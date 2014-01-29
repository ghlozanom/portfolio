package com.gabloz.portfolio.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.common.helper.EMailHelper;
import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.model.ContactMessage;
import com.gabloz.portfolio.web.helper.WebHelper;

/**
 * Servlet to manage contacts with the visitor.
 * 
 * @author      Gabriel Lozano
 * */
public class ContactServlet extends HttpServlet {

	private static final Logger logger = Logger
			.getLogger(ContactServlet.class.getCanonicalName());

	/**
	 * Sends an email message with the data provided by the visitor.
	 * It also sends back a confirmation message.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		logger.log(Level.INFO, "ContactServlet's doGet()");
		WebHelper webHelper = WebHelper.getInstance();
		
		//Creates a ContactMessage object with the data sent from the request
		ContactMessage contactMessage = getContactMessage(request);		
		EMailHelper eMailHelper = EMailHelper.getInstance();
		
		try {
			eMailHelper.sendContactMessage(contactMessage);
			
			//The contact message was sent, now show a confirmation message to the user
			webHelper.sendRedirectWithMessage(WebHelper.MAIN_PAGE_SERVLET_PATH,
					response, WebHelper.SUCCESS, MessageHelper.MESSAGE_SENT_SUCCESS);			
		} catch (PortfolioBusinessException e) {
			webHelper.sendRedirectWithMessage(WebHelper.MAIN_PAGE_SERVLET_PATH,
					response, WebHelper.ERROR, e.getMessageKey());
		}		
		
	}
	
	/**
	 * Creates a ContactMessage object with the data sent from the request
	 * 
	 * @param request
	 * @return new ContactMessage object full with data that comes from the request
	 */	
	private ContactMessage getContactMessage(HttpServletRequest request) {
		ContactMessage contactMessage = new ContactMessage();
		contactMessage.setMessage(request.getParameter("message"));
		contactMessage.setName(request.getParameter("nameSender"));
		contactMessage.setEmail(request.getParameter("emailSender"));
		return contactMessage;
	}

	private static final long serialVersionUID = -747722117532147736L;

}
