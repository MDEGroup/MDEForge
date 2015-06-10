<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form
		action="${pageContext.request.contextPath}/public/search/result"
		method="get">
		Search: <input type="text" name="search_string" id="searchField"/>
		<button class="btn btn-block btn-success" class="amount span4">Cerca</button>
	</form>






</div>
