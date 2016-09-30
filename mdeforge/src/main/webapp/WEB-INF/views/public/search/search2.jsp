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
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis.</p>
<div class="separator"></div>
<div class="innerLR">
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
	<div class="row-fluid">
		<div class="span12">
			<div class="widget widget-tabs">
				<div class="widget-body">
					<div class="tab-content">


						<c:choose>
							<c:when test="${searchResultComplete.results.size() > 0}">
								<div class="widget widget-heading-simple widget-body-white">
									<div class="widget-body">
										<h5 class="text-uppercase strong separator bottom">${searchResultComplete.getTotalHits()} results in ${searchResultComplete.getSearchTime()} ms. (${searchResultComplete.getPages()} pagine)</h5> 
										<c:forEach items="${searchResultComplete.results}" var="result">
											<div class="row-fluid">
												<div class="span12">
													<h5 class="strong text-uppercase">
														<c:choose>
															<c:when test="${result.artifact.open == true}">
																<a href="${pageContext.request.contextPath}/public/${result.artifact.getClass().getSimpleName()}/artifact?artifact_id=${result.artifact.getId()}">${result.artifact.getName()}</a>
															</c:when>
															<c:otherwise>
																<a href="${pageContext.request.contextPath}/private/${result.artifact.getClass().getSimpleName()}/artifact?artifact_id=${result.artifact.getId()}">${result.artifact.getName()}</a>
															</c:otherwise>
														</c:choose>
													</h5>
													<span class="badge badge-important">${result.artifact.getClass().getSimpleName()}</span>
													
													
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
													<p>
														<span class="label">Last update: <fmt:formatDate type="date" value="${result.artifact.getModified()}" /></span>
														<span class="badge badge-success">Score: <fmt:formatNumber type="number" maxFractionDigits="3" value="${result.getScore()}" /></span>
													</p>
													<p class="margin-none strong">
														<a
															href="${pageContext.request.contextPath}/public/${result.artifact.getClass().getSimpleName() }/ownload?artifact_id=${result.artifact.getId()}"
															title="${result.artifact.getClass().getSimpleName() } Download"
															class="glyphicons single download_alt"><i></i>Download</a>
													</p>
												</div>
											</div>
											<hr class="separator">
										</c:forEach>
										
										<!-- START Pagination -->
										<div class="pagination margin-none">
											<ul>
												<li class="disable"><a href="#">&lt;</a></li>
												<c:choose>
													<c:when test="${searchResultComplete.getPageNumber() != 1}">
														<form action="${pageContext.request.contextPath}/public/search" method="POST">
															<input type="hidden" name="search_string" value="${searchResultComplete.getQueryString()}">
															<input type="hidden" name="page" value="${searchResultComplete.getPageNumber()-1}">
															<input type="submit" name="submit">
														</form>
													</c:when>
													<c:otherwise>
														<input type="submit" name="submit">
													</c:otherwise>
												</c:choose>

												<c:forEach begin="1" end="${searchResultComplete.getPages()}" varStatus="loop">
													<c:choose>
														<c:when test="${loop.index == searchResultComplete.getPageNumber()}">
															<li class="active"><a href="#">${loop.index}</a></li>
															<input type="submit" name="submit">
														</c:when>
														<c:otherwise>
															<li><a href="#">${loop.index}</a>
																<form action="${pageContext.request.contextPath}/public/search" method="POST">
																	<input type="hidden" name="search_string" value="${searchResultComplete.getQueryString()}">
																	<input type="hidden" name="page" value="${loop.index}">
																	<input type="submit" name="submit">
																</form></li>
														</c:otherwise>
													</c:choose>
												</c:forEach>

												<li class="disable"><a href="#">&gt;</a></li>
												<c:choose>
													<c:when test="${searchResultComplete.getPageNumber() != searchResultComplete.getPages()}">
														<form action="${pageContext.request.contextPath}/public/search" method="POST">
															<input type="hidden" name="search_string" value="${searchResultComplete.getQueryString()}">
															<input type="hidden" name="page" value="${searchResultComplete.getPageNumber()+1}">
															<input type="submit" name="submit">
														</form>
													</c:when>
													<c:otherwise>
														<input type="submit" name="submit">
													</c:otherwise>
												</c:choose>
											</ul>
										</div>
										<!-- END Pagination -->

									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div
									class="widget widget-heading-simple widget-body-white">
									<div class="widget-body">
										<h5 class="text-uppercase strong separator bottom">No
											Results</h5>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

					<div class="widget widget-heading-simple widget-body-white">
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
					</c:choose>
				</div>

			</div>
		</div>
	</div>
</div>
</div>
<script>
	$(document).ready(function(){
		var search_input = $("#searchField")
		var st = ""; //search string
		
		$(".search-tag").click(function(){
			st = search_input.val() + $(this).data("value");
			search_input.val(st).focus();
		})
	})
	
</script>
