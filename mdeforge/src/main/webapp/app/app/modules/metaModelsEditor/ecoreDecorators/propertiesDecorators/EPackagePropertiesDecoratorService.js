(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EPackagePropertiesDecoratorService', EPackagePropertiesDecoratorService);

	/* @ngInject */
	function EPackagePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												ECORE_TYPES,
												rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'nsURI': {
					type: ECORE_TYPES.EString
				},
				'nsPrefix': {
					type: ECORE_TYPES.EString
				}
			}

			return ecoreElement

		};


		return service;

	}

})();

