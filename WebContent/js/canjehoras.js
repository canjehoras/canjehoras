inicio = function(){
	window.location.href= "/canjehoras/inicio/inicio.html"
}

login = function(){
	window.location.href= "/canjehoras/login/login.html"
}

registro = function(){
	window.location.href= "/canjehoras/login/registro.html"
}

recordarContrasenya = function(){
	window.location.href= "/canjehoras/login/recordar.html"
}

buscador = function(){
	window.location.href= "/canjehoras/buscador/inicio.html"
}

agenda = function(){
	window.location.href= "/canjehoras/agenda/agenda.html"
}

publicar = function(){
	window.location.href= "/canjehoras/trueque/nuevo.html"
}

trueques = function(){
	window.location.href= "/canjehoras/trueque/mistrueques.html"
}

datos = function(){
	window.location.href = "/canjehoras/login/editar.html";
}

editarTrueque = function(id){
	window.location.href= "/canjehoras/trueque/editar.html?id=" + id
}

detalleTrueque = function(id){
	window.location.href= "/canjehoras/trueque/detalle.html?id=" + id
}

denunciarTrueque = function(id){
	window.location.href= "/canjehoras/trueque/denunciado.html?id=" + id
}

reactivarTrueque = function(id){
	window.location.href= "/canjehoras/trueque/reactivar.html?id=" + id
}

opcionesCanjeoTrueque = function(id){
	window.location.href= "/canjehoras/trueque/opcionesCanjeo.html?id=" + id
}

graficasUsuario = function(){
	window.location.href= "/canjehoras/graficas/graficas.html"
}

borrarTrueque = function(){
	var txt;
	var r = confirm("Press a button!");
	if (r == true) {
	    txt = "You pressed OK!";
	} else {
	    txt = "You pressed Cancel!";
	}
	window.location.href= "/canjehoras/trueque/borrar.html"
}

cerrar = function(){
	window.location.href= "/canjehoras/login/logout.html"
}

habilitarDemanda = function(radio){
	if (radio=='C'){
		$("#divDescripcionDemanda").hide();
	}else{
		$("#divDescripcionDemanda").show();
	} 
}