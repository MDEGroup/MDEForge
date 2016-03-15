$(function() {
	$(document).on('click','#transformationModelInfo', function(e) {
		var spinner = new Spinner().spin();
		$('#transformationRelations').parent().append(spinner.el);
		e.preventDefault();
		var files = document.getElementById('artifactName').files;
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
	            		$.each(data, function (index, value) {
		            		if (value._class ==  "org.mdeforge.business.model.DomainConformToRelation") {
		            			var selectDomain = $('defineDomainRelationTo').clone();
		            			var toRender = new Object();
		            			toRender.idRow = d;
		            			toRender.metamodelName = value.referenceModelName;
		            			toRender.modelName = value.name;
		            			//////Temp
		            			var selectToAdd = $('#domainMetamodelSelect').clone();
		            			var rowToAdd = 
		            			'<tr   class="domainConformToRow lastRow" data-id="'+ d +'">' +
			            			'<td>' +
			            				'<select id="domain' + index + '" name="domainConformToRelation['+ d +'].toArtifact.id">' +
			            					selectToAdd.html() + 
			            				'</select>' +
			            				'<input id="domainFilter' + index + '" type="text" />' +
			            			'</td>' +  
			            			'<td>' + 
			            			'<input type="text" name="domainConformToRelation['+ d +'].name" value="' + toRender.modelName  + '" />' +			  			
			            			'</td>' +
			            			'<td>' +
			            				'<input type="text" name="domainConformToRelation['+ d +'].referenceModelName" value="' + toRender.metamodelName + '" />' +
			            			'</td>' +
			            			'<td>Disabled</td>' +
		            			'</tr>';
		            			domainConformToTable.append(rowToAdd);
		            			$('#domain' + index).filterByText($('#domainFilter' + index), true);
		            			
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
				            				'<select id="coDomain' + index + '" name="coDomainConformToRelation['+ c +'].toArtifact.id">' +
				            					selectToAdd.html() + 
				            				'</select>' +
				            				'<input id="coDomainFilter' + index + '" type="text" />' +
				            			'</td>' +  
				            			'<td>' + 
				            			'<input type="text" name="coDomainConformToRelation['+ c +'].name" value="' + toRender.modelName  + '" />' +			  			
				            			'</td>' +
				            			'<td>' +
				            				'<input type="text" name="coDomainConformToRelation['+ c +'].referenceModelName" value="' + toRender.metamodelName + '" />' +
				            			'</td>' +
				            			'<td>Disabled</td>' +
			            			'</tr>';
		            			coDomainConformToTable.append(rowToAdd);
		            			$('#coDomain' + index).filterByText($('#coDomainFilter' + index), true);
		            			c++;
		            		}
	            		});
	            		$('#defineCoDomainRelationTo').hide();
	            		$('#defineDomainRelationTo').hide();
	    			},
	    			error : function error(data) {
	    				console.log('error');
	    			}
	            });
	        }
	    }
	    spinner.stop();
	});
});

