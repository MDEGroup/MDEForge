<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="#" class="glyphicons dashboard"><i></i> Private Area</a></li>
		<li class="divider"></li>
		<li> Use</li>
		<li class="divider"></li>
		<li>Dashboard</li>
</ul>
<!-- Breadcrumb END -->



<h2 class="header-h main-title">Dashboard</h2>


<div class="innerLR" id="dashboard">


	<div class="row-fluid" style="background: url(/mdeforge/resources/theme/images/1.jpg) center center no-repeat;background-size: cover;">
		<div class="span12">
			<div class="well margin-none">
				<address class="margin-none">
					<h2>${user.getLastname()} ${user.getFirstname()}</h2>
					<span>${user.getUsername()}</span> at 
					<a href="#">Business</a><br> 
					<span title="Work email">e-mail:</span> <a href="mailto:#">${user.getEmail()}</a><br> 
					<span title="Work Phone">phone:</span> (+39) 0779 0987652<br>
					
				</address>
			</div>
		
		</div>
	</div>
<div class="separator line"></div>
<div class="row-fluid">
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="#" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfTransformations}</span>
						<span class="txt">Transformations</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="#" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfMetamodels}</span>
						<span class="txt">Metamodels</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="#" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfModels}</span>
						<span class="txt">Models</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="#" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfArtifacts}</span>
						<span class="txt">Artifacts</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="#" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfProjects}</span>
						<span class="txt">Projects</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
			</div>
<div class="separator"></div>
<div class="widget widget-body-white">
					<div class="widget-head">
						<h4 class="heading file"><i></i>Recent Artifacts (${myArtifactsList.size()})</h4>
					</div>
					<div class="widget-body" style="height: 200px; overflow-y: scroll;margin-bottom: 20px;">
								<table class="table table-condensed">
			
								<!-- Table heading -->
								<thead>
									<tr>
										<th>Name</th>
										<th>Type</th>
										<th class="center">Last update</th>
									</tr>
								</thead>
								<!-- // Table heading END -->
								
								<!-- Table body -->
								<tbody>
									<c:forEach items="${myArtifactsList}" var="artifact">
										<!-- Table row -->
										<tr>
											<td>
												<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName() }/artifact?artifact_id=${artifact.getId()}">${artifact.getName()}</a>
												
											</td>
											<td>
												<span class="badge badge-important">${artifact.getClass().getSimpleName() }</span>
											</td>
											<td class="center"><fmt:formatDate type="date" value="${artifact.getModified()}" /></td>
										</tr>
										<!-- // Table row END -->
									</c:forEach>
									
								</tbody>
								<!-- // Table body END -->
								
							</table>
					</div>
			</div>
<div class="separator"></div>
	<div class="widget widget-body-white">
					<div class="widget-head">
						<h4 class="heading folder_open"><i></i>Recent Projects (${myProjectList.size()})</h4>
					</div>
								<div class="widget-body" style="height: 200px; overflow-y: scroll;margin-bottom: 20px;">
								<table class="table table-condensed">
			
								<!-- Table heading -->
								<thead>
									<tr>
										<th>Project Name</th>
										<th>Created date</th>
									</tr>
								</thead>
								<!-- // Table heading END -->
								
								<!-- Table body -->
								<tbody>
									<c:forEach items="${myProjectList}" var="project">
										<!-- Table row -->
										<tr>
											<td>${project.getName()}</td>
											<td class="center">
												<span class="label"><fmt:formatDate type="date" value="${project.getCreatedDate()}" /></span>
											</td>
										</tr>
										<!-- // Table row END -->
									</c:forEach>
									<!-- Table row -->
								</tbody>
								<!-- // Table body END -->
							</table>
					</div>
			</div>
	
	<!-- Widget -->
	<h3 class="header-h main-title" style="padding-left: 10px;">Graphs</h3>
	<div class="widget widget-heading-simple widget-body-white">
		<!-- // Widget heading END -->
		
		<div class="widget-body">
		
			<!-- Chart with lines and fill with no points -->
			<div id="chart_lines_fill_nopoints" style="width: 100%; height: 250px;"></div>
		</div>
	</div>
	<!-- // Widget END -->


	
	
</div>	



<script>
	$(document).ready(function(){
		$(function()
				  {
				  	// initialize charts
				  	if (typeof charts != 'undefined')
				  		charts.initCharts();
				  });
		
		
	});
	
	  
	</script>



	