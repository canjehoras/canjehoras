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
			<div><fmt:message key="agenda.horario"/><fmt:formatDate value="${canje.fecha}" pattern="dd/MM/yyyy" />  ${canje.hora_inicio} - ${canje.hora_fin}</div>
			<div><fmt:message key="agenda.estado"/>${canje.estado}</div>

			<c:if test="${canje.estado == 'PENDIENTE'}">
				<div><fmt:message key="agenda.reservado"/>${canje.agenda.usuario.nombre} ${canje.agenda.usuario.apellido1} ${canje.agenda.usuario.apellido2}</div>
				<div>
					<fmt:message key="agenda.aceptas"/>
					<input src="../img/ok.png" type="image" onclick="resolucionCanje(${canje.id}, 'OK');" />
					<input src="../img/nok.png" type="image" onclick="resolucionCanje(${canje.id}, 'NOK');" />
				</div>
			</c:if>
			<c:if test="${canje.estado == 'CANJEADO'}">
				<div><fmt:message key="agenda.canjeado"/>${canje.agenda.usuario.nombre} ${canje.agenda.usuario.apellido1} ${canje.agenda.usuario.apellido2}</div>>
			</c:if>
			<c:if test="${canje.usuario != null}">
				otro
			</c:if>
			<div><fmt:message key="agenda.separador"/></div>
		</c:forEach>
	</body>
</html>