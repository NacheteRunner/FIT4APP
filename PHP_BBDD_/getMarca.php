<?php
 //getting the database connection
 require_once 'configuration.php';
 
 //an array to display response
 $response = array();
 if($_POST['id_usuario']){
	 $id = $_POST['id_usuario'];
	 $stmt = $conn->prepare("SELECT * FROM marcas WHERE id_usuario = ? ORDER BY fecha_marca DESC");
	 $stmt->bind_param("s",$id);
	 
	 $result = $stmt->execute();
	 if($result == TRUE){
		 $response['error'] = false;
		 $response['message'] = "Retrieval Successful!";
		 $stmt->store_result();
		 $stmt->bind_result($id_marca,$id_usuario,$fecha_marca,$carrera,$distancia,$marca,$mejor_marca);
		 $stmt->fetch();
		 $response['id_marca'] = $id_marca;
		 $response['id_usuario'] = $id;
		 $response['fecha_marca'] = $fecha_marca;
		 $response['carrera'] = $carrera;
		 $response['distancia'] = $distancia;
		 $response['marca'] = $marca;
		 $response['mejor_marca'] = $mejor_marca;
		
	 } else{
		 $response['error'] = true;
		 $response['message'] = "Incorrect id";
	 }
 } else{
	  $response['error'] = true;
	  $response['message'] = "Insufficient Parameters";
 }
 echo json_encode($response);
?>