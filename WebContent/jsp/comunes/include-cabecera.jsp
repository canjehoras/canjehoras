<%@ include file="include-javascript.jsp" %>
<%@ include file="include-estilos.jsp" %>
<%@ include file="include-taglib.jspf"%>

<%@page import="com.vcortes.canjehoras.utils.Constantes"%>

<fmt:setLocale value="${sessionScope.idioma}" scope="session"/>
<link rel="icon" type="image/png" href="/canjehoras/img/main_device_image.jpg" />

<header id="header_wrapper">
	<registro class="registro_wrapper" id="contact"></registro>
	<div class="container">
		<div class="header_box">
		    <div class="logo" >
		    	<a href="#" class="scroll-link" id="toggle-inicio">
		    		<img src="../img/logo.jpg" >
		    	</a>
		    </div>
		    <div class="logo" style="float: right;">
		    	<a href="#" class="scroll-link" id="toggle-inicio" onclick="cambiarIdioma('<%=Constantes.IDIOMA_ES%>');"><img src="../img/es.png" style="width: 9%"></a>
		    	<a href="#" class="scroll-link" id="toggle-inicio" onclick="cambiarIdioma('<%=Constantes.IDIOMA_EN%>');"><img src="../img/en.jpg" style="width: 9%"></a>
		    	<c:if test="${sessionScope.usuario != null}">
		    		<a href="#" class="scroll-link" id="toggle-cerrar"><fmt:message key="registro"/>${sessionScope.usuario.nombre}<img src="../img/close.png" alt="cerrar sesion"></a>
		    	</c:if>
		    </div>
	    
			<nav class="navbar navbar-inverse" role="navigation">
			    <div class="navbar-header">
			    	<button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> 
			    		<span class="sr-only">Toggle navigation</span> 
			    		<span class="icon-bar"></span> 
			    		<span class="icon-bar"></span> 
			    		<span class="icon-bar"></span> 
			    	</button>
			    </div>
				<div id="main-nav" class="collapse navbar-collapse navStyle" style="width: 100%">
					<ul class="nav navbar-nav" id="mainNav">
						<c:if test="${sessionScope.usuario != null}">
							<li><a href="#" class="scroll-link" id="toggle-datos"><fmt:message key="menu.datos.personales"/></a></li>
							<li><a href="#" class="scroll-link" id="toggle-trueques"><fmt:message key="menu.trueques"/></a></li>
							<li><a href="#" class="scroll-link" id="toggle-agenda"><fmt:message key="menu.agenda"/></a></li>
							<li><a href="#" class="scroll-link" id="toggle-publicar"><fmt:message key="menu.publicar"/></a></li>
							<li><a href="#" class="scroll-link" id="toggle-buscador"><fmt:message key="menu.buscador"/></a></li>
							<c:if test="${sessionScope.perfil == 'A'}">
								<li><a href="#" class="scroll-link" id="toggle-denunciados"><fmt:message key="menu.trueques.denunciados"/></a></li>
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
			seleccionado('toggle-agenda');
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
		$('#toggle-activos').click(function(){
			gestionActivos();
		});	
		$('#toggle-denunciados').click(function(){
			gestionDenunciados();
		});	
		$('#toggle-trueques').click(function(){
			trueques();
		});
		$('#toggle-graficas').click(function(){
			graficasUsuario();
		});
		$('#toggle-cerrar').click(function(){
			cerrar();
		});
		cambiarIdioma = function(idioma){	
			$.post("/canjehoras/login/cambiarIdioma.html",
				{ idioma: idioma
				},
				function (respuesta) {
					window.location.reload();
				}
			, "json");
			
		}
		seleccionado = function(id){
			$("#"+id).closest("li").attr("class","active");			
		};
	</script>
</header>