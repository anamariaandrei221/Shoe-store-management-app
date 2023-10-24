
<%@ page import="Proiect_ISI.*,java.util.ArrayList,java.sql.ResultSet,java.util.HashMap" %>
<% 
HashMap<String, Object> incaltaminte = new HashMap<>();
                        Database database = App.getDatabase();
                        String x1 = request.getParameter("update");
                        
                        
                if(x1!=null && x1.equals("confirm"))
                {
                        incaltaminte=database.afisarePereche(request.getParameter("modificare"));}
                        else
                        {
                        incaltaminte=null;
}
                      
%>



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
            <li><a href="incaltaminte.jsp">Incaltaminte</a></li>
            <li><a class="active" href="update.jsp">Adaugare</a></li>
            <li><a href="istoric.jsp">Command Log</a></li>
            <li><a href="grafic.jsp">Graphic</a></li>

        </ul> 
    </div>
    <div class="filler"></div>
    <% String x = request.getParameter("update");
                if(x!=null && x.equals("confirm")) {
    %>
    <div style="display:flex; align-items:center; justify-content:center">
        <form  class="updateform" method="POST" action="update">


            <p class="pupdate">

            <div style="display:table">
                <label class="updateLabel"  > Cod produs:  </label>
                <input  readonly class="updateinput" type="text" style="margin-top:10px;margin-left:10px" name="produs" value="<%=request.getParameter("modificare")%>">    
            </div>

            <div style="display:table">
                <label class="updateLabel"  > Categorie:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="categorie" value="<%=incaltaminte.get("categorie")%>" >     
            </div>  

            <div style="display:table">
                <label class="updateLabel"  > Marca:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="marca" value="<%=incaltaminte.get("marca")%>">     
            </div>   
            <div style="display:table">
                <label class="updateLabel"  > Model:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="model" value="<%=incaltaminte.get("model")%>">     
            </div>   

            <div style="display:table">
                <label class="updateLabel"  > Culoare:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="culoare" value="<%=incaltaminte.get("culoare")%>">     
            </div>  
            <div style="display:table">
                <label class="updateLabel"  > Tesatura:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="tesatura" value="<%=incaltaminte.get("tesatura")%>">     
            </div>  
            <div style="display:table">
                <label class="updateLabel"  > Marime:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="marime" value="<%=incaltaminte.get("marime")%>">     
            </div>   
            <div style="display:table">
                <label class="updateLabel"  > Sezon:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="sezon" value="<%=incaltaminte.get("sezon")%>">     
            </div> 

            <div style="display:table">
                <label class="updateLabel"  > Inaltime totala:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="inaltimeTotala" value="<%=incaltaminte.get("inaltimeTotala")%>"> 
            </div>
            <div style="display:table">
                <label class="updateLabel"  > Greutate:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="greutate" value="<%=incaltaminte.get("greutate")%>">   
            </div>   
            <div style="display:table">
                <label class="updateLabel"  > Pret:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="pret" value="<%=incaltaminte.get("pret")%>">     
            </div>    
            <div style="display:table">
                <label class="updateLabel"  > Cantitate:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="cantitate" value="<%=incaltaminte.get("cantitate")%>">     
            </div>   

            </p>

            <button type="submit" class="updatebutton" name="updatebutton" style=" margin-top:40px; font-size:20px; ">Update</button>



        </form>
    </div>

    <% } else { %>



    <div  style="display:flex; align-items:center; justify-content:center" >
        <form method="POST" action="adaugare" class="updateform ">
            <p class="pupdate">



            <div style="display:table">
                <label class="updateLabel"  > Categorie:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="categorieA" >     
            </div>  

            <div style="display:table">
                <label class="updateLabel"  > Marca:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="marcaA">     
            </div>   
            <div style="display:table">
                <label class="updateLabel"  > Model:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="modelA">     
            </div>   

            <div style="display:table">
                <label class="updateLabel"  > Culoare:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="culoareA">     
            </div>  
            <div style="display:table">
                <label class="updateLabel"  > Tesatura:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="tesaturaA">     
            </div>  
            <div style="display:table">
                <label class="updateLabel"  > Marime:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="marimeA">     
            </div>   
            <div style="display:table">
                <label class="updateLabel"  > Sezon:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="sezonA">     
            </div> 

            <div style="display:table">
                <label class="updateLabel"  > Inaltime totala:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="inaltimeTotalaA"> 
            </div>
            <div style="display:table">
                <label class="updateLabel"  > Greutate:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="greutateA">   
            </div>   
            <div style="display:table">
                <label class="updateLabel"  > Pret:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="pretA">     
            </div>    
            <div style="display:table">
                <label class="updateLabel"  > Cantitate:  </label>
                <input class="updateinput"type="text" style="margin-top:10px;margin-left:10px" name="cantitateA">     
            </div>   

            </p>


            <button type="submit" class="updatebutton" name="adaugare" style=" margin-top:40px; font-size:20px">Adaugare</button>


        </form>
    </div>


    <% } %>




</body>
</html>