package com.gabloz.portfolio.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.web.helper.WebHelper;
import com.gabloz.portfolio.web.helper.WebImageHelper;

/**
 * Servlet to manage the portfolio's Blog.
 * 
 * @author      Gabriel Lozano
 * */
public class BlogServlet extends HttpServlet {

	/**
	 * Loads the main image stored in the datastore.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		logger.log(Level.INFO, "Blog's doGet()");
		
		//Setting of the attributes required to work with the main image
		WebImageHelper webImageHelper = WebImageHelper.getInstance();
		webImageHelper.setImageAttributesInRequest(request, false);
		
		//Blog page is now generated
		RequestDispatcher jsp = request.getRequestDispatcher(WebHelper.BLOG_PAGE);
		jsp.forward(request, response);		
	}
	
	private static final long serialVersionUID = 7950685940659075816L;
	private static final Logger logger = Logger
			.getLogger(BlogServlet.class.getCanonicalName());	

}
