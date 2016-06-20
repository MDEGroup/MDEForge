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
<!-- Dropzone configuration -->
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/mydropzone.js"></script>
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
				<div class="widget-body">
					<div class="tab-content">

						<div class="widget widget-heading-simple widget-body-white">
							<div class="widget-body">
								<div class="row-fluid">
									<form action="${pageContext.request.contextPath}/public/search" method="POST" class="form-search">
										
										<div class="center">
											<div
												class="widget widget-heading-simple widget-body-simple text-right">

												<input type="text" class="input-large"
													placeholder="Type your keywords .. " name="search_string"
													id="searchField" value="${search_string}" style="width:90%">
												<button type="submit" class="btn btn-inverse">
													<spring:message code="mdeforge.common.action.search" />
												</button>
											</div>
										</div>
									</form>
									
									<div class="center">
											<div class="widget widget-heading-simple widget-body-simple margin-none">
												<c:forEach items="${indexFieldNames}" var="indexFieldName">
													<span class="label">${indexFieldName}:</span>
												</c:forEach>												
											</div>
										</div>
									
								</div>
							</div>
						</div>

						<c:choose>
							<c:when test="${artifactList.size() > 0}">
								<div
									class="widget widget-heading-simple widget-body-white">
									<div class="widget-body">
										<h5 class="text-uppercase strong separator bottom">${artifactList.size()}
											Search results</h5>
										<c:forEach items="${artifactList}" var="artifact">
											<div class="row-fluid">
												<div class="span12">
													<h5 class="strong text-uppercase">
														<c:choose>
															<c:when test="${artifact.open == true}">
																<a
																	href="${pageContext.request.contextPath}/public/${artifact.getClass().getSimpleName()}/artifact?artifact_id=${artifact.getId()}">${artifact.getName()}</a>
															</c:when>
															<c:otherwise>
																<a
																	href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/artifact?artifact_id=${artifact.getId()}">${artifact.getName()}</a>

															</c:otherwise>
														</c:choose>
													</h5>
													<span class="badge badge-success">Score: <fmt:formatNumber
															type="number" maxFractionDigits="3"
															value="${artifact.getScore()}" /></span>
													<p>
														<c:set var="existDescription" value="false" />
														<c:set var="description" value="" />
														<c:forEach items="${artifact.properties}" var="property">

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
													<span class="badge badge-important">${artifact.getClass().getSimpleName() }</span>

													<span class="label">Last update: <fmt:formatDate
															type="date" value="${artifact.getModified()}" /></span>
													<p class="margin-none strong">
														<a
															href="${pageContext.request.contextPath}/public/${artifact.getClass().getSimpleName() }/ownload?artifact_id=${artifact.getId()}"
															title="${artifact.getClass().getSimpleName() } Download"
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

