package com.gabloz.portfolio.gae.helper;

/**
 * Constants for Kinds, groups, properties, etc. 
 * to be used to interact with the datastore
 * 
 * @author      Gabriel Lozano
 * */
public class GAEConstants {
		
	//User upload group kind and name to be used as ancestor in the query for the main image
	protected static final String USER_UPLOAD_GROUP_KIND = "UserUploadGroup";
	protected static final String USER_UPLOAD_GROUP_NAME = "ghlm81@hotmail.com";
	
	//Kind to be saved in the datastore and its properties
	protected static final String MAIN_IMAGE_KIND = "MainImage";	
	public static final String MAIN_IMAGE_DESCRIPTION_PROPERTY = "description";
	//Name of the property of the main image entity that holds the image data
	public static final String MAIN_IMAG_PROPERTY = "mainImage";
	public static final String ENTITY_NOT_FOUND = "entity_not_found";

}
