<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a
		href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full"
		class="glyphicons dashboard"><i></i> Private area</a></li>
	<li class="divider"></li>
	<li>Services</li>
	<li class="divider"></li>
	<li>Transformation Chain</li>
</ul>
<!-- Breadcrumb END -->


<h3>Search</h3>


<div class="innerLR">
	<!-- Table -->
			<table class="dynamicTable tableTools table table-striped table-bordered table-condensed table-white">
			
				<!-- Table heading -->
				<thead>
					<tr>						
						<th>Name</th>
						<th>Description</th>
						<th>Open</th>
						<th>Created</th>
						<th>Modified</th>
						<th>Action</th>
					</tr>
				</thead>
				<!-- // Table heading END -->
				
				<!-- Table body -->
				<tbody>
					<c:forEach items="${artifactList}" var="artifact">
					<!-- Table row -->
					<tr class="gradeX">						
						<td><a href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${artifact.getId()}">${artifact.getName()}</a></td>
						<td>
							<c:forEach items="${artifact.properties}" var="property">
								<c:if test="${property.getName() == 'Description '}">
										${property.getValue()}
								</c:if>
							</c:forEach>
						</td>
						<td class="center">${artifact.getOpen()}</td>
						<td class="center">${artifact.getCreated()}</td>
						<td class="center">${artifact.getModified()}</td>
						<td class="center actions">
								<a href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${artifact.getId()}" class="btn-action glyphicons eye_open btn-default" title="Metamodel Details"><i></i></a>																	
								<a href="${pageContext.request.contextPath}/public/browse/metamodel_download?metamodel_id=${artifact.getId()}" class="btn-action glyphicons download_alt btn-success" title="Metamodel Download"><i></i></a>																	
						</td>
					</tr>
					<!-- // Table row END -->
					</c:forEach>
					
					
				</tbody>
				<!-- // Table body END -->
				
			</table>
			<!-- // Table END -->






</div>
