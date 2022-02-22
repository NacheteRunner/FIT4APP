<?php
 //getting the database connection
 require_once 'configuration.php';
 
 //an array to display response
 $response = array();
 if($_POST['id_usuario']){
	 $id = $_POST['id_usuario'];
	 $stmt = $conn->prepare("SELECT * FROM usuarios WHERE id_usuario = ?");
	 $stmt->bind_param("s",$id);
	 $result = $stmt->execute();
	 if($result == TRUE){
		 $response['error'] = false;
		 $response['message'] = "Retrieval Successful!";
		 $stmt->store_result();
		 $stmt->bind_result($id,$nombre,$username,$telefono,$email,$edad,$foto,$entrenamiento,$dieta,$activo);
		 $stmt->fetch();
		 $response['id_usuario'] = $id;
		 $response['nombre'] = $nombre;
		 $response['username'] = $username;
		 $response['telefono'] = $telefono;
		 $response['email'] = $email;
		 $response['edad'] = $edad;
		 $response['foto'] = $foto;
		 $response['entrenamiento'] = $entrenamiento;
		 $response['dieta'] = $dieta;
		 $response['activo'] = $activo;
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