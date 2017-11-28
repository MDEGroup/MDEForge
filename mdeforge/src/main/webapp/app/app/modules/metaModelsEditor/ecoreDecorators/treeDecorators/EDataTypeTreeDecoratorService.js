(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EDataTypeTreeDecoratorService', EDataTypeTreeDecoratorService);

	/* @ngInject */
	function EDataTypeTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
										   rfc4122,
										   ECORE_TYPES,
										   EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EDataType, ecoreElement);
			}

			ecoreElement.supportedChildrenTypes = [];

			ecoreElement.newChildren = function (typeName) {
			}
			ecoreElement.removeChildren = function (child) {
			}


			return ecoreElement
		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EDataType.create({
				name: 'aDataType',
				eContainer: parent
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();

