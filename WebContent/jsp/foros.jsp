<!doctype html>
<%@ include file="comunes/include-taglib.jspf"%>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport"	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
		
	</head>
	
	<body>	
		 <div class="row">
  		      <div class="col-lg-5 col-sm-5 fadeInLeft delay-06s animated">
				<h1 style="background:#3399cc; padding:20px 0; font-size:140%; font-weight:300; text-align:center; color:#fff;">Foro: Escribe tu comentario</h1>
				<form action="/canjehoras/foro/nuevoComentario.html" method="post" accept-charset="UTF-8">
			
					<c:forEach var="p" items="${publicaciones}">
						<div style="margin: 5px;">
							<div style="background: #3399cc; padding:10px; color: #fff">
								Fecha: <fmt:formatDate value="${p.fecha}" pattern="dd/MM/yyyy"/>  -  Hora: ${p.hora}
							</div>
							<div>
								${p.usuario.nombre} ${p.usuario.apellido1} ${p.usuario.apellido2}
								<textarea readonly="readonly" style="background: #ddd">${p.comentario}</textarea>
							</div>
						</div>
					</c:forEach>
					
					
						<div style="margin: 5px;">
							<div style="background: #3399cc; padding:10px; color: #fff">
								ESCRIBE UN NUEVO COMENTARIO
							</div>
							<div>
								<textarea rows="5" style="width: 100%" id="comentario" name="comentario"></textarea>
							</div>
						</div>
					
					<input type="submit" value="Añadir Comentario" />
					
					<input type="hidden" id="idTrueque" name="idTrueque" value="${idTrueque}" />
					<input type="hidden" id="idForo" name="idForo" value="${idForo}" />
			
				</form>
        	</div>
       	</div>
	
	</body>
</html>	
	
