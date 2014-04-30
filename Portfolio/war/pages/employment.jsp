<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wcf" uri="WebCommonFunctions" %>

<script type="text/javascript" src="js/pages/employment.js"></script>

<div class="category resume_category resume_category_1 first even">
  <div class="category_header resume_category_header">
    <h3 class="category_title"><span class="category_title_icon aqua"></span>Employment</h3>
  </div>
  <div class="category_body resume_category_body">
  
  	<c:if test="${authenticatedUser}">
	  	<div class="">
	  		<a id="addJobLink" href="javascript:addWork()">Add a Job</a>
	  	</div>
  	</c:if>
  	
	<div id="addJobDiv" class="dialog-form" title="Add Work" >
		<p class="validateTips"></p> 
	  	<form id="workForm" >
	  		<fieldset>
		  		<label for="company">Company:</label>
		  		<input type="text" name="company" id="company" placeholder="Company Name" /><br /><br />
		  		<label for="initialDate">Initial Date:</label>
		  		<input class="datepicker" type="text" name="initialDate" placeholder="Initial Date" value=""><br /><br />
		  		<label for="currentJob">Current Job:</label>
		  		<input type="checkbox" class="currentJobCheckbox" name="current" value="current" >	  		
		  		<label for="finalDate" class="finalDateLabel"> - Final Date:</label>
		  		<input class="datepicker finalDateInput" type="text" name="finalDate" placeholder="Final Date" value=""><br /><br />
		  		<label for="initialDate">Position:</label>
		  		<input type="text" name="position" placeholder="Position" value=""><br /><br />	  			  		
	  		</fieldset>
	  	</form>       
	  	
	</div>
	
	<div id="dialog-confirm" title="Delete this description?">
	  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>This description will be permanently deleted and cannot be recovered. Are you sure?</p>
	</div>
	
	<div id="delete-work-dialog-confirm" title="Delete this work?">
	  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>This work will be permanently deleted and cannot be recovered. Are you sure?</p>
	</div>
  	
  	<% String articleClass = "post resume_post resume_post_1 first even"; %>
  	
  	<c:forEach items="${works}" var="work">
  	
		<article id="${wcf:keyToString(work.id)}" class="<%=articleClass %>">
		  <div class="post_header resume_post_header">
		    <div class="resume_period"> <span class="period_from">${work.initialDateYear}</span> - <span class="period_to">${work.finalDateYear}</span> </div>
		    <h4 class="post_title"><span class="post_title_icon aqua"></span><a href="post-text.html">${work.company}</a> 
		    	<c:if test="${authenticatedUser}">
		    		<a href="javascript:editWork('${work.idString}');" style="display:inline-block;" ><span class="ui-icon ui-icon-gear"></span></a>
		    		<a href="javascript:deleteWork('${work.idString}');" style="display:inline-block;" ><span class="ui-icon ui-icon-trash"></span></a>
		    	</c:if>
		    </h4>
		    <h5 class="post_subtitle">${work.position}</h5>
		  </div>
		  
			<c:if test="${authenticatedUser}">
				 <form id='addForm${wcf:keyToString(work.id)}'method="post" class="">
				 	<input type="hidden" name="parentId" value="${wcf:keyToString(work.id)}" />
				 </form>
				<div><a href="javascript:addDescription('${wcf:keyToString(work.id)}' )">Add a description</a></div>
			</c:if>
		  
			<div class="post_body resume_post_body">
			  <p>
			      <ul class="canBeSortable ui-sortable">
			     	 <c:forEach items="${work.descriptions}" var="description">
				      	<li id="listItem_${wcf:keyToString(description.id)}" >
							<form id="${wcf:keyToString(description.id)}" method="post" class="descriptionForm">
								<input type="hidden" name="parentId" value="${wcf:keyToString(work.id)}" />	 
								<input type="hidden" name="id" value="${wcf:keyToString(description.id)}" />
					      		<c:if test="${authenticatedUser}">
					      			<span class="ui-icon ui-icon-arrowthick-2-n-s" style="display:inline-block"></span>
					      		</c:if>
					      		<span class="editableText">${description.description}</span>
								<textarea class="inputText" rows="4" cols="70" name="value" ></textarea>	
								<a class="updateDesc" href="javascript:saveDescription('${wcf:keyToString(description.id)}' )" ><span class="ui-icon ui-icon-check"></span></a>
								<a class="cancelDesc" href="javascript:loadDescription('${wcf:keyToString(description.id)}' )" ><span class="ui-icon ui-icon-close"></span></a>
								<c:if test="${authenticatedUser}">
									<a class="removeDesc" href="javascript:removeDescription('${wcf:keyToString(description.id)}' )" ><span class="ui-icon ui-icon-trash"></span></a>
								</c:if>	
							</form>		      		
				      	</li>
			      	</c:forEach> 
			      </ul>
			  </p>
			</div>		
			
		 <% articleClass = "post resume_post resume_post_2 odd"; %> 
		 
		</article>	
		
		<div id="editWork${work.idString}"  class="dialog-form" title="Edit Work">
		  <p class="validateTips"></p> 
		  <form id="workForm${work.idString}" >
		  <fieldset>
		  		<input type="hidden" name="id" value="${work.idString}" />
		  		<label for="company">Company:</label>
		  		<input type="text" name="company" id="company" placeholder="Company Name" value="${work.company}" /><br /><br />
		  		<label for="initialDate">Initial Date:</label>
		  		<input class="datepicker" type="text" name="initialDate" placeholder="Initial Date" value="${wcf:dateInDatepickerFormat(work.initialDate)}"><br /><br />
		  		<c:if test="${work.latestUserWork}" >
		  			<label for="currentJob">Current Job:</label>
		  			<input type="checkbox" class="currentJobCheckbox" name="current" value="current" ${wcf:checkboxChecked(work.current)}  >
		  		</c:if>	  		
		  		<label for="finalDate" class="finalDateLabel">Final Date:</label>
		  		<input class="datepicker finalDateInput" type="text" name="finalDate" placeholder="Final Date" value="${wcf:dateInDatepickerFormat(work.finalDate)}"><br /><br />
		  		<label for="initialDate">Position:</label>
		  		<input type="text" name="position" placeholder="Position" value="${work.position}"><br /><br />	  			  		
		  </fieldset>
		  </form>
		</div> 		
					
  	</c:forEach> 	
                                                                      
  </div>
  <!-- .category_body --> 
</div>

<script>

	<c:if test="${authenticatedUser}">
	
		jQuery(document).ready(function(){
			enableDescriptions();							  
		});
	</c:if>
</script>

