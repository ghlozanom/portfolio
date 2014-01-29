package com.gabloz.portfolio.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.gae.helper.BlobHelper;

/**
 * Servlet to retrieve blob data given a key.
 * 
 * @author      Gabriel Lozano
 * */
public class BlobRetrieverServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7836236960848094405L;
	private static final Logger logger = Logger
			.getLogger(BlobRetrieverServlet.class.getCanonicalName());

	/**
	 * Retrieves blob data given a key parameter that comes in the request.
	 * Sets the data in the response. This servlet uses for this the BlobHelper class
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.log(Level.INFO, "Blob retriever servlet's doGet()");
		
		BlobHelper blobHelper = BlobHelper.getInstance();
		blobHelper.getBlobDataForKey(request, response);

	}

}
