<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!-- <script	src="${pageContext.request.contextPath}/resources/theme/scripts/wordcloud2.js"></script>-->

<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<li>${artifact.getClass().getSimpleName() } Details</li>
</ul>
<!-- Breadcrumb END -->
<!-- Heading -->
<div class="innerLR">
<div class="row-fluid">
<div class="span9">
<div class="box-generic">
	<h3 class="header-h main-title" id="artifactName" data-id="${artifact.getId()}">${artifact.getName()}</h3>
	<!-- <h5 class="muted"><spring:message code="mdeforge.public.back.browse.metamodel_details.detail" /></h5>-->
	<h5 class="muted">${artifact.getClass().getSimpleName()} Details</h5>
	<hr>
	<h5 class="input-name">Used in <span class="text-primary">${artifact.getProjects().size()}</span> projects</h5>
	<div class="separator bottom"></div>
		<span class="text-primary" style="font-size: 16px">Creation Date</span>
		<h5><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getCreated()}" /></h5>
		<span class="text-primary" style="font-size: 16px">Last Modified</span>
		<h5><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${artifact.getModified()}" /></h5>
	<div class="separator bottom"></div>
	<c:if test="${artifact.getClass().getSimpleName()} == 'EcoreMetamodel'">
		<c:choose>
			<c:when test="${artifact.getUri().size() > 0}">
				<c:forEach items="${artifact.getUri()}" var="uri">
						<p><span class="text-primary">URI</span>: ${uri}</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
					<p class="text-error">It has not been assigned any URI</p>
			</c:otherwise>
		</c:choose>
	</c:if>
	<h5 class="input-name">Properties</h5>
	<ul>
	<c:forEach items="${artifact.properties}" var="property">
	<li>
		<p class="property-name-details text-primary">${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</p>
			<h5 class="property-value-details">${property.getValue()}</h5>
	</li>
	</c:forEach>
	</ul>
	<h5 class="input-name">Description</h5>
	<p>${artifact.description}</p>
	
</div>
</div>
<div class="span3 text-right">
<div class="box-generic">
<h5 class="input-name">Visibility</h5>
	<c:choose>
				<c:when test="${artifact.getOpen()}">	
				<span class="btn btn-success">	
							<span class="icon-cloud"><i></i></span> Public</span>						  												    
				</c:when>
				<c:otherwise>
				<span class="btn btn-danger">
						<span class="icon-lock"><i></i></span> Private</span>							  
				</c:otherwise>
			</c:choose>
	<div class="separator bottom"></div>
	<h5 class="input-name">Importer</h5>
	<!-- // Profile Photo END -->
	<ul class="icons-ul">
		<li>${artifact.getAuthor().getUsername()} <span class="icon-user text-primary"><i></i></span></li>
		<li class="text-black" style="font-size: 14px">${artifact.getAuthor().getFirstname()} ${artifact.getAuthor().getLastname()}</li>
		<li><a href="#">${artifact.getAuthor().getEmail()}</a> <span class="icon-envelope text-primary"><i></i></span></li>
	</ul>
</div>
</div>
</div>
</div>
<div class="innerLR">
	<div class="row-fluid">
			<div class="box-generic">
			<div class="span2">
				<a href="#modal-simple" class="widget-stats widget-stats-2" data-toggle="modal">
						<span class="count  icon-desktop text-info"><i></i></span>
						<span class="txt">Visualize ${artifact.getClass().getSimpleName()}</span>
					</a>
			</div>
			<div class="span2">
					<a href="#modal-simple" class="disabled-button widget-stats widget-stats-2" data-toggle="modal">
						<!-- <span class="count icon-code-fork"><i></i></span> -->
						<span class="count  icon-sitemap text-warning"><i></i></span>
						<span class="txt">Visualize Tree View</span>
					</a>
			</div>
			<div class="span2">
				<a href="${pageContext.request.contextPath}/private/${artifact.getClass().getSimpleName()}/download?artifact_id=${artifact.getId()}" class="widget-stats widget-stats-2">
						<span class="count icon-download-alt text-success"><i></i></span>
						<span class="txt">Download ${artifact.getClass().getSimpleName()}</span>
					</a>
			</div>
			<c:if test="${userId == artifact.getAuthor().getId()}">
			<div class="span2">
				<a href="${pageContext.request.contextPath}/private/artifact/delete?idArtifact=${artifact.getId()}" class="widget-stats widget-stats-2">
						<span class="count icon-remove text-error"><i></i></span>
						<span class="txt">Delete ${artifact.getClass().getSimpleName()}</span>
					</a>
			</div>
			</c:if>
				<div class="separator bottom"></div>
			</div>
	</div>
		<hr>
	<tiles:insertAttribute name="central" ignore="true"/>

	<div class="row-fluid">
	
				<div class="span8 tablet-column-reset">
				<div class="box-generic">
				<c:if test="${artifact.getMetrics().size()!=0}">
					<h5 class="input-name">Metrics</h5>
					<div class="separator bottom"></div>

					<table class="table table-striped table-white table-metrics">
						<thead>
							<tr>
								<th>Name</th>
								<!-- <th rowspan="2">Description</th>-->
								<th class="center">Value</th>
								<th>Max</th>
								<th>Min</th>
								<th>Avg</th>
								<th>Median</th>
								<th style="font-size: 12px;">Standard Deviation</th>
							</tr>
						</thead>
						<!-- // Table heading END -->
						<tbody>
							<c:forEach items="${artifact.getMetrics()}" var="metric">
								<!-- Table row -->
								<tr>

									<td class="left">${metric.getName()}</td>
									<!-- <td>${metric.getDescription()}</td>-->

									<c:choose>
										<c:when test="${metric.getClass().name == 'org.mdeforge.business.model.SimpleMetric'}">
											<td class="number-table">${metric.getValue()}</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</c:when>
										<c:when test="${metric.getClass().name == 'org.mdeforge.business.modelAggregatedRealMatric'}">
											<td></td>
											<td class="number-table">${metric.getMaximum()}</td>
											<td class="number-table">${metric.getMinimum()}</td>
											<td class="number-table">${metric.getAverage()}</td>
											<td class="number-table">${metric.getMedian()}</td>
											<td class="number-table">${metric.getStandardDeviation()}</td>
										</c:when>
										<c:otherwise>
											<td></td>
											<td class="number-table">${metric.getMaximum()}</td>
											<td class="number-table">${metric.getMinimum()}</td>
											<td class="number-table">${metric.getAverage()}</td>
											<td class="number-table">${metric.getMedian()}</td>
											<td class="number-table">${metric.getStandardDeviation()}</td>
										</c:otherwise>
									</c:choose>

								</tr>
								<!-- // Table row END -->
							</c:forEach>
						</tbody>
						<!-- End body -->
					</table>
				<div class="separator"></div>
				
				</c:if>
				<!-- Comments -->
				<h5 class="input-name">Comments</h5>
				<p>Share your opinion with other users. <a href="#" id="write-comment" class="text-primary ">Write a review</a></p>
				<div class="separator bottom"></div>
				
				<div id="comment-list">
				
							<c:forEach items="${artifact.comments}" var="comment">
							<div class="artifact-comment">
						<div class="widget-body">
							<div class="media">
								<div class="media-object pull-left thumb"><img src="/public/getPhoto?id=${comment.user.image}" style="width: 51px; height: 51px;"></div>
								<div class="media-body">
									<a href="#" class="author">${comment.user.getFirstname() } ${comment.user.getLastname()}</a><br>
									<span class="muted">${comment.user.username}</span>
								</div>
							</div>
							<div>
								<div class="rating text-faded read-only">
								<c:forEach end="5" begin="1" var="stars">
									<c:choose>
										<c:when test="${comment.star == (6-stars) }">
										<span class="star active"></span>
										</c:when>
										<c:otherwise>
										<span class="star"></span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
									
					        	
					       		 </div>
								<p class="">${comment.comment}</p>
							</div>
							
						</div>
					</div>
								
							</c:forEach>
				</div>
				<security:authorize access="isAuthenticated()">
						<div id="comment-box">
							<form action="${pageContext.request.contextPath}/public/EcoreMetamodel/comment" method="post" class="form-horizontal" id="comment-form">
							 	<input type="hidden" value="${artifact.id}" name="idArtifact"/>
								 	<div class="artifact-comment">
										<div class="widget-body">
											<div class="media">
												<div class="media-object pull-left thumb"><img src="/public/getPhoto?id=${logged_user.image}" style="width: 51px; height: 51px;"></div>
												<div class="media-body">
													<a href="#" class="author"><security:authentication property="principal.user.firstname"/> <security:authentication property="principal.user.lastname"/></a><br>
													<span class="muted"><security:authentication property="principal.user.username"/></span>
												</div>
											</div>
											<div>
												<div id="stars" class="c-rating"></div>
												<textarea type="text" value="" name="comment" placeholder="Write here your review..." id="comment-text"></textarea>
												<span id="error-message" class="text-error"></span>
											</div>
											<input id="submit-comment" type="submit" class="btn btn-primary" value="Send"/>
										</div>
									</div>
							 	
							</form>
						</div>
				</security:authorize>
				<!-- Comments end -->
				</div>
				</div>
			<!-- span4 shared users -->
			<tiles:insertAttribute name="right" ignore="true"/>
			</div>
		</div>


<c:import var="fileToVisualize"
	url="file:///${artifactFile.getAbsolutePath()}" />
<!-- Modal -->
<div class="modal modal-artifact hide fade" id="modal-simple">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3>${artifact.getName()}</h3>
	  </div>
	 	<pre class="prettyprint" style="margin: 0">
	 		<code class="xml" style="font-size: 16px;line-height: 22px;font-weight: 400;">
			${fn:escapeXml(fileToVisualize)}
			</code>
		</pre>
	  <div class="modal-footer center">
	    <a href="#" class="btn btn-large" data-dismiss="modal">Close</a>
	  </div>
	</div>
<!-- // Modal END -->

<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/shareArtifact.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/rating/js/dist/rating.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/highlight/highlight.pack.js"></script>
<script>
$(document).ready(function(){
	hljs.initHighlightingOnLoad();
	var stars_value = 0;
	var text = $("#comment-text");
	var list = $("#comment-list");
	var submit = $("#submit-comment");
	var message = $("#error-message");
	var stars = document.querySelector('#stars');
	// current rating, or initial rating
	var currentRating = 0;

	// max rating, i.e. number of stars you want
	var maxRating= 5;

	// callback to run after setting the rating
	var callback = function(rating) { stars_value=rating; };

	// rating instance
	var myRating = rating(stars, currentRating, maxRating, callback);
	
	$("#write-comment").click(function(e){
		e.preventDefault();
		$('#wrapper').animate({
			scrollTop: $("#comment-box").offset().top - $('#content').offset().top
		}, 400);
		text.focus();
	});
	
	$("#publicShareButton").click(shareArtifact);
	
	$("#comment-form").submit(function(e){
		var msg = "";
		message.empty();
		e.preventDefault();
		if(stars_value == 0){
			msg += "Please, set the number of stars for this artifact. "
		}
		if(text.val().length == 0){
			msg += "The comment is empty."
		}
		if(msg == ""){
			<security:authorize access="isAuthenticated()">
			InsertComment("${logged_user.getFirstname()} ${logged_user.getLastname()}", "${logged_user.username}", "/public/getPhoto?id=${logged_user.image}", text.val(), stars_value, "${artifact.id}")
			</security:authorize>
		}else{
			message.text(msg)
			return false;
		}
	})
	
	function InsertComment(autore, usern, immagine, testo, stelle, id){
		submit.addClass("disabled-button");
		$.ajax({
			method: "POST",
			url : ctx + "/public/${artifact.getClass().getSimpleName()}/comment",
			data: {
				comment: testo,
				star: stelle,
				idArtifact: "${artifact.getId()}"
			},
			success : function(eventData) {
				//alert(eventData)
				$("#comment-box").hide(500, function(){$(this).html('<p class="text-primary">Great! Your comment has been posted.</p>').show(500)});
				var result = "";
				for(var i = 1; i < 6; i++){
					if(i == stelle){
						result = '<span class="star active"></span>' + result;
					}else{
						result = '<span class="star"></span>' + result;
					}
				}
				var toRender = {
					author: autore,
					username: usern,
					image: immagine,
					text: testo,
					stars: result
				};
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/comment.html',
						function(template) {
							var rendered = Mustache.render(template, toRender);
							list.append(rendered);
				});
		},
		error: function(err){
			//alert(e)
			message.text("Ops. Something went wrong! Try Later.")
			submit.removeClass("disabled-button");
		}
		
		});
	}
	function InsertComment(autore, usern, immagine, testo, stelle, id){
		submit.addClass("disabled-button");
		$.ajax({
			method: "POST",
			url : ctx + "/public/${artifact.getClass().getSimpleName()}/comment",
			data: {
				comment: testo,
				star: stelle,
				idArtifact: "${artifact.getId()}"
			},
			success : function(eventData) {
				//alert(eventData)
				$("#comment-box").hide(500, function(){$(this).html('<p class="text-primary">Great! Your comment has been posted.</p>').show(500)});
				var result = "";
				for(var i = 1; i < 6; i++){
					if(i == stelle){
						result = '<span class="star active"></span>' + result;
					}else{
						result = '<span class="star"></span>' + result;
					}
				}
				var toRender = {
					author: autore,
					username: usern,
					image: immagine,
					text: testo,
					stars: result
				};
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/comment.html',
						function(template) {
							var rendered = Mustache.render(template, toRender);
							list.append(rendered);
				});
		},
		error: function(err){
			//alert(e)
			message.text("Ops. Something went wrong! Try Later.")
			submit.removeClass("disabled-button");
		}
		
		});
	}
	function shareArtifact(e){
		var button = $(this);
		button.addClass("disabled")
		console.log("${artifact.id}");
		$.ajax({
			url : ctx + "/public/${artifact.getClass().getSimpleName() }/share/?metamodel_id=" + "${artifact.id}",
			success : function(data) {
				console.log(data)
				button.remove()
				var count = $("#numberUser");
				var number = count.text();
				count.text(number++);
				<security:authorize access="isAuthenticated()">
				$("#users").append('<li class="userLi"><span class="glyphicons activity-icon user"><i></i></span><span class="title"><strong><security:authentication property="principal.user.firstname"/> <security:authentication property="principal.user.lastname"/></strong><br><security:authentication property="principal.user.username"/></span></li><p class="text-success">It is imported in Shared Artifact. You can see it at <a href="${pageContext.request.contextPath}/private/shared_artifacts">/private/shared_artifacts</a></p>')
				</security:authorize>
			},
			error : function error(data) {
				console.log('error');
				button.removeClass("disabled")
				
			}
		});
	}
	
});
</script>
