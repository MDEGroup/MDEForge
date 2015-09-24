<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a href="#" class="glyphicons dashboard"><i></i> Private
			Area</a></li>
	<li class="divider"></li>
	<li>Use</li>
	<li class="divider"></li>
	<li>Transformation Execution</li>
</ul>
<!-- Breadcrumb END -->




















<h3>Transformation Execution</h3>


<div class="innerLR">








<div class="widget widget-heading-simple widget-body-white">

	<!-- Widget Heading -->
	<div class="widget-head">
		<h3 class="heading glyphicons show_thumbnails">
			<i></i>Execute the Transformation
		</h3>
	</div>
	<!-- // Widget Heading END -->

	<div class="widget-body">
		<form action="${pageContext.request.contextPath}/private/use/result_transformation"
			method="POST">
			<div class="row-fluid">
				<div class="span4">
					<table class="table table-bordered table-striped table-white">
						<thead>
							<tr>
								<th class="center">Input Metamodels</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${atlTransformation.relations}" var="relation">
								
								<!-- Table row -->
								<tr>
									<c:choose>
										<c:when
											test="${relation.getClass().name == 'org.mdeforge.business.model.DomainConformToRelation'}">
											<td class="center"><a
												href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a>
												<select name="models_in">
												    <c:forEach items="${models}" var="model">
												    	<c:forEach items="${ model.getRelations()}" var="conformance">
													    	<c:choose>
													    		<c:when 
													    			test="${relation.getToArtifact().getId() == conformance.getToArtifact().getId()}">
													    			<option value="${model.id}">${conformance.getFromArtifact().getName()}</option>
													    		</c:when>
													    	</c:choose>
												        </c:forEach>
												    </c:forEach>
												</select>
												</td>
											
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
								<td class="center">${atlTransformation.getName()}</td>
							</tr>
					</table>
					<input type="hidden" name="transformation_id" value ="${atlTransformation.getId()}"/>
					<button class="btn btn-block btn-success" name="computation" value="1">Execute Transformation</button>
<!-- 					<a -->
<%-- 						href="${pageContext.request.contextPath}/private/use/restult_transformation?transformation_id=${atlTransformation.getId()}" --%>
<!-- 						class="btn btn-success btn-small btn-block"><i -->
<!-- 						class="icon-play icon-fixed-width"></i> Execute Transformation</a> -->
				</div>
				<div class="span4">

					<table class="table table-bordered table-striped table-white">
						<thead>
							<tr>
								<th class="center">Output Metamodels</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${atlTransformation.relations}" var="relation">
								<!-- Table row -->
								<tr>
									<c:choose>
										<c:when
											test="${relation.getClass().name == 'org.mdeforge.business.model.CoDomainConformToRelation'}">
											<td class="center"><a
												href="${pageContext.request.contextPath}/public/browse/metamodel_details?metamodel_id=${relation.getToArtifact().getId()}">${relation.getToArtifact().getName()}</a></td>
										</c:when>
									</c:choose>
								</tr>
								<!-- // Table row END -->
							</c:forEach>
					</table>

				</div>
			</div>
		</form>
	</div>
</div>



</div>






