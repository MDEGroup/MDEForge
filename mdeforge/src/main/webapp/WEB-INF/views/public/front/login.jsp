<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="login">

	<div class="container login">
	
		<div class="wrapper">
		
			<h1 class="glyphicons unlock">Sign in <i></i></h1>
		
			<!-- Box -->
			<div class="widget widget-heading-simple widget-body-gray">
				
				<div class="widget-body">
				
					<!-- Form -->
					<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
						<label>Username or Email</label>
						<input type="text" name="j_username" class="input-block-level" placeholder="Your Username or Email address"/> 
						<label>Password <a class="password" href="">forgot it?</a></label>
						<input type="password" name="j_password" class="input-block-level margin-none" placeholder="Your Password" />
						<div class="separator bottom"></div> 
						<div class="row-fluid">
							<div class="span8">
								<div class="uniformjs"><label class="checkbox"><input type="checkbox" value="remember-me">Remember me</label></div>
							</div>
							<div class="span4 center">
								<button class="btn btn-block btn-inverse" type="submit"><spring:message code="common.signin"/></button>
							</div>
						</div>
					</form>
					<!-- // Form END -->
							
				</div>
				<div class="widget-footer">
					<p class="glyphicons restart"><i></i>Please enter your username and password ...</p>
				</div>
			</div>
			<!-- // Box END -->
			
		</div>
		
	</div>
	
</div>