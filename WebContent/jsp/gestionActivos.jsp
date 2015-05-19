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
					<div class="col-lg-12 mrgTop">
					<c:set var="primero" value="false"/>
				</c:when>
				<c:otherwise>
				<div class="col-lg-12 borderLeft mrgTop">
				</c:otherwise>
			</c:choose>
				<div class="service_block">
					<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
					<p class="animated fadeInDown wow"><fmt:message key="listado.fecha.alta"/>${trueques.fecha_alta}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueques.categoria.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueques.provincia.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.modalidad"/>${trueques.modalidad}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.ofrezco"/>${trueques.descripcionOferta}</p>
					<c:if test="${trueques.descripcionDemanda != ''}">
						<p class="animated fadeInDown wow"><fmt:message key="listado.busco"/>${trueques.descripcionDemanda}</p>
					</c:if>
					<p class="animated fadeInDown wow"><fmt:message key="listado.publicado"/>${trueques.usuario.correo_electronico}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.denunciado"/>${trueques.denunciante.correo_electronico}</p>
					
					<input style="width: 33%" type="button" value="<fmt:message key="boton.eliminar"/>" onclick="eliminarTruequeAdmin(${trueques.id});"/>
					<input style="width: 33%" type="button" value="<fmt:message key="boton.volver.publicar"/>" onclick="publicarTruequeAdmin(${trueques.id});"/>
					<input style="width: 33%" type="button" value="<fmt:message key="boton.contactar.usuario"/>" onclick="contacto(${trueques.usuario.id});"/>
				</div>
		</div>
		
	  	<c:if test="${(count.count % 3) == 0}">
		<c:set var="primero" value="true"/>
		</div>
		</div>
		</c:if>
		</c:forEach>
	</div>
	</div>
	</div>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>