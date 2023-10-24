<!--<?php
$produseStatus = "";
if (isset($_SESSION['produse-status']))
{
    $produseStatus = $_SESSION['produse-status'];
    unset($_SESSION['produse-status']);
}
?>
<?php
try
{
    $user  = "root";
    $pass  = "oracle";
    $dbh   = new PDO('mysql:host=localhost;dbname=magazin_incaltaminte', $user, $pass);
    $stmt  = $dbh->query("describe accesorii");
    $stmt2 = $dbh->query("select * from accesorii");
    $stmt->execute();
    $data  = $stmt->fetchAll();
    $stmt2->execute();
    $data2 = $stmt2->fetchAll();
}
catch (PDOException $e)
{
   echo $e. "Could not connect to the database";
    die();
}
?>-->
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="resources/favicon.ico">
        <link rel="stylesheet" href="style.css"/>
        <title>Main Menu</title>
    </head>
    <body>
    <div class="topnav">
        <a  href="incaltaminte.php">Incaltaminte</a>
        <a  class="active" href="accesorii.php">Accesorii</a>
        <a href="#cosmetice">Cosmetice</a>
        <a href="#about">About</a>
      </div>
       
        <table>
            <thead>
                <tr>
                    <?php foreach ($data as $row) { ?>
                        <th>
                            <?= $row['Field'] ?>
                        </th>
                    <?php } ?>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($data2 as $row) { ?>
                    <tr>
                        <?php foreach ($data as $row2) { ?>
                            <td>
                                <?= $row[$row2['Field']] ?>
                            </td>
                        <?php } ?>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </body>
</html>