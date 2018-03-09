<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<tiles:importAttribute scope="request"/>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="front ie lt-ie9 lt-ie8 lt-ie7 fluid top-full"> <![endif]-->
<!--[if IE 7]>    <html class="front ie lt-ie9 lt-ie8 fluid top-full sticky-top"> <![endif]-->
<!--[if IE 8]>    <html class="front ie lt-ie9 fluid top-full sticky-top"> <![endif]-->
<!--[if gt IE 8]> <html class="front ie gt-ie8 fluid top-full sticky-top"> <![endif]-->
<!--[if !IE]><!--><html class="front fluid top-full sticky-top"><!-- <![endif]-->
<head>
	<title><spring:message code="mdeforge" /></title>
	
	<!-- Meta -->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
	
	<link rel="icon"  type="image/png" href="${pageContext.request.contextPath}/resources/theme/images/favicon.ico">
	
	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/responsive.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" rel="stylesheet" />
	
	
	<!-- Glyphicons Font Icons -->
	<link href="${pageContext.request.contextPath}/resources/theme/fonts/glyphicons/css/glyphicons.css" rel="stylesheet" />
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/fonts/font-awesome/css/font-awesome.min.css">
	<!--[if IE 7]><link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/fonts/font-awesome/css/font-awesome-ie7.min.css"><![endif]-->
	
	<!-- Uniform Pretty Checkboxes -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/pixelmatrix-uniform/css/uniform.default.css" rel="stylesheet" />
	
	<!-- Bootstrap Extended -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
	
	<!-- JQueryUI -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/css/smoothness/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
	
	<!-- MiniColors ColorPicker Plugin -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/color/jquery-miniColors/jquery.miniColors.css" rel="stylesheet" />
	
	<!-- Google Code Prettify Plugin -->
	<link href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/google-code-prettify/prettify.css" rel="stylesheet" />

	<!-- Bootstrap Image Gallery -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-image-gallery/css/bootstrap-image-gallery.min.css" rel="stylesheet" />
	
	<!-- Main Theme Stylesheet :: CSS -->
	<link href="${pageContext.request.contextPath}/resources/theme/css/style-default.css?1373029344" rel="stylesheet" />
	
	
	<!-- LESS.js Library -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/less.min.js"></script>
</head>
<body class="<tiles:insertAttribute name="page_type" ignore="true"/>">
	<a href="https://github.com/MDEGroup/MDEForge" target="_blank"><img id="github-banner" src="https://camo.githubusercontent.com/121cd7cbdc3e4855075ea8b558508b91ac463ac2/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f6c6566745f677265656e5f3030373230302e706e67" alt="Fork me on GitHub" data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_left_green_007200.png"></a>
	<!-- Main Container Fluid -->
	<div class="container-fluid">
		
		<!-- Content -->
		<div id="content">
		
		<!-- Top navbar (note: add class "navbar-hidden" to close the navbar by default) -->
<%-- 		<tiles:insertAttribute name="menu"/> --%>
		<!-- Top navbar END -->
		
	
		<!-- Body START -->
		<tiles:insertAttribute name="body"/>
		<!-- Body END -->
		
		</div>
		<!-- // Content END -->
		
		<!-- // Footer START -->
		<tiles:insertAttribute name="footer"/>
		<!-- // Footer END -->
		
	</div>
	<!-- // Main Container Fluid END -->


	
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	
	<!-- Code Beautify -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/js-beautify/beautify.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/js-beautify/beautify-html.js"></script>
	
	<!-- Global -->
	<script>
	var basePath = '',
		commonPath = '${pageContext.request.contextPath}/resources/';
	</script>
	
	<!-- JQueryUI -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/js/jquery-ui-1.9.2.custom.min.js"></script>
	
	<!-- JQueryUI Touch Punch -->
	<!-- small hack that enables the use of touch events on sites using the jQuery UI user interface library -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	
	
	<!-- Modernizr -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/modernizr.js"></script>
	
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- SlimScroll Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/jquery-slimScroll/jquery.slimscroll.min.js"></script>
	
	<!-- Common Demo Script -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/demo/common.js?1373029344"></script>
	
	<!-- Holder Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/holder/holder.js"></script>
	<script>
		Holder.add_theme("dark", {background:"#000", foreground:"#aaa", size:9});
		Holder.add_theme("white", {background:"#fff", foreground:"#c9c9c9", size:9});
	</script>
	
	<!-- Uniform Forms Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/pixelmatrix-uniform/jquery.uniform.min.js"></script>

	<!-- Bootstrap Extended -->
	<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/bootbox.js"></script>
	
	<!-- Google Code Prettify -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/google-code-prettify/prettify.js"></script>
	
	<!-- Cookie Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery.cookie.js"></script>
		
		
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-49762168-2', 'mdeforge.org');
  ga('send', 'pageview');
  $(document).ready(function(){
	  var page = window.location.pathname;
	  switch(page){
	  case "/" : $("#menu-home").addClass("active"); break;
	  case "/public/about" : $("#menu-about").addClass("active"); break;
	  case "/public/members" : $("#menu-members").addClass("active"); break;
	  case "/public/publications" : $("#menu-publications").addClass("active"); break;
	  case "/login" : $("#menu-login").addClass("active"); break;
	  }
  })
</script>


</body>
</html>