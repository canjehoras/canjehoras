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
		<h1><fmt:message key="titulo.recordar.pass"/></h1>
		<form action="/canjehoras/login/login.html" method="post" accept-charset="UTF-8">
			<div class="subtituloSelect" style="margin-bottom: 5px;"><fmt:message key="subtitulo.recordar.pass"/></div>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="login.usuario"/>" autocomplete="off" name="email" />
					</div>
				</div>
			</div>
			<input type="button" value="<fmt:message key="boton.volver"/>" onclick="javascript:history.back();"/>
			<input type="submit" value="<fmt:message key="boton.enviar"/>" onclick="recordar();"/>
		</form>
	</section>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>		