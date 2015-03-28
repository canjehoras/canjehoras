<%@ include file="include-javascript.jsp" %>
<%@ include file="include-estilos.jsp" %>

<!--Header_section-->
<header id="header_wrapper">
  <div class="container">
    <div class="header_box">
      <div class="logo"><a href="#" class="scroll-link" id="toggle-inicio"><img src="../img/logo.png" alt="logo"></a></div>
	  <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      </div>
	  <div id="main-nav" class="collapse navbar-collapse navStyle">
		<ul class="nav navbar-nav" id="mainNav">
			<c:if test="${sessionScope.usuario == null}">
		  		<li><a href="#" class="scroll-link" id="toggle-login"><fmt:message key="login"/></a></li>
		  		<li><a href="#" class="scroll-link" id="toggle-registro"><fmt:message key="registrar"/></a></li>
		  		<li><a href="#" class="scroll-link" id="toggle-publicar-sinregistro"><fmt:message key="publicar"/></a></li>
			</c:if>
			<c:if test="${sessionScope.usuario != null}">
				<c:if test="${sessionScope.perfil == 'A'}">
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="gestion.usuarios"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="trueques.activos"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="trueques.denunciados"/></a></li>
				</c:if>
				<c:if test="${sessionScope.perfil == 'U'}">
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="datos.personales"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-trueques"><fmt:message key="trueques"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-publicar"><fmt:message key="publicar"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-buscador"><fmt:message key="buscador"/></a></li>
				</c:if>
			</c:if>
			<li><a href="#" class="scroll-link" id="toggle-acerca"><fmt:message key="acerca.de"/></a></li>
		</ul>
      </div>
	 </nav>
    </div>
    <c:if test="${sessionScope.usuario != null}">
	    <div class="logo">
	    	Usuario Registrado: ${sessionScope.usuario.nombre}
	    	<a href="#" class="scroll-link" id="toggle-cerrar"><img src="../img/close.png" alt="cerrar sesion"></a>
	    </div>
    </c:if>
  </div>
  
	<script>
		$('#toggle-inicio').click(function(){
		  inicio();
		});
		$('#toggle-login').click(function(){
		  $('#login').toggle();
		});
		$('#toggle-registro').click(function(){
			registro();
		});
		$('#toggle-buscador').click(function(){
			buscador();
		});
		$('#toggle-publicar').click(function(){
			publicar();
		});
		$('#toggle-publicar-sinregistro').click(function(){
			registro();
		});
		$('#toggle-trueques').click(function(){
			trueques();
		});
		$('#toggle-cerrar').click(function(){
			cerrar();
		});
	</script>
	
	<div id="login" style="display: none; position: absolute; z-index: 100;">
	  <div id="triangle"></div>
	  <h1><fmt:message key="login"/></h1>
	  	<c:if test="${sessionScope.usuario == null}">
		 	<form action="/canjehoras/login/login.html" method="post">
			    <input type="email" name="correo_electronico" id="correo_electronico" placeholder="<fmt:message key="login.usuario"/>" />
			    <input type="password" name="pass" id="pass" placeholder="<fmt:message key="login.pass"/>" />
				<input type="submit" value="<fmt:message key="boton.enviar"/>" />
				<input type="button" value="<fmt:message key="boton.registrar"/>" onclick="registro();"/>
			</form>
		</c:if>
	</div>
</header>