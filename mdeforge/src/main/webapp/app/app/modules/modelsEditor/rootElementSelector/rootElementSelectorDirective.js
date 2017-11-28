/**
 * Created by nicolasacco on 07/01/17.
 */
(function () {
	'use strict';

	angular
		.module('modelsEditor')
		.directive('rootElementSelectorDirective', rootElementSelectorDirective);

	/* @ngInject */
	function rootElementSelectorDirective(MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: RootElementSelectorController,
			controllerAs: 'ctrl',
			templateUrl: MODELS_EDITOR.BASE_PATH + '/rootElementSelector/rootElementSelector.html',
			restrict: 'EA',
			scope: {
				onRootElementSelected: '='
			}
		};
		return directive;
	} // fine direttiva

	/* @ngInject */
	function RootElementSelectorController(EcoreDecoratorsRepoService, ECORE_TYPES) {

		var self = this;

		/**
		 * Public Methods
		 */
		self.init = init;
		self.selectRootElement = __selectRootElement;

		init();

		function init() {
			self.supportedEClasses = [];
			angular.forEach(EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass), function (item) {
				if (!item.values.abstract)
					self.supportedEClasses.push(item)
			})
		}

		function __selectRootElement(element) {
			if (angular.isDefined(self.onRootElementSelected))
				self.onRootElementSelected(element);
		}

	} // fine controller

})();

