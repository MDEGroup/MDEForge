/**
 * Created by nicolasacco on 25/09/16.
 */

angular.module('metaModels')
	.constant('META_MODELS', {
		'ROUTES': {
			'metaModelsList': 'home.metaModels.metaModelsList',
			'metaModelsEditor': 'home.metaModels.metaModelsEditor'
		}
	})
	.config(['$stateProvider', function ($stateProvider) {

		var META_MODELS = {
			'ROUTES': {
				'metaModelsList': 'home.metaModels.metaModelsList',
				'metaModelsEditor': 'home.metaModels.metaModelsEditor'
			}
		}

		$stateProvider
			.state('home.metaModels', {
				url: '',
				abstract: true,
				templateUrl: 'app/modules/metaModels/metaModels.html',
				controller: 'HomeCtrl',
				controllerAs: 'vm'
			})
			.state(META_MODELS.ROUTES.metaModelsEditor, {
				url: '/metaModelsEditor/:modelId',
				controller: 'MetaModelsEditorController',
				controllerAs: 'ctrl',
				templateUrl: 'app/modules/metaModelsEditor/metaModelsEditor.html',
				title: 'Meta Models Editor',
				params: {
					modelId: null
				}
			})
			.state(META_MODELS.ROUTES.metaModelsList, {
				url: '/metaModelsList',
				controller: 'MetaModelsListController',
				controllerAs: 'ctrl',
				templateUrl: 'app/modules/metaModelsBrowser/metaModelsList.html',
				title: 'Meta Models'
			});

	}]);
