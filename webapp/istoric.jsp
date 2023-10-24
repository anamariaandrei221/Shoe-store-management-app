
<%@ page import="Proiect_ISI.*,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="style3.css"/>
        <link rel="icon" type="image/x-icon" href="resources/favicon.ico">
        <title>Main Menu</title>
    </head>
 <body>


    <ul>
        <li><a  href="incaltaminte.jsp">Incaltaminte</a></li>
        <li><a href="update.jsp">Adaugare</a></li>
        <li><a href="istoric.jsp" class="active">Command Log</a></li>
        <li><a href="grafic.jsp">Graphic</a></li>
        <li style="float:right"><a href="index.jsp">Log out</a></li>
    </ul> 
    </div>
    <div class="filler"></div>

 

    
 <div class="istoricdiv">

        <table >
            <thead>
                <% ArrayList<ArrayList<Object>> istoric = new ArrayList<>();
                        Database database = App.getDatabase();
                        istoric=database.afisareIstoric();
                         Database database1 = App.getDatabase();
                       %>
               <tr>  <%  for (String coloana : database1.coloane1)
            { %>
                     <th> <%out.print(coloana);%></th> <% } %>
               </tr>
            </thead>
            <tbody>
                 <%  
                   
                        for (ArrayList<Object> istoric1 : istoric)
                {
            
                    
                        %>
                <tr>  <%  for (Object istoric2 : istoric1)
            { %>
                    <td>
                        <%out.print(istoric2);%>

                    </td> <% } %>
                </tr>
                <% } %>
            </tbody>
        </table>
   
                      
 </div>
    </body>
</html>



