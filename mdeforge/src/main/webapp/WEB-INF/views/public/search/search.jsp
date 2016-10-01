<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/css/fileupload.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/js/bootstrap-fileupload.js"></script>
<!-- Mustache -->
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<!-- Spin.js -->
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/spinner/spin.min.js"></script>
<!-- Dropzone configuration 
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/mydropzone.js"></script>-->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a
		href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full"
		class="glyphicons dashboard"><i></i> Search area</a></li>
</ul>
<!-- Breadcrumb END -->
<h3 class="header-h main-title">Search Page</h3>
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis.</p> -->

<div class="innerLR">
<div id="alert-box" style="margin: 20px 0 0"></div>
<div class="box-generic">
	<div class="row-fluid">
		<form id="searchForm" action="${pageContext.request.contextPath}/public/search" method="POST" class="form-search form-horizontal">
			
			<div class="span12">
					<input type="text" class="input-large"
						placeholder="Search" name="search_string"
						id="searchField" value="${searchResultComplete.getQueryString()}">
			<button id="submit-search" type="submit" class="btn btn-primary">
						<i class="icon-search"></i>
					</button>
			</div>
		</div>	

		<div class="separator"></div>
		<div class="row-fluid">
			<div class="span12 center">

			<div class="widget widget-tabs tabs-tags">
			
			    <!-- Tabs Heading -->
			    <div class="widget-head">
			        <ul>
			            <li class="active"><a href="#tab-1" data-toggle="tab">Atifacts Tags</a></li>
			            <li><a href="#tab-2" data-toggle="tab">Metamodels Tags</a></li>
			            <li><a href="#tab-2" data-toggle="tab">Transformations Tags</a></li>
			            <li><a href="#tab-2" data-toggle="tab">Models Tags</a></li>
			            <li style="border-right: none;"><label class="checkbox" style="margin-left: 10px; display: inline-block;">
							<input type="checkbox" class="checkbox" name="isFuzzy" value=true>
							Fuzzy
						</label></li>
			        </ul>
			    </div>
			    <!-- // Tabs Heading END -->
			
			    <div class="widget-body" style="padding-top: 5px">
			        <div class="tab-content">
			
			            <!-- Tab content -->
			            <div class="tab-pane active" id="tab-1">
			                <c:forEach items="${indexFieldNames}" var="indexFieldName">
								<span class="label search-tag" data-value="${indexFieldName}:">${indexFieldName}:</span>
							</c:forEach>
						</div>
			            <!-- // Tab content END -->
			
			            <!-- Tab content -->
			            <div class="tab-pane" id="tab-2">
			                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch.</p>
			            </div>
			            <!-- // Tab content END -->
			
			        </div>
			    </div>
			</div>											
			</div>
		</div>
		</form>
	</div>				
	<div class="row-fluid" id="search-result">
		<div class="span12">
			<div class="widget widget-tabs">
				<div class="">
					<div class="tab-content">


						<c:choose>
							<c:when test="${searchResultComplete.results.size() > 0}">
							<div class="box-generic">
								<h3 class="header-h main-title">Results for: <span class="strong text-primary">${searchResultComplete.getQueryString()}</span></h3>
							</div>
								<div class="widget widget-heading-simple widget-body-white">
									<div class="widget-body">
										<h5 class="strong separator bottom"><span class="strong text-primary">${searchResultComplete.getPageNumber()}</span> of ${searchResultComplete.getPages()} pages <strong class="pull-right"><span class="strong text-primary">${searchResultComplete.getTotalHits()}</span> results in ${searchResultComplete.getSearchTime()} ms. </strong></h5> 
										<hr class="separator bottom">
										<c:forEach items="${searchResultComplete.results}" var="result">
											<div class="row-fluid">
												<div class="span10">
													<h4>
														<c:choose>
															<c:when test="${result.artifact.open == true}">
																<a class="result-entry" href="${pageContext.request.contextPath}/public/${result.artifact.getClass().getSimpleName()}/artifact?artifact_id=${result.artifact.getId()}">${result.artifact.getName()}</a>
															</c:when>
															<c:otherwise>
																<a class="result-entry" href="${pageContext.request.contextPath}/private/${result.artifact.getClass().getSimpleName()}/artifact?artifact_id=${result.artifact.getId()}">${result.artifact.getName()}</a>
															</c:otherwise>
														</c:choose>
													</h4>
													<span class="text-primary">${result.artifact.getClass().getSimpleName()}</span>
													
													
													<br>
													
													<c:choose>
															<c:when test="${result.getFragments() != null}">
																<c:forEach items="${result.getFragments()}" var="fragment">
																	<p>... ${fragment} ...</p>
														  		</c:forEach>
															</c:when>
															<c:otherwise>
																<i>No description</i>
															</c:otherwise>
														</c:choose>
													
												<%-- <p>
													 	<c:set var="existDescription" value="false" />
														<c:set var="description" value="" />
														<c:forEach items="${result.artifact.properties}" var="property">

															<c:if test="${property.getName() == 'Description '}">
																<c:set var="existDescription" value="true" />
																<c:set var="description" value="${property.getValue()}" />

															</c:if>
														</c:forEach>

														<c:choose>
															<c:when test="${existDescription == 'true'}">
																<c:out value="${description}" />
															</c:when>
															<c:otherwise>
																<i>No description</i>
															</c:otherwise>
														</c:choose>
 
 												

													</p>
													--%>
													
													<br>
													
														
														<span class="btn btn-success">Score: <fmt:formatNumber type="number" maxFractionDigits="3" value="${result.getScore()}" /></span>
														<span class="separator top" >Last update: <strong><fmt:formatDate type="date" value="${result.artifact.getModified()}" /></strong></span>
													
													
												</div>
												<div class="span2">
													<a		class="hidden-phone"
															href="${pageContext.request.contextPath}/public/${result.artifact.getClass().getSimpleName() }/download?artifact_id=${result.artifact.getId()}"
															title="${result.artifact.getClass().getSimpleName() } Download"
															><button class="btn entry-button" type="button"><i class=" icon-cloud-download"></i></button></a>
													
													<a		class="hidden-desktop hidden-tablet"
															href="${pageContext.request.contextPath}/public/${result.artifact.getClass().getSimpleName() }/download?artifact_id=${result.artifact.getId()}"
															title="${result.artifact.getClass().getSimpleName() } Download"
															><button class="btn btn-primary btn-small" type="button">Download</button></a>
												</div>
											</div>
											<hr class="separator">
										</c:forEach>
										
										<!-- START Pagination -->
										<div class="pagination margin-none">
											<form id="paginationForm" action="${pageContext.request.contextPath}/public/search#search-result" method="POST">
												<input type="hidden" name="search_string" value="${searchResultComplete.getQueryString()}">
												<input id="pageInput" type="hidden" name="page" value="">
												<ul>
													<!--  Prev Page -->
													<c:choose>
														<c:when test="${searchResultComplete.getPageNumber() == 1 }">
															<li class="disabled"><a href="#" class="disabled">&lt;</a></li>
														</c:when>
														<c:otherwise>
															<li class="search-pagination" data-value="${searchResultComplete.getPageNumber()-1}"><a href="#">&lt;</a></li>
														</c:otherwise>
													</c:choose>
													
													<!-- Numbers -->
													<c:set var="after" value="false"/>
													<c:set var="before" value="false"/>
													<c:choose>
														<c:when test="${searchResultComplete.getPageNumber()+2 >= searchResultComplete.getPages()}">
															<c:set var="begin" value="${searchResultComplete.getPages()-4}"/>
															<c:set var="end" value="${searchResultComplete.getPages()}"/>
														</c:when>
														<c:otherwise>
															<c:set var="after" value="true"/>
															<c:set var="begin" value="${searchResultComplete.getPageNumber()-2}"/>
															<c:set var="end" value="${searchResultComplete.getPageNumber()+2}"/>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${searchResultComplete.getPageNumber()-2 > 1}">
															<c:if test="${searchResultComplete.getPageNumber() - searchResultComplete.getPageNumber() > 3 }">
																<c:set var="begin" value="${searchResultComplete.getPages()-2}"/>
															</c:if>
															<c:set var="before" value="true"/>
														</c:when>
														<c:otherwise>
															<c:set var="begin" value="1"/>
														</c:otherwise>
													</c:choose>
														

													<c:if test="${before == true }">
														<li class="disabled"><a href="#" class="disabled"><i class=" icon-ellipsis-horizontal"></i></a></li>
													</c:if>
													<c:forEach begin="${begin }" end="${end}" varStatus="loop">
																<c:choose>
																	<c:when test="${loop.index == searchResultComplete.getPageNumber()}">
																		<li class="active"><a href="#">${loop.index}</a></li>
																	</c:when>
																	<c:otherwise>
																		<li><a href="#" class="search-pagination" data-value="${loop.index}">${loop.index}</a></li>
																	</c:otherwise>
																</c:choose>
													</c:forEach>
													<c:if test="${after == true }">
														<li class="disabled"><a href="#" class="disabled"><i class=" icon-ellipsis-horizontal"></i></a></li>
													</c:if>
													
													<!-- Next Page -->
													<c:choose>
														<c:when test="${searchResultComplete.getPageNumber() == searchResultComplete.getPages() }">
															<li class="disabled"><a href="#" class="disabled">&gt;</a></li>
														</c:when>
														<c:otherwise>
															<li class="search-pagination" data-value="${searchResultComplete.getPageNumber()+1}"><a href="#">&gt;</a></li>
														</c:otherwise>
													</c:choose>
												
												</ul>
												<h5 class="strong separator"><span class="strong text-primary">${searchResultComplete.getPageNumber()}</span> of <span class="strong text-primary">${searchResultComplete.getPages()}</span> pages</h5>
												
											
											</form>
											
											<!-- End Pagination -->
											
										</div>

									</div>
								</div>
							</c:when>
							<c:otherwise>
								<c:if test="${not empty searchResultComplete.getQueryString()}">
								<div class="row-fluid" id="search-result">
									<div class="span12">
										<div class="widget widget-tabs">
											<div class="">
												<div class="tab-content">
													
														<div class="box-generic">
															<h3 class="header-h main-title">Results for: <span class="strong text-primary">${searchResultComplete.getQueryString()}</span></h3>
															<hr class="separator">
															<p>No Artifact Found</p>
														</div>
													</div>
											</div>
							
										</div>
									</div>
								</div>
								</c:if>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- SEARCH BY FILE -->
					
					<%-- <div class="widget widget-heading-simple widget-body-white">
						<div class="widget-body">
							<form:form cssClass="form-horizontal" modelAttribute="metamodel"
								action="${pageContext.request.contextPath}/public/search_metamodel_by_example/result"
								role="form" method="POST" enctype="multipart/form-data">
								<h4 class="separator bottom">Example Metamodel Upload</h4>
								<div class="row-fluid">
									<div class="span8">
										<div
											class="widget widget-heading-simple widget-body-simple margin-none">

											<div class="fileupload fileupload-new margin-none"
												data-provides="fileupload">
												<div class="input-append">
													<div class="uneditable-input span6">
														<i class="icon-file fileupload-exists"></i> <span
															class="fileupload-preview"></span>
													</div>
													<span class="btn btn-default btn-file"><span
														class="fileupload-new">Select Metamodel File</span><span
														class="fileupload-exists">Change</span><input type="file"
														class="margin-none" name="metamodelfile" size="40" /></span><a
														href="#" class="btn fileupload-exists"
														data-dismiss="fileupload">Remove</a>
												</div>
											</div>


										</div>
									</div>

									<div class="span4 center">
										<div
											class="widget widget-heading-simple widget-body-simple margin-none">


											<button type="submit" class="btn btn-primary btn-label-left"
												data-loading-text="Now searching ..."
												data-toggle="btn-loading">
												<i class="icon-search"></i>
												<spring:message code="mdeforge.common.action.search" />
											</button>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>

					<c:choose>
						<c:when test="${artifactListByExample.size() > 0}">
							<div
								class="widget widget-heading-simple widget-body-white margin-none">
								<div class="widget-body">
									<h5 class="text-uppercase strong separator bottom">${artifactListByExample.size()}
										Search results</h5>

									<c:forEach items="${artifactListByExample}" var="artifact">
										<div class="row-fluid">

											<div class="span12">
												<h5 class="strong text-uppercase">
													<a
														href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${artifact.getId()}">${artifact.getName()}</a>
												</h5>
												<p>
													<c:set var="existDescription" value="false" />
													<c:set var="description" value="" />
													<c:forEach items="${artifact.properties}" var="property">

														<c:if test="${property.getName() == 'Description'}">
															<c:set var="existDescription" value="true" />
															<c:set var="description" value="${property.getValue()}" />

														</c:if>
													</c:forEach>

													<c:choose>
														<c:when test="${existDescription == 'true'}">
															<c:out value="${description}" />
														</c:when>
														<c:otherwise>
															<i>No description</i>
														</c:otherwise>
													</c:choose>


												</p>
												<p class="margin-none strong">
													<a
														href="${pageContext.request.contextPath}/public/browse/metamodel_download?metamodel_id=${artifact.getId()}"
														title="Metamodel Download"
														class="glyphicons single download_alt"><i></i>Download</a>
												</p>
											</div>
										</div>
										<hr class="separator">
									</c:forEach>
								</div>
							</div>
						</c:when>
						<c:when test="${artifactList != null}">
						</c:when>
						<c:otherwise>
							<div
								class="widget widget-heading-simple widget-body-white margin-none">
								<div class="widget-body">
									<h5 class="text-uppercase strong separator bottom">No
										Results</h5>
								</div>
							</div>
						</c:otherwise>
					</c:choose> --%>
					
					<!-- END SEARCH BY FILE -->
				</div>

			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		var search_input = $("#searchField")
		var st = ""; //search string
		var page_input = $("#pageInput");
		var alert_box = $("#alert-box")
		
		search_input.focus(function(){
			$(this).removeClass("error-border");
		})
		
		$(".search-tag").click(function(){
			st = search_input.val() + $(this).data("value");
			search_input.val(st).focus();
		})
		
		$('.search-pagination').click(function(e){
			e.preventDefault();
			page_input.val($(this).data("value"));
			$("#paginationForm").submit()
		})
		
		$("#searchForm").submit(function(e){
			var valid = true;
			var str = search_input.val();
			var sub = str.substr(str.length - 1, 1)
			if(str == ""){
				alert_box.html('<div class="alert alert-error submitAlert"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 25px;"><i class="icon-remove"></i></button><span>Search string is empty.</span></div>')
				valid = false;
			}
			if(sub == ":"){
				alert_box.html('<div class="alert alert-error submitAlert"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 25px;"><i class="icon-remove"></i></button><span>Tags needs argument.</span></div>')
				valid = false;
			}
			
			if(!valid){
				search_input.addClass("error-border")
				e.preventDefault();
			}
			
			
		})
		
		
	})
	
</script>
