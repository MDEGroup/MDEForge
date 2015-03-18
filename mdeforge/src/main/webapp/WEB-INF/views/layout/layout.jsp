<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:importAttribute scope="request"/> 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>MDEForge</title>
		<meta name="description" content="description">
		<meta name="author" content="Amleto Di Salle, Alexander Perucci">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="${pageContext.request.contextPath}/resources/plugins/bootstrap/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
		<link href="${pageContext.request.contextPath}/resources/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/plugins/xcharts/xcharts.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/plugins/select2/select2.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
				<script src="http://getbootstrap.com/docs-assets/js/html5shiv.js"></script>
				<script src="http://getbootstrap.com/docs-assets/js/respond.min.js"></script>
		<![endif]-->
		<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery-2.1.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/justified-gallery/jquery.justifiedgallery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/tinymce/tinymce.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/tinymce/jquery.tinymce.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/datatables/dataTables.bootstrap.js"></script>
		<script src='${pageContext.request.contextPath}/resources/plugins/datatables/my.js'></script>    
		<script src='${pageContext.request.contextPath}/resources/plugins/datatables/columnfilter151.js'></script>    
		<script src="${pageContext.request.contextPath}/resources/plugins/datatables/TableTools.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script>
		
		<script src="${pageContext.request.contextPath}/resources/js/devoops.js"></script>
	</head>
<body>
<tiles:insertAttribute name="header" ignore="true"/>
<div id="main" class="container-fluid">
	<div class="row">
		<tiles:insertAttribute name="menu" ignore="true"/>
		<div id="content" class="col-xs-12 col-sm-10">
				<tiles:insertAttribute name="body"/>
		</div>
	</div>
</div>
</body>
</html>
