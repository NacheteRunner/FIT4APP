<?php
 //getting the database connection
 require_once 'configPDO.php';
 

 
 //an array to display response
 $response = array();
 
    $query = "SELECT * FROM usuarios ORDER BY username";
 
    $stmt = $DBcon->prepare($query);
    $stmt->execute();
    
    $num_rows = $stmt->rowCount();
    
    if ($num_rows>0){
        $response['error'] = false;
	    $response['message'] = "Retrieval Successful!";
    
 
        while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
            
            $response['Usuarios'][] = $row;
        }
    }    


 echo json_encode($response);
?>
