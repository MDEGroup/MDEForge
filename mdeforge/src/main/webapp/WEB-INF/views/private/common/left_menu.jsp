<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu" class="hidden-print">
		
			
		
			<!-- Scrollable menu wrapper with Maximum height -->
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 1025px;"><div class="slim-scroll" data-scroll-height="800px" style="overflow: hidden; width: auto; height: 1025px;">
			
			<!-- Sidebar Profile 
			<span class="profile center">
				<a href=""><img src="${pageContext.request.contextPath}/resources/theme/images/logo-small.png" style="width: 36px; height: 36px;"></a>
			</span>
			 // Sidebar Profile END -->
			
			<!-- Regular Size Menu -->
			<ul>
			
								
				<!-- Not blank page -->
								
				<!-- Quick Sidebar Style -->
								<!-- // Quick Sidebar Style END -->
				
				<!-- Full Sidebar Style -->
				<li><a href="${pageContext.request.contextPath}/private/dashboard" class="glyphicons dashboard"><i></i> Dashboard</a></li>
				<li class="dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons share_alt"><i></i>Shared <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<li><a class="glyphicons file" href="${pageContext.request.contextPath}/private/shared_projects/"><i></i>PROJECTS</a></li>
						<li><a class="glyphicons file" href="${pageContext.request.contextPath}/private/shared_artifacts/"><i></i>ARTIFACTS</a></li>						
					</ul>
				</li>
				<li class="dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons list"><i></i><!--<spring:message code="mdeforge.menu.workspace"/>--> MY ARTIFACS <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<!--<c:forEach items="${workspaces_list}" var="workspace">
							<li><a href="${pageContext.request.contextPath}/private/workspace?id=${workspace.getId()}" class="glyphicons folder_open"><i></i>${workspace.getName()}</a></li>
						</c:forEach>-->
							<li><a href="${pageContext.request.contextPath}/private/my_artifacts/">ALL</a></li>
							<li><a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifacts">METAMODELS</a></li>
							<li><a href="${pageContext.request.contextPath}/private/ATLTransformation/artifacts">ATL TRANSFORMATIONS</a></li>
							<li><a href="${pageContext.request.contextPath}/private/Model/artifacts">MODELS</a></li>
					</ul>
				</li>
				<!-- <li><a class="glyphicons list" href="${pageContext.request.contextPath}/private/my_artifacts/"><i></i>My Artifacts</a></li>-->
				<%-- <li><a class="glyphicons dashboard" href="${pageContext.request.contextPath}/private/ATLTransformation/transformation_list/"><i></i>Transformations</a></li> --%>
				<li class="dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons inbox_plus"><i></i><!--<spring:message code="mdeforge.menu.workspace"/>--> WORKSPACES <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<!--<c:forEach items="${workspaces_list}" var="workspace">
							<li><a href="${pageContext.request.contextPath}/private/workspace?id=${workspace.getId()}" class="glyphicons folder_open"><i></i>${workspace.getName()}</a></li>
						</c:forEach>-->
							<li><a href="${pageContext.request.contextPath}/private/workspace/list"  class="glyphicons list"><i></i>LIST</a></li>
							<li><a href="${pageContext.request.contextPath}/private/workspace/create" class="glyphicons circle_plus"><i></i>CREATE NEW</a></li>
					</ul>
				</li>
				<li class="dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons magic"><i></i><spring:message code="mdeforge.menu.services"/> <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<li><a href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_compare" class="glyphicons list">COMPARE METAMODEL</a></li>
					</ul>
				</li>
								<!-- // Full Sidebar Style END -->
				
								<!-- // Not blank page END -->
				
			</ul>
			<div class="clearfix"></div>
			<!-- // Regular Size Menu END -->
			
						
						
			</div><div class="slimScrollBar ui-draggable" style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 1025px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div></div>
			<!-- // Scrollable Menu wrapper with Maximum Height END -->
			
		</div>