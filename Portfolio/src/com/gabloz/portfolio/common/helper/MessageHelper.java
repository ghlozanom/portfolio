package com.gabloz.portfolio.common.helper;

import com.gabloz.portfolio.gae.helper.GAEConstants;


/**
 * Provides helper methods to work user messages
 * 
 * @author      Gabriel Lozano
 * */
public class MessageHelper {
	
	private static MessageHelper messageHelper = null;
	public static final String IMG_DELETED_SUCCESSFULY = "img_del_succ";
	//This attribute is used to indicate to the user that an image was not selected
	public static final String NO_IMAGE_UPLOADED = "img_not_upl";
	public static final String IMAGE_UPLOAD_SUCCESS = "img_upl";
	public static final String MESSAGE_NOT_SENT = "msg_not_sent";
	public static final String MESSAGE_SENT_SUCCESS = "msg_sent_succ";
	public static final String USER_NOT_AUTHENTICATED = "usr_not_ath";

	/**
	 * Returns a unique instance of this class (Singleton pattern)
	 * 
	 * @return a singleton MessageHelper instance
	 */
	public static MessageHelper getInstance() {
		if(messageHelper == null ){
			messageHelper =new MessageHelper();
		}
		return messageHelper;
	}	
	
	/**
	 * Only accessible from the same class (Singleton pattern)
	 */
	private MessageHelper(){
	}

	/**
	 * For the messageKey it returns the message, or 
	 * "No message for the key" if no message is found for
	 * this key.
	 * 
	 * @param messageKey
	 * @return the message string for the given key
	 */
	public String getMessageForKey(String messageKey) {
		
		if(GAEConstants.ENTITY_NOT_FOUND.equalsIgnoreCase(messageKey)){
			return "Entity was not found in the datastore. Please check this functionality";
		}
		if(MessageHelper.IMG_DELETED_SUCCESSFULY.equalsIgnoreCase(messageKey)){
			return "Image deleted successfully!";
		}
		if(MessageHelper.MESSAGE_SENT_SUCCESS.equalsIgnoreCase(messageKey)){
			return "Message sent successfully!";
		}			
		if(MessageHelper.NO_IMAGE_UPLOADED.equalsIgnoreCase(messageKey)){
			return "No file selected, please select a file!";
		}
		if(MessageHelper.IMAGE_UPLOAD_SUCCESS.equalsIgnoreCase(messageKey)){
			return "Image uploaded successfully!";
		}	
		if(MessageHelper.MESSAGE_NOT_SENT.equalsIgnoreCase(messageKey)){
			return "Your message could not be sent. Please try again";
		}	
		if(MessageHelper.USER_NOT_AUTHENTICATED.equalsIgnoreCase(messageKey)){
			return "This operation can only be done by an authenticated user";
		}		
		return "No message for the key";	
	}

}
