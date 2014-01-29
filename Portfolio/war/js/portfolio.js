
jQuery(document).ready(function(){	
	
	jQuery("#editPhotoLink").click(function(){
	    jQuery("#editPhotoDiv").show();
	    return false;
	});
	
	jQuery("#editPhotoLink").click(function(){
	    jQuery("#editPhotoDiv").show("slow");
	    jQuery("#editPhotoLink").hide("slow");
	    return false;
	});
	
	jQuery("#closePhotoLink").click(function(){
	    jQuery("#editPhotoDiv").hide("slow");
	    jQuery("#editPhotoLink").show();
	    return false;
	});	
	
	jQuery('#add-comment-link').click(function(e) {
		jQuery('#add-comment-form').submit();
    });	
	
});

function noImageSelected(){
	
		jQuery(".errorSign").html("*");
		jQuery(".noImageSelectedError").html("- Select a file to upload.");
	    jQuery("#editPhotoDiv").show();
	    
		noty({
			text: 'Please select a file to upload!',
			layout: 'topCenter',
			type: 'error'	
		});	    
	    
}

//Shows a given error message
function showErrorMessage( errorMessage ){
	
	noty({
		text: errorMessage,
		layout: 'topCenter',
		type: 'error'	
	});
    
}

//Shows a given success message
function showSuccessMessage( successMessage ){
	
	noty({
		text: successMessage,
		layout: 'topCenter',
		type: 'success'	
	});
    
}




















