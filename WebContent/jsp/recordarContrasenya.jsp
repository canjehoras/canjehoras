<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport" content="text/html; charset=UTF-8; width=device-width, maximum-scale=1"> 
		<title><fmt:message key="titulo"/></title>
	</head>
	
	<body>
	<div id="categoria" class="content">
	<%@ include file="comunes/include-cabecera.jsp" %>
	<section id="login" class="top_cont_outer">
		<h1><fmt:message key="titulo.recordar.pass"/></h1>
			<form>
				<div class="subtituloSelect" style="margin-bottom: 5px;"><fmt:message key="subtitulo.recordar.pass"/></div>
				<div class="control-group">
					<div class="controls">
						<div class="input-icon left">
							<i class="icon-envelope"></i>
							<input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="registro.usuario"/>" required/>
						</div>
					</div>
				</div>
				<input type="button" value="<fmt:message key="boton.enviar"/>" onclick="recordarContrasenya();"/>
				<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>
			</form>
	</section>
	</div>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>		