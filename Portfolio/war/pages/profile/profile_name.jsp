<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div id="profile_photo">
    	<c:choose>
    	<c:when test="${hasImage}">
	  		<img src="/getBlobForKey?blobKey=${mainImageKey}" alt="Gabriel Lozano" />
	  	</c:when>
	  	<c:otherwise>
	  		<img src="http://placehold.it/117x117" alt="Insert a Photo" />
	  	</c:otherwise>
	  	</c:choose> 
	  	
		<c:if test="${editImage}">
	  		<a href="#" id="editPhotoLink" >Edit Photo</a>
	  	</c:if>	  	              	
    </div>

	<div id="profile_name_area">
	  <div id="profile_name">
	    <h1 id="profile_title"><span class="firstname">Gabriel</span> <span class="lastname">Lozano</span></h1>
	    <h4 id="profile_position">Software Engineer</h4>
	  </div>                
	</div> 
