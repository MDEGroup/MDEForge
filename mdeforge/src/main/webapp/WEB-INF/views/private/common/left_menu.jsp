<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu" class="hidden-phone hidden-print">
		
			<!-- Brand -->
			<a href="${pageContext.request.contextPath}/" class="appbrand"><spring:message code="mdeforge"/></a>
		
			<!-- Scrollable menu wrapper with Maximum height -->
			<div class="slim-scroll" data-scroll-height="800px">
			
			
			
			
			<!-- Regular Size Menu -->
			<ul>
				<li><a class="glyphicons share_alt" href="${pageContext.request.contextPath}/private/use/"><i></i>Shared project</a></li>
				<li><a class="glyphicons dashboard" href="${pageContext.request.contextPath}/private/use/"><i></i>Shared artifact</a></li>
<!-- 				<li> -->
<%-- 					<a href="" data-toggle="dropdown" class="glyphicons file"><i></i><spring:message code="mdeforge.menu.workspace"/> <span class="icon-chevron-right"></span></a> --%>
<!-- 					<ul class="dropdown-menu pull-left">	 -->

<!-- 					</ul> -->
<!-- 				</li> -->
				<li class="active dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons file"><i></i><spring:message code="mdeforge.menu.workspace"/> <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<c:forEach items="${workspaces_list}" var="workspace">
							<li><a href="${pageContext.request.contextPath}/private/workspace?id=${workspace.getId()}" class="glyphicons icon-folder-open"><i></i>${workspace.getName()}</a></li>
						</c:forEach>									
					</ul>
				</li>
				<li><a class="glyphicons notes not-active" href=""><i></i><spring:message code="mdeforge.menu.services"/></a></li>				
			</ul>
			
		
			
			<div class="clearfix"></div>
			<!-- // Regular Size Menu END -->
			
			<!-- <div class="alert alert-primary">
				<a class="close" data-dismiss="alert">&times;</a>
				<p>Integer quis tempor mi. Donec venenatis dui in neque fringilla at iaculis libero ullamcorper. In velit sem, sodales id hendrerit ac, fringilla et est.</p>
			</div>
					 -->	
			</div>
			<!-- // Scrollable Menu wrapper with Maximum Height END -->
			
		</div>