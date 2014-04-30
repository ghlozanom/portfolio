package com.gabloz.portfolio.common.exceptions;

/**
 * Exception to communicate small business inconsistencies within
 * the application in the stack
 * 
 * @author      Gabriel Lozano
 * */
public class PortfolioBusinessWarningException extends Exception {
	
	//Key that stores the reason for this exception to occur
	private String messageKey;

	public PortfolioBusinessWarningException(String messagekey) {
		this.messageKey = messagekey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}
	
	private static final long serialVersionUID = 906521302721772204L;

}
