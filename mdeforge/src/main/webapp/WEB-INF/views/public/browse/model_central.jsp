<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div class="row-fluid">
		<div class="box-generic">
		<h5 class="input-name">Conform to: </h5>
		
		<c:forEach items="${artifact.relations}" var="relation">
			<c:choose>
				<c:when test="${relation.getClass().name == 'org.mdeforge.business.model.ConformToRelation'}">
					<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${relation.toArtifact.getId()}" class="btn btn-primary">
						${relation.toArtifact.getName()}
					</a>
				</c:when>
			</c:choose>
		</c:forEach>
		</div>
</div>