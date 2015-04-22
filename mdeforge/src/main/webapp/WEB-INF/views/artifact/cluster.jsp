<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Artifact</a></li>
			<li><a href="#">Cluster</a></li>			
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3>
			<spring:message code="mdeforge.metamodel.similarity.graph" />
		</h3>
	</div>
	<div class="clearfix visible-xs"></div>
</div>
<div class="row-fluid">
	<spring:message code="mdeforge.metamodel.cluster.total" />: ${clusters.size()}<br/>
	<spring:message code="mdeforge.metamodel.cluster.average" />: ${average}<br>
	<spring:message code="mdeforge.metamodel.cluster.max" />: ${max}<br>
	<spring:message code="mdeforge.metamodel.cluster.noCluster" />: ${noCluster}<br>
	<spring:message code="mdeforge.metamodel.cluster.effectiveCluster" />: ${clusters.size()- noCluster}<br>
	<br> 
	<c:forEach items="${clusters}"  var="cluster">
		
			<div class="col-xs-6">
				<div class="box ui-draggable">
					<div class="box-header">
						<div class="box-name">
							<i class="fa fa-table"></i>
							<span>Cluster</span>
						</div>
						<div class="no-move"></div>
					</div>
					<div class="box-content">
						<table class="table" >
							<thead>
								<tr>
									<th>Artifact</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cluster.artifacts}" var="artifact">
									<tr>
		   								<td>${artifact.getName()}</td>
		   							</tr>				
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
	   								<th>
	   									<div>
	   										<div>EMF zoo domain:</div>
   											<ul>
												<c:forEach items="${cluster.domains}" var="domain">
													<li>${domain} </li>
												</c:forEach>
											</ul>
											Most representive metamodel: ${cluster.mostRepresentive.name}<br/>
											KMax: ${cluster.kMax}<br/>
											KMin: ${cluster.kMin}<br/>
											KAvg: ${cluster.kAvg}
											
										</div>
									</th>
	   							</tr>				
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		<!-- if -->	

		<!-- End if -->
	</c:forEach>
	
	<div class="clearfix">	
	</div>
</div>



