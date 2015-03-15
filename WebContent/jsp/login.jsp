<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">
<title><fmt:message key="titulo"/></title>
</head>
<body>

<%@ include file="comunes/include-cabecera.jsp" %>

<section id="login" class="top_cont_outer">
	<h1><fmt:message key="registrar"/></h1>
 	<form action="/canjehoras/login/envioRegistro.html" method="post">
	    <input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="registro.usuario"/>" required/>
	    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="registro.pass"/>" required/>
	    <input type="password" name="pass2" id="pass2" placeholder="<fmt:message key="registro.repass"/>" required/>
	    <input type="text" title="Introduzca el nombre" name="nombre" id="nombre" placeholder="<fmt:message key="registro.nombre"/>" required/>
	    <input type="text" title="Introduzca el primer apellido" name="apellido1" id="apellido1" placeholder="<fmt:message key="registro.apellido1"/>" required/>
	    <input type="text" title="Introduzca el segundo apellido" name="apellido2" id="apellido2" placeholder="<fmt:message key="registro.apellido2"/>" required/>
	    <input type="tel" name="movil" title="Introduzca un movil válido"  id="movil" placeholder="<fmt:message key="registro.movil"/>" pattern="[0-9]{9}" required/>
	    <input type="tel" name="telefono" title="Introduzca un teléfono válido"  id="telefono" placeholder="<fmt:message key="registro.telefono"/>" pattern="[0-9]{9}" required/>
	    <fmt:message key="registro.wassap"/> <input type="checkbox" name="wassap" id="wassap" placeholder="<fmt:message key="registro.wassap"/>" />
	    	
	    <div class="tituloSelect">Categorías</div>
	    <div id="selectorOpciones" class="tituloSelect" style="max-height: 100px; border: 1px solid #000; background: #fff; overflow: auto;">
	    	<c:forEach var="categoria" items="${categorias}">
	    		<div style="width: 100%"><input type="checkbox" name="categoria" value="${categoria.id}" /> ${categoria.descripcion}</div>
	    	</c:forEach>
	    </div>
		<div class="tituloSelect">Provincias</div>
	 	<select multiple multiple name="provincias" id="provincias" size="10">
		  	<<c:forEach var="provincia" items="${provincias}">
	    		<option value="${provincia.id}">${provincia.descripcion}</option>
	    	</c:forEach>
		</select> 
		<div id="selectorOpciones" class="tituloSelect" style="max-height: 100px; border: 1px solid #000; background: #fff; overflow: auto;">
	    	<c:forEach var="provincia" items="${provincias}">
	    		<div style="width: 100%"><input type="checkbox" name="provincia" value="${provincia.id}" /> ${provincia.descripcion}</div>
	    	</c:forEach>
	    </div>
		<input type="submit" value="<fmt:message key="boton.enviar"/>" />
	</form>
</section>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>