package com.gabloz.portfolio.web.helper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

/**
 * Provides helper methods to work with in the "Web" layer 
 * 
 * @author      Gabriel Lozano
 * */
public class WebHelper {
	
	private static WebHelper webHelper = null;
	
	private static final Logger logger = 
		Logger.getLogger(WebHelper.class.getCanonicalName());

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	public static final String UPLOAD = "upload";
	public static final String METHOD = "req";
	public static final String DELETE = "delete";
	public static final String KEY_PARAMETER_NAME = "key";
	

	public static final String HOME_PAGE = "/pages/index.jsp";
	
	public static final String MAIN_PAGE_SERVLET_PATH = "/";
	public static final String MAIN_IMAGE_SERVLET_PATH = "/mainImg";
	//URL of the servlet to manage a file upload
	public static final String MAIN_IMAGE_UPLOAD_SERVLET_PATH = "/mainImg?" + METHOD + "=" + UPLOAD;
	public static final String MAIN_IMAGE_DESCRIPTION_PARAMETER = "description";
	
	//parameter to be used to comunicate that there was an error
	public static final String ERROR_PARAMETER_PATH = "error";
	
	public static final String DELETE_MAIN_IMG_PATH = MAIN_IMAGE_SERVLET_PATH + "?req=" + DELETE + "&" + KEY_PARAMETER_NAME + "=";
	public static final String EXISTS_ERROR_MESSAGE = "existsErrorMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	
	//parameter used to comunicate the result key (to be retrieved later with a MessageHelper) 
	//of the last operation
	public static final String SUCCESS_PARAMETER_PATH = "result";
	public static final String EXISTS_SUCCESS_MESSAGE = "existSuccessMessage";
	public static final String SUCCESS_MESSAGE = "successMessage";

	public static final String CONTACT_PATH_VALUE = "/contact";
	public static final String CONTACT_PATH = "contactPath";

	public static final String BLOG_PAGE = "/pages/blog.jsp";

	public static final String POST_REQUESTED = "post";

	public static final String POST_LABELS = "labels";
	
	/**
	 * Returns a unique instance of this class (Singleton pattern)
	 * 
	 * @return a singleton BlobHelper instance
	 */
	public static WebHelper getInstance() {
		if(webHelper == null ){
			webHelper = new WebHelper();
		}
		return webHelper;
	}	
	
	/**
	 * Only accessible from the same class (Singleton pattern)
	 */
	private WebHelper(){
	}

	/**
	 * Configures de path for the sendRedirect with the parameters needed
	 * to set a message (error or success)
	 * 
	 * @param path path to redirect the request
	 * @param response the response object to redirect
	 * @param type the type of the message, success or error
	 * @param messageKey the key to be used to get the message text
	 * @throws IOException
	 */
	public void sendRedirectWithMessage(String path, HttpServletResponse response,
			String type, String messageKey) throws IOException {
		logger.log(Level.INFO, "SendRedirectWithMessage");
		if(WebHelper.SUCCESS.equals(type)){
			response.sendRedirect(path + "?" +
					SUCCESS_PARAMETER_PATH + "=" + messageKey);
			return;
		}
		if(WebHelper.ERROR.equals(type)){
			response.sendRedirect(path + "?" +
					ERROR_PARAMETER_PATH + "=" + messageKey);	
		}		
		
	}

}
