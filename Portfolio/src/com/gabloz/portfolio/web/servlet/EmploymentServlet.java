package com.gabloz.portfolio.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.web.helper.EmploymentWebHelper;
import com.gabloz.portfolio.web.helper.WebHelper;

/**
 * Servlet to manage employment.
 * 
 * @author      Gabriel Lozano
 * */
public class EmploymentServlet extends HttpServlet {
	
	/**
	 * Saves a new Job.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		logger.log(Level.INFO, "Employments doGet()");
		
		String operation =request.getParameter(WebHelper.OPERATION);
		
		if(WebHelper.REMOVE.equals(operation)){
			EmploymentWebHelper.getInstance().deleteWork(request, response);
			response.getWriter().write(MessageHelper.WORK_REMOVED_SUCCESS);
		}else {
			EmploymentWebHelper.getInstance().saveWork(request, response);
		}
		

	}	
	
	private static final long serialVersionUID = -2381662829064587534L;
	private static final Logger logger = Logger
			.getLogger(EmploymentServlet.class.getCanonicalName());	

}
