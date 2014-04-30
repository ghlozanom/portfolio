package com.gabloz.portfolio.web.helper;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Web helper to manage Images
 * 
 * @author Gabriel Lozano
 *
 */
public class UserWebHelper {
	
	private static UserWebHelper instance = null;
	
	private UserWebHelper(){
	}
	
	public void setUserAuthenticated(HttpServletRequest req )  {		
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		if (user == null) {
			req.setAttribute("loginUrl", userService.createLoginURL("/"));
		} else {
			req.setAttribute("userNickname", user.getNickname());
			req.setAttribute("logoutUrl", userService.createLogoutURL(WebHelper.LOGOUT_URL) );
		}

		req.setAttribute(WebHelper.AUTHENTICATED_USER, user != null);
	}

	public static UserWebHelper getInstance() {
		if(instance == null ){
			instance =new UserWebHelper();
		}
		return instance;
	}
	
	public User getUser(){
		return UserServiceFactory.getUserService().getCurrentUser();
	}

}
