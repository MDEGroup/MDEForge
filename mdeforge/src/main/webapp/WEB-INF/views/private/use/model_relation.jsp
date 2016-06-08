<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row-fluid">
	<div class="span12">
	<h5 class="input-name">Select Metamodel</h5>
		<select id="conformMetamodelSelect" name="conformToRelation">
			<c:forEach items="${metamodelList}" var="metamodel">
				<option value="${metamodel.id }">${metamodel.name }</option>
			</c:forEach>
		</select>
		</div>
</div>
<div class="separator"></div>
<hr class="separator">