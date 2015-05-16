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
		       <div class="col-lg-7 wow fadeInLeft animated" style="margin-top: 20px">	
					 <div class="contact_info">
			             <div class="detail">
			                 <h4>Usuario</h4>
			                 <p>${usuario.nombre} ${usuario.apellido1} ${usuario.apellido2}</p>
			             </div>
			             <div class="detail">
			                 <h4>call us</h4>
			                 <p>${usuario.movil}</p>
			             </div>
			             <div class="detail">
			                 <h4>Email us</h4>
			                 <p>${usuario.correo_electronico}</p>
			             </div> 
					</div>
        	   </div>
			        <div class="col-lg-5 col-sm-5 fadeInLeft delay-06s animated">
			          <div class="form">
			            	<textarea required="required" title="<fmt:message key="contacto.mensaje"/>" name="mensaje" id="mensaje" placeholder="<fmt:message key="contacto.mensaje"/>"></textarea>
			            	<input type="submit" value="<fmt:message key="boton.enviar.email"/>" />
			          </div>
			        </div>
      		</div>
    </section>
  </div>
  	<%@ include file="comunes/include-pie.jsp" %>
	</body>
</html>