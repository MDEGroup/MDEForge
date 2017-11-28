(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EAttributeTreeDecoratorService', EAttributeTreeDecoratorService);

	/* @ngInject */
	function EAttributeTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
											rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			ecoreElement.id = rfc4122.v4();

			ecoreElement.supportedChildrenTypes = []

			ecoreElement.newChildren = function (typeName) {
			}
			ecoreElement.removeChildren = function (child) {
			}
			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EAttribute.create({
				name: 'anAttribute',
				eContainer: parent,
				eType: Ecore.EString
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();

