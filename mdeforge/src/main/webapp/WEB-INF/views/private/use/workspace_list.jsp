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

<!-- // Heading END -->

<div class="innerLR">
<div class="box-generic">
<div class="row-fluid">
<div class="span8">
	<h3 class="header-h main-title">My workspaces</h3>
<p>Resembling functionalities of desktop IDEs, like Eclipse, registered users have the possibility to create modeling artifacts and organize them in projects that are, in turn, contained in workspaces. Projects and artifacts can be shared with users of the same system installation.</p>
<span> Metamodels in the repository: ${numberOfMetamodels}</span>
</div>
	<div class="span4 buttons text-right" style="margin-top: 20px">
		<a href="${pageContext.request.contextPath}/private/workspace/create" class="btn btn-primary" title="New Workspace"><i class="icon-plus"></i> New Workspace</a>			
	</div>
</div>
</div>
	<div class="widget widget-heading-simple">
		<div class="widget-body">
			
			<!-- Table -->
			<table class="dynamicTable tableTools table table-striped table-white">
				<!-- Table heading -->
				<thead>
					<tr>						
						<th>Name</th>
<!-- 						<th>Description</th> -->
<!-- 						<th>Open</th> -->
						<th>Description</th>
						<th>Last Update</th>
						<th>Created</th>
						
						
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
						<td>
								${workspace.getDescription()}																	
						</td>
						<td class="center">
																								
						</td>
						<td class="center">
																								
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
	