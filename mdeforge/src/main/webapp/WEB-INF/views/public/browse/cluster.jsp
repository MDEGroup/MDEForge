<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!-- JQRangeSlider Sliders Plugin -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/sliders/jQRangeSlider/css/iThing.css" rel="stylesheet" />





<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full" class="glyphicons dashboard"><i></i> Public area</a></li>
		<li class="divider"></li>
		<li>Browse</li>
		<li class="divider"></li>
		<li>Cluster</li>
		<li class="divider"></li>
		<li>Table View</li>
</ul>
<!-- Breadcrumb END -->










<div class="innerLR" id="dashboard">


	<div class="row-fluid">
		<div class="span6">
			<h3 class="header-h main-title cluster-title"><spring:message code="mdeforge.public.back.browse.menu.cluster_metamodel"/> <spring:message code="mdeforge.public.back.browse.table"/></h3>
		</div>
		<div class="span6">
			<h3 class="header-h main-title cluster-title text-right"><a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph?threshold=${threshold}&computation=${computation}"><i></i>Cluster Metamodel Graph View</a></h3>
		</div>
	</div>
	<div class="separator bottom"></div>
	<span> Metamodels in the repository: <strong class="text-primary">${numberOfMetamodels}</strong></span>
<!-- 	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis.</p> -->
<div class="separator"></div>
	
	<div class="separator"></div>
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-simple" id="cluster">
					
		
		
							
		<div class="widget-body">		
			<!-- Row -->
			<div class="row-fluid">
			
					<div class="span3">
						<div id="show-parameters" class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse" data-toggle="collapse" data-target="#collapse-parameters">
							<span class="txt">Edit Parameters</span>	
							<div class="clearfix"></div>					
							<span class="count text-primary glyphicons adjust_alt"><i></i></span>
						</div>
					</div>
				
					<div class="span6">
						<div class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse">
							<span class="txt">Similarity Measure</span>
							<div class="clearfix"></div>
							<span class="count text-primary">								
								<c:choose>
								  <c:when test="${computation == '1'}">
								 	 Match-based similarity								   
								  </c:when>
								  <c:when test="${computation == '2'}">
								  	Containment-based similarity
								  </c:when>
								  <c:when test="${computation == '3'}">
								   	 Cosine similarity
								  </c:when>
								  <c:when test="${computation == '4'}">
								   	Dice's coefficient
								  </c:when>								  
								</c:choose>							
							</span>
							</span>
						</div>
					</div>
					
					<div class="span3">
						<div class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse" >
							<span class="txt">Threshold</span>	
							<div class="clearfix"></div>					
							<span class="count text-primary"><fmt:formatNumber value="${threshold}" maxFractionDigits="3" /></span>
						</div>
					</div>
				</div>
				<hr class="separator">
				<div class="row-fluid row-merge">
				<div class="accordion" id="accordion">
				
					<!-- Accordion Item -->
					<div class="accordion-group">
						
					    <div id="collapse-parameters" class="accordion-body collapse">
					    <form action="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster" method="get">						
								<!-- Slider -->
								<div class="slider-range-min4 row-fluid">
									<div class="span3 center">
										<p>Threshold:</p> 
									</div>
									<div class="span6" >
										<input type="hidden" id="actual_threshold" value="${fn:substringAfter(threshold, '0.')}">
										<div class="slider slider-primary" style="margin-top:5px"></div>
									</div>
									<div class="span3 center">
										<input id="input-threshold" type="text" class="amount center strong" name="threshold"/>
									</div>
								</div>
								<!-- // Slider END -->
								<div class="separator"></div>
								
								<div class="row-fluid">
								
									<div class="span3"><button class="btn btn-block btn-inverse" name="computation" value="1">Match-based similarity</button></div>
									<div class="span3"><button class="btn btn-block btn-inverse" name="computation" value="2">Containment-based similarity</button></div>
									<div class="span3"><button class="btn btn-block btn-inverse" name="computation" value="3">Cosine similarity</button></div>
									<div class="span3"><button class="btn btn-block btn-inverse" name="computation" value="4">Dice's coefficient</button></div>
								
								</div>
								
								<hr class="separator top">
						</form>	
					    </div>
				  	</div>
				  	<!-- // Accordion Item END -->
				  	
				</div>
				</div>
				
				<div class="row-fluid">
					<div class="span3">
						<div class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse" data-toggle="tooltip" data-original-title="Number of clusters" data-placement="top">
							<span class="glyphicons vector_path_polygon"><i></i><span class="txt">Clusters</span></span>
							<div class="clearfix"></div>
							<span class="count">${clusters.size()}</span>
						</div>
					</div>
					
					<div class="span2">
						<div class="widget-stats widget-stats-1" class="btn btn-inverse" data-toggle="tooltip" data-original-title="Average number of metamodels in a cluster" data-placement="top">
							<span class="glyphicons left_indent"><i></i><span class="txt">Avarage</span></span>
							<div class="clearfix"></div>
							<span class="count"><fmt:formatNumber value="${average}" maxFractionDigits="2" /></span>
						</div>
					</div>
					<div class="span2">
						<div class="widget-stats widget-stats-1" data-toggle="tooltip" data-original-title="Maximum number of metamodels in a cluster" data-placement="top">
							<span class="glyphicons star"><i></i><span class="txt">Max Cluster</span></span>
							<div class="clearfix"></div>
							<span class="count">${max}</span>
						</div>
					</div>
					<div class="span2">
						<div class="widget-stats widget-stats-1" data-toggle="tooltip" data-original-title="Number of metamodels that are not found in any cluster" data-placement="top">
							<span class="glyphicons buoy"><i></i><span class="txt">Singleton</span></span>
							<div class="clearfix"></div>
							<span class="count"><fmt:formatNumber value="${noCluster}" maxFractionDigits="2" /></span>
						</div>
					</div>
					<div class="span3">
						<div class="widget-stats widget-stats-1" data-toggle="tooltip" data-original-title="Effective cluster" data-placement="top">
							<span class="glyphicons certificate"><i></i><span class="txt">Effective cluster</span></span>
							<div class="clearfix"></div>
							<span class="count"><fmt:formatNumber value="${clusters.size()-noCluster}" maxFractionDigits="2" /></span>
						</div>
					</div>	
					
					
			</div>
			<hr>
			<!-- // Row END -->									
		</div>
					
					
					
		
	
	</div>
	
	
	<div class="separator bottom"></div>
	<!-- // Stats Widgets END -->	
	

	






	<!-- Tabs -->
	<div class="">
		<div class="">
		
		
			<div class="relativeWrap">
		<div class="widget widget-tabs widget-tabs-double widget-tabs-vertical row-fluid row-merge">
		
			<!-- Tabs Heading -->
			<div class="widget-head span3" style="height: 600px; overflow-y: scroll;">
				<ul>
					<c:forEach items="${clusters}"  var="cluster" varStatus="loop">
						
						<c:choose>
						  <c:when test="${loop.index == 0}">
						    <li class="active" style="padding:12px; height:70px">
						  </c:when>						 
						  <c:otherwise>
						    <li style="padding:12px; height:70px">
						  </c:otherwise>
						</c:choose>
							<div class="span9">
							<a href="#tab-${loop.index}" data-toggle="tab" style="height:74px !important;"><i></i><span class="strong">Cluster ${loop.index}</span>
								<span>
									<c:forEach items="${cluster.domains}" var="domain">
										${domain}
									</c:forEach>	
								</span>
							</a>
							</div>
							<div class="span2">
								<span style="float:right;">${cluster.getArtifacts().size()}</span>
							</div>
					</c:forEach>
							</li>					
				</ul>
			
			</div>
			<!-- // Tabs Heading END -->
			
			<div class="widget-body span9">
				<div class="tab-content">
				<div class="innerLR">
					<c:forEach items="${clusters}"  var="cluster" varStatus="loop2">
						<!-- Tab content -->
						
						
						<c:choose>
							 <c:when test="${loop2.index == 0}">		
											<div class="tab-pane active" id="tab-${loop2.index}">										    
							</c:when>						 
							<c:otherwise>
										<div class="tab-pane" id="tab-${loop2.index}">						  
							 </c:otherwise>
						</c:choose>
						
						
						
						
						
							
							<div class="title">
								<div class="row-fluid">
									<div class="span12">
										<h3 class="text-primary">Cluster  ${loop2.index}</h3>
										<span class="muted">
											<c:forEach items="${cluster.domains}" var="domain">															
													${domain}
											</c:forEach>		
										</span>
										<p><strong class="text-primary">${cluster.artifacts.size()}</strong> Metamodels </p>
									</div>
									
								</div>
							</div>
							<hr/>
							
							
							
							<div class="row-fluid row-merge">
							
								
									<div class="row-fluid innerB">
										<div class="span5">
											<div class="widget widget-heading-simple">
				
												<!-- Widget Heading -->
												<div class="widget-head">
													<h5 class="input-name">Measures</h5>
												</div>
												<!-- // Widget Heading END -->
												
												<div class="widget-body list simple-list">
													<ul>
													
														<!-- List item -->
														<li>
															<span>K MAX</span>
															<span class="count">${cluster.getkMax()}</span>
														</li>
														<!-- // List item END -->
														
																												<!-- List item -->
														<li>
															<span>K MIN</span>
															<span class="count">${cluster.getkMin()}</span>
														</li>
														<!-- // List item END -->
																												<!-- List item -->
														<li>
															<span>K AVG</span>
															<span class="count"><fmt:formatNumber value="${cluster.getkAvg()}" maxFractionDigits="2" /></span>
														</li>
														<!-- // List item END -->
																												
													</ul>
												</div>
											</div>
											
											
										</div>
										<div class="span7">											
	
											<div class="widget widget-heading-simple">
					
												<!-- Widget Heading -->
												<div class="widget-head">
													<h5 class="input-name">Domain(s)</h5>
												</div>
												<!-- // Widget Heading END -->
												
												<div class="widget-body list simple-list">
												
													<!-- List -->
													<ul>
														<c:choose>
															<c:when test="${empty cluster.domains}">
																<li><span>NO DOMAIN</span></li>
															</c:when>
															<c:otherwise>
																<c:forEach items="${cluster.domains}" var="domain">															
																	<li><span>${domain}</span></li>
																</c:forEach>																								
															</c:otherwise>
														</c:choose>
													</ul>
													<!-- // List END -->
													
												</div>
											</div>
										</div>
										
										
									</div>
									<div class="row-fluid">
										<div class="span12">
											<h5 class="input-name">Metamodels</h5>
											<table class="footable table table-striped table-white table-metrics table-pricing">	
													<!-- Table heading -->
													<thead>
														<tr>																						
															<th data-class="expand">Name</th>
<!-- 															<th data-hide="phone">Description</th> -->
															<th data-hide="phone,tablet" class="center">Visibility</th>
															<th data-hide="phone,tablet" class="center">Created</th>
															<th data-hide="phone,tablet" class="center">Modified</th>
															<th data-hide="phone,tablet" class="center">Most Representative</th>
															<th data-hide="phone,tablet" class="center">Actions</th>
														</tr>
													</thead>
													<!-- // Table heading END -->
													
													<!-- Table body -->
													<tbody>
														<c:forEach items="${cluster.artifacts}" var="artifact">
															<!-- Table row -->
															 <tr class="gradeX">
																<td>
																<c:choose>
																	<c:when test="${artifact.getOpen() == true}">
																		<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${artifact.getId()}">${artifact.getName()}</a>
																		</c:when>
																		<c:otherwise>
																		<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact_details?artifact_id=${artifact.getId()}">${artifact.getName()}</a>
																		</c:otherwise>
																</c:choose>
																</td>																													
																
<%-- 																<td>${artifact.getDescription()}</td> --%>
																<td class="center">
																	<c:choose>
																		<c:when test="${artifact.getOpen() == true}">
																		<span class="text-success">Public</span>
																		</c:when>
																		<c:otherwise>
																		<span class="text-error">Private</span>
																		</c:otherwise>
																	</c:choose>
																</td>
																<td class="center"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getCreated()}" /></td>
																<td class="center"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getModified()}" /></td>
																<c:choose>
																  <c:when test="${artifact.getId() == cluster.getMostRepresentive().getId()}">		
																  <td class="center"><span class="glyphicons standard circle_ok"><i></i></span></td>													    
																  </c:when>						 
																  <c:otherwise>
																  <td></td>
																  </c:otherwise>
																</c:choose>
																<td class="center actions">
																	<c:if test="${artifact.getOpen()}">
																		<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${artifact.getId()}" class="btn">View</a>
																	</c:if>
																	<c:if test="${not artifact.getOpen()}">																	
																		<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact_details?artifact_id=${artifact.getId()}" class="btn">View</a>
																	</c:if>																	
																</td>
															</tr>
															<!-- // Table row END -->
														</c:forEach>
														
														
														
														
													</tbody>
													<!-- // Table body END -->
													
												</table>
													
													
												</div>										
											</div>
											<hr>
											<div class="row-fluid">
											
												<div class="span12">
												<h5 class="input-name">Relations</h5>
													<!-- Table -->
													<table class="table table-striped table-metrics table-white">
													
													    <!-- Table heading -->
													    <thead>
													        <tr>
													            <th>Artifact</th>
													            <th class="center">Similarity Value</th>
													            <th class="text-right">Artifact</th>
													        </tr>
													    </thead>
													    <!-- // Table heading END -->
													
													    <!-- Table body -->
													    <tbody>
															<c:forEach items="${cluster.relations}" var="relation">
													        <!-- Table row -->
													        <tr>
													        <td>
																<c:choose>
																	<c:when test="${relation.getFromArtifact().getOpen() == true}">
																		<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a>
																		</c:when>
																		<c:otherwise>
																		<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact_details?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a>
																		</c:otherwise>
																</c:choose>
																</td>	
													            <td class="center"><span class="badge badge-success"><fmt:formatNumber value="${relation.getValue()}" maxFractionDigits="2" /></span></td>
													             <td class="text-right">
																<c:choose>
																	<c:when test="${relation.getToArtifact().getOpen() == true}">
																		<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
																		</c:when>
																		<c:otherwise>
																		<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact_details?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
																		</c:otherwise>
																</c:choose>
																</td>
													           
													        </tr>
													        <!-- // Table row END -->
															</c:forEach>
													       
													
													</table>
													<!-- // Table END -->
												</div>
											</div>
										
										
									</div>
						</div>
						<!-- // Tab content END -->
					</c:forEach>
					</div>
					
				</div>
				
			</div>
		</div>
	</div>
		
		
		
		
		

		</div>
	</div>
	<!-- // Tabs END -->
	
	
	
	
	
</div>	







	
	
	
	
	<!-- JQueryUI -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/css/smoothness/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />

<!-- JQueryUI -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/js/jquery-ui-1.9.2.custom.min.js"></script>


<!-- jQRangeSlider Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/sliders/jQRangeSlider/jQAllRangeSliders-withRuler-min.js"></script>
	
	<!-- Sliders Page Demo Script -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/my_sliders.js"></script>

