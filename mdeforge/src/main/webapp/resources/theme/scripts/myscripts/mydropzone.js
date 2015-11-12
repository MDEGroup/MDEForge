$(function() {
	var result = $('#resultEcoreMetamodelList');
	Dropzone.options.myAwesomeDropzone = {
		paramName : "metamodelfile",
		
		init : function() {
			var myDropzone = this;
			$('#searchEmoreMetamodelByExampleButton').on("click", function(e) {
				e.preventDefault();
				e.stopPropagation();
				myDropzone.processQueue();
			});
			this.on("success",
					function(file) {
						var v = new Object();
						v.response = $.parseJSON(file.xhr.response);
						$.get(ctx + '/resources/theme/scripts/plugins/forms/template/resultEcoreSearchByExampleTemplate.html',
								function(template) {
									var rendered = Mustache.render(template, v);
									console.log(result);
									result.append(rendered);
									console.log(result);
								});
					});
		}
	};
});