<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse"/></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse.metamodel_details.detail"/></li>
</ul>
<!-- Breadcrumb END -->





<!-- Heading -->
<div class="heading-buttons">
	<h3>${ecoreMetamodel.getName()} 
		<span>
			<c:choose>
				<c:when test="${ecoreMetamodel.getOpen()}">		
							Public Metamodel										  												    
				</c:when>						 
				<c:otherwise>
							Private Metamodel										  
				</c:otherwise>
			</c:choose> 		
		</span>
	</h3>
	<%-- <div class="buttons pull-right">
					
		<a href="${pageContext.request.contextPath}/#" class="btn btn-success btn-icon glyphicons download_alt"><i></i>Download Metamodel</a>			
	</div> --%>
	<div class="clearfix"></div>
</div>
<div class="separator bottom"></div>
<!-- // Heading END -->





<div class="innerLR">
	
	
	
	<div class="row-fluid">
		<div class="span9 tablet-column-reset">
		
			<div class="widget widget-heading-simple widget-body-white widget-employees">
					
				
				
				<div class="widget-body padding-none">
					
					<div class="row-fluid row-merge">
						
						<div class="span12 detailsWrapper">
							
							<div class="innerAll">
								<div class="title">
									<div class="row-fluid">
										<div class="span8">
											<h3 class="text-primary">Info</h3>
											<span class="muted">Artifact</span>
										</div>
										<div class="span4 text-right">
											<p class="muted">${ecoreMetamodel.getProjects().size()} projects <a href=""><i class="icon-circle-arrow-right"></i></a></p>
											<div class="margin-bottom-none progress progress-small count-outside"><div class="count">30%</div><div class="bar" style="width: 30%;"></div></div>
										</div>
									</div>
								</div>
								<hr/>
								<div class="body">
									<div class="row-fluid">
										<div class="span4 overflow-hidden">
											<h5 class="strong">Importer</h5>
											<!-- // Profile Photo END -->
											<ul class="icons-ul">
												<li><i class="icon-user icon-li icon-fixed-width"></i> ${ecoreMetamodel.getAuthor().getUsername()}</li>
												<li><i class="icon-info icon-li icon-fixed-width"></i> ${ecoreMetamodel.getAuthor().getFirstname()} ${ecoreMetamodel.getAuthor().getLastname()}</li>												
												<li><i class="icon-envelope icon-li icon-fixed-width"></i> ${ecoreMetamodel.getAuthor().getEmail()}</li>
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
															<td class="right"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ecoreMetamodel.getCreated()}" /></td>
														</tr>
														<!-- // Table row END -->
														
														<!-- Table row -->
														<tr>
															<td class="left">Last Modified</td>
															<td class="right"><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ecoreMetamodel.getModified()}" /></td>
														</tr>
														<!-- // Table row END -->																										
													</tbody>
													<!-- // Table body END -->
													
												</table>
											</div>
											
											
										</div>
										<div class="span8">
											<h5 class="strong">Description</h5>
											<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
											<div class="row-fluid">
												<div class="span4">
													<h5 class="strong">Metamodel File</h5>
													<a href="" class="btn btn-success btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> Download Metamodel</a>
													<!-- <a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> May</a>
													<a href="" class="btn btn-default btn-small btn-block"><i class="icon-download-alt icon-fixed-width"></i> April</a> -->
													<div class="separator bottom"></div>
												</div>
												<div class="span7 offset1">
													<h5 class="strong">Metrics</h5>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">100%</div><div class="bar" style="width: 100%;"></div><div class="add">HTML</div></div>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">90%</div><div class="bar" style="width: 90%;"></div><div class="add">CSS</div></div>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">93%</div><div class="bar" style="width: 93%;"></div><div class="add">jQuery</div></div>
													<div class="progress progress-mini progress-primary count-outside add-outside"><div class="count">79%</div><div class="bar" style="width: 79%;"></div><div class="add">PHP</div></div>
													<div class="progress progress-mini count-outside add-outside"><div class="count">20%</div><div class="bar" style="width: 20%;"></div><div class="add">WP</div></div>
													<div class="separator bottom"></div>
												</div>
											</div>
											<h5 class="text-uppercase strong text-primary"><i class="icon-group text-regular icon-fixed-width"></i> Shared Users <span class="text-lowercase strong padding-none">Team</span> <span class="text-lowercase padding-none">(${ecoreMetamodel.getShared().size()} people)</span></h5>
											<ul class="team">												
												<c:forEach items="${ecoreMetamodel.getShared()}" var="user" varStatus="count">
													<li><span class="crt">${count.count}</span><span class="strong">${user.getUsername()}</span><span class="muted">${user.getFirstname()} ${user.getLastname()}</span></li>
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
			
			
			<hr>
			
			<h4>Relations</h4>
			<table class="table table-bordered table-white">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Artifact</th>
						<th class="center">Similarity Value</th>
						<th>Artifact</th>
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>
					<c:forEach items="${ecoreMetamodel.relations}" var="relation">
						<!-- Table row -->
						<tr>
							<td>${relation.getFromArtifact().getName()}</td>
							<td class="center"><span class="badge badge-success"><fmt:formatNumber value="${relation.getValue()}" maxFractionDigits="2" /></span></td>
							<td>${relation.getToArtifact().getName()}</td>
						</tr>
						<!-- // Table row END -->
					</c:forEach>
			</table>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		</div>
		
		<div class="span3 tablet-column-reset">
			<!-- Latest Orders/List Widget -->
			<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
			
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons link"><i></i>URI</h4>					
				</div>
				<!-- // Widget Heading -->
				
				<div class="widget-body list">
					<table class="table table-condensed">
				
						<!-- Table body -->
						<tbody>
							<c:choose>
							 	<c:when test="${ecoreMetamodel.getUri().size() > 0}">
									   	<c:forEach items="${ecoreMetamodel.getUri()}" var="uri">
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
			<div class="widget widget-heading-simple widget-body-white" data-toggle="collapse-widget">
					
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons notes"><i></i>Properties</h4>
				</div>
				<!-- // Widget Heading END -->
				
				<div class="widget-body list">
					<table class="table table-condensed">
				
						<!-- Table body -->
						<tbody>
							
							<c:forEach items="${ecoreMetamodel.properties}" var="property">
							<tr>
								<td class="left"><b>${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</b></td>
								<td class="right">${property.getValue()}</td>
							</tr>
							</c:forEach>								
						</tbody>
						<!-- // Table body END -->
						
					</table>									
				</div>
			</div>
			<!-- // Widget END -->
			<!-- Widget -->
			<div class="widget widget-heading-simple widget-body-gray" data-toggle="collapse-widget">
					
				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons tags"><i></i>TAGS</h4>
				</div>
				<!-- // Widget Heading END -->
				
				<div class="widget-body list">
				
					<!-- List -->
					<ul>
						<li>
							<a href="">Tag 1</a>
							
						</li>
						<li>
							<a href="">Tag 2</a>
							
						</li>						
					</ul>
					<!-- // List END -->
					
				</div>
			</div>
			<!-- // Widget END -->			
			
			
						
		</div>
		
		
		
	</div>
	
	
	
	
	<div class="row-fluid">
	

		
		<!-- Column -->
		<div class="span12">
		
			<!-- Widget Scroll -->
			<div class="widget widget-scroll" data-scroll-height="219px">
				<div class="widget-head">
					<h4 class="heading">Large content scrollable box</h4>
				</div>
				<div class="widget-body">
					<pre class="prettyprint">
&lt;div class="box-generic"&gt;
	&lt;div class="slim-scroll" data-scroll-height="250px"&gt;
		&lt;h4&gt;Large content scrollable box&lt;/h4&gt;
		&lt;p&gt;Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tristique porttitor elit, faucibus convallis enim fringilla eu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed nibh nunc, egestas sit amet convallis ac, molestie vitae dui. Pellentesque placerat fermentum mauris, eu tempus dui egestas eget. Mauris sodales, lectus quis accumsan adipiscing, ante libero porta risus, eu posuere sapien magna a metus. Phasellus laoreet fermentum risus, sed congue nisl facilisis nec. Curabitur ullamcorper ultricies erat, non posuere ipsum adipiscing tincidunt. Vivamus molestie hendrerit odio at rutrum. Suspendisse porta ligula ac eros hendrerit bibendum. Integer quis metus est, eu accumsan enim.&lt;/p&gt;
		&lt;p&gt;Nam commodo imperdiet condimentum. Maecenas in orci odio, quis sagittis augue. Aenean eu nisl turpis. Etiam gravida risus vitae nunc porttitor vestibulum. Praesent ut lorem erat, accumsan ornare erat. Nam in magna magna, nec posuere mi. Curabitur semper mi sed dui ornare vel posuere magna imperdiet. Quisque id tellus ipsum. Maecenas accumsan velit id velit pulvinar tincidunt. Nullam in ante dui. Suspendisse ut orci lectus. Nulla in nunc nec enim interdum auctor. Etiam imperdiet volutpat porta. In bibendum, tortor suscipit facilisis eleifend, lectus lacus laoreet enim, non aliquam nisi justo sit amet leo.&lt;/p&gt;
		&lt;p&gt;Nunc sed dapibus diam. Suspendisse aliquam ultricies sem et semper. Nulla varius, purus ac sodales fermentum, velit sem scelerisque tellus, et hendrerit neque justo bibendum mauris. Etiam vel neque vel dolor aliquam dignissim non sit amet mauris. Ut purus ante, accumsan in venenatis eget, auctor sit amet quam. Morbi nibh quam, lacinia id porta et, pretium id arcu. Mauris justo justo, tincidunt a rhoncus sit amet, mattis id enim. Vivamus vehicula, mi ac dapibus aliquet, sapien metus dignissim odio, vel ornare elit nulla non quam. Suspendisse id ligula odio. Maecenas nunc massa, pharetra sit amet condimentum id, tempus suscipit nisl. Nulla facilisi.&lt;/p&gt;
		&lt;p&gt;Maecenas blandit libero a enim faucibus porta. Proin id mauris non lorem tristique dignissim. Duis hendrerit commodo lorem, ac pellentesque dolor sodales sed. Vivamus accumsan erat sed sem mollis facilisis. Praesent vel magna felis, quis convallis augue. Donec dictum, dolor in fermentum venenatis, est nunc fermentum nulla, at suscipit magna dolor a metus. Pellentesque malesuada pellentesque tellus, tristique eleifend dolor tempor vitae. Phasellus sed sem non massa varius mollis. Curabitur non suscipit nunc. Sed vel metus sapien, in pharetra nisi. In vel nibh et odio congue tristique. Praesent non eros purus. Aenean eleifend lacus iaculis tellus eleifend sodales. Cras auctor tellus ac dui vehicula pretium. Proin non ipsum a elit molestie sodales eu in nisi. In ac nulla tortor, sollicitudin imperdiet nisl.&lt;/p&gt;
	&lt;/div&gt;
&lt;/div&gt;
</pre>
				</div>
			</div>
			<!-- // Widget Scroll END -->

	
		</div>
		<!-- // Column END -->
		
	</div>
	
	
	
	
	
	
	
</div>	
	