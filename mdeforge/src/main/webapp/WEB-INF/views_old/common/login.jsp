<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
	<div class="text-right">
		<a href="${pageContext.request.contextPath}/registration" class="txt-default"><spring:message code="common.signup"/></a>
	</div>
	<div class="box">
		<div class="box-content">
			<div class="text-center">
				<h3 class="page-header">MDEForge</h3>
			</div>
			<form name="loginform" action="${pageContext.request.contextPath}/j_spring_security_check" method="post" role="form">
				<div class="form-group">
					<label class="control-label"><spring:message code="common.user.username"/></label> <input type="text" class="form-control" name="j_username" />
				</div>
				<div class="form-group">
					<label class="control-label"><spring:message code="common.user.password"/></label> <input type="password" class="form-control" name="j_password" />
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary"><spring:message code="common.signin"/></button> 
				</div>
			</form>
		</div>
	</div>
</div>