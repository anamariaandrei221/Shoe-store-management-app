package Proiect_ISI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "filtrare",
        urlPatterns = "/filtrare")
public class FiltrareServlet
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
                   IOException
    {
        Database database = App.getDatabase();
        try
        {
            int pret1 = Integer.parseInt(request.getParameter("inputFiltrare1"));
            String marca2 = request.getParameter("inputFiltrare2");
            request.setAttribute("filtrarea", database.afisareFiltrare(pret1, marca2));
            request.getRequestDispatcher("incaltaminte.jsp").forward(request, response);
        }
        catch (NumberFormatException e)
        {
            response.sendRedirect(request.getContextPath() + "/incaltaminte.jsp?error1=Introduceti un numar!");
        }
    }
}
