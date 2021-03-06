<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<tiles:importAttribute scope="request"/>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie lt-ie9 lt-ie8 lt-ie7 fluid top-full sidebar sidebar-full"> <![endif]-->
<!--[if IE 7]>    <html class="ie lt-ie9 lt-ie8 fluid top-full sticky-top sidebar sidebar-full"> <![endif]-->
<!--[if IE 8]>    <html class="ie lt-ie9 fluid top-full sticky-top sidebar sidebar-full"> <![endif]-->
<!--[if gt IE 8]> <html class="ie gt-ie8 fluid top-full sticky-top sidebar sidebar-full"> <![endif]-->
<!--[if !IE]><!--><html class="fluid top-full sticky-top sidebar sidebar-full sticky-sidebar js no-touch csstransforms3d csstransitions"><!-- <![endif]-->
<head>
	<title><spring:message code="mdeforge"/></title>
	
	<!-- Meta -->
	<meta charset="utf-8"/>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
	
	<link rel="icon"  type="image/png" href="${pageContext.request.contextPath}/resources/theme/images/favicon.ico">
	
	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/responsive.css" rel="stylesheet" type="text/css" />
	
	<!-- Glyphicons Font Icons -->
	<link href="${pageContext.request.contextPath}/resources/theme/fonts/glyphicons/css/glyphicons.css" rel="stylesheet" />
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/fonts/font-awesome/css/font-awesome.min.css">
	<!--[if IE 7]><link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/fonts/font-awesome/css/font-awesome-ie7.min.css"><![endif]-->
	
	<!-- Uniform Pretty Checkboxes -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/pixelmatrix-uniform/css/uniform.default.css" rel="stylesheet" />
	
	<!-- PrettyPhoto -->
    <link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/gallery/prettyphoto/css/prettyPhoto.css" rel="stylesheet" />
    
    <!-- Gritter -->
    <link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/notifications/Gritter/css/jquery.gritter.css" rel="stylesheet" />
    
    <!-- Select2 Plugin -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/selectize/css/selectize.bootstrap3.css" rel="stylesheet" />
	
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/rating/css/rating.min.css" rel="stylesheet" />
    
    <link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/google-code-prettify/prettify.css" rel="stylesheet" />
   
    <link href="${pageContext.request.contextPath}/resources/theme/scripts/highlight/styles/monokai-sublime.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/theme/scripts/highlight/styles/github.css" rel="stylesheet" />
     
    <!-- JQuery -->
	<script src="https://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/html5shiv.js"></script>
    <![endif]-->
	
	<!-- Main Theme Stylesheet :: CSS -->
	<link href="${pageContext.request.contextPath}/resources/theme/css/style-flat.css?1373029331" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
	<%-- <link href="${pageContext.request.contextPath}/resources/theme/skins/css/android-green.css" rel="stylesheet" type="text/css" /> --%>
	<!--  <link href="${pageContext.request.contextPath}/resources/theme/skins/css/bascio_template.css" rel="stylesheet" type="text/css" />-->
	
	
	<!-- FireBug Lite -->
	<!-- <script src="https://getfirebug.com/firebug-lite-debug.js"></script> -->
	<script>var ctx = "${pageContext.request.contextPath}"</script>
	<!-- LESS.js Library -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/less.min.js"></script>
	<style type="text/css">
		table.dataTableArtifacts thead th, table.dataTableArtifacts thead td {
		    border: none !important;
		    line-height: 8px;
		    vertical-align: middle;
		    text-align: left;
		    background-image: none !important;
		}
		table.dataTableArtifacts tbody tr {
		    line-height: 15px;
		}
		.contentView{
			padding: 15px;
		}
	</style>
</head>
<body class="">
	
		<!-- Main Container Fluid -->
	<div class="container-fluid fluid menu-left">
		
				<!-- Sidebar menu & content wrapper -->
		<div id="wrapper">
			
				<!-- Sidebar Menu -->
				<tiles:insertAttribute name="left_menu"/>
				<!-- // Sidebar Menu END -->
					
			<!-- Content -->
			<div id="content">
			
					<!-- Top navbar -->
					<tiles:insertAttribute name="top_menu"/>
					
					<!-- Body START -->
					<tiles:insertAttribute name="body"/>
					<!-- Body END -->
					
		
			
			</div>
			<!-- // Content END -->
		
		</div>
		<div class="clearfix"></div>
		<!-- // Sidebar menu & content wrapper END -->
				
		
		
		
		<!-- // Footer START -->
		<tiles:insertAttribute name="footer"/>
		<!-- // Footer END -->
		
	</div>
	<!-- // Main Container Fluid END -->
	<div class="modal hide fade" id="upload-artifact">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
	    <h3>Upload Artifact</h3>
	  </div>
	  <div class="modal-body">
	 	<p class="header-h title-modal">Choose which kind of artifact you would like to upload?</p>
	    <h4><a href="${pageContext.request.contextPath}/private/EcoreMetamodel/upload" class="glyphicons cloud-upload primary"><i></i> Metamodel</a></h4>
		<h4><a href="${pageContext.request.contextPath}/private/ATLTransformation/upload" class="glyphicons cloud-upload primary"><i></i> ATL Transformation</a></h4>
		<h4><a href="${pageContext.request.contextPath}/private/Model/upload" class="glyphicons cloud-upload primary"><i></i> Model</a></h4>
	  </div>
	  <div class="separator"></div>
	  <div class="modal-footer center">
	    <a href="#" class="btn btn-large" data-dismiss="modal">Cancel</a>
	  </div>
	</div>

	
	<!-- Code Beautify -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/js-beautify/beautify.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/js-beautify/beautify-html.js"></script>
	
	<!-- PrettyPhoto -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/gallery/prettyphoto/js/jquery.prettyPhoto.js"></script>
	
	<!-- Global -->
	<script>
	var basePath = '',
		commonPath = '${pageContext.request.contextPath}/resources/';
	</script>
	
	
	<!-- Modernizr -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/modernizr.js"></script>
	
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- SlimScroll Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/jquery-slimScroll/jquery.slimscroll.min.js"></script>
	
	
	<!-- Holder Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/holder/holder.js"></script>
	<script>
		Holder.add_theme("dark", {background:"#000", foreground:"#aaa", size:9});
		Holder.add_theme("white", {background:"#fff", foreground:"#c9c9c9", size:9});
		<!-- Colors -->
		var primaryColor = '#4a8bc2',
			dangerColor = '#b55151',
			successColor = '#609450',
			warningColor = '#ab7a4b',
			inverseColor = '#45484d';
		var themerPrimaryColor = primaryColor;
	</script>
	
	<!-- Uniform Forms Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/pixelmatrix-uniform/jquery.uniform.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/tables/DataTables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/tables/DataTables/extras/TableTools/media/js/TableTools.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/tables/DataTables/extras/ColVis/media/js/ColVis.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/tables/DataTables/media/js/DT_bootstrap.js"></script>
	
	
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/google-code-prettify/prettify.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/notifications/Gritter/js/jquery.gritter.min.js"></script>
	
	
	<!-- Common Demo Script -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/demo/common.js"></script>
	
	<!-- Tables Demo Script -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/demo/tables.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/bootbox.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/Chart.js"></script>
	
	<!-- Easy-pie Plugin 
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/easy-pie/jquery.easy-pie-chart.js"></script>
	-->
	<!-- Sparkline Charts Plugin 
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/sparkline/jquery.sparkline.min.js"></script>
	-->
	
	<!-- Ba-Resize Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/jquery.ba-resize.js"></script>
	<!-- Select2 Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/selectize/js/standalone/selectize.js"></script>
	<!--  Flot Charts Plugin 
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/flot/jquery.flot.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/flot/jquery.flot.pie.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/flot/jquery.flot.tooltip.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/flot/jquery.flot.selection.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/flot/jquery.flot.resize.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/flot/jquery.flot.orderBars.js"></script>-->
	
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-49762168-2', 'mdeforge.org');
	  ga('send', 'pageview');
	 
	  
	</script>

</body>
</html>