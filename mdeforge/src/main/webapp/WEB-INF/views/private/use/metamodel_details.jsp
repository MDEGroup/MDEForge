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
	<h3 id="artifactName" data-id="${ecoreMetamodel.getId()}">${ecoreMetamodel.getName()}
		<span> <c:choose>
				<c:when test="${ecoreMetamodel.getOpen()}">		
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
												Used in ${ecoreMetamodel.getProjects().size()} projects <a
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
													${ecoreMetamodel.getAuthor().getUsername()}</li>
												<li><i class="icon-info icon-li icon-fixed-width"></i>
													${ecoreMetamodel.getAuthor().getFirstname()}
													${ecoreMetamodel.getAuthor().getLastname()}</li>
												<li><i class="icon-envelope icon-li icon-fixed-width"></i>
													${ecoreMetamodel.getAuthor().getEmail()}</li>
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
																	value="${ecoreMetamodel.getCreated()}" /></td>
														</tr>
														<!-- // Table row END -->

														<!-- Table row -->
														<tr>
															<td class="left">Last Modified</td>
															<td class="right"><fmt:formatDate type="both"
																	dateStyle="short" timeStyle="short"
																	value="${ecoreMetamodel.getModified()}" /></td>
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
												<c:forEach items="${ecoreMetamodel.properties}"
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
														href="${pageContext.request.contextPath}/public/EcoreMetamodel/download?artifact_id=${ecoreMetamodel.getId()}"
														class="btn btn-success btn-small btn-block"><i
														class="icon-download-alt icon-fixed-width"></i> Download
														Metamodel</a>
														<c:if test="${userId == ecoreMetamodel.getAuthor().getId()}">
															<a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${ecoreMetamodel.getId()}"
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
															class="text-lowercase padding-none">(${ecoreMetamodel.getShared().size()}
															people)</span>
															
															
 															<c:if test="${userId == ecoreMetamodel.getAuthor().getId()}">
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
														<c:forEach items="${ecoreMetamodel.getShared()}"
															var="user" varStatus="count">
															<li class="userLi" data-id="${user.getId()}"><span class="crt">${count.count}</span><span
																class="strong">${user.getUsername()}</span><span
																class="muted">${user.getFirstname()}
																	${user.getLastname()}</span>
																<span class="muted"><a href="mailto:${user.getEmail() }">${user.getEmail() } <i class="icon-envelope"></i></a></span>
																<c:if test="${userId == ecoreMetamodel.getAuthor().getId()}">
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
			<div class="row-fluid">			
				<div class="span12">
					<h4>Relation</h4>
					<div class="relativeWrap">
						<div class="widget widget-tabs">

							<!-- Tabs Heading -->
							<div class="widget-head">
								<ul>
									<li class="active"><a href="#mio_tab_1" data-toggle="tab"><i></i>Similarity</a></li>
									<li><a href="#mio_tab_2" data-toggle="tab"><i></i>Containment</a></li>
									<li><a href="#mio_tab_3" data-toggle="tab"><i></i>Cosine</a></li>
									<li><a href="#mio_tab_4" data-toggle="tab"><i></i>Dice</a></li>
									<li><a href="#mio_tab_5" data-toggle="tab"><i></i>Transformation From</a></li>
									<li><a href="#mio_tab_6" data-toggle="tab"><i></i>Transformation To</a></li>
									<li><a href="#mio_tab_7" data-toggle="tab"><i></i>Models Conform</a></li>
								</ul>
							</div>
							<!-- // Tabs Heading END -->
							<div class="widget-body">
								<div class="tab-content">
									<!-- Tab content -->
									<div class="tab-pane active" id="mio_tab_1">
										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th>Artifact</th>
													<th class="center">Similarity Value</th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}" var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.SimilarityRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">

																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>

																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>


																<td class="center"><span
																	class="badge badge-success"><fmt:formatNumber
																			value="${relation.getValue()}" maxFractionDigits="3" /></span></td>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>


									</div>
									<!-- // Tab content END -->
									<!-- Tab content -->
									<div class="tab-pane" id="mio_tab_2">

										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th>Artifact</th>
													<th class="center">Containment Value</th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.ContainmentRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>


																<td class="center"><span
																	class="badge badge-success"><fmt:formatNumber
																			value="${relation.getValue()}" maxFractionDigits="3" /></span></td>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>

									</div>
									<!-- // Tab content END -->
									<div class="tab-pane" id="mio_tab_3">

										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th>Artifact</th>
													<th class="center">Containment Value</th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.CosineSimilarityRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>


																<td class="center"><span
																	class="badge badge-success"><fmt:formatNumber
																			value="${relation.getValue()}" maxFractionDigits="3" /></span></td>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>

									</div>
									<!-- // Tab content END -->
									<div class="tab-pane" id="mio_tab_4">

										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th>Artifact</th>
													<th class="center">Containment Value</th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.DiceSimilarityRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>


																<td class="center"><span
																	class="badge badge-success"><fmt:formatNumber
																			value="${relation.getValue()}" maxFractionDigits="3" /></span></td>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>

									</div>
									<!-- // Tab content END -->
									<!-- Tab content -->
									<div class="tab-pane" id="mio_tab_5">

										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th class="center"><spring:message	code="mdeforge.relation.domainconformto" /></th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.DomainConformToRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">
																		<td><a
																			href="${pageContext.request.contextPath}/public/ATLTransformation/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/ATLTransformation/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>

									</div>
									<!-- // Tab content END -->
									<!-- Tab content -->
									<div class="tab-pane" id="mio_tab_6">

										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th class="center"><spring:message	code="mdeforge.relation.codomainconformto"></spring:message></th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.CoDomainConformToRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">
																		<td>
																		<c:choose>
																			<c:when test="${relation.getToArtifact().getOpen()}">
																			</c:when>
																		</c:choose>
																		
																		<a
																			href="${pageContext.request.contextPath}/public/ATLTransformation/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/ATLTransformation/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>

									</div>
									<!-- // Tab content END -->
									<div class="tab-pane" id="mio_tab_7">

										<table class="table table-bordered table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th class="center"><spring:message	code="mdeforge.relation.codomainconformto"></spring:message></th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${ecoreMetamodel.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.ConformToRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == ecoreMetamodel.getId()}">
																		<td>
																		<c:choose>
																			<c:when test="${relation.getToArtifact().getOpen()}">
																			</c:when>
																		</c:choose>
																		
																		<a
																			href="${pageContext.request.contextPath}/private/Model/model_details?model_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/private/Model/model_details?model_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>
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
					</div>
				</div>
			</div>
			<div class="row-flid">
				<div class="span12">
					<h4>Metrics</h4>

					<%-- <table class="table table-bordered table-striped table-white">
	
					<!-- Table heading -->
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
	
					<!-- Table body -->
					<tbody>
						<c:forEach items="${ecoreMetamodel.getMetrics()}" var="metric">
							<!-- Table row -->
							<tr>
								
								<td class="left">${metric.getName()}</td>
								<td>${metric.getDescription()}</td>
								
								<c:choose>
								  <c:when test="${metric.getClass().name == 'org.mdeforge.business.model.SimpleMetric'}">
								    <td colspan="5" class="center">${metric.getValue()}</td>
								  </c:when>
								  <c:when test="${metric.getClass().name == 'org.mdeforge.business.modelAggregatedRealMatric'}">
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
				</table> --%>
					<table class="table table-bordered table-striped table-white">

						<!-- Table heading -->
						<thead>
							<tr>
								<th>Name</th>
								<th class="center">Value</th>
							</tr>

						</thead>
						<!-- // Table heading END -->

						<!-- Table body -->
						<tbody>
							<c:forEach items="${ecoreMetamodel.getMetrics()}" var="metric">
								<!-- Table row -->
								<tr>
									<td class="left">${metric.getName()}</td>
									<td class="center"><span class="badge badge-success"><fmt:formatNumber value="${metric.getValue()}" maxFractionDigits="3" /></span></td>
								</tr>
								<!-- // Table row END -->
							</c:forEach>
					</table>

				</div>
			</div>

		</div>
		<div class="span3 tablet-column-reset">
			<!-- Latest Orders/List Widget -->
			<div class="widget widget-heading-simple widget-body-gray"
				data-toggle="collapse-widget">

				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons link">
						<i></i>URI
					</h4>
				</div>
				<!-- // Widget Heading -->

				<div class="widget-body list">
					<table class="table table-condensed">

						<!-- Table body -->
						<tbody>
							<c:choose>
								<c:when test="${ecoreMetamodel.getUri().size() > 0}">
									<c:forEach items="${ecoreMetamodel.getUri()}" var="uri">
										<tr>
											<td class="center">${uri}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td class="center">It has not been assigned any URI</td>
									</tr>
								</c:otherwise>
							</c:choose>

						</tbody>
						<!-- // Table body END -->

					</table>
				</div>
			</div>
			<!-- // Latest Orders/List Widget END -->




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

							<c:forEach items="${ecoreMetamodel.properties}" var="property">
							
							<%-- 	<c:set var="arrayString" value="${fn:split(property.getValue(), ' ')}" />
								<c:set var="maxLengthString" value=" " />
									
								<c:forEach items="${arrayString}" var="arrayToCheck">
									<c:if test="${fn:length(arrayToCheck) > fn:length(maxLengthString)}">
										<c:set var="maxLengthString" value="${arrayToCheck}" />
									</c:if>
								</c:forEach> --%>
							
								<tr>
									<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
									<td class="">										
										 <c:choose>
										  <c:when test="${fn:length(property.getValue()) < 40}">
										    	<span data-toggle="tooltip" data-original-title="${property.getValue()}" data-placement="left" >${property.getValue()}</span>
										  </c:when>										  
										  <c:otherwise>
										  
											<span data-toggle="tooltip" data-original-title="${property.getValue()}" data-placement="left" style="font-size:80%;">${fn:replace(property.getValue(), '/', '/ ')}</span>										
										  </c:otherwise>
										</c:choose> 
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<!-- // Table body END -->

					</table>
				</div>
			</div>
			<!-- // Widget END -->
			<!-- Widget -->
			<!-- 			<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
					
				Widget Heading
				<div class="widget-head">
					<h4 class="heading glyphicons tags"><i></i>TAGS</h4>
				</div>
				// Widget Heading END
				
				<div class="widget-body list">
				
					List
					<ul>
						<li>
							<a href="">Tag 1</a>
							
						</li>
						<li>
							<a href="">Tag 2</a>
							
						</li>						
					</ul>
					// List END
					
				</div>
			</div> -->
			<!-- // Widget END -->

			<!-- Widget -->
			<div class="widget widget-heading-simple widget-body-white">

				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons notes">
						<i></i>Extracted Word Context
					</h4>
				</div>
				<!-- // Widget Heading END -->




				<div class="relativeWrap">
					<div class="widget widget-tabs">

						<!-- Tabs Heading -->
						<div class="widget-head">
							<ul>
								<li class="active"><a class="glyphicons cloud"
									href="#cloud" data-toggle="tab"><i></i>Word Cloud</a></li>
								<li><a class="glyphicons font" href="#standard"
									data-toggle="tab"><i></i>Standard</a></li>
							</ul>
						</div>
						<!-- // Tabs Heading END -->

						<div class="widget-body">
							<div class="tab-content">

								<!-- Tab content -->
								<div class="tab-pane active" id="cloud">

									<canvas id="my_canvas"></canvas>

								</div>
								<!-- // Tab content END -->

								<!-- Tab content -->
								<div class="tab-pane" id="standard">

									<c:set var="serializedContext_trim"
										value="${fn:trim(ecoreMetamodel.getExtractedContents())}" />
									<c:set var="serializedContext_splitted"
										value="${fn:replace(serializedContext_trim, ' ', ' - ')}" />
									${serializedContext_splitted}

								</div>
								<!-- // Tab content END -->

							</div>
						</div>
					</div>
				</div>


			</div>
			<!-- // Widget END -->




		</div>

	</div>
</div>
<c:import var="fileToVisualize"
	url="file:///${ecoreMetamodelFile.getAbsolutePath()}" />
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

<script>
	var res = '${ecoreMetamodel.getExtractedContents()}'.trim();
	res = res.split(" ");

	var wordlist = [];

	for (var i = 0; i < res.length; ++i) {
		var numOccurrences = 1;
		for (var j = 0; j < res.length; ++j) {
			if (res[j].toUpperCase() === res[i].toUpperCase()) {
				numOccurrences++;
				/*Elimino l'elemento ripetuto dall'array*/
				res.splice(j, 1);
			}
		}
		wordlist.push([ res[i], numOccurrences ]);
	}

	var options = {
		list : wordlist,
		gridSize : Math
				.round(1 * document.getElementById('my_canvas').offsetWidth / 1024),
		weightFactor : function(size) {
			return Math.pow(size, 4.9)
					* document.getElementById('my_canvas').offsetWidth / 1024;
		},
		fontFamily : 'Open Sans, sans-serif',
		rotateRatio : 0.5

	}

	WordCloud(document.getElementById('my_canvas'), options);
</script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/shareArtifact.js"></script>
