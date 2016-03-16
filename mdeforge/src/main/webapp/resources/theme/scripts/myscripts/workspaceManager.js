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
				
			},
			error : function error(data) {
						console.log('error')
			}
		});
	});
	
	// SHOW ARTIFACT BY TYPE
	$('#showModelList').one("click", showModelList);
	function showModelList(event){
		var spinner = new Spinner().spin();
		$('#showModelList').parent().append(spinner.el);
		if ($('#modelToAdd').css('display') == 'none') {
			var ids =[];
			$('#modelTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$.ajax({
				url : ctx + "/private/Model/list",
				success : function(data) {
					$('#modelSelect').empty();
					$.each(data, function(i, model){
						if($.inArray(model.id, ids) < 0)
							$('#modelSelect').append($('<option></option>').attr('value',model.id).text(model.name));
					});
					spinner.stop();
					$('#modelToAdd').show();
					$(document).on('click','#showModelList', showModelList);
				},
				error : function error(data) {
					console.log('error');
				}
			});
			$('#modelToAdd').show();
		}
		else {
			$('#modelToAdd').hide();
			spinner.stop();
		}
	}
	
	$('#showATLList').one("click", showATLList);
	function showATLList(event){
		var spinner = new Spinner().spin();
		$('#showATLList').parent().append(spinner.el);
		if ($('#ATLToAdd').css('display') == 'none') {
			var ids =[];
			$('#atlTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$.ajax({
				url : ctx + "/private/ATLTransformation/list",
				success : function(data) {
					$('#ATLSelect').empty();
					$.each(data, function(i, atl){
						if( $.inArray(atl.id, ids) < 0)
							$('#ATLSelect').append($('<option></option>').attr('value',atl.id).text(atl.name));
					});
					spinner.stop();
					$('#ATLToAdd').show();
					$(document).on('click','#showATLList', showATLList);
				},
				error : function error(data) {
					console.log('error');
				}
			});
			$('#ATLToAdd').show();
		}
		else {
			$('#ATLToAdd').hide();
			spinner.stop();
		}
	}
	$('#showEcoreList').one("click",showEcoreList);
	function showEcoreList(event){
		var spinner = new Spinner().spin();
		$('#showEcoreList').parent().append(spinner.el);
		if ($('#ecoreToAdd').css('display') == 'none') {
			var ids =[];
			$('#ecoreMMTable > tbody  > tr').each(function() {
				ids.push(this.id);
			});
			$.ajax({
				url : ctx + "/private/EcoreMetamodel/list",
				success : function(data) {
					$('#ecoreSelect').empty();
					$.each(data, function(i, ecore){
						if($.inArray(ecore.id, ids) < 0)
							$('#ecoreSelect').append($('<option></option>').attr('value',ecore.id).text(ecore.name));
					});
					spinner.stop();
					$('#ecoreToAdd').show();
					$(document).on('click','#showEcoreList', showEcoreList);
					//$('#showEcoreList').one(showEcoreList);
				},
				error : function error(data) {
					console.log('error');
					spinner.stop();
				}
			});
			
		}
		else {
			$('#ecoreToAdd').hide();
			spinner.stop();
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
							var  stringHead = '<li data-id="' + user.id + '" class="sharedUser"><span class="crt">' + (i + 1) + '</span><span class="strong">' +
					           		user.firstname + '  ' + user.lastname + '</span>' + 
					           		'<span class="muted"><a href="mailto:'+ user.email +
					           		'">'+ user.username +' <i class="icon-envelope"></i></a>';
							var stringDelete = '';
							if (guard)
								stringDelete = '<span class="pull-right glyphicons icon-remove removeSharedUser" data-id="' + user.id + '" ></span>';
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
		$('#userSelect').empty();
		if ($('#userList').css('display') == 'none') {
			$.ajax({
				url : ctx + "/private/user/list",
				success : function(data) {
					$.each(data, function(i, model){
						if($("#loggedUserId").val() != model.id)
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
	