<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar-left" class="col-xs-2 col-sm-2">
	<ul class="nav main-menu">
		<%-- 		<security:authorize access="hasRole('admin')"> --%>
		<c:forEach items="${workspaces}" var="w">
			<li class="dropdown"><a href="#" class="dropdown-toggle"> <i
					class="fa fa-folder"></i> <span class="hidden-xs">${w.getName()}</span></a>
				<ul class="dropdown-menu" style="display: block;">
				<c:forEach items="${w.getProjects()}" var="p">
					<li><a
						href="${pageContext.request.contextPath}/project/${p.getId()}"
						class=""> <i class="fa fa-folder-o"></i> <span
							class="hidden-xs">${p.getName()}</span></a></li>
				</c:forEach>
 					<li><a 
						href="${pageContext.request.contextPath}/workspace/${w.getId()}/artifact"
						class=""> <i class="fa fa-archive"></i> <span
							class="hidden-xs"><spring:message
 									code="mdeforge.menu.artifacts" /></span></a></li> 
<!-- 					<li><a -->
<%-- 						href="${pageContext.request.contextPath}/defaultworkspace/model/list" --%>
<!-- 						class=""> <i class="fa fa-pencil-square-o"></i> <span -->
<%-- 							class="hidden-xs"><spring:message --%>
<%-- 									code="mdeforge.menu.models" /></span></a></li> --%>
<!-- 					<li><a -->
<%-- 						href="${pageContext.request.contextPath}/defaultworkspace/transformation/list" --%>
<!-- 						class=""> <i class="fa fa-pencil-square-o"></i> <span -->
<%-- 							class="hidden-xs"><spring:message --%>
<%-- 									code="mdeforge.menu.transformations" /></span></a></li> --%>
<!-- 					<li><a -->
<%-- 						href="${pageContext.request.contextPath}/defaultworkspace/editor/list" --%>
<!-- 						class=""> <i class="fa fa-pencil-square-o"></i> <span -->
<%-- 							class="hidden-xs"><spring:message --%>
<%-- 									code="mdeforge.menu.editors" /></span></a></li> --%>
				</ul></li>
		</c:forEach>
		<li class="dropdown"><a href="#" class="dropdown-toggle"> <i
				class="fa fa-bar-chart-o"></i> <span class="hidden-xs"><spring:message
						code="mdeforge.menu.public" /></span></a>
			<ul class="dropdown-menu" style="display: block;">
				<li><a
					href="${pageContext.request.contextPath}/public/metamodel/list"
					class=""> <i class="fa fa-pencil-square-o"></i> <span
						class="hidden-xs"><spring:message
								code="mdeforge.menu.metamodels" /></span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/public/model/list"
					class=""> <i class="fa fa-pencil-square-o"></i> <span
						class="hidden-xs"><spring:message
								code="mdeforge.menu.models" /></span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/public/transformation/list"
					class=""> <i class="fa fa-pencil-square-o"></i> <span
						class="hidden-xs"><spring:message
								code="mdeforge.menu.transformations" /></span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/public/editor/list"
					class=""> <i class="fa fa-pencil-square-o"></i> <span
						class="hidden-xs"><spring:message
								code="mdeforge.menu.editors" /></span></a></li>
			</ul></li>
	</ul>
</div>
