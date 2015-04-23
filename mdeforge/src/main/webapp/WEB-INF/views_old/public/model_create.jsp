<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		var del = "${requestScope.delete}";
		if (del == "true") {
			$(":input[type='text']").each(function() {
				$(this).attr('disabled', 'disabled');
			});
		}

	});
</script>


<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Default Workspace</a></li>
			<li><a href="#">Models</a></li>
			<li><a href="#">Model</a></li>
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3>
			<c:if test="${requestScope.create}"><spring:message code="mdeforge.model.create.uppercase"/></c:if>
			<c:if test="${requestScope.update}"><spring:message code="mdeforge.model.update.uppercase"/></c:if>
			<c:if test="${requestScope.delete}"><spring:message code="mdeforge.model.delete.uppercase"/></c:if>
		</h3>
	</div>
	<div class="col-xs-2 col-sm-1 col-sm-offset-1">
		<div id="social" class="row">
			<a href="#"><i class="fa fa-google-plus"></i></a>
			<a href="#"><i class="fa fa-facebook"></i></a>
			<a href="#"><i class="fa fa-twitter"></i></a>
			<a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-youtube"></i></a>
		</div>
	</div>
	<div class="clearfix visible-xs"></div>
	<div class="col-xs-12 col-sm-8 col-md-7 pull-right">
		<div class="row">
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-1"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>756.45M
					<span class="txt-primary">EBITDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-2"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>245.12M
					<span class="txt-info">OIBDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-3"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>107.83M
					<span>REVENUE</span>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-xs-6 col-md-6">
	<div class="box">
		<div class="box-content">
			<form:form cssClass="form-horizontal" modelAttribute="model" action="${pageContext.request.contextPath}${requestScope.action}" role="form" method="POST" enctype="multipart/form-data">
				<form:hidden path="id" />
				<div class="form-group">
					<label class="col-sm-3 control-label"><spring:message code="mdeforge.model.name"/>:</label>
					<div class="col-sm-9">
						<form:input path="name" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label"><spring:message code="mdeforge.model.description"/>:</label>
					<div class="col-sm-9">
						<form:input path="description" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label"><spring:message code="mdeforge.model.uri"/>:</label>
					<div class="col-sm-9">
						<form:input path="uri" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label"><spring:message code="mdeforge.model"/>:</label>
					<div class="col-sm-9">
						<input type="file" name="modelfile" size="40">
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="form-group">
					<div class="text-center">
						<button type="submit" class="btn btn-primary btn-label-left">
							<c:choose>
								<c:when test="${requestScope.update}">
      								<spring:message code="common.action.update"/>
      							</c:when>
      							<c:when test="${requestScope.delete}">
      								<spring:message code="common.action.delete"/>
      							</c:when>
								<c:otherwise>
		      						<spring:message code="common.action.create"/>
		      					</c:otherwise>
							</c:choose>
						</button>
						<a href="${pageContext.request.contextPath}/defaultworkspace/model/list"><button type="button" class="btn btn-warning "><spring:message code="common.action.cancel"/></button></a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>