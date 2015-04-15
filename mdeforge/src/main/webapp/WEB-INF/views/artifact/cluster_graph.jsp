<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/vis/vis.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/vis/vis.css">
  <style type="text/css">
    #mynetwork {
      width: 100%;
      height: 600px;
      border: 1px solid lightgray;
    }
  </style>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Artifact</a></li>
			<li><a href="#">Cluster</a></li>			
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3>
			<spring:message code="mdeforge.metamodel.similarity.graph" />
		</h3>
	</div>
	<div class="clearfix visible-xs"></div>
</div>

<div class="row-fluid">
	<div id="mynetwork"></div>
	<div class="clearfix"></div>
</div>

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