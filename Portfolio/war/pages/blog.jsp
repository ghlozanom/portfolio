<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Gabriel Lozano's Blog</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico"/>
<link rel="stylesheet" type="text/css" media="all" href="/style/style.css">
<link rel="stylesheet" type="text/css" media="all" href="/style/responsive.css">
<!--[if lt IE 9]>
	<script src="/js/html5.js" type="text/javascript"></script>
<![endif]-->
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
  
  <div id="main"  class="right_sidebar">
    <section id="profile" class="section profile_section odd first blog_page"> <a href="/" id="profile_page_link"><span class="icon-user icon"></span><span class="label">Profile</span></a>
      <div class="section_header profile_section_header">
        <div id="profile_header">
          <div id="profile_user">
            
            <jsp:include page="/pages/profile/profile_name.jsp" />
            
          </div>
        </div>
      </div>
    </section>
    <section id="breadcrumbs" class="section breadcrumbs_section even">
      <div class="section_header breadcrumbs_section_header">
        <ul class="breadcrumbs">
          <li class="home"><a href="/">Home</a></li>
          <li class="current">All Posts</li>
        </ul>
      </div>
    </section>
    <div id="primary" class="content_area">
      <div id="content" class="site_content blog_content" role="main">
      
      <c:forEach items="${posts}" var="post">
        <section class="section blog_section odd">
          <div class="section_header blog_section_header ">
            <h2 class="section_title blog_section_title"><strong><span class="icon icon-pencil"></span><span class="section_name">${post[0]}</span></strong></h2>
          </div>
          <div class="section_body blog_section_body">
            <article class="post ">
              <h3 class="post_title"><a href="#">${post[1]}</a></h3>
              
              <div class="text">             
				    ${post[2]}                        
              </div>
            </article>
          </div>
        </section>
		</c:forEach>
        
        <jsp:include page="/pages/blog/navigation.jsp" />
        
      </div>
      <!-- #content --> 
    </div>
    <!-- #primary -->
    
    <div id="secondary" class="widget_area sidebar_blog right_sidebar sidebar-blog" role="complementary"> 
    
      <jsp:include page="/pages/blog/categories.jsp" />
      
      <jsp:include page="/pages/blog/recent_posts.jsp" />
      
      <jsp:include page="/pages/blog/tags.jsp" />
      
      <jsp:include page="/pages/blog/calendar.jsp" />
      
      <jsp:include page="/pages/blog/recent_comments.jsp" />
      
      <jsp:include page="/pages/blog/archives.jsp" /> 
      
      <jsp:include page="/pages/blog/twitter_feed.jsp" />
      
      <jsp:include page="/pages/blog/meta.jsp" />
      
    </div>
  </div>
  
  <!-- #main -->
  
  <footer role="contentinfo" class="site_footer" id="footer">
    <div class="footer_copyright"> ThemeREX &copy; 2013 All Rights Reserved </div>
  </footer>
</div>
<!-- #page --> 

<!-- connect js --> 
<script type="text/javascript" src="/js/jquery.min.js"></script> 
<script type="text/javascript" src="/js/jquery.tools.custom.js"></script> 
<script type="text/javascript" src="/js/jquery.flexslider.min.js"></script> 
<script type="text/javascript" src="/js/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="/js/jquery.isotope.min.js"></script> 
<script type="text/javascript" src="/js/jquery.cookie.js"></script> 
<script type="text/javascript" src="/js/mediaelement.min.js"></script> 
<script type="text/javascript" src="/js/jquery.qrcode-0.6.0.min.js"></script> 
<script type="text/javascript" src="/js/googlemap_init.js"></script> 
<script type="text/javascript" src="/js/jquery.easing.js"></script> 
<script type="text/javascript" src="/js/jquery.reject.js"></script> 
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
<script type="text/javascript" src="/js/utils.js"></script> 
<script type="text/javascript" src="/js/lib.js"></script>
</body>
</html>
