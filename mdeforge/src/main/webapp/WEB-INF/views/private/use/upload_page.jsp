<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
		<li>Upload Page</li>
</ul>
<!-- Breadcrumb END -->



<h3>Upload Page</h3>


<div class="innerLR">

<form:form cssClass="form-horizontal" modelAttribute="metamodel" action="${pageContext.request.contextPath}/private/EcoreMetamodel/upload" role="form" method="POST" enctype="multipart/form-data">
	<div class="widget widget-heading-simple widget-body-gray">
		
			<!-- Widget heading -->
			<div class="widget-head">
				<h4 class="heading">Upload new Ecore Metamodel</h4>
			</div>
			<!-- // Widget heading END -->
			
			<div class="widget-body">
			
				<!-- Row -->
				<div class="row-fluid">
				
					<!-- Column -->
					<div class="span6">
					
						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Metamodel Description</label>
							<div class="controls">
								<textarea class="span12" rows="5" cols="100" name="metamodelDescription"></textarea>
							</div>
						</div>
						<!-- // Group END -->
						
					</div>
					<!-- // Column END -->
					
					<!-- Column -->
					<div class="span6">
						<div class="row-fluid uniformjs">
				
							<!-- Column -->
							<div class="span4">
								<h4 style="margin-bottom: 10px;">Private or Public</h4>
								<div class="widget-body uniformjs collapse in">
								<label class="radio">
									<div class="radio" id="uniform-undefined"><span><input type="radio" class="radio" name="publicPrivate" value="public" style="opacity: 0;"></span></div> Public
								</label><br>
								<label class="radio">
									<div class="radio" id="uniform-undefined"><span class="checked"><input type="radio" class="radio" name="publicPrivate" value="private" checked="checked" style="opacity: 0;"></span></div> Private
								</label><br>
								
							</div>
							</div>
							<!-- // Column END -->
						
							
						</div>
						<!-- // Row END -->
				
						
					</div>
					<!-- // Column END -->
					
				</div>
				<!-- // Row END -->


				<hr class="separator">
				
					<div class="control-group">
							<label class="control-label" for="email">Metamodel File</label>
							
							<div class="fileupload fileupload-new controls" data-provides="fileupload">
													  	<div class="input-append">
													    	<div class="uneditable-input"><i class="icon-file fileupload-exists"></i> 
													    		<span class="fileupload-preview"></span>
													    	</div>
													    	<span class="btn btn-default btn-file">
														    	<span class="fileupload-new">Select Metamodel File</span>
														    	<span class="fileupload-exists">Change</span>
														    	<input type="file" class="margin-none" name="metamodelfile" size="40"/>
													    	</span>
													    	<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
													  	</div>
													</div>

						</div>
					
			
				
				<!-- Row -->
				
				<hr class="separator">
				
				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Upload</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancel</button>
				</div>
				<!-- // Form actions END -->
				
			</div>
		</div>
</form:form>



	
</div>	





<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/js/bootstrap-fileupload.js"></script>
	