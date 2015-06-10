inicio = function(){
	window.location.href= "/canjehoras/inicio/inicio.html"
}

login = function(){
	window.location.href= "/canjehoras/login/login.html"
}

registro = function(){
	window.location.href= "/canjehoras/login/registro.html"
}

recordarContrasenya = function(email){
	window.location.href= "/canjehoras/login/recordar.html?email="+$("#correo_electronico").val();
}

buscador = function(){
	window.location.href= "/canjehoras/buscador/inicio.html"
}

agenda = function(){
	window.location.href= "/canjehoras/agenda/agenda.html"
}

canjeAgenda = function(id){
	window.location.href= "/canjehoras/agenda/agendaTrueque.html?id=" + id
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

preferenciaTrueque = function(id){
	window.location.href= "/canjehoras/trueque/preferencias.html"
}

todosTrueque = function(id){
	window.location.href= "/canjehoras/trueque/listado.html"
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

contacto = function(id_usuario){
	window.location.href= "/canjehoras/login/contacto.html?id_usuario=" + id_usuario
}

graficasUsuario = function(){
	window.location.href= "/canjehoras/graficas/graficas.html"
}

borrarTrueque = function(id){
	window.location.href= "/canjehoras/trueque/borrar.html?id=" + id
}

publicarTruequeAdmin = function(id){
	window.location.href= "/canjehoras/trueque/republicar.html?id=" + id
}

eliminarTruequeAdmin = function(id){
	window.location.href= "/canjehoras/trueque/borrar.html?id=" + id
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

eventoMiAgenda = function(fecha){
	$("#agendaCanje").load("/canjehoras/agenda/detalleMiAgenda.html?fecha="+fecha,  function(){
		showAgendaCanje();
	}
	);
};

eventoRealizar = function(id){
	$("#agendaCanjeR").load("/canjehoras/agenda/detalleAgendaCanjeo.html?id="+id,  function(){
		showAgendaCanje();
	}
	);
};

gestionActivos = function(id){
	window.location.href= "/canjehoras/trueque/gestionActivos.html"
}

gestionDenunciados = function(id){
	window.location.href= "/canjehoras/trueque/gestionDenunciados.html"
}

graficas = function(){
	$("#foro").load("/canjehoras/graficas/verGraficas.html");
}

canjeForo = function(id){
	$("#foro").load("/canjehoras/foro/verForos.html?idTrueque="+id);
}

canjeAgendaTrueque= function(id){
	$("#foro").load("/canjehoras/agenda/agendaTrueque.html?id="+id);
}

canjeEmail = function(correo){
	$("#foro").load("/canjehoras/agenda/contactoEmail.html?email=" + correo);
}

gestionActivos = function(id){
	window.location.href= "/canjehoras/trueque/gestionActivos.html"
}

resolucionCanje = function(id, resolucion){
	window.location.href= "/canjehoras/agenda/resolucionCanje.html?id="+id+"&resolucion="+resolucion
}

verTrueques = function(id){
	var sel = $('#'+id).val();	
	window.location.href= "/canjehoras/trueque/mistrueques.html?estado="+sel;
}

comboTruequeInicio = function(id){
	var sel = $('#'+id).val();	
	window.location.href= "/canjehoras/login/verTrueques.html?filtroTrueque="+sel;
}
