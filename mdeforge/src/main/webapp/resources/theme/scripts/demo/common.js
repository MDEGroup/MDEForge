/* ==========================================================
 * QuickAdmin v1.4.0
 * common.js
 * 
 * http://www.mosaicpro.biz
 * Copyright MosaicPro
 *
 * Built exclusively for sale @Envato Marketplaces
 * ========================================================== */ 

/* Utility functions */

// generate a random number
function randNum()
{
	return (Math.floor( Math.random()* (1+40-20) ) ) + 20;
}

function equalHeight(boxes)
{
	boxes.height('auto');
	var maxHeight = Math.max.apply( Math, boxes.map(function(){ return $(this).height(); }).get());
	boxes.height(maxHeight);
}

function PDFTarget(target)
{
	var doc = $('html').clone();
	var target = $(target).clone();
	var form = $('#PDFTargetForm');
	if (!form.length) {
		//$('body').append('<form id="PDFTargetForm"></form>');
		$('<form id="PDFTargetForm"></form>').appendTo('body');
		form = $('#PDFTargetForm');
	}
	
	form.attr('action', basePath + 'ajax.php?section=pdf');
	form.attr('method', 'POST');
	$('<input type="hidden" name="target" value="" />').appendTo(form);
	
	target.find('.hidden-print').remove();
	doc.find('body').html(target);
	var html = doc.html();
	
	form.find('input').val(html);
	form.submit();
}

function beautify(source)
{
	var output,
		opts = {};

    /*
    opts.indent_size = $('#tabsize').val();
    opts.indent_char = opts.indent_size == 1 ? '\t' : ' ';
    opts.max_preserve_newlines = $('#max-preserve-newlines').val();
    opts.preserve_newlines = opts.max_preserve_newlines !== -1;
    opts.keep_array_indentation = $('#keep-array-indentation').prop('checked');
    opts.break_chained_methods = $('#break-chained-methods').prop('checked');
    opts.indent_scripts = $('#indent-scripts').val();
    opts.brace_style = $('#brace-style').val();
    opts.space_before_conditional = $('#space-before-conditional').prop('checked');
    opts.unescape_strings = $('#unescape-strings').prop('checked');
    opts.wrap_line_length = $('#wrap-line-length').val();
    opts.space_after_anon_function = true;
    */
	
	opts.preserve_newlines = false;

	output = html_beautify(source, opts);
    return output;
}

// generate a random number within a range (PHP's mt_rand JavaScript implementation)
function mt_rand (min, max) 
{
	// http://kevin.vanzonneveld.net
	// +   original by: Onno Marsman
	// +   improved by: Brett Zamir (http://brett-zamir.me)
	// +   input by: Kongo
	// *     example 1: mt_rand(1, 1);
	// *     returns 1: 1
	var argc = arguments.length;
	if (argc === 0) {
		min = 0;
		max = 2147483647;
	}
	else if (argc === 1) {
		throw new Error('Warning: mt_rand() expects exactly 2 parameters, 1 given');
	}
	else {
		min = parseInt(min, 10);
		max = parseInt(max, 10);
	}
	return Math.floor(Math.random() * (max - min + 1)) + min;
}

// scroll to element animation
function scrollTo(id)
{
	if ($(id).length)
		$('html,body').animate({scrollTop: $(id).offset().top},'slow');
}

// handle menu toggle button action
function toggleMenuHidden()
{
	//console.log('toggleMenuHidden');
	$('.container-fluid:first').toggleClass('menu-hidden');
	$('#menu').toggleClass('hidden-phone', function()
	{
		if ($('.container-fluid:first').is('.menu-hidden'))
		{
			if (typeof resetResizableMenu != 'undefined') 
				resetResizableMenu(true);
		}
		else 
		{
			removeMenuHiddenPhone();
			
			if (typeof lastResizableMenuPosition != 'undefined') 
				lastResizableMenuPosition();
		}
		
		if (typeof $.cookie != 'undefined')
			$.cookie('menuHidden', $('.container-fluid:first').is('.menu-hidden'));
	});
	
	if (typeof masonryGallery != 'undefined') 
		masonryGallery();	
}

function removeMenuHiddenPhone()
{
	if (!$('.container-fluid:first').is('.menu-hidden') && $('#menu').is('.hidden-phone'))
		$('#menu').removeClass('hidden-phone');
}

// handle generate sparkline charts
function genSparklines()
{
	if ($('.sparkline').length)
	{
		$.each($('#content .sparkline'), function(k,v)
		{
			var size = { w: 150, h: 28 };
			if ($(this).parent().is('.widget-stats'))
				size = { w: 150, h: 35 }
			
			var color = primaryColor;
			if ($(this).is('.danger')) color = dangerColor;
			if ($(this).is('.success')) color = successColor;
			if ($(this).is('.warning')) color = warningColor;
			if ($(this).is('.inverse')) color = inverseColor;
			
			var data = [[1, 3+randNum()], [2, 5+randNum()], [3, 8+randNum()], [4, 11+randNum()],[5, 14+randNum()],[6, 17+randNum()],[7, 20+randNum()], [8, 15+randNum()], [9, 18+randNum()], [10, 22+randNum()]];
		 	$(v).sparkline(data, 
			{ 
				type: 'bar',
				width: size.w,
				height: size.h,
				stackedBarColor: ["#444", color],
				lineWidth: 2
			});
		});
		$.each($('#menu .sparkline'), function(k,v)
		{
			var size = { w: 150, h: 20 };
			if ($(this).parent().is('.widget-stats-3'))
				size = { w: 150, h: 35 }
			
			var color = primaryColor;
			if ($(this).is('.danger')) color = dangerColor;
			if ($(this).is('.success')) color = successColor;
			if ($(this).is('.warning')) color = warningColor;
			if ($(this).is('.inverse')) color = inverseColor;
			
			var data = [[1, 3+randNum()], [2, 5+randNum()], [3, 8+randNum()], [4, 11+randNum()],[5, 14+randNum()],[6, 17+randNum()],[7, 20+randNum()], [8, 15+randNum()], [9, 18+randNum()], [10, 22+randNum()]];
		 	$(v).sparkline(data, 
			{ 
				type: 'bar',
				width: size.w,
				height: size.h,
				stackedBarColor: ["#dadada", color],
				lineWidth: 2
			});
		});
	}
}

//handle generate easy-pie-charts
function genEasyPie()
{
	if ($('.easy-pie').length && $.fn.easyPieChart)
	{
		$.each($('.easy-pie'), function(k,v)
		{	
			var color = primaryColor;
			if ($(this).is('.danger')) color = dangerColor;
			if ($(this).is('.success')) color = successColor;
			if ($(this).is('.warning')) color = warningColor;
			if ($(this).is('.inverse')) color = inverseColor;
			
			$(v).easyPieChart({
				barColor: color,
				animate: ($('html').is('.ie') ? false : 3000),
                lineWidth: 4,
                size: 50
			});
		});
	}
}

/*
 * Helper function for JQueryUI Sliders Create event
 */
function JQSliderCreate()
{
	$(this)
		.removeClass('ui-corner-all ui-widget-content')
		.wrap('<span class="ui-slider-wrap"></span>')
		.find('.ui-slider-handle')
		.removeClass('ui-corner-all ui-state-default');
}

$(function()
{
	// Sidebar menu collapsibles
	$('#menu .collapse').on('show', function(e)
	{
		e.stopPropagation();
		$(this).parents('.hasSubmenu:first').addClass('active');
	})
	.on('hidden', function(e)
	{
		e.stopPropagation();
		$(this).parents('.hasSubmenu:first').removeClass('active');
	});
	
	// main menu visibility toggle
	$('.navbar.main .btn-navbar').click(function()
	{
		var disabled = typeof toggleMenuButtonWhileTourOpen != 'undefined' ? toggleMenuButtonWhileTourOpen(true) : false;
		if (!disabled)
			toggleMenuHidden();
	});
	
	// topnav toggle
	$('.navbar.main .toggle-navbar').click(function()
	{
		var that = $(this);
		
		if ($('.navbar.main .wrapper').is(':hidden'))
		{
			$(this).slideUp(20, function(){
				$('.navbar.main .wrapper').show();
				$('.navbar.main').animate({ height: 34 }, 200, function(){
					$('.navbar.main').toggleClass('navbar-hidden');
					that.slideDown();
				});
			});
		}
		else
		{
			$(this).slideUp(20, function(){
				$('.navbar.main').animate({ height: 0 }, 200, function(){
					$('.navbar.main .wrapper').hide();
					$('.navbar.main').toggleClass('navbar-hidden');
					that.slideDown();
				});
			});
		}
	});
	
	// multi-level top menu
	$('.submenu').hover(function()
	{
        $(this).children('ul').removeClass('submenu-hide').addClass('submenu-show');
    }, function()
    {
    	$(this).children('ul').removeClass('.submenu-show').addClass('submenu-hide');
    });
    //.find("a:first").append(" &raquo; ");
	
	// tooltips
	$('body').tooltip({ selector: '[data-toggle="tooltip"]' });
	
	// popovers
	$('[data-toggle="popover"]').popover();
	
	// save to PDF
	$('[data-toggle*="pdf"]').on('click', function(e){
		e.preventDefault();
		PDFTarget($(this).attr('data-target'));
	});
	
	// prettyphoto
	if ($('[data-toggle="prettyPhoto"]').length) 
		$('[data-toggle="prettyPhoto"]').prettyPhoto();
	
	// loading state for buttons
	$('[data-toggle*="btn-loading"]').click(function () {
        var btn = $(this);
        btn.button('loading');
        setTimeout(function () {
        	btn.button('reset')
        }, 3000);
    });
	$('[data-toggle*="button-loading"]').click(function () {
        var btn = $(this);
        btn.button('loading');
    });
	
	// typeahead
	if ($('[data-toggle="typeahead"]').length)
		$('[data-toggle="typeahead"]').typeahead({
			source: ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"],
			items: 4
		});
	
	// print
	$('[data-toggle="print"]').click(function(e)
	{
		e.preventDefault();
		window.print();
	});
	
	// carousels
	$('.carousel').carousel();
	
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
	
	$(document).on('click', '#addNewProject', function(event){
		event.stopPropagation();
		var idProject = $('#createProjectName').val();
		var nameProject = $(this).data('name');
		var idWorkspace = $("#workspaceId").data('id');
		$.ajax({
			url : "/mdeforge/private/workspace/" + idWorkspace + "/addNew/" + idProject,
			success : function(data) {
				$('#projectList').append('<li id="'+ data.id + '">'+
						'<div class="media innerAll">' +
							'<div class="pull-right glyphicons icon-remove remove-project" data-id="' + data.id + 
								'" data-name="' + data.name + '"></div>' +
							'<div class="media-body">' +
								'<span class="strong">' + data.name + '</span>' +
								'<span class="muted">Owner:</span>' +
								'<span class="muted">' + data.owner.username +
									'<a href="mailto:' + data.owner.email + '"><i class="icon-envelope"></i></a>' +
								'</span>' +
							'</div>' +
						'</div>' +
						'</li>' +
								'');
				$('#createNewProject').text('createProjectName');
				$('#createProject').hide();
				
				
			},
			error : function error(data) {
				console.log('error');
			}
			
		});
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
	
	$(document).on('click','#addEcore', function(event){
		var idEcore = $('#ecoreSelect').val();
		var nameEcore = $("#ecoreSelect option:selected").text();
		var idProject = $("#projectId").data('id');
		
		$.ajax({
			
			url : "/mdeforge/private/project/" + idProject + "/add/" + idEcore,
			success : function(data) {
				
				$('#ecoreMMTable').append('<tr id="'+ idEcore +'">' + 
						'<td>'  +
						'<i class="icon-remove-circle removeArtifact" data-id="' + idEcore + '"></i></td>' +
						'<td>' 
						+ '<a href="/mdeforge/private/EcoreMetamodel/metamodel_details?metamodel_id='+ idEcore + '">'
						+ nameEcore + 
						'</a></td></tr>');
				$("#ecoreSelect option[value='" + idEcore + "']").remove();
				$('#ecoreToAdd').hide();
			},
			error : function error(data) {
				$('#ecoreMMTable').append('<tr id="'+ idEcore +'">' + 
						'<td>'  +
						'<i class="icon-remove-circle removeArtifact" data-id="' + idEcore + '"></i></td>' +
						'<td>' 
						+ '<a href="/mdeforge/private/EcoreMetamodel/metamodel_details?metamodel_id='+ idEcore + '">'
						+ nameEcore + 
						'</a></td></tr>');
				$("#ecoreSelect option[value='" + idEcore + "']").remove();
				console.log('error');
				
			}
			
		});
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
	
	$(document).on('click','#addATL', function(event){
		var idATL = $('#ATLSelect').val();
		var nameModel = $("#ATLSelect option:selected").text();
		var idProject = $("#projectId").data('id');
		
		$.ajax({
			
			url : "/mdeforge/private/project/" + idProject + "/add/" + idATL,
			success : function(data) {
				
				$('#atlTable').append('<tr id="'+ idATL +'">' + 
						'<td>'  +
						'<i class="icon-remove-circle removeArtifact" data-id="' + idATL + '"></i></td>' +
						'<td>' 
						+ '<a href="/mdeforge/private/ATLTransformation/transformation_details?transformation_id='+ idATL + '">'
						+ nameModel + 
						'</a></td></tr>');
				$("#ATLSelect option[value='" + idATL + "']").remove();
				$('#ATLToAdd').hide();
			},
			error : function error(data) {
						console.log('error')
			}
			
		});
	});
	
	
	//
	$(document).on('click','#addUserArtifact', function(event){
		var idUser = $('#userSelect').val();
		var nameModel = $("#userSelect option:selected").text();
		var idArtifact = $("#artifactName").data('id');
		$.ajax({
			url : "/mdeforge/private/artifact/" + idArtifact + "/addUser/" + idUser,
			success : function(data) {
				console.log($('#users'))
				$('#users').append('<li class="userLi" data-id="' + data.id + 
						'" class="sharedUser"><span class="crt"></span><span class="strong">' +
						data.firstname + '  ' + data.lastname + '</span>' + 
						'<span class="muted"><a href="mailto:'+ data.email +
						'">'+ data.username +' <i class="icon-envelope"></i></a>' +
						'<span class="pull-right glyphicons icon-remove removeArtifactSharedUser" data-id="' + data.id + '" ></span>' +
				'</span></li>');
				$("#userSelect option[value='" + idUser + "']").remove();
				$('#userList').hide();
			},
			error : function error(data) {
				console.log('error')
			}
		});
	});
	//
	
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
	
	$(document).on('click','#addModel', function(event){
		var idModel = $('#modelSelect').val();
		var nameModel = $("#modelSelect option:selected").text();
		var idProject = $("#projectId").data('id');
		
		$.ajax({
			
			url : "/mdeforge/private/project/" + idProject + "/add/" + idModel,
			success : function(data) {
				
				$('#modelTable').append('<tr id="'+ idModel +'">' + 
						'<td>'  +
						'<i class="icon-remove-circle removeArtifact" data-id="' + idModel + '"></i></td>' +
						'<td>' 
						+ '<a href="/mdeforge/private/Model/model_details?model_id='+ idModel + '">'
						+ nameModel + 
						'</a></td></tr>');
				console.log('<td>'  +
						'<i class="icon-remove-circle removeArtifact" data-id="' + idModel + '"></i></td>' +
						'<td>' 
						+ '<a href="/mdeforge/private/Model/model_details?model_id='+ idModel + '">'
						+ nameModel + 
						'</a></td></tr>');
				$("#modelSelect option[value='" + idModel + "']").remove();
				$('#modelToAdd').hide();
				
			},
			error : function error(data) {
						console.log('error')
			}
			
		});
	});
	
	$(document).on('click','#addUser', function(event){
		var idUser = $('#userSelect').val();
		var nameModel = $("#userSelect option:selected").text();
		var idProject = $("#projectId").data('id');
		$.ajax({
			url : "/mdeforge/private/project/" + idProject + "/addUser/" + idUser,
			success : function(data) {
				$('#users').append('<li data-id="' + data.id + '" class="sharedUser"><span class="crt"></span><span class="strong">' +
						data.firstname + '  ' + data.lastname + '</span>' + 
				           '<span class="muted"><a href="mailto:'+ data.email +
				           '">'+ data.username +' <i class="icon-envelope"></i></a>' +
				           '<span class="pull-right glyphicons icon-remove removeSharedUser" data-id="' + data.id + '" ></span>' +
				           '</span></li>');
				$("#userSelect option[value='" + idUser + "']").remove();
				$('#userList').hide();
			},
			error : function error(data) {
				console.log('error')
			}
		});
	});
	
	
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
	
	$(document).on('click','#addProject', function(event){
		var idProject = $('#projectSelect').val();
		var idWorkspace = $("#workspaceId").data('id');
		
		$.ajax({
			
			url : "/mdeforge/private/workspace/" + idWorkspace + "/add/" + idProject,
			success : function(data) {
				$('#projectList').append('<li id="'+ data.id + '">'+
				'<div class="media innerAll">' +
					'<div class="pull-right glyphicons icon-remove remove-project" data-id="' + data.id + 
						'" data-name="' + data.name + '"></div>' +
					'<div class="media-body">' +
						'<span class="strong">' + data.name + '</span>' +
						'<span class="muted">Owner:</span>' +
						'<span class="muted">' + data.owner.username +
							'<a href="mailto:' + data.owner.email + '"><i class="icon-envelope"></i></a>' +
						'</span>' +
					'</div>' +
				'</div>' +
				'</li>' +
						'');
				$("#projectSelect option[value='" + idProject + "']").remove();
				$('#projectsToAdd').hide();
			},
			error : function error(data) {
				console.log('error');
				
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
	
	$(document).on('click','.removeArtifactSharedUser', function(event){
		var idArtifact = $("#artifactName").data('id');
		var idUser = $(this).data('id');
		$.ajax({
			url : "/mdeforge/private/artifact/" + idArtifact + "/removeUser/" + idUser,
			success : function(data) {
				$('.userLi[data-id="'+ idUser +'"]').remove();
				
			},
			error : function error(data) {
				console.log($('.userLi[data-id="'+ idUser +'"]'));
				$('.userLi[data-id="'+ idUser +'"]').remove();
				
			}
			
		});
		
	});
	
	// employees widget
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
					console.log(data.id);
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
					$.each(data.users, function(i, user) {
						$('#users').append('<li data-id="' + user.id + '" class="sharedUser"><span class="crt">' + (i + 1) + '</span><span class="strong">' +
								           user.firstname + '  ' + user.lastname + '</span>' + 
								           '<span class="muted"><a href="mailto:'+ user.email +
								           '">'+ user.username +' <i class="icon-envelope"></i></a>' +
								           '<span class="pull-right glyphicons icon-remove removeSharedUser" data-id="' + user.id + '" ></span>' +
								           '</span></li>');
						
					});
					$('#ecoreMMTable').empty();
					$('#atlTable').empty();
					$('#modelTable').empty();
					$.each(data.artifacts, function(i, artifact) {
						if(artifact._class == "org.mdeforge.business.model.EcoreMetamodel") {
							$('#ecoreMMTable').append('<tr id="'+ artifact.id +'">' + 
									'<td>'  +
									'<i class="icon-remove-circle removeArtifact" data-id="' + artifact.id + '"></i></td>' +
									'<td>' 
									+ '<a href="/mdeforge/private/EcoreMetamodel/metamodel_details?metamodel_id='+ artifact.id + '">'
									+ artifact.name + 
									'</a></td></tr>');
						}
						if(artifact._class == "org.mdeforge.business.model.ATLTransformation") {
							$('#atlTable').append('<tr id="'+ artifact.id +'">' +
									'<td>'  +
									'<i class="icon-remove-circle removeArtifact" data-id="' + artifact.id + '"></i></td>' +
									'<td>' 
									+ '<a href="/mdeforge/private/ATLTransformation/transformation_details?transformation_id='+ artifact.id + '">'
									+ artifact.name + 
									'</a></td></tr>');
						}
						if(artifact._class == "org.mdeforge.business.model.Model") {
							$('#modelTable').append('<tr id="'+ artifact.id +'">' +
									'<td>'  +
									'<i class="icon-remove-circle removeArtifact" data-id="' + artifact.id + '"></i></td>' +
									'<td>'
									+ '<a href="/mdeforge/private/Model/model_details?model_id='+ artifact.id + '">'
									+ artifact.name + 
									'</a></td></tr>');
						}
					});
					$('#projectName').text(data.name);
					//$('#ownerEmail').html('<i class="icon-envelope icon-li icon-fixed-width">'+ data.owner.email + '</i>');

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
	
	// gridalicious
	$('[data-toggle*="gridalicious"]').each(function(){
		var $that = $(this);
		$(this).gridalicious({
			gutter: $that.attr('data-gridalicious-gutter') || 13, 
			width: $that.attr('data-gridalicious-width') ? parseInt($that.attr('data-gridalicious-width')) : 200,
			animate: true,
			selector: '.widget'
		}).removeClass('hide');
	});
	
	// collapsible widgets
	$('.widget[data-toggle="collapse-widget"] .widget-body')
		.on('show', function(){
			$(this).parents('.widget:first').attr('data-collapse-closed', "false");
		})
		.on('shown', function(){
			setTimeout(function(){ $(window).resize(); }, 500);
		})
		.on('hidden', function(){
			$(this).parents('.widget:first').attr('data-collapse-closed', "true");
		});
	
	$('.widget[data-toggle="collapse-widget"]').each(function()
	{
		// append toggle button
		//$(this).find('.widget-head').append('<span class="collapse-toggle"></span>');
		$('<span class="collapse-toggle"></span>').appendTo($(this).find('.widget-head'));
		
		// make the widget body collapsible
		$(this).find('.widget-body').addClass('collapse');
		
		// verify if the widget should be opened
		if ($(this).attr('data-collapse-closed') !== "true")
			$(this).find('.widget-body').addClass('in');
		
		// bind the toggle button
		$(this).find('.collapse-toggle').on('click', function(){
			$(this).parents('.widget:first').find('.widget-body').collapse('toggle');
		});
	});
	
	// generate sparkline charts
	genSparklines();
	
	// generate easy-pie-charts
	genEasyPie();
	
	// Google Code Prettify
	if ($('.prettyprint').length)
		prettyPrint();
	
	// bind window resize event
	$(window).resize(function()
	{
		if ($('.widget-employees').length)
			equalHeight($('.widget-employees').find('.row-merge > [class*="span"]'));
	});
	
	// trigger window resize event
	$(window).on('load', function(){
		$(this).resize();
	});
	
	// view source toggle buttons
	$('.btn-source-toggle').click(function(e){
		e.preventDefault();
		$('.code:not(.show)').toggleClass('hide');
	});
	
	// source-code widgets
	$('[data-toggle="source-code"]').each(function(){
		var button = $('<span data-toggle="source-code-toggle" class="hidden-phone btn btn-toggle-code btn-mini btn-primary btn-icon glyphicons embed_close"><i></i> Source</span>');
		if ($(this).attr('data-placement') == 'outside') button.addClass('outside');
		//$(this).append(button);
		button.appendTo($(this));
		$(this).css('overflow', 'visible');
	}).on('click', '[data-toggle="source-code-toggle"]', function(){
		var html = $(this).parent().clone();
			html.find('[data-toggle="source-code-toggle"]').remove();
			html = beautify(html.html());
			html = $('<pre class="prettyprint"></pre>').text(html);
		
		bootbox.alert(html);
		
		if ($('.prettyprint').length)
			prettyPrint();
	});
	
	// reset themer
	$('[data-toggle="reset-themer"]').click(function(e){
		e.preventDefault();
		if (typeof updateTheme != 'undefined') {
			updateTheme(0);
		}
		location = $(this).attr('href');
	});
	
	// show/hide toggle buttons
	$('[data-toggle="hide"]').click(function()
	{
		if ($(this).is('.bootboxTarget'))
			bootbox.alert($($(this).attr('data-target')).html());
		else {
			$($(this).attr('data-target')).toggleClass('hide');
			if ($(this).is('.scrollTarget') && !$($(this).attr('data-target')).is('.hide'))
				scrollTo($(this).attr('data-target'));
		}
	});
	
	// handle menu position change
	$('#toggle-menu-position').on('change', function()
	{
		$('.container-fluid:first').toggleClass('menu-right');
		
		if ($(this).prop('checked')) 
			$('.container-fluid:first').removeClass('menu-left');
		else
			$('.container-fluid:first').addClass('menu-left');
		
		if (typeof $.cookie != 'undefined')
			$.cookie('rightMenu', $(this).prop('checked') ? $(this).prop('checked') : null);
		
		if (typeof resetResizableMenu != 'undefined' && typeof lastResizableMenuPosition != 'undefined')
		{
			resetResizableMenu(true);
			lastResizableMenuPosition();
		}
		removeMenuHiddenPhone();
	});
	
	// handle persistent menu position on page load
	if (typeof $.cookie != 'undefined' && $.cookie('rightMenu') && $('#toggle-menu-position').length)
	{
		$('#toggle-menu-position').prop('checked', true);
		$('.container-fluid:first').not('.menu-right').removeClass('menu-left').addClass('menu-right');
	}
	
	// handle layout type change
	$('#toggle-layout').on('change', function()
	{
		if ($(this).prop('checked'))
		{
			$('.container-fluid:first').addClass('fixed');
		}
		else
			$('.container-fluid:first').removeClass('fixed');
		
		if (typeof $.cookie != 'undefined')
		{
			$.cookie('layoutFixed', $(this).prop('checked') ? $(this).prop('checked') : null);
			$.cookie('layoutFluid', $(this).prop('checked') ? null : $(this).prop('checked'));
		}
	});
	
	// handle persistent layout type on page load
	if (typeof $.cookie != 'undefined' && $.cookie('layoutFixed') && $('#toggle-layout').length)
	{
		$('#toggle-layout').prop('checked', true);
		$('.container-fluid:first').addClass('fixed');
	}
	else if (!$('.container-fluid:first').is('.fixed') || (typeof $.cookie != 'undefined' && $.cookie('layoutFluid')))
	{
		$('#toggle-layout').prop('checked', false);
		$('.container-fluid:first').removeClass('fixed');
	}
	
	// handle persistent menu visibility on page load
	if (typeof $.cookie != 'undefined' && $.cookie('menuHidden') && $.cookie('menuHidden') == 'true' || (!$('.container-fluid').is('.menu-hidden') && !$('#menu').is(':visible')))
		toggleMenuHidden();
	else if ($('#menu').is(':visible'))
	{
		removeMenuHiddenPhone();
		
		if (typeof lastResizableMenuPosition != 'undefined') 
			lastResizableMenuPosition();
	}
	
	// menu slim scroll max height
	setTimeout(function()
	{
		var menu_max_height = parseInt($('#menu .slim-scroll').attr('data-scroll-height'));
		var menu_real_max_height = parseInt($('#wrapper').height());
		$('#menu .slim-scroll').slimScroll({
			height: (menu_max_height < menu_real_max_height ? (menu_real_max_height - 40) : menu_max_height) + "px",
			allowPageScroll : true,
			railDraggable: ($.fn.draggable ? true : false)
	    });
		
		if (Modernizr.touch)
			return; 
		
		// fixes weird bug when page loads and mouse over the sidebar (can't scroll)
		$('#menu .slim-scroll').trigger('mouseenter').trigger('mouseleave');
	}, 200);
	
	/* Slim Scroll Widgets */
	$('.widget-scroll').each(function(){
		$(this).find('.widget-body > div').slimScroll({
			height: $(this).attr('data-scroll-height')
	    });
	});
	
	/* Other non-widget Slim Scroll areas */
	$('#content .slim-scroll').each(function(){
		var scrollSize = $(this).attr('data-scroll-size') ? $(this).attr('data-scroll-size') : "7px";
		$(this).slimScroll({
			height: $(this).attr('data-scroll-height'),
			allowPageScroll : false,
			railVisible: false,
			size: '0',
			railDraggable: ($.fn.draggable ? true : false)
	    });
	});

	/* wysihtml5 */
	if ($('textarea.wysihtml5').size() > 0)
		$('textarea.wysihtml5').wysihtml5();
	
	/*
	 * Boostrap Extended
	 */
	// custom select for Boostrap using dropdowns
	if ($('.selectpicker').length) $('.selectpicker').selectpicker();
	
	// bootstrap-toggle-buttons
	if ($('.toggle-button').length) $('.toggle-button').toggleButtons();
	
	/*
	 * UniformJS: Sexy form elements
	 */
	if ($('.uniformjs').length) $('.uniformjs').find("select, input, button, textarea").uniform();
	
	// colorpicker
	if ($('#colorpicker').length) $('#colorpicker').farbtastic('#colorpickerColor');
	
	// datepicker
	if ($('#datepicker').length) $("#datepicker").datepicker({ showOtherMonths:true });
	if ($('#datepicker-inline').length) $('#datepicker-inline').datepicker({ inline: true, showOtherMonths:true });
	
	// daterange
	if ($('#dateRangeFrom').length && $('#dateRangeTo').length)
	{
		$( "#dateRangeFrom" ).datepicker({
			defaultDate: "+1w",
			changeMonth: false,
			numberOfMonths: 2,
			onClose: function( selectedDate ) {
				$( "#dateRangeTo" ).datepicker( "option", "minDate", selectedDate );
			}
		}).datepicker( "option", "maxDate", $('#dateRangeTo').val() );

		$( "#dateRangeTo" ).datepicker({
			defaultDate: "+1w",
			changeMonth: false,
			numberOfMonths: 2,
			onClose: function( selectedDate ) {
				$( "#dateRangeFrom" ).datepicker( "option", "maxDate", selectedDate );
			}
		}).datepicker( "option", "minDate", $('#dateRangeFrom').val() );
	}
	
	/* Table select / checkboxes utility */
	$('.checkboxs thead :checkbox').change(function(){
		if ($(this).is(':checked'))
		{
			$('.checkboxs tbody :checkbox').prop('checked', true).parent().addClass('checked');
			$('.checkboxs tbody tr.selectable').addClass('selected');
			$('.checkboxs_actions').show();
		}
		else
		{
			$('.checkboxs tbody :checkbox').prop('checked', false).parent().removeClass('checked');
			$('.checkboxs tbody tr.selectable').removeClass('selected');
			$('.checkboxs_actions').hide();
		}
	});
	
	$('.checkboxs tbody').on('click', 'tr.selectable', function(e){
		var c = $(this).find(':checkbox');
		var s = $(e.srcElement);
		
		if (e.srcElement.nodeName == 'INPUT')
		{
			if (c.is(':checked'))
				$(this).addClass('selected');
			else
				$(this).removeClass('selected');
		}
		else if (e.srcElement.nodeName != 'TD' && e.srcElement.nodeName != 'TR' && e.srcElement.nodeName != 'DIV')
		{
			return true;
		}
		else
		{
			if (c.is(':checked'))
			{
				c.prop('checked', false).parent().removeClass('checked');
				$(this).removeClass('selected');
			}
			else
			{
				c.prop('checked', true).parent().addClass('checked');
				$(this).addClass('selected');
			}
		}
		if ($('.checkboxs tr.selectable :checked').size() == $('.checkboxs tr.selectable :checkbox').size())
			$('.checkboxs thead :checkbox').prop('checked', true).parent().addClass('checked');
		else
			$('.checkboxs thead :checkbox').prop('checked', false).parent().removeClass('checked');

		if ($('.checkboxs tr.selectable :checked').size() >= 1)
			$('.checkboxs_actions').show();
		else
			$('.checkboxs_actions').hide();
	});
	
	if ($('.checkboxs tbody :checked').size() == $('.checkboxs tbody :checkbox').size() && $('.checkboxs tbody :checked').length)
		$('.checkboxs thead :checkbox').prop('checked', true).parent().addClass('checked');
	
	if ($('.checkboxs tbody :checked').length)
		$('.checkboxs_actions').show();
	
	$('.radioboxs tbody tr.selectable').click(function(e){
		var c = $(this).find(':radio');
		if (e.srcElement.nodeName == 'INPUT')
		{
			if (c.is(':checked'))
				$(this).addClass('selected');
			else
				$(this).removeClass('selected');
		}
		else if (e.srcElement.nodeName != 'TD' && e.srcElement.nodeName != 'TR')
		{
			return true;
		}
		else
		{
			if (c.is(':checked'))
			{
				c.attr('checked', false);
				$(this).removeClass('selected');				
			}
			else
			{
				c.attr('checked', true);
				$('.radioboxs tbody tr.selectable').removeClass('selected');
				$(this).addClass('selected');
			}
		}
	});
	
	// sortable tables
	if ($( ".js-table-sortable" ).length)
	{	
		$( ".js-table-sortable" ).sortable(
		{
			placeholder: "ui-state-highlight",
			items: "tbody tr",
			handle: ".js-sortable-handle",
			forcePlaceholderSize: true,
			helper: function(e, ui) 
			{
				ui.children().each(function() {
					$(this).width($(this).width());
				});
				return ui;
			},
			start: function(event, ui) 
			{
				if (typeof mainYScroller != 'undefined') mainYScroller.disable();
				ui.placeholder.html('<td colspan="' + $(this).find('tbody tr:first td').size() + '">&nbsp;</td>');
			},
		    stop: function() { if (typeof mainYScroller != 'undefined') mainYScroller.enable(); }
		});
	}
});