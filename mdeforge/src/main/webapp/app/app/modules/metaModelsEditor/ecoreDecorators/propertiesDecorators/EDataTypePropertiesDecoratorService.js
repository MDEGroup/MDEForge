(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EDataTypePropertiesDecoratorService', EDataTypePropertiesDecoratorService);

	/* @ngInject */
	function EDataTypePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												 ECORE_TYPES) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			var p = [
				"name",
				"eType",
				"ordered",
				"unique",
				"lowerBound",
				"upperBound",
				"many",
				"required",
				"changeable",
				"volatile",
				"transient",
				"defaultValueLiteral",
				"defaultValue",
				"unsettable",
				"derived",
			]

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				}
			}

			return ecoreElement

		};


		return service;

	}

})();

