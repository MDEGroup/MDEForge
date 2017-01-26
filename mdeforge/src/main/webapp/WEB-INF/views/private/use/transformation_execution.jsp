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
<form action="${pageContext.request.contextPath}/private/ATLTransformation/result_transformation" method="POST">

<div class="innerLR">

<div class="box-generic">
<h3 class="header-h main-title text-primary">${atlTransformation.getName()}</h3>
	<h3 class="header-h main-title">Transformation Execution</h3>
	<div class="separator bottom"></div>
	<div class="row-fluid">
	<div class="span12">
	<p>Model transformations can be remotely executed from the Execute the Transformation section. From this section, users can select input models already available in the repository or can upload new ones. Once the input models are selected, the transformation can be executed, and the link to download the generated target model is given back to the user </p>
	</div>
	</div>
	<div class="separator bottom"></div>
	<button class="btn btn-large btn-primary" name="computation" value="1"><i class="icon-play"></i> Execute Transformation</button>
</div>


<div class="widget widget-heading-simple widget-body-white">

	<div class="widget-body">
		<div class="row-fluid">
			<div class="span4">
				<table class="table table-white">
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
							</tbody>
				</table>
			</div>
			<div class="span4">
				<table class="table table-striped table-white">
					<tbody>
					<tr>
					<td class="center"><i class=" icon-long-arrow-right text-primary"></i></td>
							<td class="center strong">${atlTransformation.getName()}</td>
					<td class="center"><i class=" icon-long-arrow-right text-primary"></i></td>
					</tr>
				</table>
			</div>
			<div class="span4">

				<table class="table table-white">
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
							</tbody>
				</table>

			</div>
		</div>
		<input type="hidden" name="transformation_id" value ="${atlTransformation.getId()}"/>
						
	</div>
</div>



</div>

</form>



