(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.service:menuService
	 * @description
	 * # menuService
	 * Service of the app
	 */

	angular
		.module('mmwe')
		.factory('MenuService', Menu);

	// Inject your dependencies as .$inject = ['$http', '$otherDependency'];
	// function Name ($http, $otherDependency) {...}

	Menu.$inject = ['$http'];

	function Menu($http) {
		// Sample code.

		var menu = [
			{
				link: 'metaModels.metaModelsList',
				name: 'Meta Models',
				icon: 'folder'
			},
			{
				link: 'models.modelsList',
				name: 'Models',
				icon: 'folder'
			}];

		return {
			listMenu: function () {
				return menu;
			}
		};

	}

})();
