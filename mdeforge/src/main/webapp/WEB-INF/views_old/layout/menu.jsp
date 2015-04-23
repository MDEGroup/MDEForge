<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar-left" class="col-xs-2 col-sm-2">
	<ul class="nav main-menu">
		<%-- 		<security:authorize access="hasRole('admin')"> --%>		
		<li class="dropdown"><a href="${pageContext.request.contextPath}/private/workspace/list" class="dropdown-toggle"> <i class="fa fa-bar-chart-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.workspaces" /></span></a>
		<li class="dropdown"><a href="#" class="dropdown-toggle"> <i class="fa fa-bar-chart-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.projects" /></span></a>
		<li class="dropdown"><a href="#" class="dropdown-toggle"> <i class="fa fa-bar-chart-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.public_artifacts" /></span></a>
			<ul class="dropdown-menu" style="display: block;">
				<li><a href="${pageContext.request.contextPath}/public/metamodel/list" class=""> <i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.etl_transformations" /></span></a></li>
				<li><a href="${pageContext.request.contextPath}/public/metamodel/list" class=""> <i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.atl_transformations" /></span></a></li>
				<li><a href="${pageContext.request.contextPath}/public/metamodel/list" class=""> <i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.ecore_metamodel" /></span></a></li>
				<li><a href="${pageContext.request.contextPath}/public/metamodel/list" class=""> <i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.models" /></span></a></li>			
				<li><a href="${pageContext.request.contextPath}/public/metamodel/list" class=""> <i class="fa fa-pencil-square-o"></i> <span class="hidden-xs"><spring:message code="mdeforge.menu.all_artifacts" /></span></a></li>			
			</ul>
		</li>
	</ul>
</div>
