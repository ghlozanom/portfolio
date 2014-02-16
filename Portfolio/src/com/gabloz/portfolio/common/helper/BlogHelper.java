package com.gabloz.portfolio.common.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;


/**
 * Provides helper methods to work with Blogs 
 * 
 * @author      Gabriel Lozano
 * */
public class BlogHelper {
	
    public static String GHLOZANOM_BLOG_ID = "9019788118118806715";
	private static final String API_KEY = "AIzaSyDjJ0aDOtQ1Cl_ojEoodV2n84aGOxMQ0PI";
	private static final String POST_DATE_FORMAT = "MMM-dd-yy";
	private static BlogHelper blogHelper = null;	
	private Blogger blogger = null;
	
	/**
	 * Returns a unique instance of this class (Singleton pattern)
	 * 
	 * @return a singleton BlobHelper instance
	 */
	public static BlogHelper getInstance() {
		if(blogHelper == null ){
			blogHelper = new BlogHelper();
		}
		return blogHelper;
	}	
	
	/**
	 * Only accessible from the same class (Singleton pattern)
	 */
	private BlogHelper(){
		blogger = new Blogger.Builder(new UrlFetchTransport(), new JacksonFactory(), null)
			.setApplicationName("ghlozanom").build();		
	}

	/**
	 * Only to test, this have to be changed
	 * @param labels 
	 * @param blogName 
	 * @return HTML for the blog
	 */
	public List<String[]> getPosts(String postID, String labels) {		
		List<String[]> posts = new ArrayList<String[]>();
		
		try {
			//Means all posts should be returned
			if(postID== null){
				com.google.api.services.blogger.Blogger.Posts.List postsRequest;
				postsRequest = blogger.posts().list(GHLOZANOM_BLOG_ID);
				//labels specify a filter for the posts to be returned
				if(labels != null && !"".equals(labels)){
					postsRequest.setLabels(labels);
				}
				PostList postList = postsRequest.setKey(API_KEY).execute();
				 if(postList != null && postList.getItems() != null ){
					 for( Post post: postList.getItems() ){
						 posts.add(getPost(post)); 
					 }
				 }
				return posts;
			}
			//Code is here because the request is for a specific post
			posts.add(getPost(postID));
			return posts;
		} catch (IOException e) {
			// TODO show an exception message to the user
		}		
		
		return null;
	}

	//Given a Post model object, a String array is fulfilled
	private String[] getPost(Post post) {
		String[] blog = new String[3];
		
		SimpleDateFormat timeFormat = new SimpleDateFormat(POST_DATE_FORMAT);
        String finalDate = timeFormat.format( new Date(post.getPublished().getValue()) );
        
		blog[0] = finalDate;
		blog[1] = post.getTitle();
		blog[2] = post.getContent();
		return blog;
	}

	//A Get request for a specific post is done
	private String[] getPost(String postID) throws IOException {	
	    
		 com.google.api.services.blogger.Blogger.Posts.Get postRequest = 
			 blogger.posts().get(GHLOZANOM_BLOG_ID, postID);
		 Post post = postRequest.setKey(API_KEY).execute();		
		 return getPost(post);	
				
	}
	
}
