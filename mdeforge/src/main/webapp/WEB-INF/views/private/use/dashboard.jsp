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



<h3>Dashboard</h3>


<div class="innerLR">


	<div class="row-fluid">
		<div class="span4">
			<div class="well margin-none">
				<address class="margin-none">
					<h2>${user.getLastname()} ${user.getFirstname()}</h2>
					<strong>${user.getUsername()}</strong> at 
					<strong><a href="#">Business</a></strong><br> 
					<abbr title="Work email">e-mail:</abbr> <a href="mailto:#">${user.getEmail()}</a><br> 
					<abbr title="Work Phone">phone:</abbr> (+39) 0779 0987652<br>
					<div class="separator line"></div>
					
				</address>
			</div>
		
		</div>
		
		<div class="span8">
			
		
		</div>
	</div>

<div class="separator bottom"></div>

	<div class="row-fluid">
		<div class="span4">
			
			<div class="widget widget-body-white">
					<div class="widget-head">
						<h4 class="heading glyphicons file"><i></i>Recent Artifacts (${myArtifactsList.size()})</h4>
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
												<c:choose>
														<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.ATLTransformation'}">
																<a href="${pageContext.request.contextPath}/private/ATLTransformation/transformation_details?transformation_id=${artifact.getId()}">${artifact.getName()}</a>
														</c:when>
														<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.EcoreMetamodel'}">
																<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_details?metamodel_id=${artifact.getId()}">${artifact.getName()}</a>
														</c:when>
														<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.Model'}">
																<a href="#">${artifact.getName()}</a>
														</c:when>
													</c:choose>
											</td>
											<td>
														<c:choose>
																<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.ATLTransformation'}">
																		<span class="badge badge-important">ATL Transformation</span>
																</c:when>
																<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.EcoreMetamodel'}">
																		<span class="badge badge-warning">Ecore Metamodel</span>
																</c:when>
																<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.Model'}">
																		<span class="badge badge-info">Model</span>
																</c:when>
															</c:choose>
			
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
		
		</div>
		
		<div class="span4">

			<div class="widget widget-body-white">
					<div class="widget-head">
						<h4 class="heading glyphicons edit"><i></i>Recent Projects (${myProjectList.size()})</h4>
					</div>
								<div class="widget-body" style="height: 200px; overflow-y: scroll;margin-bottom: 20px;">
								<table class="table table-condensed">
			
								<!-- Table heading -->
								<thead>
									<tr>
										<th>Project Name</th>
										<th>Workspace</th>
									</tr>
								</thead>
								<!-- // Table heading END -->
								
								<!-- Table body -->
								<tbody>
									<c:forEach items="${myProjectList}" var="project">
										<!-- Table row -->
										<tr>
											<td>${project.getName()}</td>
											<td class="center">WS 1</td>
										</tr>
										<!-- // Table row END -->
									</c:forEach>
									<!-- Table row -->
									
								</tbody>
								<!-- // Table body END -->
								
							</table>
					</div>
			</div>
		
		</div>

		<div class="span4">

			<div class="widget widget-body-white">
							<div class="widget-head">
								<h4 class="heading glyphicons stats"><i></i>Statistics</h4>
							</div>
							<div class="widget-body" style="height: 200px; overflow-y: scroll;margin-bottom: 20px;">
								
								
								<div class="widget-body list collapse in">
									<ul>
									
										<!-- List item -->
										<li>
											<span>Total Number of Transformations</span>
											<span class="count">${totalNumberOfTransformations}</span>
										</li>
										<!-- // List item END -->
										
										<!-- List item -->
										<li>
											<span>Total Number of Metamodels</span>
											<span class="count">${totalNumberOfMetamodels}</span>
										</li>
										<!-- // List item END -->
										
										<!-- List item -->
										<li>
											<span>Total Number of Artifact</span>
											<span class="count">${totalNumberOfArtifacts}</span>
										</li>
										<!-- // List item END -->
										
										<!-- List item -->
										<li>
											<span>Total Number of Projects</span>
											<span class="count">${totalNumberOfProjects}</span>
										</li>
										<!-- // List item END -->
										
									</ul>
						</div>
								
								
							</div>
						</div>
		
		</div>
	</div>


	
	
</div>	






	