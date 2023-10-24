package Proiect_ISI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "update",
        urlPatterns = "/update")
public class UpdateServlet
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
        int codProdus = Integer.parseInt(request.getParameter("produs"));
        String categorie = request.getParameter("categorie");
        String marca = request.getParameter("marca");
        String model = request.getParameter("model");
        String culoare = request.getParameter("culoare");
        String tesatura = request.getParameter("tesatura");
        int marime = Integer.parseInt(request.getParameter("marime"));
        String sezon = request.getParameter("sezon");
        int inaltimeTotala = Integer.parseInt(request.getParameter("inaltimeTotala"));
        int greutate = Integer.parseInt(request.getParameter("greutate"));
        int pret = Integer.parseInt(request.getParameter("pret"));
        int cantitate = Integer.parseInt(request.getParameter("cantitate"));
        database.modificaIncaltaminte(codProdus, categorie, marca, model, culoare, tesatura, marime, sezon, inaltimeTotala, greutate, pret, cantitate);
        database.istoricul((String) request.getSession(true).getAttribute("userul"), "update produs cu codul=" + codProdus);
        database.afisareIncaltaminte();
        response.sendRedirect("/incaltaminte.jsp");
    }
}
