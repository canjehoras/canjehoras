<!DOCTYPE html>
<%@ include file="comunes/include-taglib.jspf" %>
<head>
	<meta charset="utf-8" />
	<title><fmt:message key="titulo"/></title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<link href="css/login/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="css/login/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="css/login/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="css/login/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="css/login/style.css" rel="stylesheet" type="text/css"/>
	<link href="css/login/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="css/login/purple.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="css/login/select2_metro.css" rel="stylesheet" type="text/css" />
	<link href="css/login/login-soft.css" rel="stylesheet" type="text/css"/>
	<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<!-- PUT YOUR LOGO HERE -->
	</div>
	<!-- END LOGO -->
	
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="" method="post">
			<h3 class="form-title"><fmt:message key="login.titulo"/></h3>
			<div class="alert alert-error hide">
				<button class="close" data-dismiss="alert"></button>
				<span><fmt:message key="error.usuario.pass"/></span>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="login.usuario"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" autocomplete="off" placeholder="<fmt:message key="login.usuario"/>" name="correoElectronico"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="login.pass"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" autocomplete="off" placeholder="<fmt:message key="login.pass"/>" name="pass"/>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<!--  <label class="checkbox"><input type="checkbox" name="remember" value="1"/><fmt:message key="login.recordar"/></label>-->
				<button type="submit" class="btn blue pull-right"><fmt:message key="boton.inicio.sesion"/>
				
				<i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
			<div class="forget-password">
				<h4><fmt:message key="login.olvidar.pass"/></h4>
				<p><a href="javascript:;"  id="forget-password"><fmt:message key="login.restablecer.pass"/></a></p>
			</div>
			<div class="create-account">
				<p>
					<fmt:message key="login.cuenta"/>&nbsp; 
					<a href="javascript:;" id="register-btn" ><fmt:message key="login.cuenta.crear"/></a>
				</p>
			</div>
		</form>	
		<!-- END LOGIN FORM -->        
		<!-- BEGIN FORGOT PASSWORD FORM -->
		<form class="form-vertical forget-form" action="index.html" method="post">
			<h3 ><fmt:message key="login.recuperar.pass"/></h3>
			<p><fmt:message key="login.recuperar.password"/></p>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="login.usuario"/>" autocomplete="off" name="email" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn">
					<i class="m-icon-swapleft"></i><fmt:message key="boton.volver"/>
				</button>
				<button type="submit" class="btn blue pull-right">
					<fmt:message key="boton.enviar"/><i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>
		<!-- END FORGOT PASSWORD FORM -->
		<!-- BEGIN REGISTRATION FORM -->
		<form class="form-vertical register-form" action="index.html" method="post">
			<h3><fmt:message key="registro.titulo"/></h3>
			<p><fmt:message key="registro.cuenta"/></p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.usuario"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" autocomplete="off" placeholder="<fmt:message key="registro.usuario"/>" name="correoElectronico"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.pass"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" autocomplete="off" id="register_password" placeholder="<fmt:message key="registro.pass"/>" name="pass"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.repass"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-ok"></i>
						<input class="m-wrap placeholder-no-fix" type="password" autocomplete="off" placeholder="<fmt:message key="registro.repass"/>" name="rpass"/>
					</div>
				</div>
			</div>			

			<p><fmt:message key="registro.datos.personales"/></p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.nombre"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-font"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="registro.nombre"/>" name="nombre"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.apellido1"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-font"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="registro.apellido1"/>" name="apellido1"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.apellido2"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-font"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="registro.apellido2"/>" name="apellido2"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.telefono"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-font"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="registro.telefono"/>" name="telefono"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.movil"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-font"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="<fmt:message key="registro.movil"/>" name="movil"/>
					</div>
				</div>
			</div>			
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.wassap"/></label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-font"></i>
						<input class="m-wrap placeholder-no-fix" type="checkbox" placeholder="<fmt:message key="registro.wassap"/>" name="wassap"/>
					</div>
				</div>
			</div>				
			<div class="control-group">
				<div class="row-fluid">
					<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.provincia"/></label>
					<div class="controls">
						<select name="provincia" id="select_provincia" class="span12 select2">
							<option value=""></option>
							<option value="A">Avila</option>
						</select>
					</div>
				</div>
			</div>
			
			<p><fmt:message key="registro.preferencias"/></p>
			<div class="control-group">
				<div class="row-fluid">
					<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.categoria"/></label>
					<div class="controls">
						<select name="categoria" id="select_pref_categoria" class="span12 select2">
							<option value=""></option>
							<option value="A">Categoria</option>
						</select>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="row-fluid">
					<label class="control-label visible-ie8 visible-ie9"><fmt:message key="registro.provincia"/></label>
					<div class="controls">
						<select name="provincia" id="select_pref_provincia" class="span12 select2">
							<option value=""></option>
							<option value="A">Avila</option>
						</select>
					</div>
				</div>
			</div>

			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn">
					<i class="m-icon-swapleft"></i><fmt:message key="boton.volver"/>
				</button>
				<button type="submit" id="register-submit-btn" class="btn green pull-right">
				<fmt:message key="boton.registrar"/><i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>
		<!-- END REGISTRATION FORM -->
	</div>
	<!-- END LOGIN -->
	<script src="js/login/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="js/login/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<script src="js/login/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="js/login/bootstrap.min.js" type="text/javascript"></script>

	<script src="js/login/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="js/login/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="js/login/jquery.validate.min.js" type="text/javascript"></script>
	<script src="js/login/jquery.backstretch.min.js" type="text/javascript"></script>
	<script src="js/login/select2.min.js" type="text/javascript"></script>
	<script src="js/login/app.js" type="text/javascript"></script>
	<script src="js/login/login-soft.js" type="text/javascript"></script>      
	<script>
		jQuery(document).ready(function() {     
		  App.init();
		  Login.init();
		});
	</script>
</body>
<!-- END BODY -->
</html>