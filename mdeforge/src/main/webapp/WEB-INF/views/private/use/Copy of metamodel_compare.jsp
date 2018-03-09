<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li>You are here</li>
	<li><a href="#" class="glyphicons dashboard"><i></i> Private Area</a></li>
	<li class="divider"></li>
	<li>Use</li>
	<li class="divider"></li>
	<li>Metamodels Compare</li>
</ul>
<!-- Breadcrumb END -->


<h3 class="header-h main-title">Metamodels Compare</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p>



<div class="innerLR">


<div class="widget widget-heading-simple widget-body-white">


	<div class="widget-body">
		<form action="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_compare" method="POST">
			<div class="row-fluid">
				<div class="span5">
					<h5 class="input-name center">First Metamodel to compare</h5>
					<select class="span12" name="left_metamodel_id">
						<c:forEach items="${ecoreMetamodelList}" var="metamodel">
							<option value="${metamodel.getId()}">${metamodel.getName()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="span2">
					<button class="btn btn-block btn-primary" style="margin-top: 30px;padding: 20px 10px;" name="compare" value="1">Compare Metamodels</button>
				</div>
				<div class="span5">
				<h5 class="input-name center">Second Metamodel to compare</h5>
					<select class="span12" name="right_metamodel_id">
											<c:forEach items="${ecoreMetamodelList}" var="metamodel">
												<option value="${metamodel.getId()}">${metamodel.getName()}</option>
											</c:forEach>
					</select>
				</div>
			</div>
		</form>
	</div>
</div>




<c:choose>
		<c:when test="${leftMetamodel != null && rightMetamodel != null}">
			
			<hr>

			<div class="widget widget-heading-simple widget-body-white">
				<!-- Widget Heading -->
				<div class="widget-head">
					<h3 class="heading glyphicons show_thumbnails">
						<i></i>Comparison Result
					</h3>
				</div>
				<!-- // Widget Heading END -->
			
			
				<div class="widget-body">
						<div class="row-fluid">
							<div class="span4">
							
							
								<div class="widget widget-heading-simple widget-body-white widget-employees">
								<div class="widget-body padding-none">
				
									<div class="row-fluid row-merge">
				
										<div class="span12 detailsWrapper">
				
											<div class="innerAll">
												<div class="title">
													<div class="row-fluid">
														<div class="span8">
															<h3 class="text-primary">${leftMetamodel.getName()}</h3>
															<br>
															<span class="muted"><i>Ecore Metamodel</i></span>
														</div>
														<div class="span4 text-right">
															<p class="muted">
																Used in ${leftMetamodel.getProjects().size()} projects <a href=""><i class="icon-circle-arrow-right"></i></a>
															</p>
														</div>
													</div>
												</div>
												<hr />
												<div class="body">
													<div class="row-fluid">
														<div class="span4 overflow-hidden">
															<h5 class="strong">Importer</h5>
															<!-- // Profile Photo END -->
															<ul class="icons-ul">
																<li><i class="icon-user icon-li icon-fixed-width"></i>
																	${leftMetamodel.getAuthor().getUsername()}</li>
																<li><i class="icon-info icon-li icon-fixed-width"></i>
																	${leftMetamodel.getAuthor().getFirstname()}
																	${leftMetamodel.getAuthor().getLastname()}</li>
																<li><i class="icon-envelope icon-li icon-fixed-width"></i>
																	${leftMetamodel.getAuthor().getEmail()}</li>
															</ul>
															<div class="separator bottom"></div>
															<h5 class="strong">General</h5>
															<!-- Profile Photo -->
															<div class="center">
																<table class="table table-condensed">
																	<!-- Table body -->
																	<tbody>
																		<!-- Table row -->
																		<tr>
																			<td class="left">Creation Data</td>
																			<td class="right"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${leftMetamodel.getCreated()}" /></td>
																		</tr>
																		<!-- // Table row END -->
				
																		<!-- Table row -->
																		<tr>
																			<td class="left">Last Modified</td>
																			<td class="right"><fmt:formatDate type="both"
																					dateStyle="short" timeStyle="short"
																					value="${leftMetamodel.getModified()}" /></td>
																		</tr>
																		<!-- // Table row END -->
																	</tbody>
																	<!-- // Table body END -->
				
																</table>
															</div>
														</div>
														<div class="span8">
															<h5 class="strong">Description</h5>
															<p>
																<c:forEach items="${leftMetamodel.properties}"
																	var="property">
																	<c:if test="${property.getName() == 'Description '}">
																			${property.getValue()}
																		</c:if>
																</c:forEach>
															</p>
															<div class="row-fluid">
																<div class="span4">
																	<h5 class="strong">Metamodel File</h5>
																	<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${leftMetamodel.getId()}"
																		class="btn btn-primary btn-small btn-block"
																		data-toggle="modal"><i
																		class="icon-eye-open icon-fixed-width"></i> Visualize Metamodel</a> 
																	<a href="#"
																		class="btn btn-default btn-small btn-block"
																		onclick="return false;"><i
																		class="icon-eye-open icon-fixed-width"></i> Visualize Tree View</a> 
																	<a
																		href="${pageContext.request.contextPath}/public/EcoreMetamodel/download?artifact_id=${leftMetamodel.getId()}"
																		class="btn btn-success btn-small btn-block"><i
																		class="icon-download-alt icon-fixed-width"></i> Download Metamodel</a>
																	<!-- <a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> May</a>
																	<a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> April</a> -->
																	<div class="separator bottom"></div>
																</div>
																<div class="span1"></div>
																<div class="span6">
																	<h5 class="text-uppercase strong text-primary">
																		<i class="icon-group text-regular icon-fixed-width"></i>
																		Shared Users <span
																			class="text-lowercase strong padding-none">Team</span> <span
																			class="text-lowercase padding-none">(${leftMetamodel.getShared().size()} people)
																		</span>
																	</h5>
																	<ul class="team">
																		<c:forEach items="${leftMetamodel.getShared()}" var="user" varStatus="count">
																			<li><span class="crt">${count.count}</span>
																				<span class="strong">${user.getUsername()}</span>
																				<span class="muted">${user.getFirstname()}${user.getLastname()}</span>
																			</li>
																		</c:forEach>
																	</ul>
																</div>
															</div>
				
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
				
								</div>
							</div>
							
							
							<div class=" tablet-column-reset">
											<!-- Latest Orders/List Widget -->
											<div class="widget widget-heading-simple widget-body-gray"
												data-toggle="collapse-widget">
								
												<!-- Widget Heading -->
												<div class="widget-head">
													<h4 class="heading glyphicons link">
														<i></i>URI
													</h4>
												</div>
												<!-- // Widget Heading -->
								
												<div class="widget-body list">
													<table class="table table-condensed">
								
														<!-- Table body -->
														<tbody>
															<c:choose>
																<c:when test="${leftMetamodel.getUri().size() > 0}">
																	<c:forEach items="${leftMetamodel.getUri()}" var="uri">
																		<tr>
																			<td class="center">${uri}</td>
																		</tr>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<tr>
																		<td class="center">It has not been assigned any URI</td>
																	</tr>
																</c:otherwise>
															</c:choose>
								
														</tbody>
														<!-- // Table body END -->
								
													</table>
												</div>
											</div>
											<!-- // Latest Orders/List Widget END -->
								
								
								
								
											<!-- Widget -->
											<div class="widget widget-heading-simple widget-body-white">
								
												<!-- Widget Heading -->
												<div class="widget-head">
													<h4 class="heading glyphicons notes"><i></i>Properties</h4>
												</div>
												<!-- // Widget Heading END -->
								
												<div class="widget-body list">
													<table class="table">
								
														<!-- Table body -->
														<tbody>
								
															<c:forEach items="${leftMetamodel.properties}" var="property">
								
																<tr>
																	<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
																	<td class="">										
																		 <c:choose>
																		  <c:when test="${fn:length(property.getValue()) < 40}">
																		    	<span data-toggle="tooltip" data-original-title="${property.getValue()}" data-placement="left" >${property.getValue()}</span>
																		  </c:when>										  
																		  <c:otherwise>
																		  
																			<span data-toggle="tooltip" data-original-title="${property.getValue()}" data-placement="left" style="font-size:80%;">${fn:replace(property.getValue(), '/', '/ ')}</span>										
																		  </c:otherwise>
																		</c:choose> 
																	</td>
																</tr>
															</c:forEach>
														</tbody>
														<!-- // Table body END -->
								
													</table>
												</div>
											</div>
								
											
										</div>
							
							
							
							
							</div>
							<div class="span4">
									
										<h5 class="strong">Similarity Relation</h5>
										<div class="progress progress-mini progress-primary count-outside add-outside">
											<div class="count">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * similarityRelation.getValue()}" />%
											</div>
											<div class="bar" style="width: ${100 -similarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator bottom"></div>
										
										<h5 class="strong">Cosine Similarity</h5>
										<div class="progress progress-mini progress-primary count-outside add-outside">
											<div class="count">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * cosineSimilarityRelation.getValue()}" />%
											</div>
											<div class="bar" style="width: ${100 - cosineSimilarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator bottom"></div>
										
										<h5 class="strong">Dice Similarity</h5>
										<div class="progress progress-mini progress-primary count-outside add-outside">
											<div class="count">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * diceSimilarityRelation.getValue()}" />%
											</div>
											<div class="bar" style="width: ${100 - diceSimilarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator bottom"></div>
										
										<h5 class="strong">Containment Similarity</h5>
										<div class="progress progress-mini progress-primary count-outside add-outside">
											<div class="count">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * containmentRelation.getValue()}" />%
											</div>
											<div class="bar" style="width: ${100 - containmentRelation.getValue() * 100}%;"></div>
											</div>
										<div class="separator bottom"></div>
										
										<!--  foreacbh metric -->
										<c:forEach items="${leftMetamodel.getMetrics()}" var="metric" varStatus="i">
											<h5 class="strong">${metric.getName() }</h5>
										

											<div class="progress progress-mini progress-primary count-outside add-outside">
												
												<div class="count">
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${metric.getValue()}" />
												</div>
												<div class="bar" style="width:${metric.getValue() * 100/(metric.getValue()+rightMetamodel.metrics[i.index].getValue())}%;"></div>
												<div class="add">
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${rightMetamodel.metrics[i.index].getValue()}" />
												</div>
											</div>	
										</c:forEach>
			 				</div>
							<div class="span4">
								
									<div class="widget widget-heading-simple widget-body-white widget-employees">
								<div class="widget-body padding-none">
				
									<div class="row-fluid row-merge">
				
										<div class="span12 detailsWrapper">
				
											<div class="innerAll">
												<div class="title">
													<div class="row-fluid">
														<div class="span8">
															<h3 class="text-primary">${rightMetamodel.getName()}</h3>
															<br>
															<span class="muted"><i>Ecore Metamodel</i></span>
														</div>
														<div class="span4 text-right">
															<p class="muted">
																Used in ${rightMetamodel.getProjects().size()} projects <a href=""><i class="icon-circle-arrow-right"></i></a>
															</p>
														</div>
													</div>
												</div>
												<hr />
												<div class="body">
													<div class="row-fluid">
														<div class="span4 overflow-hidden">
															<h5 class="strong">Importer</h5>
															<!-- // Profile Photo END -->
															<ul class="icons-ul">
																<li><i class="icon-user icon-li icon-fixed-width"></i>
																	${rightMetamodel.getAuthor().getUsername()}</li>
																<li><i class="icon-info icon-li icon-fixed-width"></i>
																	${rightMetamodel.getAuthor().getFirstname()}
																	${rightMetamodel.getAuthor().getLastname()}</li>
																<li><i class="icon-envelope icon-li icon-fixed-width"></i>
																	${rightMetamodel.getAuthor().getEmail()}</li>
															</ul>
															<div class="separator bottom"></div>
															<h5 class="strong">General</h5>
															<!-- Profile Photo -->
															<div class="center">
																<table class="table table-condensed">
																	<!-- Table body -->
																	<tbody>
																		<!-- Table row -->
																		<tr>
																			<td class="left">Creation Data</td>
																			<td class="right"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${rightMetamodel.getCreated()}" /></td>
																		</tr>
																		<!-- // Table row END -->
				
																		<!-- Table row -->
																		<tr>
																			<td class="left">Last Modified</td>
																			<td class="right"><fmt:formatDate type="both"
																					dateStyle="short" timeStyle="short"
																					value="${rightMetamodel.getModified()}" /></td>
																		</tr>
																		<!-- // Table row END -->
																	</tbody>
																	<!-- // Table body END -->
				
																</table>
															</div>
														</div>
														<div class="span8">
															<h5 class="strong">Description</h5>
															<p>
																<c:forEach items="${rightMetamodel.properties}"
																	var="property">
																	<c:if test="${property.getName() == 'Description '}">
																			${property.getValue()}
																		</c:if>
																</c:forEach>
															</p>
															<div class="row-fluid">
																<div class="span4">
																	<h5 class="strong">Metamodel File</h5>
																	<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_details?metamodel_id=${rightMetamodel.getId()}"
																		class="btn btn-primary btn-small btn-block"
																		data-toggle="modal"><i
																		class="icon-eye-open icon-fixed-width"></i> Visualize Metamodel</a> 
																	<a href="#"
																		class="btn btn-default btn-small btn-block"
																		onclick="return false;"><i
																		class="icon-eye-open icon-fixed-width"></i> Visualize Tree View</a> 
																	<a
																		href="${pageContext.request.contextPath}/public/EcoreMetamodel/metamodel_download?metamodel_id=${rightMetamodel.getId()}"
																		class="btn btn-success btn-small btn-block"><i
																		class="icon-download-alt icon-fixed-width"></i> Download
																		Metamodel</a>
																	<!-- <a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> May</a>
																	<a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> April</a> -->
																	<div class="separator bottom"></div>
																</div>
																<div class="span1"></div>
																<div class="span6">
																	<h5 class="text-uppercase strong text-primary">
																		<i class="icon-group text-regular icon-fixed-width"></i>
																		Shared Users <span
																			class="text-lowercase strong padding-none">Team</span> <span
																			class="text-lowercase padding-none">(${rightMetamodel.getShared().size()} people)
																		</span>
																	</h5>
																	<ul class="team">
																		<c:forEach items="${rightMetamodel.getShared()}" var="user" varStatus="count">
																			<li><span class="crt">${count.count}</span>
																				<span class="strong">${user.getUsername()}</span>
																				<span class="muted">${user.getFirstname()}${user.getLastname()}</span>
																			</li>
																		</c:forEach>
																	</ul>
																</div>
															</div>
				
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
				
								</div>
							</div>
							
							
							<div class=" tablet-column-reset">
											<!-- Latest Orders/List Widget -->
											<div class="widget widget-heading-simple widget-body-gray"
												data-toggle="collapse-widget">
								
												<!-- Widget Heading -->
												<div class="widget-head">
													<h4 class="heading glyphicons link">
														<i></i>URI
													</h4>
												</div>
												<!-- // Widget Heading -->
								
												<div class="widget-body list">
													<table class="table table-condensed">
								
														<!-- Table body -->
														<tbody>
															<c:choose>
																<c:when test="${rightMetamodel.getUri().size() > 0}">
																	<c:forEach items="${rightMetamodel.getUri()}" var="uri">
																		<tr>
																			<td class="center">${uri}</td>
																		</tr>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<tr>
																		<td class="center">It has not been assigned any URI</td>
																	</tr>
																</c:otherwise>
															</c:choose>
								
														</tbody>
														<!-- // Table body END -->
								
													</table>
												</div>
											</div>
											<!-- // Latest Orders/List Widget END -->
								
								
								
								
											<!-- Widget -->
											<div class="widget widget-heading-simple widget-body-white">
								
												<!-- Widget Heading -->
												<div class="widget-head">
													<h4 class="heading glyphicons notes"><i></i>Properties</h4>
												</div>
												<!-- // Widget Heading END -->
								
												<div class="widget-body list">
													<table class="table">
								
														<!-- Table body -->
														<tbody>
								
															<c:forEach items="${rightMetamodel.properties}" var="property">
								
																<tr>
																	<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
																	<td class="">										
																		 <c:choose>
																		  <c:when test="${fn:length(property.getValue()) < 40}">
																		    	<span data-toggle="tooltip" data-original-title="${property.getValue()}" data-placement="left" >${property.getValue()}</span>
																		  </c:when>										  
																		  <c:otherwise>
																		  
																			<span data-toggle="tooltip" data-original-title="${property.getValue()}" data-placement="left" style="font-size:80%;">${fn:replace(property.getValue(), '/', '/ ')}</span>										
																		  </c:otherwise>
																		</c:choose> 
																	</td>
																</tr>
															</c:forEach>
														</tbody>
														<!-- // Table body END -->
								
													</table>
												</div>
											</div>
								
											
										</div>
							
							
							
							
							</div>
			
							</div>
						</div>
				</div>
			</div>
		</c:when>
</c:choose>





</div>




