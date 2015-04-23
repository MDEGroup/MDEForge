<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!--Start Breadcrumb-->
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Workspaces</a></li>
		</ol>
	</div>
</div>
<!--End Breadcrumb-->
<!--Start Dashboard 1-->
<div id="dashboard-header" class="row">
	<div class="col-xs-12 col-sm-4 col-md-5">
		<h3><spring:message code="mdeforge.workspace"/>: ${workspace.getName()}</h3>
	</div>
	<div class="clearfix visible-xs"></div>
	<div class="col-xs-12 col-sm-8 col-md-7 pull-right">
		<div class="row">
			
			
			
		</div>
	</div>
</div>
<!--End Dashboard 1-->
<!--Start Dashboard 2-->
<div class="row-fluid">
	<div id="dashboard_links" class="col-xs-12 col-sm-2 pull-right">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#" class="tab-link" id="overview">Overview</a></li>
			<li><a href="#" class="tab-link" id="projects">Projects</a></li>
			<li><a href="#" class="tab-link" id="artifacts">Artifacts</a></li>
		</ul>
	</div>
	<div id="dashboard_tabs" class="col-xs-12 col-sm-10">
		<!--Start Dashboard Tab 1-->
		<div id="dashboard-overview" class="row" style="visibility: visible; position: relative;">
			<div id="ow-marketplace" class="col-sm-12 col-md-12">
				
				<h4 class="page-header">OVERVIEW</h4>
				${workspace.getDescription()}
			</div>
			
			
		
			
			
			
			<div class="col-xs-12 col-md-6">				
				<div id="ow-summary" class="row">
					<div class="col-xs-12">
						<h4 class="page-header">WORKSPACE SUMMARY</h4>
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-6">Total projects<b>${workspace.getProjects().size()}</b></div>
									<div class="col-xs-6">Total artifacts<b>${workspace.getArtifacts().size()}</b></div>
								</div>								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--End Dashboard Tab 1-->
		<!--Start Dashboard Tab 2-->
		<div id="dashboard-projects" class="row" style="visibility: hidden; position: absolute;">
			<div id="ow-marketplace" class="col-sm-12 col-md-12">
				<!-- <div id="ow-setting">
					<a href="#"><i class="fa fa-folder-open"></i></a>
					<a href="#"><i class="fa fa-credit-card"></i></a>
					<a href="#"><i class="fa fa-ticket"></i></a>
					<a href="#"><i class="fa fa-bookmark-o"></i></a>
					<a href="#"><i class="fa fa-globe"></i></a>
				</div>-->
				<h4 class="page-header">PROJECTS</h4>
				<table id="ticker-table" class="table m-table table-bordered table-hover table-heading">
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
		<!--End Dashboard Tab 2-->
		
		
		<!--Start Dashboard Tab 3-->
		<div id="dashboard-artifacts" class="row" style="visibility: hidden; position: absolute;">
		
			<div id="ow-marketplace" class="col-sm-12 col-md-12">
				<!-- <div id="ow-setting">
					<a href="#"><i class="fa fa-folder-open"></i></a>
					<a href="#"><i class="fa fa-credit-card"></i></a>
					<a href="#"><i class="fa fa-ticket"></i></a>
					<a href="#"><i class="fa fa-bookmark-o"></i></a>
					<a href="#"><i class="fa fa-globe"></i></a>
				</div> -->
				<h4 class="page-header">ARTIFACTS</h4>
				<table id="ticker-table" class="table m-table table-bordered table-hover table-heading">
					<thead>
						<tr>							
							<th>Id</th>
							<th>Name</th>
							<th>Description</th>
							<th>Created</th>
							<th>Modified</th>
							<th>Public</th>
														
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${workspace.getArtifacts()}" var="artifact">
   							<tr>
   								<td>${artifact.getId()}</td>
   								<td>${artifact.getName()}</td>
   								<td>${artifact.getClass().getCanonicalName().split("\\.")[4]}</td>   								   								
   								<td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${artifact.getCreated()}" /></td>
   								<td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${artifact.getModified()}" /></td>
   								<td>
   								<c:choose>
								  <c:when test="${artifact.getOpen()}">								   	
								   	<i class="fa fa-users"></i>
								  </c:when>				
								  <c:otherwise>
								    <i class="fa fa-user"></i>
								  </c:otherwise>
								</c:choose>		
   								</td>							   								
   							</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
				
				
		</div>
		<!--End Dashboard Tab 3-->		
	</div>
	<div class="clearfix"></div>
</div>
<!--End Dashboard 2 -->
<div style="height: 40px;"></div>
<script type="text/javascript">
// Array for random data for Sparkline
var sparkline_arr_1 = SparklineTestData();
var sparkline_arr_2 = SparklineTestData();
var sparkline_arr_3 = SparklineTestData();
$(document).ready(function() {
	// Make all JS-activity for dashboard
	DashboardTabChecker();
	// Load Knob plugin and run callback for draw Knob charts for dashboard(tab-servers)
	LoadKnobScripts(DrawKnobDashboard);
	// Load Sparkline plugin and run callback for draw Sparkline charts for dashboard(top of dashboard + plot in tables)
	LoadSparkLineScript(DrawSparklineDashboard);
	// Load Morris plugin and run callback for draw Morris charts for dashboard
	LoadMorrisScripts(MorrisDashboard);
	// Load Springy plugin and run callback for draw network map for dashboard
	LoadSpringyScripts(SpringyNetmap);
	// Make beauty hover in table
	$("#ticker-table").beautyHover();
	// Run script for stock block
	CreateStockPage();
});
</script>
