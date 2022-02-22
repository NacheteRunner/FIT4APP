<?php
 //getting the database connection
 require_once 'configPDO.php';
 

 
 //an array to display response
 $response = array();
 if($_POST['id_usuario']){
	$id = $_POST['id_usuario'];
    $query = "SELECT * FROM marcas WHERE id_usuario = '$id' ORDER BY fecha_marca DESC";
 
    $stmt = $DBcon->prepare($query);
    $stmt->execute();
    
    $num_rows = $stmt->rowCount();
    
    if ($num_rows>0){
        $response['error'] = false;
	    $response['message'] = "Retrieval Successful!";
    
 
        while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
            
            $response['Marcas'][] = $row;
        }
    }    
} else{
	  $response['error'] = true;
	  $response['message'] = "Insufficient Parameters";
}
 echo json_encode($response);
?>
