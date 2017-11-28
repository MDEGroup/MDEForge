(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EClassTreeDecoratorService', EClassTreeDecoratorService);

	/* @ngInject */
	function EClassTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
										ECORE_TYPES,
										rfc4122,
										EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EClass, ecoreElement);
			}
			ecoreElement.supportedChildrenTypes = [
				ECORE_TYPES.EAttribute,
				ECORE_TYPES.EReference,
				ECORE_TYPES.EOperation
			]

			ecoreElement.children = ecoreElement.get('eStructuralFeatures').map(function (c) {

				var decorator = service.getDecoratorByElement(c)
				if (angular.isDefined(decorator))
					return decorator.decorate(c);
				else
					return c;
			});

			ecoreElement.tags = ecoreElement.get('eSuperTypes').map(function (c) {
				return c.values.name;
			});

			ecoreElement.newChildren = function (typeName) {
				var newEl = service.getDecoratorByTypeName(typeName).buildNew(parent);
				ecoreElement.children.push(newEl);
				ecoreElement.get('eStructuralFeatures').add(newEl);
			}

			ecoreElement.removeChildren = function (child) {
				if (ecoreElement.children.indexOf(child) != -1) {
					ecoreElement.children.splice(ecoreElement.children.indexOf(child), 1)
					var structFeatures = ecoreElement.get('eStructuralFeatures');
					structFeatures.remove(child);
				}
			}

			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EClass.create({
				name: 'aClass',
				eContainer: parent
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}


		return service;

	}

})();

