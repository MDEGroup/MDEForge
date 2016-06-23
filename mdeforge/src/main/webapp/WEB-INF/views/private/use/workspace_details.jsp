<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


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

<div class="box-generic">
<div class="row-fluid">
<div class="span8" id="workspaceId" data-id="${workspace.getId()}">
	<h3 class="header-h main-title">${workspace.getName() }</h3>
<p>${workspace.getDescription() }</p>
<span> Projects in Workspace: </span>
</div>
	<div class="span4 buttons text-right" style="margin-top: 20px">
		<form action="${pageContext.request.contextPath}/private/workspace/delete"
			method="get">
			<input value="${workspace.getId()}" type="hidden" name="id" id="idWorkspaceHidden" > 
			<button type="submit" class="btn btn-danger">
				<i class="icon-remove"></i> <spring:message code="mdeforge.common.action.delete.workspace" />
			</button>
		</form>	
	</div>
</div>
</div>
<div class="innerLR">
<div class="row-fluid">
<div class="span6">
	<span class="btn btn-block btn-primary" id="showProjectList">Add Project</span>
	<div id="projectsToAdd" class="innerT" style="display: none">
	<select id="projectSelect" style="width: 100%; margin-bottom: 15px;">
		<c:forEach items="${projects}" var="proj">
			<option value="${proj.getId() }">${proj.getName()}</option>
		</c:forEach>
	</select>
	<span class="btn btn-block btn-success" id="addProject">Add</span>
	</div>
</div>
<div class="span6">
	<span class="btn btn-block btn-primary" id="showProjectAdd">Create New Project</span>
	<div id="createProject" class="innerT form-horizontal" style="display: none">
							<input type="text" placeholder="Project name"
								id="createProjectName">
							<span class="btn btn-block btn-success" id="addNewProject">Create</span>
					</div>
</div>
			
</div>
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-white widget-employees">

		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading">
				<i></i>${workspace.getDescription()}</h4>
		</div>
		<!-- // Widget Heading END -->

		<div class="widget-body padding-none">

			<div class="row-fluid row-merge">
				<div class="accordion" id="accordion">
				
					<!-- Accordion Item -->
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse-1">
								<span class="results"><i class="icon-ellipsis-vertical"></i> Navigator</span>
							</a>
					    </div>
					    <div id="collapse-1" class="accordion-body in collapse" style="height: auto;">
					        	<div class="span12 listWrapper">							
									
									<ul class="list unstyled">
									<c:forEach items="${workspace.projects}" var="proj">
											<li id="${proj.getId() }">
											<div class="media innerAll">
												<div class="media-object pull-left thumb"><img src="/mdeforge/resources/theme/images/logo-small.png" width="51px" height="51px"></div>
												<div class="media-body">
													<span class="strong text-black">${proj.getName()}</span>
													<span class="muted">${proj.getOwner().getUsername() }</span>
													<a href="mailto:${proj.getOwner().getEmail() }"><i
																class="icon-envelope"></i></a>
												</div>
											</div>
											</li>
										</c:forEach>
									</ul>
								</div>	
					    </div>
				  	</div>
				  	<!-- // Accordion Item END -->
				  	
				</div>
			</div>
	</div>
	</div>
					<!--  <span class="results">${workspace.getProjects().size() } Project <i class="icon-circle-arrow-down"></i></span>-->
		<div class="separator"></div>
			<div class="row-fluid form-horizontal">
				<div class="span12 detailsWrapper" id="details">
					<div class="ajax-loading hide">
						<i class="icon-spinner icon-spin icon-4x"></i>
					</div>
					<div class="innerAll" id="workspaceDetailsDiv" style="display: none;">
						<div class="title">
							<div class="row-fluid">
								<div class="span8" id="projectId">
									<h3 class="text-primary header-h main-title" id="projectName"></h3>
									<div class="separator"></div>
									<p class="muted" id="artifactsNumber"></p>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim.</p>
								</div>
								<div class="span4">
									<span id="removeProject" class="btn btn-danger remove-project pull-right" data-id="" data-name="" style="margin-top: 20px"><i class="icon-remove"></i> Delete</span>
									<div class="separator"></div>
								</div>
							</div>
							
						</div>
						<h5 class="input-name">Owner</h5>
								<ul class="icons-ul" style="border-right: none;border-left: 2px solid #ededed;padding-left: 10px;margin: 10px 0;">
									<li><span class="icon-user text-primary"><i></i></span> <span id="ownerUsername">Admin</span></li>
									<li class="text-black" style="font-size: 14px" id="ownerName">Juri Di Rocco</li>
									<li><span class="icon-envelope text-primary"><i></i></span> <a href="#" id="ownerEmail">juri.dirocco@univaq.it </a></li>
								</ul>
						<hr>
						<div class="body">
							<div class="row-fluid">
								<div class="span3">
									<h5 class="input-name">Ecore Metamodels <i class="pull-right icon-plus text-primary button-toggle" id="showEcoreList"></i></h5>
									<div id="ecoreToAdd" style="display: none">
										<div class="separator bottom"></div>
										<select id="ecoreSelect">
											<option value="" selected disabled>Search Metamodels</option>
										</select>
										<div>
											<span class="btn btn-block btn-primary" id="addEcore">Add</span>
										</div>
									</div>
									<div class="separator bottom"></div>
									<table class="table table-condensed" id="ecoreMMTable">
										<tbody>
											<tr>
												<td>Lorem ipsum dolor</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="span3">
									<h5 class="input-name">ATL Transformations <i class="pull-right icon-plus text-primary button-toggle" id="showATLList"></i></h5>
									
									<div id="ATLToAdd" style="display: none">
									<div class="separator bottom"></div>
										<select id="ATLSelect">
											<option value="" selected disabled>Search Metamodels</option>
										</select>
										<div>
											<span class="btn btn-block btn-primary" id="addATL">Add</span>
										</div>
									</div>
									<div class="separator bottom"></div>
									<table class="table table-condensed" id="atlTable">
										<tbody>
											<tr>
												<td>Lorem ipsum dolor</td>
											</tr>
										</tbody>
									</table>

								</div>
								<div class="span3">
									<h5 class="input-name">Models <i class="pull-right icon-plus text-primary button-toggle" id="showModelList"></i></h5>
									<div id="modelToAdd" style="display: none">
									<div class="separator bottom"></div>
										<select id="modelSelect">
											<option value="" selected disabled>Search Metamodels</option>
										</select>
										<div>
											<span class="btn btn-block btn-primary" id="addModel">Add</span>
										</div>
									</div>
									<div class="separator bottom"></div>
									<table class="table table-condensed" id="modelTable">
										<tbody>
											<tr>
												<td>Lorem ipsum dolor</td>
											</tr>
										</tbody>
									</table>

								</div>
								<div class="span3" id="userDiv" style="display: none;">
									<!-- Latest Orders/List Widget -->
									<h5 class="input-name">Shared Users <i class="pull-right icon-plus text-primary button-toggle" id="showUserList"></i></h5>
									<div id="userList" class="row-fluid" style="display: none">
										<div class="separator bottom"></div>
											<select id="userSelect">
											</select>
												<span class="btn btn-block btn-primary" id="addUserArtifact">Add</span>
												
									</div>
									<div class="separator bottom"></div>
									<p class="text-primary"><span id="sharedNumber" class="text-black strong"></span> people share this artifact</p>
										
								 		<div class="widget">
											
											<div class="widget-body list products">
												<ul class="team" id="users"></ul>
											</div>
										</div>
										
									
									
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>

</div>
<div class="separator "></div>
<div class="separator "></div>
<div class="separator "></div>


<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/spinner/spin.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/workspaceManager.js"></script>
