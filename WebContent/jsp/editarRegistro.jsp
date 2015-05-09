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
	    <input type="email" name="correo_electronico" id="correo_electronico" value="${usuario.correo_electronico}" placeholder="<fmt:message key="registro.usuario"/>" required/>
	    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="registro.pass"/>" value="${usuario.pass}"  required/>
	    <input type="password" name="pass2" id="pass2" placeholder="<fmt:message key="registro.repass"/>" value="${usuario.pass}"  required/>
	    <input type="text" title="Introduzca el nombre" name="nombre" id="nombre" placeholder="<fmt:message key="registro.nombre"/>" value="${usuario.nombre}" required/>
	    <input type="text" title="Introduzca el primer apellido" name="apellido1" id="apellido1" placeholder="<fmt:message key="registro.apellido1"/>" value="${usuario.apellido1}" required/>
	    <input type="text" title="Introduzca el segundo apellido" name="apellido2" id="apellido2" placeholder="<fmt:message key="registro.apellido2"/>" value="${usuario.apellido2}" required/>
	    
	    <select name="provincias" id="provincias" required="required">
			<option value="-1"><fmt:message key="registro.seleccione.provincia" /></option>
            <c:forEach var="provincia" items="${provincias}">
                    <option <c:if test="${usuario.provincia.id == provincia.id}" > selected="selected" </c:if> value="${provincia.id}">${provincia.descripcion}</option>
            </c:forEach>
        </select> 
	    
	    <input type="tel" name="movil" title="Introduzca un movil válido"  id="movil" placeholder="<fmt:message key="registro.movil"/>" pattern="[0-9]{9}" value="${usuario.movil}" required/>
	    <input type="tel" name="telefono" title="Introduzca un teléfono válido"  id="telefono" placeholder="<fmt:message key="registro.telefono"/>" pattern="[0-9]{9}" value="${usuario.telefono}" required/>
	    <fmt:message key="registro.wassap"/> <input type="checkbox" name="wassap" id="wassap" placeholder="<fmt:message key="registro.wassap"/>" />

	    <h1>Indica las preferencias</h1>
	    <div class="tituloSelect">Categorías</div>
	    <div id="selectorOpciones" class="tituloSelect" style="max-height: 200px; border: 1px solid #000; background: #fff; overflow: auto;">
	    	<c:forEach var="categoria" items="${categorias}">
	    		<div style="width: 100%"><input type="checkbox" name="categoria" value="${categoria.id}" <c:if test="${fn:contains(listadoCategoria, categoria.id)}" > checked = "checked" </c:if>/> ${categoria.descripcion}</div>
	    	</c:forEach>
	    </div>

		<div class="tituloSelect">Provincias</div>
		<div id="selectorOpciones" class="tituloSelect" style="max-height: 200px; border: 1px solid #000; background: #fff; overflow: auto; margin-bottom: 5%;">
	    	<c:forEach var="provincia" items="${provincias}">
	    		<div style="width: 100%"><input type="checkbox" name="provincia" value="${provincia.id}" <c:if test="${fn:contains(listadoProvincia, provincia.id)}" > checked = "checked" </c:if>/> ${provincia.descripcion}</div>
	    	</c:forEach>
	    </div>
	    <div class="tituloSelect"><fmt:message key="campos.obligatorios"/></div>
		<input type="submit" value="<fmt:message key="boton.crear.cuenta"/>" />
		<!--<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>  -->
	</form>
</section>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>