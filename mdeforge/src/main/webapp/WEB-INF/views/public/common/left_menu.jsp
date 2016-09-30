	
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
				<li><a class="glyphicons folder_open" href="${pageContext.request.contextPath}/public/dashboard"><i></i>Browse</a></li>
				<li class="dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons share_alt"><i></i><spring:message code="mdeforge.menu.metamodels"/> <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<li><a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifacts" class="glyphicons list"><i></i><spring:message code="mdeforge.public.back.browse.menu.list"/></a></li>
						<li><a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster" class="glyphicons vector_path_polygon"><i></i><spring:message code="mdeforge.public.back.browse.menu.cluster"/></a></li>						
					</ul>
				</li>
				<li><a class="glyphicons random" href="${pageContext.request.contextPath}/public/ATLTransformation/artifacts" style="font-size: 14px"><i></i><spring:message code="mdeforge.menu.transformations"/></a></li>
				<li><a class="glyphicons file" href="${pageContext.request.contextPath}/public/Model/artifacts"><i></i><spring:message code="mdeforge.menu.models"/></a></li>
				<li><a class="glyphicons inbox" href="${pageContext.request.contextPath}/public/projects"><i></i><spring:message code="mdeforge.menu.projects"/></a></li>
				
			</ul>
			<div class="clearfix"></div>
			<!-- // Regular Size Menu END -->
			
						
						
			</div><div class="slimScrollBar ui-draggable" style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 1025px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div></div>
			<!-- // Scrollable Menu wrapper with Maximum Height END -->
			
</div>