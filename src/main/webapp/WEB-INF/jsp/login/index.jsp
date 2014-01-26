<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<link rel="stylesheet" type="text/css" href="ext/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="ext/bootstrap/css/bootstrap-responsive.css" />
		<script type="text/javascript" src="ext/bootstrap/js/bootstrap.js"></script>   
		<title>LightCMS - Página de Login</title>
	</head>
	<body>
	    <div class="form-login">
            <div class="header">
	           <img src="images/login/espiao.png" align="left" />
	           <div class="mensagem"> 
	               Hey rapaz, <br /> identifique-se!!!
	           </div>
            </div>
	    
			<form action="login/validar" method="post">
			
			    <div>
	                <input placeholder="Seu usuario aqui!" type="text" name="usuario" id="usuario" class="form-control" />
	            </div>
	            
	            <div> 
	                <input placeholder="Sua senha aqui!"   type="password" name="senha" id="senha" class="form-control" />
	            </div>
	             
				<input value="validar" type="submit" id="validar" class="btn btn-primary" />
	        </form>
	    </div>
    </body>
</html>