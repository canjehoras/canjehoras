<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" name="viewport"
	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
</head>
<body>

<%@ include file="comunes/include-cabecera.jsp" %>

<section id="login" class="top_cont_outer">
	<h1><fmt:message key="nuevo.trueque.inicio"/></h1>
 	<form action="/canjehoras/trueque/publicar.html" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
 		<input type="text" title="<fmt:message key="nuevo.trueque.titulo2"/>" maxlength="50" name="titulo" id="titulo" placeholder="<fmt:message key="nuevo.trueque.titulo"/>" value="${trueque.titulo}" required/>
 		<div class="tituloSelect"><fmt:message key="nuevo.trueque.categoria"/></div>	
		<select name="categorias" id="categorias" required="required">
			<option value="-1"><fmt:message key="nuevo.trueque.seleccione.categoria" /></option>
            <c:forEach var="categoria" items="${categorias}">
                    <option value="${categoria.id}" <c:if test="${categoria.id == trueque.categoria.id}">selected</c:if>>${categoria.descripcion}</option>
            </c:forEach>
        </select> 
		<div class="tituloSelect"><fmt:message key="nuevo.trueque.provincia"/></div>
		<select name="provincias" id="provincias" required="required">
			<option value="-1"><fmt:message key="nuevo.trueque.seleccione.provincia" /></option>
            <c:forEach var="provincia" items="${provincias}">
                    <option value="${provincia.id}" <c:if test="${provincia.id == sessionScope.usuario.provincia.id}">selected</c:if>>${provincia.descripcion}</option>
            </c:forEach>
        </select> 
 		<textarea title="<fmt:message key="nuevo.trueque.descripcion2"/>" name="descripcion" id="descripcion" placeholder="<fmt:message key="nuevo.trueque.descripcion"/>" required="required">${trueque.descripcion}</textarea>
 		<div class="tituloSelect"><fmt:message key="nuevo.trueque.imagen"/></div>
 		<input type="file" accept="image/*" title="<fmt:message key="nuevo.trueque.imagen2"/>" name="imagen" id="imagen" placeholder="<fmt:message key="nuevo.trueque.imagen"/>" style="margin-bottom: 5%"/>
		
		
		<input type="submit" value="<fmt:message key="boton.enviar"/>" />
		<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>

 		<input type="hidden" name="id" id="id" value="${trueque.id}"/>
	</form>
</section>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>