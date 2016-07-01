<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div class="span4 tablet-column-reset">
<div class="box-generic">
	<!-- Latest Orders/List Widget -->
	<h5 class="input-name center">Shared Users 
	<c:if test="${logged_user.id == artifact.getAuthor().getId()}">
		<i class="pull-right icon-plus text-primary button-toggle" id="showUserList"></i>
	</c:if>
	</h5>
	<div class="separator bottom"></div>
	<div id="userList" class="row-fluid" style="display: none">
			<select id="userSelect">
			</select>
			<span class="btn btn-block btn-primary" id="addUserArtifact">Add User</span>
		</div>
	<div class="separator bottom"></div>
	<p class="text-primary center"><span class="strong text-black" id="numberUser">${artifact.getShared().size()}</span> people share this artifact</p>
 		<div class="widget">
			
			<div class="widget-body list products">
				<ul id="users" class="team">
					<c:forEach items="${artifact.getShared()}" var="user" varStatus="count">
					<!-- List item -->
					<li class="userLi" data-id="${user.getId()}">
						<span class="glyphicons activity-icon user"><i></i></span>
						<span class="title">${user.getUsername()}<br><strong>${user.getFirstname()}
						${user.getLastname()}</strong></span>
						<c:if test="${logged_user.id == artifact.getAuthor().getId()}">
							<span class="pull-right text-error removeArtifactSharedUser" data-id="${user.getId()}" ><i class="icon-remove"></i></span>
						</c:if>
						<!--  <span class="count crt">${count.count}</span>-->
					</li>
					<!-- // List item END -->
					</c:forEach>													
				</ul>
			</div>
		</div>
		
</div>	
</div>

