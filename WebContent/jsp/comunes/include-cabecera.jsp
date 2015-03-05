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
			  		<li><a href="#" class="scroll-link" id="toggle-login">Log in</a></li>
				</c:if>
				<c:if test="${sessionScope.usuario != null}">
			  		<li><a href="#" class="scroll-link" id="toggle-login">Bienvenido ${sessionScope.usuario.nombre}</a></li>
				</c:if>
			  
			 <!--  <li><span href="#" class="button" id="toggle-login">Log in</span></li> -->
			  
			  <li class="active"><a href="#hero_section" class="scroll-link">Home</a></li>
			  <li><a href="#aboutUs" class="scroll-link">About Us</a></li>
			  <li><a href="#service" class="scroll-link">Services</a></li>
			  <li><a href="#Portfolio" class="scroll-link">Portfolio</a></li>
			  <li><a href="#clients" class="scroll-link">Clients</a></li>
			  <li><a href="#team" class="scroll-link">Team</a></li>
			  <li><a href="#contact" class="scroll-link">Identificate</a></li>
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
  <h1>Log in</h1>
  	<c:if test="${sessionScope.usuario == null}">
	 	<form action="/canjehoras/login/login.html" method="post">
		    <input type="email" name="correoElectronico" id="correoElectronico" placeholder="Email" />
		    <input type="password" name="pass" id="pass" placeholder="Password" />
			<input type="submit" value="Log in" />
			<input type="button" value="Registrate" onclick="registro();"/>
		</form>
	</c:if>
	<c:if test="${sessionScope.usuario != null}">
		<form action="/canjehoras/login/logout.html" method="post">
			<input type="submit" value="Log out" />
		</form>
	</c:if>
  
</div>
</header>