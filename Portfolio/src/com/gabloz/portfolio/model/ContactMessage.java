package com.gabloz.portfolio.model;


/**
 * Model class that holds a Contact message
 * 
 * @author Gabriel Lozano
 *
 */
public class ContactMessage {
	
	private String name;
	private String email;
	private String message;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
