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
	          <div class="col-lg-7 col-sm-7">
	            <div class="top_left_cont zoomIn wow animated"> 
	              <h2><fmt:message key="inicio.titulo"/></h2>
	              <p><fmt:message key="inicio.descripcion"/></p>
	              <h3>Utimos trueques publicados</h3>
	              <c:forEach var="trueques" items="${trueques}" varStatus="count" >
	                 <a href="#" class="scroll-link" onclick="detalleTrueque(${trueques.id});"><p>${trueques.fecha} - ${trueques.titulo}</p></a>  
	              </c:forEach>
	            </div>
	          </div>
	          <div class="col-lg-5 col-sm-5">
					<section id="login" class="top_cont_outer">
						<h1><fmt:message key="login"/></h1>
						<form action="/canjehoras/login/login.html" method="post" accept-charset="UTF-8">
							<input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="login.usuario"/>" />
						    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="login.pass"/>" />
						    
						    <div class="forget-password">
								<p><a href="/canjehoras/login/recordarContrasenya.html" id="forget-password"><fmt:message key="login.olvidar.pass"/></a></p>
							</div>
							<div class="create-account">
								<p>
									<fmt:message key="login.cuenta"/>&nbsp; 
									<a href="/canjehoras/login/registro.html" id="register-btn" ><fmt:message key="login.cuenta.crear"/></a>
								</p>
							</div>
							
							<input type="submit" value="<fmt:message key="boton.iniciar.sesion"/>" />
				            <input type="button" value="<fmt:message key="boton.registrar"/>" onclick="registro();"/>			
						</form>
					</section>
			  </div>
	        </div>
	      </div>
	    </div>
	  </div>
	
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>