	$(document).on('click','.removeSharedUser', function(event){
		debugger;
		var idArtifact = $("#artifactName").data('id');
		var idUser = $(this).data('id');
		$.ajax({
			url : ctx + "/private/artifact/" + idArtifact + "/removeUser/" + idUser,
			success : function(data) {
				$('.userLi[data-id="'+ idUser +'"]').remove();
			},
			error : function error(data) {
				$('.userLi[data-id="'+ idUser +'"]').remove();
				
			}
		});
	});
	
	$(document).on('click','.removeArtifactSharedUser', function(event){
		debugger;
		var idArtifact = $("#artifactName").data('id');
		var idUser = $(this).data('id');
		$.ajax({
			url : ctx + "/private/artifact/" + idArtifact + "/removeUser/" + idUser,
			success : function(data) {
				$('.userLi[data-id="'+ idUser +'"]').remove();
			},
			error : function error(data) {
				$('.userLi[data-id="'+ idUser +'"]').remove();
				
			}
		});
	});

	$(document).on('click','#addUserArtifact', function(event){
		debugger;
		var button = $(this);
		button.addClass("disabled-button");
		var select = $('#userSelect');
		var idUser = select.val();
		var nameUser = $("#userSelect option:selected").text();
		var idArtifact = $("#artifactName").data('id');
		$.ajax({
			url : ctx + "/private/artifact/" + idArtifact + "/addUser/" + idUser,
			success : function(data) {
				var result = $('#users');
				$.get(ctx + '/resources/theme/scripts/plugins/forms/template/userBox.html',
						function(template) {
							var rendered = Mustache.render(template, data);
							result.append(rendered);
						});
				$("#userSelect option[value='" + idUser + "']").remove();
				$('#userList').hide();
				button.removeClass("disabled-button");
				$.gritter.add({
					title: 'This artifact has been shared with '+ nameUser,
					text: ""
				});
				$('#showUserList').removeClass("rotate-item");
				
			},
			error : function error(data) {
				console.log('error')
				button.removeClass("disabled-button");
			}
		});
	});
	
	$(document).on('click','#showUserList',function(event){
		var button = $(this);
		button.addClass("disabled-button");
		var select = $('#userSelect');
		select.empty();
		if (!(button.hasClass("rotate-item"))) {
			$.ajax({
				url : ctx + "/private/user/list",
				success : function(data) {
					button.addClass("rotate-item").removeClass("disabled-button");
					var userid = $("#loggedUserId").val();	
					$.each(data, function(i, model){
						if(userid != model.id)
							select.append('<option value='+model.id+' >'+model.username+'</option>');
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
			$(this).removeClass('rotate-item disabled-button');
		}
	});
