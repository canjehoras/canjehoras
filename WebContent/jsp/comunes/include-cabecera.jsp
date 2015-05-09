<%@ include file="include-javascript.jsp" %>
<%@ include file="include-estilos.jsp" %>

<!--Header_section-->
<header id="header_wrapper">
	<registro class="registro_wrapper" id="contact">
		<div class="container">
		  	<div class="registro_bottom">
		  		<span>
		  			<c:if test="${sessionScope.usuario == null}">
		        		<p><fmt:message key="registro.no"/></p>
		        	</c:if>
		        	<c:if test="${sessionScope.usuario != null}">
		        		<p>
		        			<fmt:message key="registro"/>${sessionScope.usuario.nombre}<a href="#" class="scroll-link" id="toggle-cerrar"><img src="../img/close.png" alt="cerrar sesion"></a>
		        		</p>
		        	</c:if>
				</span> 
			</div>
		</div>
	</registro>
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
		  		<li><a href="#" class="scroll-link" id="toggle-publicar-sinregistro"><fmt:message key="publicar"/></a></li>
			</c:if>
			<c:if test="${sessionScope.usuario != null}">
				<c:if test="${sessionScope.perfil == 'A'}">
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="datos.personales"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-trueques"><fmt:message key="trueques"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-agenda"><fmt:message key="agenda"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-publicar"><fmt:message key="publicar"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-buscador"><fmt:message key="buscador"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="trueques.activos"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="trueques.denunciados"/></a></li>
				</c:if>
				<c:if test="${sessionScope.perfil == 'U'}">
					<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="datos.personales"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-trueques"><fmt:message key="trueques"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-agenda"><fmt:message key="agenda"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-publicar"><fmt:message key="publicar"/></a></li>
					<li><a href="#" class="scroll-link" id="toggle-buscador"><fmt:message key="buscador"/></a></li>
				</c:if>
			</c:if>
		</ul>
      </div>
	 </nav>
    </div>
  </div>
  
	<script>
		$('#toggle-inicio').click(function(){
		  	inicio();
		});
		$('#toggle-login').click(function(){
		  	login();
		});
		$('#toggle-buscador').click(function(){
			buscador();
		});
		$('#toggle-agenda').click(function(){
			agenda();
		});
		$('#toggle-publicar').click(function(){
			publicar();
		});
		$('#toggle-publicar-sinregistro').click(function(){
			registro();
		});
		$('#toggle-datos').click(function(){
			datos();
		});
		$('#toggle-trueques').click(function(){
			trueques();
		});
		$('#toggle-cerrar').click(function(){
			cerrar();
		});
	</script>
</header>