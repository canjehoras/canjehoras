<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport" content="text/html; charset=UTF-8; width=device-width, maximum-scale=1"> 
	</head>
	
	<body>
		<div style="font-size: 11px; ">
			<c:forEach var="canje" items="${listadoFechasTrueques}">
				<div style="border-bottom: 2px solid black; padding: 3px;">
					<div><fmt:message key="agenda.titulo"/>${canje.trueque.titulo}</div>
					<div><fmt:message key="agenda.horario"/><fmt:formatDate value="${canje.fecha}" pattern="dd/MM/yyyy" />  ${canje.hora_inicio} - ${canje.hora_fin}</div>
					<div>
						<fmt:message key="agenda.trueque"/>
						<input src="../img/manos2.png" type="image" onclick="resolucionCanje(${canje.id}, 'LIBRE_RESERVADO');" style="width: 30px" />
					</div>
				</div>
			</c:forEach>
		</div>
	</body>
</html>