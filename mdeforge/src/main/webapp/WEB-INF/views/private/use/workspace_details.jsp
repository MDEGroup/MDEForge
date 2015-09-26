<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li>Use</li>
	<li class="divider"></li>
	<li>Workspace details</li>
</ul>
<!-- Breadcrumb END -->
<div class="row-fluid">
	<div class="span8" id="workspaceId" data-id="${workspace.getId()}"><h3>${workspace.getName() }</h3></div>
	<div class="span4">
		<form action="${pageContext.request.contextPath}/private/workspace/delete"
			method="get">
			<input value="${workspace.getId()}" type="hidden" name="id" id="idWorkspaceHidden" > 
			<button type="submit" class="btn btn-inverse">
				<spring:message code="mdeforge.common.action.delete.workspace" />
			</button>
		</form>
	</div>
</div>
<div class="innerLR">

	<!-- Widget -->
	<div
		class="widget widget-heading-simple widget-body-white widget-employees">

		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading">
				<i></i>${workspace.getDescription()}</h4>
		</div>
		<!-- // Widget Heading END -->

		<div class="widget-body padding-none">

			<div class="row-fluid row-merge">
				<div class="span4 listWrapper">
					<!--  <span class="results">${workspace.getProjects().size() } Project <i class="icon-circle-arrow-down"></i></span>-->
					<div>
						<span class="btn btn-block btn-primary span6" id="showProjectList">Add
							Project</span> <span class="btn btn-block btn-primary"
							id="showProjectAdd">Create new Project</span>
					</div>
					<div id="projectsToAdd" class="row-fluid" style="display: none">
						<div class="span6">
							<select id="projectSelect">
								<c:forEach items="${projects}" var="proj">
									<option value="${proj.getId() }">${proj.getName()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="span3"></div>
						<div class="span3">
							<span class="btn btn-block btn-primary" id="addProject">Add</span>
						</div>
					</div>
					<div id="createProject" class="row-fluid" style="display: none">
						<div class="span6">
							<input type="text" placeholder="Project name"
								id="createProjectName">
						</div>
						<div class="span3"></div>
						<div class="span3">
							<span class="btn btn-block btn-primary" id="addNewProject">Create</span>
						</div>
					</div>

					<ul class="list unstyled autoscroll" id="projectList">
						<c:forEach items="${workspace.projects}" var="proj">
							<li id="${proj.getId() }">
								<div class="media innerAll">
									<div class="pull-right glyphicons icon-remove remove-project"
										data-id="${proj.getId() }" data-name="${proj.getName() }"></div>
									<div class="media-body">
										<span class="strong">${proj.getName()}</span> <span
											class="muted">Owner:</span> <span class="muted">${proj.getOwner().getUsername() }
											<a href="mailto:${proj.getOwner().getEmail() }"><i
												class="icon-envelope"></i></a>
										</span>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="span8 detailsWrapper" id="details">
					<div class="ajax-loading hide">
						<i class="icon-spinner icon-spin icon-4x"></i>
					</div>
					<div class="innerAll" id="workspaceDetailsDiv"
						style="display: none;">
						<div class="title">
							<div class="row-fluid">
								<div class="span8" id="projectId">
									<h3 class="text-primary" id="projectName"></h3>
								</div>
								<div class="span4 text-right">
									<p class="muted" id="artifactsNumber">4 projects</p>
								</div>
							</div>
						</div>
						<hr />
						<div class="body">
							<div class="row-fluid">
								<div class="span4">
									<h5 class="strong">
										Ecore Metamodels <i class="icon-expand-alt" id="showEcoreList"></i>
									</h5>

									<div id="ecoreToAdd" style="display: none">
										<select class="span12" id="ecoreSelect">
											<option value="pippo">pippo</option>
										</select>
										<div>
											<span class="btn btn-block btn-primary" id="addEcore">Add</span>
										</div>
									</div>

									<table class="table table-condensed" id="ecoreMMTable">
										<tbody>
											<tr>
												<td>Lorem ipsum dolor</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="span4">
									<h5 class="strong">
										ATL Transformations <i class="icon-expand-alt"
											id="showATLList"></i>
									</h5>
									<div id="ATLToAdd" style="display: none">
										<select class="span12" id="ATLSelect">
										</select>
										<div>
											<span class="btn btn-block btn-primary" id="addATL">Add</span>
										</div>
									</div>
									<table class="table table-condensed" id="atlTable">
										<tbody>
											<tr>
												<td>Lorem ipsum dolor</td>
											</tr>
										</tbody>
									</table>

								</div>
								<div class="span4">
									<h5 class="strong">
										Models <i class="icon-expand-alt" id="showModelList"></i>
									</h5>
									<div id="modelToAdd" style="display: none">
										<select class="span12" id="modelSelect">
										</select>
										<div>
											<span class="btn btn-block btn-primary" id="addModel">Add</span>
										</div>
									</div>
									<table class="table table-condensed" id="modelTable">
										<tbody>
											<tr>
												<td>Lorem ipsum dolor</td>
											</tr>
										</tbody>
									</table>

								</div>
							</div>
							<div class="row-fluid">
								<div class="span4">
									<h5 class="text-uppercase strong text-primary">
										<i class="icon-male text-regular icon-fixed-width"></i>Owner
									</h5>
									<ul class="icons-ul">
										<li id="ownerEmail"><i
											class="icon-envelope icon-li icon-fixed-width"></i></li>
										<li id="ownerName"><i
											class="icon-phone icon-li icon-fixed-width"></i></li>
										<li id="ownerUsername"><i
											class="icon-skype icon-li icon-fixed-width"></i></li>
									</ul>
								</div>
								<div class="span8" id="userDiv" style="display: none;">
									<h5 class="text-uppercase strong text-primary">
										<i class="icon-group text-regular icon-fixed-width"></i>
										Shared with <span class="text-lowercase padding-none"
											id="sharedNumber">(2 people)</span> <i
											class="icon-expand-alt" id="showUserList"></i>
									</h5>
									<ul class="team" id="users">
									</ul>
									<div id="userList" class="row-fluid" style="display: none">
										<select id="userSelect">
										</select>
										<div>
											<span class="btn btn-block btn-primary span4" id="addUser">Add</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- // Widget END -->
</div>




