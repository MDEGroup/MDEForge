<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<div class="navbar main">
			
			<!-- Menu Toggle Button -->
			<button type="button" class="btn btn-navbar pull-left">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!-- // Menu Toggle Button END -->
			
						
			<ul class="topnav pull-left">
				<li><a href="${pageContext.request.contextPath}/public/browse" class="glyphicons dashboard"><i></i> Dashboard</a></li>					
				<%-- <li><a href="${pageContext.request.contextPath}/private/transformation.htm" class="glyphicons random"><i></i> Transformation Chain</a></li> 
				
					
				
				
				
				<li class="dropdown dd-1">
					<a href="" data-toggle="dropdown" class="glyphicons cloud-upload"><i></i>Upload<span class="caret"></span></a>
					<ul class="dropdown-menu pull-left">
					
					<security:authorize access="hasRole('admin')">
						<li><a href="${pageContext.request.contextPath}/private/upload.htm" class="glyphicons cloud-upload"><i></i> Generico</a></li>	
					</security:authorize>	
						
						<li><a href="${pageContext.request.contextPath}/private/metamodelInsertion.htm" class="glyphicons random"><i></i>Metamodello</a></li>						
						<li><a href="${pageContext.request.contextPath}/private/transformationInsertion.htm" class="glyphicons random"><i></i>Trasformazione</a></li>
						
					
					</ul>
				</li>
				
				<li><a href="${pageContext.request.contextPath}/private/forge.htm" class="glyphicons claw_hammer"><i></i>Forge</a></li> --%>
				
									
				
			</ul>
						
						<!-- Top Menu Right -->
			<%-- <ul class="topnav pull-right hidden-phone hidden-tablet hidden-desktop-1">								
								
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
				
			</ul> --%>
			<!-- // Top Menu Right END -->
						<div class="clearfix"></div>
			
		</div>