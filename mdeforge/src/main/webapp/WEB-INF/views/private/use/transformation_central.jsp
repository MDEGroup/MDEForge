<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:if test="${artifact.atlError.size()== 0 && artifact.atlTestError.size()==0}">
<div class="separator"></div>
<div class="innerLR">
	<div class="row-fluid">
		<div class="span2">
			<a	href="${pageContext.request.contextPath}/private/ATLTransformation/analysis?transformation_id=${artifact.getId()}"
					class="btn btn-primary btn-block" style="padding: 10px;"><!-- <i class= "icon-cogs icon-fixed-width"></i>--> Analyze Transformation</a>
		</div>
		</div>
	</div>
</c:if>
<c:if test="${artifact.atlError.size() != 0}">
	<div class="widget widget-heading-simple widget-body-white">		
		<div class="widget-body">
		<h5 class="input-name text-error">anATLyzer Transformation Errors</h5>
			<div class="tab-content">
				<div id="tabAll" class="tab-pane active">
					<c:forEach items="${artifact.atlError}" var="error"
						varStatus="status">
						<div class="accordion accordion-2" id="accordion">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle glyphicons font collapsed"
										data-toggle="collapse" data-parent="#accordion"
										href="#collapse-${status.index + 1 }"> <i></i>Error
										${status.index + 1 }: ${error.description }
									</a>
								</div>
								<div id="collapse-${status.index + 1 }"
									class="accordion-body collapse" style="height: 0px;">
									<div class="accordion-inner">
										<b>Local problem: </b>${error.localProblem } <br /> <b>Element:
										</b>${error.element }<br /> <b>File location: </b>${error.fileLocation }<br />
										<b>Location: </b>${error.location }<br /> <b>Status: </b>${error.status }<br />
										<b>ProblemId: </b>${error.problemId }<br /> <b>Description:
										</b>${error.description }<br /> <b>Severity: </b>${error.severity }<br />
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${artifact.atlTestError.size() != 0}">

	<div class="widget widget-heading-simple widget-body-white">
		<div class="widget-body">
		<h5 class="input-name">Test service report</h5>
			<c:forEach items="${artifact.atlTestError}" var="error"
				varStatus="status">

				<div class="accordion accordion-2" id="accordion">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle glyphicons font collapsed"
								data-toggle="collapse" data-parent="#accordion"
								href="#collapse-${status.index + 2 }"> <i></i>Test
								${status.index + 1 }: ${error.errorMessage }
							</a>
						</div>
						<div id="collapse-${status.index + 2 }"
							class="accordion-body collapse" style="height: 0px;">
							<div class="accordion-inner">
								executionRaisesException: ${error.executionRaisesException }<br />
								executionYieldsIllTarget: ${error.executionYieldsIllTarget }<br />
								<%-- 											anatlyserNotifiesError: ${error.anatlyserNotifiesError }<br/> --%>
								<%-- 											anatlyserDoesNotFinish: ${error.anatlyserDoesNotFinish }<br/> --%>
								errorKind: ${error.errorKind }<br /> errorMessage:
								${error.errorMessage }<br /> model: <a
									href="${pageContext.request.contextPath}/private/Model/artifact?artifact_id=${error.model.id }">
									${error.model.name }</a>
							</div>
						</div>
					</div>
				</div>



			</c:forEach>
		</div>
	</div>
</c:if>


<div class="widget widget-heading-simple widget-body-white">

	<div class="widget-body">
	<h5 class="input-name">Execute the Transformation</h5>
	<div class="separator bottom"></div>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p>
	<div class="separator bottom"></div>
		<div class="row-fluid">
			<div class="span4">
				<table class="table table-striped table-white">
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
				<table class="table table-striped table-white">
					<tbody>
					<tr>
					<td class="center"><i class=" icon-long-arrow-right text-primary"></i></td>
							<td class="center strong">${artifact.getName()}</td>
					<td class="center"><i class=" icon-long-arrow-right text-primary"></i></td>
					</tr>
				</table>
			</div>
			<div class="span4">

				<table class="table table-striped table-white">
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
														href="${pageContext.request.contextPath}/public/EcoreMetamodel/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
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
		</div>
		<a href="${pageContext.request.contextPath}/private/ATLTransformation/execute_transformation?transformation_id=${artifact.getId()}"
					class="btn btn-success btn-block"><i
					class="icon-play icon-fixed-width"></i> Execute Transformation</a>
	</div>
</div>
<div class="separator"></div>
<hr>