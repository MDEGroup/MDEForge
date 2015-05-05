<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse"/></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse.dashboard"/></li>
</ul>
<!-- Breadcrumb END -->



<h3><spring:message code="mdeforge.public.back.browse.dashboard"/></h3>


<div class="innerLR">
	
	<c:forEach items="${clusters}"  var="cluster" varStatus="loop">
	
	
	
	<div class="row-fluid">
			<div class="span12">
									
									<h3>
										
										<c:forEach items="${cluster.domains}" var="domain">															
															${domain} | 
														</c:forEach>	
														
									</h3>		
				<table class="footable table table-striped table-bordered table-white table-primary table-pricing">	
													<!-- Table heading -->
										<thead>
														<tr>																						
															<th data-class="expand">Name</th>
															
															<th data-hide="phone,tablet">Open</th>
															<th data-hide="phone,tablet">Created</th>
															<th data-hide="phone,tablet">Modified</th>
															<th data-hide="phone,tablet">Most Representative</th>
															<th data-hide="phone,tablet">Actions</th>
														</tr>
													</thead>
													<!-- // Table heading END -->
													
													<!-- Table body -->
													<tbody>
														<c:forEach items="${cluster.artifacts}" var="artifact">
															<!-- Table row -->
															 <tr class="gradeX">
																																														
																<td>${artifact.getName()}</td>
																
																<td class="center">${artifact.getOpen()}</td>
																<td class="center"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getCreated()}" /></td>
																<td class="center"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getModified()}" /></td>
																<c:choose>
																  <c:when test="${artifact.getId() == cluster.getMostRepresentive().getId()}">		
																  <td class="center"><span class="glyphicons standard circle_ok"><i></i></span></td>													    
																  </c:when>						 
																  <c:otherwise>
																  <td></td>
																  </c:otherwise>
																</c:choose>
																<td class="center actions">
																	<a href="#" class="btn-action glyphicons eye_open btn-default"><i></i></a>																	
																</td>
															</tr>
															<!-- // Table row END -->
														</c:forEach>
														
														
														
														
													</tbody>
													<!-- // Table body END -->
													
												</table>
													
													
												</div>										
											</div>
											<hr>
	
	</c:forEach>
	
</div>	
	