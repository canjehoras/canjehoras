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
	              <h2><fmt:message key="inicio.titulo"/></h2>
	              <p><fmt:message key="inicio.descripcion"/></p>
	              <a href="#" class="read_more2" id="toggle-ultimos"><fmt:message key="ultimos.trueques"/></a>
	            </div>
	          </div>
	          <div class="col-lg-7 col-sm-5">
				<img src="../img/main_device_image.jpg" class="zoomIn wow animated" alt=" "/>
			  </div>
	        </div>
	      </div>
	    </div>
	  </div>
	
	<%@ include file="comunes/include-pie.jsp" %>
	
		<script>
		$('#toggle-ultimos').click(function(){
			trueques();
		});
		</script>
	</body>
</html>