package Proiect_ISI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "adaugare",
        urlPatterns = "/adaugare")
public class AddServlet
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
        String categorie = request.getParameter("categorieA");
        String marca = request.getParameter("marcaA");
        String model = request.getParameter("modelA");
        String culoare = request.getParameter("culoareA");
        String tesatura = request.getParameter("tesaturaA");
        int marime = Integer.parseInt(request.getParameter("marimeA"));
        String sezon = request.getParameter("sezonA");
        int inaltimeTotala = Integer.parseInt(request.getParameter("inaltimeTotalaA"));
        int greutate = Integer.parseInt(request.getParameter("greutateA"));
        int pret = Integer.parseInt(request.getParameter("pretA"));
        int cantitate = Integer.parseInt(request.getParameter("cantitateA"));
        database.adaugaIncaltaminte(categorie, marca, model, culoare, tesatura, marime, sezon, inaltimeTotala, greutate, pret, cantitate);
        database.istoricul((String) request.getSession(true).getAttribute("userul"), "adaugare produs categoria=" + categorie);
        database.afisareIncaltaminte();
        response.sendRedirect("/incaltaminte.jsp");
    }
}
