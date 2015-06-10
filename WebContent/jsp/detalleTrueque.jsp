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
	<div class="container" >
		<div class="service_block" style="margin: 10px;">
		
			<div class="service_icon delay-03s animated wow  zoomIn textoTrueque" style="height: 190px;"> 
				<c:choose>
					<c:when test="${trueques.imagen64==''}">
						<img src="/canjehoras/img/sinfoto.jpg" style="max-height: 190px; border: 3px solid #4BAAD6;" />		
					</c:when>
					<c:otherwise>
						<img src="data:image/jpg;base64,${trueque.imagen64}" style="width:60%; max-height: 190px; border: 2px solid #4BAAD6;"/> 
					</c:otherwise>
				</c:choose>
			</div>
			
			
			<div class="textoTrueque">
				<h3 class="animated fadeInUp wow">${trueque.titulo}</h3>
				<p class="animated fadeInDown wow"><fmt:message key="fecha.alta"/>${trueques.fecha_alta}</p>
				<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueque.categoria.descripcion}</p>
				<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueque.provincia.descripcion}</p>
				<p class="animated fadeInDown wow"><fmt:message key="listado.modalidad"/>${trueque.modalidad}</p>
				<p class="animated fadeInDown wow">OFERTA: ${trueque.descripcionOferta}</p>
				<p class="animated fadeInDown wow">DEMANDA: ${trueque.descripcionDemanda}</p>
				
				<div id="botonesDetalle">
					<img title="<fmt:message key="boton.canjeo"/>" class="imagenOpcionesCanjeo" src="/canjehoras/img/manos2.png" onclick="opcionesCanjeoTrueque(${trueque.id});" />		
					<img title="<fmt:message key="boton.volver"/>" class="imagenOpcionesCanjeo" src="/canjehoras/img/volver.png" onclick="javascript:history.back();" />		
				<%-- 	<input type="button" value="<fmt:message key="boton.canjeo"/>" onclick="opcionesCanjeoTrueque(${trueque.id});"/>
					<input type="button" value="<fmt:message key="boton.volver"/>" onclick="javascript:history.back();"/>		 --%>	
				</div>
			</div>
			
		</div>
	</div>
	
	<%@ include file="comunes/include-pie.jsp"%>	
</body>
</html>