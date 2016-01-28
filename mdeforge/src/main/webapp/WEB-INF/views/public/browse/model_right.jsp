<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>
<c:if test="${artifact.properties.size()!=0 }">
<div class="span3 tablet-column-reset">
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-white">
		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading glyphicons notes">
				<i></i>Properties
			</h4>
		</div>
		<!-- // Widget Heading END -->
		<div class="widget-body list">
			<table class="table">
				<!-- Table body -->
				<tbody>
					<c:forEach items="${artifact.properties}" var="property">
						<tr>
							<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
							<td class=""><c:choose>
									<c:when test="${fn:length(property.getValue()) < 40}">
										<span data-toggle="tooltip"
											data-original-title="${property.getValue()}"
											data-placement="left">${property.getValue()}</span>
									</c:when>
									<c:otherwise>
										<span data-toggle="tooltip"
											data-original-title="${property.getValue()}"
											data-placement="left" style="font-size: 80%;">${fn:replace(property.getValue(), '/', '/ ')}</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
				<!-- // Table body END -->
			</table>
		</div>
	</div>
</div>
</c:if>


