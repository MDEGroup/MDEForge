<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<div class="navbar main">
			
			<!-- Menu Toggle Button -->
			<button type="button" class="btn btn-navbar pull-left">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!-- // Menu Toggle Button END -->
			
							
			<ul class="topnav pull-right">
			<!-- Profile / Logout menu -->
				<li class="">
					<a href="${pageContext.request.contextPath}"><span class="hidden-tablet hidden-phone">MDE Forge Home</span></a>
				</li>
				<security:authorize access="isAnonymous()">
				<li class="">
					<a href="${pageContext.request.contextPath}/login"><span class="hidden-tablet hidden-phone">Login</span></a>
				</li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">	
				<li class="account dropdown dd-1">
					
					<a data-toggle="dropdown" href="#" class="logout">
					<span class="hidden-tablet hidden-phone"><security:authentication property="principal.user.username"/></span>
					</a>
					<ul class="dropdown-menu pull-right">				
								
						<li class="profile">
							<span>
								<img id="imagePreview" src="/public/getPhoto?id=${logged_user.image}" alt="Profile Photo"/>
								<div class="details">
									<a href="#"><security:authentication property="principal.user.firstname"/> <security:authentication property="principal.user.lastname"/></a>
									<br>
									<a href="#"><security:authentication property="principal.user.email"/></a>
									<!--<security:authentication property="principal.user.id" var="userId"/>-->
									<input type="hidden" value="${userId}" id="loggedUserId">
								</div>
								<span class="clearfix"></span>
							</span>
						</li>
						<li><a href="${pageContext.request.contextPath}/private/dashboard" class="menu-right-dropdown pull-right">Dashboard</a></li>		
						<!-- <li><a href="${pageContext.request.contextPath}/private/change_password" class="menu-right-dropdown pull-right">Change password</a></li>-->		
						<li><a href="${pageContext.request.contextPath}/private/update_account" class="menu-right-dropdown pull-right">Account</a></li>		
						<li><a href="${pageContext.request.contextPath}" class="menu-right-dropdown pull-right">MDE Forge Home</a></li>
						<hr>
						<li>
								<a id="logout" class="btn btn-default pull-right" href="${pageContext.request.contextPath}/j_spring_security_logout"><spring:message code="common.logout"/></a>
						</li>
					</ul>
				</li>
				</security:authorize>
									
				
			</ul> 
			
			<ul class="topnav pull-left">
					<%-- <li><a href="${pageContext.request.contextPath}/public/search" class="glyphicons search"><i></i> Search</a></li>	 --%>
					
					<li class="glyphs hidden-tablet hidden-phone">
					<ul>
						<!-- <li><a href="${pageContext.request.contextPath}/public/dashboard" class="glyphicons folder_open" data-toggle="tooltip" data-title="Browse the repository" data-placement="bottom" data-original-title="" title=""><i></i></a></li>-->
						<li><a href="${pageContext.request.contextPath}/public/search" class="glyphicons search" data-toggle="tooltip" data-title="Search Artifacts" data-placement="bottom" data-original-title="" title=""><i></i></a></li>
					</ul>
				</li>
				<li class="search open">
					<form action="${pageContext.request.contextPath}/public/search" method="get" class="dropdown dd-1">
						<input type="text" value="" placeholder="Search Artifacts.." name="search_string" data-toggle="typeahead" />
						<button type="button" class="glyphicons search"><i></i></button>
					</form>
				</li> 
				
			</ul>
						
						<!-- Top Menu Right -->
			 <ul class="topnav pull-right hidden-phone hidden-tablet hidden-desktop-1">								
			<%--					
				<!-- Language menu -->
				<li class="hidden-tablet hidden-phone hidden-desktop-1 dropdown dd-1 dd-flags" id="lang_nav">
					<a href="#" data-toggle="dropdown"><img src="${pageContext.request.contextPath}/resources/theme/images/lang/it.png" alt="en" /></a>
			    	<ul class="dropdown-menu pull-left">
			      		<li class="active"><a href="#" title="English"><img src="${pageContext.request.contextPath}/resources/theme/images/lang/en.png" alt="English"> English</a></li>
			      		<li><a href="#" title="Romanian"><img src="${pageContext.request.contextPath}/resources/theme/images/lang/ro.png" alt="Romanian"> Romanian</a></li>
			      		<li><a href="#" title="Italian"><img src="${pageContext.request.contextPath}/resources/theme/images/lang/en.png" alt="Italian"> Italian</a></li>
			      		<li><a href="#" title="French"><img src="${pageContext.request.contextPath}/resources/theme/images/lang/fr.png" alt="French"> French</a></li>
			      		<li><a href="#" title="Polish"><img src="${pageContext.request.contextPath}/resources/theme/images/lang/pl.png" alt="Polish"> Polish</a></li>
			    	</ul>
				</li>
				<!-- // Language menu END -->
				
				<security:authorize access="hasRole('admin')">
				<li><a href="${pageContext.request.contextPath}/admin/admin_dashboard.htm" class="glyphicons settings"><i></i> Admin</a></li>
				</security:authorize>
			
				<!-- Profile / Logout menu -->
				<li class="account dropdown dd-1">
										<a data-toggle="dropdown" href="#" class="glyphicons logout lock"><span class="hidden-tablet hidden-phone hidden-desktop-1"> MyName</span><i></i></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="#" class="glyphicons cogwheel">Settings<i></i></a></li>
						<li><a href="#" class="glyphicons camera">My Photos<i></i></a></li>
						<li class="profile">
							<span>
								<span class="heading">Profile <a href="#" class="pull-right">edit</a></span>
								<span class="img"></span>
								<span class="details">
									<a href="#">Mosaic Pro</a>
									contact@mosaicpro.biz
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
				<!-- // Profile / Logout menu END -->
				--%>
			</ul> 
			<!-- // Top Menu Right END -->
						<div class="clearfix"></div>
			
		</div>