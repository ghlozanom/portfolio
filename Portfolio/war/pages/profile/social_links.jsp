<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <header role="banner" class="site_header" id="header">
    <div class="social_links">
      <ul>
        <li class="fb"><a href="https://www.facebook.com/gabloz" target="_blank" title="Facebook">Facebook</a></li>
        <li class="gplus"><a href="https://plus.google.com/u/0/+GabrielLozano1981" target="_blank" title="Google+">Google+</a></li>
        <li class="lnkd"><a href="https://www.linkedin.com/pub/gabriel-lozano/12/803/a27" target="_blank" title="Linkedin">Linkedin</a></li>
      </ul>
    </div>
    <div class="loginLink">
    	<c:if test="${!authenticatedUser}" >
    		<a href="${loginUrl}" >Log in with Google</a>
    	</c:if>    
    	<c:if test="${authenticatedUser}" >
    		Hi ${userNickname} - <a href="${logoutUrl}" >logout</a>
    	</c:if>
    </div>
  </header>
