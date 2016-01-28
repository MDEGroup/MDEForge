<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- JQRangeSlider Sliders Plugin -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/sliders/jQRangeSlider/css/iThing.css" rel="stylesheet" />
<!-- PER GRAFICO DEL CLUSTER - START -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/plugins/vis/vis.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/vis/vis.css">
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
		<li><a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full" class="glyphicons dashboard"><i></i> Public area</a></li>
		<li class="divider"></li>
		<li>Browse</li>
		<li class="divider"></li>
		<li>Cluster</li>
		<li class="divider"></li>
		<li>Graph View</li>
</ul>
<!-- Breadcrumb END -->

<!-- Heading -->
<div class="heading-buttons">
	<h3><spring:message code="mdeforge.public.back.browse.menu.cluster_metamodel" /> <spring:message code="mdeforge.public.back.browse.graph"/></h3>
	<span> Metamodels in the repository: ${numberOfMetamodels}</span>
	<div class="buttons pull-right">
		<span class="btn btn-success btn-icon glyphicons adjust_alt" data-toggle="hide" data-target="#threshold_form"><i></i> Set Parameters</span>			
		<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster?threshold=${threshold}&computation=${computation}" class="btn btn-primary btn-icon glyphicons show_big_thumbnails"><i></i> Table View</a>				
	</div>
	<div class="clearfix"></div>
</div>
<div class="separator bottom"></div>
<!-- // Heading END -->

<div class="innerLR">
	<div class="hide" id="threshold_form">
			<div class="row-fluid">
				<div class="span2">
				</div>	
				<div class="span8">	
			<div class="widget widget-heading-simple widget-body-white" data-toggle="collapse-widget">													
				<div class="widget-body">	
					<div class="widget-body">
							<div class="row-fluid">
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph" method="get">
								<div class="span9">		
											<!-- Slider -->
											<div class="slider-range-min row-fluid">
												<div class="span3">
													<label class="span8">Threshold:</label> 
													<input type="text" class="amount span4" name="threshold"/>
												</div>
												<div class="span9" style="padding: 5px 0 0;">

													<c:choose>
													  <c:when test="${fn:length(fn:substringAfter(threshold, '0.')) == 1}">
													    <c:set var="newThreshold" value="${fn:substringAfter(threshold, '0.')}0"/>
													  </c:when>
													  <c:otherwise>
													    <c:set var="newThreshold" value="${fn:substringAfter(threshold, '0.')}"/>
													  </c:otherwise>
													</c:choose>																										
													
													<input type="hidden" id="actual_threshold" value="${newThreshold}">
													<div class="slider slider-primary"></div>
												</div>
											</div>
											<!-- // Slider END -->
								</div>
								<div class="span3">														
									<button class="btn btn-block btn-success" name="computation" value="1">Match-based similarity</button>
								</div>
							</form>
							</div>
						</div>
					<hr>
					<div class="widget-body">
							<div class="row-fluid">
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph" method="get">
								<div class="span9">		
											<!-- Slider -->
											<div class="slider-range-min2 row-fluid">
												<div class="span3">
													<label class="span8">Threshold:</label> 
													<input type="text" class="amount span4" name="threshold"/>
												</div>
												<div class="span9" style="padding: 5px 0 0;">
													<input type="hidden" id="actual_threshold" value="0.3 - ${fn:substringAfter(threshold, '0.')}">
													<div class="slider slider-primary"></div>
												</div>
											</div>
											<!-- // Slider END -->
								</div>
								<div class="span3">														
									<button class="btn btn-block btn-success" name="computation" value="2">Containment-based similarity</button>
								</div>
							</form>
							</div>
						</div>
						<hr>
					<div class="widget-body">
							<div class="row-fluid">
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph" method="get">
								<div class="span9">		
											<!-- Slider -->
											<div class="slider-range-min3 row-fluid">
												<div class="span3">
													<label class="span8">Threshold:</label> 
													<input type="text" class="amount span4" name="threshold"/>
												</div>
												<div class="span9" style="padding: 5px 0 0;">
													<input type="hidden" id="actual_threshold" value="${fn:substringAfter(threshold, '0.')}">
													<div class="slider slider-primary"></div>
												</div>
											</div>
											<!-- // Slider END -->
								</div>
								<div class="span3">														
									<button class="btn btn-block btn-success" name="computation" value="3">Cosine similarity</button>
								</div>
							</form>
							</div>
						</div>
						<hr>
					<div class="widget-body">
							<div class="row-fluid">
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph" method="get">
								<div class="span9">		
									<!-- Slider -->
									<div class="slider-range-min4 row-fluid">
										<div class="span3">
											<label class="span8">Threshold:</label> 
											<input type="text" class="amount span4" name="threshold"/>
										</div>
										<div class="span9" style="padding: 5px 0 0;">
											<input type="hidden" id="actual_threshold" value="${fn:substringAfter(threshold, '0.')}">
											<div class="slider slider-primary"></div>
										</div>
									</div>
									<!-- // Slider END -->
								</div>
								<div class="span3">														
									<button class="btn btn-block btn-success" name="computation" value="4">Dice's coefficient</button>
								</div>
			
							</form>
							</div>
						</div>
						<hr>
						<div class="widget-body">
							<div class="row-fluid">
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph" method="get">
								<div class="span9">		
								</div>
								<div class="span3" style="text-align:right;">		
									<span class="btn btn-default" data-toggle="hide" data-target="#threshold_form"> Close</span>	
								</div>
							</form>
							</div>
						</div>
					
			</div>
			</div>
		</div>
		<div class="span2">
		</div>	
		</div>
		</div>
		<div class="separator bottom"></div>
		<div class="separator bottom"></div>
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-simple"> 
		<div class="widget-body">		
			<!-- Row -->
			<div class="row-fluid">
				<div class="span6">
					<div class="span4">
						<div class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse" data-toggle="tooltip" data-original-title="Computation" data-placement="top">
							<span class="txt">Similarity Measure</span>
							<div class="clearfix"></div>
							<span class="count" style="font-size:26px; line-height:28px;">								
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
						</div>
					</div>
					
					<div class="span4">
						<div class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse" data-toggle="tooltip" data-original-title="Threshold of this cluster" data-placement="top">
							<span class="glyphicons adjust_alt"><i></i><span class="txt">Threshold</span></span>
							<div class="clearfix"></div>
							<span class="count"><fmt:formatNumber value="${threshold}" maxFractionDigits="3" /></span>
						</div>
					</div>
					
					<div class="span4">
						<div class="widget-stats widget-stats-gray widget-stats-1" class="btn btn-inverse" data-toggle="tooltip" data-original-title="Number of clusters" data-placement="top">
							<span class="glyphicons vector_path_polygon"><i></i><span class="txt">Clusters</span></span>
							<div class="clearfix"></div>
							<span class="count">${clusters.size()}</span>
						</div>
					</div>
					
				</div>
				<div class="span6">
					<div class="span3">
						<div class="widget-stats widget-stats-1" class="btn btn-inverse" data-toggle="tooltip" data-original-title="Average number of metamodels in a cluster" data-placement="top">
							<span class="glyphicons left_indent"><i></i><span class="txt">Avarage</span></span>
							<div class="clearfix"></div>
							<span class="count"><fmt:formatNumber value="${average}" maxFractionDigits="2" /></span>
						</div>
					</div>
					<div class="span3">
						<div class="widget-stats widget-stats-1" data-toggle="tooltip" data-original-title="Maximum number of metamodels in a cluster" data-placement="top">
							<span class="glyphicons star"><i></i><span class="txt">Max Cluster</span></span>
							<div class="clearfix"></div>
							<span class="count">${max}</span>
						</div>
					</div>
					<div class="span3">
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
			</div>
			<!-- // Row END -->									
		</div>
	</div>
	
	<div class="separator bottom"></div>
	<!-- // Stats Widgets END -->
	
	<!-- Tabs -->
	<div class="">
		<div class="box-generic">		
			<div id="mynetwork"></div>
		</div>
	</div>
</div>
<!-- PER GRAFICO DEL CLUSTER - START -->
<script type="text/javascript">
	var network;
/* 	function onSelect (data) {
		  alert('selected nodes: '.data[0]);
	}
	 */
	function redrawAll() {
		network = null;
		// create an array with nodes
		${graph}
		// create a network
		var container = document.getElementById('mynetwork');
		var data = {
			nodes : nodes,
			edges : edges
		};
		var options = {
			/* height:  '1000px', */
			nodes : {
				shape : 'dot',
				radiusMin : 10,
				radiusMax : 30,
				fontSize : 40,
				fontFace : "Tahoma"
			},
			edges : {
				width : 0.15,
				fontSize : 40,
				inheritColor : "from"
			},
			tooltip : {
				delay : 200,
				fontSize : 12,
				color : {
					background : "#fff"
				}
			},
			stabilize : false,
			smoothCurves : {
				dynamic : false,
				type : "continuous"
			},
			physics : {
				barnesHut : {
					gravitationalConstant : -80000,
					springConstant : 0.001,
					springLength : 200
				}
			},
			hideEdgesOnDrag : true
		};
		network = new vis.Network(container, data, options);
		
		/* // add event listener*/
		  network.on('doubleClick', function(properties) {
			  var node_id = properties.nodes;
			  var node = data.nodes[node_id-1];
			  if(node['label']){
				  window.open("${pageContext.request.contextPath}/public/EcoreMetamodel/artifact_name?name="+node['label'], '_blank');
			  }
		  });
	}
	redrawAll()
</script>
<!-- PER GRAFICO DEL CLUSTER - END -->
	<!-- JQueryUI -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/css/smoothness/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<!-- JQueryUI -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/js/jquery-ui-1.9.2.custom.min.js"></script>
<!-- jQRangeSlider Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/sliders/jQRangeSlider/jQAllRangeSliders-withRuler-min.js"></script>
	<!-- Sliders Page Demo Script -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/my_sliders.js"></script>