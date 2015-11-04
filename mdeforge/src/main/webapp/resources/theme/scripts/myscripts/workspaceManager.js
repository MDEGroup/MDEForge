	$(document).on('click', '.removeArtifact', function(event){
		var idArtifact = $(this).data('id');
		var idProject = $("#projectId").data('id');
		$.ajax({
			url : "/mdeforge/private/project/" + idProject + "/remove/" + idArtifact,
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
		var result = $('#ecoreMMTable');
		$.ajax({
			
			url : "/mdeforge/private/project/" + idProject + "/add/" + ecoreMetamodel.id,
			success : function(data) {
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ecoreMetamodel);
							result.append(rendered);
						});
				$("#ecoreSelect option[value='" + ecoreMetamodel.id + "']").remove();
				$('#ecoreToAdd').hide();
			},
			error : function error(data) {
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ecoreMetamodel);
							result.append(rendered);
						});
				$("#ecoreSelect option[value='" + ecoreMetamodel.id + "']").remove();
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
		var result = $('#atlTable');
		$.ajax({
			url : "/mdeforge/private/project/" + idProject + "/add/" + ATLTransormation.id,
			success : function(data) {
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, ATLTransormation);
							result.append(rendered);
					});
				$("#ATLSelect option[value='" + ATLTransormation.id + "']").remove();
				$('#ATLToAdd').hide();
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
		var result = $('#modelTable');
		$.ajax({
			url : "/mdeforge/private/project/" + idProject + "/add/" + model.id,
			success : function(data) {
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
						function(template) {
							var rendered = Mustache.render(template, model);
							result.append(rendered);
					});
				$("#modelSelect option[value='" + model.id + "']").remove();
				$('#modelToAdd').hide();
				
			},
			error : function error(data) {
						console.log('error')
			}
		});
	});
	
	// SHOW ARTIFACT BY TYPE
	$('#showModelList').click(function(event){
		if ($('#modelToAdd').css('display') == 'none') {
			$.ajax({
				url : "/mdeforge/private/Model/list",
				success : function(data) {
					$.each(data, function(i, model){
						$('#modelSelect').append($('<option></option>').attr('value',model.id).text(model.name));
					});
				},
				error : function error(data) {
					console.log('error');
				}
			});
			$('#modelToAdd').show();
		}
		else {
			$('#modelToAdd').hide();
		}
	});
	
	$('#showATLList').click(function(event){
		if ($('#ATLToAdd').css('display') == 'none') {
			$('#ATLSelect').empty();
			$.ajax({
				url : "/mdeforge/private/ATLTransformation/list",
				success : function(data) {
					$.each(data, function(i, ecore){
						$('#ATLSelect').append($('<option></option>').attr('value',ecore.id).text(ecore.name));
					});
				},
				error : function error(data) {
					console.log('error');
				}
			});
			$('#ATLToAdd').show();
		}
		else {
			$('#ATLToAdd').hide();
		}
	});
	
	$('#showEcoreList').click(function(event){
		if ($('#ecoreToAdd').css('display') == 'none') {
			$('#ecoreSelect').empty();
			$.ajax({
				url : "/mdeforge/private/EcoreMetamodel/list",
				success : function(data) {
					$.each(data, function(i, ecore){
						$('#ecoreSelect').append($('<option></option>').attr('value',ecore.id).text(ecore.name));
					});
				},
				error : function error(data) {
					console.log('error');
				}
			});
			$('#ecoreToAdd').show();
		}
		else {
			$('#ecoreToAdd').hide();
		}
	});
	
	//SHARE OR UNSHARE PROJECT
	
	$(document).on('click','#addUser', function(event){
		var idUser = $('#userSelect').val();
		var nameModel = $("#userSelect option:selected").text();
		var idProject = $("#projectId").attr('data-id');
		$.ajax({
			url : "/mdeforge/private/project/" + idProject + "/addUser/" + idUser,
			success : function(data) {
				var result = $('#users');
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/userBox.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
						});
				$("#userSelect option[value='" + idUser + "']").remove();
				$('#userList').hide();
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
			url : "/mdeforge/private/project/" + idProject + "/removeUser/" + idUser,
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
		console.log('asr');
		var idProject = $('#projectSelect').val();
		var idWorkspace = $("#workspaceId").data('id');
		var result = $('#projectList');
		$.ajax({
			url : "/mdeforge/private/workspace/" + idWorkspace + "/add/" + idProject,
			success : function(data) {
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/projectInArtifact.html',
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
			url : "/mdeforge/private/workspace/" + idWorkspace + "/remove/" + idProject,
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
				url : "/mdeforge/private/project/" + id,
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
						var  stringHead = '<li data-id="' + user.id + '" class="sharedUser"><span class="crt">' + (i + 1) + '</span><span class="strong">' +
				           		user.firstname + '  ' + user.lastname + '</span>' + 
				           		'<span class="muted"><a href="mailto:'+ user.email +
				           		'">'+ user.username +' <i class="icon-envelope"></i></a>';
						var stringDelete = '';
						if (guard)
							stringDelete = '<span class="pull-right glyphicons icon-remove removeSharedUser" data-id="' + user.id + '" ></span>';
						var stringTail = '</span></li>';
						$('#users').append(stringHead + stringDelete + stringTail);
					});
					$('#ecoreMMTable').empty();
					$('#atlTable').empty();
					$('#modelTable').empty();
					$.each(data.artifacts, function(i, artifact) {
						if(artifact._class == "org.mdeforge.business.model.EcoreMetamodel") {
							var result = $('#ecoreMMTable');
							artifact.ecoreMetamdel = true;
							$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										result.append(rendered);
								});
						}
						if(artifact._class == "org.mdeforge.business.model.ATLTransformation") {
							var result = $('#atlTable');
							artifact.ecoreMetamdel = true;
							$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										result.append(rendered);
								});
						}
						if(artifact._class == "org.mdeforge.business.model.Model") {
							var result = $('#modelTable');
							artifact.model = true;
							$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/artifactRowInWorkspace.html',
									function(template) {
										var rendered = Mustache.render(template, artifact);
										result.append(rendered);
								});
						}
					});
					$('#projectName').text(data.name);
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
		console.log('s');
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
			url : "/mdeforge/private/workspace/" + idWorkspace + "/addNew/" + idProject,
			success : function(data) {
				$.get('/mdeforge/resources/theme/scripts/plugins/forms/template/projectInArtifact.html',
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
		$('#userSelect').empty();
		if ($('#userList').css('display') == 'none') {
			$.ajax({
				url : "/mdeforge/private/user/list",
				success : function(data) {
					$.each(data, function(i, model){
						$('#userSelect').append($('<option></option>').attr('value',model.id).text(model.username));
					});
				},
				error : function error(data) {
					console.log('error');
				}
			});
			$('#userList').show();
		}
		else {
			$('#userList').hide();
		}
	});
	