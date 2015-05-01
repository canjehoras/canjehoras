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
	
	<section id="hero_section" class="top_cont_outer">
	  <div class="hero_wrapper">
	    <div class="container">
	      <div class="hero_section">
	        <div class="row">
	          <div class="col-lg-5 col-sm-7">
	            <div class="top_left_cont zoomIn wow animated"> 
					<h3 class="animated fadeInUp wow">
						<fmt:message key="contacte" />
					</h3>
					<p class="animated fadeInDown wow">${trueque.usuario.nombre}
						${trueque.usuario.apellido1} ${trueque.usuario.apellido2}</p>
					<p class="animated fadeInDown wow">${trueque.usuario.correo_electronico}</p>
					<p class="animated fadeInDown wow">${trueque.usuario.movil}</p>
					<input type="button" value="<fmt:message key="boton.email"/>" onclick="canjeEmail(${trueque.id});"/>
					<input type="button" value="<fmt:message key="boton.foro"/>" onclick="canjeForo(${trueque.id});"/>
					<input type="button" value="<fmt:message key="boton.agenda"/>" onclick="canjeAgenda(${trueque.id});"/>
	            </div>
	          </div>
	          <div  id="foro" class="col-lg-7 col-sm-5">
				hola
			  </div>
	        </div>
	      </div>
	    </div>
	  </div>

	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>