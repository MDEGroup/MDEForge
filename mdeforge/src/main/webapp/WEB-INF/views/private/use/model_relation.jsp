<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr class="separator">
<div class="row-fluid">
	<div class="span12">
		<div class="control-group">
		<label class="control-label">Select Metamodel</label>
		<select class="control" id="conformMetamodelSelect" name="conformToRelation">
			<c:forEach items="${metamodelList}" var="metamodel">
				<option value="${metamodel.id }">${metamodel.name }</option>
			</c:forEach>
		</select>
		</div>
	</div>
</div>
<hr class="separator">