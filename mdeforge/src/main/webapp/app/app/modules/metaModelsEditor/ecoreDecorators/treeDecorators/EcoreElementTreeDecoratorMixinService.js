(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EcoreElementTreeDecoratorMixinService', EcoreElementTreeDecoratorMixinService);

	/* @ngInject */
	function EcoreElementTreeDecoratorMixinService(EcoreDecoratorsRepoService,
												   ECORE_DECORATOR) {
		var service = {
			getDecoratorByElement: function (element) {
				return EcoreDecoratorsRepoService.getDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + element.eClass.values.name);
			},

			getDecoratorByTypeName: function (typeName) {
				return EcoreDecoratorsRepoService.getDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + typeName);
			},

			decorate: function (ecoreElement) {

			},

			buildNew: function (parent) {

			}


		}

		return service;
	}

})();

