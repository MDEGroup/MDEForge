<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>

<style type="text/css">
#my_canvas {
	width: 100%;
	height: 200px;
}
</style>
<security:authentication property="principal.user.id" var="userId"/>
<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> Private
			Area</a></li>
	<li class="divider"></li>
	<li>Use</li>
	<li class="divider"></li>
	<li><spring:message
			code="mdeforge.public.back.browse.transformation_details.detail" /></li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="heading-buttons">
	<h3 id="artifactName" data-id="${atlTransformation.getId()}">${atlTransformation.getName()}
		<span> <c:choose>
				<c:when test="${atlTransformation.getOpen()}">		
							Public Transformation										  												    
				</c:when>
				<c:otherwise>
							Private Transformation										  
				</c:otherwise>
			</c:choose>
		</span>
	</h3>
	<%-- <div class="buttons pull-right">
					
		<a href="${pageContext.request.contextPath}/#" class="btn btn-success btn-icon glyphicons download_alt"><i></i>Download Metamodel</a>			
	</div> --%>
	<div class="clearfix"></div>
</div>
<div class="separator bottom"></div>
<!-- // Heading END -->
<div class="innerLR">
	<div class="row-fluid">
		<div class="span9 tablet-column-reset">
			<div
				class="widget widget-heading-simple widget-body-white widget-employees">
				<div class="widget-body padding-none">
					<div class="row-fluid row-merge">
						<div class="span12 detailsWrapper">
							<div class="innerAll">
								<div class="title">
									<div class="row-fluid">
										<div class="span8">
											<h3 class="text-primary">Info</h3>
											<span class="muted">Artifact</span>
										</div>
										<div class="span4 text-right">
											<p class="muted">
												Used in ${atlTransformation.getProjects().size()} projects <a
													href=""><i class="icon-circle-arrow-right"></i></a>
											</p>
										</div>
									</div>
								</div>
								<hr />
								<div class="body">
									<div class="row-fluid">
										<div class="span4 overflow-hidden">
											<h5 class="strong">Importer</h5>
											<!-- // Profile Photo END -->
											<ul class="icons-ul">
												<li><i class="icon-user icon-li icon-fixed-width"></i>
													${atlTransformation.getAuthor().getUsername()}</li>
												<li><i class="icon-info icon-li icon-fixed-width"></i>
													${atlTransformation.getAuthor().getFirstname()}
													${atlTransformation.getAuthor().getLastname()}</li>
												<li><i class="icon-envelope icon-li icon-fixed-width"></i>
													${atlTransformation.getAuthor().getEmail()}</li>
											</ul>
											<div class="separator bottom"></div>
											<h5 class="strong">General</h5>
											<!-- Profile Photo -->
											<div class="center">
												<table class="table table-condensed">
													<!-- Table body -->
													<tbody>
														<!-- Table row -->
														<tr>
															<td class="left">Creation Data</td>
															<td class="right"><fmt:formatDate type="both"
																	dateStyle="short" timeStyle="short"
																	value="${atlTransformation.getCreated()}" /></td>
														</tr>
														<!-- // Table row END -->

														<!-- Table row -->
														<tr>
															<td class="left">Last Modified</td>
															<td class="right"><fmt:formatDate type="both"
																	dateStyle="short" timeStyle="short"
																	value="${atlTransformation.getModified()}" /></td>
														</tr>
														<!-- // Table row END -->
													</tbody>
													<!-- // Table body END -->
												</table>
											</div>
										</div>
										<div class="span8">
											<h5 class="strong">Description</h5>
											<p>
												<c:forEach items="${atlTransformation.properties}"
													var="property">
													<c:if test="${property.getName() == 'Description '}">
															${property.getValue()}
														</c:if>
												</c:forEach>
											</p>
											<div class="row-fluid">
												<div class="span4">
													<h5 class="strong">Transformation File</h5>
													<a href="#modal-simple"
														class="btn btn-primary btn-small btn-block"
														data-toggle="modal"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize
														Transformation</a>
													<c:choose>
														<c:when test="${atlTransformation.open}">
															<a
																href="${pageContext.request.contextPath}/public/browse/transformation_download?transformation_id=${atlTransformation.getId()}"
																class="btn btn-success btn-small btn-block"><i
																class="icon-download-alt icon-fixed-width"></i> Download
																Transformation</a>
														</c:when>
														<c:otherwise>
															<a
																href="${pageContext.request.contextPath}/private/ATLTransformation/transformation_download?transformation_id=${atlTransformation.getId()}"
																class="btn btn-success btn-small btn-block"><i
																class="icon-download-alt icon-fixed-width"></i> Download
																Transformation</a>

														</c:otherwise>
													</c:choose>
													<c:if test="${userId == atlTransformation.getAuthor().getId()}">
															<a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${atlTransformation.getId()}"
															class="btn btn-block btn-danger btn-small"><i
															class="icon-remove-sign icon-fixed-width"></i> Delete
															Metamodel</a>
													</c:if>
													<!-- <a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> May</a>
													<a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> April</a> -->
													<div class="separator bottom"></div>
												</div>
												<div class="span1"></div>
												<div class="span6">
													<h5 class="text-uppercase strong text-primary">
														<i class="icon-group text-regular icon-fixed-width"></i>
														Shared Users <span
															class="text-lowercase strong padding-none">Team</span> <span
															class="text-lowercase padding-none">(${atlTransformation.getShared().size()}
															people)</span> <i class="icon-expand-alt" id="showUserList"></i>
													</h5>
													<div id="userList" class="row-fluid" style="display: none">
														<select id="userSelect">
														</select>
														<div>
															<span class="btn btn-block btn-primary span4"
																id="addUserArtifact">Add</span>
														</div>
													</div>
													<ul id="users" class="team">
														<c:forEach items="${atlTransformation.getShared()}"
															var="user" varStatus="count">
															<li class="userLi" data-id="${user.getId()}"><span
																class="crt">${count.count}</span><span class="strong">${user.getUsername()}</span><span
																class="muted">${user.getFirstname()}
																	${user.getLastname()}</span> <span class="muted"><a
																	href="mailto:${user.getEmail() }">${user.getEmail() }
																		<i class="icon-envelope"></i>
																</a></span> <span
																class="pull-right glyphicons icon-remove removeArtifactSharedUser"
																data-id="${user.getId()}"></span></li>
														</c:forEach>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<c:if test="${atlTransformation.atlError.size()== 0 && atlTransformation.atlTestError.size()==0}">
			<div class="widget widget-heading-simple widget-body-white">
				<div class="widget-body">
					<a
								href="${pageContext.request.contextPath}/private/ATLTransformation/analysis?transformation_id=${atlTransformation.getId()}"
								class="btn btn-success btn-small btn-block"><i
								class="icon-play icon-fixed-width"></i> Analyze Transformation</a>
				</div>
			</div>
			</c:if>
			<c:if test="${atlTransformation.atlError.size() != 0}">
				<div class="widget widget-heading-simple widget-body-white">
					<div class="widget-head">
						<h3 class="heading glyphicons show_thumbnails">
							<i></i>anATLyzer Transformation errors
						</h3>
					</div>
					
					<div class="widget-body">
						<div class="tab-content">
							<div id="tabAll" class="tab-pane active">
								<c:forEach items="${atlTransformation.atlError}" var="error"
									varStatus="status">
									<div class="accordion accordion-2" id="accordion">
										<div class="accordion-group">
											<div class="accordion-heading">
												<a class="accordion-toggle glyphicons font collapsed"
													data-toggle="collapse" data-parent="#accordion"
													href="#collapse-${status.index + 1 }"> <i></i>Error
													${status.index + 1 }: ${error.description }
												</a>
											</div>
											<div id="collapse-${status.index + 1 }"
												class="accordion-body collapse" style="height: 0px;">
												<div class="accordion-inner">
													<b>Local problem: </b>${error.localProblem } <br /> <b>Element:
													</b>${error.element }<br /> <b>File location: </b>${error.fileLocation }<br />
													<b>Location: </b>${error.location }<br /> <b>Status: </b>${error.status }<br />
													<b>ProblemId: </b>${error.problemId }<br /> <b>Description:
													</b>${error.description }<br /> <b>Severity: </b>${error.severity }<br />
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${atlTransformation.atlTestError.size() != 0}">

				<div class="widget widget-heading-simple widget-body-white">
					<div class="widget-head">
						<h3 class="heading glyphicons show_thumbnails">
							<i></i>Test service report
						</h3>
					</div>
					<div class="widget-body">
						<c:forEach items="${atlTransformation.atlTestError}" var="error"
							varStatus="status">

							<div class="accordion accordion-2" id="accordion">
								<div class="accordion-group">
									<div class="accordion-heading">
										<a class="accordion-toggle glyphicons font collapsed"
											data-toggle="collapse" data-parent="#accordion"
											href="#collapse-${status.index + 2 }"> <i></i>Test
											${status.index + 1 }: ${error.errorMessage }
										</a>
									</div>
									<div id="collapse-${status.index + 2 }"
										class="accordion-body collapse" style="height: 0px;">
										<div class="accordion-inner">
											executionRaisesException: ${error.executionRaisesException }<br/>
											executionYieldsIllTarget: ${error.executionYieldsIllTarget }<br/>
<%-- 											anatlyserNotifiesError: ${error.anatlyserNotifiesError }<br/> --%>
<%-- 											anatlyserDoesNotFinish: ${error.anatlyserDoesNotFinish }<br/> --%>
											errorKind: ${error.errorKind }<br/> 
											errorMessage: ${error.errorMessage }<br/> 
											model: <a href="${pageContext.request.contextPath}/private/Model/model_details?model_id=${error.model.id }">
												${error.model.name }</a>
										</div>
									</div>
								</div>
							</div>



						</c:forEach>
					</div>
				</div>
			</c:if>
			
			
			<div class="widget widget-heading-simple widget-body-white">
				<!-- Widget Heading -->
				<div class="widget-head">
					<h3 class="heading glyphicons show_thumbnails">
						<i></i>Execute the Transformation
					</h3>
				</div>
				<!-- // Widget Heading END -->

				<div class="widget-body">
					<div class="row-fluid">
						<div class="span4">
							<table class="table table-bordered table-striped table-white">
								<thead>
									<tr>
										<th class="center">Input Metamodels</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${atlTransformation.relations}"
										var="relation">
										<!-- Table row -->
										<tr>
											<c:choose>
												<c:when
													test="${relation.getClass().name == 'org.mdeforge.business.model.DomainConformToRelation'}">
													<td class="center"><c:choose>
															<c:when test="${relation.getToArtifact().getId()}">${relation.getToArtifact().open}">
																<a
																	href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
															</c:when>
															<c:otherwise>
																<a
																	href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
															</c:otherwise>
														</c:choose></td>
												</c:when>
											</c:choose>
										</tr>
										<!-- // Table row END -->
									</c:forEach>
							</table>
						</div>
						<div class="span4">
							<table class="table table-bordered table-striped table-white">
								<tbody>
									<tr>
										<td class="center">${atlTransformation.getName()}</td>
									</tr>
							</table>
							<a
								href="${pageContext.request.contextPath}/private/ATLTransformation/execute_transformation?transformation_id=${atlTransformation.getId()}"
								class="btn btn-success btn-small btn-block"><i
								class="icon-play icon-fixed-width"></i> Execute Transformation</a>
						</div>
						<div class="span4">

							<table class="table table-bordered table-striped table-white">
								<thead>
									<tr>
										<th class="center">Output Metamodels</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${atlTransformation.relations}"
										var="relation">
										<!-- Table row -->
										<tr>
											<c:choose>
												<c:when
													test="${relation.getClass().name == 'org.mdeforge.business.model.CoDomainConformToRelation'}">
													<td class="center"><c:choose>
															<c:when test="${relation.getToArtifact().getId()}">${relation.getToArtifact().open}">
															<a
																	href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
															</c:when>
															<c:otherwise>
																<a
																	href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
															</c:otherwise>
														</c:choose></td>
												</c:when>
											</c:choose>
										</tr>
										<!-- // Table row END -->
									</c:forEach>
							</table>

						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="">
				<div class="">
					<h4>Metrics</h4>
					<table class="table table-bordered table-striped table-white">
						<thead>
							<tr>
								<th rowspan="2">Name</th>
								<th rowspan="2">Description</th>
								<th class="center" colspan="5">Value</th>
							</tr>
							<tr>
								<th>Max</th>
								<th>Min</th>
								<th>Avg</th>
								<th>Median</th>
								<th>Standard Deviation</th>
							</tr>
						</thead>
						<!-- // Table heading END -->
						<tbody>
							<c:forEach items="${atlTransformation.getMetrics()}" var="metric">
								<!-- Table row -->
								<tr>

									<td class="left">${metric.getName()}</td>
									<td>${metric.getDescription()}</td>

									<c:choose>
										<c:when
											test="${metric.getClass().name == 'org.mdeforge.business.model.SimpleMetric'}">
											<td colspan="5" class="center">${metric.getValue()}</td>
										</c:when>
										<c:when
											test="${metric.getClass().name == 'org.mdeforge.business.modelAggregatedRealMatric'}">
											<td>${metric.getMaximum()}</td>
											<td>${metric.getMinimum()}</td>
											<td>${metric.getAverage()}</td>
											<td>${metric.getMedian()}</td>
											<td>${metric.getStandardDeviation()}</td>
										</c:when>
										<c:otherwise>
											<td>${metric.getMaximum()}</td>
											<td>${metric.getMinimum()}</td>
											<td>${metric.getAverage()}</td>
											<td>${metric.getMedian()}</td>
											<td>${metric.getStandardDeviation()}</td>
										</c:otherwise>
									</c:choose>

								</tr>
								<!-- // Table row END -->
							</c:forEach>
						</tbody>
						<!-- End body -->
					</table>
				</div>
			</div>
		</div>
		<div class="span3 tablet-column-reset">

			<!-- Widget -->
			<div class="widget widget-heading-simple widget-body-white">

				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons notes">
						<i></i>Properties
					</h4>
				</div>
				<!-- // Widget Heading END -->

				<div class="widget-body list">
					<table class="table">

						<!-- Table body -->
						<tbody>

							<c:forEach items="${atlTransformation.properties}" var="property">
								<tr>
									<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
									<td class=""><c:choose>
											<c:when test="${fn:length(property.getValue()) < 40}">
												<span data-toggle="tooltip"
													data-original-title="${property.getValue()}"
													data-placement="left">${property.getValue()}</span>
											</c:when>
											<c:otherwise>

												<span data-toggle="tooltip"
													data-original-title="${property.getValue()}"
													data-placement="left" style="font-size: 80%;">${fn:replace(property.getValue(), '/', '/ ')}</span>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
						<!-- // Table body END -->

					</table>
				</div>
			</div>

		</div>
	</div>
</div>

<c:import var="fileToVisualize"
	url="file:///${atlTransformationFile.getAbsolutePath()}" />


<!-- Modal -->
<div class="modal hide fade" id="modal-simple"
	style="width: 800px; left: 42%">

	<pre class="prettyprint">
${fn:escapeXml(fileToVisualize)}
</pre>

	<!-- Modal footer -->
	<div class="modal-footer">
		<a href="#" class="btn btn-primary" data-dismiss="modal">Close</a>
	</div>
	<!-- // Modal footer END -->

</div>
<!-- // Modal END -->
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/shareArtifact.js"></script>

