/**
 * Created by nicolasacco on 06/10/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('treeEcorePropertiesEditor', ecorePropertiesEditor);

	/* @ngInject */
	function ecorePropertiesEditor(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: TreeEcorePropertiesEditorController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/propertiesEditor/propertiesEditor.html',
			restrict: 'EA',
			scope: {
				rootTreeEcoreElement: '=',
				treeEcoreElement: '='
			}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function TreeEcorePropertiesEditorController($scope, EcoreDecoratorsRepoService, ECORE_DECORATOR) {

		var self = this;

		self.values = {};

		// metodi
		self.init = init;


		init();

		// =============================================

		function init() {

		}

		$scope.$watch('ctrl.treeEcoreElement', function () {
			EcoreDecoratorsRepoService
				.getDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + self.treeEcoreElement.eClass.values.name)
				.decorate(self.treeEcoreElement)
		});
	} // fine controller

})();

