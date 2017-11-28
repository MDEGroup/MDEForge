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


	<div class="container ">
	 
		<div class="wrapper">
		<img class="logo-banner" width="100px" style="margin-top: 1%" src="${pageContext.request.contextPath}/resources/theme/images/logo-small.png">
			<h3 class="header-h main-title text-black center">Sign Up to MDE Forge</h3>
			<h4 class="center">Already a member? <a href="${pageContext.request.contextPath}/login" class="text-primary">Sign In</a></h4>
			<h2 class="header-h main-text center"></h2>
			<!-- Box -->
			
			
			<div class="">
				
				<div class="" style="background: #fff">
				
					<!-- Form -->
					<form id="signin-form"  method="post" class="form-horizontal" action="${pageContext.request.contextPath}/signin" enctype="multipart/form-data">
					<div class="form-group center" >
					
						
						<label class="center">Upload Your Picture</label>
						<div class="separator bottom"></div>
						<div class="box__input">
							<label for="artifactName" id="label-img"><img id="img-signin" class="img-center" src="${pageContext.request.contextPath}/resources/theme/images/blankuser.jpg"></label>
							<input type="file" id="artifactName" style="display: none;" class="margin-none" name="photo" size="40">
							
						</div>
						<div class="separator"></div> 
						<div class="form-group">
						<label class="control-label  textAlignLeft" for="username-input">Username:</label>
						<input class="registerCustom" id="username-input" type="text" name="username" class="center form-control" autocomplete="off" placeholder="Your Username" tabindex="1"/>
						
						</div>						
											
						<div class="form-group">
						<label for="firstname" class=" control-label textAlignLeft">Firstname:</label>
						<input class="registerCustom" type="text" name="firstname" class="center form-control" autocomplete="false" placeholder="Your Firstname" tabindex="2"/>
						
						</div>
						
						<div class="form-group" >
						<label for="lastname" class=" control-label">Lastname:</label>
						<input class="registerCustom" type="text" id="lastname" name="lastname" class="center form-control" autocomplete="false" placeholder="Your Lastname" tabindex="3"/>
					
						</div>
						
						<div class="form-group">
						<label for="email" class=" control-label">Email:</label>
						<input class="registerCustom" type="email" id="email" name="email" class="center form-control" autocomplete="new-password" placeholder="Your Email Address" tabindex="4"/>
						</div>
						
						
						<div class="form-group">
						<label for="email_confirmation" class=" control-label">Confirm Email:</label>
						<input class="registerCustom" type="text" id="email_confirmation" name="email_confirmation" class="center form-control" autocomplete="false" placeholder="Confirm Your Email Address" tabindex="5"/>
						</div>
						
						<div class="form-group">
						<label for="password" class=" control-label">Password:</label>
						<input class="registerCustom" type="password" id="password" name="password" class="center form-control" autocomplete="new-password" placeholder="Your Password" tabindex="6" />
						</div>
						

						<div class="form-group">
						<label class=" control-label">Repeat Password:</label>
						<input class="registerCustom" type="password" id="password_confirmation" name="password_confirmation" class="center form-control" autocomplete="new-password" placeholder="Repeat Your Password" tabindex="7" />
						</div>
			
						<div class="separator"></div> 
						
						<div class="form-group center">
						<label>Resolve Captcha</label>
						</div>
						<div class="form-group">
						
							<c:if test="${not empty captcha}">
    							<p class="center color-red">Wrong captcha code</p>
							</c:if>
							<%
								ReCaptcha c = ReCaptchaFactory.newSecureReCaptcha(
										"6LcaZBoTAAAAAFUsZE3TRO4OO-vnzanm69wbD-rx",
										"6LcaZBoTAAAAAORXKj6dB9GrBgsAQw2jBotbNfoY", false);
								out.print(c.createRecaptchaHtml(null, null));
							%>
						
						
						</div>
						<div class="separator"></div> 
						<div class="separator"></div> 
						<div class="form-group">
						
						<button class="btn btn-block btn-large btn-primary " type="submit">Sign Up</button>
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