<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<script src="${pageContext.request.contextPath}/resources/theme/scripts/worldcloud2.js"></script>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse"/></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse.metamodel_details.detail"/></li>
</ul>
<!-- Breadcrumb END -->





<!-- Heading -->
<div class="heading-buttons">
	<h3>${ecoreMetamodel.getName()} 
		<span>
			<c:choose>
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
		
			<div class="widget widget-heading-simple widget-body-white widget-employees">
					
				
				
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
											<p class="muted">${ecoreMetamodel.getProjects().size()} projects <a href=""><i class="icon-circle-arrow-right"></i></a></p>
											<div class="margin-bottom-none progress progress-small count-outside"><div class="count">30%</div><div class="bar" style="width: 30%;"></div></div>
										</div>
									</div>
								</div>
								<hr/>
								<div class="body">
									<div class="row-fluid">
										<div class="span4 overflow-hidden">
											<h5 class="strong">Importer</h5>
											<!-- // Profile Photo END -->
											<ul class="icons-ul">
												<li><i class="icon-user icon-li icon-fixed-width"></i> ${ecoreMetamodel.getAuthor().getUsername()}</li>
												<li><i class="icon-info icon-li icon-fixed-width"></i> ${ecoreMetamodel.getAuthor().getFirstname()} ${ecoreMetamodel.getAuthor().getLastname()}</li>												
												<li><i class="icon-envelope icon-li icon-fixed-width"></i> ${ecoreMetamodel.getAuthor().getEmail()}</li>
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
															<td class="right"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ecoreMetamodel.getCreated()}" /></td>
														</tr>
														<!-- // Table row END -->
														
														<!-- Table row -->
														<tr>
															<td class="left">Last Modified</td>
															<td class="right"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ecoreMetamodel.getModified()}" /></td>
														</tr>
														<!-- // Table row END -->																										
													</tbody>
													<!-- // Table body END -->
													
												</table>
											</div>
											
											
										</div>
										<div class="span8">
											<h5 class="strong">Description</h5>
											<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
											<div class="row-fluid">
												<div class="span4">
													<h5 class="strong">Metamodel File</h5>
													<a href="#modal-simple" class="btn btn-primary btn-small btn-block" data-toggle="modal"><i class="icon-eye-open icon-fixed-width"></i> Visualize Metamodel</a>													
													<a href="${ecoreMetamodelFile.getAbsolutePath()}"  class="btn btn-success btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> Download Metamodel</a>																								
													<!-- <a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> May</a>
													<a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> April</a> -->
													<div class="separator bottom"></div>
												</div>
												<div class="span7 offset1">
													<h5 class="strong">Metrics</h5>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">100%</div><div class="bar" style="width: 100%;"></div><div class="add">HTML</div></div>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">90%</div><div class="bar" style="width: 90%;"></div><div class="add">CSS</div></div>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">93%</div><div class="bar" style="width: 93%;"></div><div class="add">jQuery</div></div>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">79%</div><div class="bar" style="width: 79%;"></div><div class="add">PHP</div></div>
													<div class="progress progress-mini count-outside add-outside"><div class="count">20%</div><div class="bar" style="width: 20%;"></div><div class="add">WP</div></div>
													<div class="separator bottom"></div>
												</div>
											</div>
											<h5 class="text-uppercase strong text-primary"><i class="icon-group text-regular icon-fixed-width"></i> Shared Users <span class="text-lowercase strong padding-none">Team</span> <span class="text-lowercase padding-none">(${ecoreMetamodel.getShared().size()} people)</span></h5>
											<ul class="team">												
												<c:forEach items="${ecoreMetamodel.getShared()}" var="user" varStatus="count">
													<li><span class="crt">${count.count}</span><span class="strong">${user.getUsername()}</span><span class="muted">${user.getFirstname()} ${user.getLastname()}</span></li>
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
			
			
			<hr>
			
			<h4>Relations</h4>
			<table class="table table-bordered table-white">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Artifact</th>
						<th class="center">Similarity Value</th>
						<th>Artifact</th>
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>
					<c:forEach items="${ecoreMetamodel.relations}" var="relation">
						<!-- Table row -->
						<tr>
							<td>${relation.getFromArtifact().getName()}</td>
							<td class="center"><span class="badge badge-success"><fmt:formatNumber value="${relation.getValue()}" maxFractionDigits="2" /></span></td>
							<td>${relation.getToArtifact().getName()}</td>
						</tr>
						<!-- // Table row END -->
					</c:forEach>
			</table>
			
			
			<hr>
			
			<h4>Metrics</h4>
			<table class="table table-bordered table-white">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Artifact</th>
						<th class="center">Name</th>
						<th>Description</th>
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>
					<c:forEach items="${metrics}" var="metric">
						<!-- Table row -->
						<tr>
							<td>${metric.getArtifact().getName()}</td>
							<td class="center"><span class="badge badge-success">${metric.getName()}</span></td>
							<td>${metric.getDescription()}</td>
						</tr>
						<!-- // Table row END -->
					</c:forEach>
			</table>
			
			
			
			
			
			
			
			
			
			
			
			
		</div>
		
		<div class="span3 tablet-column-reset">
			<!-- Latest Orders/List Widget -->
			<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
			
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons link"><i></i>URI</h4>					
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
			<div class="widget widget-heading-simple widget-body-white" data-toggle="collapse-widget">
					
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons notes"><i></i>Properties</h4>
				</div>
				<!-- // Widget Heading END -->
				
				<div class="widget-body list">
					<table class="table table-condensed">
				
						<!-- Table body -->
						<tbody>
							
							<c:forEach items="${ecoreMetamodel.properties}" var="property">
							<tr>
								<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
								<td class="right">${property.getValue()}</td>
							</tr>
							</c:forEach>								
						</tbody>
						<!-- // Table body END -->
						
					</table>									
				</div>
			</div>
			<!-- // Widget END -->
			<!-- Widget -->
			<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
					
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons tags"><i></i>TAGS</h4>
				</div>
				<!-- // Widget Heading END -->
				
				<div class="widget-body list">
				
					<!-- List -->
					<ul>
						<li>
							<a href="">Tag 1</a>
							
						</li>
						<li>
							<a href="">Tag 2</a>
							
						</li>						
					</ul>
					<!-- // List END -->
					
				</div>
			</div>
			<!-- // Widget END -->			
			
			<!-- Widget -->
			<div class="widget widget-heading-simple widget-body-white" data-toggle="collapse-widget">
					
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons notes"><i></i>Extracted Word Context</h4>
				</div>
				<!-- // Widget Heading END -->
				
				<div class="widget-body list">
					
					
													
				</div>
			</div>
			<!-- // Widget END -->
			
			
			
						
		</div>
		
		
		
	</div>
	
	
	
	

	
	
	
	
</div>	













<c:import var="fileToVisualize" url="file:///${ecoreMetamodelFile.getAbsolutePath()}" />


<!-- Modal -->
<div class="modal hide fade" id="modal-simple" style="width:800px; left:42%">

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




<script type="text/javascript">

WordCloud(document.getElementById('my_canvas'), { list: list } );
</script>
	