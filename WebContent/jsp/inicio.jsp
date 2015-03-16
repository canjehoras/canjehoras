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

<section id="hero_section" class="top_cont_outer">
  <div class="hero_wrapper">
    <div class="container">
      <div class="hero_section">
        <div class="row">
          <div class="col-lg-5 col-sm-7">
            <div class="top_left_cont zoomIn wow animated"> 
              <h2>We create <strong>awesome</strong> web templates</h2>
              <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text  printer took a galley of type and scrambled it to make a type specimen.</p>
              <a href="#service" class="read_more2">Read more</a> </div>
          </div>
          <div class="col-lg-7 col-sm-5">
			<img src="../img/main_device_image.png" class="zoomIn wow animated" alt="" />
		  </div>
        </div>
      </div>
    </div>
  </div>

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>