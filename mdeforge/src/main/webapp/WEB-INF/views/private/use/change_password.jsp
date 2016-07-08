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
					<form method="post" action="${pageContext.request.contextPath}/private/change_password">
						<label>Old password</label>
						<input type="password" name="password_old" id="password_old"" class="input-block-level" placeholder="Your Password" />
						<label>New password</label>
						<input type="password" name="password_new" id="password_new" class="input-block-level" placeholder="Your Password" />
						<label>Retype password</label>
						<input type="password" name="password_new_r" id="password_new_r" class="input-block-level" placeholder="Your Password" />
						<div class="row-fluid">
						<div class="span12 center">
								<button class="btn btn-block btn-large btn-primary" type="submit">Change password</button>
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
								<h4>New to <span class="text-black">MDE Forge?</span> <a href="${pageContext.request.contextPath}/signin" class="text-primary">Create an account</a></h4>
							</div>
						</div>
							
				</div>
			</div>
			<!-- // Box END -->
			
		</div>
		
	</div>
	
</div>