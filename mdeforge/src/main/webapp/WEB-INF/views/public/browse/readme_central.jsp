<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	
<div class="row-fluid">			
<div class="span12">
<div class="box-generic">
<h5 class="input-name">Relations</h5>
<p> Each artifact refers to the
corresponding type, e.g., model, transformation, metamodel, etc. The specification of
the relation between a given artifact and the corresponding type is done by means of
the Relation elements. In turn, each relation is typed by means of a corresponding
RelationType element. </p>

<div class="separator bottom"></div>
    <!-- Tabs Heading -->
    <div class="tabsbar">
        <ul>
            <li><a href="#tab7-7" data-toggle="tab">Related Artifact</a></li>
        </ul>
    </div>
    <!-- // Tabs Heading END -->

    <div class="tab-content">
         <div class="tab-pane" id="tab7-7">
            	<table class="table table-striped table-white">

											<!-- Table heading -->
											<thead>
												<tr>
													<th class="center">Related Artifact</th>
												</tr>
											</thead>
											<!-- // Table heading END -->

											<!-- Table body -->
											<tbody>
												<c:forEach items="${artifact.relations}"
													var="relation">
													<!-- Table row -->
													<tr>
														<c:choose>
															<c:when
																test="${relation.getClass().name == 'org.mdeforge.business.model.DocumentalRelation'}">
																<c:choose>
																	<c:when
																		test="${relation.getToArtifact().getId() == artifact.getId()}">
																		<td>
																		<c:choose>
																			<c:when test="${relation.getToArtifact().getOpen()}">
																			</c:when>
																		</c:choose>
																		
																		<a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getFromArtifact().getId()}">${relation.getFromArtifact().getName()}</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="${pageContext.request.contextPath}/public/EcoreMetamodel/artifact?artifact_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose>
													</tr>
													<!-- // Table row END -->
												</c:forEach>
										</table>
        </div>
        <!-- // Tab content END -->
    </div>
</div>
</div>
</div>
<hr>
