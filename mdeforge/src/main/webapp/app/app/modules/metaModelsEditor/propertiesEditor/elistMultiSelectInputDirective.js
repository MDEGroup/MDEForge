/**
 * Created by nicolasacco on 01/11/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('elistMultiSelectInputDirective', elistMultiSelectInputDirective);

	/* @ngInject */
	function elistMultiSelectInputDirective(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: EListMultiSelectInputDirectiveController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/propertiesEditor/elistMultiSelectInputDirective.html',
			restrict: 'EA',
			scope: {
				ngModel: '=',
				propertiesField: '='
			}
		};
		return directive;

	} // fine direttiva

	/* @ngInject */
	function EListMultiSelectInputDirectiveController($scope) {

		var self = this;

		// metodi
		self.init = init;

		self.arrayValues = [];
		self.initializing = false;
		self.updating = false;

		init();

		function init() {

		}

		$scope.$watch('ctrl.ngModel', function (newVal) {
			if (!self.updating) {
				self.initializing = true;
				self.arrayValues = self.ngModel.map(function (c) {
					return c;
				});
				self.initializing = false;
			}
		})

		$scope.$watch('ctrl.arrayValues', function (newVal) {
			if (!self.initializing) {
				self.updating = true;
				self.ngModel.clear();
				angular.forEach(self.arrayValues, function (item) {
					self.ngModel.add(item);
				});
				self.updating = false;
			}
		})

	}

})();

