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
	public static final String WORK_CREATED_WITH_SUCCESS = "wrk_crt_suc";
	public static final String CURRENT_WORK_EXISTS = "cur_wrk_ext";
	public static final String WORK_UPDATED_SUCCESS = "wrk_upd_suc";
	public static final String INITIAL_DATE_BEFORE_PREVIOUS_WORK_FINAL_DATE = "init_dat_bef_prev_wfd";
	public static final String FINAL_DATE_AFTER_NEXT_WORK_INITIAL_DATE = "fin_dat_aft_nex_wid";
	public static final String FINAL_DATE_NOT_AFTER_INIT_DATE = "fin_dat_naf_idt";
	public static final String FINAL_DATE_CAN_NOT_EMPTY = "fin_dat_cnt_ept";
	public static final String INIT_DATE_NOT_BEFORE_INITIAL_DATE_CURRENT_WORK = "init_date_nbf_idt_cwk";
	public static final String WORK_REMOVED_SUCCESS = "wrk_rem_suc";

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
		if(MessageHelper.WORK_CREATED_WITH_SUCCESS.equalsIgnoreCase(messageKey)){
			return "This job was created successfully";
		}	
		if(MessageHelper.WORK_UPDATED_SUCCESS.equalsIgnoreCase(messageKey)){
			return "This job was updated successfully";
		}		
		if(MessageHelper.CURRENT_WORK_EXISTS.equalsIgnoreCase(messageKey)){
			return "There is already a current job registered";
		}
		if(MessageHelper.INITIAL_DATE_BEFORE_PREVIOUS_WORK_FINAL_DATE.equalsIgnoreCase(messageKey)){
			return "This job was updated successfully but with a warning: "
					+ "The initial date is before the final date of the previous work";
		}	
		if(MessageHelper.FINAL_DATE_AFTER_NEXT_WORK_INITIAL_DATE.equalsIgnoreCase(messageKey)){
			return "This job was updated successfully but with a warning: "
					+ "The final date is after the initial date of the next work";
		}		
		if(MessageHelper.FINAL_DATE_NOT_AFTER_INIT_DATE.equalsIgnoreCase(messageKey)){
			return "Final date should be after the initial date";
		}	
		if(MessageHelper.FINAL_DATE_CAN_NOT_EMPTY.equalsIgnoreCase(messageKey)){
			return "Final date can not be empty unless it is the current one";
		}
		if(MessageHelper.INIT_DATE_NOT_BEFORE_INITIAL_DATE_CURRENT_WORK.equalsIgnoreCase(messageKey)){
			return "The initial date must be before the initial date of the current work";
		}
		if(MessageHelper.WORK_REMOVED_SUCCESS.equalsIgnoreCase(messageKey)){
			return "This work was removed successfully";
		}		
		return "No message for the key";	
	}

}
