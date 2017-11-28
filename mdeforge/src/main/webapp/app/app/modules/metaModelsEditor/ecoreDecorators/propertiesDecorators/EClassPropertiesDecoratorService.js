(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EClassPropertiesDecoratorService', EClassPropertiesDecoratorService);

	/* @ngInject */
	function EClassPropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
											  ECORE_TYPES,
											  rfc4122,
											  EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EClass, ecoreElement);
			}


			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'eSuperTypes': {
					type: ECORE_TYPES.EClass,
					multiple: true,
					supportedValues: function () {
						var classes = [];
						var elements = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass)
						angular.forEach(elements, function (item) {
							classes.push(item);
						});
						return classes;
					}
				},
				'abstract': {
					type: ECORE_TYPES.EBoolean
				},
				'interface': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();

