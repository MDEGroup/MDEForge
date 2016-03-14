<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a href="#" class="glyphicons dashboard"><i></i> Private
			Area</a></li>
	<li class="divider"></li>
	<li>Use</li>
	<li class="divider"></li>
	<li>Dashboard</li>
</ul>
<!-- Breadcrumb END -->



<h3>Dashboard</h3>


<div class="innerLR">


	<div class="row-fluid">
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading glyphicons stats">
						<i></i>Repository Statistics
					</h4>
				</div>
				<div class="widget-body"
					style="height: 200px; overflow-y: scroll; margin-bottom: 20px;">


					<div class="widget-body list collapse in">
						<ul>

							<!-- List item -->
							<li><span>Total Number of Transformations</span> <span
								class="count">${numATL}</span></li>
							<!-- // List item END -->

							<!-- List item -->
							<li><span>Total Number of Metamodels</span> <span
								class="count">${numEcore}</span></li>
							<!-- // List item END -->

							<!-- List item -->
							<li><span>Total Number of Models</span> <span class="count">${numModel}</span>
							</li>
							<li><span>Total Number of Artifact</span> <span
								class="count">${numArtifacts}</span></li>
							<!-- // List item END -->

							<!-- List item -->
							<li><span>Total Number of Projects</span> <span
								class="count">${numProject}</span></li>
														<!-- List item -->
							<li><span>Total Number of Users</span> <span
								class="count">${numUsers}</span></li>
							<!-- // List item END -->

						</ul>
					</div>


				</div>
			</div>
		</div>

		<div class="span8"></div>
	</div>

	<div class="separator bottom"></div>

	<div class="row-fluid">
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading glyphicons file">
						<i></i>Recent Ecore Metamodels (${numEcore})
					</h4>
				</div>
				<div class="widget-body"
					style="height: 200px; overflow-y: scroll; margin-bottom: 20px;">
					<table class="table table-condensed">

						<thead>
							<tr>
								<th>Name</th>
								<th class="center">Last update</th>
								<th>Owner</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentsEcore}" var="artifact">
								<tr>
									<td>
										${artifact.name}
									</td>
									<td>
										${artifact.created }
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
		</div>
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading glyphicons file">
						<i></i>Recent ATL transformations (${numATL})
					</h4>
				</div>
				<div class="widget-body"
					style="height: 200px; overflow-y: scroll; margin-bottom: 20px;">
					<table class="table table-condensed">

						<thead>
							<tr>
								<th>Name</th>
								<th class="center">Last update</th>
								<th>Owner</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentsATL}" var="artifact">
								<tr>
									<td>
										${artifact.name}
									</td>
									<td>
										${artifact.created }
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
		</div>
		<div class="span4">

			<div class="widget widget-body-white">
				<div class="widget-head">
					<h4 class="heading glyphicons file">
						<i></i>Recent Models (${numModel})
					</h4>
				</div>
				<div class="widget-body"
					style="height: 200px; overflow-y: scroll; margin-bottom: 20px;">
					<table class="table table-condensed">

						<thead>
							<tr>
								<th>Name</th>
								<th class="center">Last update</th>
								<th>Owner</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentsModel}" var="artifact">
								<tr>
									<td>
										${artifact.name}
									</td>
									<td>
										${artifact.created }
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
		</div>
	</div>
</div>






