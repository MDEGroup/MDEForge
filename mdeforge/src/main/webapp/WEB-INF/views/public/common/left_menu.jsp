<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="menu" class="hidden-phone hidden-print">
		
			<!-- Brand -->
			<a href="${pageContext.request.contextPath}/" class="appbrand"><spring:message code="mdeforge"/></a>
		
			<!-- Scrollable menu wrapper with Maximum height -->
			<div class="slim-scroll" data-scroll-height="800px">
			
			<!-- Sidebar Profile -->
			<span class="profile center">
				<a href="#"><img data-src="holder.js/36x36/white" alt="Avatar" /></a>
			</span>
			<!-- // Sidebar Profile END -->
			
			<!-- Regular Size Menu -->
			<ul>
			
												
								<!-- Blank page template menu example -->
				<!-- Menu Regular Item (add class active to LI for an active menu item) -->
				
				<li class="active dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons file"><i></i><spring:message code="mdeforge.menu.metamodels"/> <span class="icon-chevron-right"></span></a>
					<ul class="dropdown-menu pull-left">											
						<li><a href="${pageContext.request.contextPath}/public/browse/metamodels_list" class="glyphicons list"><i></i><spring:message code="mdeforge.public.back.browse.menu.list"/></a></li>
						<li><a href="${pageContext.request.contextPath}/public/browse/cluster" class="glyphicons vector_path_polygon"><i></i><spring:message code="mdeforge.public.back.browse.menu.cluster"/></a></li>
					</ul>
				</li>
				<li><a class="glyphicons random" href=""><i></i><spring:message code="mdeforge.menu.transformations"/></a></li>
				<li><a class="glyphicons notes" href=""><i></i><spring:message code="mdeforge.menu.models"/></a></li>				
				<!-- // Blank page template menu example END -->
												
				
				
			</ul>
			<div class="clearfix"></div>
			<!-- // Regular Size Menu END -->
			
						<div class="alert alert-primary">
				<a class="close" data-dismiss="alert">&times;</a>
				<p>Integer quis tempor mi. Donec venenatis dui in neque fringilla at iaculis libero ullamcorper. In velit sem, sodales id hendrerit ac, fringilla et est.</p>
			</div>
						
			</div>
			<!-- // Scrollable Menu wrapper with Maximum Height END -->
			
		</div>