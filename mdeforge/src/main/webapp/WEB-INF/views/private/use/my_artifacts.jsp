<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="#" class="glyphicons dashboard"><i></i> Private Area</a></li>
		<li class="divider"></li>
		<li> Use</li>
		<li class="divider"></li>
		<li>My Artifacts</li>
</ul>
<!-- Breadcrumb END -->



<h3 class="header-h main-title">${Title}</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p>
	<div class="innerLR">
	<div class="widget widget-heading-simple">
		<div class="widget-body">
			<!-- Table -->
			<table id="artList">
				<thead>
					<tr>
						<th>Public</th>
						<th>Name</th>
						<th>Action</th>
						<th>Author</th>
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
		"columns":[
	                {
	                	"data":"open",
	                    "searchable": false,
	                    "sortable": false
	                },
	                {
	                    "data":"name",
	                    "searchable": false,
	                    "sortable": false
	                },
	                {
	                	"data": "action",
	                    "searchable": false,
	                    "sortable": false,
	                    "defaultContent": "",
	                    "render": function ( data, type, row, meta ) {
	                    	return "<a href='${pageContext.request.contextPath}/private/${type}/artifact?artifact_id=" + row.id + "'>Details</a>";
	                     }
	                 },
	                 {
	                	"data": "author.username",
	                    "searchable": false,
	                    "sortable": false
	                 }
        ],
        "ajax": {
		    "url": "${pageContext.request.contextPath}/private/${type}/artifactsRest",
		}		
	});              
});
</script>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>	