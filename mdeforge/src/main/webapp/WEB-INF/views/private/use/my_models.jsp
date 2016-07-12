<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="#" class="glyphicons dashboard"><i></i> Private Area</a></li>
		<li class="divider"></li>
		<li> Use</li>
		<li class="divider"></li>
		<li>My ${type}s</li>
</ul>
<!-- Breadcrumb END -->



<h3 class="header-h main-title">My ${type}s</h3>
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p> -->
	<div class="innerLR">
	<div class="widget widget-heading-simple">
		${all }
		<c:if test="${!all}">
			<a href="/mdeforge/private/${type}/artifactsWithGenerated" 
				class="btn btn-primary btn-block">Show with generated</a>
		</c:if>
	</div>
	<div class="widget widget-heading-simple">
		<div class="widget-body">
			<!-- Table -->
			<table id="artList" class="responsive" width="100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Conform to</th>
						<th class="center">Author</th>
						<th class="center">Public</th>
						<th class="center">Action</th>
						
					</tr>
				</thead>
			</table>
			<!-- // Table END -->
		</div>
	</div>
</div>	
<script>
$(document).ready(function () {
	$('#artList').dataTable({
		"processing": true,
		"serverSide": true,
		"filter" : false,
		"responsive": true,
		"language": {
		    "lengthMenu": "Show _MENU_ <span class='strong text-primary'>${type}s</span> per page",
		    "info": "_TOTAL_ <span class='strong text-primary'>${type}s</span> found",
		    "processing":'<img class="spinner" src="/mdeforge/resources/theme/images/spin.gif"></span>'
		},
		"columns":[
	                
	                {
	                    "data":"name",
	                    "searchable": false,
	                    "sortable": false,
	                    "render": function ( data, type, row, meta ) {
	                    	return "<a href='${pageContext.request.contextPath}/private/${type}/artifact?artifact_id=" + row.id + "'>" + row.name + "</a>";
	                     }
	                },
	                {
	                    "data":"metamodelArtifact",
	                    "searchable": false,
	                    "sortable": false,
	                    "render": function ( data, type, row, meta ) {
	                    	console.log(row);
	                    	return "<a href='${pageContext.request.contextPath}/private/EcoreMetamodel/artifact?artifact_id=" + row.metamodelArtifact.id + "'>" + row.metamodelArtifact.name + "</a>";
	                     }
	                },
	                {
	                	"data": "author.username",
	                    "searchable": false,
	                    "sortable": false,
	                    "className": "center"
	                 },
	                {
	                	"data":"open",
	                    "searchable": false,
	                    "sortable": false,
	                    "className": "center"
	                },
	                {
	                	"data": "action",
	                    "searchable": false,
	                    "sortable": false,
	                    "defaultContent": "",
	                    "className": "center",
	                    "render": function ( data, type, row, meta ) {
	                    	return "<a href='${pageContext.request.contextPath}/private/${type}/download?artifact_id=" + row.id + "'>Download</a>";
	                     }
	                 }
        ],
        "ajax": {
	    	"url": "${pageContext.request.contextPath}/private/${type}/artifactsRest"
		}		
	});              
});
</script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/jquery.dataTables.js"></script>	
<!-- <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script> -->