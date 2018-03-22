<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="login">

	<div class="container login">
	
		<div class="wrapper">
		<img class="logo-banner" width="100px" src="${pageContext.request.contextPath}/resources/theme/images/logo-small.png">
			<h3 class="header-h main-title text-black center">Sign In to MDE Forge</h3>
			
			<h2 class="header-h main-text center"></h2>
			<!-- Box -->
			<div class="widget widget-heading-simple widget-body-simple">
				
				<div class="widget-body" style="background: #fff">
				
					<!-- Form -->
					<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" class="form-horizontal">
						
						<div class="form-group">
						<label>Username or Email</label>
						<input type="text" name="j_username" class="form-control" placeholder="Your Username or Email address" tabindex="1"/>
						</div>
						
						<div class="form-group">
						<label>Password</label>
						<a class="password forgot-password" href="#" tabindex="5"><strong >Forgot your password?</strong></a>
						<input type="password" name="j_password" class="form-control" placeholder="Your Password" tabindex="2" />
						</div>
						<div class="form-group">
						<div class="uniformjs"><label class="checkbox"><input type="checkbox" value="remember-me" style="margin: 4px 10px 0 0" tabindex="3">Remember Me</label></div>
						</div>
						<div class="separator bottom"></div> 
						
						<div class="form-group">
								<button class="btn btn-block btn-large btn-primary" type="submit" tabindex="4">Sign In</button>
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
								<h4>New to <span class="text-black">MDE Forge?</span> <a href="${pageContext.request.contextPath}/signin" class="text-primary">Create an account</a></h4>
							</div>
						</div>
							
				</div>
			</div>
			<!-- // Box END -->
			
		</div>
		
	</div>
</div>