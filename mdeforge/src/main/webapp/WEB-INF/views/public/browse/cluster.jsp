<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
					<li class="glyphicons folder_open active"><a href="#tab1-1" data-toggle="tab"><i></i> <spring:message code="mdeforge.public.back.browse.table"/> <strong>(3)</strong></a></li>
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
							<a href="#tab-${loop.index}" data-toggle="tab"><i></i><span class="strong">Cluster ${loop.index}</span><span>Billing details</span></a>
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
							
							
							<table class="footable table table-striped table-bordered table-white table-primary">
	
		<!-- Table heading -->
		<thead>
			<tr>
				<th data-class="expand">Name</th>
				<th data-hide="phone,tablet">Browser</th>
				<th data-hide="phone,tablet">Platform(s)</th>
				<th data-hide="phone">Eng. vers.</th>
				<th>CSS grade</th>
			</tr>
		</thead>
		<!-- // Table heading END -->
		
		<!-- Table body -->
		<tbody>
			<c:forEach items="${cluster.artifacts}" var="artifact">
				<!-- Table row -->
				<tr class="gradeX">
					<td>${artifact.getName()}</td>
					<td>Internet Explorer 4.0</td>
					<td>Win 95+</td>
					<td class="center">4</td>
					<td class="center">X</td>
				</tr>
				<!-- // Table row END -->
			</c:forEach>
			
			
		</tbody>
		<!-- // Table body END -->
		
	</table>
							
							
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