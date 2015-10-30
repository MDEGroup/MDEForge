$(function() {
	
	$(document).on('click','.deletePropertyButton', function(e) {
		console.log($(this).data('id'));
		$('.propertyRow[data-id="' + $(this).data('id') + '"]').remove();
		
		
	});
	$(document).on('click','#addPropertyButton', function(e) {
		var idRow = $('.propertyRow.lastPropertyRow').data('id');
		$('.propertyRow.lastPropertyRow').removeClass('lastPropertyRow');
		if (idRow ==null)
			idRow = -1;
		
		$('#propertiesTable').append(
				'<tr  class="propertyRow lastPropertyRow" data-id="' + (idRow + 1) + '">' +
					'<td>' +
						'<input type="text" name="properties[' + (idRow + 1) + '].name"/>'	+			  			
					'</td>' +
					'<td>' +
						'<input type="text" name="properties[' + (idRow + 1) + '].value"/>' +
					'</td>' +
					'<td>' +
						'<button type="button" data-id="' + (idRow + 1) + '" class="deletePropertyButton btn btn-icon btn-danger glyphicons circle_ok"><i></i>Delete</button>' +
					'</td>' +
				'</tr>'	);
	});
	
	$(document).on('click','.deleteDomainConformToButton', function(e) {
		console.log($(this).data('id'));
		$('.propertyRow[data-id="' + $(this).data('id') + '"]').remove();
		
		
	});
	$(document).on('click','#addDomainConformToMetamodel', function(e) {
		var idRow = $('.domainonformToRow.lastPropertyRow').data('id');
		console.log(idRow);
		
		$('.domainonformToRow.lastPropertyRow').removeClass('lastPropertyRow');
		if (idRow ==null)
			idRow = -1;
		var idMetamodel = $('#domainMetamodelSelect').val();
		var nameMetamodel = $('#domainMetamodelSelect option:selected').text();
		var result = $('#domainConformToTable');
		var toRender = new Object();
		toRender.idRow = idRow + 1;
		toRender.fromArtifactID = idMetamodel;
		toRender.fromArtifactName = nameMetamodel;
		$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/rowDomainConformToRelation.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
				});
	});
	
	$(document).on('click','.deleteCoDomainConformToButton', function(e) {
		console.log($(this).data('id'));
		$('.propertyRow[data-id="' + $(this).data('id') + '"]').remove();
	});
	
	$(document).on('click','#addCoDomainConformToMetamodel', function(e) {
		var idRow = $('.coDomainConformToRow.lastPropertyRow').data('id');
		console.log(idRow);
		
		$('.coDomainConformToRow.lastPropertyRow').removeClass('lastPropertyRow');
		if (idRow ==null)
			idRow = -1;
		var result = $('#coDomainConformToTable');
		var idMetamodel = $('#domainMetamodelSelect').val();
		var nameMetamodel = $('#domainMetamodelSelect option:selected').text();
		var toRender = new Object();
		toRender.idRow = idRow + 1;
		toRender.fromArtifactID = idMetamodel;
		toRender.fromArtifactName = nameMetamodel;
		$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/rowCoDomainConformToRelation.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
				});
	});
});
