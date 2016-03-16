<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<script
	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>

<div class="row-fluid">
	<div class="span12">
		Conform to
		<c:forEach items="${artifact.relations}" var="relation">
			<c:choose>
				<c:when
					test="${relation.getClass().name == 'org.mdeforge.business.model.ConformToRelation'}">
					<a
						href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${relation.toArtifact.getId()}"
						class="btn btn-success btn-small btn-block">${relation.toArtifact.getName()}</a>
				</c:when>
			</c:choose>
		</c:forEach>


	</div>
</div>