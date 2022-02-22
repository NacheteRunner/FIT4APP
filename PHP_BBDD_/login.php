<?php
include "configuration.php";

$response = array();
if($_POST['email'] && $_POST['password']){
	$email = $_POST['email'];
	$post_password = $_POST['password'];
	$id_usuario = '';
	$stmt = $conn->prepare("SELECT usu.Id_usuario, usu.username, pwd.password FROM usuarios usu LEFT JOIN passwords pwd ON usu.Id_usuario=pwd.Id_usuario WHERE usu.email=?");
	$stmt->bind_param("s",$email);
	$stmt->execute();
	$stmt->bind_result($id_usuario, $username, $password);
	$stmt->fetch();
	
	if($post_password==$password){
		$response['error'] = false;
		$response['message'] = "Login Successful!";
		$response['id_usuario'] = $id_usuario;
		$response['email'] = $email;
		$response['username'] = $username;
		
	} else{
		$response['error'] = false;
		$response['message'] = "Invalid Email or Password";
	}
} else {
	$response['error'] = true;
	$response['message'] = "Insufficient Parameters";
}
echo json_encode($response);	
?>