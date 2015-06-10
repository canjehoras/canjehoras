 <!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
        <div class="row">
  		      <div class="col-lg-5 col-sm-5 fadeInLeft delay-06s animated">
				<h1 style="background:#3399cc; padding:20px 0; font-size:140%; font-weight:300; text-align:center; color:#fff;"><fmt:message key="informacion.canje"/></h1>
				<form action="/canjehoras/agenda/contacto.html" method="post" accept-charset="UTF-8">
					<div style="margin-bottom: 15px;">To: ${usuario.correo_electronico}</div>
					<input type="hidden" id="email" name="email" value="${usuario.correo_electronico}" />
					<textarea required="required" title="<fmt:message key="contacto.mensaje"/>" name="mensaje" id="mensaje" placeholder="<fmt:message key="contacto.mensaje"/>" cols="100"></textarea>
		           	<input type="submit" value="<fmt:message key="boton.enviar.email"/>" />
		           	<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>
				</form>
        	</div>
       	</div>
	</body>
</html>

      	