/**
 * Created by nicolasacco on 25/09/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsBrowser')
		.controller('MetaModelsListController', MetaModelsListController);

	/* @ngInject */
	function MetaModelsListController($state, $scope, $mdToast, AntiBounceService, metaModelsService, META_MODELS) {

		var self = this;

		/**
		 * Properties
		 *
		 */
		self.loading = false;
		self.items = undefined;
		self.LAST_SEARCH_STORAGE_KEY = 'mdeForge.metaModelsListController.lastSearch'

		/**
		 * Public methods, invokable in templates
		 */
		self.init = init;
		self.editMetamodel = __editMetaModel;
		self.searchMetaModel = __searchMetaModel;
		self.newMetaModel = __newMetaModel;


		/**
		 * Invoking init at the creation of the controller.
		 */
		init();

		/**
		 * Starts loading for metamodels descriptions
		 */
		function init() {
			__loadLastSearch();

			$scope.$watch('ctrl.searchText', __searchMetaModel)
		}

		function __searchMetaModel(search) {
			if (angular.isDefined(search) && search != '') {
				AntiBounceService.do(function () {
					delete self.items;
					self.loading = true;
					__updateUserLastSearch(search);
					metaModelsService.search(search).then(__onMetaModelsLoaded, __onMetaModelsLoadingError)
				})
			}
		}


		function __loadLastSearch() {
			var lastSearch = JSON.parse(localStorage.getItem(self.LAST_SEARCH_STORAGE_KEY))
			if (angular.isDefined(lastSearch) && lastSearch != null) {
				self.items = lastSearch.items;
				self.lastSearchText = lastSearch.searchText;
			}
		}

		function __updateUserLastSearch() {
			localStorage.setItem(self.LAST_SEARCH_STORAGE_KEY, JSON.stringify({
				searchText: self.searchText,
				items: self.items
			}))
		}

		/**
		 * Assigns loaded meta models to items attribute then
		 * stops the loading
		 * @param meta_models
		 * @private
		 */
		function __onMetaModelsLoaded(meta_models) {

			self.items = meta_models;
			__updateUserLastSearch();
			self.loading = false;
		}

		/**
		 * Handles the loading error,
		 * doing nothing, for now XD
		 * @param response
		 * @private
		 */
		function __onMetaModelsLoadingError(response) {
			$mdToast.show(
				$mdToast.simple()
					.textContent("Spiacente, si è verificato un errore :(")
					.hideDelay(3000)
			);
		}

		/**
		 * Redirects to the metaModelsEditor
		 * with the metaModel passed as parameter
		 * @param mm
		 * @private
		 */
		function __editMetaModel(mm) {
			$state.go(META_MODELS.ROUTES.metaModelsEditor, {modelId: mm.id})
		}

		/**
		 * Redirects to the metaModelsEditor
		 * with no metaModel id
		 * @private
		 */
		function __newMetaModel() {
			$state.go(META_MODELS.ROUTES.metaModelsEditor)
		}

	} // fine controller

})();

