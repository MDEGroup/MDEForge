<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
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
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<li><spring:message
			code="mdeforge.public.back.browse.metamodel_details.detail" /></li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="heading-buttons">
	<h3 id="artifactName" data-id="${artifact.getId()}">${artifact.getName()}
		<span> <c:choose>
				<c:when test="${artifact.getOpen()}">		
							Public Metamodel										  												    
				</c:when>
				<c:otherwise>
							Private Metamodel										  
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
												Used in ${artifact.getProjects().size()} projects <a
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
													${artifact.getAuthor().getUsername()}</li>
												<li><i class="icon-info icon-li icon-fixed-width"></i>
													${artifact.getAuthor().getFirstname()}
													${artifact.getAuthor().getLastname()}</li>
												<li><i class="icon-envelope icon-li icon-fixed-width"></i>
													${artifact.getAuthor().getEmail()}</li>
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
																	value="${artifact.getCreated()}" /></td>
														</tr>
														<!-- // Table row END -->

														<!-- Table row -->
														<tr>
															<td class="left">Last Modified</td>
															<td class="right"><fmt:formatDate type="both"
																	dateStyle="short" timeStyle="short"
																	value="${artifact.getModified()}" /></td>
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
												<c:forEach items="${artifact.properties}"
													var="property">
													<c:if test="${property.getName() == 'Description '}">
															${property.getValue()}
														</c:if>
												</c:forEach>
											</p>
											<div class="row-fluid">
												<div class="span4">
													<h5 class="strong">Metamodel File</h5>
													<a href="#modal-simple"
														class="btn btn-primary btn-small btn-block"
														data-toggle="modal"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize
														Metamodel</a> <a href="#"
														class="btn btn-default btn-small btn-block"
														onclick="return false;"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize Tree
														View</a> <a
														href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/download?artifact_id=${artifact.getId()}"
														class="btn btn-success btn-small btn-block"><i
														class="icon-download-alt icon-fixed-width"></i> Download
														Metamodel</a>
														<c:if test="${userId == artifact.getAuthor().getId()}">
															<a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${artifact.getId()}"
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
															class="text-lowercase padding-none">(${artifact.getShared().size()}
															people)</span>
															
															
 															<c:if test="${userId == artifact.getAuthor().getId()}">
 																<i class="icon-expand-alt" id="showUserList"></i>
 															</c:if>
															
													</h5>
													<div id="userList" class="row-fluid" style="display: none">
														<select id="userSelect">
														</select>
														<div>
															<span class="btn btn-block btn-primary span4" id="addUserArtifact">Add</span>
														</div>
													</div>
													
													<ul id="users" class="team">
														<c:forEach items="${artifact.getShared()}"
															var="user" varStatus="count">
															<li class="userLi" data-id="${user.getId()}"><span class="crt">${count.count}</span><span
																class="strong">${user.getUsername()}</span><span
																class="muted">${user.getFirstname()}
																	${user.getLastname()}</span>
																<span class="muted"><a href="mailto:${user.getEmail() }">${user.getEmail() } <i class="icon-envelope"></i></a></span>
																<c:if test="${userId == artifact.getAuthor().getId()}">
																	<span class="pull-right glyphicons icon-remove removeArtifactSharedUser" data-id="${user.getId()}" ></span>
																</c:if>
															</li>
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
			<tiles:insertAttribute name="central" ignore="true"/>
			<div class="row-flid">
				<div class="span12">
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
							<c:forEach items="${artifact.getMetrics()}" var="metric">
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
		<tiles:insertAttribute name="right" ignore="true"/>
	</div>
</div>

<c:import var="fileToVisualize"
	url="file:///${artifactFile.getAbsolutePath()}" />
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


<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/shareArtifact.js"></script>