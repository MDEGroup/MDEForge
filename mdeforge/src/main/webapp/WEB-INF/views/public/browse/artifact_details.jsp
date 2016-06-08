<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>
<script	type="text/javascript">
function shareArtifact(){
	
	console.log("${artifact.id}");
	$.ajax({
		url : ctx + "/public/${artifact.getClass().getSimpleName() }/share/?metamodel_id=" + "${artifact.id}",
		success : function(data) {
			console.log("UEEEE")
		},
		error : function error(data) {
			console.log('error');
			
		}
	});
}


</script>

<style type="text/css">
#my_canvas {
	width: 100%;
	height: 200px;
}
</style>

<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<li>${artifact.getClass().getSimpleName() } details</li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="heading-buttons">
	<h3>${artifact.getName()}
		<span> <c:choose>
				<c:when test="${artifact.getOpen()}">		
							Public									  												    
				</c:when>
				<c:otherwise>
							Private										  
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
												<security:authorize access="isAuthenticated()">
																<a id="publicShareButton" onclick="shareArtifact()" data-id="${artifact.getId()}"> Share</a>
												</security:authorize>
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
													<h5 class="strong">${artifact.getClass().getSimpleName() } File</h5>
													<a href="#modal-simple"
														class="btn btn-primary btn-small btn-block"
														data-toggle="modal"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize
														${artifact.getClass().getSimpleName() }</a> <a href="#"
														class="btn btn-default btn-small btn-block"
														onclick="return false;"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize Tree
														View</a> <a
														href="${pageContext.request.contextPath}/public/${artifact.getClass().getSimpleName() }/download?artifact_id=${artifact.getId()}"
														class="btn btn-success btn-small btn-block"><i
														class="icon-download-alt icon-fixed-width"></i> Download
														${artifact.getClass().getSimpleName() }</a>
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
															
													</h5>
													<ul class="team">
														<c:forEach items="${artifact.getShared()}"
															var="user" varStatus="count">
															<li><span class="crt">${count.count}</span><span
																class="strong">${user.getUsername()}</span><span
																class="muted">${user.getFirstname()}
																	${user.getLastname()}</span></li>
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
			<c:if test="${artifact.getMetrics().size()!=0}">
			
			<div class="row-fluid">
				<div class="span12">
					<h4>Metrics</h4>
					<table class="table table-bordered table-striped table-white">
						<!-- Table heading -->
						<thead>
							<tr>
								<th rowspan="2">Name</th>
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
							<c:forEach items="${artifact.getMetrics()}" var="metric">
													<!-- Table row -->
								<tr>
									<td class="left">${metric.getName()}</td>
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
					</table>

				</div>
			</div>
			</c:if>
			<security:authorize access="isAuthenticated()">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget widget-heading-simple widget-body-white">
						<div><h4>Comments</h4></div>
						<div>
							<c:forEach items="${artifact.comments }" var="comment">
								<div>
									${comment.comment }
									${comment.star }
									${comment.user.username }
									
								</div>
							</c:forEach>
						</div>
						<div>
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/comment" method="post">
							 	<input type="hidden" value="${artifact.id}" name="idArtifact"/>
							 	Comment
							 	<input type="text" value="" name="comment"/>
							 	Star
							 	<select name="star">
							 		<option value="1">1</option>
							 		<option value="2">2</option>
							 		<option value="3">3</option>
							 		<option value="4">4</option>
							 		<option value="5">5</option>
							 	</select>
							 	<input type="submit"/>
							</form>
						</div>
					</div>
				</div>
			</div>
			</security:authorize>
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

<script>
	var res = '${artifact.getDefaultWeightedContents()}'.trim();
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
