(function () {
	'use strict';

	angular
		.module('ecoreInstanceDecorators')
		.service('EClassInstanceTreeDecoratorService', EClassInstanceTreeDecoratorService);

	/* @ngInject */
	function EClassInstanceTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
												ECORE_TYPES,
												rfc4122,
												EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreInstance, ecoreElement) {

			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EClass, ecoreElement);
			}
			return ecoreElement
		};

		service.buildNew = function (eClass, values) {
			var newEl = undefined;
			if (angular.isDefined(values)) {
				newEl = eClass.create(values);
			}
			else {
				newEl = eClass.create();
			}
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}


		return service;

	}

})();

