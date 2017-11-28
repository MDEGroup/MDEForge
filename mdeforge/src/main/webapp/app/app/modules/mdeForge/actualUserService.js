/**
 * Created by Nicola Sacco on 27/12/2016.
 */
(function () {
	'use strict';

	angular
		.module('mdeForge')
		.service('ActualUserService', ActualUserService);

	ActualUserService.$inject = ['$q', '$timeout', 'mdeForgeClientService'];

	/* @ngInject */
	function ActualUserService($q, $timeout, mdeForgeClientService) {


		var STORAGE_USER_KEY = 'mdeForge.actualUser';

		var FAKE_WAIT_TIME = 500;


		var service = {
			getUser: function () {
				var deferred = $q.defer();

				$timeout(function () {
					var user = JSON.parse(localStorage.getItem(STORAGE_USER_KEY));
					deferred.resolve(user);
				}, FAKE_WAIT_TIME);

				return deferred.promise;
			},
			setUser: function (user) {
				var deferred = $q.defer();
				$timeout(function () {
					localStorage.setItem(STORAGE_USER_KEY, JSON.stringify(user));
					deferred.resolve(user);
				}, FAKE_WAIT_TIME);

				return deferred.promise;
			},
			logIn: function (username, password) {
				var deferred = $q.defer();
				mdeForgeClientService.getInstance().setToken(username, password).then(function (response) {
					service.getUser().then(function (user) {
						if (angular.isUndefined(user) || user == null) {
							user = {}
						}
						user.username = username;
						user.password = password;
						service.setUser(user).then(deferred.resolve);
					})
				}, deferred.reject);
				return deferred.promise;
			},

			logOut: function () {
				var deferred = $q.defer();
				$timeout(function () {
					localStorage.removeItem(STORAGE_USER_KEY);
					deferred.resolve();
				}, FAKE_WAIT_TIME);

				return deferred.promise;
			}
		}

		return service;

	}

})();

