/**
 * Created by nicolasacco on 29/10/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.filter('prettyJSON', function () {
			function prettyPrintJson(json) {
				return JSON ? JSON.stringify(json, null, '  ') : 'your browser doesnt support JSON so cant pretty print';
			}

			return prettyPrintJson;
		})
		.directive('jsonEcorePreview', jsonEcorePreviewDirective);


	/* @ngInject */
	function jsonEcorePreviewDirective(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: JsonEcorePreviewController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/JsonEcorePreview.html',
			restrict: 'EA',
			scope: {
				ecoreResource: '=?'
			}
		};
		return directive;
	}

	/* @ngInject */
	function JsonEcorePreviewController($scope, $rootScope, META_MODELS_EDITOR) {

		var self = this;

		// =============================================
		self.jsonResource = '{}';

		// metodi
		self.init = init;

		init();
		
		$rootScope.$on(META_MODELS_EDITOR.EVENTS.MODEL_UPDATE_EVENT, function (newVal) {
			self.jsonResource = self.ecoreResource.to();
		})

		function init() {


		}

	} // fine controller

})();

