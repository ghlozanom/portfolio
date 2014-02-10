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
        <section class="section blog_section odd">
          <div class="section_header blog_section_header ">
            <h2 class="section_title blog_section_title"><strong><span class="icon icon-pencil"></span><span class="section_name">Jul.04</span></strong></h2>
            <div class="post-info"> <a href="author.html" class="post_author"><span class="icon-user"></span>admin</a> <a href="post-standart.html" class="comments_count"><span class="icon-comment"></span>0</a> <span class="post_categories"><span class="icon-align-left"></span><a href="blog-category-arhive.html" class="post_categories even first">Post</a></span> </div>
          </div>
          <div class="section_body blog_section_body">
            <article class="post ">
              <h3 class="post_title"><a href="post-standart.html">Quisque odio eros</a></h3>
              <div class="pic"> <a href="post-standart.html" class="w_hover img-link img-wrap"><img alt="Quisque odio eros" src="
http://placehold.it/510x300" /> <span class="overlay"></span> <span class="link-icon"></span> </a> </div>
              <div class="text">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
                <div class="readmore"><a href="post-standart.html" class="more-link"><span class="readmore">Read more</span></a></div>
              </div>
            </article>
          </div>
        </section>
        <section class="section blog_section even">
          <div class="section_header blog_section_header gallery">
            <h2 class="section_title blog_section_title"><strong><span class="icon icon-camera"></span><span class="section_name">Jul.03</span></strong></h2>
            <div class="post-info"> <a href="author.html" class="post_author"><span class="icon-user"></span>admin</a> <a href="post-slider.html" class="comments_count"><span class="icon-comment"></span>0</a> <span class="post_categories"><span class="icon-align-left"></span><a href="blog-category-arhive.html" class="post_categories even first last">Slider</a></span> </div>
          </div>
          <div class="section_body blog_section_body">
            <article class="post ">
              <h3 class="post_title"><a href="post-slider.html">Proin bibendum</a></h3>
              <div class="slider_container">
                <ul class="slides">
                  <li><a href="post-slider.html" class="w_hover"><img src="
http://placehold.it/510x250" alt="" /><span class="overlay"></span></a></li>
                  <li><a href="post-slider.html" class="w_hover"><img src="
http://placehold.it/510x250" alt="" /><span class="overlay"></span></a></li>
                  <li><a href="post-slider.html" class="w_hover"><img src="
http://placehold.it/510x250" alt="" /><span class="overlay"></span></a></li>
                </ul>
              </div>
              <div class="text">
                <p>Pellentesque luctus urna quis tellus tempus ultrices. Aenean varius pretium nisl, scelerisque mattis nibh laoreet id. Suspendisse nec auctor dolor, ac auctor dolor. </p>
                <div class="readmore"><a href="post-slider.html" class="more-link"><span class="readmore">Read more</span></a></div>
              </div>
            </article>
          </div>
        </section>
        
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
