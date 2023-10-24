

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


        <div class="navbarul">
             
            <ul>
                <li><a class="active" href="incaltaminte.php">Incaltaminte</a></li>
                 <% if(session.getAttribute("nivelul").equals(0))
                    {
                    
%>
                <li><a href="update.jsp" class="<% out.print(request.getAttribute("clasa")); %>">Adaugare</a></li>
                <li><a href="istoric.jsp" class="<% out.print(request.getAttribute("clasa")); %>" >Command Log</a></li>
                <li><a href="grafic.jsp" class="<% out.print(request.getAttribute("clasa")); %>" >Graphic</a></li> 
                
                <% } %>
                <li style="float:right"><a href="index.jsp">Log out</a></li>
            </ul> 
                
               
        </div>
        <div class="filler"></div>

        <div class="containerul">
            <div class="formuri">
                <div class="cautareafisare">
                    <form method="get" action="cautare"> 
                        <input type="text" name="inputCautare">
                        <button type="submit" name="cautare"class="butoanele"  >Cautare</button>
                    </form>
                    <form action="incaltaminte.jsp">
                        <button type="submit" class="butoanele"  >Afisare produse</button>
                    </form>
                </div>
                <fieldset style="display:flex">
                    <legend>Filtrare</legend>
                    <form method="get" action="filtrare" > 
                     
                        <label for="inputFiltrare1"> Pret >=</label>
                        <input type="text" name="inputFiltrare1" style="margin-right:20px; margin-bottom:10px">
                        <h5 style="color:red"> <%  if(request.getParameter("error1") == null )
                                out.print("");
                            else
                                out.print(request.getParameter("error1")); %>
</h5>
                        <br>
                        <label for="inputFiltrare2"> Marca = </label>
                        <input type="text" name="inputFiltrare2" style="margin-right:20px">
                        <button type="submit" name="filtrare" class="butoanele"  >Filtrare</button>
                    </form>
                </fieldset>
                 <fieldset style="display:flex">
                    <legend>Ordonare dupa pret</legend>
                    <form method="get" action="ordonare"> 
                        <button type="submit" name="crescator" class="butoanele" value="confirm" >Crescatoare</button>
                    </form>
                    <form method="get" action="ordonare"> 
                        <button type="submit" name="descrescator" class="butoanele"  >Descrescatoare</button>
                    </form>
                    <% if(session.getAttribute("nivelul").equals(0))
                    {
                    
%>
                </fieldset>
                <fieldset class=" <% out.print(request.getAttribute("clasa")); %>" >
                    <legend>Update</legend>
                    
                    
                    <form method="POST" action="update.jsp" style="display:flex">
                        <label for="modificare"> Cod produs:</label>
                        <input type="text" name="modificare" > 
                       
                        <button class="actiuni" name="update" type="submit" value="confirm"  ><img class="imagine" src="refresh.png"></button>
                        
                    </form> 
                    
                

                </fieldset>
                <fieldset class="<% out.print(request.getAttribute("clasa")); %>">
                    <legend>Stergere</legend>
                    <form method="POST" action="delete"  style="display:flex" > 
                        <label for="stergere"> Cod produs:</label>
                        <input type="text" name="stergere" id="stergere" name="stergere"> 
                      
                        <button class="actiuni" name="delete" ><img class="imagine  "src="delete.png"></button>
                        

                    </form>
                      <h5 style="color:red"> <%  if(request.getParameter("error2") == null )
                                out.print("");
                            else
                                out.print(request.getParameter("error2")); %>
</h5>
                </fieldset>
                <form method="POST" action="export">
                    <input type="submit" name="exportxls" value="Export XLS" class="butoanele <% out.print(request.getAttribute("clasa")); %>">
                </form>   <% } %>
            </div>


            <div class="container3">
                <table >
                    <thead>

                        <% ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
                        Database database = App.getDatabase();
                        incaltaminte=database.afisareIncaltaminte();
                       
               
                        if(request.getAttribute("filtrarea") != null)
                        {
                           
                           incaltaminte= (ArrayList<ArrayList<Object>>) request.getAttribute("filtrarea");
                        }
                        else if (request.getAttribute("cautarea") != null)
                        {
                         incaltaminte= (ArrayList<ArrayList<Object>>) request.getAttribute("cautarea");
                        }
                        else if(request.getAttribute("ordonarea") != null)
                        {
                        incaltaminte= (ArrayList<ArrayList<Object>>) request.getAttribute("ordonarea");
                        }
                        else
                        { 
                            
                         incaltaminte=database.afisareIncaltaminte();
                        }
                        
                        
                         
                        Database database1 = App.getDatabase();
                   
                        %><tr>

                            <%  for (String coloana : database1.coloane)
            { %>
                            <th>
                                <%out.print(coloana);%>
                               



                            </th><% } %>
                        </tr>

                    </thead>
                    <tbody>

                        <%  
                   
                        for (ArrayList<Object> incaltaminte1 : incaltaminte)
                {
            
                    
                        %><tr>

                            <%  for (Object incaltaminte2 : incaltaminte1)
            { %>
                            <td>
                                <%out.print(incaltaminte2);%>

                            </td><% } %>


                        </tr>
                        <% } %>

                        </td>


                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>



