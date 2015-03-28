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
			<c:set var="primero" value="true"></c:set>
			<c:forEach var="trueques" items="${trueques}" varStatus="count" >
			<c:choose>
				<c:when test="${primero}">
				<div class="service_wrapper">
				<div class="row borderTop">
					<div class="col-lg-4 mrgTop">
					<c:set var="primero" value="false"/>
				</c:when>
				<c:otherwise>
				<div class="col-lg-4 borderLeft mrgTop">
				</c:otherwise>
			</c:choose>
				<div class="service_block">
					<div class="service_icon delay-03s animated wow  zoomIn"> 
						<span><i class="fa fa-dropbox"></i></span> 
					</div>
					<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
					<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>&nbps;${trueques.categoria.descripcion}</p>
					<!-- <p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>&nbps;${trueques.usuario.provincia.descripcion}</p> -->
					<p class="animated fadeInDown wow"><fmt:message key="listado.tipo"/>&nbps;${trueques.tipo}</p>
					<p class="animated fadeInDown wow">${trueques.descripcion}</p>
					<c:if test="${sessionScope.usuario == null}">
						<input type="button" value="<fmt:message key="boton.ver.mas"/>" onclick="detalleTrueque(${trueques.id});"/>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<input type="button" value="<fmt:message key="boton.editar"/>" onclick="editarTrueque(${trueques.id});"/>
						<input type="button" value="<fmt:message key="boton.borrar"/>" onclick="borrarTrueque(${trueques.id});"/>
					</c:if>
				</div>
		</div>
		
	  	<c:if test="${(count.count % 3) == 0}">
		<c:set var="primero" value="true"/>
		</div>
		</div>
		</c:if>
		</c:forEach>
	</div>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>