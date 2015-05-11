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
	<div class="buttons pull-right">
		<span class="btn btn-success btn-icon glyphicons adjust_alt" data-toggle="hide" data-target="#threshold_form"><i></i> Set Threshold</span>			
		<a href="${pageContext.request.contextPath}/public/browse/cluster" class="btn btn-primary btn-icon glyphicons stats"><i></i> Table View</a>				
	</div>
	<div class="clearfix"></div>
</div>
<div class="separator bottom"></div>
<!-- // Heading END -->




<div class="innerLR">



	<div class="hide" id="threshold_form">
		
			
			<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
	
				
				
				<div class="widget-body">
					<div class="row-fluid">
					<form action="${pageContext.request.contextPath}/public/browse/cluster_graph" method="get">
						<div class="span6">		
									<!-- Slider -->
									<div class="slider-range-min row-fluid">
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
						<div class="span3" style="padding-left:100px;">
						
							<label class="radio">
								<input type="radio" class="radio" name="computation" value="1" checked="checked"/> Computation 1
							</label><br/>
							<label class="radio">
								<input type="radio" class="radio" name="computation" value="2"  /> Computation 2
							</label>
							
						</div>
						<div class="span3">
							<button class="btn btn-block btn-success">Calculate</button>
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
						<span class="glyphicons buoy"><i></i><span class="txt">Singleton</span></span>
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
		<div class="box-generic">		
		
			<div id="mynetwork"></div>
			
		</div>
	</div>
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
			nodes : nodes,
			edges : edges
		};
		var options = {
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