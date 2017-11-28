/**
 * Created by Nicola Sacco on 26/12/2016.
 */
(function () {
	'use strict';

	angular
		.module('mmwe')
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$state', 'ActualUserService'];

	/* @ngInject */
	function LoginController($state, ActualUserService) {
		var self = this;
		self.title = 'MMWE Login';
		self.username = undefined;
		self.password = undefined;

		activate();

		function activate() {

		}


		self.login = login;


		function login() {
			self.loading = true;
			ActualUserService.logIn(self.username, self.password).then(function (user) {
				self.loading = false;
				$state.go('home.dashboard');
			}, function () {
				self.loading = false;
			})
		}
	}

})();


