package com.gabloz.portfolio.web.helper;

import javax.servlet.http.HttpServletRequest;

import com.gabloz.portfolio.gae.helper.UserHelper;

/**
 * Web helper to manage Images
 * 
 * @author Gabriel Lozano
 *
 */
public class WebImageHelper {
	
	private static WebImageHelper webImageHelper = null;
	
	private WebImageHelper(){
	}
	
	public void setImageAttributesInRequest(HttpServletRequest request, boolean withImageEdit )  {
		
		//Sets the key for the main image if it exists
		UserHelper userHelper = UserHelper.getInstance();	
		String mainImageKey = userHelper.getMainImgUploadKey();
		if(mainImageKey != null ){
			request.setAttribute("mainImageKey", mainImageKey);
			
		}		
		if( withImageEdit ){
			request.setAttribute("deleteMainImgPath", WebHelper.DELETE_MAIN_IMG_PATH  + mainImageKey);
		}
		request.setAttribute("hasImage", mainImageKey != null);
		request.setAttribute("editImage", withImageEdit);
		
	}

	public static WebImageHelper getInstance() {
		if(webImageHelper == null ){
			webImageHelper =new WebImageHelper();
		}
		return webImageHelper;
	}

}
