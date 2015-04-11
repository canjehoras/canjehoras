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
 			  onRegionClick: function(event, index){
 				//alert(index);
 		  	  }
		});
       

      })
      //@code_end
    </script>
    
    
	<script type="text/javascript" src="../js/jquery-jvectormap-2.0.2.min.js"></script>
	<script type="text/javascript" src="../js/spain.js"></script>
	
	<link href="../css/jquery-jvectormap-2.0.2.css" rel="stylesheet" type="text/css">
    
	
	
	
	
	
	
	<section id="Categoria" class="content">
		<div id="map" style="height: 500px"></div>
		<%-- <div class="container categoria_title"></div>
		<div class="categoria-top"></div>
		<div class="categoria">
			<div id="filters" class="sixteen columns">
				<ul class="clearfix">
					<li><a id="all" href="#" data-filter="*" class="active">
							<h5>
								<fmt:message key="etiqueta.todo" />
							</h5>
					</a></li>
					<c:forEach var="categoria" items="${categorias}">
						<li><a class="" href="#" data-filter=".${categoria.id}">
								<h5>${categoria.descripcion}</h5>
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="portfolio_btm"></div>
		<div id="project_container">
			<div class="clear"></div>
			<div id="project_data"></div>
		</div>
	</section> --%>


	<section id="Categoria2" class="content">
		  <div class="container">
			<c:set var="primero" value="true"/>
			<c:forEach var="trueques" items="${trueques}" varStatus="count" >
				<c:choose>
					<c:when test="${primero}">
						<div class="service_wrapper">
						<div class="row borderTop">
				 		<div class="col-lg-4 mrgTop">
				 		<c:set var="primero" value="false"/>
				 	</c:when>
				 	<c:otherwise>
				 		<div class="col-lg-4 borderLeft mrgTop">
				 	</c:otherwise>
				</c:choose>
				<div class="service_block">
				  	<div class="service_icon delay-03s animated wow  zoomIn"> <span><i class="fa fa-dropbox"></i></span> </div>
				  	<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
				  	<p class="animated fadeInDown wow">${trueques.categoria.descripcion}</p>
				  	<p class="animated fadeInDown wow">${trueques.descripcion}</p>
				  	<input type="button" value="<fmt:message key="boton.ver.mas"/>" onclick="detalleTrueque(${trueques.id});"/>
				</div>
			</div>
		   	<c:if test="${(count.count % 3) == 0}">
		   		<c:set var="primero" value="true"/>
		   		</div>
		   		</div>
		   	</c:if>
			</c:forEach>
		</div>
	</section>



	<%@ include file="comunes/include-pie.jsp"%>
</body>
</html>