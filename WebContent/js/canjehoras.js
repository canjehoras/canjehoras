inicio = function(){
	window.location.href= "/canjehoras/inicio/inicio.html"
}

registro = function(){
	window.location.href= "/canjehoras/login/registro.html"
}

categorias = function(){
	window.location.href= "/canjehoras/categoria/inicio.html"
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