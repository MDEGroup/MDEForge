<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="col-xs-12 col-md-12">
	<div class="box">
		<div class="box-content">
			<h4 class="page-header">Registration</h4>
			<form:form cssClass="form-horizontal" modelAttribute="user" action="${requestScope.action}" role="form" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label"><spring:message code="common.user.username" />:</label>
					<div class="col-sm-4">
						<form:input path="username" cssClass="form-control" />
					</div>
					<label class="col-sm-2 control-label"><spring:message code="common.user.password" />:</label>
					<div class="col-sm-4">
						<form:password path="password" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><spring:message code="common.user.firstname" />:</label>
					<div class="col-sm-4">
						<form:input path="firstname" cssClass="form-control" />
					</div>
					<label class="col-sm-2 control-label"><spring:message code="common.user.lastname" />:</label>
					<div class="col-sm-4">
						<form:input path="lastname" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><spring:message code="common.user.email" />:</label>
					<div class="col-sm-6">
						<form:input path="email" cssClass="form-control" />
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="form-group">
					<div class="text-center">
						<button type="submit" class="btn btn-primary btn-label-left">
							<spring:message code="common.signup" />
						</button>
						<a href="${pageContext.request.contextPath}"><button type="button" class="btn btn-warning ">
								<spring:message code="common.action.cancel" />
							</button></a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>