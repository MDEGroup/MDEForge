<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function MakeSelect2() {
		$('select').select2();
		$('.dataTables_filter').each(
				function() {
					$(this).find('label input[type=text]').attr('placeholder',
							'Search');
				});
	}

	$(document)
			.ready(
					function() {
						$('#workspace_datatable')
								.dataTable(
										{
											"bProcessing" : true,
											"bServerSide" : true,
											"sPaginationType" : "full_numbers",
											"sAjaxDataProp" : "rows",
											"aaSorting" : [ [ 0, "asc" ] ],
											"sDom" : "<'box-content'<'col-sm-6 text-left'l><'clearfix'>>rt<'box-content'<'col-sm-6'i><'col-sm-6 text-right'p><'clearfix'>>",
											"sPaginationType" : "bootstrap",
											"aoColumns" : [
													{
														"mData" : "id"
													},
													{
														"mData" : "name"
													},
													{
														"mData" : "description"
													},
													{
														"sName" : "id",
														"bSearchable" : false,
														"bSortable" : false,
														"sDefaultContent" : "",
														"fnRender" : function(oObj) {
															return "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/private/workspace?id="
															+ oObj.aData['id']
															+ "'><i class='fa fa-plus-square-o'></i></a>"
															+ "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/private/workspace/update?id="
															+ oObj.aData['id']
															+ "'><i class='fa fa-edit'></i></a>"
															+ "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/private/workspace/delete?id="
															+ oObj.aData['id']
															+ "'><i class='fa fa-trash-o'></i></a>";
														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/private/workspace/findelementspaginated",
											"oLanguage" : {
												"sSearch" : "",
												"sLengthMenu" : '_MENU_',
												"sUrl" : "${pageContext.request.contextPath}/resources/plugins/datatables/i18n/english.properties"
											},
											bAutoWidth : false,
											"fnServerParams" : addparams
										}).columnFilter({
									aoColumns : [ {
										type : "number"
									}, {
										type : "text"
									}, {
										type : "text"
									}, null ]
								});

						MakeSelect2();
					});
	
</script>


<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Workspaces</a></li>
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3><spring:message code="mdeforge.workspaces"/></h3>
	</div>
	<div class="col-xs-2 col-sm-1 col-sm-offset-1">
		<div id="social" class="row">
			<a href="#"><i class="fa fa-google-plus"></i></a>
			<a href="#"><i class="fa fa-facebook"></i></a>
			<a href="#"><i class="fa fa-twitter"></i></a>
			<a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-youtube"></i></a>
		</div>
	</div>
	<div class="clearfix visible-xs"></div>
	<div class="col-xs-12 col-sm-8 col-md-7 pull-right">
		<div class="row">
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-1"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>756.45M
					<span class="txt-primary">EBITDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-2"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>245.12M
					<span class="txt-info">OIBDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-3"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>107.83M
					<span>REVENUE</span>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-12"> 
		<a href="${pageContext.request.contextPath}/private/workspace/create"><button type="button" class="btn btn-success"><spring:message code="mdeforge.workspace.create.lowercase"/></button></a>
	</div>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-list"></i>
					<span></span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<table id="workspace_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable" >
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="workspaces_list" var="workspace">
   							<tr>
   								<td>
   								Y
	   							</td>
   								<td>
   								Y
	   							</td>
   								<td>
   								Y
	   							</td>
   								<td>
   								Y
	   							</td>
   								
   							</tr>							
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
