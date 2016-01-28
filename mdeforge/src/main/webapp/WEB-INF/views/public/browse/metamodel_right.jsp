<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div class="span3 tablet-column-reset">
	<!-- Latest Orders/List Widget -->
	<div class="widget widget-heading-simple widget-body-gray"
		data-toggle="collapse-widget">

		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading glyphicons link">
				<i></i>URI
			</h4>
		</div>
		<!-- // Widget Heading -->

		<div class="widget-body list">
			<table class="table table-condensed">

				<!-- Table body -->
				<tbody>
					<c:choose>
						<c:when test="${artifact.getUri().size() > 0}">
							<c:forEach items="${artifact.getUri()}" var="uri">
								<tr>
									<td class="center">${uri}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td class="center">It has not been assigned any URI</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
				<!-- // Table body END -->

			</table>
		</div>
	</div>
	<!-- // Latest Orders/List Widget END -->
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-white">

		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading glyphicons notes">
				<i></i>Properties
			</h4>
		</div>
		<!-- // Widget Heading END -->
		<c:if test="${artifact.properties.size()!=0 }">

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
		</c:if>
	</div>
	<!-- Widget -->
	<div class="widget widget-heading-simple widget-body-white">
		<!-- Widget Heading -->
		<div class="widget-head">
			<h4 class="heading glyphicons notes">
				<i></i>Extracted Word Context
			</h4>
		</div>
		<!-- // Widget Heading END -->
		<div class="relativeWrap">
			<div class="widget widget-tabs">

				<!-- Tabs Heading -->
				<div class="widget-head">
					<ul>
						<li class="active"><a class="glyphicons cloud" href="#cloud"
							data-toggle="tab"><i></i>Word Cloud</a></li>
						<li><a class="glyphicons font" href="#standard"
							data-toggle="tab"><i></i>Standard</a></li>
					</ul>
				</div>
				<!-- // Tabs Heading END -->

				<div class="widget-body">
					<div class="tab-content">

						<!-- Tab content -->
						<div class="tab-pane active" id="cloud">

							<canvas id="my_canvas"></canvas>

						</div>
						<!-- // Tab content END -->

						<!-- Tab content -->
						<div class="tab-pane" id="standard">

							<c:set var="serializedContext_trim"
								value="${fn:trim(artifact.getExtractedContents())}" />
							<c:set var="serializedContext_splitted"
								value="${fn:replace(serializedContext_trim, ' ', ' - ')}" />
							${serializedContext_splitted}

						</div>
						<!-- // Tab content END -->

					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- // Widget END -->
</div>