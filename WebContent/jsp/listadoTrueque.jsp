<!doctype html>
<%@ include file="comunes/include-taglib.jspf" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">
<title><fmt:message key="titulo"/></title>
</head>
<body>

<%@ include file="comunes/include-cabecera.jsp" %>

  <div class="container">
    <h2>Ultimos trueques publicados</h2>
    
	   	<c:forEach var="trueques" items="${trueques}">

    <div class="service_wrapper">
	   <div class="row borderTop">
        <div class="col-lg-4 mrgTop">
          <div class="service_block">
            <div class="service_icon delay-03s animated wow  zoomIn"> <span><i class="fa fa-dropbox"></i></span> </div>
            <h3 class="animated fadeInUp wow">${trueques.titulo}</h3>
            <p class="animated fadeInDown wow">${trueques.descripcion}</p>
          </div>
        </div>
        <div class="col-lg-4 borderLeft mrgTop">
          <div class="service_block">
            <div class="service_icon icon2  delay-03s animated wow zoomIn"> <span><i class="fa fa-slack"></i></span> </div>
            <h3 class="animated fadeInUp wow">User Research</h3>
            <p class="animated fadeInDown wow">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.</p>
          </div>
        </div>
        <div class="col-lg-4 borderLeft mrgTop">
          <div class="service_block">
            <div class="service_icon icon3  delay-03s animated wow zoomIn"> <span><i class="fa fa-users"></i></span> </div>
            <h3 class="animated fadeInUp wow">User Experience</h3>
            <p class="animated fadeInDown wow">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.</p>
          </div>
        </div>
      </div>
    </div>
    
    	   	</c:forEach>
  </div>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>