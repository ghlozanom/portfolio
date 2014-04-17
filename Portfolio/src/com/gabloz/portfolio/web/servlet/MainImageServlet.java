package com.gabloz.portfolio.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.gae.helper.BlobHelper;
import com.gabloz.portfolio.gae.helper.UserHelper;
import com.gabloz.portfolio.model.Image;
import com.gabloz.portfolio.web.helper.UserWebHelper;
import com.gabloz.portfolio.web.helper.WebHelper;

/**
 * Servlet to be used to admin the main image (save and delete main image).
 * 
 * @author      Gabriel Lozano
 * */
public class MainImageServlet extends HttpServlet {

	private static final long serialVersionUID = 7801817058400189849L;	
	private static final Logger logger = Logger
			.getLogger(MainImageServlet.class.getCanonicalName());
	
	/**
	 * Method for the administration of an image. If the method parameter
	 * is DELETE, the main image in the datastore is removed.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 **/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		

		logger.log(Level.INFO, "MainImageServlet doGet()");
		WebHelper webHelper = WebHelper.getInstance();
		
		String method = request.getParameter(WebHelper.METHOD);
		
		if(WebHelper.DELETE.equals(method)){
			//request is made to delete the main image, it must be removed from the datastore
			//at the end the application is sent to the main page
			UserHelper userHelper = UserHelper.getInstance();
			try {
				userHelper.deleteMainImage(UserWebHelper.getInstance().getUser(), request.getParameter(WebHelper.KEY_PARAMETER_NAME));
				//Sets an entity deleted with success message and redirects
				webHelper.sendRedirectWithMessage(WebHelper.MAIN_PAGE_SERVLET_PATH,
						response, WebHelper.SUCCESS, MessageHelper.IMG_DELETED_SUCCESSFULY);
			} catch (PortfolioBusinessException e) {
				webHelper.sendRedirectWithMessage(WebHelper.MAIN_PAGE_SERVLET_PATH,
						response, WebHelper.ERROR, e.getMessageKey());
			}	
		}		
		
	}	
	

	/**
	 * Method for the administration of an image. If the method parameter
	 * is UPLOAD, the main image chosen by the user muss be saved in the
	 * datastore.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.log(Level.INFO, "MainImageServlet's doGet()");
		WebHelper webHelper = WebHelper.getInstance();
		
		String method = request.getParameter(WebHelper.METHOD);
		
		if(WebHelper.UPLOAD.equals(method)){
			//request is made to upload an image, it must be saved in the datastore
			UserHelper userHelper = UserHelper.getInstance();
			try {
				//Creates an image object with the data sent from the request
				Image mainImage = getImage(request);
				userHelper.saveMainImage(mainImage);
				//After the image is saved, the user is redirected to the main page 
				//with a message of success
				webHelper.sendRedirectWithMessage(WebHelper.MAIN_PAGE_SERVLET_PATH,
						response, WebHelper.SUCCESS, MessageHelper.IMAGE_UPLOAD_SUCCESS);
			} catch (PortfolioBusinessException e) {
				webHelper.sendRedirectWithMessage(WebHelper.MAIN_PAGE_SERVLET_PATH,
						response, WebHelper.ERROR, e.getMessageKey());
			}
		}
			
	}

	/**
	 * Creates an image object with the data sent from the request
	 * 
	 * @param request
	 * @return new Image object full with data that comes from the request
	 * @throws PortfolioBusinessException 
	 */
	private Image getImage(HttpServletRequest request) throws PortfolioBusinessException {
		
		Image image = new Image();
		image.setDescription( request.getParameter(
				WebHelper.MAIN_IMAGE_DESCRIPTION_PARAMETER) );
		BlobHelper blobHelper = BlobHelper.getInstance();
		image.setBlobkey(blobHelper.getBlobKey(request));

		return image;
	}

}
