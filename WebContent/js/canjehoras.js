inicio = function(){
	window.location.href= "/canjehoras/inicio/inicio.html"
}

login = function(){
	window.location.href= "/canjehoras/login/login.html"
}

registro = function(){
	window.location.href= "/canjehoras/login/registro.html"
}

buscador = function(){
	window.location.href= "/canjehoras/buscador/inicio.html"
}

publicar = function(){
	window.location.href= "/canjehoras/trueque/nuevo.html"
}

trueques = function(){
	window.location.href= "/canjehoras/trueque/listado.html"
}

editarTrueque = function(id){
	window.location.href= "/canjehoras/trueque/editar.html?id=" + id
}

detalleTrueque = function(id){
	window.location.href= "/canjehoras/trueque/detalle.html?id=" + id
}

foroTrueque = function(id){
	window.location.href= "/canjehoras/foro/listado.html?id=" + id
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