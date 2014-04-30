
//Holds the id of the ddescription to be removed if the user confirms (see dialof-confirm)
var descriptionIdToBeRemoved;
var workIdToBeRemoved;

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
	
	$('.updateDesc').hide();
	$('.cancelDesc').hide();
	$('.inputText').hide();
	
    $( "#dialog-confirm" ).dialog({
	      resizable: false,
	      height:200,
	      width: 500,
	      autoOpen: false,
	      modal: true,
	      buttons: {
	        "Delete description": function() {
	        	
	        	var temp = this;
	        	
	        	$.ajax({
	    	       	type: "POST",
	    	      	data: $('#' + descriptionIdToBeRemoved).serialize(),
	    	        url: "/description?op=removeDescription",
	    	        success: function(data)
	    	        {   
	    	        	$('#listItem_' + descriptionIdToBeRemoved).hide('slow', function(){ $('#listItem_' + descriptionIdToBeRemoved).remove(); });
	    	       		$( temp ).dialog( "close" );
	    	        }
	    	    });	
	        },
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
    
    $( "#delete-work-dialog-confirm" ).dialog({
	      resizable: false,
	      height:200,
	      width: 500,
	      autoOpen: false,
	      modal: true,
	      buttons: {
	        "Delete work": function() {
	        	
	        	var temp = this;
	        	
	        	$.ajax({
	    	       	type: "POST",
	    	      	data: 'id=' + workIdToBeRemoved,
	    	        url: "/employment?op=remove",
	    	        success: function(data)
	    	        {   
	    	        	window.location.replace("/?result=" + data);
//	    	        	$('#' + workIdToBeRemoved).hide('slow', function(){ $('#' + workIdToBeRemoved).remove(); });
//	    	       		$( temp ).dialog( "close" );
	    	        }
	    	    });	
	        },
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });	    
	
	$('.descriptionForm').keypress(function (e) {
		  if (e.which == 13) {
		  	e.preventDefault();
		  	saveDescription(this.getAttribute('id'));
		  }
		});	
	
});

function enableDescriptions(){
	
	$('.editableText').on('click', function(e) {
        var t = $(this).text();
        $(this).parent().parent().find('.updateDesc').show();
        $(this).parent().parent().find('.cancelDesc').show();
        $(this).parent().parent().find('.inputText').show();
        $(this).parent().parent().find('.inputText').html(t);
	    $(this).hide();
	});			
	
    $( ".canBeSortable" ).addClass( "sortable" );
    $( ".sortable" ).sortable( {
        update : function () { 
            var order = $(this).sortable('serialize'); 
        	$.ajax({
    	       	type: "POST",
    	      	data: order,
    	        url: "/description?op=updateOrder"
    	    });	            
        } 
    });
    $( ".sortable" ).disableSelection();
    
}

function loadDescription(formId){
	$.ajax({
	       	type: "GET",
	      	data: $('#' + formId).serialize(),
	        url: "/description?op=loadDescription",
	        success: function(data)
	        {   
	       		updateDescription( $('#listItem_' + formId), data);
	        }
	    });		
}

function removeDescription(descriptionId){

	descriptionIdToBeRemoved = descriptionId;
	$( "#dialog-confirm" ).dialog( "open" );
}

function deleteWork(workId){

	workIdToBeRemoved = workId;
	$( "#delete-work-dialog-confirm" ).dialog( "open" );
}

function saveDescription(descriptionId){

	$.ajax({
	       	type: "POST",
	      	data: $('#' + descriptionId).serialize(),
	        url: "/description?op=update",
	        success: function(data)
	        {   
	        	updateDescription( $('#listItem_' + descriptionId), data);
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
			   if(jqXHR.responseText !== ''){
			  		showErrorMessage(jqXHR.responseText);
			    }else{
			    	showErrorMessage(errorThrown);
			    }
	        }		        
	    });		
}

function addDescription(formId){
	
	$.ajax({
	       	type: "POST",
	      	data: $('#addForm' + formId).serialize(),
	        url: "/description?op=add",
	        success: function(data)
	        {   
	        	window.location.replace("/?result=" + data);
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
			   if(jqXHR.responseText !== ''){
			  		showErrorMessage(jqXHR.responseText);
			    }else{
			    	showErrorMessage(errorThrown);
			    }
	        }		        
	    });		
}

function updateDescription( itemDescriptionId, data ){
	
	$(itemDescriptionId).find('.inputText').val(data);
	itemDescriptionId.find('.inputText').hide();
	itemDescriptionId.find('.updateDesc').hide();
	itemDescriptionId.find('.cancelDesc').hide();
	itemDescriptionId.find('.editableText').show();
	itemDescriptionId.find('.editableText').text(data);
}

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

//Shows a given information message
function showInfoMessage( successMessage ){
	
	noty({
		text: successMessage,
		layout: 'topCenter',
		type: 'information'	
	});
    
}




















