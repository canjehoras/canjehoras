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
		
		<section id="login" class="top_cont_outer">
			<h1><fmt:message key="titulo.registro"/></h1>
		 	<form action="/canjehoras/login/envioRegistro.html" method="post" accept-charset="UTF-8">
			    <div class="subtituloSelect" style="margin-bottom: 5px;"><fmt:message key="subtitulo.registro"/></div>
			    
			    <h1><fmt:message key="registro.datos.acceso"/></h1>
			    <input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="registro.usuario"/>" required/>
			    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="registro.pass"/>" required/>
			    <input type="password" name="pass2" id="pass2" placeholder="<fmt:message key="registro.repass"/>" required/>
			    
			    <h1><fmt:message key="registro.datos.personales"/></h1>
			    <input type="text" name="nombre" id="nombre" placeholder="<fmt:message key="registro.nombre"/>" required/>
			    <input type="text" name="apellido1" id="apellido1" placeholder="<fmt:message key="registro.apellido1"/>" required/>
			    <input type="text" name="apellido2" id="apellido2" placeholder="<fmt:message key="registro.apellido2"/>"/>
			    <input type="text" name="fecha_nacimiento" id="fecha_nacimiento" placeholder="<fmt:message key="seleccione.fecha.nacimiento" />"/>
			    <select name="provincias" id="provincias" required="required">
					<option value="-1"><fmt:message key="registro.seleccione.provincia" /></option>
		            <c:forEach var="provincia" items="${provincias}">
		                    <option value="${provincia.id}">${provincia.descripcion}</option>
		            </c:forEach>
		        </select> 
			    <input type="tel" name="movil" id="movil" placeholder="<fmt:message key="registro.movil"/>" pattern="[0-9]{9}" required/>
			   	<select name="idioma" id="idioma" required="required">
					<option value="-1"><fmt:message key="registro.seleccione.idioma" /></option>
		            <c:forEach var="idioma" items="${listadoIdiomas}">
		                    <option value="${idioma}">${idioma}</option>
		            </c:forEach>
		        </select> 
			    
			    <h1><fmt:message key="registro.datos.preferencias"/></h1>
			    <div class="tituloSelect"><fmt:message key="registro.categoria"/></div>
			    <div id="selectorOpciones" class="tituloSelect" style="max-height: 200px; border: 1px solid #000; background: #fff; overflow: auto;">
			    	<c:forEach var="categoria" items="${categorias}">
			    		<div style="width: 100%"><input type="checkbox" name="categoria" value="${categoria.id}" /> ${categoria.descripcion}</div>
			    	</c:forEach>
			    </div>
		
				<div class="tituloSelect"><fmt:message key="registro.provincia"/></div>
				<div id="selectorOpciones" class="tituloSelect" style="max-height: 200px; border: 1px solid #000; background: #fff; overflow: auto; margin-bottom: 5%;">
			    	<c:forEach var="provincia" items="${provincias}">
			    		<div style="width: 100%"><input type="checkbox" name="provincia" value="${provincia.id}" /> ${provincia.descripcion}</div>
			    	</c:forEach>
			    </div>
		
				<input type="submit" value="<fmt:message key="boton.crear.cuenta"/>" />
				<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>
			</form>
		</section>
		
		<script type="text/javascript">
		    $(document).ready(function() {
		    	$("#fecha_nacimiento").datepicker({ 
					dateFormat: 'dd/mm/yy',
				 	changeMonth: true, 
				 	changeYear: true, 
				 	yearRange: "-100:+0"
		    	});
		    });
		</script>
		
		<%@ include file="comunes/include-pie.jsp" %>
	
	</body>
</html>