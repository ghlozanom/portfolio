package com.gabloz.description.common.helper;


public class DescriptionMessageHelper {

	public static final String DESC_PREFIX = "DESC";
	public static final String DESC_UPDATED_SUCCESS = DESC_PREFIX + "_desc_upd_succ";
	private static DescriptionMessageHelper instance;
	
	
	public static DescriptionMessageHelper getInstance() {
		if(instance == null){
			instance = new DescriptionMessageHelper();
		}
		return instance;
	}


	public String getMessageForKey(String messageKey) {
		
		if(DESC_UPDATED_SUCCESS.equals(messageKey)){
			return "Description updated successfully";
		}
		return "No message found for key " + messageKey;
	}

}
