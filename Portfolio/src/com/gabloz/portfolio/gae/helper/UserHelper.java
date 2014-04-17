package com.gabloz.portfolio.gae.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gabloz.portfolio.common.exceptions.PortfolioBusinessException;
import com.gabloz.portfolio.common.helper.MessageHelper;
import com.gabloz.portfolio.model.Image;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;

/**
 * Provides helper methods to work with user data
 * in the Google's datastore
 * 
 * @author      Gabriel Lozano
 * */
public class UserHelper {
	
	private BlobstoreService blobstoreService = null;
	private DatastoreService datastoreService = null;
	private static UserHelper userHelper = null;
	
	private static final Logger logger = Logger.getLogger(UserHelper.class.getCanonicalName());	
	
	/**
	 * Returns a unique instance of this class (Singleton pattern)
	 * 
	 * @return a singleton UserHelper instance
	 */
	public static UserHelper getInstance() {
		if(userHelper == null ){
			userHelper =new UserHelper();
		}
		return userHelper;
	}	
	
	/**
	 * Only accessible from the same class (Singleton pattern)
	 */
	private UserHelper(){
		datastoreService = DatastoreServiceFactory.getDatastoreService();
		blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	}

	/**
	 * If an image is saved in the datastore, the String representation
	 * of its key is returned, null otherwise
	 * 
	 * @return String representation of the key of the main image
	 */
	public String getMainImgUploadKey() {
			
		Key userGroupKey = 
			KeyFactory.createKey(GAEConstants.USER_UPLOAD_GROUP_KIND, GAEConstants.USER_UPLOAD_GROUP_NAME);
		Query q = new Query(GAEConstants.MAIN_IMAGE_KIND).setAncestor(userGroupKey);			
		PreparedQuery pq = datastoreService.prepare(q);
		Entity mainImgUpload = pq.asSingleEntity();		
		if( mainImgUpload == null ){
			return null;
		}
		return KeyFactory.keyToString(mainImgUpload.getKey());
		
	}

	/**
	 * Validates that the user chose an image. If that is the case,
	 * the corresponding message is shown. If the user selected a valid
	 * file then if a previous image for the user exists it is deleted
	 * and replaced with the new one.
	 * 
	 * @param request 
	 * @throws BusinessException 
	 */
	public void saveMainImage(Image image) throws IOException, PortfolioBusinessException {
		//Key to be used for the query to avoid a global index
		Key userGroupKey = KeyFactory.createKey(GAEConstants.USER_UPLOAD_GROUP_KIND, 
				GAEConstants.USER_UPLOAD_GROUP_NAME);
		Query q = new Query(GAEConstants.MAIN_IMAGE_KIND).setAncestor(userGroupKey);			
		PreparedQuery pq = datastoreService.prepare(q);
		Entity mainImgUpload = pq.asSingleEntity();
		
		//If there is already an image entity, then it is deleted to be replaced later
		if(mainImgUpload != null ){
			List<Key> keysToDelete = new ArrayList<Key>();				
			BlobKey blobKey = (BlobKey) mainImgUpload.getProperty(GAEConstants.MAIN_IMAG_PROPERTY);
			//Prevous approach, deleting a blobInfoKey, doesnt work in production server, see
			//http://stackoverflow.com/questions/16434164/appengine-illegal-key-path-element-type-blobinfo-trying-to-delete-blobstore
			blobstoreService.delete(blobKey);
//			Key blobInfoKey = KeyFactory.createKey(
//					BlobInfoFactory.KIND, blobKey.getKeyString());
//			keysToDelete.add(blobInfoKey);
			keysToDelete.add(mainImgUpload.getKey());
			datastoreService.delete(keysToDelete);
		}			
		
		//Main image is saved in the datastore
		mainImgUpload = new Entity(GAEConstants.MAIN_IMAGE_KIND, userGroupKey);
		mainImgUpload.setProperty(GAEConstants.MAIN_IMAGE_DESCRIPTION_PROPERTY, image.getDescription());
		mainImgUpload.setProperty(GAEConstants.MAIN_IMAG_PROPERTY, image.getBlobkey());		
		datastoreService.put(mainImgUpload);		
	}

	/**
	 * Removes, if there is one, the main Image from the datastore
	 * @param user 
	 * @param mainImgUploadKeyStr 
	 * 
	 * @throws IOException 
	 * @throws PortfolioBusinessException 
	 */
	public void deleteMainImage(User user, String mainImgUploadKeyStr) throws IOException, PortfolioBusinessException {
		
		try {
			
			//Validates that there user calling this method is authenticated
			if(user == null){
				logger.log(Level.WARNING, "DeleteMainImage called from a non-authenticated user");
				throw new PortfolioBusinessException(MessageHelper.USER_NOT_AUTHENTICATED);				
			}
			
			List<Key> keysToDelete = new ArrayList<Key>();
			Entity mainImgUpload;
				mainImgUpload = datastoreService.get(KeyFactory.stringToKey(mainImgUploadKeyStr));

			BlobKey blobKey = (BlobKey) mainImgUpload.getProperty("mainImage");
			keysToDelete.add(mainImgUpload.getKey());
			datastoreService.delete(keysToDelete);
			blobstoreService.delete(blobKey);
		} catch (EntityNotFoundException e) {
			logger.log(Level.WARNING, "Entity to be deleted not found in the datastore");
			throw new PortfolioBusinessException(GAEConstants.ENTITY_NOT_FOUND);
		}
	}

}
