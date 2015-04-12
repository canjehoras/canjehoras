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
			<div class="service_icon delay-03s animated wow  zoomIn"> 
				<img src="data:image/jpg;base64,${trueques.imagen64}" style="max-height: 190px; border: 2px solid #4BAAD6;"/> 
			</div>
			<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
			<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueques.categoria.descripcion}</p>
			<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueques.provincia.descripcion}</p>
			<p class="animated fadeInDown wow"><fmt:message key="listado.tipo"/>${trueques.tipo}</p>
			<p class="animated fadeInDown wow">${trueques.descripcion}</p>
					
			<input type="button" value="<fmt:message key="boton.contacte"/>" onclick="contacteUsuarioTrueque(${trueques.id});"/>
			<input type="button" value="<fmt:message key="boton.agenda"/>" onclick="agendaTrueque(${trueques.id});"/>
			<input type="button" value="<fmt:message key="boton.denunciar"/>" onclick="denunciarTrueque(${trueques.id});"/>



			<h3 class="animated fadeInUp wow">
				<fmt:message key="contacte" />
			</h3>
			<p class="animated fadeInDown wow">${trueque.usuario.nombre}
				${trueque.usuario.apellido1} ${trueque.usuario.apellido2}</p>
			<p class="animated fadeInDown wow">${trueque.usuario.correo_electronico}</p>
			<p class="animated fadeInDown wow">${trueque.usuario.movil}</p>

		</div>
	</div>
	<%@ include file="comunes/include-pie.jsp"%>	
</body>
</html>