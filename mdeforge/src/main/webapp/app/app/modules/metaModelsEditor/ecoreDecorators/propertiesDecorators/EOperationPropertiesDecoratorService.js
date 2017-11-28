(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EOperationPropertiesDecoratorService', EOperationPropertiesDecoratorService);

	/* @ngInject */
	function EOperationPropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												  ECORE_TYPES,
												  EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'eType': {
					type: ECORE_TYPES.EType,
					multiple: false,
					supportedValues: function () {
						var classes = [];
						var elements = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass)
						angular.forEach(elements, function (item) {
							classes.push(item);
						});

						classes = classes.concat([
							Ecore.EString,
							Ecore.EInt,
							Ecore.EFloat,
							Ecore.EDouble,
							Ecore.EBoolean,
							Ecore.EDate
						])

						return classes;
					}
				},
				'lowerBound': {
					type: ECORE_TYPES.EInt
				},
				'upperBound': {
					type: ECORE_TYPES.EInt
				},
				'unique': {
					type: ECORE_TYPES.EBoolean
				},
				'required': {
					type: ECORE_TYPES.EBoolean
				},
				'changeable': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();

