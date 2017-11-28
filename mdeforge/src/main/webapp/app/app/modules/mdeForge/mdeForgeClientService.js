(function () {
	'use strict';

	angular
		.module('mdeForge')
		.service('mdeForgeClientService', mdeForgeClientService);

	/* @ngInject */
	function mdeForgeClientService($http, $q, mdeForge_SERVER_URL) {

		var OAUTH_PATH = 'oauth/token';

		/**
		 * The id of the client asking for aut
		 * @type {string}
		 */
		var CLIENT_ID = 'my-trusted-client';

		var GRANT_TYPE = 'password';

		var TOKEN = undefined;

		var USERNAME = '';
		var PASSWORD = '';

		return {
			getInstance: function () {

				var client = {}

				/**
				 *
				 * This private method builds the url for an OAuth request.
				 * @param username
				 * @param password
				 * @returns {string}
				 * @private
				 */
				client.__buildOAuthRequest = function (username, password) {
					var url = mdeForge_SERVER_URL + OAUTH_PATH;

					url += '?username=' + username;
					url += '&grant_type=' + GRANT_TYPE;
					url += '&client_id=' + CLIENT_ID;
					url += '&password=' + password;

					return encodeURI(url);
				}

				/**
				 * This method requests an access token for the
				 * specified couple < username, password >
				 * Returns a promise and automatically stores the token
				 * inside service.
				 * @param username
				 * @param password
				 * @returns {HttpPromise}
				 */
				client.setToken = function (username, password) {

					var deferred = $q.defer();

					var options = {
						url: client.__buildOAuthRequest(username, password),
						method: 'GET',
						headers: {}
					}

					$http(options).then(function (response) {
							TOKEN = response.data;
							USERNAME = username;
							PASSWORD = password;
							deferred.resolve(response);
						}, deferred.reject
					);

					return deferred.promise;
				}

				/**
				 *
				 * @param urlstring
				 * @returns {*}
				 * @private
				 */
				client.__buildRequestWithToken = function (urlstring) {

					urlstring = mdeForge_SERVER_URL + urlstring

					if (urlstring.indexOf('?') != -1)
						urlstring = urlstring + '&access_token=' + TOKEN.access_token
					else {
						urlstring = urlstring + '?access_token=' + TOKEN.access_token
					}

					return urlstring;
				}

				/**
				 *
				 * @param urlString
				 * @returns {*}
				 */
				client.doGetRequest = function (urlString) {

					var deferred = $q.defer();

					client.setToken(USERNAME, PASSWORD).then(
						function (response) {
							var options = {
								url: client.__buildRequestWithToken(urlString),
								method: 'GET',
								headers: {}
							}

							$http(options).then(deferred.resolve, deferred.reject);
						},
						deferred.reject
					)

					return deferred.promise
				}


				client.doPutRequest = function (urlString, data) {
					var deferred = $q.defer();

					client.setToken(USERNAME, PASSWORD).then(
						function (response) {
							var options = {
								url: client.__buildRequestWithToken(urlString),
								method: 'PUT',
								data: data,
								headers: {}
							}

							$http(options).then(deferred.resolve, deferred.reject);
						},
						deferred.reject
					)

					return deferred.promise
				}

				client.doPostRequest = function (urlString, data) {
					var deferred = $q.defer();

					client.setToken(USERNAME, PASSWORD).then(
						function (response) {
							var options = {
								url: client.__buildRequestWithToken(urlString),
								method: 'POST',
								data: data,
								headers: {}
							}

							$http(options).then(deferred.resolve, deferred.reject);
						},
						deferred.reject
					)

					return deferred.promise
				}

				client.doDeleteRequest = function (urlString) {
					var deferred = $q.defer();

					client.setToken(USERNAME, PASSWORD).then(
						function (response) {
							var options = {
								url: client.__buildRequestWithToken(urlString),
								method: 'DELETE',
								headers: {}
							}

							$http(options).then(deferred.resolve, deferred.reject);
						},
						deferred.reject
					)

					return deferred.promise
				}

				return client;
			}
		};

	}

})();

