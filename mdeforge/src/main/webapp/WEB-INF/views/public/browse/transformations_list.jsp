<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse"/></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse.transformations.list"/></li>
</ul>
<!-- Breadcrumb END -->


<h3><spring:message code="mdeforge.public.back.browse.transformations.list"/></h3>


<div class="innerLR">

	
	<div class="widget widget-heading-simple widget-body-gray">
		<div class="widget-body">
		
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
					<c:forEach items="${transformationsList}" var="transformation">
					<!-- Table row -->
					<tr class="gradeX">						
						<td>
							<c:choose>
  								<c:when test="${transformation.getOpen()}">
									<a href="${pageContext.request.contextPath}/public/browse/transformation_details?transformation_id=${transformation.getId()}">${transformation.getName()}</a>
								</c:when>
								<c:otherwise>${transformation.getName()}</c:otherwise>
							</c:choose>
															
							
						<td>
							<c:forEach items="${transformation.properties}" var="property">
								<c:if test="${property.getName() == 'Description '}">
										${property.getValue()}
								</c:if>
							</c:forEach>
						</td>
						<td class="center">${transformation.getOpen()}</td>
						<td class="center">${transformation.getCreated()}</td>
						<td class="center">${transformation.getModified()}</td>
						<td class="center actions">
							<c:choose>
  								<c:when test="${transformation.getOpen()}">
									<a href="${pageContext.request.contextPath}/public/browse/transformation_details?transformation_id=${transformation.getId()}" class="btn-action glyphicons eye_open btn-default" title="Transformation Details"><i></i></a>																	
									<a href="${pageContext.request.contextPath}/private/ATLTransformation/execute_transformation?transformation_id=${transformation.getId()}" class="btn-action glyphicons play btn-success" title="Execute Transformation"><i></i></a>
								</c:when>
							</c:choose>
																									
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
	