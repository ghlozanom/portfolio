<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <div class="profile_row website"> <span class="th">Website:</span><span class="td"><a target="_blank" href="http://ghlozanom.appspot.com">http://ghlozanom.appspot.com</a></span> </div>
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

