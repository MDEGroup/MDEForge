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

				<hr class="separator">

				<!-- Row -->
				<div class="row-fluid uniformjs">

					<!-- Column -->
					<div class="span4">
						<h4 style="margin-bottom: 10px;">Policy &amp; Newsletter</h4>
						<label class="checkbox" for="agree">
							<div class="checker" id="uniform-agree">
								<span><input type="checkbox" class="checkbox" id="agree"
									name="agree" style="opacity: 0;"></span>
							</div> Please agree to our policy
						</label> <label class="checkbox" for="newsletter">
							<div class="checker" id="uniform-newsletter">
								<span><input type="checkbox" class="checkbox"
									id="newsletter" name="newsletter" style="opacity: 0;"></span>
							</div> Receive Newsletter
						</label>
					</div>
					<!-- // Column END -->

					<!-- Column -->
					<div class="span8">
						<div id="newsletter_topics" class="gray">
							<h4>Topics</h4>
							<p>Select at least two topics you would like to receive in
								the newsletter.</p>
							<label for="topic_marketflash">
								<div class="checker" id="uniform-topic_marketflash">
									<span><input type="checkbox" id="topic_marketflash"
										value="marketflash" name="topic" disabled="disabled"
										style="opacity: 0;"></span>
								</div> Marketflash
							</label> <label for="topic_fuzz">
								<div class="checker" id="uniform-topic_fuzz">
									<span><input type="checkbox" id="topic_fuzz"
										value="fuzz" name="topic" disabled="disabled"
										style="opacity: 0;"></span>
								</div> Latest fuzz
							</label> <label for="topic_digester">
								<div class="checker" id="uniform-topic_digester">
									<span><input type="checkbox" id="topic_digester"
										value="digester" name="topic" disabled="disabled"
										style="opacity: 0;"></span>
								</div> Mailing list digester
							</label>
						</div>
					</div>
					<!-- // Column END -->

				</div>
				<!-- // Row END -->

				<hr class="separator">

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
