<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link
	href="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/multiselect/css/multi-select.css"
	rel="stylesheet" />
<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse.list" /></li>
</ul>
<!-- Breadcrumb END -->


<h3>
	<spring:message code="mdeforge.public.back.browse.list" />
</h3>


<div class="innerLR">

	 <form:form class="form-horizontal margin-none" modelAttribute="workspace" id="validateSubmitForm" method="post" 
	 action="${pageContext.request.contextPath}/private/workspace/create" autocomplete="off">
	 
	


		<!-- Widget -->
		<div class="widget widget-heading-simple widget-body-gray">

			<!-- Widget heading -->

			<!-- // Widget heading END -->

			<div class="widget-body">

				<!-- Row -->
				<div class="row-fluid">

					<!-- Column -->
					<div class="span6">

						<!-- Group -->
						<div class="control-group">
							<form:label path="name" class="control-label" for="name">Name</form:label>
							<div class="controls">
								<form:input path="name" class="span12" id="name" name="name" type="text"></form:input>	
							</div>
						</div>
						<!-- // Group END -->

						<!-- Group -->
						<div class="control-group">
							<form:label path="description" class="control-label" for="lastname">Description</form:label>
							<div class="controls">
								<form:input path="description" class="span12" id="description" name="description"
									type="text"></form:input>
							</div>
						</div>
						<!-- // Group END -->



					</div>
					<!-- // Column END -->

					<!-- Column -->
					<div class="span6">

						<!-- Group -->
						<!-- 						<div class="control-group"> -->
						<!-- 							<label class="control-label" for="password">Password</label> -->
						<!-- 							<div class="controls"><input class="span12" id="password" name="password" type="password"></div> -->
						<!-- 						</div> -->
						<div class="innerAll">
							<form:select path="projects" multiple="true">
								<form:options  items="${projectList}" itemValue="id" itemLabel="name"></form:options>
							</form:select>
						</div>
						<!-- // Group END -->

						<!-- Group -->
<!-- 						<div class="control-group"> -->
<!-- 							<label class="control-label" for="confirm_password">Confirm -->
<!-- 								password</label> -->
<!-- 							<div class="controls"> -->
<!-- 								<input class="span12" id="confirm_password" -->
<!-- 									name="confirm_password" type="password"> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<!-- // Group END -->



					</div>
					<!-- // Column END -->

				</div>
				<!-- // Row END -->

				

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit"
						class="btn btn-icon btn-primary glyphicons circle_ok">
						<i></i>Save
					</button>
					<button type="button"
						class="btn btn-icon btn-default glyphicons circle_remove">
						<i></i>Cancel
					</button>
				</div>
				<!-- // Form actions END -->

			</div>
		</div>
		<!-- // Widget END -->

	</form:form>
</div>
