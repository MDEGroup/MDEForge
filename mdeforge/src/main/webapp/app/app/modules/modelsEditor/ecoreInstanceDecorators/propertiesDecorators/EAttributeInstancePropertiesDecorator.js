(function () {
	'use strict';

	angular
		.module('ecoreInstanceDecorators')
		.service('EAttributeInstancePropertiesDecoratorService', EAttributeInstancePropertiesDecoratorService);

	/* @ngInject */
	function EAttributeInstancePropertiesDecoratorService(ECORE_TYPES,
														  rfc4122,
														  EcoreDecoratorsRepoService) {

		var service = {}

		service.decorate = function (ecoreInstance, ecoreElement) {
			
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

