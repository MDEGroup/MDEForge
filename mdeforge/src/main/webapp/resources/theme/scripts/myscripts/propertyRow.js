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
	
	$(document).on('click','.deleteMetamodelButton', function(e) {
		console.log($(this).data('id'));
		$('.propertyRow[data-id="' + $(this).data('id') + '"]').remove();
		
		
	});
	$(document).on('click','#addConformToMetamodel', function(e) {
		var idRow = $('.conformToRow.lastPropertyRow').data('id');
		console.log(idRow);
		
		$('.conformToRow.lastPropertyRow').removeClass('lastPropertyRow');
		if (idRow ==null)
			idRow = -1;
		var idMetamodel = $('#metamodelSelect').val();
		var nameMetamodel = $('#metamodelSelect option:selected').text();
		
		$('#conformToTable').append(
				'<tr  class="conformToRow lastPropertyRow" data-id="' + (idRow + 1) + '">' +
					'<td> ' +
					'<input type="hidden" name="relations[' + (idRow + 1) + 
							'].fromArtifact.id" value="' + idMetamodel + '"></input>' +
							'<input type="hidden" name="relations[' + (idRow + 1) + 
							']._class" value="org.medforge.business.model.DomainConformToRelation"></input>' +
					'<input type="text" name="relations[' + (idRow + 1) + 
							'].fromArtifact.name" value="' + nameMetamodel + '" disabled></input>' +
						
					'</td>' +
					'<td>' +
						'<input type="text" name="relations[' + (idRow + 1) + '].name"/>'	+			  			
					'</td>' +
					'<td>' +
						'<input type="text" name="relations[' + (idRow + 1) + '].referenceModelName"/>' +
					'</td>' +
					'<td>' +
					'<button type="button" data-id="' + (idRow + 1) + 
							'" class="deletePropertyButton btn btn-icon btn-danger glyphicons circle_ok"><i></i>Delete</button>' +
					'</td>' +
				'</tr>'	);
	});
});
