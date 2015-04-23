<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Workspaces</a></li>
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3><spring:message code="mdeforge.workspace"/></h3>
	</div>
	
	<div class="clearfix visible-xs"></div>
	
</div>




<div class="row">
	<div class="col-xs-3">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class=""></i>
					<span>Info Workspace</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<ul>
					<li>Name: ${workspace.getName()}</li>
					<li>Description: ${workspace.getDescription()}</li>
				</ul>
			</div>
		</div>
		
	</div>
</div>




<div class="row">
	<div class="col-xs-6">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class=""></i>
					<span>Projects</span>
				</div>
				<div class="no-move"></div>
			</div>
			
			
				
			
			
			<div class="box-content">
				<table id="workspace_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable" >
					<thead>
						<tr>							
							<th>Id</th>
							<th>Name</th>
							<th># Artifacts</th>
							<th>Details</th>
														
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${workspace.getProjects()}" var="project">
   							<tr>
   								<td>${project.getId()}</td>
   								<td>${project.getName()}</td>
   								<td>${project.getArtifacts().size()}</td>   								   								
   								<td>${project.getArtifacts().size()}</td>   								   								
   							</tr>							
						</c:forEach>
					</tbody>					
				</table>
			</div>
			
			
			
		</div>
	</div>
</div>


<div class="row">	
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-list"></i>
					<span>Artifacts</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<table id="workspace_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable" >
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Public</th>
							<th>Details</th>
							<th>Created</th>
							<th>Modified</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${workspace.getArtifacts()}" var="artifact">
   							<tr>
   								<td>${artifact.getId()}</td>
   								<td>${artifact.getName()}</td>
   								<td>${artifact.getClass().getCanonicalName().split("\\.")[4]}</td>
   								<td>${artifact.getOpen()}</td>
   								<td></td>
   								<td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${artifact.getCreated()}" /></td>      															   								
   								<td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${artifact.getModified()}" /></td>   	   								
   							</tr>							
						</c:forEach>
					</tbody>					
				</table>
			</div>
		</div>
	</div>
	
</div>


