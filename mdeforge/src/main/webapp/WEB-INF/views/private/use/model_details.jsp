<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>

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
	<li><spring:message
			code="mdeforge.public.back.browse.model_details.detail" /></li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="heading-buttons">
	<h3 id="artifactName" data-id="${model.getId()}">${model.getName()}
		<span> <c:choose>
				<c:when test="${model.getOpen()}">		
							Public Model										  												    
				</c:when>
				<c:otherwise>
							Private Model										  
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
												Used in ${model.getProjects().size()} projects <a
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
													${model.getAuthor().getUsername()}</li>
												<li><i class="icon-info icon-li icon-fixed-width"></i>
													${model.getAuthor().getFirstname()}
													${model.getAuthor().getLastname()}</li>
												<li><i class="icon-envelope icon-li icon-fixed-width"></i>
													${model.getAuthor().getEmail()}</li>
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
																	value="${model.getCreated()}" /></td>
														</tr>
														<!-- // Table row END -->

														<!-- Table row -->
														<tr>
															<td class="left">Last Modified</td>
															<td class="right"><fmt:formatDate type="both"
																	dateStyle="short" timeStyle="short"
																	value="${model.getModified()}" /></td>
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
												<c:forEach items="${model.properties}"
													var="property">
													<c:if test="${property.getName() == 'Description '}">
															${property.getValue()}
														</c:if>
												</c:forEach>
											</p>
											<div class="row-fluid">
												<div class="span4">
													<h5 class="strong">Model File</h5>
													<a href="#modal-simple"
														class="btn btn-primary btn-small btn-block"
														data-toggle="modal"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize
														Model</a> <a href="#"
														class="btn btn-default btn-small btn-block"
														onclick="return false;"><i
														class="icon-eye-open icon-fixed-width"></i> Visualize Tree
														View</a> <a
														href="${pageContext.request.contextPath}/public/browse/model_download?model_id=${model.getId()}"
														class="btn btn-success btn-small btn-block"><i
														class="icon-download-alt icon-fixed-width"></i> Download
														Model</a>

													
												</div>
												<div class="span1"></div>
												<div class="span6">
													<div class="row-fluid">
													<div class="span12">
													<h5 class="text-uppercase strong text-primary">
														<i class="icon-group text-regular icon-fixed-width"></i>
														Conform to: <span
															class="text-lowercase padding-none">
																<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${model.metamodel.getToArtifact().getId()}">
																	${model.metamodel.getToArtifact().getName() }
																</a>
															</span></h5>
													</div>
													<div class="span12">
													<h5 class="text-uppercase strong text-primary">
														<i class="icon-group text-regular icon-fixed-width"></i>
														Shared Users <span
															class="text-lowercase strong padding-none">Team</span> <span
															class="text-lowercase padding-none">(${model.getShared().size()}
															people)</span>
															<i class="icon-expand-alt" id="showUserList"></i>
													</h5>
													<div id="userList" class="row-fluid" style="display: none">
														<select id="userSelect">
														</select>
														<div>
															<span class="btn btn-block btn-primary span4" id="addUserArtifact">Add</span>
														</div>
													</div>
													
													<ul id="users" class="team">
														<c:forEach items="${model.getShared()}"
															var="user" varStatus="count">
															<li class="userLi" data-id="${user.getId()}"><span class="crt">${count.count}</span><span
																class="strong">${user.getUsername()}</span><span
																class="muted">${user.getFirstname()}
																	${user.getLastname()}</span>
																<span class="muted"><a href="mailto:${user.getEmail() }">${user.getEmail() } <i class="icon-envelope"></i></a></span>
																<span class="pull-right glyphicons icon-remove removeArtifactSharedUser" data-id="${user.getId()}" ></span>
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

				</div>
			</div>
			<hr>
			

		</div>
		<div class="span3 tablet-column-reset">
			<!-- Latest Orders/List Widget -->
			<div class="widget widget-heading-simple widget-body-gray"
				data-toggle="collapse-widget">
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

				<div class="widget-body list">
					<table class="table">

						<!-- Table body -->
						<tbody>

							<c:forEach items="${model.properties}" var="property">
							
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
										value="${fn:trim(model.getExtractedContents())}" />
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
	url="file:///${modelFile.getAbsolutePath()}" />
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
	var res = '${model.getExtractedContents()}'.trim();
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
