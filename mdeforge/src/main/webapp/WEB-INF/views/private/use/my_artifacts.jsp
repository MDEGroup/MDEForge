<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="#" class="glyphicons dashboard"><i></i> Private Area</a></li>
		<li class="divider"></li>
		<li> Use</li>
		<li class="divider"></li>
		<li>My Artifacts</li>
</ul>
<!-- Breadcrumb END -->



<h3 class="header-h main-title">${pageName}</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p>

	
	<div class="innerLR">

	
	<div class="widget widget-heading-simple">
		<div class="widget-body">
		
			<!-- Table -->
			<table class="dynamicTable tableTools table table-striped table-white">
			
				<!-- Table heading -->
				<thead>
					<tr>						
						<th>Name</th>
						<!-- <th>Description</th>-->
						<th class="center">Artifact Type</th>
						<th class="center">Open</th>
						<th class="center">Created</th>
						<th class="center">Modified</th>
						<th class="center">Action</th>
					</tr>
				</thead>
				<!-- // Table heading END -->
				
				<!-- Table body -->
				<tbody>
					<c:forEach items="${sharedArtifactList}" var="artifact">
					<!-- Table row -->
					<tr class="gradeX">						
						<td>
							<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/artifact?artifact_id=${artifact.getId()}">${artifact.getName()}</a>
						</td>
						<!-- <td>
							<c:forEach items="${artifact.properties}" var="property">
								<c:if test="${property.getName() == 'Description '}">
										${property.getValue()}
								</c:if>
							</c:forEach>
						</td>-->
						<td class="center">
							<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/artifact?artifact_id=${artifact.getId()}" title="See Artifact Details">${artifact.getClass().getSimpleName()}</a>
							<c:choose>
								<c:when test="${artifact.getClass().name == 'org.mdeforge.business.model.Model'}">
										(<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${artifact.getMetamodel().getToArtifact().getId()}">${artifact.getMetamodel().getToArtifact().getName()}</a>)
								</c:when>
							</c:choose>
						</td>
						<td class="center">${artifact.getOpen()}</td>
						<td class="center">${artifact.getCreated()}</td>
						<td class="center">${artifact.getModified()}</td>
						<td class="center actions">
								<!-- <a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${artifact.getId()}" class="btn-action glyphicons remove_2 btn-danger" title="Delete Artifact"><i></i></a>
								<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/artifact?artifact_id=${artifact.getId()}" class="btn-action glyphicons eye_open btn-default" title="See Artifact Details"><i></i></a>-->
								<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/artifact_download?artifact_id=${artifact.getId()}" class="btn-action center download_alt" title="Artifact Download">Download</a>
									
								
								
																									
						</td>
					</tr>
					<!-- // Table row END -->
					</c:forEach>
					
					
				</tbody>
				<!-- // Table body END -->
				
			</table>
			<!-- // Table END -->
			
		</div>
	</div>
	
</div>	