<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, maximum-scale=1">
	<title><fmt:message key="titulo"/></title>
	
	<script type="text/javascript">
	
	</script>
</head>

<body>
<%@ include file="comunes/include-cabecera.jsp" %>

  <div class="container">
	<c:set var="primero" value="true"/>
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
		  	<div class="service_icon delay-03s animated wow  zoomIn"> <span><i class="fa fa-dropbox"></i></span> </div>
		  	<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
		  	<p class="animated fadeInDown wow">${trueques.descripcion}</p>
		  	<input type="button" value="<fmt:message key="boton.editar"/>" onclick="editarTrueque(${trueques.id});"/>
		  	<input type="button" value="<fmt:message key="boton.borrar"/>" onclick="borrarTrueque(${trueques.id});"/>
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