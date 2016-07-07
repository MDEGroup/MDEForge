<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="login">

	<div class="container login">
	 
		<div class="wrapper">
		<img class="logo-banner" width="100px" src="${pageContext.request.contextPath}/resources/theme/images/logo-small.png">
			<h3 class="header-h main-title text-black center">Sign Up to MDE Forge</h3>
			
			<h2 class="header-h main-text center"></h2>
			<!-- Box -->
			<div class="widget widget-heading-simple widget-body-simple">
				
				<div class="widget-body" style="background: #fff">
				
					<!-- Form -->
					<form method="post" action="${pageContext.request.contextPath}/signin">
						<div class="row-fluid">
						<div class="span6">
						<label>Firstname</label>
						<input type="text" name="firstname" class="input-block-level" placeholder="Your Firstname"/>
						</div>
						<div class="span6">
						<label>Lastname</label>
						<input type="text" name="lastname" class="input-block-level" placeholder="Your Lastname"/>
						</div>
						</div>
						<div class="row-fluid">
						<div class="span12">
						<label>Username</label>
						<input type="text" name="username" class="input-block-level" placeholder="Your Username"/>
						</div>
						</div>
						<label>Email</label>
						<input type="email" name="email" class="input-block-level" placeholder="Your Email Address"/>
						<label>Confirm Email</label>
						<input type="email" name="email_confirmation" class="input-block-level" placeholder="Confirm Your Email Address"/>
						<p></p>
						<label>Password</label>
						<input type="password" name="password" class="input-block-level" placeholder="Your Password" />
						<label>Repeat Password</label>
						<input type="password" name="password_confirmation" class="input-block-level" placeholder="Repeat Your Password" />
						
						<div class="separator bottom"></div> 
						<label>Resolve Captcha</label>
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
						<div class="separator bottom"></div> 
						<div class="row-fluid">
						<div class="span12 center">
								<button class="btn btn-block btn-large btn-primary" type="submit">Sign Up</button>
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