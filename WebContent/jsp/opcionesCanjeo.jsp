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
	
	<c:if test="${sessionScope.usuario != null}">
		<section id="hero_section" class="top_cont_outer">
		  <div class="hero_wrapper">
		    <div class="container">
		      <div class="hero_section">
		        <div class="row">
			       <div class="col-lg-5 col-sm-7 wow fadeInLeft animated" style="margin-top: 20px">	
						 <div class="contact_info">
				             <div class="detail">
				                 <h4>Usuario</h4>
				                 <p>${usuario.nombre} ${usuario.apellido1} ${usuario.apellido2}</p>
				             </div>
				             <div class="detail">
				                 <h4>Telefono</h4>
				                 <p>${usuario.movil}</p>
				             </div>
				             <div class="detail">
				                 <h4>Email</h4>
				                 <p>${usuario.correo_electronico}</p>
				             </div> 
				             <div class="detail">
				                 <h4>Fecha nacimiento:</h4>
				                 <p>${usuario.fecha_nacimiento}</p>
				             </div> 
						</div>
						<input type="button" value="<fmt:message key="boton.email"/>" onclick="canjeEmail(${usuario.id});"/>
						<input type="button" value="<fmt:message key="boton.foro"/>" onclick="canjeForo(${trueque.id});"/>
						<input type="button" value="<fmt:message key="boton.agenda"/>" onclick="canjeAgenda(${trueque.id});"/>
						<input type="button" value="<fmt:message key="boton.denunciar"/>" onclick="denunciarTrueque(${trueque.id});"/>
						<input type="button" value="<fmt:message key="boton.graficas"/>" onclick="graficas();"/>
		          </div>
		          <div  id="foro" class="col-lg-7 col-sm-5">
				  </div>
		        </div>
		      </div>
		    </div>
		  </div>
	  </section>
	</c:if>
	  
	<c:if test="${sessionScope.usuario == null}">
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
							<a href="/canjehoras/login/registro.html" id="register-btn" ><fmt:message key="login.cuenta"/></a>
						</p>
					</div>
				<input type="submit" value="<fmt:message key="boton.iniciar.sesion"/>" />
				<input type="button" value="<fmt:message key="boton.registrar"/>" onclick="registro();"/>			
			</form>
		</section>
	</c:if>
	
	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>