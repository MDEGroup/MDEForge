<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie lt-ie9 lt-ie8 lt-ie7 fluid top-full sidebar sidebar-full"> <![endif]-->
<!--[if IE 7]>    <html class="ie lt-ie9 lt-ie8 fluid top-full sticky-top sidebar sidebar-full"> <![endif]-->
<!--[if IE 8]>    <html class="ie lt-ie9 fluid top-full sticky-top sidebar sidebar-full"> <![endif]-->
<!--[if gt IE 8]> <html class="ie gt-ie8 fluid top-full sticky-top sidebar sidebar-full"> <![endif]-->
<!--[if !IE]><!--><html class="fluid top-full sticky-top sidebar sidebar-full"><!-- <![endif]-->
<head>
	<title>MDEForge sign in</title>
	
	<!-- Meta -->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
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
    <!-- JQuery -->
	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/html5shiv.js"></script>
    <![endif]-->
	<!-- Main Theme Stylesheet :: CSS -->
	<link href="${pageContext.request.contextPath}/resources/theme/css/style-default.css?1373029323" rel="stylesheet" type="text/css" />
	<!-- FireBug Lite -->
	<!-- <script src="https://getfirebug.com/firebug-lite-debug.js"></script> -->
	<!-- LESS.js Library -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/less.min.js"></script>
</head>
<body class="login ">
	<!-- Wrapper -->
<div id="login">
	<div class="wrapper signup">
			<h1 class="glyphicons lock">MDEForge <i></i></h1>
			<!-- Box -->
			<div class="widget widget-heading-simple">
				
				<div class="widget-head">
					<h3 class="heading">Create Account</h3>
					<div class="pull-right">
						Already a member?
						<a href="${pageContext.request.contextPath}/login" class="btn btn-inverse btn-mini">Sign in</a>
					</div>
				</div>
				<div class="widget-body">
		
					<!-- Form -->
					<form class="form-horizontal" modelAttribute="user" 
						action="${pageContext.request.contextPath}/signin" role="form" method="POST">
					<!-- Row -->
					<div class="row-fluid row-merge">
					
						<!-- Column -->
						<div class="span6">
							<div class="innerR">
								<label class="strong">Username</label>
								<input type="text" name="username" class="input-block-level" placeholder="Your Username"/>
								<label class="strong">Password</label>
								<input type="password" name="password" class="input-block-level" placeholder="Your Password"/>
								<label class="strong">Confirm Password</label>
								<input type="password" class="input-block-level" placeholder="Confirm Password"/>
								<label class="strong">Firstname</label>
								<input type="text" name="firstname" class="input-block-level" placeholder="Your Firstname"/>
							</div>
						</div>
						<!-- // Column END -->
						
						<!-- Column -->
						<div class="span6">
							<div class="innerL">
								<label class="strong">Lastname</label>
								<input type="text" name="lastname" class="input-block-level" placeholder="Your Lastname"/>
								<label class="strong">Email</label>
								<input type="text" name="email" class="input-block-level" placeholder="Your Email Address"/>
								<label class="strong">Confirm Email</label>
								<input type="text" class="input-block-level" placeholder="Confirm Your Email Address"/>
								<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Upload</button>
							</div>
						</div>
						<!-- // Column END -->
						
					</div>
					<!-- // Row END -->
					
					</form>
					<!-- // Form END -->
		
		
				</div>
				<!-- // Box END -->
				
			</div>
			
	</div>
	
</div>
<!-- // Wrapper END -->	

<!-- Themer -->
<div id="themer" class="collapse">
	<div class="wrapper">
		<span class="close2">&times; close</span>
		<h4>Themer <span>color options</span></h4>
		<ul>
			<li>Theme: <select id="themer-theme" class="pull-right"></select><div class="clearfix"></div></li>
			<li>Primary Color: <input type="text" data-type="minicolors" data-default="#ffffff" data-slider="hue" data-textfield="false" data-position="left" id="themer-primary-cp" /><div class="clearfix"></div></li>
			<li>
				<span class="link" id="themer-custom-reset">reset theme</span>
				<span class="pull-right"><label>advanced <input type="checkbox" value="1" id="themer-advanced-toggle" /></label></span>
			</li>
		</ul>
		<div id="themer-getcode" class="hide">
			<hr class="separator" />
			<button class="btn btn-primary btn-small pull-right btn-icon glyphicons download" id="themer-getcode-less"><i></i>Get LESS</button>
			<button class="btn btn-inverse btn-small pull-right btn-icon glyphicons download" id="themer-getcode-css"><i></i>Get CSS</button>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- // Themer END -->

	
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
	<!-- Common Demo Script -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/demo/common.js?1373029323"></script>
	<!-- Holder Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/holder/holder.js"></script>
	<script>
		Holder.add_theme("dark", {background:"#000", foreground:"#aaa", size:9});
		Holder.add_theme("white", {background:"#fff", foreground:"#c9c9c9", size:9});
	</script>
	<!-- Uniform Forms Plugin -->
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/pixelmatrix-uniform/jquery.uniform.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/signup.js"></script>
</body>
</html>