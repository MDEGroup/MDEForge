<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
						$('#metamodels_datatable')
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
														"mData" : "name"
													},
													{
														"mData" : "description"
													},
													{
														"mData" : "uri"
													},
													{
														"sName" : "name",
														"bSearchable" : false,
														"bSortable" : false,
														"sDefaultContent" : "",
														"fnRender" : function(
																oObj) {
															return "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/metamodel/update?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-edit'></i></a>"
																	+ "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/metamodel/delete?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-trash-o'></i></a>";
														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/project/findmetamodelspaginated",
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

						$('#models_datatable')
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
														"mData" : "name"
													},
													{
														"mData" : "description"
													},
													{
														"mData" : "uri"
													},
													{
														"sName" : "name",
														"bSearchable" : false,
														"bSortable" : false,
														"sDefaultContent" : "",
														"fnRender" : function(
																oObj) {
															return "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/model/update?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-edit'></i></a>"
																	+ "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/model/delete?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-trash-o'></i></a>";
														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/project/findmodelspaginated",
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

						$('#transformations_datatable')
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
														"mData" : "name"
													},
													{
														"mData" : "description"
													},
													{
														"mData" : "uri"
													},
													{
														"sName" : "name",
														"bSearchable" : false,
														"bSortable" : false,
														"sDefaultContent" : "",
														"fnRender" : function(
																oObj) {
															return "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/transformation/update?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-edit'></i></a>"
																	+ "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/transformation/delete?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-trash-o'></i></a>";
														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/project/findtransformationspaginated",
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

						$('#editors_datatable')
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
														"mData" : "name"
													},
													{
														"mData" : "description"
													},
													{
														"mData" : "uri"
													},
													{
														"sName" : "name",
														"bSearchable" : false,
														"bSortable" : false,
														"sDefaultContent" : "",
														"fnRender" : function(
																oObj) {
															return "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/editor/update?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-edit'></i></a>"
																	+ "<a class=\"col-xs-3\" href='${pageContext.request.contextPath}/project/editor/delete?name="
																	+ oObj.aData['name']
																	+ "'><i class='fa fa-trash-o'></i></a>";
														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/project/findeditorspaginated",
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

						// Make all select2
						MakeSelect2();

						// Make all JS-activity for dashboard
						DashboardTabChecker();

					});
</script>


<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Workspace</a></li>
			<li><a href="#">Project</a></li>
			<li><a href="#">Artifacts</a></li>
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3>
			<spring:message code="mdeforge.project" />
			, ${projectname}
		</h3>
	</div>
	<div class="col-xs-2 col-sm-1 col-sm-offset-1">
		<div id="social" class="row">
			<a href="#"><i class="fa fa-google-plus"></i></a> <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a> <a href="#"><i class="fa fa-youtube"></i></a>
		</div>
	</div>
	<div class="clearfix visible-xs"></div>
	<div class="col-xs-12 col-sm-8 col-md-7 pull-right">
		<div class="row">
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-1">
					<canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas>
				</div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>756.45M <span class="txt-primary">EBITDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-2">
					<canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas>
				</div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>245.12M <span class="txt-info">OIBDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-3">
					<canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas>
				</div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>107.83M <span>REVENUE</span>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row-fluid">
	<div id="dashboard_links" class="col-xs-12 col-sm-2 pull-right">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#" class="tab-link" id="metamodels"><spring:message code="mdeforge.menu.metamodels" /></a></li>
			<li><a href="#" class="tab-link" id="models"><spring:message code="mdeforge.menu.models" /></a></li>
			<li><a href="#" class="tab-link" id="transformations"><spring:message code="mdeforge.menu.transformations" /></a></li>
			<li><a href="#" class="tab-link" id="editors"><spring:message code="mdeforge.menu.editors" /></a></li>
		</ul>
	</div>
	<div id="dashboard_tabs" class="col-xs-12 col-sm-10">
		<!--Start Dashboard Tab metamodels-->
		<div id="dashboard-metamodels" class="row" style="visibility: visible; position: relative;">
			<div class="col-sm-12 col-md-12" style="margin-top: 20px;">
				<h4 class="page-header">
					<spring:message code="mdeforge.metamodels" />
				</h4>
				<div class="row">
					<div class="col-xs-12">
						<a href="${pageContext.request.contextPath}/project/metamodel/create?projectname=${projectname}"><button type="button" class="btn btn-success">
								<spring:message code="mdeforge.metamodel.create.lowercase" />
							</button></a>
					</div>
				</div>
				<div class="box">
					<div class="box-header">
						<div class="box-name">
							<i class="fa fa-list"></i> <span></span>
						</div>
						<div class="no-move"></div>
					</div>
					<div class="box-content no-padding">
						<table id="metamodels_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable">
							<thead>
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>URI</th>
									<th>Azioni</th>
								</tr>
							</thead>
							<tbody>
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
		<!--End Dashboard Tab metamodels-->
		<!--Start Dashboard Tab models-->
		<div id="dashboard-models" class="row" style="visibility: hidden; position: absolute;">
			<div class="col-sm-12 col-md-12" style="margin-top: 20px;">
				<h4 class="page-header">
					<spring:message code="mdeforge.models" />
				</h4>
				<div class="row">
					<div class="col-xs-12">
						<a href="${pageContext.request.contextPath}/project/model/create?projectname=${projectname}"><button type="button" class="btn btn-success">
								<spring:message code="mdeforge.model.create.lowercase" />
							</button></a>
					</div>
				</div>
				<div class="box">
					<div class="box-header">
						<div class="box-name">
							<i class="fa fa-list"></i> <span></span>
						</div>
						<div class="no-move"></div>
					</div>
					<div class="box-content no-padding">
						<table id="models_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable">
							<thead>
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>URI</th>
									<th>Azioni</th>
								</tr>
							</thead>
							<tbody>
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
		<!--End Dashboard Tab models-->
		<!--Start Dashboard Tab transformations-->
		<div id="dashboard-transformations" class="row" style="width: 100%; visibility: hidden; position: absolute;">
			<div class="col-sm-12 col-md-12" style="margin-top: 20px;">
				<h4 class="page-header">
					<spring:message code="mdeforge.transformations" />
				</h4>
				<div class="row">
					<div class="col-xs-12">
						<a href="${pageContext.request.contextPath}/project/transformation/create?projectname=${projectname}"><button type="button" class="btn btn-success">
								<spring:message code="mdeforge.transformation.create.lowercase" />
							</button></a>
					</div>
				</div>
				<div class="box">
					<div class="box-header">
						<div class="box-name">
							<i class="fa fa-list"></i> <span></span>
						</div>
						<div class="no-move"></div>
					</div>
					<div class="box-content no-padding">
						<table id="transformations_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable">
							<thead>
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>URI</th>
									<th>Azioni</th>
								</tr>
							</thead>
							<tbody>
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
		<!--End Dashboard Tab transformations-->
		<!--Start Dashboard Tab editors-->
		<div id="dashboard-editors" class="row" style="visibility: hidden; position: absolute;">
			<div class="col-sm-12 col-md-12" style="margin-top: 20px;">
				<h4 class="page-header">
					<spring:message code="mdeforge.editors" />
				</h4>
				<div class="row">
					<div class="col-xs-12">
						<a href="${pageContext.request.contextPath}/project/editor/create?projectname=${projectname}"><button type="button" class="btn btn-success">
								<spring:message code="mdeforge.editor.create.lowercase" />
							</button></a>
					</div>
				</div>
				<div class="box">
					<div class="box-header">
						<div class="box-name">
							<i class="fa fa-list"></i> <span></span>
						</div>
						<div class="no-move"></div>
					</div>
					<div class="box-content no-padding">
						<table id="editors_datatable" class="table table-bordered table-striped table-hover table-heading table-datatable">
							<thead>
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>URI</th>
									<th>Azioni</th>
								</tr>
							</thead>
							<tbody>
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
		<!--End Dashboard Tab editors-->
	</div>
	<div class="clearfix"></div>
</div>