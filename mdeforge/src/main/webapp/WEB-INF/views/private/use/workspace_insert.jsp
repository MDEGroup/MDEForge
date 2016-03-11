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
	<li>Use</li>
	<li class="divider"></li>
	<li>Create Workspace</li>
</ul>
<!-- Breadcrumb END -->
<h3>Create workspace</h3>
<div class="innerLR">
	<form:form class="form-horizontal margin-none"
		modelAttribute="workspace" id="validateSubmitForm" method="post"
		action="${pageContext.request.contextPath}/private/workspace/create"
		autocomplete="off">
		<div class="widget widget-heading-simple widget-body-gray">
			<div class="widget-body">
				<div class="row-fluid">
					<div class="span6">
						<div class="control-group">
							<form:label path="name" class="control-label" for="name">Name</form:label>
							<div class="controls">
								<form:input path="name" class="span12" id="name" name="name"
									type="text"></form:input>
								<p id="nameValidator" style="display: none;">Mandatory field</p>
							</div>
						</div>
						<!-- Group -->
						<div class="control-group">
							<form:label path="description" class="control-label"
								for="lastname">Description</form:label>
							<div class="controls">
								<form:input path="description" class="span12" id="description"
									name="description" type="text"></form:input>
								<p id="descriptionValidator" style="display: none;">Mandatory field</p>
							</div>
						</div>
					</div>
					<div class="span6">
						<div class="innerAll">
							<form:select path="projects" multiple="true">
								<form:options items="${projectList}" itemValue="id"
									itemLabel="name"></form:options>
							</form:select>
						</div>
					</div>
				</div>

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

			</div>
		</div>
	</form:form>
</div>
<script>
	$("#validateSubmitForm").submit(function(event) {
		if ($("#name").val() == "" || $("#name").val == null) {
			$("#nameValidator").show();
			event.preventDefault();
		}
		if ($("#description").val() == "" || $("#description").val == null) {
			$("#descriptionValidator").show();	
			event.preventDefault();
		}
		else {
			return;
		}
	});
</script>