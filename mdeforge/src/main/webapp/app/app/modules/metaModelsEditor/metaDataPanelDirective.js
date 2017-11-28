(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('metaDataPanel', metaDataPanel);

	metaDataPanel.$inject = ['META_MODELS_EDITOR'];

	/* @ngInject */
	function metaDataPanel(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: MetaDataPanelController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/metaDataPanel.html',
			restrict: 'EA',
			scope: {
				artifact: '='
			}
		};
		return directive;
	}

	MetaDataPanelController.$inject = ['metaModelsService'];

	/* @ngInject */
	function MetaDataPanelController(metaModelsService) {

		var self = this;

		function init() {

		}


		self.init = init;

		init();

	}

})();


