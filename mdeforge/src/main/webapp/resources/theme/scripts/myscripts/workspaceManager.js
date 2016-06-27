	$(document).on('click', '.removeArtifact', function(event){
		var idArtifact = $(this).data('id');
		var idProject = $("#projectId").data('id');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/remove/" + idArtifact,
			success : function(data) {
				$('#' + idArtifact).remove();
			},
			error : function error(data) {
				$('#' + idArtifact).remove();
			}
			
		});
	});

	$(document).on('click','#addEcore', function(event){
		var ecoreMetamodel = new Object();
		ecoreMetamodel.id = $('#ecoreSelect').val();
		ecoreMetamodel.name = $("#ecoreSelect option:selected").text();
		ecoreMetamodel.ecoreMetamdel = true;
		var idProject = $("#projectId").data('id');
		console.log("1 _ " + idProject);
		ecoreMetamodel.projectId = idProject;
		var result = $('#ecoreMMTable');
		$.ajax({
			
			url : ctx + "/private/project/" + idProject + "/add/" + ecoreMetamodel.id,
			success : function(data) {
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ecoreMetamodel);
							result.append(rendered);
						});
				$("#ecoreSelect option[value='" + ecoreMetamodel.id + "']").remove();
				$('#ecoreToAdd').hide();
				$("#showEcoreList").removeClass("rotate-item");
			},
			error : function error(data) {
				console.log('error');
				
			}
		});
	});
		
	$(document).on('click','#addATL', function(event){
		var idProject = $("#projectId").data('id');
		var ATLTransormation = new Object();
		ATLTransormation.id = $('#ATLSelect').val();
		ATLTransormation.name = $("#ATLSelect option:selected").text();
		ATLTransormation.ATLTransformation = true;
		var idProject = $("#projectId").data('id');
		console.log("2 _ " + idProject);
		ATLTransormation.projectId = idProject;
		var result = $('#atlTable');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/add/" + ATLTransormation.id,
			success : function(data) {
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ATLTransormation);
							result.append(rendered);
					});
				$("#ATLSelect option[value='" + ATLTransormation.id + "']").remove();
				$('#ATLToAdd').hide();
				$("#showATLList").removeClass("rotate-item");
			},
			error : function error(data) {
				console.log('error')
			}
			
		});
	});


	$(document).on('click','#addModel', function(event){
		var idProject = $("#projectId").data('id');
		var model = new Object();
		model.id = $('#modelSelect').val();
		model.name = $("#modelSelect option:selected").text();
		model.model = true;
		var idProject = $("#projectId").data('id');
		console.log("3 _ " + idProject);
		model.projectId = idProject;
		var result = $('#modelTable');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/add/" + model.id,
			success : function(data) {
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, model);
							result.append(rendered);
					});
				$("#modelSelect option[value='" + model.id + "']").remove();
				$('#modelToAdd').hide();
				$("#showModelList").removeClass("rotate-item");
				
			},
			error : function error(data) {
						console.log('error')
			}
		});
	});
	
	// SHOW ARTIFACT BY TYPE
	$('#showModelList').click(showModelList);
	function showModelList(event){
		if (!($(this).hasClass("rotate-item"))) {
			$(this).addClass("rotate-item");
			var ids =[];
			$('#modelTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$('#modelSelect').html('<option value="" selected disabled>Search Models</option>');
			$('#modelToAdd').show();
					//$(document).on('click','#showModelList', showModelList);
		}
		else {
			$('#modelToAdd').hide();
			$(this).removeClass("rotate-item");
			modelselect[0].selectize.clearOptions()
		}
	}
	
	$('#showATLList').click(showATLList);
	function showATLList(event){
		if (!($(this).hasClass("rotate-item"))) {
			$(this).addClass("rotate-item");
			var ids =[];
			$('#atlTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			
			//$('#ATLSelect').html('<option value="" selected disabled>Search ATL Transformations</option>');
			$('#ATLToAdd').show();
					//$(document).on('click','#showATLList', showATLList); perchè altro listener?
		}
		else {
			$('#ATLToAdd').hide();
			$(this).removeClass("rotate-item");
			atlselect[0].selectize.clearOptions()
		}
	}
	$('#showEcoreList').click(showEcoreList);
	
	function showEcoreList(event){
		if (!($(this).hasClass("rotate-item"))){
			$(this).addClass("rotate-item");
			var ids =[];
			$('#ecoreMMTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$('#ecoreSelect').html('<option value="" selected disabled>Search Metamodels</option>');
			//inizialize plugin for this ajax select
			$('#ecoreToAdd').show();
					//$(document).on('click','#showEcoreList', showEcoreList); perchè altro listener?
					//$('#showEcoreList').one(showEcoreList);
		}
		else {
			$('#ecoreToAdd').hide();
			$(this).removeClass("rotate-item");
			ecoreselect[0].selectize.clearOptions()
		}
	}
	
	//SHARE OR UNSHARE PROJECT
	
	$(document).on('click','#addUser', function(event){
		var idUser = $('#userSelect').val();
		var nameModel = $("#userSelect option:selected").text();
		var idProject = $("#projectId").attr('data-id');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/addUser/" + idUser,
			success : function(data) {
				var result = $('#users');
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/userBox.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
						});
				$("#userSelect option[value='" + idUser + "']").remove();
				$('#userList').hide();
				$("#showUserList").removeClass("rotate-item");
				
			},
			error : function error(data) {
				console.log('error')
			}
		});
	});
	
	$(document).on('click','.removeSharedUser', function(event){
		var idProject = $("#projectId").data('id');
		var idUser = $(this).data('id');
		$.ajax({
			url : ctx + "/private/project/" + idProject + "/removeUser/" + idUser,
			success : function(data) {
				$('.sharedUser[data-id="'+ idUser +'"]').remove();
				
			},
			error : function error(data) {
				console.log('error');
				$('.sharedUser[data-id="'+ idUser +'"]').remove();
			}
		});
	});
	
	// WORKSPACE MANAGEMENT
	$(document).on('click','#addProject', function(event){
		var idProject = $('#projectSelect').val();
		var idWorkspace = $("#workspaceId").data('id');
		var result = $('#projectList');
		$.ajax({
			url : ctx + "/private/workspace/" + idWorkspace + "/add/" + idProject,
			success : function(data) {
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/projectInArtifact.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
						});
				$("#projectSelect option[value='" + idProject + "']").remove();
				$('#projectsToAdd').hide();
			},
			error : function error(data) {
				console.log('error');
			}
			
		});
	});
	
	$(document).on('click', '.remove-project', function(event){
		event.stopPropagation();
		var idProject = $(this).data('id');
		var nameProject = $(this).data('name');
		var idWorkspace = $("#workspaceId").data('id');
		$.ajax({
			url : ctx + "/private/workspace/" + idWorkspace + "/remove/" + idProject,
			success : function(data) {
				$('#' + idProject).remove();
				$('#projectSelect').append($('<option></option>').attr('value',idProject).text(nameProject));
				$('#workspaceDetailsDiv').hide();
			},
			error : function error(data) {
				$('#' + idProject).remove();
				$('#projectSelect').append($('<option></option>').attr('value',idProject).text(nameProject));
				$('#workspaceDetailsDiv').hide();
			}
			
		});
	});
	
	$('#showProjectList').click(function(event){
		if ($('#projectsToAdd').css('display') == 'none') {
			$('#projectsToAdd').show();
			$('#showProjectList').text("Close");
		}
		else {
			$('#projectsToAdd').hide();
			$('#showProjectList').text("Add project");
		}
	});
	
	// WORKSPACE LOADING
	$('.widget-employees').each(function(){
		if (typeof $.fn.select2 != 'undefined') 
			$(this).find('select').select2();
		
		equalHeight($(this).find('.row-merge > [class*="span"]'));
		
		$(this).on('click', '.listWrapper li:not(.active)', function()
		{
			var p = $(this).parents('.widget-employees:first');
			p.find('.listWrapper li').removeClass('active');
			$(this).addClass('active');
			var id = $(this).attr('id');
			$.ajax({
				url : ctx + "/private/project/" + id,
				success : function(data) {
					$('#projectId').attr('data-id',data.id)
					$("#workspaceDetailsDiv").show();
					$('#users').empty();
					$('#ATLToAdd').hide();
					$('#modelToAdd').hide();
					$('#ecoreToAdd').hide();
					if (data.users.length > 1)
						$('#sharedNumber').text(data.users.length + " users");
					else
						$('#sharedNumber').text(data.users.length + " user");
					if (data.artifacts.length > 1)
						$('#artifactsNumber').text(data.artifacts.length + " artifacts");
					else
						$('#artifactsNumber').text(data.artifacts.length + " artifact");
					$('#userDiv').show();
					var guard = data.owner.id == $('#loggedUserId').val();
					if (guard)
						$('#showUserList').show();
					else
						$('#showUserList').hide();
					$.each(data.users, function(i, user) {
						if(data.owner.id != user.id) {
							var  stringHead = '<li data-id="' + user.id + '" class="sharedUser UserLi"><span class="glyphicons activity-icon user"><i></i></span><span class="title">' +
					           		user.username + ' <br><strong>' + user.firstname + ' ' + user.lastname + '</strong></span>';
							var stringDelete = '';
							if (guard)
								stringDelete = '<span class="pull-right glyphicons icon-remove removeSharedUser text-error" data-id="' + user.id + '" ></span>';
							var stringTail = '</span></li>';
							$('#users').append(stringHead + stringDelete + stringTail);
						}
					});
					$('#ecoreMMTable').empty();
					$('#atlTable').empty();
					$('#modelTable').empty();
					$.each(data.artifacts, function(i, artifact) {
						if(artifact._class == "org.mdeforge.business.model.EcoreMetamodel") {
							var result = $('#ecoreMMTable');
							artifact.ecoreMetamdel = true;
							var idProject = $("#projectId").data('id');
							console.log("4 _ " + idProject);
							artifact.projectId = idProject;
							$.get(ctx + '/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										result.append(rendered);
								});
						}
						if(artifact._class == "org.mdeforge.business.model.ATLTransformation") {
							var result = $('#atlTable');
							artifact.ATLTransformation = true;
							var idProject = $("#projectId").data('id');
							console.log("5 _ " + idProject);
							artifact.projectId = idProject;
							$.get(ctx + '/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										result.append(rendered);
								});
						}
						if(artifact._class == "org.mdeforge.business.model.Model") {
							var result = $('#modelTable');
							artifact.model = true;
							var idProject = $("#projectId").data('id');
							console.log("6 _ " + idProject);
							artifact.projectId = idProject;
							$.get(ctx + '/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										result.append(rendered);
								});
						}
					});
					$('#removeProject').attr("data-id", data.id);
					$('#removeProject').attr("data-name", data.name)
					$('#projectName').text(data.name);
					$('#sharedNumber').text(data.users.length);
					$('#ownerEmail').text(data.owner.email);
					$('#ownerName').text(data.owner.firstname + ' ' + data.owner.lastname);
					$('#ownerUsername').text(data.owner.username);
				},
				error : function error(data) {
					$('#projectName').text(data);
				}
			})
		});
	});
	
	$('#showProjectAdd').click(function(event){
		if ($('#createProject').css('display') == 'none') {
			$('#createProject').show();
			$('#showProjectAdd').text("Cancel");
		}
		else {
			$('#createProject').hide();
			$('#showProjectAdd').text("Create new project");
		}
	});
	
	//UTILITY
	function equalHeight(boxes)	{
		boxes.height('auto');
		var maxHeight = Math.max.apply( Math, boxes.map(function(){ return $(this).height(); }).get());
		boxes.height(maxHeight);
	}
	
	$(document).on('click', '#addNewProject', function(event){
		event.stopPropagation();
		var idProject = $('#createProjectName').val();
		var nameProject = $(this).data('name');
		var idWorkspace = $("#workspaceId").data('id');
		var result = $('#projectList');
		$.ajax({
			url : ctx + "/private/workspace/" + idWorkspace + "/addNew/" + idProject,
			success : function(data) {
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/projectInArtifact.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
						});
				$('#createNewProject').text('createProjectName');
				$('#createProject').hide();
			},
			error : function error(data) {
				console.log('error');
			}
		});
	});
	
	$(document).on('click','#showUserList',function(event){
		if (!($(this).hasClass("rotate-item"))) {
			$.ajax({
				url : ctx + "/private/user/list",
				success : function(data) {
					$('#showUserList').addClass("rotate-item");
					$('#userSelect').empty();	
					$.each(data, function(i, model){
						if($("#loggedUserId").val() != model.id)
							$('#userSelect').append('<option value='+model.id+' >'+model.username+'</option>');
					});
					$('#userList').show();
				},
				error : function error(data) {
					console.log('error');
				}
			});
		}
		else {
			$('#userList').hide();
			$(this).removeClass('rotate-item');
		}
	});
/* SELECT AJAX */
initSelects($('.my-select'));
function initSelects(select){
	//select is a text input
	select.each(function(e){
		$(this).after('<div class="my-select-control">' + 
					'<div class="my-select-dropdown">' + 
						'<div class="my-select-content">' + 
		                '</div></div></div>');
		$(this).data("target", $(this).next())
	});
}
$('.my-select').focus(function(e){
	var dropdown = $(this).data("target");
	dropdown.show("fast")
})
$('.my-select').keypress(function(e){
	getArtifactsForProject("ecore", $(this).data("project"), $(this).val())
})
function getArtifactsForProject(typeArtifact, project, query){
	//project is to ignore artifacts for that project
	//if project is null all artifacts will be retrived
	//typeArtifact can be "ecore", "atl", "model"
	//input is the html element where results will be append
	$.ajax({
	    type: "POST",
	    url: 'http://localhost:8080/mdeforge/public/searchArtifact',
	    data: {
        	search_string: query,
        	idProject: project,
        	type: typeArtifact,
        	limit: 50
        },
	    dataType:'json',
	    success: function(data) {
	    	console.log(data)
	       var options = '';    

	       for(var i=0;i<data.length; i++)
	       {
	        options += '<div>' +
		                '<h5 class="text-black strong">' + escape(item.name) + '</h5>' +
		                    '<span class="by">' + escape(item.username) + '</span>' +
		            '</div>';              
	       }

	       //select.append(options);
	    },
	    error: function(res){
	    	console.log(res)
	    }
	});
}