(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EAttributePropertiesDecoratorService', EAttributePropertiesDecoratorService);

	/* @ngInject */
	function EAttributePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												  EcoreDecoratorsRepoService,
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
				},
				'eType': {
					type: ECORE_TYPES.EType,
					multiple: false,
					supportedValues: function () {
						var eDataTypes = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EDataType)
						var s_v = [
							Ecore.EString,
							Ecore.EInt,
							Ecore.EFloat,
							Ecore.EDouble,
							Ecore.EBoolean,
							Ecore.EDate
						]
						angular.forEach(eDataTypes, function (item) {
							s_v.push(item);
						})
						return s_v;
					}
				},
				'lowerBound': {
					type: ECORE_TYPES.EInt
				},
				'upperBound': {
					type: ECORE_TYPES.EInt
				},
				'defaultValue': {
					type: ECORE_TYPES.EString
				},
				'ordered': {
					type: ECORE_TYPES.EBoolean
				},
				'unique': {
					type: ECORE_TYPES.EBoolean
				},
				'required': {
					type: ECORE_TYPES.EBoolean
				},
				'changeable': {
					type: ECORE_TYPES.EBoolean
				},
				'volatile': {
					type: ECORE_TYPES.EBoolean
				},
				'transient': {
					type: ECORE_TYPES.EBoolean
				},
				'derived': {
					type: ECORE_TYPES.EBoolean
				},
				'unsettable': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();

