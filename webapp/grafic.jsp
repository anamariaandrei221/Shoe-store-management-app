<!--<?php
$user  = "root";
$pass  = "oracle";
$dbh   = new PDO('mysql:host=localhost;dbname=magazin', $user, $pass);
$stmt1 = $dbh->query("select count(categorie),categorie as numar from incaltaminte where categorie in (Select categorie from incaltaminte) GROUP BY categorie;");
$stmt1->execute();

$data1  = $stmt1->fetchAll(PDO::FETCH_NUM);



// $stmt2 = $dbh->query("select count(*) as numar from incaltaminte where categorie='Pantofi'");
// $stmt2->execute();
// $data2  = $stmt2->fetch();
// $numere2=$data2['numar'];

// $stmt3 = $dbh->query("select count(*) as numar from incaltaminte where categorie='Sport'");
// $stmt3->execute();
// $data3  = $stmt3->fetch();
// $numere3=$data3['numar'];

// $stmt4 = $dbh->query("select count(*) as numar from incaltaminte where categorie='Papuci'");
// $stmt4->execute();
// $data4  = $stmt4->fetch();
// $numere4=$data4['numar'];
 

// $stmt5 = $dbh->query("select count(*) as numar from incaltaminte where categorie='Ghete'");
// $stmt5->execute();
// $data5  = $stmt5->fetch();
// $numere5=$data5['numar'];

$dataPoints=[];
foreach ($data1 as $row)
{

    $dataPoints[]=array ( "y" => $row[0], "label" =>$row[1]);

}


?>-->
<%@ page import="Proiect_ISI.*,java.util.ArrayList" %>
<!DOCTYPE HTML>
<html>
<head>  
<link rel="stylesheet" href="style3.css">
<script>
window.onload = function () {
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: false,
	exportEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Numarul de produse per categorie"
	},
	axisY:{
		includeZero: true
	},
	data: [{
		type: "column", //change type to bar, line, area, pie, etc
		//indexLabel: "{y}", //Shows y value on all Data Points
		indexLabelFontColor: "#5A5757",
		indexLabelPlacement: "outside",   
		dataPoints:<%=App.getDatabase().grafic()%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
    
<div class="navbarul">
    <ul>
        <li><a  href="incaltaminte.jsp">Incaltaminte</a></li>
        <li><a href="update.jsp">Adaugare</a></li>
        <li><a href="istoric.jsp">Command Log</a></li>
        <li><a  class="active" href="grafic.jsp">Graphic</a></li>
        <li style="float:right"><a href="index.jsp">Log out</a></li>
    </ul> 

</div>
</div>
    <div class="filler"></div>
    <div style="display:flex; align-items:center; justify-content:center"> 
<div id="chartContainer" style="height: 370px; width: 50%;"></div>
</div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>                              