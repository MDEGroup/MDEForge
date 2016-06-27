
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li><spring:message code="mdeforge.public.back.browse.breadcrumbs.you_are_here"/></li>
		<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message code="mdeforge.public.back.browse.breadcrumbs.public_area"/></a></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse"/></li>
		<li class="divider"></li>
		<li><spring:message code="mdeforge.public.back.browse.list"/></li>
</ul>
<!-- Breadcrumb END -->


<h3>${Title}</h3>
<div class="innerLR">

	
	<div class="widget widget-heading-simple widget-body-gray">
		<div class="widget-body">
		
			<!-- Table -->
			<table id="artList">
				<thead>
					<tr>
						<th>First Column</th>
						<th>Second Column</th>
						<th>Action</th>
						<th>Author</th>
					</tr>
				</thead>
				<tbody></tbody>			
			</table>
			<!-- // Table END -->
			
		</div>
	</div>
	
</div>	
<script>
$(document).ready(function () {
	$('#artList').dataTable({
		"sorting": [[ 0, "asc" ]],
		"processing": true,
		"serverSide": true,
		"filter" : false,
		"columns":[
	                {"data":"id"},
	                {"data":"name"},
	                {"data": "action",
	                    "searchable": false,
	                    "sortable": false,
	                    "defaultContent": "",
	                    "render": function ( data, type, row, meta ) {
	                    	return "<a href='${pageContext.request.contextPath}/public/${type}/artifact?artifact_id=" + row.id + "'>Details</a>";
	                     }
	                 },
	                 {"data": "author.username"}
	                
        ],
        "ajax": {
		    "url": "${pageContext.request.contextPath}/public/EcoreMetamodel/artifactsRest",
		}		
	});              
});
</script>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>	