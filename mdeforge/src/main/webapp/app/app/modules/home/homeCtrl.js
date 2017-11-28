(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.controller:HomeCtrl
	 * @description
	 * # HomeCtrl
	 * Controller of the app
	 */

	angular
		.module('mmwe')
		.controller('HomeCtrl', Home);

	Home.$inject = ['homeService', '$timeout', 'ActualUserService', '$state'];

	/*
	 * recommend
	 * Using function declarations
	 * and bindable members up top.
	 */

	function Home(homeService, $timeout, ActualUserService, $state) {
		/*jshint validthis: true */
		var vm = this;


		vm.original_title = "Welcome to MMWE";
		vm.appTitle = "mmwe"
		vm.title = '';
		var index = 0;


		vm.subtitle = "DISIM's Meta Model Web Editor";
		vm.version = "1.0.0";

		vm.loggingIn = true;

		ActualUserService.getUser().then(function (user) {
			if (angular.isDefined(user) && user != null)
				ActualUserService.logIn(user.username, user.password).then(function (user) {
					vm.loggingIn = false;
					vm.user = user;
					__typeTitle(index, 500);

				}, __goToLogin)
			else
				__goToLogin();
		}, __goToLogin)

		function __goToLogin() {
			$state.go('login');
		}


		vm.listFeatures = homeService.getFeaturesList();

		function __typeTitle(index, delay_constant) {
			vm.title = vm.title.replace('|', '')
			if (index < vm.original_title.length) {
				vm.title += vm.original_title.charAt(index) + '|';

				$timeout(function () {
					__typeTitle(index + 1, delay_constant)
				}, delay_constant * Math.random())
			}

		}


	}


})();
