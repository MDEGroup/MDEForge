
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


<h3>${type}s</h3>
<!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mi elit, laoreet ac turpis ac, vulputate lacinia turpis. Vestibulum eu augue massa. Curabitur a quam sed turpis pharetra finibus. In purus nulla, tristique eu pulvinar ut, lacinia ut ligula. Proin ac neque neque. Sed vitae egestas enim. </p> -->
<div class="innerLR">
	
	
	<div class="widget widget-heading-simple">
		<div class="widget-body">
		
			<!-- Table -->
			<table id="artList" class="responsive" width="100%">
				<thead>
					<tr>
						<th>Name</th>
						<th class="center">Author</th>
						<th class="center">Visibility</th>
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
			    	if(row.open){
                		return "<a href='${pageContext.request.contextPath}/public/${type}/artifact?artifact_id=" + row.id + "'>" + row.name + "</a>";
			    	}else{
			    		return "<span class='text-primary'>" + row.name + "</span>";
			    	}
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
			    "className": "center",
			    "render": function ( data, type, row, meta ) {
			    	if(row.open){
			    		return "<span class='text-success'>Public</span>";
			    	}else{
			    		return "<span class='text-error'>Private</span>";
			    	}
                	
                 }
			},
			{
				"data": "action",
			    "searchable": false,
			    "sortable": false,
			    "defaultContent": "",
			    "className": "center",
			    "render": function ( data, type, row, meta ) {
			    	if(row.open){
			    		return "<a href='${pageContext.request.contextPath}/public/${type}/download?artifact_id=" + row.id + "'>Download</a>";
			    	}
                	
                 }
			 },
			 
        ],
        "ajax": {
		    "url": "${pageContext.request.contextPath}/public/${type}/artifactsRest",
		}		
	});              
});
</script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/jquery.dataTables.js"></script>		