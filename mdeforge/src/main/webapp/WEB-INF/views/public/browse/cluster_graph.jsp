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
<div class="innerLR" id="dashboard">


	<div class="row-fluid">
		<div class="span6">
			<h3 class="header-h main-title cluster-title">Cluster Metamodel Graph View</h3>
		</div>
		<div class="span6">
			<h3 class="header-h main-title cluster-title text-right"><a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster?threshold=${threshold}&computation=${computation}">Cluster Metamodel Table View</a></h3>
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