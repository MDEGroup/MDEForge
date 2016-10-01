<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/css/fileupload.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" rel="stylesheet" />



<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="#" class="glyphicons dashboard"><i></i> Private Area</a></li>
		<li class="divider"></li>
		<li> Use</li>
		<li class="divider"></li>
		<li>${artifact.getClass().getSimpleName()} Upload</li>
</ul>
<!-- Breadcrumb END -->


<h3 class="header-h main-title">${artifact.getClass().getSimpleName()} Upload</h3>
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p> -->

<div class="innerLR">

<form:form cssClass="form-horizontal" modelAttribute="artifact" 
	action="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/upload" role="form" method="POST" enctype="multipart/form-data">
	<div class="widget widget-heading-simple">
		
			<!-- Widget heading 
			<div class="widget-head">
				<h4 class="heading">Upload new ${artifact.getClass().getSimpleName()}</h4>
			</div> -->
			<!-- // Widget heading END -->
			
			<div class="widget-body">
			
				<!-- Row -->
				<div class="row-fluid">
				
					<!-- Column -->
					<div class="span6">
						<!-- Group -->
							<h5 class="input-name">${artifact.getClass().getSimpleName()} Name</h5>
								<input type="text" name="name" id="artifactTitle"/>
							<h5 class="input-name">${artifact.getClass().getSimpleName()} Description</h5>
								<textarea name="description"></textarea>
							<!-- // Group END -->
							<h5 class="input-name">Visibility</h5>
									<select name="open">
										<option value="true">Public</option>
										<option value="false">Private</option>
									</select>
					<!-- // Column END -->
					</div>
					<div class="span6">
					 <div class="box__input">
					    <!-- <input class="box__file" type="file" name="files[]" id="file" data-multiple-caption="{count} files selected" multiple />
					    <label for="file"><strong>Choose a file</strong><span class="box__dragndrop"> or drag it here</span>.</label>
					    <button class="box__button" type="submit">Upload</button>
					  </div>
					  <div class="box__uploading">Uploading&hellip;</div>
					  <div class="box__success">Done!</div>
					  <div class="box__error">Error! <span></span>.</div> -->
						<h5 class="input-name center">Upload ${artifact.getClass().getSimpleName()} File</h5>
						<label for="artifactName"><div><img width="150px" class="img-center" src="${pageContext.request.contextPath}/resources/theme/images/newfile.png"></div></label>
						<div class="fileupload fileupload-new" data-provides="fileupload">
							  	<div class="input-append center" style="width: 100%">
							  		<span class="btn btn-default btn-file">
								    	<span class="fileupload-new">Select ${artifact.getClass().getSimpleName()} File</span>
								    	<span class="fileupload-exists">Change</span>
								    	<input type="file" id="artifactName" class="margin-none" name="artifactfile" size="40"/>
							    	</span>
							    	<div class="uneditable-input center"><i class="icon-file fileupload-exists"></i> 
							    		<span class="fileupload-preview"></span>
							    	</div>
							    	
							    	<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
							  	</div>
						</div>
						
					</div>
						<!-- // Row END -->
					</div>
					<!-- // Column END -->
				
				<!-- // Row END-->
				
				<hr class="separator">
				<div class="row-fluid">
					<!-- Row -->
					<div class="span12">
						<h5 class="input-name">Properties</h5>
							<table id="propertiesT">
								<thead>
									<tr>
										<th>Name</th>
									
										<th>Value</th>
										<th></th>
									</tr>
								</thead>
								<tbody id="propertiesTable">
								</tbody>
							</table>
							<button type="button" id="addPropertyButton" class="btn btn-primary">Add New Property</button>
					</div>
				</div>	
				<div class="separator"></div>		
				<hr class="separator">
				<div class="row-fluid">
					<div class="span6">
					<h5 class="input-name">Add To Project</h5>
						<form:select path="projects" multiple="true">
									<form:options  items="${projecList}" itemValue="id" itemLabel="name"></form:options>
						</form:select>
					</div>			
					
					<div class="span6">
					<h5 class="input-name">Share With</h5>
						<form:select path="shared" multiple="true">
									<form:options  items="${userList}" itemValue="id" itemLabel="username"></form:options>
						</form:select>
					</div>				
				</div>
				<tiles:insertAttribute name="central" ignore="true"/>
				<div class="separator"></div>
				<div class="row-fluid">
					<div class="span12">
					<div class="form-actions">
						<button type="submit" class="btn btn-large btn-primary glyphicons cloud-upload"><i></i> Upload</button>
						<button type="button" class="btn btn-large btn-default">Cancel</button>
					</div>
					</div>
				</div>
				<!-- // Form actions END -->
				
			</div>
		</div>
</form:form>
</div>	
<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/spinner/spin.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/dynamicRow.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/js/bootstrap-fileupload.js"></script>

	