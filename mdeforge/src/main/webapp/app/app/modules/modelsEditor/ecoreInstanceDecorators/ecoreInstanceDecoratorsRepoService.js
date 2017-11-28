/**
 * Created by nicolasacco on 30/10/16.
 */
(function () {
	'use strict';

	angular
		.module('ecoreInstanceDecorators')
		.service('EcoreInstanceDecoratorsRepoService', EcoreInstanceDecoratorsRepoService);


	/* @ngInject */
	function EcoreInstanceDecoratorsRepoService() {

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

