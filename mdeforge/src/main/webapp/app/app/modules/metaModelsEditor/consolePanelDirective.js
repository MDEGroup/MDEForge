/**
 * Created by nicolasacco on 15/10/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('consolePanel', consolePanelDirective);

	/* @ngInject */
	function consolePanelDirective(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: ConsolePanelController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/consolePanel.html',
			restrict: 'EA',
			scope: {}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function ConsolePanelController($rootScope, ECORE_TREE_SERVICE_EVENTS) {

		var self = this;

		// proprietà
		self.logs = []

		// metodi
		self.init = init;

		init();

		// =============================================

		function init() {
			self.logs.push({date: new Date(), source: 'ConsolePanel', message: 'ConsolePanel activated'})
		}

		$rootScope.$on(ECORE_TREE_SERVICE_EVENTS.LOG, function (evt, data) {
			self.logs.push(data);
		});

	} // fine controller

})();

