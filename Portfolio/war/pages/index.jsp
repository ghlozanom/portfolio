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

<!-- Import of styles created for this application -->
<link rel="stylesheet" type="text/css" media="all" href="style/portfolio.css">
<!--[if lt IE 9]>
	<script src="js/html5.js" type="text/javascript"></script>
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
  <header role="banner" class="site_header" id="header">
    <div class="social_links">
      <ul>
        <li class="fb"><a href="https://www.facebook.com/gabloz" target="_blank" title="Facebook">Facebook</a></li>
        <li class="gplus"><a href="https://plus.google.com/u/0/+GabrielLozano1981" target="_blank" title="Google+">Google+</a></li>
        <li class="lnkd"><a href="http://www.linkedin.com/pub/gabriel-hernando-lozano-mart%C3%ADnez/12/803/a27" target="_blank" title="Linkedin">Linkedin</a></li>
      </ul>
    </div>
  </header>
  <div id="main" >
    <div class="content_area" id="primary">
      <div role="main" class="site_content" id="content">
        <section class="section profile_section first odd" id="profile"> <a id="blog_page_link" href="blog-category-arhive.html"><span class="icon-pencil icon"></span><span class="label">Blog</span></a>
          <div class="section_header profile_section_header opened">
            <h2 class="section_title profile_section_title vis"><a href="#"><span class="icon icon-user"></span><span class="section_name">Profile</span></a><span class="section_icon"></span></h2>
            <div id="profile_header">
              <div id="profile_user">
                <div id="profile_photo">
                	<c:choose>
                	<c:when test="${hasImage}">
				  		<img src="/getBlobForKey?blobKey=${mainImageKey}" alt="Gabriel Lozano" />
				  	</c:when>
				  	<c:otherwise>
				  		<img src="http://placehold.it/117x117" alt="Insert a Photo" />
				  	</c:otherwise>
				  	</c:choose> 
                	<a href="#" id="editPhotoLink" >Edit Photo</a>              	
                </div>
                <div id="profile_name_area">
                  <div id="profile_name">
                    <h1 id="profile_title"><span class="firstname">Gabriel</span> <span class="lastname">Lozano</span></h1>
                    <h4 id="profile_position">Software Engineer</h4>
                  </div>                
                </div>  
                <div id="editPhotoDiv" style="display: none; clear: both; padding-top: 20px; padding-bottom: 20px;"> 
				  	<form action="${uploadUrl}" method="post" enctype="multipart/form-data">
				  		<label for="description">Description:</label>
				  		<input type="text" name="description" id="description" /><br /><br />
				  		<label for="upload">File:</label>
				  		<input type="file" name="upload" /><c:if test="${noImageSelected}"><span class="error errorSign"></span></c:if><br /><br />
				  		<input type="submit" value="Upload File" />
				  	</form>    
				  	<c:if test="${noImageSelected}">
				  		<div>
				  			<span class="error noImageSelectedError"></span>
				  		</div>
				  	</c:if>
				  	<c:if test="${hasImage}">
				  		<a href="${deleteMainImgPath}" id="deletePhotoLink" >Delete Photo</a><br />
				  	</c:if>  
				  	<a href="#" id="closePhotoLink" >Hide Photo Edit</a>        
				</div>             
              </div>
              <div id="profile_data">
                <div class="profile_row name"> <span class="th">Name:</span><span class="td">Gabriel Lozano</span> </div>
                <div class="profile_row birth"> <span class="th">Date of birth:</span><span class="td">May 24, 1981</span> </div>
                <div class="profile_row address"> <span class="th">Address:</span><span class="td">Gerhardstr.21, 81543 Muenchen, DE</span> </div>
                <div class="profile_row phone"> <span class="th">Phone:</span><span class="td">+49-(0)-176-613-94-295</span> </div>
                <div class="profile_row email"> <span class="th">Email:</span><span class="td">ghlozanom-at-gmail.com</span> </div>
                <div class="profile_row website"> <span class="th">Website:</span><span class="td"><a target="_blank" href="http://ghlozanom.appspot.com/portfolio">http://ghlozanom.appspot.com/portfolio</a></span> </div>
              </div>
            </div>
          </div>
          <div class="section_body profile_section_body">
            <div class="proile_body">
            	Enthusiastic and quick learner Software Engineering masters graduate under the Erasmus Mundus scholarship program, 
            	 with five years of web development experience for the financial and automotive industries both in Colombia and Germany. 
            	 Expert in the Java programming language (Certified Programmer), experience in the Business and the UI Layers, 
            	 including client-side technologies(Javascript, HTML and CSS). Mother tongue Spanish, fluent in English and 
            	 very good knowledge of German.
 			</div>
          </div>
        </section>
        <div id="mainpage_accordion_area"> 
          
          <!-- RESUME -->
          <section class="section resume_section even" id="resume">
            <div id="resume_buttons"> <a target="_blank" id="resume_link" href="print.html"><span class="label">Print</span><span class="icon-print icon"></span></a> <a target="_blank" id="resume_link_download"><span class="label">Download</span><span class="icon-download icon"></span></a> </div>
            <div class="section_header resume_section_header">
              <h2 class="section_title resume_section_title"><a href="#"><span class="icon icon-align-left"></span><span class="section_name">Resume</span></a><span class="section_icon"></span></h2>
            </div>
            <div class="section_body resume_section_body">
              <div class="sidebar resume_sidebar">
                <aside class="widget widget_skills">
                  <h3 class="widget_title">Programming skills</h3>
                  <div class="widget_inner style_1">
                    <div class="skills_row odd first"><span class="caption">Wordpress</span><span class="progressbar"><span data-process="90%" class="progress blue"><span class="value">90%</span></span></span></div>
                    <div class="skills_row even"><span class="caption">PHP</span><span class="progressbar"><span data-process="80%" class="progress aqua"><span class="value">80%</span></span></span></div>
                    <div class="skills_row odd"><span class="caption">HTML</span><span class="progressbar"><span data-process="93%" class="progress green"><span class="value">93%</span></span></span></div>
                    <div class="skills_row even"><span class="caption">CSS</span><span class="progressbar"><span data-process="80%" class="progress yellow"><span class="value">80%</span></span></span></div>
                    <div class="skills_row odd"><span class="caption">MySQL</span><span class="progressbar"><span data-process="70%" class="progress red"><span class="value">70%</span></span></span></div>
                  </div>
                </aside>
                <aside class="widget widget_skills">
                  <h3 class="widget_title">Graphic Skills</h3>
                  <div class="widget_inner style_2">
                    <div class="skills_row odd"><span class="legend blue"></span><span class="caption">Adobe Photoshop</span></div>
                    <div class="skills_row even"><span class="legend aqua"></span><span class="caption">Adobe Illustrator</span></div>
                    <div class="skills_row odd"><span class="legend green"></span><span class="caption">Adobe Indesign</span></div>
                    <div class="skills_row even"><span class="legend yellow"></span><span class="caption">Corel Draw</span></div>
                    <div class="skills_row odd"><span class="legend red"></span><span class="caption">3D Max</span></div>
                    <div class="svg"> <svg xmlns="http://www.w3.org/2000/svg" class="piechart">
                      <path d="M66,66 L130,66  A64,64 0 0,1 57,129 z" fill="#327ea3"></path>
                      <path d="M66,66 L57, 129 A64,64 0 0,1 2,60 z" fill="#4ca5d0"></path>
                      <path d="M66,66 L2,  60  A64,64 0 0,1 34,11 z" fill="#6ca338"></path>
                      <path d="M66,66 L34, 11  A64,64 0 0,1 103,14 z" fill="#ffbc38"></path>
                      <path d="M66,66 L103,14  A64,64 0 0,1 130,66 z" fill="#e82c0c"></path>
                      <circle cx="66" cy="66" r="40" fill="#ffffff"></circle>
                      </svg> </div>
                  </div>
                </aside>
                <aside class="widget widget_skills" >
                  <h3 class="widget_title">Language skills</h3>
                  <div class="widget_inner style_3">
                    <div class="skills_row odd first"><span class="caption">English</span><span class="progressbar"><span data-process="80%" class="progress aqua"></span></span></div>
                    <div class="skills_row even"><span class="caption">French</span><span class="progressbar"><span data-process="60%" class="progress green"></span></span></div>
                    <div class="skills_row odd"><span class="caption">Spain</span><span class="progressbar"><span data-process="80%" class="progress yellow"></span></span></div>
                  </div>
                </aside>
              </div>
              <div class="wrapper resume_wrapper">
                <div class="category resume_category resume_category_1 first even">
                  <div class="category_header resume_category_header">
                    <h3 class="category_title"><span class="category_title_icon aqua"></span>Employment</h3>
                  </div>
                  <div class="category_body resume_category_body">
                    <article class="post resume_post resume_post_1 first even">
                      <div class="post_header resume_post_header">
                        <div class="resume_period"> <span class="period_from">2012</span> - <span class="period_to">present</span> </div>
                        <h4 class="post_title"><span class="post_title_icon aqua"></span><a href="post-text.html">Teamware GmbH</a></h4>
                        <h5 class="post_subtitle">Java Developer</h5>
                      </div>
                      <div class="post_body resume_post_body">
                        <p>
	                        <ul>
	                        	<li>Implementation and maintenance of existent software applications in the Java EE platform for an automotive company
	                         as well as for internal use.</li>
	                         	<li>Confirmation of new module requirements by reviewing its functionality, input data, and output requirements with 
	                         software analysts and clients.</li>
	                         	<li>Design and development of user interfaces to internet/intranet applications both in server side (i.e JSP and Servets)
	                         as well as in client side (CSS and Javascript).</li> 
	                         	<li>Design and development of the business logic and the code to access the backend, mainly Oracle Databases.
	                         Development of Reports in the form of PDF and Excel files.</li>
	                         	<li>Bug fixing for new as well as existing functionality.</li>
	                         </ul>
                        </p>
                      </div>
                    </article>
                    <article class="post resume_post resume_post_2 odd">
                      <div class="post_header resume_post_header">
                        <div class="resume_period"> <span class="period_from">2010</span> - <span class="period_to period_present">2011</span> </div>
                        <h4 class="post_title"><span class="post_title_icon aqua"></span><a href="post-text.html">AG Software Engineering</a></h4>
                        <h5 class="post_subtitle">Research Assistant (Hilfswissenschaftler)</h5>
                      </div>
                      <div class="post_body resume_post_body">
                        <div>
                        	<ul>
                        		<li>
                        			Design and implementation of an eclipse-based tool in Java for dependability modeling and 
                        			assessment, Essarel. Supports in particular the modeling and evaluation of fault
									trees. This tool is funded in part by Siemens Corporate Technology.
								</li>
                        	</ul>
                        </div>
                      </div>
                    </article>
                    <article class="post resume_post resume_post_2 odd">
                      <div class="post_header resume_post_header">
                        <div class="resume_period"> <span class="period_from">2006</span> - <span class="period_to period_present">2008</span> </div>
                        <h4 class="post_title"><span class="post_title_icon aqua"></span><a href="post-text.html">Open Card</a></h4>
                        <h5 class="post_subtitle">Q.A. Senior Developer, IT Department, Bogota, Colombia</h5>
                      </div>
                      <div class="post_body resume_post_body">
                        <div>
                        	<ul>
                        		<li>
                        			Migration of an application for managing credit cards, debit cards and revolving credits from Oracle Forms 
                        			technology to a J2EE environment, including a web front-end and business components.
								</li>                        	
                        		<li>
                        			Design and executive of functionality and performance test plans of the main application.
								</li>
								<li>
                        			Documentation of anomalies and issues.
								</li>
                        	</ul>
                        </div>
                      </div>
                    </article>      
                    <article class="post resume_post resume_post_2 odd">
                      <div class="post_header resume_post_header">
                        <div class="resume_period"> <span class="period_from">2005</span> - <span class="period_to period_present">2006</span> </div>
                        <h4 class="post_title"><span class="post_title_icon aqua"></span><a href="post-text.html">Edesa S.A.</a></h4>
                        <h5 class="post_subtitle">Java Programmer, Bogota, Colombia</h5>
                      </div>
                      <div class="post_body resume_post_body">
                        <div>
                        	<ul>
                        		<li>
                        			Migration of an application for managing credit cards, debit cards and revolving credits from Oracle Forms 
                        			technology to a J2EE environment, including a web front-end and business components.
								</li>
                        	</ul>
                        </div>
                      </div>
                    </article>                                                                        
                  </div>
                  <!-- .category_body --> 
                </div>
                <!-- .category -->
                <div class="category resume_category resume_category_2 odd">
                  <div class="category_header resume_category_header">
                    <h3 class="category_title"><span class="category_title_icon green"></span>Education</h3>
                  </div>
                  <div class="category_body resume_category_body">
                    <article class="post resume_post resume_post_1 first even">
                      <div class="post_header resume_post_header">
                        <div class="resume_period"> <span class="period_from">2008</span> - <span class="period_to">2011</span> </div>
                        <h4 class="post_title"><span class="post_title_icon green"></span><a href="post-text.html">TU Kaiserslautern - Germany, 
                        Universidad Politecnica de Madrid - Spain,</a></h4>
                        <h5 class="post_subtitle">Master of Science, Software Enginnering</h5>
                      </div>
                      <div class="post_body resume_post_body">
                        <div>
							<p>Double degree master course with Erasmus Mundus Scholarship funded by the European Union.</p>
							<p>Master thesis: A Traceability Model for Management of Service-Oriented Landscapes. </p>                       
                        </div>
                      </div>
                    </article>
                    <article class="post resume_post resume_post_2 odd">
                      <div class="post_header resume_post_header">
                        <div class="resume_period"> <span class="period_from">1996</span> - <span class="period_to">2000</span> </div>
                        <h4 class="post_title"><span class="post_title_icon green"></span><a href="post-text.html">Lorem Ipsum is simply dummy text</a></h4>
                        <h5 class="post_subtitle">Graphic design</h5>
                      </div>
                      <div class="post_body resume_post_body">
                        <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                      </div>
                    </article>
                  </div>
                  <!-- /category_body --> 
                </div>
                <!-- /category --> 
              </div>
              <!-- /wrapper --> 
            </div>
            <!-- /section_body --> 
          </section>
          <!-- /RESUME--> 
          
          <!-- PORTFOLIO -->
          <section class="section portfolio_section odd" id="portfolio">
            <div class="section_header portfolio_section_header">
              <h2 class="section_title portfolio_section_title"><a href="#"><span class="icon icon-briefcase"></span><span class="section_name">Portfolio</span></a><span class="section_icon"></span></h2>
            </div>
            <div class="section_body portfolio_section_body">
              <div class="portfolio_wrapper">
                <ul id="portfolio_iso_filters">
                  <li><a class="current" data-filter="*" href="#">All</a></li>
                  <li><a data-filter=".category_4" href="#">Web</a></li>
                  <li><a data-filter=".category_6" href="#">Photo</a></li>
                  <li><a data-filter=".category_5" href="#">Graphics</a></li>
                </ul>
                <div class="portfolio_items">
                  <article class="post portfolio_post portfolio_post_1 first even category_4 category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 14" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 14</a></h4>
                    <h5 class="post_subtitle">Web, Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_2 odd category_4 category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 13" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 13</a></h4>
                    <h5 class="post_subtitle">Web, Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_3 even category_4 category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 12" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 12</a></h4>
                    <h5 class="post_subtitle">Web, Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_4 odd category_4 category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 11" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 11</a></h4>
                    <h5 class="post_subtitle">Web, Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_5 even category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 15" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 15</a></h4>
                    <h5 class="post_subtitle">Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_6 odd category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio 10" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio 10</a></h4>
                    <h5 class="post_subtitle">Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_7 even category_4 category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio 9" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio 9</a></h4>
                    <h5 class="post_subtitle">Web, Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_8 odd category_4 category_5">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio 8" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio 8</a></h4>
                    <h5 class="post_subtitle">Web, Graphics</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_9 even category_5 category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio 7" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio 7</a></h4>
                    <h5 class="post_subtitle">Graphics, Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_10 odd category_4">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Lorem Ipsum" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Lorem Ipsum</a></h4>
                    <h5 class="post_subtitle">Web</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_11 even category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio 5" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio 5</a></h4>
                    <h5 class="post_subtitle">Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_12 odd category_4">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio 4" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio 4</a></h4>
                    <h5 class="post_subtitle">Web</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_13 even category_5">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 3" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 3</a></h4>
                    <h5 class="post_subtitle">Graphics</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_14 odd category_6">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 2" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 2</a></h4>
                    <h5 class="post_subtitle">Photo</h5>
                  </article>
                  <article class="post portfolio_post portfolio_post_15 even category_1 category_5">
                    <div class="post_pic portfolio_post_pic"> <a class="w_hover img-link img-wrap" href="http://placehold.it/800x400"> <span class="overlay"></span> <span class="link-icon"></span> <img src="http://placehold.it/252x174" alt="Portfolio item 15" /> </a> </div>
                    <h4 class="post_title"><a href="portfolio.html">Portfolio item 1</a></h4>
                    <h5 class="post_subtitle">Web, Graphics</h5>
                  </article>
                </div>
                <div class="portfolio_iso_pages">
                  <ul id="portfolio_iso_pages">
                  </ul>
                  <div id="portfolio_iso_pages_2"> Page <span id="portfolio_iso_pages_current">1</span> of <span id="portfolio_iso_pages_total"></span> </div>
                </div>
              </div>
            </div>
            <!-- .section_body --> 
          </section>
          <!-- /PORTFOLIO --> 
          
          <!-- CONTACTS -->
          <section class="section contact_section even" id="contact">
            <div class="section_header contact_section_header">
              <h2 class="section_title contact_section_title"><a href="#"><span class="icon icon-envelope-alt"></span><span class="section_name">Contacts</span></a><span class="section_icon"></span></h2>
            </div>
            <div class="section_body contact_section_body">
              <div id="googlemap_data">
                <div id="sc_googlemap" style="width:100%;height:294px;" class="sc_googlemap"></div>
                <div class="add_info">
                  <div class="profile_row header "> Contact info </div>
                  <div class="profile_row address"> <span class="th">Address</span><span class="td"></span> </div>
                  <div class="profile_row phone"> <span class="th">Phone</span><span class="td"></span> </div>
                  <div class="profile_row email"> <span class="th">Email</span><span class="td"></span> </div>
                  <div class="profile_row website"> <span class="th">Website</span><span class="td"></span> </div>
                </div>
              </div>
              <div class="sidebar contact_sidebar">
                <aside class="widget widget_qrcode_vcard" id="qrcode-vcard-widget-2">
                  <h3 class="widget_title">VCARD</h3>
                  <div class="widget_inner">
                    <div class="qrcode"></div>
                  </div>
                </aside>
              </div>
              <div class="contact_form">
                <div class="contact_form_data">
                  <div class="sc_contact_form">
                    <h3 class="title">Let's keep in touch</h3>
                    <form action="${contactPath}" method="post" id="add-comment-form" >
                      <div class="field">
                        <label class="required" for="sc_contact_form_username">Name</label>
                        <input type="text" name="nameSender" id="sc_contact_form_username" />
                      </div>
                      <div class="field">
                        <label class="required" for="sc_contact_form_email">Email</label>
                        <input type="text" name="emailSender" id="sc_contact_form_email" />
                      </div>
                      <div class="field message">
                        <label class="required" for="sc_contact_form_message">Your Message</label>
                        <textarea name="message" id="sc_contact_form_message"></textarea>
                      </div>
                      <div class="button"> <a id="add-comment-link" class="enter" href="#"><span>Submit</span></a> </div>
                    </form>
                    <div class="result sc_infobox"></div>
                  </div>
                </div>
              </div>
            </div>
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

<!-- connect js -->  
<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/jquery.tools.custom.js"></script> 
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


</body>
</html>
