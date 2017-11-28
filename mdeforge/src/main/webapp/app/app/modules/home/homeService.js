(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.service:homeService
	 * @description
	 * # homeService
	 * Service of the app
	 */

	angular.module('mmwe')
		.factory('homeService', homeService);


	homeService.$inject = ['$http'];

	function homeService($http) {

		var STATUS_DONE = 'DONE';
		var STATUS_IN_PROGRESS = 'IN_PROGRESS';

		var list = [
			{"feature": "This Dashboard :)", status: STATUS_DONE},
			{"feature": "Meta Models Repository Browser", status: STATUS_DONE},
			{"feature": "Tree Editor for Meta Models", status: STATUS_DONE},
			{"feature": "Properties editor for Meta Models", status: STATUS_DONE},
			{"feature": "Meta Models Export in Ecore Json notation", status: STATUS_IN_PROGRESS},
			{"feature": "Integration with DISIM repository", status: STATUS_IN_PROGRESS},
		];

		return {
			getFeaturesList: getFeaturesList
		};

		function getFeaturesList() {
			return list;
		}

	}

})();
