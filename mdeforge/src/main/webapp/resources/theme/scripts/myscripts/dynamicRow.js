var domainRows = 0, coDomainRows = 0, propertyRows = 0;
$(function() {

//	$("#formEcore").submit(function(e) {
//		e.stopPropagation();
//		e.preventDefault();
//		console.log('adas');
//		var form = new FormData();
//		console.log($('#ecoreFile').files[0]);
//		form.append('file',$('#ecoreFile').files[0]);
//		console.log('asd');
//		$.ajax({
//			data : form,
//			type : "POST",
//			url : ctx + "/private/EcoreMetamodel/upload/inner",
//			success : function(eventData) {
//				console.log(eventData);
//			}
//		});
//	});

	var idRow = 0;
	$(document).on('click','.deletePropertyButton', function(e) {
		console.log($(this).data('id'));
		$(this).closest('tr').remove();
		propertyRows--;
		if (propertyRows == 0)
			$('#propertiesT').removeClass("visible");
		
	});
	$(document).on('click','#addPropertyButton', function(e) {
		if (propertyRows == 0)
			$('#propertiesT').addClass("visible");
		else{
			var last_input = $('#propertiesTable tr:last td input');
			if(last_input[0].value == "" || last_input[1].value == "" ){
				return false;
			}
		}
		
		if (idRow == null)
			idRow = -1;
		var result = $('#propertiesTable');
		
		var toRender = new Object();
		idRow = idRow + 1;
		toRender.idRow = idRow;
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowProperty.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
				});
		
		propertyRows++;
	});
	$(document).on('click','#addPropertyButton2', function(e) {
		var idRow = $('.propertyRow.lastRow').data('id');
		if (idRow ==null)
			idRow = -1;
		var result = $('#propertiesTable2');
		toRender.idRow = idRow + 1;
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowProperty.html',
				function(template) {
			var rendered = Mustache.render(template, idRow);
			result.append(rendered);
		});
	});
	
	$(document).on('click','.deleteDomainConformToButton', function(e) {
		domainRows--;
		$(this).closest('tr').remove();
		if(domainRows == 0){
			$('#tableDefineDomainRelationTo').removeClass("visible");
		}
	});
	$(document).on('click','#addDomainConformToMetamodel', function(e) {
		var button = $(this);
		var select =  $('#domainMetamodelSelect');
		var idMetamodel = select.data("id");
		var nameMetamodel = select.data("name");
		//when input is null
		if(idMetamodel == "undefined" || idMetamodel === null || select.val().length == 0){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.addClass("input-error").attr("placeholder", "No Metamodel Selected");
			return false;
		}
		//when input has been edited
		if(nameMetamodel == "undefined" || nameMetamodel === null || select.val() != nameMetamodel){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.val("").addClass("input-error").attr("placeholder", "Invalid Input");
			return false;
		}
		if (domainRows > 0){
			var last_input = $("#domainConformToTable tr:last td .check-input");
			if(last_input[0].value == ""){
				$(last_input[0]).addClass("input-error");
				return false;
			}
			if(last_input[1].value == ""){
				$(last_input[1]).addClass("input-error");
				return false;
			}
		}
		button.addClass("disabled-button");
		if (idRow ==null)
			idRow = -1;
		var result = $('#domainConformToTable');
		var toRender = new Object();
		toRender.idRow = idRow + 1;
		toRender.toArtifactID = idMetamodel;
		toRender.toArtifactName = nameMetamodel;
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowDomainConformToRelation.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
					button.removeClass("disabled-button");
					select.empty();
					$.gritter.add({
						title: 'New Metamodel has been added to Transformation Inputs',
						text: ""
					});
					if (domainRows == 0)
						$('#tableDefineDomainRelationTo').addClass("visible");
					domainRows++;
				});
	});
	
	$(document).on('click','.deleteCoDomainConformToButton', function(e) {
		coDomainRows--;
		$(this).closest('tr').remove();
		if(coDomainRows == 0){
			$('#tableDefineCoDomainRelationTo').removeClass("visible");
		}
	});
	
	$(document).on('click','#addCoDomainConformToMetamodel', function(e) {
		var button = $(this);
		var select =  $('#coDomainMetamodelSelect');
		var idMetamodel = select.data("id");
		var nameMetamodel = select.data("name");
		//when input is null
		if(idMetamodel == "undefined" || idMetamodel === null || select.val().length == 0){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.addClass("input-error").attr("placeholder", "No Metamodel Selected");
			return false;
		}
		//when input has been edited
		if(nameMetamodel == "undefined" || nameMetamodel === null || select.val() != nameMetamodel){
			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
			select.val("").addClass("input-error").attr("placeholder", "Invalid Input");
			return false;
		}
		if (coDomainRows > 0){
			var last_input = $("#coDomainConformToTable tr:last td .check-input");
			if(last_input[0].value == ""){
				$(last_input[0]).addClass("input-error");
				return false;
			}
			if(last_input[1].value == ""){
				$(last_input[1]).addClass("input-error");
				return false;
			}
		}
		button.addClass("disabled-button");
		if (idRow ==null)
			idRow = -1;
		var result = $('#coDomainConformToTable');
		var toRender = new Object();
		toRender.idRow = idRow + 1;
		toRender.toArtifactID = idMetamodel;
		toRender.toArtifactName = nameMetamodel;
		$.get(ctx + '/resources/theme/scripts/plugins/forms/template/rowCoDomainConformToRelation.html',
				function(template) {
					var rendered = Mustache.render(template, toRender);
					result.append(rendered);
					button.removeClass("disabled-button");
					select.empty();
					$.gritter.add({
						title: 'New Metamodel has been added to Transformation Outputs',
						text: ""
					});
					if (coDomainRows == 0)
						$('#tableDefineCoDomainRelationTo').addClass("visible");
					coDomainRows++;
				});
	});
});

$('body').on('focus','.check-input, #artifactTitle, .property-input', function(e) {
	$(this).removeClass("input-error")
})

/*jQuery.fn.filterByText = function(textbox, selectSingleMatch) {
    return this.each(function() {
        var select = this;
        var options = [];
        $(select).find('option').each(function() {
            options.push({value: $(this).val(), text: $(this).text()});
        });
        $(select).data('options', options);
        $(textbox).on('change keyup', function() {
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
});*/

/*$(function() {
	$('#coDomainMetamodelSelect').filterByText($('#filterMMCoDomainTextBox'), true);
});

$(function() {
	$('#domainMetamodelSelect').filterByText($('#filterMMDomainTextBox'), true);
});*/
$('#artifact').submit(function(e){
	debugger;
	var valid = true;
	$('.submitAlert').remove();
	
	
	
	/* NAME VALIDATION */
	var name = $("#artifactTitle");
	if(name.val() == ""){
		name.addClass("input-error").after('<div class="alert alert-error submitAlert"><button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button><span>This field is required</span></div>')
		valid = false;
	}
	
	/*Duplicate artifact name */
	$.ajax({
	url : ctx + "/private/artifact/name?name=" + name.val(),
	success : function(eventData) {
		name.addClass("input-error").after('<div class="alert alert-error submitAlert"><button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button><span>Duplicate name</span></div>')
		valid = eventData;
	}
});
	
	/* FILE VALIDATION */
	var input_file = document.getElementById('artifactName');
	if(input_file.files.length == 0){
		$(".box__input").append('<div class="alert-error center submitAlert"><span>File to upload is missing</span></div>')
		valid = false;
	}
	
	/* PROPERTIES VALIDATION */
	var property_input = $(".property-input");
	var pvalid = true;
	property_input.each(function(){
		if($(this).val() == "" || $(this).val().length == 0){
			$(this).addClass("input-error");
			pvalid = false;
		}
	})
	if(!pvalid){
		valid = false;
		$("#propertiesT").after('<div class="alert alert-error submitAlert"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 15px;"><i class="icon-remove"></i></button><span>Fill the fields you have missed or delete the entire entry</span></div>')

	}
	
	/* RELATIONS VALIDATION */

//	try{
//		var cvalid = true;
//		var domain_rows = $(".domainConformToRow");
//		if(domain_rows.length == 0){
//			valid = false;
//			$("#transformationRelations").before('<div class="alert alert-error submitAlert"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 15px;margin-bottom: 0;"><i class="icon-remove"></i></button><span>Please, you have to specify metamodels relation.</span></div>')
//		}else{
//			var coDomain_rows = $(".coDomainConformToRow");
//			if(coDomain_rows.length == 0){
//				valid = false;
//				$("#transformationRelations").before('<div class="alert alert-error submitAlert"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 15px; margin-bottom: 0;"><i class="icon-remove"></i></button><span>Please, you have to specify metamodels relation.</span></div>');
//			}
//		}
//		
//		var check_input = $(".check-input");
//		check_input.each(function(){
//			if($(this).val() == "" || $(this).val().length == 0){
//				$(this).addClass("input-error");
//				cvalid = false
//			}
//		})
//		if(!cvalid){
//			valid = false;
//			$("#transformationRelations").after('<div class="alert alert-error submitAlert"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 15px;"><i class="icon-remove"></i></button><span>Fill the fields you have missed or delete the entire entry</span></div>')
//		}
//	}catch(err){
//		console.log(err)
//	}
//	
//	/* MODEL RELATION */
//	try{
//		var select = $('#modelRelMetamodel');
//		var  meta_id = select.data("id");
//		var input_id = select.prev().val();
//		var meta_name = select.data("name");
//		//when input is null
//		if(meta_id === "undefined" || select.val().length == 0 || input_id == ""){
//			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
//			select.addClass("input-error").attr("placeholder", "No Metamodel Selected");
//			valid = false;
//		}
//		//when input has been edited
//		if(meta_id != input_id || meta_name === "undefined" || select.val() != meta_name){
//			//select.before('<div id="addProjectAlert" class="alert alert-error"><span>No Metamodel Selected</span></div>')
//			select.val("").addClass("input-error").attr("placeholder", "Invalid Input");
//			valid = false;
//		}
//	}catch(err){
//		console.log(err)
//	}
	if(valid){
		return true;
	}else{
		e.preventDefault();
	}
	
	
});