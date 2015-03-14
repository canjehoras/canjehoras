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
</section>

<!-- Categorias -->
<section id="Categorias" class="content"> 
  
  <!-- Container -->
  <div class="container categoria_title"> 
    
    <!-- Title -->
    <div class="section-title">
      <h2>Portfolio</h2>
    </div>
    <!--/Title --> 
    
  </div>
  <!-- Container -->
  
  <div class="portfolio-top"></div>
  
  <!-- Portfolio Filters -->
  <div class="portfolio"> 
    
    <div id="filters" class="sixteen columns">
      <ul class="clearfix">
        <li><a id="all" href="#" data-filter="*" class="active">
          <h5>All</h5>
          </a></li>
        <li><a class="" href="#" data-filter=".prototype">
          <h5>Prototype</h5>
          </a></li>
        <li><a class="" href="#" data-filter=".design">
          <h5>Design</h5>
          </a></li>
        <li><a class="" href="#" data-filter=".android">
          <h5>Android</h5>
          </a></li>
        <li><a class="" href="#" data-filter=".appleIOS">
          <h5>Apple IOS</h5>
          </a></li>
        <li><a class="" href="#" data-filter=".web">
          <h5>Web App</h5>
          </a></li>
      </ul>
    </div>
    <!--/Portfolio Filters --> 
    
    <!-- Portfolio Wrapper -->
    <div class="isotope fadeInLeft animated wow" style="position: relative; overflow: hidden; height: 480px;" id="portfolio_wrapper"> 
      
      <!-- Portfolio Item -->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(0px, 0px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four   appleIOS isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic1.jpg"  alt="Portfolio 1"> </div>        
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">SMS Mobile App</h4>
          </div>
        </div>
        </div>
      <!--/Portfolio Item --> 
      
      <!-- Portfolio Item-->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(337px, 0px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four  design isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic2.jpg" alt="Portfolio 1"> </div>
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">Finance App</h4>
          </div>
        </div>
      </div>
      <!--/Portfolio Item --> 
      
      <!-- Portfolio Item -->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(674px, 0px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four  design  isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic3.jpg" alt="Portfolio 1"> </div>
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">GPS Concept</h4>
          </div>
        </div>
      </div>
      <!--/Portfolio Item--> 
      
      <!-- Portfolio Item-->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(1011px, 0px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four  android  prototype web isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic4.jpg" alt="Portfolio 1"> </div>
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">Shopping</h4>
          </div>
        </div>
      </div>
      <!-- Portfolio Item --> 
      
      <!-- Portfolio Item -->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(0px, 240px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four  design isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic5.jpg" alt="Portfolio 1"> </div>
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">Managment</h4>
          </div>
        </div>
      </div>
      <!--/Portfolio Item --> 
      
      <!-- Portfolio Item -->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(337px, 240px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four  web isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic6.jpg" alt="Portfolio 1"> </div>
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">iPhone</h4>
          </div>
        </div>
      </div>
      <!--/Portfolio Item --> 
      
      <!-- Portfolio Item  -->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(674px, 240px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four  design web isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic7.jpg" alt="Portfolio 1"> </div>       
        <div class="item_overlay">
          <div class="item_info"> 
            <h4 class="project_name">Nexus Phone</h4>
          </div>
        </div>
       </div>
      <!--/Portfolio Item --> 
      
      <!-- Portfolio Item -->
      <div style="position: absolute; left: 0px; top: 0px; transform: translate3d(1011px, 240px, 0px) scale3d(1, 1, 1); width: 337px; opacity: 1;" class="portfolio-item one-four   android isotope-item">
        <div class="portfolio_img"> <img src="img/portfolio_pic8.jpg" alt="Portfolio 1"> </div>       
        <div class="item_overlay">
          <div class="item_info"> 
				<h4 class="project_name">Android</h4>
          </div>
        </div>
        </a> </div>
      <!--/Portfolio Item --> 
      
    </div>
    <!--/Portfolio Wrapper --> 
    
  </div>
  <!--/Portfolio Filters -->
  
  <div class="portfolio_btm"></div>
  
  
  <div id="project_container">
    <div class="clear"></div>
    <div id="project_data"></div>
  </div>
 
  
</section>
<!--/Portfolio --> 

<%@ include file="comunes/include-pie.jsp" %>

</body>
</html>