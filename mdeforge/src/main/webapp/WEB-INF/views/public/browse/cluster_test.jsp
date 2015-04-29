<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
	<li><a
		href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full"
		class="glyphicons dashboard"><i></i> Private area</a></li>
	<li class="divider"></li>
	<li>Services</li>
	<li class="divider"></li>
	<li>Transformation Chain</li>
</ul>
<!-- Breadcrumb END -->


<h3>
	<spring:message
		code="mdeforge.public.back.browse.menu.cluster_metamodel" />
</h3>


<div class="innerLR">
	<!-- Tab content -->
	<div id="mynetwork"></div>
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