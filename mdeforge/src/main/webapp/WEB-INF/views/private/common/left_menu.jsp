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
				<li><a class="glyphicons dashboard" href="${pageContext.request.contextPath}/private/use/"><i></i>Dashboard</a></li>				
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