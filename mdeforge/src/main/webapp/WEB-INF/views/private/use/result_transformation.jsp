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
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${models}" var="model">
							<tr>
								<td>
									${model.getName()}
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>






