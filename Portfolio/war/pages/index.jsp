<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Gabriel Lozano's Portfolio</title>

<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico"/>
<!-- Import of styles from the template -->
<link rel="stylesheet" type="text/css" media="all" href="style/style.css">
<link rel="stylesheet" type="text/css" media="all" href="style/responsive.css">

<link href="style/redmond/jquery-ui-1.10.4.custom.css" rel="stylesheet">

<!-- Import of styles created for this application -->
<link rel="stylesheet" type="text/css" media="all" href="style/portfolio.css">

<!-- Import of styles created for all my applications -->
<link rel="stylesheet" type="text/css" media="all" href="style/gabloz.css">

<!--[if lt IE 9]>
	<script src="js/html5.js" type="text/javascript"></script>
<![endif]-->

<!-- connect js -->  
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.flexslider.min.js"></script> 
<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="js/jquery.isotope.min.js"></script> 
<script type="text/javascript" src="js/jquery.cookie.js"></script> 
<script type="text/javascript" src="js/mediaelement.min.js"></script> 
<script type="text/javascript" src="js/jquery.qrcode-0.6.0.min.js"></script> 
<script type="text/javascript" src="js/googlemap_init.js"></script> 
<script type="text/javascript" src="js/jquery.easing.js"></script> 
<script type="text/javascript" src="js/jquery.reject.js"></script> 
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
<script type="text/javascript" src="js/utils.js"></script> 
<script type="text/javascript" src="js/lib.js"></script>
<script type="text/javascript" src="js/portfolio.js"></script>

<script type="text/javascript" src="js/noty/packaged/jquery.noty.packaged.min.js"></script>

<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.tools.custom.js"></script> 

<script>
	jQuery(document).ready(function(){
		<c:if test="${noImageSelected}">		
		    noImageSelected();
		</c:if> 
		
		<c:if test="${existsErrorMessage}">
			showErrorMessage('${errorMessage}');		
		</c:if>
	
		<c:if test="${existSuccessMessage}">
			showSuccessMessage('${successMessage}');		
		</c:if>										
		   
	});
</script>

</head>
<body class="home blog dark">
<div class="switherHead"></div>
<div class="colored">
  <div class="blue"></div>
  <div class="aqua"></div>
  <div class="green"></div>
  <div class="yellow"></div>
  <div class="red"></div>
</div>
<div class="hfeed site" id="page">

  <jsp:include page="/pages/profile/social_links.jsp" /> 

  <div id="main" >
    <div class="content_area" id="primary">
      <div role="main" class="site_content" id="content">
      	
        <jsp:include page="/pages/profile.jsp" /> 
      
        <div id="mainpage_accordion_area"> 
          
          <!-- RESUME -->
          <section class="section resume_section even" id="resume">
            <div id="resume_buttons"> <a id="resume_link" href="javascript: showInfoMessage('Coming soon!')"><span class="label">Print</span><span class="icon-print icon"></span></a> <a id="resume_link_download" href="javascript: showInfoMessage('Coming soon!')"><span class="label">Download</span><span class="icon-download icon"></span></a> </div>
            <div class="section_header resume_section_header">
              <h2 class="section_title resume_section_title"><a href="#"><span class="icon icon-align-left"></span><span class="section_name">Resume</span></a><span class="section_icon"></span></h2>
            </div>
            <div class="section_body resume_section_body">

				<jsp:include page="/pages/resume_sidebar.jsp" />

              
				<div class="wrapper resume_wrapper">
				
					   <jsp:include page="/pages/employment.jsp" /> 
				        
				       <jsp:include page="/pages/education.jsp" /> 
				    
				</div>
				
              	<!-- /wrapper --> 
            </div>
            <!-- /section_body --> 
          </section>
          <!-- /RESUME--> 
          
          <!-- PORTFOLIO -->
          <section class="section portfolio_section odd" id="portfolio">
          	
          	<jsp:include page="/pages/portfolio_section.jsp" /> 
          	
          </section>
          <!-- /PORTFOLIO --> 
          
          <!-- CONTACTS -->
          <section class="section contact_section even" id="contact">

			<jsp:include page="/pages/contacts.jsp" /> 

            <!-- .section_body --> 
          </section>
          <!-- /CONTACT --> 
        </div>
        <!-- #mainpage_accordion_area --> 
      </div>
      <!-- #content --> 
    </div>
    <!-- #primary -->
    
  </div>
  <!-- #main -->
  
  <footer role="contentinfo" class="site_footer" id="footer">
    <div class="footer_copyright"> ThemeREX &copy; 2013 All Rights Reserved </div>
  </footer>
</div>
<!-- #page --> 




</body>
</html>