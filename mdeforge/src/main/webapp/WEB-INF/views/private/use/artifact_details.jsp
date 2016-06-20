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
	<li><spring:message code="mdeforge.public.back.browse.metamodel_details.detail" /></li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="innerLR">
<div class="row-fluid">
<div class="span9">
<div class="box-generic">
	<h3 class="header-h main-title" id="artifactName" data-id="${artifact.getId()}">${artifact.getName()}</h3>
	<h5 class="muted"><spring:message code="mdeforge.public.back.browse.metamodel_details.detail" /></h5>
	<hr>
	<h5 class="input-name">Used in ${artifact.getProjects().size()} projects</h5>
	<div class="separator bottom"></div>
		<span class="text-primary" style="font-size: 16px">Creation Date</span>
		<h5><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getCreated()}" /></h5>
		<span class="text-primary" style="font-size: 16px">Last Modified</span>
		<h5><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getModified()}" /></h5>
	<div class="separator bottom"></div>
	<c:choose>
		<c:when test="${artifact.getUri().size() > 0}">
			<c:forEach items="${artifact.getUri()}" var="uri">
					<p><span class="text-primary">URI</span>: ${uri}</p>
			</c:forEach>
		</c:when>
		<c:otherwise>
				<p class="text-error">It has not been assigned any URI</p>
		</c:otherwise>
	</c:choose>
	<h5 class="input-name">Properties</h5>
	<c:forEach items="${artifact.properties}" var="property">
		<h5>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</h5>
			<p>${property.getValue()}</p>
	</c:forEach>
	
	<h5 class="input-name">Description</h5>
	<p>	
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim.									
		<c:forEach items="${artifact.properties}"
			var="property">
			<c:if test="${property.getName() == 'Description '}">
					${property.getValue()}
				</c:if>
		</c:forEach>
	</p>
	
</div>
</div>
<div class="span3 text-right">
<div class="box-generic">
<h5 class="input-name">Visibility</h5>
	<c:choose>
				<c:when test="${artifact.getOpen()}">	
				<span class="btn btn-success">	
							<span class="icon-cloud"><i></i></span> Public</span>						  												    
				</c:when>
				<c:otherwise>
				<span class="btn btn-danger">
						<span class="icon-lock"><i></i></span> Private</span>							  
				</c:otherwise>
			</c:choose>
	<div class="separator bottom"></div>
	<h5 class="input-name">Importer</h5>
	<!-- // Profile Photo END -->
	<ul class="icons-ul">
		<li>${artifact.getAuthor().getUsername()} <span class="icon-user text-primary"><i></i></span></li>
		<li class="text-black" style="font-size: 14px">${artifact.getAuthor().getFirstname()} ${artifact.getAuthor().getLastname()}</li>
		<li><a href="#">${artifact.getAuthor().getEmail()}</a> <span class="icon-envelope text-primary"><i></i></span></li>
	</ul>
</div>
</div>
</div>
</div>
<div class="innerLR">
	<div class="row-fluid">
		<div class="span12 tablet-column-reset">
			<div class="box-generic">
			<div class="span2">
				<a href="#modal-simple" class="widget-stats widget-stats-2" data-toggle="modal">
						<span class="count  icon-desktop text-info"><i></i></span>
						<span class="txt">Visualize Metamodel</span>
					</a>
			</div>
			<div class="span2">
					<a href="#modal-simple" class="widget-stats widget-stats-2" data-toggle="modal">
						<!-- <span class="count icon-code-fork"><i></i></span> -->
						<span class="count  icon-sitemap text-warning"><i></i></span>
						<span class="txt">Visualize Tree View</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/download?artifact_id=${artifact.getId()}" class="widget-stats widget-stats-2">
						<span class="count icon-download-alt text-success"><i></i></span>
						<span class="txt">Download Metamodel</span>
					</a>
			</div>
			<c:if test="${userId == artifact.getAuthor().getId()}">
			<div class="span2">
				<a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${artifact.getId()}" class="widget-stats widget-stats-2">
						<span class="count icon-remove text-error"><i></i></span>
						<span class="txt">Delete Metamodel</span>
					</a>
			</div>
			</c:if>
				<div class="separator bottom"></div>
			</div>
			<hr>
			<tiles:insertAttribute name="central" ignore="true"/>
			<div class="row-fluid">
				<div class="span8">
				<div class="box-generic">
					<h5 class="input-name">Metrics</h5>
					<div class="separator bottom"></div>

					<table class="table table-striped table-white table-metrics">
						<thead>
							<tr>
								<th>Name</th>
								<!-- <th rowspan="2">Description</th>-->
								<th class="center">Value</th>
								<th>Max</th>
								<th>Min</th>
								<th>Avg</th>
								<th>Median</th>
								<th style="font-size: 12px;">Standard Deviation</th>
							</tr>
						</thead>
						<!-- // Table heading END -->
						<tbody>
							<c:forEach items="${artifact.getMetrics()}" var="metric">
								<!-- Table row -->
								<tr>

									<td class="left">${metric.getName()}</td>
									<!-- <td>${metric.getDescription()}</td>-->

									<c:choose>
										<c:when test="${metric.getClass().name == 'org.mdeforge.business.model.SimpleMetric'}">
											<td class="number-table">${metric.getValue()}</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</c:when>
										<c:when test="${metric.getClass().name == 'org.mdeforge.business.modelAggregatedRealMatric'}">
											<td></td>
											<td class="number-table">${metric.getMaximum()}</td>
											<td class="number-table">${metric.getMinimum()}</td>
											<td class="number-table">${metric.getAverage()}</td>
											<td class="number-table">${metric.getMedian()}</td>
											<td class="number-table">${metric.getStandardDeviation()}</td>
										</c:when>
										<c:otherwise>
											<td></td>
											<td class="number-table">${metric.getMaximum()}</td>
											<td class="number-table">${metric.getMinimum()}</td>
											<td class="number-table">${metric.getAverage()}</td>
											<td class="number-table">${metric.getMedian()}</td>
											<td class="number-table">${metric.getStandardDeviation()}</td>
										</c:otherwise>
									</c:choose>

								</tr>
								<!-- // Table row END -->
							</c:forEach>
						</tbody>
						<!-- End body -->
					</table>
				<div class="separator"></div>
				<!-- Widget -->
						<div class="widget widget-heading-simple widget-body-white">
							<!-- Widget Heading -->
							<h5 class="input-name">Extracted Word Context</h5>
							<div class="separator bottom"></div>
							<!-- // Widget Heading END -->
							<div class="relativeWrap">
								<div class="widget widget-tabs">
					
									<!-- Tabs Heading -->
									<div class="widget-head">
										<ul>
											<li class="active"><a class="glyphicons cloud" href="#cloud" data-toggle="tab"><i></i>Word Cloud</a></li>
											<li><a class="glyphicons font" href="#standard" data-toggle="tab"><i></i>Standard</a></li>
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
													value="${fn:trim(artifact.getDefaultWeightedContents())}" />
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
				<!-- span4 shared users -->
				<tiles:insertAttribute name="right" ignore="true"/>
			</div>

		</div>
		
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