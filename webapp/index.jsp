<!--<?php
session_start();
if(isset($_SESSION['username']))
{
    unset($_SESSION['username']);
}

?>-->
<%@ page import="Proiect_ISI.*" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CCC | LOGIN</title>
        <link rel="stylesheet" href="style3.css">
    </head>
    <body>
        
        <div class="titlu">
            <h1>CCC</h1>
            <img  class="shoe" src="high-heels.png">
            <h1>SHOES</h1>
        </div>

        <div class="container"> 
            <div class="login_card">

                <form form method="POST" action="login">
                    <div class="usernameLabel">
                        <label for="username">Username:</label>
                        <input type="username" id="username" name="username" ><br>
                    </div>
                    <div class="passwordLabel">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" >
                    </div> <br>
                    <button type="submit" class="buton" name="lgn">Login</button>    






                    <!--        <?php
                    
                        
                      
                    
                        if(isset($_POST['lgn']))
                          {
                        
                        
                        $user  = "root";
                        $pass  = "oracle";
                        $dbh   = new PDO('mysql:host=localhost;dbname=magazin', $user, $pass);
                             
                             $username = $_POST['username'];
                             $password = $_POST['password'];
                             $query = "SELECT * FROM user WHERE username='$username' AND password='$password'";
                            
                             $stmt = $dbh -> prepare($query);
                             $stmt -> execute();
                             $row = $stmt -> fetchAll();
                             foreach ($row as $variabila)
                             {
                                    foreach ($variabila as $banana)
                                    {
                                        echo ($banana."<br>");
                                    }
                             }
                             
                             
                             
                             if(count($row)!=0 && $row["0"]["nivelAcces"]==0)
                             {$_SESSION['username']=$username;
                                 $_SESSION['nivel']=$row["0"]["nivelAcces"];
                                header('Location:incaltaminte.php');
                                
                             }
                             elseif(count($row) !=0 && $row["0"]["nivelAcces"]==1)
                               {$_SESSION['username']=$username;
                                   $_SESSION['nivel']=$row["0"]["nivelAcces"];
                                   header('Location:incaltaminte.php');
                                } 
                              
                             else
                                ?>-->



                    <h5> 

                        <%  if(request.getParameter("error") == null )
                                out.print("");
                            else
                                out.print(request.getParameter("error")); %>

                            
                    </h5>


                </form>
                <!-- <?php } ?>-->




            </div>







            <div class="register_card">
                <form method="POST" action="register">
                    <div class="numeLabel">
                        <label for="nume" class="numeLabel" >Name:</label>
                        <input type="text" id="nume" name="nume" ><br>
                    </div>
                    <div class="usernameLabelRegister">
                        <label for="usernameRegister">Username:</label>
                        <input type="text" id="usernameRegister" name="usernameRegister" ><br>
                    </div>
                    <div class="passwordLabelRegister">
                        <label for="passwordRegister">Password:</label>
                        <input type="password" id="passwordRegister" name="passwordRegister" >
                    </div> <br>
                    <button type="submit" class="buton" name="register">Register</button>        
                    <div>

                </form>
            </div>
        </div>

        <!--<?php
        
        if(isset($_POST['register']))
        {   
            try{  $user  = "root";
            $pass  = "oracle";
            $dbh   = new PDO('mysql:host=localhost;dbname=magazin', $user, $pass);
                 $nume=$_POST["nume"];
                 $username1 = $_POST['usernameRegister'];
                 $password1 = $_POST['passwordRegister'];
                $query = "INSERT INTO user values (NULL,'$nume','$username1','$password1', 0)";
                $stmt = $dbh -> prepare($query);
                 
                 $stmt -> execute();
                
        
            }
            catch(PDOException $e)
            {
                echo $e. "Could not connect to the database";
            die();
            }
          
                 
        }
        
        
         ?>
        
        -->


    </body>
</html>