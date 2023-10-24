package Proiect_ISI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "login",
        urlPatterns = "/login")
public class LoginServlet
        extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private Database bazadedate = App.getDatabase();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.print("<html>");
//        printWriter.print("<body>");
//        printWriter.print("<h1>heyheHello World HttpServlet Class Example</h1>");
//        printWriter.print("<a href=\"http://www.javaguides.net\">Java Guides</a>");
//        printWriter.print("</body>");
//        printWriter.print("</html>");
//        printWriter.close();
//        resp.sendRedirect(req.getContextPath() + "/home.jsp");
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
                   IOException
    {
        Database database = App.getDatabase();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean check = database.loginCheck(username, password);
        if (check == true)
        {
            int nivel = database.getNivel(username);
            request.setAttribute("nivelul", nivel);
            request.getSession(true).setAttribute("nivelul", nivel);
            request.setAttribute("userul", username);
            request.getSession(true).setAttribute("userul", username);
            String clasa = "";
            if (nivel == 0)
            {
                database.istoricul(username, "logare");
            }
            if (nivel == 1)
            {
                clasa = "invisible";
            }
            request.setAttribute("clasa", clasa);
            request.getRequestDispatcher("incaltaminte.jsp").forward(request, response);
        }
        if (check == false)
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp?error=Wrong credentials!");
        }
    }
}
