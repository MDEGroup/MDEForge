<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="separator"></div>
<hr class="separator">
<div class="separator"></div>
<div class="row-fluid">
	<div class="span6">
		<button type="button" id="transformationModelInfo"
			class="btn btn-icon btn-large btn-primary glyphicons file">
			<i></i>Parse ATL
		</button>
	</div>
	<div class="span6 text-right">
		<button type="button" id="expandTables"
			class="btn btn-icon">
			<i class="icon-resize-horizontal"></i>
		</button>
	</div>
</div>
<div class="separator bottom"></div>
<p>When uploading transformations, it is necessary to specify the source and target
metamodels. It is possible to parse the transformation being uploaded to automatically
search for candidate metamodels. If they are not
available in the repository, users have to upload them before finalizing the addition of
the new transformation.</p>
<!-- Form actions -->
<div class="row-fluid" id="transformationRelations">
		<div class="span6 expand-row">
		<h5 class="input-name">From Metamodels</h5>
		
			<div id="defineDomainRelationTo">
			<div class="separator bottom"></div>
			<!-- <h6>Search Metamodels by name</h6>-->
			<!-- <select id="domainMetamodelSelect" class="select-relation">
				 <option value="" selected disabled>Metamodels</option>
			</select> -->
			<input autocomplete="off" id="domainMetamodelSelect" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search EcoreMetamodels">
<!-- 			<div class="span6"> -->
<!-- 			<h6>Filter</h6> -->
<!-- 				<input id="filterMMDomainTextBox" type="text" placeholder="Filter Metamodels by Name" /> -->
<!-- 			</div>	 -->

			<button type="button" id="addDomainConformToMetamodel" class="btn btn-primary">
				Select Metamodel
			</button>
			<!-- 							<a href="#new_metamodel_popup" data-toggle="modal" class="btn btn-primary">New metamodel</a> -->
			<div class="separator"></div>
			</div>
			
			<table id="tableDefineDomainRelationTo" class="showOnFillTablesMeta">
				<thead>
					<tr>
						<th class="span5">Metamodel</th>
						<th>Name</th>
						<th>Reference Model Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="domainConformToTable">
				</tbody>
			</table>
			<div class="separator"></div>
		<hr>
		</div>
		<div class="span6 expand-row">
			<h5 class="input-name">To Metamodels</h5>
			
			<div  id="defineCoDomainRelationTo">
			<div class="separator bottom"></div>
			<!-- <h6>Search Metamodels by name</h6>-->
				<!-- <select id="coDomainMetamodelSelect">
				  <option value="" selected disabled>Metamodels</option>
				</select>-->
				<input autocomplete="off" id="coDomainMetamodelSelect" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search EcoreMetamodels">
<!-- 			<div class="span6"> -->
<!-- 			<h6>Filter</h6> -->
<!-- 				<input id="filterMMCoDomainTextBox" type="text" placeholder="Filter Metamodels by Name"/> -->
<!-- 			</div> -->
			<button type="button" id="addCoDomainConformToMetamodel"
				class="btn btn-primary">
				Select Metamodel
			</button>
			<!-- 							<a href="#new_metamodel_popup" data-toggle="modal" class="btn btn-primary">Upload New metamodel</a> -->
		<div class="separator"></div>
		</div>
		
		<table id="tableDefineCoDomainRelationTo" class="showOnFillTablesMeta">
				<thead>
					<tr>
						<th class="span5">Metamodel</th>
						<th>Name</th>
						<th>Reference Model Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="coDomainConformToTable">
				</tbody>
			</table>
		<div class="separator"></div>
	</div>
</div>
<hr class="separator">
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/transformationModelInfo.js"></script>