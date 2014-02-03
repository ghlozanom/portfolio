package com.gabloz.portfolio.common.helper;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gabloz.portfolio.common.PortfolioConstants;
import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.model.ContactMessage;

/**
 * Provides helper methods to work with emails 
 * 
 * @author      Gabriel Lozano
 * */
public class EMailHelper {
	
	private static final String CONTACT_MESSAGE_SUBJECT = "Contacted from the form";
	private static EMailHelper emailHelper = null;	
	
	/**
	 * Returns a unique instance of this class (Singleton pattern)
	 * 
	 * @return a singleton BlobHelper instance
	 */
	public static EMailHelper getInstance() {
		if(emailHelper == null ){
			emailHelper = new EMailHelper();
		}
		return emailHelper;
	}	
	
	/**
	 * Only accessible from the same class (Singleton pattern)
	 */
	private EMailHelper(){
	}

	/**
	 * Sends a contact message from the visitor to the official address of the application
	 * (the address defined in PortfolioConstants.PORTFOLIO_APP_ADDRESS). A confirmation
	 * message is sent back to the user.
	 * 
	 * @param contactMessage
	 * @throws PortfolioBusinessException if the user could not be sent
	 */
	public void sendContactMessage(ContactMessage contactMessage) throws PortfolioBusinessException {
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(PortfolioConstants.PORTFOLIO_APP_ADDRESS, 
					PortfolioConstants.PORTFOLIO_APP_ADDRESS_NICKNAME));
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(PortfolioConstants.PORTFOLIO_APP_ADDRESS) );
			message.setSubject( CONTACT_MESSAGE_SUBJECT );
			message.setText(contactMessage.getMessage());
			Transport.send(message);
			
			//Confirmation message
			String confirmationMessageBody = "Dear " + contactMessage.getName() + ":" +
			"\n\nThank you for contacting us. In short, we will answer to your message." +
			"\n\nKind regards,\n\nThe Portfolio Team.";
			
			message.addRecipient(Message.RecipientType.TO,
									new InternetAddress(contactMessage.getEmail()) );
			message.setSubject( "Thank you for your message, " + contactMessage.getName() );
			message.setText(confirmationMessageBody);
			Transport.send(message);				
			
		} catch (UnsupportedEncodingException e) {
			throw new PortfolioBusinessException(MessageHelper.MESSAGE_NOT_SENT);
		} catch (MessagingException e) {
			throw new PortfolioBusinessException(MessageHelper.MESSAGE_NOT_SENT);
		}		
	}
}
