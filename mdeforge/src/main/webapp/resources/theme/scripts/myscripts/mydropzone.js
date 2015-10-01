$(function() {
	var spinner = new Spinner().spin($('#resultEcoreMetamodelList'));
	Dropzone.options.myAwesomeDropzone = {
		paramName : "metamodelfile",
		autoProcessQueue : false,
		init : function() {
			var myDropzone = this;
			$('#searchEmoreMetamodelByExampleButton').on("click", function(e) {
				e.preventDefault();
				e.stopPropagation();
				myDropzone.processQueue();
			});
			this.on("success",
					function(file) {
						spinner.stop();
						var v = new Object();
						v.response = $.parseJSON(file.xhr.response);
						$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/resultEcoreSearchByExampleTemplate.html',
								function(template) {
									var rendered = Mustache.render(template, v);
									$('#resultEcoreMetamodelList').append(rendered);
								});
					});
		}
	};
});