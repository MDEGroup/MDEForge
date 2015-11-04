<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<div class="navbar main hidden-print">
			
			<div class="secondary">
				<div class="container-960">
				
					<!-- Brand -->
					<a href="${pageContext.request.contextPath}/" class="appbrand pull-left"><spring:message code="mdeforge" /></a>
					
					<!-- TOP Menu START -->
					<ul class="topnav pull-right">												
												
						<%-- <li class="hidden-phone"><a href="${pageContext.request.contextPath}/public/help.htm" class="glyphicons shield"><i></i><spring:message code="public.menu.help" /></a></li> --%>
						<%-- <li class="hidden-phone"><a href="#" class="glyphicons shield"><i></i><spring:message code="public.menu.info" /></a></li> --%>
						
						<security:authorize access="isAnonymous()">
						<li class="glyphs hidden-phone">
							<ul>
								<li><a href="${pageContext.request.contextPath}/login" class="glyphicons unlock"><i></i><spring:message code="public.menu.login" /></a></li>
								<li><a href="#" class="glyphicons user_add"><i></i><spring:message code="public.menu.register" /> (Not available for now)</a></li>
							</ul>
						</li>
						</security:authorize>	
						
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
			
			<ul class="topnav pull-right border-none hidden-tablet">
				<security:authorize access="isAuthenticated()">		
						<!-- Profile / Logout menu -->
						<li class="account dropdown dd-1">
							<a data-toggle="dropdown" href="#" class="glyphicons logout lock">
							<span class="hidden-tablet hidden-phone hidden-desktop-1">  
							<security:authentication property="principal.user.username"/></span><i></i></a>
							<ul class="dropdown-menu pull-right">
								<li><a href="#" class="glyphicons cogwheel">Settings<i></i></a></li>	
								<li><a href="${pageContext.request.contextPath}/private/dashboard"
												class="glyphicons edit" data-toggle="tooltip" data-title="Private Area" data-placement="bottom" data-original-title="" title="">Dashboard</a></li>					
								<li class="profile">
									<span>
										<span class="heading">Profile <a href="#" class="pull-right">edit</a></span>
										<span class="img"></span>
										<span class="details">
											<a href="#"><security:authentication property="principal.user.firstname"/> 
											<security:authentication property="principal.user.lastname"/></a>
											<security:authentication property="principal.user.email"/>
											
										</span>
										<span class="clearfix"></span>
									</span>
								</li>
								<li>
									<span>
										<a class="btn btn-default btn-mini pull-right" href="${pageContext.request.contextPath}/j_spring_security_logout"><spring:message code="common.logout"/></a>
									</span>
								</li>
							</ul>
						</li>
						</security:authorize>			
					
			</ul>
			<div class="clearfix"></div>
			<!-- // Top Menu Right END -->
				
			</div>
			
		</div>