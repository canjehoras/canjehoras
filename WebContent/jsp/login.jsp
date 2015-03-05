<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">
<title>Canje Horas</title>

</head>
<body>

<%@ include file="comunes/include-cabecera.jsp" %>

	<div id="login" style="position: absolute; z-index: 100;">
	  <h1>Registro</h1>
	 	<form action="/canjehoras/login/envioRegistro.html" method="post">
		    <input type="email" name="correo_electronico" id="correo_electronico" placeholder="Email" />
		    <input type="password" name="pass" id="pass" placeholder="Password" />
		    <input type="password" name="pass2" id="pass2" placeholder="Repite Password" />
		    <input type="text" name="nombre" id="nombre" placeholder="Nombre" />
		    <input type="text" name="apellido1" id="apellido1" placeholder="Primer Apellido" />
		    <input type="text" name="apellido2" id="apellido2" placeholder="Segundo Apellido" />
		    <input type="text" name="movil" id="movil" placeholder="Movil" />
		    <input type="text" name="telefono" id="telefono" placeholder="Telefono" />
		    <input type="text" name="wassap" id="wassap" placeholder="Whatsapp" />
			<input type="submit" value="Enviar" />
		</form>
	</div>
</body>
<!-- END BODY -->
</html>