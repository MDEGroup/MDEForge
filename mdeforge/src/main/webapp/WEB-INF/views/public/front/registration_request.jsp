<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Breadcrumb START -->
<!-- <ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full" class="glyphicons dashboard"><i></i> Private area</a></li>
		<li class="divider"></li>
		<li>Public</li>
		<li class="divider"></li>
		<li>Registration request</li>
</ul> -->
<!-- Breadcrumb END -->


<div class="container">
	<div class="wrapper container max-width-420">
		<img class="logo-banner" width="100px"
			src="${pageContext.request.contextPath}/resources/theme/images/logo-small.png">
		<h3 class="header-h main-title text-black center">MDE Forge</h3>
		<div class="separator"></div>
		<div class="separator"></div>
		<div class="alert alert-info" role="alert">
			<h4 class="alert-heading text-center"><strong>Well done!</strong></h4>
			<hr class="message-inner-separator">
			<p class="text-center">An email will be forwarded to you in order to activate your account!</p>
		</div>
		<div class="separator"></div>
		<div class="separator"></div>
			<div class="center"><a href="${pageContext.request.contextPath}/private/dashboard" class="btn btn-block btn-large btn-primary">Continue</a></div>
	</div>
</div>




<!-- <h3>Registration request</h3>


<div class="innerLR">
An email will be forwarded to you in order to activate your account!
</div>	
<div class="bs-example">
    <div id="myAlert" class="alert alert-info">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Note!</strong> Please read the comments carefully.
    </div> -->

