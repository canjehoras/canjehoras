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
			<section id="hero_section" class="page_section contact">
				<div class="row">
				
					<div class="col-lg-7 wow fadeInLeft animated"  style="margin-top: 20px">	
						<span style="color:white; text-align: justify;">
							<fmt:message key="inicio.descripcion"/>
						</span>
						<div style="color:white; font-weight: bold; font-family:cursive; padding: 20px 20px 20px 20px;">
							<fmt:message key="inicio.ultimos.trueques"/>
						</div>
						<c:forEach var="trueques" items="${trueques}" varStatus="count" begin="0" end="4">
							<a href="#" class="scroll-link" style="color:white; font-weight: bold;" onclick="detalleTrueque(${trueques.id});">
								<div style="margin-left: 15px">${trueques.fecha} - ${trueques.titulo} (${trueques.provincia.descripcion})</div>
							</a>  
						</c:forEach>
						<div style="padding-bottom: 20px; width: 100%; text-align: center; margin-top: 10px;" class="col-lg-3 col-sm-5 fadeInLeft delay-06s animated">
							<img src="../img/reloj.jpg" class="zoomIn wow animated" alt="" style="width: 50%"/>
						</div>
					</div>
					
					<div class="col-lg-5 col-sm-5 fadeInLeft delay-06s animated">
						<h1 style="background:#3399cc; padding:20px 0; font-size:140%; font-weight:300; text-align:center; color:#fff;">
							<fmt:message key="login"/>
						</h1>
						<div>
						</div>	
						<form action="/canjehoras/login/login.html" method="post" accept-charset="UTF-8">
							<%if(request.getSession().getAttribute(Constantes.MENSAJE_ERROR) != null){ %>
								<span style="color: #EE1616;"><%=request.getSession().getAttribute(Constantes.MENSAJE_ERROR) %></span>
							<%} %>
							<input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="login.usuario"/>" required/>
							<input type="password" name="pass" id="pass" placeholder="<fmt:message key="login.pass"/>" required/>
							<div class="forget-password" style="padding-bottom: 5px">
								<p>
									<a href="/canjehoras/login/recordarContrasenya.html" id="forget-password">
										<fmt:message key="login.olvidar.pass"/>
									</a>
								</p>
							</div>
							<input type="submit" value="<fmt:message key="boton.iniciar.sesion"/>" />
							<input type="button" value="<fmt:message key="boton.registrar"/>" onclick="registro();"/>			
						</form>
					</div>
				</div>
			</section>
		</div>
  	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>