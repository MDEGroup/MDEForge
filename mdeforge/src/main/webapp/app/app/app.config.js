(function () {
	'use strict';

	/**
	 * @ngdoc configuration file
	 * @name app.config:config
	 * @description
	 * # Config and run block
	 * Configutation of the app
	 */


	angular
		.module('mmwe')
		.config(configure)
		.run(runBlock);

	configure.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider', '$httpProvider', '$mdThemingProvider'];

	function configure($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider, $mdThemingProvider) {

		$locationProvider.hashPrefix('!');
		$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
		$urlRouterProvider
			.otherwise('/dashboard');

		$mdThemingProvider.theme('docs-dark', 'default').primaryPalette('pink').dark();
	}

	runBlock.$inject = ['$rootScope', 'ActualUserService', '$state'];

	function runBlock($rootScope, ActualUserService, $state) {
		'use strict';
	}


})();
