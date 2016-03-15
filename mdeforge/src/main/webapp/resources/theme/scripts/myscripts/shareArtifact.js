	$(document).on('click','.removeSharedUser', function(event){
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
		var idUser = $('#userSelect').val();
		var nameModel = $("#userSelect option:selected").text();
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
			},
			error : function error(data) {
				console.log('error')
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
