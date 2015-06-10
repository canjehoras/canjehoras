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
			<section id="categoria" class="content">
				<h1><fmt:message key="listado.titulo"/></h1>
				<div style="width: 30%">
					<select id="filtroTrueque" onchange="comboTruequeInicio('filtroTrueque');">
						<option id="preferencias" value="PREFERENCIAS" <c:if test="${filtroTrueque == 'PREFERENCIAS'}">selected</c:if> ><fmt:message key="combo.preferencias"/></option>
						<option id="todos" value="TODOS" <c:if test="${filtroTrueque == 'TODOS'}">selected</c:if> ><fmt:message key="combo.todos"/></option>
					</select>
				</div>
			
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
					<div class="service_icon delay-03s animated wow  zoomIn" style="height: 190px;"> 
					<c:choose>
						<c:when test="${trueques.imagen64==''}">
							<img src="/canjehoras/img/sinfoto.jpg" style="max-height: 190px; border: 3px solid #4BAAD6;" />		
						</c:when>
						<c:otherwise>
							<img src="data:image/jpg;base64,${trueques.imagen64}" style="max-height: 190px; border: 2px solid #4BAAD6;"/>
						</c:otherwise>
					</c:choose> 
					</div>
					<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
					<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueques.categoria.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueques.provincia.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.ofrezco"/> ${trueques.descripcionOferta}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.busco"/> ${trueques.descripcionDemanda}</p>
					<c:if test="${sessionScope.usuario == null}">
						<p>
							<fmt:message key="listado.usuario.registro"/>&nbsp; 
							<a href="/canjehoras/login/registro.html" id="register-btn" ><fmt:message key="listado.usuario.registro.aqui"/></a>
						</p>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<input type="button" value="<fmt:message key="boton.ver.mas"/>" onclick="detalleTrueque(${trueques.id});"/>
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
		</section>
	</div>
	<%@ include file="comunes/include-pie.jsp" %>
	
	</body>
</html>