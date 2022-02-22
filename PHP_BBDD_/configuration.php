<?php
$servername = "localhost";
$db_username = "id18402711_trainer";
$db_password = "+p1#6p>PyWE9u!qi";
$db_name = "id18402711_fituapp";

// Create connection
$conn = new mysqli($servername, $db_username, $db_password, $db_name);
$conn->set_charset("utf8");
   if ($conn->connect_errno) {
      echo 'Error al conectar base de datos: ', $conn->connect_error;
      exit();
   }
?>