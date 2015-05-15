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
		OK
			<input type="button" value="<fmt:message key="boton.volver"/>" onclick="javascript:history.back();"/>
	</section>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>		