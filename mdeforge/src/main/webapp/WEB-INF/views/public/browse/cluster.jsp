<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>








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



<!-- Heading -->
<div class="heading-buttons">
	<h3><spring:message code="mdeforge.public.back.browse.menu.cluster_metamodel"/> <spring:message code="mdeforge.public.back.browse.table"/></h3>
	<div class="buttons pull-right">
		<span class="btn btn-success btn-icon glyphicons adjust_alt" data-toggle="hide" data-target="#threshold_form"><i></i> Set Threshold</span>			
		<a href="${pageContext.request.contextPath}/public/browse/cluster_graph" class="btn btn-primary btn-icon glyphicons stats"><i></i> Graph View</a>			
	</div>
	<div class="clearfix"></div>
</div>
<div class="separator bottom"></div>
<!-- // Heading END -->





<div class="innerLR">





		<div class="hide" id="threshold_form">
		
			
			<div class="widget widget-heading-simple widget-body-white" data-toggle="collapse-widget">
	
				
				
				<div class="widget-body">
					<div class="row-fluid">
					<form action="${pageContext.request.contextPath}/public/browse/cluster" method="get">
						<div class="span4">	
						Threshold						
							<input type="text" placeholder="Threshold" name="threshold" value="0.4"/>
						</div>
						<div class="span4">
						Computation
							<input type="text" placeholder="Computation" name="computation" value="1"/>
						</div>
						<div class="span4">
							<button class="btn btn-block btn-success">Set</button>
						</div>
					</form>
												
						
					</div>
				</div>
			</div>
		
		</div>
		
		
		
		
		
		
		
		
		
		
		

	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-simple">
					
		
		
							
		<div class="widget-body">		
			<!-- Row -->
			<div class="row-fluid">
				<div class="span2">
					<div class="widget-stats widget-stats-gray widget-stats-1">
						<span class="glyphicons adjust_alt"><i></i><span class="txt">Threshold</span></span>
						<div class="clearfix"></div>
						<span class="count"><fmt:formatNumber value="${threshold}" maxFractionDigits="3" /></span>
					</div>
				</div>
				
				<div class="span2">
					<div class="widget-stats widget-stats-1">
						<span class="glyphicons vector_path_polygon"><i></i><span class="txt">Clusters</span></span>
						<div class="clearfix"></div>
						<span class="count">${clusters.size()}</span>
					</div>
				</div>
				<div class="span2">
					<div class="widget-stats widget-stats-1">
						<span class="glyphicons left_indent"><i></i><span class="txt">Avarage</span></span>
						<div class="clearfix"></div>
						<span class="count"><fmt:formatNumber value="${average}" maxFractionDigits="3" /></span>
					</div>
				</div>
				<div class="span2">
					<div class="widget-stats widget-stats-1">
						<span class="glyphicons star"><i></i><span class="txt">Max Cluster</span></span>
						<div class="clearfix"></div>
						<span class="count">${max}</span>
					</div>
				</div>
				<div class="span2">
					<div class="widget-stats widget-stats-1">
						<span class="glyphicons buoy"><i></i><span class="txt">Clusters With One Element</span></span>
						<div class="clearfix"></div>
						<span class="count"><fmt:formatNumber value="${noCluster}" maxFractionDigits="2" /></span>
					</div>
				</div>
				<div class="span2">
					<div class="widget-stats widget-stats-1">
						<span class="glyphicons buoy"><i></i><span class="txt">Effective cluster</span></span>
						<div class="clearfix"></div>
						<span class="count"><fmt:formatNumber value="${clusters.size()-noCluster}" maxFractionDigits="2" /></span>
					</div>
				</div>	
			</div>
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
						    <li class="active" style="padding:12px;">
						  </c:when>						 
						  <c:otherwise>
						    <li style="padding:12px;">
						  </c:otherwise>
						</c:choose>
							<a href="#tab-${loop.index}" data-toggle="tab"><i></i><span class="strong">Cluster ${loop.index}</span>
								<span>
									<c:forEach items="${cluster.domains}" var="domain">
										${domain}
									</c:forEach>	
								</span>
							</a>
							${cluster.getArtifacts().size()}
							
					</c:forEach>
							</li>					
				</ul>
			
			</div>
			<!-- // Tabs Heading END -->
			
			<div class="widget-body span9">
				<div class="tab-content">
				
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
									<div class="span8">
										<h3 class="text-primary">Cluster  ${loop2.index}</h3>
										<span class="muted">
											<c:forEach items="${cluster.domains}" var="domain">															
													${domain}
											</c:forEach>		
										</span>
									</div>
									<div class="span4 text-right">
										<p class="muted">${cluster.artifacts.size()} Metamodels </p>										
									</div>
								</div>
							</div>
							<hr/>
							
							
							
							<div class="row-fluid row-merge">
							
								<div class="innerLR">
									<div class="row-fluid innerB">
										<div class="span5">
											<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
				
												<!-- Widget Heading -->
												<div class="widget-head">
													<h4 class="heading glyphicons history"><i></i>Measures</h4>
													
												</div>
												<!-- // Widget Heading END -->
												
												<div class="widget-body list">
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
	
											<div class="widget widget-heading-simple widget-body-gray">
					
												<!-- Widget Heading -->
												<div class="widget-head">
													<h4 class="heading glyphicons list"><i></i>Domain(s)</h4>
												</div>
												<!-- // Widget Heading END -->
												
												<div class="widget-body list">
												
													<!-- List -->
													<ul>
														<c:forEach items="${cluster.domains}" var="domain">															
															<li>${domain}</li>
														</c:forEach>																								
														
													</ul>
													<!-- // List END -->
													
												</div>
											</div>
										</div>
										
										
									</div>
									<div class="row-fluid">
										<div class="span12">
											
											<table class="footable table table-striped table-bordered table-white table-primary table-pricing">	
													<!-- Table heading -->
													<thead>
														<tr>																						
															<th data-class="expand">Name</th>
<!-- 															<th data-hide="phone">Description</th> -->
															<th data-hide="phone,tablet">Open</th>
															<th data-hide="phone,tablet">Created</th>
															<th data-hide="phone,tablet">Modified</th>
															<th data-hide="phone,tablet">Most Representative</th>
															<th data-hide="phone,tablet">Actions</th>
														</tr>
													</thead>
													<!-- // Table heading END -->
													
													<!-- Table body -->
													<tbody>
														<c:forEach items="${cluster.artifacts}" var="artifact">
															<!-- Table row -->
															 <tr class="gradeX">
																																														
																<td>${artifact.getName()}</td>
<%-- 																<td>${artifact.getDescription()}</td> --%>
																<td class="center">${artifact.getOpen()}</td>
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
																	<a href="#" class="btn-action glyphicons eye_open btn-default"><i></i></a>																	
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
													<!-- Table -->
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
															<c:forEach items="${cluster.relations}" var="relation">
													        <!-- Table row -->
													        <tr>
													            <td>${relation.getFromArtifact().getName()}</td>
													            <td class="center"><span class="badge badge-success"><fmt:formatNumber value="${relation.getValue()}" maxFractionDigits="2" /></span></td>
													            <td>${relation.getToArtifact().getName()}</td>
													        </tr>
													        <!-- // Table row END -->
															</c:forEach>
													       
													
													</table>
													<!-- // Table END -->
												</div>
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
	<!-- // Tabs END -->
	
</div>	












