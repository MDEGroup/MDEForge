<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a
		href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full"
		class="glyphicons dashboard"><i></i> Private area</a></li>
	<li class="divider"></li>
	<li>Services</li>
	<li class="divider"></li>
	<li>Transformation Chain</li>
</ul>
<!-- Breadcrumb END -->


<h3>NOME</h3>


<div class="innerLR">
	<form action="${pageContext.request.contextPath}/public/search/result"
		method="get">
		Search: <input type="text" name="search_string" id="searchField" />
		<button class="btn btn-block btn-success" class="amount span4">
			<spring:message code="mdeforge.common.action.search" />
		</button>
	</form>

	<form:form cssClass="form-horizontal" modelAttribute="metamodel"
		action="${pageContext.request.contextPath}/public/search_metamodel_by_example/result"
		role="form" method="POST" enctype="multipart/form-data">
		<div class="form-group">
			<label class="col-sm-3 control-label"><spring:message
					code="mdeforge.metamodel" />:</label>
			<div class="col-sm-9">
				<input type="file" name="metamodelfile" size="40">
			</div>
		</div>
		<div class="form-group">
			<div class="text-center">
				<button type="submit" class="btn btn-primary btn-label-left">
					<spring:message code="mdeforge.common.action.search" />
				</button>
			</div>
		</div>
	</form:form>
</div>
