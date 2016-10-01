<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/css/fileupload.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" rel="stylesheet" />
<div id="login">

	<div class="container login">
	 
		<div class="wrapper" style="max-width: none">
		<img class="logo-banner" width="100px" style="margin-top: 10%" src="${pageContext.request.contextPath}/resources/theme/images/logo-small.png">
			<h3 class="header-h main-title text-black center">Sign Up to MDE Forge</h3>
			<h4 class="center">Already a member? <a href="${pageContext.request.contextPath}/login" class="text-primary">Sign In</a></h4>
			<div class="separator"></div>
			<h2 class="header-h main-text center"></h2>
			<!-- Box -->
			<div class="widget widget-heading-simple widget-body-simple">
				
				<div class="widget-body" style="background: #fff">
				
					<!-- Form -->
					<form id="signin-form" method="post" action="${pageContext.request.contextPath}/signin" enctype="multipart/form-data">
						<div class="row-fluid">
						<div class="span12 center">
						<label>Upload Your Picture</label>
						<div class="separator bottom"></div>
						<div class="box__input">
							<label for="artifactName" id="label-img"><img id="img-signin" class="img-center" src="${pageContext.request.contextPath}/resources/theme/images/blankuser.jpg"></label>
							<input type="file" id="artifactName" style="display: none;" class="margin-none" name="photo" size="40">
							
						</div>
						
						<div class="separator"></div> 
						<label>Username</label>
						<input id="username-input" type="text" name="username" class="input-block-level center" autocomplete="off" placeholder="Your Username"/>
						<div class="separator"></div> 
						</div>
						</div>
						<div class="row-fluid center">
						<div class="span6">
						<label>Firstname</label>
						<input type="text" name="firstname" class="input-block-level" autocomplete="false" placeholder="Your Firstname"/>
						<label>Email</label>
						<input type="email" name="email" class="input-block-level" autocomplete="new-password" placeholder="Your Email Address"/>
						<label>Password</label>
						<input type="password" name="password" class="input-block-level" autocomplete="new-password" placeholder="Your Password" />
						</div>
						<div class="span6">
						<label>Lastname</label>
						<input type="text" name="lastname" class="input-block-level" autocomplete="false" placeholder="Your Lastname"/>
						<label>Confirm Email</label>
						<input type="text" name="email_confirmation" class="input-block-level" autocomplete="false" placeholder="Confirm Your Email Address"/>
						<label>Repeat Password</label>
						<input type="password" name="password_confirmation" class="input-block-level" autocomplete="new-password" placeholder="Repeat Your Password" />
						</div>
						</div>
						
						
						
						
						
						
			
						<div class="separator"></div> 
						<label class="center" >Resolve Captcha</label>
						<div class="row-fluid">
							<c:if test="${not empty captcha}">
    							Wrong captcha code
							</c:if>
							<%
								ReCaptcha c = ReCaptchaFactory.newReCaptcha(
										"6LcaZBoTAAAAAFUsZE3TRO4OO-vnzanm69wbD-rx",
										"6LcaZBoTAAAAAORXKj6dB9GrBgsAQw2jBotbNfoY", false);
								out.print(c.createRecaptchaHtml(null, null));
							%>
						</div>
						<div class="separator"></div> 
						<div class="separator"></div> 
						<div class="row-fluid">
						<div class="span12 center">
								<button class="btn btn-block btn-large btn-primary my-button" type="submit">Sign Up</button>
							</div>
						</div>
					 	
					</form>
					<!-- // Form END -->
							
				</div>
			</div>
			<!-- // Box END -->
			<hr style="margin: 25px 0">
			<!-- Box -->
			<div class="widget widget-heading-simple widget-body-simple">
				
				<div class="widget-body" style="background: #fff">
				
						<div class="row-fluid">
							<div class="span12 center">
								<h4>Already a member? <a href="${pageContext.request.contextPath}/login" class="text-primary">Sign In</a></h4>
							</div>
						</div>
							
				</div>
			</div>
			<!-- // Box END -->
			
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/bootstrap/extend/jasny-fileupload/js/bootstrap-fileupload.js"></script>