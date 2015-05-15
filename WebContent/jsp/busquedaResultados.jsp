<%@ include file="comunes/include-taglib.jspf"%>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/jquery.nav.js"></script> 
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>


<h1>RESULTADOS DE LA BUSQUEDA</h1>

		<div class="container">
			<c:set var="primero" value="true"></c:set>
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
					<div class="service_icon delay-03s animated wow  zoomIn"> 
						<img src="data:image/jpg;base64,${trueques.imagen64}" style="max-height: 190px; border: 2px solid #4BAAD6;"/> 
					</div>
					<h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
					<p class="animated fadeInDown wow"><fmt:message key="listado.categoria"/>${trueques.categoria.descripcion}</p>
					<p class="animated fadeInDown wow"><fmt:message key="listado.provincia"/>${trueques.provincia.descripcion}</p>
					<p class="animated fadeInDown wow">OFERTA: ${trueques.descripcionOferta}</p>
					<p class="animated fadeInDown wow">DEMANDA: ${trueques.descripcionOferta}</p>
					<c:if test="${sessionScope.usuario == null}">
						<input type="button" value="<fmt:message key="boton.ver.mas"/>" onclick="detalleTrueque(${trueques.id});"/>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<input type="button" value="<fmt:message key="boton.editar"/>" onclick="editarTrueque(${trueques.id});"/>
						<input type="button" value="<fmt:message key="boton.borrar"/>" onclick="borrarTrueque(${trueques.id});"/>
					</c:if>
				</div>
		</div>
		
	  	<c:if test="${(count.count % 3) == 0}">
		<c:set var="primero" value="true"/>
		</div>
		</div>
		</c:if>
		</c:forEach>
	</div>