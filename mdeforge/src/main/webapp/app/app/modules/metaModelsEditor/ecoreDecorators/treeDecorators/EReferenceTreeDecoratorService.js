(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EReferenceTreeDecoratorService', EReferenceTreeDecoratorService);

	/* @ngInject */
	function EReferenceTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
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
			var newEl = Ecore.EReference.create({
				name: 'aReference',
				eContainer: parent,
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();

