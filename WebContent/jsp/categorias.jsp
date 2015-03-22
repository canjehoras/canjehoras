<!doctype html>
<%@ include file="comunes/include-taglib.jspf"%>
<html>
<head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" name="viewport"
	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
</head>
<body>
	<%@ include file="comunes/include-cabecera.jsp"%>
	<section id="Categoria" class="content">
		<div class="container categoria_title"></div>
		<div class="categoria-top"></div>
		<div class="categoria">
			<div id="filters" class="sixteen columns">
				<ul class="clearfix">
					<li><a id="all" href="#" data-filter="*" class="active">
							<h5>
								<fmt:message key="etiqueta.todo" />
							</h5>
					</a></li>
					<c:forEach var="categoria" items="${categorias}">
						<li><a class="" href="#" data-filter=".${categoria.id}">
								<h5>${categoria.descripcion}</h5>
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="portfolio_btm"></div>
		<div id="project_container">
			<div class="clear"></div>
			<div id="project_data"></div>
		</div>
	</section>


	<section id="Categoria2" class="content">
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
				  	<p class="animated fadeInDown wow">${trueques.categoria.id}</p>
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
	</section>



	<%@ include file="comunes/include-pie.jsp"%>
</body>
</html>