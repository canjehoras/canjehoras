<!doctype html>
<%@ include file="comunes/include-taglib.jspf"%>
<html>
<head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" name="viewport"
	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
<title><fmt:message key="titulo" /></title>
</head>

<body>
	<%@ include file="comunes/include-cabecera.jsp"%>
	<div class="container">
		<div class="service_block">
			<div class="service_icon delay-03s animated wow  zoomIn" style="height: 300px;"> 
				<img src="data:image/jpg;base64,${trueque.imagen64}" style="height: 300px; border: 2px solid #4BAAD6;"/> 
			</div>
			<h3 class="animated fadeInUp wow">${trueque.titulo}</h3>
			<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueque.categoria.descripcion}</p>
			<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueque.provincia.descripcion}</p>
			<p class="animated fadeInDown wow"><fmt:message key="listado.tipo"/>${trueque.tipo}</p>
			<p class="animated fadeInDown wow"><fmt:message key="listado.modalidad"/>${trueque.modalidad}</p>
			<p class="animated fadeInDown wow">${trueque.descripcion}</p>
			
			<div id="botonesDetalle">		
				<input type="button" value="<fmt:message key="boton.canjeo"/>" onclick="opcionesCanjeoTrueque(${trueque.id});"/>
				<input type="button" value="<fmt:message key="boton.denunciar"/>" onclick="denunciarTrueque(${trueque.id});"/>
				<input type="button" value="<fmt:message key="boton.volver"/>" onclick="#"/>
			</div>



		</div>
	</div>
	<%@ include file="comunes/include-pie.jsp"%>	
</body>
</html>