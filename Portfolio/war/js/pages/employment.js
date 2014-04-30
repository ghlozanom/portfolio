
var workSelected = '';
var tips;

jQuery(document).ready(function(){	
	
	jQuery(".currentJobCheckbox").click(function(){
		if(this.checked){
			jQuery(this).parent().find(".finalDateInput").hide();
			jQuery(this).parent().find(".finalDateLabel").hide();
		}else {
			jQuery(this).parent().find(".finalDateInput").show();
			jQuery(this).parent().find(".finalDateLabel").show();
		}
	});
	
	jQuery( ".datepicker" ).datepicker( 
			{
				changeMonth: true,
				changeYear:  true,
				yearRange:   "1980:2018"
			}
	);
	
	function updateTips( t ) {
	    tips
	      .text( t )
	      .addClass( "ui-state-highlight" );
	    setTimeout(function() {
	      tips.removeClass( "ui-state-highlight", 1500 );
	    }, 500 );
	  }
	
	jQuery( ".dialog-form" ).dialog({
        autoOpen: false,
        height: 'auto',
        hide: true,
        width: 430,
        modal: true,
        buttons: {
          "Save": function() {
      		$.ajax({
		       	type: "POST",
		      	data: $('#workForm' + workSelected).serialize(),
		        url: "/employment",
		        success: function(data)
		        {   
		        	window.location.replace("/?result=" + data);
		        },
		        error: function(jqXHR, textStatus, errorThrown) {
				   if(jqXHR.responseText !== ''){
					   updateTips( jqXHR.responseText );
				    }else{
				    	showErrorMessage(errorThrown);
				    }
		        }		        
		    });	
          },
          Cancel: function() {
            $( this ).dialog( "close" );
          }
        },
        close: function() {
          
        }
      });
	
	
});

function editWork(workId){
	
	workSelected = workId;
	tips = $( '#editWork' + workId  ).find(".validateTips");
	
	
	if( $( '#editWork' + workId  ).find(".currentJobCheckbox").is(':checked') ){
		$( '#editWork' + workId  ).find(".finalDateInput").hide();
		$( '#editWork' + workId  ).find(".finalDateLabel").hide();
	}
	
	$( '#editWork' + workId  ).dialog( "open" );
}

function addWork(){
	workSelected = '';
	tips = $( '#addJobDiv' ).find(".validateTips");
	$( '#addJobDiv' ).dialog( "open" );
}





















