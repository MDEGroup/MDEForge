<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/css/fileupload.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" rel="stylesheet" />





<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a
		href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full"
		class="glyphicons dashboard"><i></i> Search area</a></li>
	
</ul>
<!-- Breadcrumb END -->


<h3>Search Page</h3>




<div class="innerLR">

	<div class="row-fluid">
		<div class="span12">
		
			<div class="widget widget-tabs">
				<div class="widget-head">
					<ul>
						<c:choose>
						  <c:when test="${artifactList.size() > 0 || (artifactList == null && artifactListByExample.size() == null)}">
						    <li class="active">
						  </c:when>
						  <c:otherwise>
						    <li>
						  </c:otherwise>
						</c:choose>
						<a href="#search-simple" data-toggle="tab">Simple search</a></li>
						
						<c:choose>
						  <c:when test="${artifactListByExample.size() > 0}">
						    <li class="active">
						  </c:when>
						  <c:otherwise>
						    <li>
						  </c:otherwise>
						</c:choose>
						<a href="#search-by-example" data-toggle="tab">Metamodel Search By Example</a></li>
					</ul>
				</div>
				<div class="widget-body">
					<div class="tab-content">
					
					
					
					<c:choose>
					  <c:when test="${artifactList.size() > 0 || (artifactList == null && artifactListByExample.size() == null)}">
					  	<div class="tab-pane active" id="search-simple">
					  </c:when>
					  <c:otherwise>
					  	<div class="tab-pane" id="search-simple">
					  </c:otherwise>
					 </c:choose>
					
							<div class="widget widget-heading-simple widget-body-white">
						
						<div class="widget-body">
							
							<div class="row-fluid">
							<form action="${pageContext.request.contextPath}/public/search" method="get" class="form-search">
										<div class="span6 center">
											<div class="widget widget-heading-simple widget-body-simple margin-none">
												
												
														<div class="uniformjs">
															<label class="checkbox" style="display: inline-block;">
																<div class="checker" id="uniform-undefined"><span><input type="checkbox" class="checkbox" name="artifactType" value="models" style="opacity: 0;"></span></div>
																Models
															</label>
															<label class="checkbox" style="display: inline-block; margin-left: 10px;">
																<div class="checker" id="uniform-undefined"><span class="checked"><input type="checkbox" class="checkbox" name="artifactType" value="metamodels" checked="checked" style="opacity: 0;"></span></div>
																Metamodels
															</label>
															<label class="checkbox" style="display: inline-block; margin-left: 10px;">
																<div class="checker" id="uniform-undefined"><span class="checked"><input type="checkbox" class="checkbox" name="artifactType" value="transformations" style="opacity: 0;"></span></div>
																Transformations
															</label>
														</div>
													</div>
												
										</div>
										
										<div class="span6 center">
											<div class="widget widget-heading-simple widget-body-simple text-right">
											
												  	<input type="text" class="input-large" placeholder="Type your keywords .. " name="search_string" id="searchField">
												  	<button type="submit" class="btn btn-inverse">
												  		<spring:message code="mdeforge.common.action.search" />
												  	</button>
												
											</div>
											
											</form>
											
											
											
											
										
										</div>
										</div>
											</div>
							</div>
							
							
							
							<c:choose>
							  <c:when test="${artifactList.size() > 0}">
							   			<div class="widget widget-heading-simple widget-body-white margin-none">
											<div class="widget-body">
												<h5 class="text-uppercase strong separator bottom">${artifactList.size()} Search results</h5>
												
												<c:forEach items="${artifactList}" var="artifact">
													<div class="row-fluid">	
														<div class="span2 center">
															<a href="" class="thumb"><img data-src="holder.js/150x100" alt="150x100" src="data:image/png;base64,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" style="width: 150px; height: 100px;"></a>
														</div>
														<div class="span10">
															<h5 class="strong text-uppercase">
																<a href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${artifact.getId()}">${artifact.getName()}</a>
															</h5>
															<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
															<p class="label label-inverse"><fmt:formatDate type="date" value="${artifact.getModified()}" /></p>
															<p class="margin-none strong">
																<a href="${pageContext.request.contextPath}/public/browse/metamodel_download?metamodel_id=${artifact.getId()}" title="Metamodel Download" class="glyphicons single download_alt"><i></i>Download</a>
															</p>
														</div>
													</div>
													<hr class="separator">
												</c:forEach>
												
												
												<div class="pagination margin-none">
												    <ul>
												        <li class="disabled"><a href="#">&lt;</a></li>
												        <li class="active"><a href="#">1</a></li>
												        <li><a href="#">2</a></li>
												        <li><a href="#">3</a></li>
												        <li><a href="#">&gt;</a></li>
												    </ul>
												</div>
												
											</div>
							 			</div>
							  </c:when>
							 	 <c:otherwise>
						  			<!-- <div class="widget widget-heading-simple widget-body-white margin-none">
											<div class="widget-body">
												<h5 class="text-uppercase strong separator bottom">No Results</h5>
											</div>
									</div> -->
						    	</c:otherwise>
							</c:choose>
							
						</div>
						
						
					<c:choose>
					  <c:when test="${artifactListByExample.size() > 0}">
					  	<div class="tab-pane active" id="search-by-example">
					  </c:when>
					  <c:otherwise>
					  	<div class="tab-pane" id="search-by-example">
					  </c:otherwise>
					 </c:choose>
						
							
							<div class="widget widget-heading-simple widget-body-white">
								<div class="widget-body">
								<form:form cssClass="form-horizontal" modelAttribute="metamodel" action="${pageContext.request.contextPath}/public/search_metamodel_by_example/result" role="form" method="POST" enctype="multipart/form-data">
							
									<h4 class="separator bottom">Example Metamodel Upload</h4>
									<div class="row-fluid">
										<div class="span8">
											<div class="widget widget-heading-simple widget-body-simple margin-none">
												
													<div class="fileupload fileupload-new margin-none" data-provides="fileupload">
													  	<div class="input-append">
													    	<div class="uneditable-input span6"><i class="icon-file fileupload-exists"></i> <span class="fileupload-preview"></span></div><span class="btn btn-default btn-file"><span class="fileupload-new">Select Metamodel File</span><span class="fileupload-exists">Change</span><input type="file" class="margin-none" name="metamodelfile" size="40"/></span><a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
													  	</div>
													</div>
												
												
											</div>
										</div>
										
										<div class="span4 center">
											<div class="widget widget-heading-simple widget-body-simple margin-none">
												
												
												<button type="submit" class="btn btn-primary btn-label-left" data-loading-text="Now searching ..." data-toggle="btn-loading"><i class="icon-search"></i> <spring:message code="mdeforge.common.action.search" /></button>
											</div>
										</div>
									</div>
								</form:form>
		
								</div>
								</div>
							
							
								<c:choose>
							  <c:when test="${artifactListByExample.size() > 0}">
							   			<div class="widget widget-heading-simple widget-body-white margin-none">
											<div class="widget-body">
												<h5 class="text-uppercase strong separator bottom">${artifactListByExample.size()} Search results</h5>
												
												<c:forEach items="${artifactListByExample}" var="artifact">
													<div class="row-fluid">	
														
														<div class="span12">
															<h5 class="strong text-uppercase">
																<a href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${artifact.getId()}">${artifact.getName()}</a>
															</h5>
															<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
															<p class="margin-none strong">
																<a href="${pageContext.request.contextPath}/public/browse/metamodel_download?metamodel_id=${artifact.getId()}" title="Metamodel Download" class="glyphicons single download_alt"><i></i>Download</a>
															</p>
														</div>
													</div>
													<hr class="separator">
												</c:forEach>
												
												
												<div class="pagination margin-none">
												    <ul>
												        <li class="disabled"><a href="#">&lt;</a></li>
												        <li class="active"><a href="#">1</a></li>
												        <li><a href="#">2</a></li>
												        <li><a href="#">3</a></li>
												        <li><a href="#">&gt;</a></li>
												    </ul>
												</div>
												
											</div>
										</div>
							  </c:when>
							 	 <c:otherwise>
						  			<!-- <div class="widget widget-heading-simple widget-body-white margin-none">
											<div class="widget-body">
												<h5 class="text-uppercase strong separator bottom">No Results</h5>
											</div>
									</div> -->
						    	</c:otherwise>
							</c:choose>
						</div>
						
					</div>
				</div>
			</div>
			
		</div>
		
	</div>	
</div>


<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/js/bootstrap-fileupload.js"></script>
