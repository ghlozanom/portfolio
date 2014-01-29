package com.gabloz.portfolio.gae.helper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.web.helper.WebHelper;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Provides helper methods to work with blobs 
 * in the Google App Engine
 * 
 * @author      Gabriel Lozano
 * */
public class BlobHelper {
	
	//Parameter's name of the blob data's key to be retrieved
	private static final String BLOB_KEY_PARAM = "blobKey";	
	private static final String MAIN_IMAGE_PROPERTY_NAME = "mainImage";
	
	private static BlobHelper blobHelper = null;	
	private BlobstoreService blobstoreService = null;		
	private DatastoreService datastoreService = null;
	private static final Logger logger = Logger
	.getLogger(BlobHelper.class.getCanonicalName());
	
	/**
	 * Returns a unique instance of this class (Singleton pattern)
	 * 
	 * @return a singleton BlobHelper instance
	 */
	public static BlobHelper getInstance() {
		if(blobHelper == null ){
			blobHelper = new BlobHelper();
		}
		return blobHelper;
	}	
	
	/**
	 * Only accessible from the same class (Singleton pattern)
	 */
	private BlobHelper(){
		blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		datastoreService = DatastoreServiceFactory.getDatastoreService();
	}

	/*
	 * Creates URL to upload the main image photo using the BlobService
	 */
	public String createUploadUrl() {
		return blobstoreService.createUploadUrl(WebHelper.MAIN_IMAGE_UPLOAD_SERVLET_PATH);
	}

	/**
	 * Gets the blob data of the man Image's Entity
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void getBlobDataForKey(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String uploadKeyStr = request.getParameter(BLOB_KEY_PARAM);
		if(uploadKeyStr == null || "".equalsIgnoreCase(uploadKeyStr) ){
			return;
		}
		
		try{
			Entity mainImage = datastoreService.get(KeyFactory.stringToKey(uploadKeyStr));
			BlobKey blobKey = (BlobKey)mainImage.getProperty(MAIN_IMAGE_PROPERTY_NAME);
			blobstoreService.serve(blobKey, 
					blobstoreService.getByteRange(request),
					response);
		}catch (EntityNotFoundException e) {
			logger.log(Level.WARNING, "Entity for the main image given a key was not found");
			response.sendError(404);
		}		
		
	}
	
	/**
	 * Obtains the Blobkeys from the request
	 * 
	 * @param request
	 * @return blobKeys representing the files uploaded by the user
	 * @throws PortfolioBusinessException 
	 */
	public BlobKey getBlobKey(HttpServletRequest request) throws PortfolioBusinessException {
		Map<String, List<BlobKey>> blobFields = blobstoreService.getUploads(request);
		List<BlobKey> blobKeys = blobFields.get("upload");
		if(blobKeys == null ){
			//To validate that the user selected a file. If he/she didn't,
			//an error message is shown			
			throw new PortfolioBusinessException(MessageHelper.NO_IMAGE_UPLOADED);
		}
		return blobKeys.get(0);
	}	

}
