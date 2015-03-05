<%@ include file="include-javascript.jsp" %>
<%@ include file="include-estilos.jsp" %>

<!--Header_section-->
<header id="header_wrapper">
  <div class="container">
    <div class="header_box">
      <div class="logo"><a href="#"><img src="../img/logo.png" alt="logo"></a></div>
	  <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      </div>
	  <div id="main-nav" class="collapse navbar-collapse navStyle">
		<ul class="nav navbar-nav" id="mainNav">
			<c:if test="${sessionScope.usuario == null}">
		  		<li><a href="#" class="scroll-link" id="toggle-login"><fmt:message key="login"/></a></li>
			</c:if>
			<c:if test="${sessionScope.usuario != null}">
		  		<li><a href="#" class="scroll-link" id="toggle-login"><fmt:message key="login.ok"/> ${sessionScope.usuario.nombre}</a></li>
			</c:if>
		</ul>
      </div>
	 </nav>
    </div>
  </div>
  
	<script>
		$('#toggle-login').click(function(){
		  $('#login').toggle();
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
		<c:if test="${sessionScope.usuario != null}">
			<form action="/canjehoras/login/logout.html" method="post">
				<input type="submit" value="<fmt:message key="boton.salir"/>" />
			</form>
		</c:if>
	</div>
</header>