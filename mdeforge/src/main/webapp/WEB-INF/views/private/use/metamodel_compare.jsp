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


<div class="separator"></div>
<div class="innerLR">
		<div class="row-fluid" style="background: url(/mdeforge/resources/theme/images/5.jpg) center center no-repeat;background-size: cover; height:200px"></div>
		<div class="separator"></div>
		<form id="form_compare" class="form-horizontal" action="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_compare" method="POST">
			<div class="row-fluid">
			
			<div class="span6">
				<input type="hidden" name="left_metamodel_id" value="">
				<input autocomplete="off" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search EcoreMetamodels">
		
			</div>
			<div class="span6">
				<input type="hidden" name="right_metamodel_id" value="">
				<input autocomplete="off" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search EcoreMetamodels">
			</div>
			</div>
					
				<button class="btn btn-primary" style="margin: 20px auto;padding: 15px 40px; display: block" name="compare" value="1">Compare Metamodels</button>
		</form>




<c:choose>
		<c:when test="${leftMetamodel != null && rightMetamodel != null}">
			
			<div class="separator"></div>

			<h3 class="header-h main-title center">Comparison Results</h3>
			<div class="separator"></div>
			<div class="separator"></div>
			<div class="row-fluid hidden-phone">
				<div class="span6"><h3 class="text-primary center">${leftMetamodel.getName()}</h3></div>
				<div class="span6"><h3 class="text-primary center">${rightMetamodel.getName()}</h3></div>
			</div>
			<div class="row-fluid">
							<div class="span6">
								<h3 class="text-primary center hidden-desktop hidden-tablet">${leftMetamodel.getName()}</h3>
								<div class="separator"></div>
								<span class="muted text-black">Ecore Metamodel</span>
								<h5 class="input-name">Importer</h5>
								<div class="widget">
									<div class="widget-body list products">
										<ul id="users" class="team">
											
											<!-- List item -->
											<li class="userLi" data-id="55ae5947d4c677485a267bca">
												<span class="glyphicons activity-icon user"><i></i></span>
												<span class="title">${leftMetamodel.getAuthor().getUsername()}<br><strong>${leftMetamodel.getAuthor().getFirstname()}
										${leftMetamodel.getAuthor().getLastname()}</strong></span>
												
												<!--  <span class="count crt">1</span>-->
											</li>
											<!-- // List item END -->
																								
										</ul>
									</div>
								</div>
								<h5 class="muted">Used in <strong class="text-black">${leftMetamodel.getProjects().size()}</strong> projects</h5>
								<h5 class="muted">Shared by <strong class="text-black">${leftMetamodel.getShared().size()}</strong> users</h5>
								<h5 class="input-name">Description</h5>
								<p>
								${leftMetamodel.description}
									<c:forEach items="${leftMetamodel.properties}"
										var="property">
										<c:if test="${property.getName() == 'Description '}">
												${property.getValue()}
											</c:if>
									</c:forEach>
								</p>
								<div class="separator"></div>
								<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=${leftMetamodel.getId()}"
											class="btn btn-primary btn-small"
											data-toggle="modal"><i
											class="icon-desktop icon-fixed-width" title="Visualize Metamodel"></i> </a> 
										<a href="#"
											class="btn btn-inverse btn-small"
											onclick="return false;"><i
											class="icon-sitemap icon-fixed-width" title="Visualize Tree View"></i> </a> 
										<a
											href="${pageContext.request.contextPath}/public/EcoreMetamodel/download?artifact_id=${leftMetamodel.getId()}"
											class="btn btn-success btn-small"><i
											class="icon-download-alt icon-fixed-width" title="Download Metamodel"></i> </a>
						<h5 class="input-name">URI</h5>
															<c:choose>
																<c:when test="${leftMetamodel.getUri().size() > 0}">
																	<c:forEach items="${leftMetamodel.getUri()}" var="uri">
																		<h5>${uri}</h5>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<h5 class="text-error">It has not been assigned any URI</h5>
																</c:otherwise>
															</c:choose>
							<h5 class="input-name">Properties</h5>
								<c:forEach items="${leftMetamodel.properties}" var="property">
									<p class="text-primary">${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</p>
										<h5 class="innerLR">${property.getValue()}</h5>
								</c:forEach>
							
							</div>
							<div class="span6 text-right">
								<h3 class="text-primary center hidden-desktop hidden-tablet">${rightMetamodel.getName()}</h3>
								<div class="separator"></div>
								<span class="muted text-black">Ecore Metamodel</span>
								<h5 class="input-name">Importer</h5>
								<div class="widget">
									<div class="widget-body list products">
										<ul id="users" class="team">
											
											<!-- List item -->
											<li class="userLi text-right" data-id="55ae5947d4c677485a267bca" style="border-left: none; border-right: 2px solid #ededed">
												
												<span class="title" style="padding-right: 16px;">${rightMetamodel.getAuthor().getUsername()}<br><strong>${rightMetamodel.getAuthor().getFirstname()}
										${rightMetamodel.getAuthor().getLastname()}</strong></span>
												<span class="glyphicons activity-icon user" style="padding: 12px"><i></i></span>
												<!--  <span class="count crt">1</span>-->
											</li>
											<!-- // List item END -->
																								
										</ul>
									</div>
								</div>
								<h5 class="muted">Used in <strong class="text-black">${rightMetamodel.getProjects().size()}</strong> projects</h5>
								<h5 class="muted">Shared by <strong class="text-black">${rightMetamodel.getShared().size()}</strong> users</h5>
															
																<h5 class="input-name">Description</h5>
															<p>
															${rightMetamodel.description }
																<c:forEach items="${rightMetamodel.properties}"
																	var="property">
																	<c:if test="${property.getName() == 'Description '}">
																			${property.getValue()}
																		</c:if>
																</c:forEach>
															</p>
															<div class="separator"></div>
															<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_details?metamodel_id=${rightMetamodel.getId()}"
																		class="btn btn-primary btn-small"
																		data-toggle="modal"><i
																		class="icon-desktop icon-fixed-width" title="Visualize Metamodel"></i> </a> 
																	<a href="#"
																		class="btn btn-inverse btn-small"
																		onclick="return false;"><i
																		class="icon-sitemap icon-fixed-width" title="Visualize Tree View"></i> </a> 
																	<a
																		href="${pageContext.request.contextPath}/public/EcoreMetamodel/metamodel_download?metamodel_id=${rightMetamodel.getId()}"
																		class="btn btn-success btn-small"><i
																		class="icon-download-alt icon-fixed-width" title="Download Metamodel"></i> </a>
								<h5 class="input-name">URI</h5>
															<c:choose>
																<c:when test="${rightMetamodel.getUri().size() > 0}">
																	<c:forEach items="${rightMetamodel.getUri()}" var="uri">
																		<h5>${uri}</h5>
																		
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<h5 class="text-error">It has not been assigned any URI</h5>
																</c:otherwise>
															</c:choose>
								<h5 class="input-name">Properties</h5>
								<c:forEach items="${rightMetamodel.properties}" var="property">
									<p class="text-primary">${fn:toUpperCase(fn:substring(property.getName(), 0, 1))}${fn:toLowerCase(fn:substring(property.getName(), 1,fn:length(property.getName())))}</p>
										<h5 class="innerLR">${property.getValue()}</h5>
								</c:forEach>		
							
							</div>
				</div>
				<hr class="separator">
				<div class="row-fluid">
							<div class="span12">
									
										<h5 class="input-name center">Similarity Relation</h5>
										<h5 class="center text-black"><span class="btn btn-success"><fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * similarityRelation.getValue()}" />%</span></h5>
										<div class="progress progress-primary">
											<div class="bar" style="width: ${100 -similarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator"></div>
										<h5 class="input-name center">Cosine Similarity</h5>
										<h5 class="center text-black"><span class="btn btn-success"><fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * cosineSimilarityRelation.getValue()}" />%</span></h5>
										<div class="progress  progress-primary">
											<div class="bar" style="width: ${100 - cosineSimilarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator"></div>
										<%-- <h5 class="strong">Cosine Similarity</h5>
										<div class="progress progress-mini progress-primary count-outside add-outside">
											<div class="count">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * cosineSimilarityRelation.getValue()}" />%
											</div>
											<div class="bar" style="width: ${100 - cosineSimilarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator bottom"></div> --%>
										
										<h5 class="input-name center">Dice Similarity</h5>
										<h5 class="center text-black"><span class="btn btn-success"><fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * diceSimilarityRelation.getValue()}" />%</span></h5>
										<div class="progress  progress-primary">
											<div class="bar" style="width: ${100 - diceSimilarityRelation.getValue() * 100}%;"></div>
										</div>
										<div class="separator"></div>
										
										<h5 class="input-name center">Containment Similarity</h5>
										<h5 class="center text-black"><span class="btn btn-success"><fmt:formatNumber type="number" maxFractionDigits="3" value="${100 - 100 * containmentRelation.getValue()}" />%</span></h5>
										<div class="progress progress-primary">
											<div class="bar" style="width: ${100 - containmentRelation.getValue() * 100}%;"></div>
											</div>
										
									</div>
									<div class="clearfix"></div>
									<div class="separator"></div>
									<h5 class="input-name center ">Metrics</h5>
										<table class="table table-striped table-white">
											<thead>
												<tr>
													<th class="span4 center text-primary">${leftMetamodel.getName()}</th>
													<th class="span4 center"></th>
													<th class="span4 center text-primary">${rightMetamodel.getName()}</th>
												</tr>
											</thead>
											<tbody>
												<!--  foreacbh metric -->
												<c:forEach items="${leftMetamodel.getMetrics()}" var="metric" varStatus="i">
												<tr>
													<td class="center number-table"><fmt:formatNumber type="number" maxFractionDigits="3" value="${metric.getValue()}" /></td>
													<td class="center"><strong class="text-black">${metric.getName() }</strong></td>
													<td class="center number-table"><fmt:formatNumber type="number" maxFractionDigits="3" value="${rightMetamodel.metrics[i.index].getValue()}" /></td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
							
			
							</div>
						</div>
					<a href="${pageContext.request.contextPath}/private/EcoreMetamodel/metamodel_compare" class="btn btn-default" style="width: 250px;; margin: 20px auto;padding: 15px 20px; display: block">Compare two more Metamodels</a>	
		</c:when>
</c:choose>





</div>

<script>
/* SELECT AJAX INITIALIZATION*/
var delay = null;
$(document).ready(function(){
	initSelects($('.my-select'));
})


function initSelects(select){
	//select is a text input
	select.each(function(e){
		$(this).after('<div class="my-select-control"><div class="my-select-dropdown">' + 
						'<div id="select-content" class="my-select-content">' + 
		                '</div></div></div>');
		var next = $(this).next();
		var prev = $(this).prev();
		$(this).data("target", next);
		$(this).data("input", prev);
		$(this).data("content", next.find("#select-content"))
	});
}

/* MY SELECT EVENTS */
$("body").on("mousedown", ".my-select-item", function(e){
	e.preventDefault();
	var input = $(this).closest(".my-select-control").prev();
	
	input
		.data("id", $(this).data("id"))
		.data("name", $(this).data("name"))
		.val($(this).data("name"))
		.blur()
	
	var value = input.data("input");
	value.val($(this).data("id"));
})


$('body').on("focus", ".my-select", function(){
	$(this).removeClass("input-error").attr("placeholder", "Search EcoreMetamodels");
	$(this).data("target").addClass("dropdown-open");
})
.on("blur", ".my-select", function(){
	$(this).data("target").removeClass("dropdown-open")
})
.on("keyup", ".my-select", function(){
	if (delay !== null) {
        clearTimeout(delay);
    }
	var type = $(this).data("type");
	var project = $(this).data("project");
	var that = $(this);
	delay = setTimeout(
			function(){
				if(that.val().length > 0)
					getMetamodels(type, project, that)
	}, 500)
})

function getMetamodels(typeArtifact, project, input){
	//project is to ignore artifacts for that project
	//if project is null all artifacts will be retrived
	//typeArtifact can be "EcoreMetamodel", "ATLTransformation", "Model"
	//input is the html element
	var select = input.data("content");
	var query = input.val();
	select.html('<div class="my-select-item-info">' +
            '<span class="by loagind-select text-primary">Loading...</span>' +
    '</div>');
	$.ajax({
	    type: "POST",
	    url: ctx + '/public/searchArtifact',
	    data: {
        	search_string: query,
        	id_project: project,
        	type: typeArtifact,
        	limit: 50
        },
	    dataType:'json',
	    success: function(data) {
	    	console.log(data)
	    	var options = '';  
			if(data.length > 0){
				data.forEach(function(item, index, array){
			    	   options += '<div class="my-select-item" data-id="'+ item.id +'" data-name="'+ item.name +'">' +
				                '<h5 class="text-black strong">' + escape(item.name) + '</h5>' +
				                    '<span class="by">' + escape(item.author.username) + '</span>' +
				            '</div>';              
			       }); 
			}
			else{
				options = '<div class="my-select-item-info"><span class="by text-primary">No result found.</span></div>';
			}
			select.html(options);
	    },
	    error: function(res){
	    	console.log(res);
	    	select.html('<div class="my-select-item-info"><span class="by text-error">Ops. Something went wrong. Try Again</span></div>');
	    }
	});
}

$('#form_compare').submit(function(e){
	debugger;
	var valid = true;
	var select = $('.my-select');
	var  meta_id_l = $(select[0]).data("id");
	var input_id_l = $(select[0]).prev().val();
	var meta_name_l = $(select[0]).data("name");
	var  meta_id_r = $(select[1]).data("id");
	var input_id_r = $(select[1]).prev().val();
	var meta_name_r = $(select[1]).data("name");
	//when input is null
	if(meta_id_l === "undefined" || $(select[0]).val().length == 0 || input_id_l == ""){
		//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
		$(select[0]).addClass("input-error").attr("placeholder", "No Metamodel Selected");
		valid = false;
	}
	if(meta_id_r === "undefined" || $(select[1]).val().length == 0 || input_id_r == ""){
		//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
		$(select[1]).addClass("input-error").attr("placeholder", "No Metamodel Selected");
		valid = false;
	}
	//when input has been edited
	if(meta_id_l != input_id_l || meta_name_l === "undefined" || $(select[0]).val() != meta_name_l){
		//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
		$(select[0]).val("").addClass("input-error").attr("placeholder", "Invalid Input");
		valid = false;
	}
	if(meta_id_r != input_id_r || meta_name_r === "undefined" || $(select[1]).val() != meta_name_r){
		//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
		$(select[1]).val("").addClass("input-error").attr("placeholder", "Invalid Input");
		valid = false;
	}
	if(valid){
		return true;
	}else{
		e.preventDefault();
	}
});
</script>


