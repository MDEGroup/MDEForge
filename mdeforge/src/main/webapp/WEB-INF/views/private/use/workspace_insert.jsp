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

<div class="innerLR">
<div class="box-generic">
<h3 class="header-h main-title">Create Workspace</h3>
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p> -->
</div>
	<form:form class="form-horizontal margin-none"
		modelAttribute="workspace" id="validateSubmitForm" method="post"
		action="${pageContext.request.contextPath}/private/workspace/create"
		autocomplete="off">
		<div class="widget widget-heading-simple">
				<div class="row-fluid">
					<div class="span6">
					<div class="box-generic">
						<h5 class="input-name">Name</h5>
								<form:input path="name" id="name" name="name"
									type="text" placeholder=""></form:input>
								<p id="nameValidator"  class="text-error" style="display: none;">Mandatory field</p>
						<h5 class="input-name">Description</h5>
								<form:textarea path="description" id="description"
									name="description" type="text"></form:textarea>
								<p id="descriptionValidator" style="display: none;">Mandatory field</p>
					</div>
					</div>
					<div class="span6">
						<div class="box-generic">
						<h5 class="input-name">Select Projects</h5>
							<form:select path="projects" multiple="true" style="height: 215px">
								<form:options items="${projectList}" itemValue="id"
									itemLabel="name" ></form:options>
							</form:select>
						</div>
					</div>
				</div>
				<div class="box-generic">
				<div class="form-actions">
					<button type="submit"
						class="btn btn-primary btn-large">
						<i class="icon-save"></i> Save
					</button>
					<button type="button"
						class="btn btn-default btn-large">
						Cancel
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