/**
 * Created by Nicola Sacco on 06/01/2017.
 */
(function () {
	'use strict';

	angular
		.module('modelsBrowser')
		.controller('ModelsListController', ModelsListController);

	/* @ngInject */
	function ModelsListController($state, $scope, $mdToast, AntiBounceService, modelsService, MODELS) {


		var self = this;

		self.newModel = __newModel;
		self.editModel = __editModel;


		/**
		 * Invoking init at the creation of the controller.
		 */
		init();

		/**
		 * Starts loading for metamodels descriptions
		 */
		function init() {
			//__loadLastSearch();

			$scope.$watch('ctrl.searchText', __searchModel)
		}

		function __searchModel(search) {
			if (angular.isDefined(search) && search != '') {
				AntiBounceService.do(function () {
					delete self.items;
					self.loading = true;
					modelsService.search(search).then(__onModelsLoaded, __onModelsLoadingError)
				})
			}
		}


		function __onModelsLoaded(models) {
			self.items = models;
			self.loading = false;
		}


		function __onModelsLoadingError() {

		}

		/**
		 * Redirects to the metaModelsEditor
		 * with no metaModel id
		 * @private
		 */
		function __newModel() {
			$state.go(MODELS.ROUTES.metaModelSelector)
		}


		function __editModel(model) {
			$state.go(MODELS.ROUTES.modelsEditor, {modelId: model.id, metaModelId: model.metamodel.id})
		}
	}

})();

