<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">
<title><fmt:message key="titulo"/></title>
</head>
<body>

<%@ include file="comunes/include-cabecera.jsp" %>

<section id="login" class="top_cont_outer">
	<h1><fmt:message key="registrar"/></h1>
 	<form action="/canjehoras/login/envioRegistro.html" method="post">
	    <input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="registro.usuario"/>" />
	    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="registro.pass"/>" />
	    <input type="password" name="pass2" id="pass2" placeholder="<fmt:message key="registro.repass"/>" />
	    <input type="text" name="nombre" id="nombre" placeholder="<fmt:message key="registro.nombre"/>" />
	    <input type="text" name="apellido1" id="apellido1" placeholder="<fmt:message key="registro.apellido1"/>" />
	    <input type="text" name="apellido2" id="apellido2" placeholder="<fmt:message key="registro.apellido2"/>" />
	    <input type="text" name="movil" id="movil" placeholder="<fmt:message key="registro.movil"/>" />
	    <input type="text" name="telefono" id="telefono" placeholder="<fmt:message key="registro.telefono"/>" />
	    <input type="text" name="wassap" id="wassap" placeholder="<fmt:message key="registro.wassap"/>" />
		<input type="submit" value="<fmt:message key="boton.enviar"/>" />
	</form>
</section>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>