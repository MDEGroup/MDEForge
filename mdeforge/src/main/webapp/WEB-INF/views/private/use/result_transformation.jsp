<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<h3>Transformation Result</h3>

<div class="innerLR">
	<div class="widget widget-heading-simple widget-body-white">
		<div class="row-fluid">
			<div class="span12">
				<table class="table table-bordered table-striped table-white">
					<thead>
						<tr>
							<th class="center">Output models</th>
							<th class="center">Conform to metamodel</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${models}" var="model">
							<tr>
								<td>
									<a href="${pageContext.request.contextPath}/private/Model/model_details?model_id=${model.getId()}">${model.getName()}</a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_details?metamodel_id=${model.metamodel.getToArtifact().getId()}">${model.getMetamodel().getToArtifact().getName() }</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row-fluid">
			 <textarea name="errors" rows="4" style="width:100%">
			 ${errors }
			</textarea> 
		</div>
	</div>

</div>






