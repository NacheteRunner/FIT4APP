<?php
$servername = "localhost";
$db_username = "id18402711_trainer";
$db_password = "+p1#6p>PyWE9u!qi";
$db_name = "id18402711_fituapp";

 
 try{
  
  $DBcon = new PDO("mysql:host=$servername;dbname=$db_name",$db_username,$db_password);
  $DBcon->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  
 }catch(PDOException $ex){
  
  die($ex->getMessage());
 }
 
 ?>