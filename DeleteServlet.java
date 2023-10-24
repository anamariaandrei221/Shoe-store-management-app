package Proiect_ISI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete",
        urlPatterns = "/delete")
public class DeleteServlet
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
        try
        {
            int coda = Integer.parseInt(request.getParameter("stergere"));
            database.eliminaIncaltaminte(coda);
            database.afisareIncaltaminte();
            database.istoricul((String) request.getSession(true).getAttribute("userul"), "stergere produs cu codul=" + coda);
            response.sendRedirect(request.getContextPath() + "/incaltaminte.jsp");
        }
        catch (NumberFormatException e)
        {
            response.sendRedirect(request.getContextPath() + "/incaltaminte.jsp?error2=Introduceti un numar!");
        }
    }
}
