package com.vcortes.canjehoras.utils;

public class Constantes {

	// General
	public final static String ESPACIO_BLANCO = " ";
	public final static String COMILLAS = "'";
	public final static String BR = "</br>";
	
	// Idioma
	public final static String IDIOMA_ES = "ES";
	public final static String IDIOMA_EN = "EN";
	public final static String IDIOMA_ESPANOL = "Castellano";
	public final static String IDIOMA_INGLES = "Ingles";
	
	// Tipos de usuario
	public final static String TIPO_ADMINISTRADOR = "A";
	public final static String TIPO_USUARIO = "U";
	
	// Email
	public final static String EMAIL_ASUNTO_NUEVO = "Nuevo trueque publicado";
	public final static String EMAIL_ASUNTO_RESOLUCION = "Resolución del canjeo";
	public final static String EMAIL_ASUNTO_DENUNCIAR = "Denuncia trueque";
	public final static String EMAIL_ADMINISTRADOR = "canjehoras@gmail.com";
	public final static String EMAIL_CABECERA_ADMINISTRADOR = "<h2>Hola, Administrador</h2>";
	public final static String EMAIL_CABECERA_DENUNCIADO = "<h2>Se ha denunciado el trueque '";
	public final static String EMAIL_APERTURA_H2 = "<h2>";
	public final static String EMAIL_APERTURA_H3 = "<h3>";
	public final static String EMAIL_APERTURA_H4 = "<h4>";
	public final static String EMAIL_CIERRE_H2 = "</h2>";
	public final static String EMAIL_CIERRE_H3 = "</h3>";
	public final static String EMAIL_CIERRE_H4 = "</h4>";
	public final static String EMAIL_PUBLICADO_POR = "Publicado por:"; 
	public final static String EMAIL_DENUNCIADO_POR = "Denunciado por:";

	// Mensaje de errores
	public final static String MENSAJE_ERROR = "error";
	public final static String MENSAJE_DENUNCIADO = "denunciado";
	public final static String ERROR_PASS = "El password no es correcto";
	public final static String ERROR_USUARIO = "El usuario no esta registrado en la aplicación";
	public final static String ERROR_DENUNCIADO = "El trueque ha sido denunciado. Se ha enviado un email al Administrador. Gracias.";
	
	// Estados de los trueques
	public static final String TRUEQUE_ESTADO_NUEVO  = "N";
	public static final String TRUEQUE_ESTADO_REVISADO  = "R";
	public static final String TRUEQUE_ESTADO_DENUNCIADO = "D";
	public static final String TRUEQUE_ESTADO_BORRADO = "B";
	public static final String TRUEQUE_ESTADO_PENDIENTE = "P";
	public static final String TRUEQUE_ESTADO_CANJEADO = "C";
	
	// Nombre de los .jsp
	public static final String INICIO  = "inicio";
	public static final String LISTA_TRUEQUE  = "listadoTrueque";
	
	// Nombre de atributos
	public final static String CORREO_ELECTRONICO = "correo_electronico";
	public final static String PASS = "pass";
	public final static String TRUEQUES = "trueques";
	
	
	
	///////////////////////////
	
	public final static String FORMATO_FECHA = "dd/MM/yyyy";
	public final static String FORMATO_FECHA2 = "dd-MM-yyyy";
	public final static String ENCODING = "UTF-8";
	public final static String MAX_DESCRIPCION = "25";


	public final static String TIPO_OFERTA = "O";
	public final static String TIPO_OFERTA_DESC = "Oferta";
	public final static String TIPO_DEMANDA = "D";
	public final static String TIPO_DEMANDA_DESC = "Demanda";
	public final static String TIPO_COMPARTIR_HORAS = "C";
	public final static String TIPO_COMPARTIR_HORAS_DESC = "Compartir Horas";
	public final static String TIPO_INTERCAMBIAR_HORAS = "I";
	public final static String TIPO_INTERCAMBIAR_HORAS_DESC = "Intercambiar Horas";
	
	// Nombre de atributos
	public final static String USUARIO = "usuario";
	public final static String CATEGORIA = "categoria";
	public final static String CATEGORIAS = "categorias";
	public final static String TIPO = "tipo";
	public final static String DESCRIPCION = "descripcion";
	public final static String DESCRIPCION_OFERTA = "descripcionOferta";
	public final static String DESCRIPCION_DEMANDA = "descripcionDemanda";
	public final static String TITULO = "titulo";
	public final static String IMAGEN = "imagen";

	public final static String TRUEQUE = "trueque";
	public final static String ID = "id";
	public final static String PERFIL = "perfil";
	public final static String PROVINCIAS = "provincias";
	public final static String MODALIDAD = "modalidad";
	public final static String FECHA = "fecha";
	public final static String HORA_INICIO = "hora_inicio";
	public final static String HORA_FIN = "hora_fin";
	
	
	
	public static final String LOGIN  = "login";
	public static final String REGISTRO  = "registro";
	public static final String EDITAR_REGISTRO  = "editarRegistro";
	public static final String RECORDAR_PASS  = "recordarContrasenya";
	public static final String RECORDAR_PASS_OK  = "recordarContrasenyaAceptar";
	
	public static final String PUBLICAR  = "publicar";
	public static final String NUEVO_TRUEQUE  = "nuevoTrueque";
	
	public static final String EDITAR_TRUEQUE  = "edicionTrueque";
	public static final String MI_LISTA_TRUEQUE  = "misTrueques";
	public static final String DETALLE_TRUEQUE  = "detalleTrueque";
	public static final String LISTA_TRUEQUE_DENUNCIADOS = "gestionDenunciados";
	public static final String LISTA_TRUEQUE_ACTIVOS = "gestionActivos";
	public static final String OPCIONES_CANJEO_TRUEQUE  = "opcionesCanjeo";
	public static final String LISTA_CATEGORIA = "categorias";
	public static final String BUSCADOR ="buscador";
	public static final String BUSCADOR_RESULTADOS ="busquedaResultados";
	public static final String AGENDA = "agenda";
	public static final String AGENDA_DETALLE = "agendaDetalle";
	public static final String AGENDA_DETALLE_RESERVA = "agendaDetalleReserva";
	public static final String AGENDA_DETALLE_TRUEQUE = "agendaTrueque";
	public static final String GRAFICAS = "graficas";
	public static final String FOROS = "foros";
	public static final String CONTACTO = "contacto";
	public static final String ENVIAR_EMAIL = "enviarEmail";

	
	// Estado de los canjes
	public static final String ESTADO_CANJE_LIBRE  = "L";
	public static final String ESTADO_CANJE_LIBRE_STRING  = "LIBRE";
	public static final String ESTADO_CANJE_PENDIENTE  = "P";
	public static final String ESTADO_CANJE_PENDIENTE_STRING  = "PENDIENTE";
	public static final String ESTADO_CANJE_CANJEADO  = "C";
	public static final String ESTADO_CANJE_CANJEADO_STRING  = "CANJEADO";
	

	
	// Atributos de base de datos
	public final static String BBDD_USUARIO_CORREO = "correo_electronico";
	public final static String BBDD_USUARIO_PASS = "pass";
	public final static String BBDD_USUARIO_NOMBRE = "nombre";
	public final static String BBDD_USUARIO_APELLIDO1 = "apellido1";
	public final static String BBDD_USUARIO_APELLIDO2 = "apellido2";
	public final static String BBDD_USUARIO_MOVIL = "movil";
	public final static String BBDD_USUARIO_PROVINCIA = "provincia";
	public final static String BBDD_USUARIO_PROVINCIAS = "provincias";
	public final static String BBDD_USUARIO_CATEGORIA = "categoria";
	public final static String BBDD_NUM_ACCESO = "num_acceso";
	public final static String BBDD_FECHA_NACIMIENTO = "fecha_nacimiento";
	public final static String BBDD_IDIOMA = "idioma";
	
	// Email

	public final static String RESOLUCION_OK = "OK";
	public final static String RESOLUCION_OK_LABEL = "ACEPTADO";
	public final static String RESOLUCION_NOK = "NOK";
	public final static String RESOLUCION_NOK_LABEL = "RECHAZADO";
	public final static String RESOLUCION_LIBRE_RESERVADO = "OK";
	public final static String RESOLUCION_LIBRE_RESERVADO_LABEL = "ACEPTADO";
}
