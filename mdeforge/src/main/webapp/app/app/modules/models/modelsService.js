/**
 * Created by Nicola Sacco on 06/01/2017.
 */
(function () {
	'use strict';

	angular
		.module('models')
		.service('modelsService', ModelsService);


	/* @ngInject */
	function ModelsService($q, $mdToast, mdeForgeClientService, $timeout, rfc4122) {

		var META_MODELS_PATH_URL = 'api/EcoreMetamodel';

		var ARTIFACTS_PATH_URL = 'api/Artifact'

		var FAKE_WAIT_TIME = 500;

		var LOCAL_STORAGE_PREFIX = "mdeForge.model.";

		return {


			search: function (search) {
				var deferred = $q.defer();

				$timeout(function () {
					var models = [];

					angular.forEach(localStorage, function (item, key) {
						if (key.indexOf(LOCAL_STORAGE_PREFIX) == 0)
							models.push(JSON.parse(item));
					})

					deferred.resolve(models);

				}, FAKE_WAIT_TIME)
				return deferred.promise
			},

			/**
			 * This method is used to load the descriptions of all
			 * metamodels matching query
			 * @param query
			 * @returns {*}
			 */
			load: function (query, folder) {
				var deferred = $q.defer();

				$timeout(function () {
					var models = [];

					angular.forEach(localStorage, function (item, key) {
						if (key.indexOf(LOCAL_STORAGE_PREFIX) == 0)
							models.push(JSON.parse(item));
					})

					deferred.resolve(models);

				}, FAKE_WAIT_TIME)
				return deferred.promise
			},


			/**
			 * This method is used to load entirely a specific metaModel
			 * with a certain id
			 * @param id
			 */
			loadById: function (id) {

				var deferred = $q.defer();

				$timeout(function () {
					deferred.resolve(JSON.parse(localStorage.getItem(LOCAL_STORAGE_PREFIX + id.toString())));
				}, FAKE_WAIT_TIME)

				return deferred.promise;
			},

			/**
			 * This method is used to load entirely a specific metaModel
			 * with a certain id
			 * @param id
			 */
			loadFile: function (id) {

				var deferred = $q.defer();

				/**
				 * Simulating download of object,
				 * firstly retrieve the metaModel description json
				 * and after that download the model from file
				 */
				mdeForgeClientService.getInstance()
					.doGetRequest(META_MODELS_PATH_URL + '/metamodelJsonFormat/' + id)
					.then(
						function (response) {
							deferred.resolve(response.data);
						}, deferred.reject
					);

				return deferred.promise;
			},

			/**
			 * This method is used to load entirely a specific metaModel
			 * with a certain id
			 * @param id
			 */
			destroy: function (id) {

				var deferred = $q.defer();

				/**
				 * Simulating download of object,
				 * firstly retrieve the metaModel description json
				 * and after that download the model from file
				 */
				mdeForgeClientService.getInstance()
					.doDeleteRequest(META_MODELS_PATH_URL + '/' + id + '/')
					.then(
						function (response) {
							deferred.resolve(response.data);
						}, deferred.reject
					);

				return deferred.promise;
			},

			/**
			 * This method is used to store entirely a specific metaModel
			 * @param data
			 */
			store: function (data) {

				var deferred = $q.defer();

				if (!angular.isDefined(data.id)) {
					data.id = rfc4122.v4();
				}

				$timeout(function () {
					localStorage.setItem(LOCAL_STORAGE_PREFIX + data.id, JSON.stringify(data))
					deferred.resolve(data);
				});

				return deferred.promise;
			}
		}
	}

})();

