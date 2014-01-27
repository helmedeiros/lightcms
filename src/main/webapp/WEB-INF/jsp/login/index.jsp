<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css" />"  />
		<link rel="stylesheet" type="text/css" href="<c:url value="/ext/bootstrap/css/bootstrap.css" />" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/ext/bootstrap/css/bootstrap-responsive.css" />" />
		<script type="text/javascript" src="<c:url value="ext/bootstrap/js/bootstrap.js" />"></script>   
		<title>LightCMS - Página de Login</title>
	</head>
	<body>
	    <div class="form-login">
            <div class="header">
	           <img src="<c:url value="/images/login/espiao.png" />" align="left" />
	           <div class="mensagem"> 
	               Hey rapaz, <br /> identifique-se!!!
	           </div>
            </div>
	    
			<form action="<c:url value="/login/validar" />" method="post">
			
				<c:if test="${not empty mensagem}">
				    <div id="mensagem-de-erro">${mensagem}</div>
				</c:if>
			
			    <div>
	                <input id="usuario" type="text" name="login.usuario" 
	                       class="form-control" placeholder="Seu usuario aqui!" />
	            </div>
	            
	            <div> 
	                <input id="senha" type="password" name="login.senha" 
	                       class="form-control" placeholder="Sua senha aqui!" />
	            </div>
	             
				<input id="validar" value="validar" type="submit" class="btn btn-primary" />
	        </form>
	    </div>
    </body>
</html>