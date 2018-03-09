<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row-fluid">
	<div class="span6">
		<h5 class="input-name">Select Metamodel</h5>
		<input id="conformMetamodelSelect" type="hidden"  name="conformToRelation" value="">
		<input autocomplete="off" id="modelRelMetamodel" type="text" class="my-select" data-type="EcoreMetamodel" placeholder="Search EcoreMetamodels">
	</div>
</div>
<div class="separator"></div>
<hr class="separator">

<script>
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
</script>