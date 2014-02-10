package com.gabloz.portfolio.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.gae.helper.BlobHelper;
import com.gabloz.portfolio.web.helper.WebHelper;
import com.gabloz.portfolio.web.helper.WebImageHelper;

/**
 * Servlet for the main path ("/") of the portfolio app.
 * 
 * @author      Gabriel Lozano
 * */
public class PortfolioServlet extends HttpServlet {


	private static final long serialVersionUID = 4063774046835297817L;
	private static final Logger logger = Logger
			.getLogger(PortfolioServlet.class.getCanonicalName());

	/**
	 * Generates the upload URL to be used in the form so that the user
	 * is able to change the main profile picture. Also, if the user
	 * has already uploaded a picture, gets its key from the datastore
	 * so that the image can be retrieved. Home page (index.jsp) is 
	 * finally generated.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.log(Level.INFO, "Portfolio servlet doGet()");
		
		checkErrorMessages(request);
		checkConfirmationMessages(request);			

		//Sets the URL to upload the main image
		BlobHelper blobHelper = BlobHelper.getInstance();
		String uploadUrl = blobHelper.createUploadUrl();
		request.setAttribute("uploadUrl", uploadUrl);		
		
		//Setting of the attributes required to work with the main image
		WebImageHelper webImageHelper = WebImageHelper.getInstance();
		webImageHelper.setImageAttributesInRequest(request, true);
		
		//TODO insert comment here
		setAppPaths(request);
		
		//Home page is now generated
		RequestDispatcher jsp = request.getRequestDispatcher(WebHelper.HOME_PAGE);
		jsp.forward(request, response);

	}

	private void setAppPaths(HttpServletRequest request) {
		request.setAttribute(WebHelper.CONTACT_PATH, WebHelper.CONTACT_PATH_VALUE);
	}

	/**
	 * If a message was sent, a confirmation message must be set in the request
	 * 
	 * @param request
	 */
	private void checkConfirmationMessages(HttpServletRequest request) {
		
		String messageKey = request.getParameter(WebHelper.SUCCESS_PARAMETER_PATH);
		if( messageKey != null ){
			request.setAttribute(WebHelper.EXISTS_SUCCESS_MESSAGE, true);
			request.setAttribute(WebHelper.SUCCESS_MESSAGE, 
					MessageHelper.getInstance().getMessageForKey(messageKey) );
		}		
		
	}

	/**
	 * Check for problems in previous processes
	 * @param request
	 */
	private void checkErrorMessages(HttpServletRequest request) {	
		
		String error = request.getParameter(WebHelper.ERROR_PARAMETER_PATH);
		if( error != null ){
			request.setAttribute(WebHelper.EXISTS_ERROR_MESSAGE, true);
			request.setAttribute(WebHelper.ERROR_MESSAGE, 
					MessageHelper.getInstance().getMessageForKey(error) );
		}
	}

}
