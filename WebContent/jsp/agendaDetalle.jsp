<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport" content="text/html; charset=UTF-8; width=device-width, maximum-scale=1"> 
	</head>
	
	<body>
		<c:forEach var="canje" items="${canjes}">
			<div><fmt:message key="agenda.titulo"/>${canje.trueque.titulo}</div>
			<div><fmt:message key="agenda.horario"/>${canje.fechaLabel}  ${canje.hora_inicio} - ${canje.hora_fin}</div>
			<div><fmt:message key="agenda.estado"/>${canje.estado}</div>
			<c:if test="${canje.estado == 'LIBRE'}">
				<div>
					<fmt:message key="agenda.trueque"/>
					<input src="../img/ok.png" type="image" onclick="resolucionCanje(${canje.id}, 'LIBRE_RESERVADO');" />
					<input src="../img/nok.png" type="image" onclick="resolucionCanje(${canje.id}, 'NOK');" />
				</div>
			</c:if>
			<c:if test="${canje.estado == 'RESERVADO'}">
				<div><fmt:message key="agenda.reservado"/>${canje.usuario.nombre} ${canje.usuario.apellido1} ${canje.usuario.apellido2}</div>
				<div>
					<fmt:message key="agenda.aceptas"/>
					<input src="../img/ok.png" type="image" onclick="resolucionCanje(${canje.id}, 'OK');" />
					<input src="../img/nok.png" type="image" onclick="resolucionCanje(${canje.id}, 'NOK');" />
				</div>
			</c:if>
			<c:if test="${canje.estado == 'CANJEADO'}">
				<div><fmt:message key="agenda.canjeado"/>${canje.usuario.nombre}</div>
			</c:if>
			<div><fmt:message key="agenda.separador"/></div>
		</c:forEach>
	</body>
</html>