/**
 * Created by nicolasacco on 30/10/16.
 */
(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EcoreDecoratorsRepoService', EcoreDecoratorsRepoService);


	/* @ngInject */
	function EcoreDecoratorsRepoService() {

		var REGISTERED_ELEMENTS = {}

		var ECORE_DECORATORS = {}

		return {
			registerDecorator: function (key, value) {
				ECORE_DECORATORS[key] = value;
			},
			getDecorator: function (key) {
				return ECORE_DECORATORS[key];
			},
			registerElement: function (type, element) {
				if (!angular.isDefined(REGISTERED_ELEMENTS[type])) {
					REGISTERED_ELEMENTS[type] = {};
				}

				if (angular.isDefined(element.eURI))
					REGISTERED_ELEMENTS[type][element.eURI()] = element;
				else
					REGISTERED_ELEMENTS[type][element.id] = element;
			},

			getElements: function (type) {
				return REGISTERED_ELEMENTS[type];
			},

			clearElements: function () {
				REGISTERED_ELEMENTS = [];
			}
		}

	} // fine service

})();

