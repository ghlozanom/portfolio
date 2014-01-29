package com.gabloz.portfolio.common.exceptions;

/**
 * Exception to communicate business problems within
 * the application in the stack
 * 
 * @author      Gabriel Lozano
 * */
public class PortfolioBusinessException extends Exception {
	
	//Key that stores the reason for this exception to occur
	private String messageKey;

	public PortfolioBusinessException(String messagekey) {
		this.messageKey = messagekey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	private static final long serialVersionUID = -8664101783518153464L;

}
