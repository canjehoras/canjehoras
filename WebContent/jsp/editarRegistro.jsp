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
			<h1><fmt:message key="titulo.registro.editar"/></h1>
		 	<form action="/canjehoras/login/envioRegistro.html" method="post" accept-charset="UTF-8">
				<div class="subtituloSelect" style="margin-bottom: 5px;"><fmt:message key="subtitulo.registro.editar"/></div>
				
				<h1><fmt:message key="registro.datos.acceso"/></h1>
			    <div class="tituloSelect"><fmt:message key="registro.usuario"/></div>
			    <input type="email" name="correo_electronico" id="correo_electronico" value="${usuario.correo_electronico}" placeholder="<fmt:message key="registro.usuario"/>"/>
				<div class="tituloSelect"><fmt:message key="registro.pass"/></div>
			    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="registro.pass"/>" value="${usuario.pass}"  required/>

			    <h1><fmt:message key="registro.datos.personales"/></h1>
			    <div class="tituloSelect"><fmt:message key="registro.nombre"/></div>
			    <input type="text" name="nombre" id="nombre" placeholder="<fmt:message key="registro.nombre"/>" value="${usuario.nombre}" required/>
			    <div class="tituloSelect"><fmt:message key="registro.apellido1"/></div>
			    <input type="text" name="apellido1" id="apellido1" placeholder="<fmt:message key="registro.apellido1"/>" value="${usuario.apellido1}" required/>
			    <div class="tituloSelect"><fmt:message key="registro.apellido2"/></div>
			    <input type="text" name="apellido2" id="apellido2" placeholder="<fmt:message key="registro.apellido2"/>" value="${usuario.apellido2}" />
			    <div class="tituloSelect"><fmt:message key="seleccione.fecha.nacimiento"/></div>
			    <input type="text" name="fecha_nacimiento" id="fecha_nacimiento" value="<fmt:formatDate value='${usuario.fecha_nacimiento}' pattern='dd/MM/yyyy' />" placeholder="<fmt:message key="seleccione.fecha.nacimiento" />"/>
			    <div class="tituloSelect"><fmt:message key="registro.seleccione.provincia"/></div>
			    <select name="provincias" id="provincias" required="required">
					<option value="-1"><fmt:message key="registro.seleccione.provincia" /></option>
		            <c:forEach var="provincia" items="${provincias}">
		                    <option <c:if test="${usuario.provincia.id == provincia.id}" > selected="selected" </c:if> value="${provincia.id}">${provincia.descripcion}</option>
		            </c:forEach>
		        </select> 
			    <div class="tituloSelect"><fmt:message key="registro.movil"/></div>
			    <input type="tel" name="movil" id="movil" placeholder="<fmt:message key="registro.movil"/>" pattern="[0-9]{9}" value="${usuario.movil}" required/>
			   	<div class="tituloSelect"><fmt:message key="registro.seleccione.idioma"/></div>
			   	<select name="idioma" id="idioma" required="required">
					<option value="-1"><fmt:message key="registro.seleccione.idioma" /></option>
		            <c:forEach var="idioma" items="${listadoIdiomas}">
		            	<option <c:if test="${usuario.idioma == idioma}" > selected="selected" </c:if> value="${idioma}">${idioma}</option>
		            </c:forEach>
		        </select> 
		
				<h1><fmt:message key="registro.datos.preferencias"/></h1>
				<div class="tituloSelect"><fmt:message key="registro.categoria"/></div>
			    <div id="selectorOpciones" class="tituloSelect" style="max-height: 200px; border: 1px solid #000; background: #fff; overflow: auto;">
			    	<c:forEach var="categoria" items="${categorias}">
			    		<div style="width: 100%"><input type="checkbox" name="categoria" value="${categoria.id}" <c:if test="${categoria.seleccionado}" > checked = "checked" </c:if>/> ${categoria.descripcion}</div>
			    	</c:forEach>
			    </div>
				<div class="tituloSelect"><fmt:message key="registro.provincia"/></div>
				<div id="selectorOpciones" class="tituloSelect" style="max-height: 200px; border: 1px solid #000; background: #fff; overflow: auto; margin-bottom: 5%;">
			    	<c:forEach var="provincia" items="${provincias}">
			    		<div style="width: 100%"><input type="checkbox" name="provincia" value="${provincia.id}" <c:if test="${provincia.seleccionado}" > checked = "checked" </c:if>/> ${provincia.descripcion}</div>
			    	</c:forEach>
			    </div>

				<input type="submit" value="<fmt:message key="boton.guardar"/>" />
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