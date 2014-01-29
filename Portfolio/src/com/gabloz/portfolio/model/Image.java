package com.gabloz.portfolio.model;

import com.google.appengine.api.blobstore.BlobKey;

/**
 * Model class that holds an image
 * @author Gabriel Lozano
 *
 */
public class Image {
	
	private String description;
	private BlobKey blobkey;
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setBlobkey(BlobKey blobkey) {
		this.blobkey = blobkey;
	}
	public BlobKey getBlobkey() {
		return blobkey;
	}
}
