<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>

<div class="widget widget-heading-simple widget-body-white">

	<!-- Widget Heading -->
	<div class="widget-head">
		<h3 class="heading glyphicons show_thumbnails">
			<i></i>Execute the Transformation
		</h3>
	</div>
	<!-- // Widget Heading END -->

	<div class="widget-body">
		<div class="row-fluid">
			<div class="span4">
				<table class="table table-bordered table-striped table-white">
					<thead>
						<tr>
							<th class="center">Input Metamodels</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${artifact.relations}" var="relation">
							<!-- Table row -->
							<tr>
								<c:choose>
									<c:when
										test="${relation.getClass().name == 'org.mdeforge.business.model.DomainConformToRelation'}">
										<td class="center"><c:choose>
												<c:when test="${relation.getToArtifact().getId()}">${relation.getToArtifact().open}">
																<a
														href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
												</c:when>
												<c:otherwise>
													<a
														href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
												</c:otherwise>
											</c:choose></td>
									</c:when>
								</c:choose>
							</tr>
							<!-- // Table row END -->
						</c:forEach>
				</table>


			</div>
			<div class="span4">
				<table class="table table-bordered table-striped table-white">
					<tbody>
						<tr>
							<td class="center">${artifact.getName()}</td>
						</tr>
				</table>
				<a
					href="${pageContext.request.contextPath}/private/ATLTransformation/execute_transformation?transformation_id=${artifact.getId()}"
					class="btn btn-success btn-small btn-block"><i
					class="icon-play icon-fixed-width"></i> Execute Transformation</a>
			</div>
			<div class="span4">

				<table class="table table-bordered table-striped table-white">
					<thead>
						<tr>
							<th class="center">Output Metamodels</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${artifact.relations}" var="relation">
							<!-- Table row -->
							<tr>
								<c:choose>
									<c:when
										test="${relation.getClass().name == 'org.mdeforge.business.model.CoDomainConformToRelation'}">
										<td class="center"><c:choose>
												<c:when test="${relation.getToArtifact().getId()}">${relation.getToArtifact().open}">
																<a
														href="${pageContext.request.contextPath}/public/EcoreMetamodel/martifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
												</c:when>
												<c:otherwise>
													<a
														href="${pageContext.request.contextPath}/private/EcoreMetamodel/martifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
												</c:otherwise>
											</c:choose></td>
									</c:when>
								</c:choose>
							</tr>
							<!-- // Table row END -->
						</c:forEach>
				</table>

			</div>
		</div>
	</div>
</div>