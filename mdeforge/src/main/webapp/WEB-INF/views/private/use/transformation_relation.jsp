<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="separator"></div>
<div class="row-fluid">
	<div class="span12">
		<button type="button" id="transformationModelInfo"
			class="btn btn-icon btn-large btn-primary glyphicons file">
			<i></i>Parse ATL
		</button>
	</div>
</div>
<div class="separator"></div>
<!-- Form actions -->
<hr class="separator">
<div class="row-fluid" id="transformationRelations">
		<div class="span6">
		<h5 class="input-name">From Metamodels</h5>
		<div class="separator"></div>
			<div id="defineDomainRelationTo">
			<h6>Search Metamodels by name</h6>
			<select id="domainMetamodelSelect" class="select-relation">
				 <option value="" selected disabled>Metamodels</option>
			</select> 
<!-- 			<div class="span6"> -->
<!-- 			<h6>Filter</h6> -->
<!-- 				<input id="filterMMDomainTextBox" type="text" placeholder="Filter Metamodels by Name" /> -->
<!-- 			</div>	 -->

			<button type="button" id="addDomainConformToMetamodel" class="btn btn-primary">
				Select Metamodel
			</button>
			<!-- 							<a href="#new_metamodel_popup" data-toggle="modal" class="btn btn-primary">New metamodel</a> -->
			</div>
			<div class="separator"></div>
			<table>
				<thead>
					<tr>
						<th>Metamodel</th>
						<th>Name</th>
						<th>Reference Model Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="domainConformToTable">
				</tbody>
			</table>
		</div>
		<div class="span6">
			<h5 class="input-name">To Metamodels</h5>
			<div class="separator"></div>
			<div  id="defineCoDomainRelationTo">
			<h6>Search Metamodels by name</h6>
				<select id="coDomainMetamodelSelect">
				  <option value="" selected disabled>Metamodels</option>
				</select>
<!-- 			<div class="span6"> -->
<!-- 			<h6>Filter</h6> -->
<!-- 				<input id="filterMMCoDomainTextBox" type="text" placeholder="Filter Metamodels by Name"/> -->
<!-- 			</div> -->
			<button type="button" id="addCoDomainConformToMetamodel"
				class="btn btn-primary">
				Select Metamodel
			</button>
			<!-- 							<a href="#new_metamodel_popup" data-toggle="modal" class="btn btn-primary">Upload New metamodel</a> -->
		</div>
		<div class="separator"></div>
		<table>
				<thead>
					<tr>
						<th>Metamodel</th>
						<th>Name</th>
						<th>Reference Model Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="coDomainConformToTable">
				</tbody>
			</table>
	</div>
</div>
<hr class="separator">
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/transformationModelInfo.js"></script>