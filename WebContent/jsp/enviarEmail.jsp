 <!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
	</head>
	
	<body>


 <div class="container">

       <div style="margin-top: 20px" class="col-lg-5 col-sm-5 fadeInLeft delay-06s animated">
         <div class="form">
           	<textarea required="required" title="<fmt:message key="contacto.mensaje"/>" name="mensaje" id="mensaje" placeholder="<fmt:message key="contacto.mensaje"/>"></textarea>
           	<input type="submit" value="<fmt:message key="boton.enviar.email"/>" />
           	<input type="button" value="<fmt:message key="boton.cancelar"/>" onclick="javascript:history.back();"/>
         </div>
       </div>
</div>
	</body>
</html>

      	