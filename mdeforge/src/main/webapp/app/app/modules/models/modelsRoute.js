/**
 * Created by nicolasacco on 25/09/16.
 */

angular.module('models')
	.constant('MODELS', {
		'ROUTES': {
			'modelsList': 'home.models.modelsList',
			'modelsEditor': 'home.models.modelsEditor',
			'metaModelSelector': 'home.models.metaModelSelector'
		}
	})
	.config(['$stateProvider', function ($stateProvider) {

		var MODELS = {
			'ROUTES': {
				'modelsList': 'home.models.modelsList',
				'metaModelSelector': 'home.models.metaModelSelector',
				'modelsEditor': 'home.models.modelsEditor'
			}
		}

		$stateProvider
			.state('home.models', {
				url: '',
				abstract: true,
				templateUrl: 'app/modules/models/models.html',
				controller: 'HomeCtrl',
				controllerAs: 'vm'
			})
			.state(MODELS.ROUTES.modelsList, {
				url: '/modelsList',
				controller: 'ModelsListController',
				controllerAs: 'ctrl',
				templateUrl: 'app/modules/modelsBrowser/modelsList.html',
				title: 'Models'
			})
			.state(MODELS.ROUTES.metaModelSelector, {
				url: '/metaModelSelector',
				controller: 'MetaModelSelectorController',
				controllerAs: 'ctrl',
				templateUrl: 'app/modules/modelsEditor/metaModelSelector.html',
				title: 'Select a Meta Model'
			})
			.state(MODELS.ROUTES.modelsEditor, {
				url: '/modelsEditor/:metaModelId/:modelId',
				controller: 'ModelsEditorController',
				controllerAs: 'ctrl',
				templateUrl: 'app/modules/modelsEditor/modelsEditor.html',
				title: 'Models Editor',
				params: {
					modelId: null,
					metaModelId: null
				}
			});


	}]);
