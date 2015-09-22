<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/responsive.css"
	rel="stylesheet" type="text/css" />
<!-- Glyphicons Font Icons -->
<link
	href="${pageContext.request.contextPath}/resources/theme/fonts/glyphicons/css/glyphicons.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme/fonts/font-awesome/css/font-awesome.min.css">
<!--[if IE 7]><link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/fonts/font-awesome/css/font-awesome-ie7.min.css"><![endif]-->

<!-- Uniform Pretty Checkboxes -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/pixelmatrix-uniform/css/uniform.default.css"
	rel="stylesheet" />

<!-- PrettyPhoto -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/gallery/prettyphoto/css/prettyPhoto.css"
	rel="stylesheet" />

<!-- JQuery -->
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/html5shiv.js"></script>
    <![endif]-->

<!-- Bootstrap Extended -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/css/fileupload.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css"
	rel="stylesheet" />

<!-- DateTimePicker Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/bootstrap-datetimepicker/css/datetimepicker.css"
	rel="stylesheet" />

<!-- JQueryUI -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/jquery-ui/css/smoothness/jquery-ui-1.9.2.custom.min.css"
	rel="stylesheet" />

<!-- MiniColors ColorPicker Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/color/jquery-miniColors/jquery.miniColors.css"
	rel="stylesheet" />

<!-- Notyfy Notifications Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/notifications/notyfy/jquery.notyfy.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/notifications/notyfy/themes/default.css"
	rel="stylesheet" />

<!-- Gritter Notifications Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/notifications/Gritter/css/jquery.gritter.css"
	rel="stylesheet" />

<!-- Easy-pie Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/charts/easy-pie/jquery.easy-pie-chart.css"
	rel="stylesheet" />

<!-- Google Code Prettify Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/google-code-prettify/prettify.css"
	rel="stylesheet" />

<!-- Select2 Plugin -->
<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/select2/select2.css"
	rel="stylesheet" />

<!-- Pageguide Guided Tour Plugin -->
<!--[if gt IE 8]><!-->
<link media="screen"
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/other/pageguide/css/pageguide.css"
	rel="stylesheet" />
<!--<![endif]-->

<!-- Main Theme Stylesheet :: CSS -->
<link
	href="${pageContext.request.contextPath}/resources/theme/css/style-default.css?1373029313"
	rel="stylesheet" type="text/css" />


<!-- FireBug Lite -->
<!-- <script src="https://getfirebug.com/firebug-lite-debug.js"></script> -->

<!-- LESS.js Library -->
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/system/less.min.js"></script>


<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse.list" /></li>
</ul>
<!-- Breadcrumb END -->


<h3>
	${workspace.getName() }
</h3>
<div class="innerLR">
	
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-white widget-employees">
			
		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading glyphicons user"><i></i>Manage Workspace</h4>
		</div>
		<!-- // Widget Heading END -->
		
		<div class="widget-body padding-none">
			
			<div class="row-fluid row-merge">
				<div class="span4 listWrapper">
					<span class="results">${workspace.getProjects().size() } Project <i class="icon-circle-arrow-down"></i></span>
					<ul class="list unstyled">
						<c:forEach items="${workspace.projects}" var="proj">
									<li id="${proj.getId() }">
								
								<div class="media innerAll">
									<div class="media-object pull-left thumb"><img data-src="holder.js/51x51/dark" alt="Image" /></div>
									<div class="media-body">
										<span class="strong">${proj.getName()}</span>
										<span class="muted">Owner:</span>
										<span class="muted">${proj.getOwner().getUsername() }
											<a href="mailto:${proj.getOwner().getEmail() }"><i class="icon-envelope"></i></a>
										</span>
									</div>
								</div>
							</li>
						</c:forEach>	
					</ul>
				</div>
				<div class="span8 detailsWrapper" id="details">
					<div class="ajax-loading hide">
						<i class="icon-spinner icon-spin icon-4x"></i>
					</div>
					<div class="innerAll">
						<div class="title">
							<div class="row-fluid">
								<div class="span8">
									<h3 class="text-primary" id="projectName">Adrian Demian</h3>
								</div>
								<div class="span4 text-right">
									<p class="muted" id="artifactsNumber">4 projects</p>
								</div>
							</div>
						</div>
						<hr/>
						<div class="body">
							<div class="row-fluid">
								<div class="span4">
									<h5 class="strong">Ecore Metamodels</h5>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
									
									
								</div>
								<div class="span4">
									<h5 class="strong">Transformations</h5>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
									
									
								</div>
								<div class="span4">
									<h5 class="strong">Models</h5>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
									
									
								</div>
								<div class="span4"></div>
								<div class="span8">
									<h5 class="text-uppercase strong text-primary"><i class="icon-group text-regular icon-fixed-width"></i> Shared with <span class="text-lowercase padding-none" id="sharedNumber">(2 people)</span></h5>
									<ul class="team" id="users">
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<!-- // Widget END -->



