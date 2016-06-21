<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div class="span4 tablet-column-reset">
<div class="box-generic">
	<!-- Latest Orders/List Widget -->
	<h5 class="input-name center">Shared Users</h5>
	<div class="separator bottom"></div>
	<%-- Da Tagliare -->
	
	<!-- // Latest Orders/List Widget END -->
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-white">

		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading glyphicons notes">
				<i></i>Properties
			</h4>
		</div>
		<!-- // Widget Heading END -->
		<c:if test="${artifact.properties.size()!=0 }">

			<div class="widget-body list">
				<table class="table">

					<!-- Table body -->
					<tbody>

						<c:forEach items="${artifact.properties}" var="property">
							<tr>
								<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
								<td class=""><c:choose>
										<c:when test="${fn:length(property.getValue()) < 40}">
											<span data-toggle="tooltip"
												data-original-title="${property.getValue()}"
												data-placement="left">${property.getValue()}</span>
										</c:when>
										<c:otherwise>

											<span data-toggle="tooltip"
												data-original-title="${property.getValue()}"
												data-placement="left" style="font-size: 80%;">${fn:replace(property.getValue(), '/', '/ ')}</span>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
					<!-- // Table body END -->

				</table>
			</div>
		</c:if>
	</div>
	<hr>
	<!-- Da Tagliare End--%>
	<p class="text-primary">${artifact.getShared().size()} people share this artifact</p>
		<c:if test="${userId == artifact.getAuthor().getId()}">
 		<a class="btn btn-primary" href="#" id="showUserList">Add People</a>
 		</c:if>
 		<div class="widget">
			
			<div class="widget-body list products">
				<ul id="users" class="team">
					<c:forEach items="${artifact.getShared()}" var="user" varStatus="count">
					<!-- List item -->
					<li class="userLi" data-id="${user.getId()}">
						<span class="glyphicons activity-icon user"><i></i></span>
						<span class="title">${user.getUsername()}<br><strong>${user.getFirstname()}
						${user.getLastname()}</strong></span>
						<c:if test="${userId == artifact.getAuthor().getId()}">
						<span class="pull-right glyphicons icon-remove removeArtifactSharedUser" data-id="${user.getId()}" ></span>
						</c:if>
						<!--  <span class="count crt">${count.count}</span>-->
					</li>
					<!-- // List item END -->
					</c:forEach>													
				</ul>
			</div>
		</div>
		<div id="userList" class="row-fluid" style="display: none">
			<select id="userSelect">
			</select>
			<div>
				<span class="btn btn-block btn-primary span4" id="addUserArtifact">Add</span>
			</div>
		</div>
		
		<%-- <ul id="users" class="team">
			<c:forEach items="${artifact.getShared()}" var="user" varStatus="count">
				<li class="userLi" data-id="${user.getId()}"><span class="crt">${count.count}</span><span
					class="strong">${user.getUsername()}</span><span
					class="muted">${user.getFirstname()}
						${user.getLastname()}</span>
					<span class="muted"><a href="mailto:${user.getEmail() }">${user.getEmail() } <i class="icon-envelope"></i></a></span>
					<c:if test="${userId == artifact.getAuthor().getId()}">
						<span class="pull-right glyphicons icon-remove removeArtifactSharedUser" data-id="${user.getId()}" ></span>
					</c:if>
				</li>
			</c:forEach>
		</ul> --%>
</div>	
</div>
