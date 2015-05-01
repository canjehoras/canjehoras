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
						<img src="data:image/jpg;base64,${trueques.imagen64}" style="max-height: 190px; border: 2px solid #4BAAD6;"/> 
					</div>
					<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
					<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueques.categoria.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueques.provincia.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.tipo"/>${trueques.tipo}</p>
					<p class="animated fadeInDown wow">${trueques.descripcion}</p>
					<c:if test="${sessionScope.usuario == null}">
						<p>
							<fmt:message key="listado.usuario.registro"/>&nbsp; 
							<a href="/canjehoras/login/registro.html" id="register-btn" ><fmt:message key="listado.usuario.registro.aqui"/></a>
						</p>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<c:if test="${trueques.estado == 'B'}">
							<input type="button" value="<fmt:message key="boton.reactivar"/>" onclick="reactivarTrueque(${trueques.id});"/>
						</c:if>
						<c:if test="${trueques.estado == 'N'}">
							<input type="button" value="<fmt:message key="boton.editar"/>" onclick="editarTrueque(${trueques.id});"/>
							<input type="button" value="<fmt:message key="boton.borrar"/>" onclick="borrarTrueque(${trueques.id});"/>
						</c:if>
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
	</div>
	</div>
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>