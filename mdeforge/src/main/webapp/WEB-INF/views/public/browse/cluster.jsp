<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- PER GRAFICO DEL CLUSTER - START -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/vis/vis.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/vis/vis.css">
<style type="text/css">
    #mynetwork {
      width: 100%;
      height: 600px;
      border: 1px solid lightgray;
    }
</style>
<!-- PER GRAFICO DEL CLUSTER - END -->




<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full" class="glyphicons dashboard"><i></i> Private area</a></li>
		<li class="divider"></li>
		<li>Services</li>
		<li class="divider"></li>
		<li>Transformation Chain</li>
</ul>
<!-- Breadcrumb END -->


<h3><spring:message code="mdeforge.public.back.browse.menu.cluster_metamodel"/></h3>


<div class="innerLR">

	<!-- Tabs -->
	<div class="relativeWrap">
		<div class="box-generic">
		
			<!-- Tabs Heading -->
			<div class="tabsbar">
				<ul>					
					<li class="glyphicons folder_open active"><a href="#tab1-1" data-toggle="tab"><i></i> <spring:message code="mdeforge.public.back.browse.table"/> <strong>(${clusters.size()})</strong></a></li>
					<li class="glyphicons vector_path_polygon tab-stacked"><a href="#tab1-2" data-toggle="tab"><i></i> <span><spring:message code="mdeforge.public.back.browse.graph"/></span></a></li>					
				</ul>
			</div>
			<!-- // Tabs Heading END -->
			
			<div class="tab-content">
					
				<!-- Tab content -->
				<div class="tab-pane active" id="tab1-1">
					<h4><spring:message code="mdeforge.public.back.browse.table"/></h4>
					
					
					
					
					
		<div class="relativeWrap">
		<div class="widget widget-tabs widget-tabs-double widget-tabs-vertical row-fluid row-merge">
		
			<!-- Tabs Heading -->
			<div class="widget-head span3">
				<ul>
					<c:forEach items="${clusters}"  var="cluster" varStatus="loop">
						<c:choose>
						  <c:when test="${loop.index == 0}">
						    <li class="active">
						  </c:when>						 
						  <c:otherwise>
						    <li>
						  </c:otherwise>
						</c:choose>
							<a href="#tab-${loop.index}" data-toggle="tab"><i></i><span class="strong">Cluster ${loop.index}</span>
								<span>
									<c:forEach items="${cluster.domains}" var="domain">
										${domain}
									</c:forEach>	
								</span>
							</a>
					</c:forEach>
							</li>					
				</ul>
			</div>
			<!-- // Tabs Heading END -->
			
			<div class="widget-body span9">
				<div class="tab-content">
				
					<c:forEach items="${clusters}"  var="cluster" varStatus="loop2">
						<!-- Tab content -->
						<div class="tab-pane" id="tab-${loop2.index}">
							<h4>Cluster  ${loop2.index}</h4>
							
							
							
							
							<div class="row-fluid row-merge">
							
								<div class="innerLR">
									<div class="row-fluid innerB">
										<div class="span7">
											<!-- Bio -->
											<div class="widget widget-heading-simple widget-body-white margin-none">
												<div class="widget-head"><h4 class="heading glyphicons calendar"><i></i>Domain(s) <span></span></h4></div>
												<div class="widget-body">
													<ul class="unstyled icons margin-none">		
														<c:forEach items="${cluster.domains}" var="domain">
															<li class=""><i></i>${domain}</li>
														</c:forEach>												
														
													</ul>
												</div>
											</div>
											<!-- // Bio END -->
											
										
										</div>
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
															<span class="count">${cluster.getkAvg()}</span>
														</li>
														<!-- // List item END -->
																												
													</ul>
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
															<th data-hide="phone,tablet">Id</th>
															<th data-class="expand">Name</th>
															<th data-hide="phone">Description</th>
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
															
															
																<td>${artifact.getId()}</td>
																<td>${artifact.getName()}</td>
																<td>${artifact.getDescription()}</td>
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
																<td class="right actions">
																	<a href="#" class="btn-action glyphicons eye_open btn-default"><i></i></a>
																	<a href="#" class="btn-action glyphicons pencil btn-success"><i></i></a>
																	<a href="#" class="btn-action glyphicons remove_2 btn-danger"><i></i></a>
																</td>
															</tr>
															<!-- // Table row END -->
														</c:forEach>
														
														
														
														
													</tbody>
													<!-- // Table body END -->
													
												</table>
													
													
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
				<!-- // Tab content END -->
				
				<!-- Tab content -->
				<div class="tab-pane" id="tab1-2">
					<h4><spring:message code="mdeforge.public.back.browse.graph"/></h4>
					
						<div id="mynetwork"></div>
					
					
					
				</div>
				<!-- // Tab content END -->
								
				
			</div>
		</div>
	</div>
	<!-- // Tabs END -->
	
</div>	












<!-- PER GRAFICO DEL CLUSTER - START -->
<script type="text/javascript">
    var network;
    function redrawAll() {
      network = null;
      // create an array with nodes
     ${graph}
      // create a network
        var container = document.getElementById('mynetwork');
      var data = {
        nodes: nodes,
        edges: edges
      };
      var options = {
        nodes: {
            shape: 'dot',
            radiusMin: 10,
            radiusMax: 30,
            fontSize: 12,
            fontFace: "Tahoma"
            },
        edges: {
            width: 0.15,
            inheritColor: "from"
            },
        tooltip: {
            delay: 200,
            fontSize: 12,
            color: {
                background: "#fff"
                }
            },
          stabilize: false,
        smoothCurves: {dynamic:false, type: "continuous"},
        physics: {barnesHut: {gravitationalConstant: -80000, springConstant: 0.001, springLength: 200}},
        hideEdgesOnDrag: true
      };

      network = new vis.Network(container, data, options);
    }
    redrawAll()
</script>
<!-- PER GRAFICO DEL CLUSTER - END -->