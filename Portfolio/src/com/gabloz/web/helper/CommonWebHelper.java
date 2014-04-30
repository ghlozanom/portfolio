package com.gabloz.web.helper;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.PortfolioConstants;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class CommonWebHelper {
	
	//if the parameter "checked" is true, the String "checked" is returned. 
	//this is to be used with input checkbox
	public static String isChecked( boolean checked ){
		if(checked){
			return "checked";
		}
		return "";
	}
	
	//return a given date as a String formatted to be used with a date picker
	public static String dateInDatepickerFormat( Date date ){
		if(date == null ) return "";
		return PortfolioConstants.simpleDateFormatter.format(date);
	}

	public static void setAjaxWarningResponse(HttpServletResponse response,
			String message) throws IOException {
		
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.getWriter().write( message );
		response.flushBuffer();	
		
	}	
	
	public static String keyToString( Key key ) {
		
		return KeyFactory.keyToString(key);	
		
	}		

}
