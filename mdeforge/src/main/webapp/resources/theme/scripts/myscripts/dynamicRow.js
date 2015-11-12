$(function() {
	
	$(document).on('click','.deletePropertyButton', function(e) {
		console.log($(this).data('id'));
		$('.propertyRow[data-id="' + $(this).data('id') + '"]').remove();
		
		
	});
	$(document).on('click','#addPropertyButton', function(e) {
		var idRow = $('.propertyRow.lastRow').data('id');
		$('.propertyRow.lastRow').removeClass('lastRow');
		if (idRow ==null)
			idRow = -1;
		var result = $('#propertiesTable');
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowProperty.html',
				function(template) {
					var rendered = Mustache.render(template, idRow);
					result.append(rendered);
				});
	});
	
	$(document).on('click','.deleteDomainConformToButton', function(e) {
		console.log($(this).data('id'));
		$('.domainConformToRow[data-id="' + $(this).data('id') + '"]').remove();
		
		
	});
	$(document).on('click','#addDomainConformToMetamodel', function(e) {
		var idRow = $('.domainConformToRow.lastRow').data('id');
		$('.domainonformToRow.lastRow').removeClass('lastRow');
		if (idRow ==null)
			idRow = -1;
		var idMetamodel = $('#domainMetamodelSelect').val();
		var nameMetamodel = $('#domainMetamodelSelect option:selected').text();
		var result = $('#domainConformToTable');
		var toRender = new Object();
		toRender.idRow = idRow + 1;
		toRender.toArtifactID = idMetamodel;
		toRender.toArtifactName = nameMetamodel;
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowDomainConformToRelation.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
				});
	});
	
	$(document).on('click','.deleteCoDomainConformToButton', function(e) {
		console.log($(this).data('id'));
		$('.coDomainConformToRow[data-id="' + $(this).data('id') + '"]').remove();
	});
	
	$(document).on('click','#addCoDomainConformToMetamodel', function(e) {
		var idRow = $('.coDomainConformToRow.lastRow').data('id');
		$('.coDomainConformToRow.lastRow').removeClass('lastRow');
		if (idRow ==null)
			idRow = -1;
		var result = $('#coDomainConformToTable');
		var idMetamodel = $('#coDomainMetamodelSelect').val();
		var nameMetamodel = $('#coDomainMetamodelSelect option:selected').text();
		var toRender = new Object();
		toRender.idRow = idRow + 1;
		console.log(idMetamodel);
		toRender.toArtifactID = idMetamodel;
		toRender.toArtifactName = nameMetamodel;
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowCoDomainConformToRelation.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
				});
	});
});

jQuery.fn.filterByText = function(textbox, selectSingleMatch) {
    return this.each(function() {
        var select = this;
        var options = [];
        $(select).find('option').each(function() {
            options.push({value: $(this).val(), text: $(this).text()});
        });
        $(select).data('options', options);
        $(textbox).bind('change keyup', function() {
            var options = $(select).empty().data('options');
            var search = $.trim($(this).val());
            var regex = new RegExp(search,"gi");
          
            $.each(options, function(i) {
                var option = options[i];
                if(option.text.match(regex) !== null) {
                    $(select).append(
                       $('<option>').text(option.text).val(option.value)
                    );
                }
            });
            if (selectSingleMatch === true && $(select).children().length === 1) {
                $(select).children().get(0).selected = true;
            }
        });            
    });
};

$(function() {
    $('#conformMetamodelSelect').filterByText($('#filterMMTextBox'), true);
});

$(function() {
	$('#coDomainMetamodelSelect').filterByText($('#filterMMCoDomainTextBox'), true);
});

$(function() {
	$('#domainMetamodelSelect').filterByText($('#filterMMDomainTextBox'), true);
});
