<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" name="viewport"	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
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
        
          
        <div style="background: none repeat scroll 0 0 #fff; border: 1px solid #ccc; color: #555; font-size: 95%; margin-bottom: 4%; padding: 2%; width: 92%;">
	        <input onclick="habilitarDemanda(this.value);" type="radio" value="C" name="modalidad" id="modalidad" <c:if test="${'C' == trueque.modalidad}"> checked="checked" </c:if>/> Compartir Horas
	        <input onclick="habilitarDemanda(this.value);" type="radio" value="I" name="modalidad" id="modalidad" <c:if test="${'I' == trueque.modalidad}"> checked="checked" </c:if>/> Intercambiar Horas
        </div>
        <div class="tituloSelect"><fmt:message key="nuevo.trueque.descripcion.oferta"/></div>	
 		<textarea maxlength="500" title="<fmt:message key="nuevo.trueque.descripcion2"/>" name="descripcionOferta" id="descripcionOferta" placeholder="<fmt:message key="nuevo.trueque.descripcion"/>" required="required">${trueque.descripcionOferta}</textarea>
	 	<div id="divDescripcionDemanda" style="display:none;">
	 		<div class="tituloSelect"><fmt:message key="nuevo.trueque.descripcion.demanda"/></div>	
	 		<textarea maxlength="500" title="<fmt:message key="nuevo.trueque.descripcion2"/>" name="descripcionDemanda" id="descripcionDemanda" placeholder="<fmt:message key="nuevo.trueque.descripcion"/>">${trueque.descripcionDemanda}</textarea>
 		</div>
 		<div class="tituloSelect"><fmt:message key="nuevo.trueque.imagen"/></div>
 		<input type="file" accept="image/*" title="<fmt:message key="nuevo.trueque.imagen2"/>" name="imagen" id="imagen" placeholder="<fmt:message key="nuevo.trueque.imagen"/>" style="margin-bottom: 5%"/>
		
		<h1><fmt:message key="nuevo.trueque.agenda"/></h1>
		<div class="subtituloSelect" style="margin-bottom: 5px;"><fmt:message key="nuevo.trueque.subtitulo"/></div>
		<input type="text" name="fecha" id="fecha" value="<fmt:formatDate value='${fechaCanje}' pattern='dd/MM/yyyy' />" placeholder="<fmt:message key="nuevo.trueque.seleccione.fecha" />"/>
		
		<select name="hora_inicio" id="hora_inicio" >
			<option value="-1"><fmt:message key="nuevo.trueque.hora.inicio" /></option>
            <c:forEach var="hora_inicio" items="${listadoHoras}">
            	<option value="${hora_inicio}" <c:if test="${hora_inicioCanje == hora_inicio}">selected</c:if>>${hora_inicio}</option>
            </c:forEach>
        </select>       
		<select name="hora_fin" id="hora_fin" >
			<option value="-1"><fmt:message key="nuevo.trueque.hora.fin" /></option>
            <c:forEach var="hora_fin" items="${listadoHoras}">
                    <option value="${hora_fin}" <c:if test="${hora_finCanje == hora_fin}">selected</c:if>>${hora_fin}</option>
            </c:forEach>
        </select> 		
        
		<input type="submit" value="<fmt:message key="boton.enviar"/>" />
		<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>
 		<input type="hidden" name="id" id="id" value="${trueque.id}"/>
	</form>
</section>

<script type="text/javascript">
    $(document).ready(function() {
    	$("#fecha").datepicker({ 
    		dateFormat: 'dd/mm/yy',
    		firstDay: 1,
    		 changeMonth: true, 
    		 changeYear: true,
    		 minDate: "+0m +0d",
    		 firstDay: 1
    	});
    	
	  	seleccionado('toggle-publicar');
    });
    
</script>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>