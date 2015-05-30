<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport" content="text/html; charset=UTF-8; width=device-width, maximum-scale=1"> 
		<title><fmt:message key="titulo"/></title>
	</head>
	
	<body>
	<%@ include file="comunes/include-cabecera.jsp" %>
	<section id="login" class="top_cont_outer">
		<h1><fmt:message key="login"/></h1>
		<form action="/canjehoras/login/login.html" method="post" accept-charset="UTF-8">
			<input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="login.usuario"/>" />
		    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="login.pass"/>" />
		    
		    <div class="forget-password">
				<p><a href="/canjehoras/login/recordarContrasenya.html" id="forget-password"><fmt:message key="login.olvidar.pass"/></a></p>
			</div>
			
			<input type="submit" value="<fmt:message key="boton.iniciar.sesion"/>" />
            <input type="button" value="<fmt:message key="boton.registrar"/>" onclick="registro();"/>			
		</form>
	</section>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>