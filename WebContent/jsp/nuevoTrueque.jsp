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
	<h1><fmt:message key="nuevo.trueque.inicio"/></h1>
 	<form action="/canjehoras/trueque/publicar.html" method="post">
 		<input type="text" title="<fmt:message key="nuevo.trueque.titulo2"/>" name="titulo" id="titulo" placeholder="<fmt:message key="nuevo.trueque.titulo"/>" required/>
 		<div class="tituloSelect"><fmt:message key="nuevo.trueque.categoria"/></div>	
		<select name="categorias" id="categorias" required="required">
            <c:forEach var="categoria" items="${categorias}">
                    <option value="${categoria.id}">${categoria.descripcion}</option>
            </c:forEach>
        </select> 
 		<textarea title="<fmt:message key="nuevo.trueque.descripcion2"/>" name="descripcion" id="descripcion" placeholder="<fmt:message key="nuevo.trueque.descripcion"/>" required/>
 		<input type="file" title="<fmt:message key="nuevo.trueque.imagen2"/>" name="imagen" id="imagen" placeholder="<fmt:message key="nuevo.trueque.imagen"/>" />
 
		<input type="submit" value="<fmt:message key="boton.enviar"/>" />
	</form>
</section>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>