<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li>Use</li>
		<li class="divider"></li>
		<li>My workspace</li>
</ul>
<!-- Breadcrumb END -->



<!-- Heading -->
<div class="heading-buttons">
	<h3><spring:message code="mdeforge.public.back.browse.menu.cluster_metamodel"/> <spring:message code="mdeforge.public.back.browse.table"/></h3>
	<span> Metamodels in the repository: ${numberOfMetamodels}</span>
	<div class="buttons pull-right">
		<a href="${pageContext.request.contextPath}/private/workspace/create" class="btn btn-primary btn-icon glyphicons stats" title="Workspace Insert">Workspace Insert</a>
		<a href="${pageContext.request.contextPath}/public/EcoreMetamodel/cluster_graph?threshold=${threshold}&computation=${computation}" class="btn btn-primary btn-icon glyphicons stats"><i></i> Graph View</a>			
	</div>
	<div class="clearfix"></div>
</div>
<div class="separator bottom"></div>
<!-- // Heading END -->

<div class="innerLR">

	
	<div class="widget widget-heading-simple widget-body-gray">
		<div class="widget-body">
			
			<!-- Table -->
			<table class="dynamicTable tableTools table table-striped table-bordered table-condensed table-white">
				<!-- Table heading -->
				<thead>
					<tr>						
						<th>Name</th>
<!-- 						<th>Description</th> -->
<!-- 						<th>Open</th> -->
<!-- 						<th>Created</th> -->
<!-- 						<th>Modified</th> -->
						<th>Action</th>
					</tr>
				</thead>
				<!-- // Table heading END -->
				
				<!-- Table body -->
				<tbody>
					<c:forEach items="${workspaces_list}" var="workspace">
<!-- 					Table row -->
					<tr class="gradeX">						
						<td><a href="${pageContext.request.contextPath}/private/workspace?id=${workspace.getId()}">${workspace.getName()}</a></td>
<!-- 						<td> -->
<%-- 							<c:forEach items="${ecoreMetamodel.properties}" var="property"> --%>
<%-- 								<c:if test="${property.getName() == 'Description '}"> --%>
<%-- 										${property.getValue()} --%>
<%-- 								</c:if> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<%-- 						<td class="center">${ecoreMetamodel.getOpen()}</td> --%>
<%-- 						<td class="center">${ecoreMetamodel.getCreated()}</td> --%>
<%-- 						<td class="center">${ecoreMetamodel.getModified()}</td> --%>
						<td class="center actions">
								<a href="${pageContext.request.contextPath}/private/workspace?id=${workspace.getId()}" class="btn-action glyphicons eye_open btn-default" title="Metamodel Details"><i></i></a>																	
								<a href="${pageContext.request.contextPath}/private/workspace?id=${workspace.getId()}" class="btn-action glyphicons download_alt btn-success" title="Metamodel Download"><i></i></a>																	
						</td>
					</tr>
<!-- 					// Table row END -->
					</c:forEach>
					
					
				</tbody>
				<!-- // Table body END -->
				
			</table>
			<!-- // Table END -->
			
		</div>
	</div>
	
</div>	
	