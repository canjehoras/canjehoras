<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport" content="text/html; charset=UTF-8; width=device-width, maximum-scale=1"> 
	</head>
	
	<body>
		<div style="font-size: 11px; ">
			<c:forEach var="canje" items="${canjes}">
				<div style="border-bottom: 2px solid black; padding: 3px;">
					<div><fmt:message key="agenda.titulo"/>${canje.trueque.titulo}</div>
					<div><fmt:message key="agenda.horario"/>${canje.fechaLabel}  ${canje.hora_inicio} - ${canje.hora_fin}</div>
					<div><fmt:message key="agenda.estado"/>${canje.estado}</div>
					<c:if test="${canje.estado == 'LIBRE'}">
						<div>
							<fmt:message key="agenda.trueque"/>
							<input src="../img/manos2.png" type="image" onclick="resolucionCanje(${canje.id}, 'LIBRE_RESERVADO');" style="width: 30px" />
						</div>
					</c:if>
					<c:if test="${canje.estado == 'PENDIENTE'}">
						<div>
							<fmt:message key="agenda.trueque.aceptar"/>
							<input src="../img/manos2.png" type="image" onclick="resolucionCanje(${canje.id}, 'LIBRE_RESERVADO');" style="width: 30px" />
							<input src="../img/nok.png" type="image" onclick="resolucionCanje(${canje.id}, 'NOK');" style="width: 30px" />
						</div>
					</c:if>
					<c:if test="${canje.estado == 'CANJEADO'}">
						<div><fmt:message key="agenda.canjeado"/>${canje.usuario.nombre}</div>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</body>
</html>