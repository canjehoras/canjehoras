<!doctype html>
<%@ include file="comunes/include-taglib.jspf"%>
<html>
<head>
	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" name="viewport"	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
	
	
</head>
<body>
	<%@ include file="comunes/include-cabecera.jsp"%>
	
	<script>
      //@code_start
      $(function(){
    	  
    	  
    	  var map = new jvm.Map({
 			  map: 'es_mill_en',
 	          container: $('#map'),
 			  backgroundColor: '#4baad6',
 			  zoomButtons: false,
 			  zoomOnScroll: false,
 			  zoomOnScrollSpeed: 3,
 			  panOnDrag: true,
 			  zoomMax: 8,
 			  zoomMin: 1,
 			  zoomStep: 1.6,
 			  zoomAnimate: true,
 			  regionsSelectable: true,
 			  markersSelectable: false,
 			  bindTouchEvents: true,
 			  regionStyle: {
 			    initial: {
 			      fill: 'white',
 			      "fill-opacity": 1,
 			      stroke: 'none',
 			      "stroke-width": 0,
 			      "stroke-opacity": 1
 			    },
 			    hover: {
 			      "fill-opacity": 0.8,
 			      cursor: 'pointer'
 			    },
 			    selected: {
 			      fill: 'yellow'
 			    },
 			    selectedHover: {
 			    }
 			  },
 			  regionLabelStyle: {
 			    initial: {
 			      'font-family': 'Verdana',
 			      'font-size': '12',
 			      'font-weight': 'bold',
 			      cursor: 'default',
 			      fill: 'black'
 			    },
 			    hover: {
 			      cursor: 'pointer'
 			    }
 			  },
 			  markerStyle: {
 			    initial: {
 			      fill: 'grey',
 			      stroke: '#505050',
 			      "fill-opacity": 1,
 			      "stroke-width": 1,
 			      "stroke-opacity": 1,
 			      r: 5
 			    },
 			    hover: {
 			      stroke: 'black',
 			      "stroke-width": 2,
 			      cursor: 'pointer'
 			    },
 			    selected: {
 			      fill: 'blue'
 			    },
 			    selectedHover: {
 			    }
 			  },
 			 onRegionSelected: function(event, code, isSelected, selectedRegions){
				$("#provincia").val(selectedRegions);
 			 }
		});
       

      });
      
      
      buscar = function(){
    	
    	  var descripcion = $("#descripcion").val();
    	  var provincias = $("#provincia").val();
    	  var categoria = $("#categorias").val();
    	  
    	  $("#categoria2").load("/canjehoras/buscador/buscar.html?descripcion="+escape(descripcion)+"&provincias="+provincias+"&categoria="+categoria, function(){
    		  
    		  $('html, body').animate({
	  		        scrollTop: $("#categoria2").offset().top - 170
	  		  }, 1000);
    		  
    	  });
    	  
      };
      
      
      $(document).ready(function() {
    	  seleccionado('toggle-buscador');
      });
     
    </script>
    
    
	<script type="text/javascript" src="../js/jquery-jvectormap-2.0.2.min.js"></script>
	<script type="text/javascript" src="../js/spain.js"></script>
	
	<link href="../css/jquery-jvectormap-2.0.2.css" rel="stylesheet" type="text/css">
    
	<section id="categoria" class="content">
			<h1>Seleccione la provincia y la categoría para encontrar los canjes que desees</h1>
			<div id="map" class="mapa" style="height: 450px"></div>
			
			<div id="mapaCombo" class="mapaCombo">
				<%-- <div class="tituloSelect"><fmt:message key="nuevo.trueque.categoria"/></div>	 --%>
				<form action="/canjehoras/login/envioRegistro.html" method="post" accept-charset="UTF-8">
					<select name="categorias" id="categorias" required="required">
						<option value="-1"><fmt:message key="nuevo.trueque.seleccione.categoria" /></option>
			            <c:forEach var="categoria" items="${categorias}">
			                    <option value="${categoria.id}" <c:if test="${categoria.id == trueque.categoria.id}">selected</c:if>>${categoria.descripcion}</option>
			            </c:forEach>
			        </select>
			        
			        <input type="text" title="Introduzca una descripcion" name="descripcion" id="descripcion" placeholder="Introduzca una descripcion" /> 
			        
			        <input type="hidden" id="provincia" name="provincia"/>
			        
			        <input type="button" onclick="buscar();" value="<fmt:message key="boton.enviar"/>" style="width: 100%"/>
		        </form>
			</div>
	</section>

	<section id="categoria2" class="content">
	</section>



	<%@ include file="comunes/include-pie.jsp"%>
</body>
</html>