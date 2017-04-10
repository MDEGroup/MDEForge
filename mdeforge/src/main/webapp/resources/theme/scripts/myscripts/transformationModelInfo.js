$(function() {
	$(document).on('click','#transformationModelInfo', function(e) {
		//var spinner = new Spinner().spin();
		//$('#transformationRelations').parent().append(spinner.el);
		debugger;
		e.preventDefault();
		$('#parseAlert').remove();
		var button = $(this)
		var files = document.getElementById('artifactName').files;
		if(files.length == 0){
			$(this).before('<div id="parseAlert" class="alert alert-error"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 15px;"><i class="icon-remove"></i></button><span>You have to upload an ATL file before using this feature</span></div>')
			return false;
		}
		var file = files[0];
	    if (files && file) {
	    	var reader = new FileReader();
	        reader.readAsText(file, "UTF-8");
	        reader.onload = function(evt) {
	            var file = new Object();
	            content = btoa(evt.target.result);
	            $.ajax({
	            	type : 'POST',
	            	data : '{"content" : "' + content + '"}',
	            	contentType: "application/json; charset=utf-8",
	                dataType: "json",
	            	url : ctx + "/private/ATLTransformation/modelInfo",
	            	success : function(data) {
	            		var c = 0;
	            		var d = 0;
	            		var coDomainConformToTable = $('#coDomainConformToTable');
	            		var domainConformToTable = $('#domainConformToTable');
	            		$(".domainConformToRowManual").remove();
	            		$(".coDomainConformToRowManual").remove();
	            		$(".showOnFillTablesMeta").addClass("visible");
	            		$.each(data, function (index, value) {
		            		if (value._class ==  "org.mdeforge.business.model.DomainConformToRelation") {
		            			var selectDomain = $('defineDomainRelationTo').clone();
		            			var toRender = new Object();
		            			$(".domainConformToRowManual").remove();
		            			toRender.idRow = d;
		            			toRender.metamodelName = value.referenceModelName;
		            			toRender.modelName = value.name;
		            			//////Temp
		            			var selectToAdd = $('#domainMetamodelSelect').clone();
		            			var rowToAdd = 
		            			'<tr   class="domainConformToRow lastRow" data-id="'+ d +'">' +
			            			'<td>' +
			            				//'<select id="domain' + index + '" name="domainConformToRelation['+ d +'].toArtifact.id">' +
			            				//	selectToAdd.html() + 
			            				//'</select>' +
			            				'<input autocomplete="off" id="ecoreSelectIdFrom" type="hidden" name="domainConformToRelation['+ d +'].toArtifact.id" value="">' +
			            				'<input autocomplete="off" id="ecoreSelectFrom" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search Ecore Metamodels">' +
			            				//'<input id="domainFilter' + index + '" type="text" />' +
			            			'</td>' +  
			            			'<td>' + 
			            			'<input autocomplete="off" type="text" name="domainConformToRelation['+ d +'].name" value="' + toRender.modelName  + '" />' +			  			
			            			'</td>' +
			            			'<td>' +
			            				'<input autocomplete="off" type="text" name="domainConformToRelation['+ d +'].referenceModelName" value="' + toRender.metamodelName + '" />' +
			            			'</td>' +
			            			'<td>Disabled</td>' +
		            			'</tr>';
		            			domainConformToTable.append(rowToAdd);
		            			//$('#domain' + index).filterByText($('#domainFilter' + index), true);
		            			
		            			d++;
		            		}
		            		else {
		            			var toRender = new Object();
		            			toRender.idRow = c;
		            			toRender.metamodelName = value.referenceModelName;
		            			toRender.modelName = value.name;
		            			var selectToAdd = $('#domainMetamodelSelect').clone();
		            			var rowToAdd = 
			            			'<tr  class="coDomainConformToRow lastRow" data-id="'+ c +'">' +
				            			'<td>' +
				            				//'<select id="coDomain' + index + '" name="coDomainConformToRelation['+ c +'].toArtifact.id">' +
				            				//	selectToAdd.html() + 
				            				//'</select>' +
				            				'<input autocomplete="off" id="ecoreSelectIdTo" type="hidden" name="coDomainConformToRelation['+ c +'].toArtifact.id" value="">' +
				            				'<input autocomplete="off" id="ecoreSelectTo" class="my-select" type="text" data-type="EcoreMetamodel" placeholder="Search Ecore Metamodels">' +
				            				//'<input id="coDomainFilter' + index + '" type="text" />' +
				            			'</td>' +  
				            			'<td>' + 
				            			'<input autocomplete="off" type="text" name="coDomainConformToRelation['+ c +'].name" value="' + toRender.modelName  + '" />' +			  			
				            			'</td>' +
				            			'<td>' +
				            				'<input autocomplete="off" type="text" name="coDomainConformToRelation['+ c +'].referenceModelName" value="' + toRender.metamodelName + '" />' +
				            			'</td>' +
				            			'<td>Disabled</td>' +
			            			'</tr>';
		            			coDomainConformToTable.append(rowToAdd);
		            			//$('#coDomain' + index).filterByText($('#coDomainFilter' + index), true);
		            			c++;
		            		}
	            		});
	            		$('#defineCoDomainRelationTo').hide();
	            		$('#defineDomainRelationTo').hide();
	            		initSelects($('.my-select'));
	    			},
	    			error : function error(data) {
	    				debugger;
	    				console.log('error');
	    				$(this).before('<div id="parseAlert" class="alert alert-error"><button type="button" class="close pull-left" data-dismiss="alert" style="left: -12px; padding-left: 15px;"><i class="icon-remove"></i></button><span>Ops! Something went wrong! Try Again.</span></div>')
	    			}
	            });
	        }
	    }
	    //spinner.stop();
	});
});

/* SELECT AJAX INITIALIZATION*/
var delay = null;
$(document).ready(function(){
	initSelects($('.my-select'));
})


function initSelects(select){
	//select is a text input
	select.each(function(e){
		$(this).after('<div class="my-select-control"><div class="my-select-dropdown">' + 
						'<div id="select-content" class="my-select-content">' + 
		                '</div></div></div>');
		var next = $(this).next();
		var prev = $(this).prev();
		$(this).data("target", next);
		$(this).data("input", prev);
		$(this).data("content", next.find("#select-content"))
	});
}

/* MY SELECT EVENTS */
$("body").on("mousedown", ".my-select-item", function(e){
	e.preventDefault();
	var input = $(this).closest(".my-select-control").prev();
	
	input
		.data("id", $(this).data("id"))
		.data("name", $(this).data("name"))
		.val($(this).data("name"))
		.blur()
	
	var value = input.data("input");
	value.val($(this).data("id"));
})

/*$('.my-select')
.focus(function(e){
	$(this).removeClass("input-error");
	$(this).data("target").addClass("dropdown-open").attr("placeholder", "Search Ecore Metamodels");
})
.blur(function(e){
	$(this).data("target").removeClass("dropdown-open")
})
.keyup(function(e){
	if (delay !== null) {
        clearTimeout(delay);
    }
	var type = $(this).data("type");
	var project = $(this).data("project");
	var that = $(this);
	delay = setTimeout(
			function(){
				if(that.val().length > 0)
					getMetamodels(type, project, that)
	}, 500)
})*/

$('body').on("focus", ".my-select", function(){
	$(this).removeClass("input-error").attr("placeholder", "Search EcoreMetamodels");
	$(this).data("target").addClass("dropdown-open");
})
.on("blur", ".my-select", function(){
	$(this).data("target").removeClass("dropdown-open")
})
.on("keyup", ".my-select", function(){
	if (delay !== null) {
        clearTimeout(delay);
    }
	var type = $(this).data("type");
	var project = $(this).data("project");
	var that = $(this);
	delay = setTimeout(
			function(){
				if(that.val().length > 0)
					getMetamodels(type, project, that)
	}, 500)
})

function getMetamodels(typeArtifact, project, input){
	//project is to ignore artifacts for that project
	//if project is null all artifacts will be retrived
	//typeArtifact can be "EcoreMetamodel", "ATLTransformation", "Model"
	//input is the html element
	var select = input.data("content");
	var query = input.val();
	select.html('<div class="my-select-item-info">' +
            '<span class="by loagind-select text-primary">Loading...</span>' +
    '</div>');
	$.ajax({
	    type: "POST",
	    url: ctx + '/public/searchArtifact',
	    data: {
        	search_string: query,
        	id_project: project,
        	type: typeArtifact,
        	limit: 50
        },
	    dataType:'json',
	    success: function(data) {
	    	console.log(data)
	    	var options = '';  
			if(data.length > 0){
				data.forEach(function(item, index, array){
			    	   options += '<div class="my-select-item" data-id="'+ item.id +'" data-name="'+ item.name +'">' +
				                '<h5 class="text-black strong">' + escape(item.name) + '</h5>' +
				                    '<span class="by">' + escape(item.author.username) + '</span>' +
				            '</div>';              
			       }); 
			}
			else{
				options = '<div class="my-select-item-info"><span class="by text-primary">No result found.</span></div>';
			}
			select.html(options);
	    },
	    error: function(res){
	    	console.log(res);
	    	select.html('<div class="my-select-item-info"><span class="by text-error">Ops. Something went wrong. Try Again</span></div>');
	    }
	});
}

$("#expandTables").click(function(){
	var that = $(this)
	if(that.hasClass("toggled")){
		$('.expand-row').addClass("span6")
		that.removeClass("toggled")
	}else{
		$('.expand-row').removeClass("span6")
		that.addClass("toggled")
	}
	
})