<?php
 //getting the database connection
 require_once 'configuration.php';
 
 //an array to display response
 $response = array();
 if($_POST['id_usuario']){
	 $id = $_POST['id_usuario'];
	 $stmt = $conn->prepare("SELECT * FROM entrenamientos WHERE id_usuario = ? AND fecha< NOW() LIMIT 1");
	 $stmt->bind_param("s",$id);
	 
	 $result = $stmt->execute();
	 if($result == TRUE){
		 $response['error'] = false;
		 $response['message'] = "Retrieval Successful!";
		 $stmt->store_result();
		 $stmt->bind_result($id_entrenamiento,$id_usuario,$semana,$fecha,$lunes,$martes,$miercoles,$jueves,$viernes,$sabado,$domingo,$mensual);
		 $stmt->fetch();
		 $response['id_entrenamiento'] = $id_entrenamiento;
		 $response['id_usuario'] = $id;
		 $response['semana'] = $semana;
		 $response['fecha'] = $fecha;
		 $response['lunes'] = $lunes;
		 $response['martes'] = $martes;
		 $response['miercoles'] = $miercoles;
		 $response['jueves'] = $jueves;
		 $response['viernes'] = $viernes;
		 $response['sabado'] = $sabado;
		 $response['domingo'] = $domingo;
		 $response['mensual'] = $mensual;
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