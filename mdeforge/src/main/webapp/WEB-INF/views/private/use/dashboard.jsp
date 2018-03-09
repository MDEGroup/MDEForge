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
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim.</p> -->

<div class="innerLR" id="dashboard">


	<div class="row-fluid" style="background: url(${pageContext.request.contextPath}/resources/theme/images/1.jpg) center center no-repeat;background-size: cover;">
		<div class="span12">
			<div class="well margin-none">
				<address class="margin-none">
					<h2>${user.getLastname()} ${user.getFirstname()}</h2>
					<span>${user.getUsername()}</span> at 
					<a href="http://www.di.univaq.it/home.php?users_username=alfonso">site</a><br> 
					<span title="Work email">e-mail:</span> <a href="mailto:#">${user.getEmail()}</a><br> 
					<span title="Work Phone">phone:</span> (+39) +39 0862 43.3725<br>
					
				</address>
			</div>
		
		</div>
	</div>
<div class="separator line"></div>
<div class="row-fluid">
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/private/ATLTransformation/artifacts" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfTransformations}</span>
						<span class="txt">Transformations</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifacts" class="widget-stats widget-stats-2">
						<span class="count">${totalNumberOfMetamodels}</span>
						<span class="txt">Metamodels</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/private/Model/artifacts" class="widget-stats widget-stats-2">
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
<hr class="separator">
<div class="separator"></div>
<div class="row-fluid dashboard-buttons">
		<div class="span12 tablet-column-reset">
			<div class="span2">
					<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster" class="widget-stats widget-stats-2 btn" style="background: #fff;     border: 2px solid #3FAAE2 !Important;">
						<span class="count glyphicons vector_path_polygon text-info"><i></i></span>
						<span class="txt" style="color: #3FAAE2">Metamodels Cluster</span>
					</a>
				</div>
			<div class="span2">
				<a href="#upload-artifact" class="widget-stats widget-stats-2 btn" data-toggle="modal" style="background: #b94a48">
						<span class="count icon-cloud-upload text-info"><i></i></span>
						<span class="txt">Upload Artifact</span>
					</a>
			</div>
			<div class="span2">
					<a href="${pageContext.request.contextPath}/private/workspace/create" class="widget-stats widget-stats-2 btn" style="background: #53575d">
						<!-- <span class="count icon-code-fork"><i></i></span> -->
						<span class="count  icon-sitemap text-warning"><i></i></span>
						<span class="txt">New Workspace</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/public/dashboard" class="btn widget-stats widget-stats-2" style="background: #c09853">
						<span class="count icon-folder-open"><i></i></span>
						<span class="txt">Browse Repository</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/public/search" class="widget-stats widget-stats-2 btn" style="background: #3FAAE2">
						<span class="count icon-search text-error"><i></i></span>
						<span class="txt">Search</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}" class="widget-stats widget-stats-2 btn" style="background: #468847">
						<span class="count icon-desktop text-error"><i></i></span>
						<span class="txt">MDE Forge Home</span>
					</a>
			</div>
				<div class="separator bottom"></div>
			</div>
</div>
<div class="separator"></div>
<div class="separator"></div>
<h3 class="header-h main-title" style="padding-left: 15px;">Recent Artifacts (${myArtifactsList.size()})</h3>
<div class="widget widget-body-white">
					<div class="widget-body">
								<table class="table table-striped table-metrics">
			
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
<h3 class="header-h main-title" style="padding-left: 15px;">Recent Projects</h3>
	<div class="widget widget-body-white">
					<div class="widget-body">
								<table class="table table-striped table-metrics">
			
								<!-- Table heading -->
								<thead>
									<tr>
										<th>Project Name</th>
										<th class="center">Created date</th>
									</tr>
								</thead>
								<!-- // Table heading END -->
								
								<!-- Table body -->
								<tbody>
									<c:forEach items="${myProjectList}" var="project">
										<!-- Table row -->
										<tr>										    
											<td><a href="${pageContext.request.contextPath}/private/project?idProject=${project.getId()}"> ${project.getName()} </a></td>
											<td class="center">
												<span><fmt:formatDate type="date" value="${project.getCreatedDate()}" /></span>
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
	<!-- <h3 class="header-h main-title" style="padding-left: 10px;">Graphs</h3>-->
	<div class="widget widget-heading-simple widget-body-white">
		<!-- // Widget heading END -->
		
		<div class="widget-body">
		
			<!-- Chart with lines and fill with no points -->
			<canvas id="myChart" width="100" height="400"></canvas>
		</div>
		
		<div class="widget-body">
		
			<!-- Chart with lines and fill with no points -->
			<canvas id="myChart2" width="100" height="400"></canvas>
		</div>
	</div>
	<!-- // Widget END -->
	<h3 class="header-h main-title" style="padding-left: 10px;">Activities</h3>
	<div class="separator bottom"></div>
	<div class="widget-timeline">
				<ul class="list-timeline">
					
															<!-- Item -->
					<li>
						<span class="date">21/03</span>
						<span class="glyphicons activity-icon user_add"><i></i></span>
						<span class="ellipsis"><a href="">Melisa Ragae</a> registered at <a href="">John Doe's</a> suggestion.</span>
						<div class="clearfix"></div>
					</li>
					<!-- // Item END -->
										<!-- Item -->
					<li>
						<span class="date">21/03</span>
						<span class="glyphicons activity-icon user_add"><i></i></span>
						<span class="ellipsis"><a href="">Jane Doe</a> registered at <a href="">Melisa Ragae's</a> suggestion.</span>
						<div class="clearfix"></div>
					</li>
					<!-- // Item END -->
										<!-- Item -->
					<li>
						<span class="date">21/03</span>
						<span class="glyphicons activity-icon user_add"><i></i></span>
						<span class="ellipsis"><a href="">Darius Jackson</a> registered at <a href="">Martin Glades's</a> suggestion.</span>
						<div class="clearfix"></div>
					</li>
					<!-- // Item END -->
										<!-- Item -->
					<li>
						<span class="date">21/03</span>
						<span class="glyphicons activity-icon user_add"><i></i></span>
						<span class="ellipsis"><a href="">Darius Jackson</a> registered at <a href="">Melisa Ragae's</a> suggestion.</span>
						<div class="clearfix"></div>
					</li>
					<!-- // Item END -->
										<!-- Item -->
					<li>
						<span class="date">21/03</span>
						<span class="glyphicons activity-icon user_add"><i></i></span>
						<span class="ellipsis"><a href="">Darius Jackson</a> registered at <a href="">John Doe's</a> suggestion.</span>
						<div class="clearfix"></div>
					</li>
					<!-- // Item END -->
										<!-- Item -->
					<li>
						<span class="date">21/03</span>
						<span class="glyphicons activity-icon user_add"><i></i></span>
						<span class="ellipsis"><a href="">John Doe</a> registered at <a href="">Jane Doe's</a> suggestion.</span>
						<div class="clearfix"></div>
					</li>
					<!-- // Item END -->
										
				</ul>
				<a href="#" class="btn btn-primary view-all">View all</a>
			</div>


	
	
</div>	


<!-- Charts Helper Demo Script -->
	<script>
	$(document).ready(function(){
		var ctx = document.getElementById("myChart");
		var myChart = new Chart(ctx, {
		    type: 'line',
		    data: {
		        labels: [
		                 <c:forEach items="${statistic}" var ="stat">
		                 	${stat.created},
		                 </c:forEach>
		                 	],
		        datasets: [{
		            label: 'All',
		            data: [
		                 <c:forEach items="${statistic}" var ="stat">
		                 	${stat.total},
		                 </c:forEach>
					],
					duration: 500,
					backgroundColor: "rgba(255, 99, 132, 0.2)",
					borderColor: "rgba(255,99,132,1)",
		            borderWidth: 1
		        },
		        {
		            label: 'ATL Transformations',
		            data: [
		                 <c:forEach items="${statisticT}" var ="stat">
		                 	${stat.total},
		                 </c:forEach>
					],
					duration: 600,
					backgroundColor: "rgba(54, 162, 235, 0.2)",
					borderColor: "rgba(54, 162, 235, 1)",
		            borderWidth: 1
		        },
		        {
		            label: 'ECORE Metamodels',
		            data: [
		                 <c:forEach items="${statisticMM}" var ="stat">
		                 	${stat.total},
		                 </c:forEach>
					],
					duration: 700,
					backgroundColor: "rgba(255, 206, 86, 0.2)",
					borderColor: "rgba(255, 206, 86, 1)",
		            borderWidth: 1
		        },
		        {
		            label: 'Models',
		            data: [
		                 <c:forEach items="${statisticM}" var ="stat">
		                 	${stat.total},
		                 </c:forEach>
					],
					duration: 800,
					backgroundColor: "rgba(75, 192, 192, 0.2)",
					borderColor: "rgba(75, 192, 192, 1)",
		            borderWidth: 1
		        }]
		    },
		    options: {
                legend: {
                    position: 'top',
                },
                hover: {
                    mode: 'label'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Day'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        }
                    }]
                },
		    	maintainAspectRatio: false,
		    	fullWidth: true
		    }
		});
		var ctx2 = document.getElementById("myChart2");
		var myChart2 = new Chart(ctx2, {
		    type: 'line',
		    data: {
		        labels: [
		                 <c:forEach items="${statistic2}" var ="stat">
		                 	${stat.created},
		                 </c:forEach>
		                 	],
		        datasets: [{
		            label: 'All',
		            data: [
		                 <c:forEach items="${statistic2}" var ="stat">
		                 	${stat.total},
		                 </c:forEach>
					],
					duration: 500,
					backgroundColor: "rgba(54, 162, 235, 0.2)",
					borderColor: "rgba(54, 162, 235, 1)",
		            borderWidth: 1
		        }
		      ]
		    },
		    options: {
                legend: {
                    position: 'top',
                },
                hover: {
                    mode: 'label'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Number of Metamodel'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Number of Metaclass'
                        }
                    }]
                },
		    	maintainAspectRatio: false,
		    	fullWidth: true
		    }
		});
	})
	
	</script>



	