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
		<div class="container">
				<div class="service_block">
					<div class="service_icon delay-03s animated wow  zoomIn"> 
						<span><i class="fa fa-dropbox"></i></span> 
					</div>
					<h3 class="animated fadeInUp wow">${trueque.titulo}</h3>
					<p class="animated fadeInDown wow">${trueque.fecha_alta}</p>
					<p class="animated fadeInDown wow">${trueque.tipo}</p>
					
					<p class="animated fadeInDown wow">${trueque.categoria.descripcion}</p>
					<p class="animated fadeInDown wow">${trueque.descripcion}</p>
					
					<h3 class="animated fadeInUp wow"><fmt:message key="contacte"/></h3>
					<p class="animated fadeInDown wow">${trueque.usuario.nombre} ${trueque.usuario.apellido1} ${trueque.usuario.apellido2}</p>
					<p class="animated fadeInDown wow">${trueque.usuario.correo_electronico}</p>
					<p class="animated fadeInDown wow">${trueque.usuario.movil}</p>
					
				</div>
		</div>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>