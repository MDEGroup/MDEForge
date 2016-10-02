<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a href="#" class="glyphicons dashboard"><i></i> Public
			Area</a></li>
	<li class="divider"></li>
	<li>Use</li>
	<li class="divider"></li>
	<li>Dashboard</li>
</ul>
<!-- Breadcrumb END -->



<h2 class="header-h main-title">Browse the Repository</h2>
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim.</p> -->

<div class="innerLR" id="dashboard">
	<!-- <div class="row-fluid" style="background: url(/mdeforge/resources/theme/images/1.jpg) center center no-repeat;background-size: cover;">
		<div class="span12">
			<div class="well margin-none">
				<address class="margin-none">
					<h2>MDE Forge</h2>
				</address>
			</div>
		
		</div>
	</div>-->
<div class="separator line"></div>
<div class="row-fluid">
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/public/ATLTransformation/artifacts" class="widget-stats widget-stats-2">
						<span class="count">${numATL}</span>
						<span class="txt">Transformations</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifacts" class="widget-stats widget-stats-2">
						<span class="count">${numEcore}</span>
						<span class="txt">Metamodels</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/public/Model/artifacts" class="widget-stats widget-stats-2">
						<span class="count">${numModel}</span>
						<span class="txt">Models</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="${pageContext.request.contextPath}/public/projects" class="widget-stats widget-stats-2">
						<span class="count">${numArtifacts}</span>
						<span class="txt">Artifacts</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
				<div class="span2">
				
					<!-- Stats Widget -->
					<a href="#" class="widget-stats widget-stats-2">
						<span class="count">${numProject}</span>
						<span class="txt">Projects</span>
					</a>
					<!-- // Stats Widget END -->
					
				</div>
			</div>
<hr class="separator">
<div class="row-fluid dashboard-buttons">
		<div class="span12 tablet-column-reset">
			<div class="span2">
				<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster" class="widget-stats widget-stats-2 btn" style="background: #fff;     border: 2px solid #3FAAE2 !Important;">
						<span class="count glyphicons vector_path_polygon text-info"><i></i></span>
						<span class="txt" style="color: #3FAAE2">Metamodels Cluster</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifacts" class="widget-stats widget-stats-2 btn" style="background: #b94a48">
						<span class="count glyphicons share_alt"><i></i></span>
						<span class="txt">Metamodels</span>
					</a>
			</div>
			<div class="span2">
					<a href="${pageContext.request.contextPath}/public/ATLTransformation/artifacts" class="widget-stats widget-stats-2 btn" style="background: #53575d">
						<!-- <span class="count icon-code-fork"><i></i></span> -->
						<span class="count  glyphicons random"><i></i></span>
						<span class="txt">Transformations</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/public/Model/artifacts" class="btn widget-stats widget-stats-2" style="background: #c09853">
						<span class="count icon-sitemap text-success"><i></i></span>
						<span class="txt">Models</span>
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

	<div class="row-fluid">
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading">
						Recent Ecore Metamodels (${numEcore})
					</h4>
				</div>
				<div class="widget-body table-dashboard">
					<table class="table tabled-striped">

						<thead>
							<tr>
								<th>Name</th>
								<th>Owner</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentsEcore}" var="artifact">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${artifact.id}">${artifact.name}</a>
									</td>
									<td>
										${artifact.author.username }
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifacts" class="btn btn-block">View All</a>
		</div>
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading">
						<i></i>Recent ATL transformations (${numATL})
					</h4>
				</div>
				<div class="widget-body table-dashboard">
					<table class="table table-striped">

						<thead>
							<tr>
								<th>Name</th>
								<th>Owner</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentsATL}" var="artifact">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/public/ATLTransformation/artifact?artifact_id=${artifact.id}">${artifact.name}</a>
									</td>
									<td>
										${artifact.author.username }
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/public/ATLTransformation/artifacts" class="btn btn-block">View All</a>
		</div>
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading">
						<i></i>Recent Models (${numModel})
					</h4>
				</div>
				<div class="widget-body table-dashboard">
					<table class="table table-striped">

						<thead>
							<tr>
								<th>Name</th>
								<th>Owner</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentsModel}" var="artifact">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/public/Model/artifact?artifact_id=${artifact.id}">${artifact.name}</a>
									</td>
									<td>
										${artifact.author.username }
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/public/Model/artifacts" class="btn btn-block">View All</a>
		</div>
	</div>
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




