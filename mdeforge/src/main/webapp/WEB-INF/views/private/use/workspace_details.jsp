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
	<span class="btn btn-block btn-primary" id="showProjectList">Add Project <i class="icon-angle-down"></i></span>
	<div id="projectsToAdd" class="innerT" style="display: none">
	<h5 class="input-name center" style="margin: 0 0 10px;">Add Project to Workspace</h5>
	<select id="projectSelect" style="width: 100%; margin-bottom: 15px;">
		<c:forEach items="${projects}" var="proj">
			<option value="${proj.getId() }">${proj.getName()}</option>
		</c:forEach>
	</select>
	<span class="btn btn-block btn-success" id="addProject">Add</span>
	</div>
</div>
<div class="span6">
	<span class="btn btn-block btn-primary" id="showProjectAdd">Create New Project <i class="icon-angle-down"></i></span>
	<div id="createProject" class="innerT form-horizontal" style="display: none">
	<h5 class="input-name center" style="margin: 0 0 10px;">Create New Project</h5>
							<input type="text" placeholder="Project Name"
								id="createProjectName" style="width: 65%; float: left;">
							<select id="createProjectOpen" name="open" style="width: 30%; float: right;">
								<option value="true">Public</option>
								<option value="false">Private</option>
							</select>
							<textarea id="createProjectDesc" name="description" placeholder="Description"></textarea>
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
							<a class="accordion-toggle" id="navigator-accordion" data-toggle="collapse" data-parent="#accordion" href="#collapse-1">
								<span class="results"><i class="icon-ellipsis-vertical"></i> Navigator</span>
								<span id="navigator-open" class="pull-right">Open <i class="icon-angle-down"></i></span>
								<span id="navigator-close" class="pull-right">Close <i class="icon-angle-up"></i></span>
							</a>
					    </div>
					    <div id="collapse-1" class="accordion-body in collapse" style="height: auto;">
					        	<div class="span12 listWrapper">							
									
									<ul class="list unstyled autoscroll" id="projectList">
									<c:forEach items="${workspace.projects}" var="proj">
											<li id="${proj.getId() }">
											<div class="media innerAll">
												<div class="media-object pull-left thumb"><img src="/mdeforge/resources/theme/images/logo-small.png" width="51px" height="51px"></div>
												<div class="media-body">
													<h5 class="strong text-black">${proj.getName()}</h5>
													<span class="muted">${proj.getOwner().getUsername() }</span>
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
		<hr class="separator">
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
									<div class="separator bottom"></div>
									<p class="muted" id="artifactsNumber"></p>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim.</p>
								</div>
								<div class="span4 text-right">
								<h5 class="input-name">Visibility</h5>	
								<div id="visibility">
									<span class="btn btn-success"><i class="icon-cloud"></i> Public</span>
								</div>					  												    
								<div class="separator bottom"></div>
								<h5 class="input-name">Owner</h5>
								<!-- // Profile Photo END -->
								<ul class="icons-ul">
									<li><span id="ownerUsername"></span> <span class="icon-user text-primary"><i></i></span></li>
									<li class="text-black" style="font-size: 14px" id="ownerName"></li>
									<li><a href="#" id="ownerEmail"></a> <span class="icon-envelope text-primary"><i></i></span></li>
								</ul>
								<div class="separator"></div>
								</div>
							</div>
							
						</div>
						<div class="body">
							<div class="row-fluid">
								<div class="span3">
									<h5 class="input-name">Ecore Metamodels <i class="pull-right icon-plus text-primary button-toggle" id="showEcoreList"></i></h5>
									<div id="ecoreToAdd" style="display: none">
										<div class="separator bottom"></div>
										<input id="ecoreSelect" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search Ecore Metamodels">
										<span class="btn btn-block btn-primary" id="addEcore">Add</span>
									</div>
									<div class="separator bottom"></div>
									<table class="table table-striped" id="ecoreMMTable">
										<tbody>
											<tr>
												<td></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="span3">
									<h5 class="input-name">ATL Transformations <i class="pull-right icon-plus text-primary button-toggle" id="showATLList"></i></h5>
									
									<div id="ATLToAdd" style="display: none">
									<div class="separator bottom"></div>
										<input id="ATLSelect" class="my-select" type="text" data-type="ATLTransformation" data-project="" placeholder="Search ATL Transformations">
										<span class="btn btn-block btn-primary" id="addATL">Add</span>
									</div>
									<div class="separator bottom"></div>
									<table class="table table-striped" id="atlTable">
										<tbody>
											<tr>
												<td></td>
											</tr>
										</tbody>
									</table>

								</div>
								<div class="span3">
									<h5 class="input-name">Models <i class="pull-right icon-plus text-primary button-toggle" id="showModelList"></i></h5>
									<div id="modelToAdd" style="display: none">
									<div class="separator bottom"></div>
										<input id="modelSelect" class="my-select" type="text" data-type="Model" placeholder="Search Models">
										<div>
											<span class="btn btn-block btn-primary" id="addModel">Add</span>
										</div>
									</div>
									<div class="separator bottom"></div>
									<table class="table table-striped" id="modelTable">
										<tbody>
											<tr>
												<td></td>
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
												<span class="btn btn-block btn-primary" id="addUser">Add</span>
												
									</div>
									<div class="separator bottom"></div>
									<p class="text-primary" id="sharedNumber"></p>
										
								 		<div class="widget">
											
											<div class="widget-body list products">
												<ul class="team" id="users"></ul>
											</div>
										</div>
										
									
									
								</div>
							</div>
							
						</div>
						<hr class="separator">
						<span id="removeProject" class="btn btn-danger remove-project" data-id="" data-name="" style="margin-top: 20px"><i class="icon-remove"></i> Delete Project</span>
					</div>
				</div>
			</div>

</div>
<div class="separator "></div>
<div class="separator "></div>
<div class="separator "></div>
<div class="separator "></div>
<div class="separator "></div>
<div class="separator "></div>


<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/spinner/spin.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/workspaceManager.js"></script>
