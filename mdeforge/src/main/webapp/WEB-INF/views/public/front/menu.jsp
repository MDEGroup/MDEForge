<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="navbar main hidden-print">
			
			<div class="secondary">
				<div class="container-960">
				
					<!-- Brand -->
					<a href="${pageContext.request.contextPath}/" class="appbrand pull-left"><spring:message code="mdeforge" /></a>
					
					<!-- TOP Menu START -->
					<ul class="topnav pull-right">												
												
						<%-- <li class="hidden-phone"><a href="${pageContext.request.contextPath}/public/help.htm" class="glyphicons shield"><i></i><spring:message code="public.menu.help" /></a></li> --%>
						<%-- <li class="hidden-phone"><a href="#" class="glyphicons shield"><i></i><spring:message code="public.menu.info" /></a></li> --%>
						<li class="glyphs hidden-phone">
							<ul>
								<li><a href="#" class="glyphicons unlock"><i></i><spring:message code="public.menu.login" /></a></li>
								<%-- <li><a href="${pageContext.request.contextPath}/public/register_start.htm" class="glyphicons user_add"><i></i><spring:message code="public.menu.register" /></a></li> --%>
								<li><a href="#" class="glyphicons user_add"><i></i><spring:message code="public.menu.register" /> (Not available for now)</a></li>
							</ul>
						</li>
					</ul>					
					<!-- TOP Menu END -->
					
					<div class="clearfix"></div>
					
				</div>
			</div>
			
			<div class="container-960">
			
			<!-- Menu Toggle Button -->
			<button type="button" class="btn btn-navbar visible-phone">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!-- // Menu Toggle Button END -->
			
			<ul class="topnav pull-left">
				
				<li class="active"><a href="${pageContext.request.contextPath}/" class="glyphicons home"><i></i><spring:message code="common.home" /></a></li>
				<%-- <li><a href="${pageContext.request.contextPath}/public/about.htm" class="glyphicons circle_info"><i></i><spring:message code="public.menu.about" /></a></li> --%>												
				<li><a href="${pageContext.request.contextPath}/public/about" class="glyphicons circle_info"><i></i><spring:message code="public.menu.about" /></a></li>
				
			</ul>
			
			<!-- Top Menu Right -->
			<%-- <ul class="topnav pull-right border-none hidden-tablet">
				
				<li class="search open margin-none border-none box-shadow-none">
					<form autocomplete="off" class="dropdown dd-1">
						<input type="text" value="" placeholder="<spring:message code="public.menu.search" />" data-toggle="typeahead" />
						<button type="button" class="glyphicons search"><i></i></button>
					</form>
				</li>
				
			</ul> --%>
			<div class="clearfix"></div>
			<!-- // Top Menu Right END -->
			
			</div>
			
		</div>