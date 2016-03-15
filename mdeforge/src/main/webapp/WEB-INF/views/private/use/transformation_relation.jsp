<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr class="separator">
<div class="row-fluid">
	<div class="span12">
		<button type="button" id="transformationModelInfo"
			class="btn btn-icon btn-success glyphicons circle_ok">
			<i></i>Parse ATL
		</button>
	</div>
</div>
<!-- Form actions -->
<div class="row-fluid" id="transformationRelations">
	<div class="row-fluid">
		<div class="span12">
			<h4>From Metamodels</h4>
			<table>
				<thead>
					<tr>
						<th>Metamodel</th>
						<th>Name</th>
						<th>Reference Model Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="domainConformToTable">
				</tbody>
			</table>
		</div>
		<div class="span12" id="defineDomainRelationTo">
			<select id="domainMetamodelSelect">
				<c:forEach items="${metamodelList}" var="metamodel">
					<option value="${metamodel.id }">${metamodel.name }</option>
				</c:forEach>
			</select> <input id="filterMMDomainTextBox" type="text" />

			<button type="button" id="addDomainConformToMetamodel"
				class="btn btn-icon btn-success glyphicons circle_ok">
				<i></i>Select metamodel
			</button>
			<!-- 							<a href="#new_metamodel_popup" data-toggle="modal" class="btn btn-primary">New metamodel</a> -->
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<h4>To Metamodels:</h4>
			<table>
				<thead>
					<tr>
						<th>Metamodel</th>
						<th>Name</th>
						<th>Reference Model Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="coDomainConformToTable">
				</tbody>
			</table>
		</div>
		<div class="span12" id="defineCoDomainRelationTo">
			<select id="coDomainMetamodelSelect">
				<c:forEach items="${metamodelList}" var="metamodel">
					<option value="${metamodel.id }">${metamodel.name }</option>
				</c:forEach>
			</select> <input id="filterMMCoDomainTextBox" type="text" />
			<button type="button" id="addCoDomainConformToMetamodel"
				class="btn btn-icon btn-success glyphicons circle_ok">
				<i></i>Select metamodel
			</button>
			<!-- 							<a href="#new_metamodel_popup" data-toggle="modal" class="btn btn-primary">Upload New metamodel</a> -->
		</div>
	</div>
</div>
<hr class="separator">
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/transformationModelInfo.js"></script>