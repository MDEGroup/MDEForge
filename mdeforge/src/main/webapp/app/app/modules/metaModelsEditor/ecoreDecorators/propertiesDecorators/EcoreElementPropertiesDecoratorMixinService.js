(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EcoreElementPropertiesDecoratorMixinService', EcoreElementPropertiesDecoratorMixinService);

	/* @ngInject */
	function EcoreElementPropertiesDecoratorMixinService(EcoreDecoratorsRepoService,
														 ECORE_DECORATOR) {



		var service = {
			getDecoratorByElement: function (element) {
				return EcoreDecoratorsRepoService
					.getDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + element.eClass.values.name);
			},

			getDecoratorByTypeName: function (typeName) {
				return EcoreDecoratorsRepoService
					.getDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + typeName);
			},

			decorate: function (ecoreElement) {

			}



		}

		return service;
	}

})();

