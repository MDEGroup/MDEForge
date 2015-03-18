<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--
<div id="screensaver">
	<canvas id="canvas"></canvas>
	<i class="fa fa-lock" id="screen_unlock"></i>
</div>
<div id="modalbox">
	<div class="devoops-modal">
		<div class="devoops-modal-header">
			<div class="modal-header-name">
				<span>Basic table</span>
			</div>
			<div class="box-icons">
				<a class="close-link"> <i class="fa fa-times"></i>
				</a>
			</div>
		</div>
		<div class="devoops-modal-inner"></div>
		<div class="devoops-modal-bottom"></div>
	</div>
</div>
 --%>
<header class="navbar">
	<div class="container-fluid expanded-panel">
		<div class="row">
			<div id="logo" class="col-xs-12 col-sm-2">
				<a href="${pageContext.request.contextPath}/common/welcome"><spring:message code="mdeforge"/></a>
			</div>
			<div id="top-panel" class="col-xs-12 col-sm-10">
				<div class="row">
					<div class="col-xs-8 col-sm-4">
						<a href="#" class="show-sidebar"> <i class="fa fa-bars"></i></a>
						<%--
						<div id="search">
							<input type="text" placeholder="search" /> <i class="fa fa-search"></i>
						</div>
						--%>
					</div>
					<div class="col-xs-4 col-sm-8 top-panel-right">
						<security:authorize access="isAuthenticated()">
							<ul class="nav navbar-nav pull-right panel-menu">
								<%-- 
								<li class="hidden-xs"><a href="index.html" class="modal-link"> <i class="fa fa-bell"></i> <span class="badge">7</span>
								</a></li>
								<li class="hidden-xs"><a class="ajax-link" href="ajax/calendar.html"> <i class="fa fa-calendar"></i> <span class="badge">7</span>
								</a></li>
								<li class="hidden-xs"><a href="ajax/page_messages.html" class="ajax-link"> <i class="fa fa-envelope"></i> <span class="badge">7</span>
								</a></li>
								--%>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
										<div class="avatar">
											<img src="${pageContext.request.contextPath}/resources/img/avatar.jpg" class="img-rounded" alt="avatar" />
										</div> 
										<i class="fa fa-angle-down pull-right"></i>
										<div class="user-mini pull-right">
											<span class="welcome"><spring:message code="common.welcome"/>,</span> <span><security:authentication property="principal.username" /></span>
										</div>
									</a>
									<ul class="dropdown-menu">
										<li><a href="#"> <i class="fa fa-user"></i> <span><spring:message code="common.user.profile"/></span>
										</a></li>
										<li><a href="${pageContext.request.contextPath}/j_spring_security_logout"> <i class="fa fa-power-off"></i> <span><spring:message code="common.logout"/></span>
										</a></li>
									</ul>
								</li>
							</ul>
						</security:authorize>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>