<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse"/></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse.dashboard"/></li>
</ul>
<!-- Breadcrumb END -->



<h3><spring:message code="mdeforge.public.back.browse.dashboard"/></h3>


<div class="innerLR">
	
	<h3>Similarity</h3>
	${similarity}
	<h3>Containment</h3>
	${containment}
	<h3>Cosine distance</h3>
	${cosine}
	<h3>Dice distance</h3>
	${dice}
	
</div>	
	