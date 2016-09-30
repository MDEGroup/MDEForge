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
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<!-- <li><spring:message code="mdeforge.public.back.browse.metamodel_details.detail" /></li>-->
	<li>${artifact.getClass().getSimpleName()} Details</li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="innerLR">
<div class="row-fluid">
<div class="span9">
<div class="box-generic">
	<h3 class="header-h main-title" id="artifactName" data-id="${artifact.getId()}">${artifact.getName()}</h3>
	<!-- <h5 class="muted"><spring:message code="mdeforge.public.back.browse.metamodel_details.detail" /></h5>-->
	<h5 class="muted">${artifact.getClass().getSimpleName()} Details</h5>
	<hr>
	<h5 class="input-name">Used in <span class="text-primary">${artifact.getProjects().size()}</span> projects</h5>
	<div class="separator bottom"></div>
		<span class="text-primary" style="font-size: 16px">Creation Date</span>
		<h5><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getCreated()}" /></h5>
		<span class="text-primary" style="font-size: 16px">Last Modified</span>
		<h5><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getModified()}" /></h5>
	<div class="separator bottom"></div>
	<c:if test="${artifact.getClass().getSimpleName()} == 'EcoreMetamodel'">
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
	</c:if>
	<h5 class="input-name">Properties</h5>
	<ul>
	<c:forEach items="${artifact.properties}" var="property">
	<li>
		<p class="property-name-details text-primary">${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</p>
			<h5 class="property-value-details">${property.getValue()}</h5>
	</li>
	</c:forEach>
	</ul>
	<h5 class="input-name">Description</h5>
	<p>${artifact.description}</p>
	
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
			<div class="box-generic">
			<div class="span2">
				<a href="#modal-simple" class="widget-stats widget-stats-2" data-toggle="modal">
						<span class="count  icon-desktop text-info"><i></i></span>
						<span class="txt">Visualize ${artifact.getClass().getSimpleName()}</span>
					</a>
			</div>
			<div class="span2">
					<a href="#modal-simple" class="disabled-button widget-stats widget-stats-2" data-toggle="modal">
						<!-- <span class="count icon-code-fork"><i></i></span> -->
						<span class="count  icon-sitemap text-warning"><i></i></span>
						<span class="txt">Visualize Tree View</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/download?artifact_id=${artifact.getId()}" class="widget-stats widget-stats-2">
						<span class="count icon-download-alt text-success"><i></i></span>
						<span class="txt">Download ${artifact.getClass().getSimpleName()}</span>
					</a>
			</div>
			<c:if test="${userId == artifact.getAuthor().getId()}">
			<div class="span2">
				<a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${artifact.getId()}" class="widget-stats widget-stats-2">
						<span class="count icon-remove text-error"><i></i></span>
						<span class="txt">Delete ${artifact.getClass().getSimpleName()}</span>
					</a>
			</div>
			</c:if>
				<div class="separator bottom"></div>
			</div>
	</div>
		<hr>
	<tiles:insertAttribute name="central" ignore="true"/>

	<div class="row-fluid">
	<c:if test="${artifact.getMetrics().size()!=0}">
				<div class="span8">
				<c:if test="${artifact.getMetrics().size()!=0}">
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
				
				<!-- word context 
						<div class="widget widget-heading-simple widget-body-white">
							
							<h5 class="input-name">Extracted Word Context</h5>
							<div class="separator bottom"></div>
					
									<div class="tab-pane" id="standard">
					
												<c:set var="serializedContext_trim"
													value="${fn:trim(artifact.getDefaultWeightedContents())}" />
												<c:set var="serializedContext_splitted"
													value="${fn:replace(serializedContext_trim, ' ', ' - ')}" />
												${serializedContext_splitted}
					
											</div>
					
										</div>
						<!-- word context END -->
				</div>
				</c:if>
				</div>
				<!-- span4 shared users -->
			</c:if>
				<tiles:insertAttribute name="right" ignore="true"/>
			</div>
		</div>


<c:import var="fileToVisualize"
	url="file:///${artifactFile.getAbsolutePath()}" />
<!-- Modal -->
<div class="modal modal-artifact hide fade" id="modal-simple">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3>${artifact.getName()}</h3>
	  </div>
	 	<pre class="prettyprint" style="margin: 0">
	 		<code class="xml" style="font-size: 16px;line-height: 22px;font-weight: 400;">
			${fn:escapeXml(fileToVisualize)}
			</code>
		</pre>
	  <div class="modal-footer center">
	    <a href="#" class="btn btn-large" data-dismiss="modal">Close</a>
	  </div>
	</div>
<!-- // Modal END -->


<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/shareArtifact.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/highlight/highlight.pack.js"></script>
<script>
	hljs.initHighlightingOnLoad();
	/*var res = '${artifact.getDefaultWeightedContents()}'.trim();
	res = res.split(" ");

	 var wordlist = [];

	for (var i = 0; i < res.length; ++i) {
		var numOccurrences = 1;
		for (var j = 0; j < res.length; ++j) {
			if (res[j].toUpperCase() === res[i].toUpperCase()) {
				numOccurrences++;
				//Elimino l'elemento ripetuto dall'array
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

	} */
	

	//WordCloud(document.getElementById('my_canvas'), options);
</script>