/*!
* mmwe - v0.0.1 - MIT LICENSE 2017-09-22. 
* @author Nicola Sacco
*/
(function () {
	'use strict';

	/**
	 * @ngdoc index
	 * @name app
	 * @description
	 * # app
	 *
	 * Main module of the application.
	 */

	angular.module('mmwe', [
		'ngResource',
		'ngAria',
		'ngMaterial',
		'ngMdIcons',
		'ngMessages',
		'ngCookies',
		'ngAnimate',
		'ngSanitize',
		'ui.router',
		'md.data.table',
		'home',
		'ecoreDecorators',
		'login',
		'metaModels',
		'models'
	]);

})();

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

(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.module:homeModule
	 * @description
	 * # homeModule
	 * Module of the app
	 */

	angular.module('home', [])
		
})();

/**
 * Created by Nicola Sacco on 26/12/2016.
 */
angular
	.module('login', ['mdeForge'])

/**
 * Created by nicolasacco on 18/12/16.
 */
angular
	.module('mdeForge', [])
	.constant('mdeForge_SERVER_URL', 'http://www.mdeforge.org/');
	//.constant('mdeForge_SERVER_URL', 'http://localhost:8080/mdeforge/');

/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('metaModels', ['metaModelsEditor', 'metaModelsBrowser', 'mdeForge']);



/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('metaModelsBrowser', [])
	.constant('META_MODELS_BROWSER', {
		BASE_PATH: '/app/modules/metaModelsBrowser'
	});


/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('ecoreDecorators', ['uuid'])
	.constant('ECORE_DECORATOR', {
		'TREE_DECORATORS_PREFIX': 'TREE_',
		'PROPERTIES_DECORATORS_PREFIX': 'PROPERTIES_'
	}).constant('ECORE_TYPES', {

		/**
		 *
		 */
		EPackage: "EPackage",

		/**
		 *
		 */
		EClass: "EClass",

		/**
		 *
		 */
		EAttribute: "EAttribute",

		/**
		 *
		 */
		EReference: "EReference",

		/**
		 *
		 */
		EOperation: "EOperation",

		/**
		 *
		 */
		EChar: "EChar",

		/**
		 *
		 */
		EString: "EString",

		/**
		 *
		 */
		EInt: "EInt",

		/**
		 *
		 */
		EFloat: "EFloat",

		/**
		 *
		 */
		EDouble: "EDouble",

		/**
		 *
		 */
		EBoolean: "EBoolean",

		/**
		 *
		 */
		EByte: "EByte",

		/**
		 *
		 */
		EDate: "EDate",

		/**
		 *
		 */
		EType: "EType",

		/**
		 *
		 */
		EDataType: "EDataType"
	})
	.constant('ECORE_TREE_SERVICE_EVENTS', {
		/**
		 *
		 */
		LOG: 'LOG'
	})

	.run(function (ECORE_TYPES,
				   EcoreDecoratorsRepoService,
				   ECORE_DECORATOR,
				   EPackageTreeDecoratorService,
				   EClassTreeDecoratorService,
				   EAttributeTreeDecoratorService,
				   EReferenceTreeDecoratorService,
				   EOperationTreeDecoratorService,
				   EDataTypeTreeDecoratorService,
				   EPackagePropertiesDecoratorService,
				   EClassPropertiesDecoratorService,
				   EAttributePropertiesDecoratorService,
				   EReferencePropertiesDecoratorService,
				   EOperationPropertiesDecoratorService,
				   EDataTypePropertiesDecoratorService) {

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + ECORE_TYPES.EOperation,
			EOperationTreeDecoratorService);

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + ECORE_TYPES.EReference,
			EReferenceTreeDecoratorService);

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + ECORE_TYPES.EAttribute,
			EAttributeTreeDecoratorService);

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + ECORE_TYPES.EClass,
			EClassTreeDecoratorService);

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + ECORE_TYPES.EPackage,
			EPackageTreeDecoratorService);

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + ECORE_TYPES.EDataType,
			EDataTypeTreeDecoratorService);

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + ECORE_TYPES.EPackage,
			EPackagePropertiesDecoratorService)


		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + ECORE_TYPES.EClass,
			EClassPropertiesDecoratorService)

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + ECORE_TYPES.EAttribute,
			EAttributePropertiesDecoratorService)

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + ECORE_TYPES.EReference,
			EReferencePropertiesDecoratorService)

		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + ECORE_TYPES.EOperation,
			EOperationPropertiesDecoratorService)


		EcoreDecoratorsRepoService
			.registerDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + ECORE_TYPES.EDataType,
			EDataTypePropertiesDecoratorService);
	})





/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('metaModelsEditor', ['treeControl', 'md.data.table', 'picardy.fontawesome', 'uuid'])
	.constant('META_MODELS_EDITOR',
	{
		'EVENTS': {
			'MODEL_UPDATE_EVENT': 'META_MODELS_EDITOR.EVENTS.MODEL_UPDATE_EVENT'
		},
		'BASE_PATH': '/app/modules/metaModelsEditor'
	});

/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('models', ['modelsBrowser', 'modelsEditor', 'mdeForge']);



/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('modelsBrowser', [])
	.constant('MODELS_BROWSER', {
		BASE_PATH: '/app/modules/modelsBrowser'
	});


/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('ecoreInstanceDecorators', ['uuid'])
	.constant('ECORE_INSTANCE_DECORATOR', {
		'TREE_DECORATORS_PREFIX': 'TREE_',
		'PROPERTIES_DECORATORS_PREFIX': 'PROPERTIES_'
	})
	.constant('ECORE_INSTANCE_TREE_SERVICE_EVENTS', {
		/**
		 *
		 */
		LOG: 'LOG'
	})

	.run(function () {


	})





/**
 * Created by nicolasacco on 25/09/16.
 */
angular
	.module('modelsEditor', ['treeControl', 'md.data.table', 'picardy.fontawesome', 'uuid'])
	.constant('MODELS_EDITOR',
		{
			'EVENTS': {
				'MODEL_UPDATE_EVENT': 'MODELS_EDITOR.EVENTS.MODEL_UPDATE_EVENT'
			},
			'BASE_PATH': '/app/modules/modelsEditor'
		});

'use strict';

/**
 * @ngdoc function
 * @name app.route:HomeRoute
 * @description
 * # HomeRoute
 * Route of the app
 */

angular.module('mmwe')
	.config(['$stateProvider', function ($stateProvider) {
		$stateProvider

			.state('home', {
				url: '',
				abstract: true,
				templateUrl: 'app/modules/home/home.html',
				controller: 'HomeCtrl',
				controllerAs: 'vm'
			})
			.state('home.dashboard', {
				url: '/dashboard',
				templateUrl: 'app/modules/home/dashboard.html',
				title: 'Dashboard'
			});

	}]);


'use strict';

/**
 * @ngdoc function
 * @name app.route:HomeRoute
 * @description
 * # HomeRoute
 * Route of the app
 */

angular.module('login')
	.config(['$stateProvider', function ($stateProvider) {
		$stateProvider
			.state('login', {
				url: '/login',
				
				templateUrl: 'app/modules/login/login.html',
				controller: 'LoginController',
				controllerAs: 'ctrl'
			});
	}]);


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

(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.controller:LayoutCtrl
	 * @description
	 * # LayoutCtrl
	 * Controller of the app
	 */

	angular
		.module('mmwe')
		.controller('LayoutCtrl', Layout);

	Layout.$inject = ['$mdSidenav', '$scope', '$state', 'ActualUserService'];

	/*
	 * recommend
	 * Using function declarations
	 * and bindable members up top.
	 */

	function Layout($mdSidenav, $scope, $state, ActualUserService) {
		/*jshint validthis: true */
		var vm = this;


		vm.toggleSidenav = function (menuId) {
			$mdSidenav(menuId).toggle();
		};


		$scope.$on('$stateChangeSuccess', function () {
			vm.title = $state.current.title;
		})


		vm.logOut = function () {
			ActualUserService.logOut().then(function () {
				$state.go('login');
			});
		}

	}

})();

(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.controller:SidenavCtrl
	 * @description
	 * # SidenavCtrl
	 * Controller of the app
	 */
	angular
		.module('mmwe')
		.controller('SidenavCtrl', SidenavCtrl)
		.controller('SettingsCtrl', SettingsCtrl);

	// Injecting Denpendencies

	SidenavCtrl.$inject = ['$mdSidenav', '$state', '$mdBottomSheet', '$mdToast', 'MenuService', '$scope', '$timeout', '$interval', 'ActualUserService'];
	SettingsCtrl.$inject = ['$mdBottomSheet'];

	/*
	 * recommend
	 * Using function declarations
	 * and bindable members up top.
	 */

	function SidenavCtrl($mdSidenav, $state, $mdBottomSheet, $mdToast, MenuService, $scope, $timeout, $interval, ActualUserService) {
		/*jshint validthis: true */
		var vm = this;

		vm.original_title = 'mmwe';
		vm.title = '';

		vm.toggleSidenav = function (menuId) {
			$mdSidenav(menuId).toggle();
		};

		vm.closeSidenav = function () {
			$mdSidenav('left').close();
		};

		// Close menu on small screen after click on menu item.
		// Only use $scope in controllerAs when necessary; for example, publishing and subscribing events using $emit, $broadcast, $on or $watch.
		$scope.$on('$stateChangeSuccess', vm.closeSidenav);

		vm.menu = MenuService.listMenu();

		vm.admin = [
			{
				link: 'showListBottomSheet($event)',
				title: 'Settings',
				icon: 'settings'
			}
		];

		

		vm.navigateTo = function (target) {

			var page = target;

			$state.go(page);

		};

		vm.showSettingsBottom = function ($event) {
			vm.alert = '';
			$mdBottomSheet.show({
				template: '<md-bottom-sheet class="md-grid" layout="column" ng-cloak><div layout="row" layout-align="center center"><h4>With clickOutsideToClose option, drag down or press ESC to close</h4></div><md-list flex layout="row" layout-align="center center"><md-list-item ng-repeat="item in vm.items"><md-button class="md-grid-item-content" ng-click="vm.listItemClick($index)"><md-icon class="md-48">{{item.icon}}</md-icon><div class="md-grid-text"> {{ item.name }} </div></md-button></md-list-item></md-list></md-bottom-sheet>',
				controller: 'SettingsCtrl',
				controllerAs: 'vm',
				targetEvent: $event
			}).then(function (clickedItem) {
				$mdToast.show(
					$mdToast.simple()
						.content(clickedItem.name + ' clicked!')
						.position('top right')
						.hideDelay(2000)
				);
			});
		};

		$timeout(function () {
			__typeTitle(0, 1000)
		}, 2000)

		$interval(function () {
			vm.title = '';
			try {
				$interval.cancel(vm.blink_interval)
			} catch (e) {

			}
			$timeout(function () {
				__typeTitle(0, 1000)
			}, 1000)
		}, 10000)


		function __typeTitle(index, delay_constant) {

			vm.title = vm.title.replace('|', '')
			if (index < vm.original_title.length) {
				vm.title += vm.original_title.charAt(index) + '|';

				$timeout(function () {
					__typeTitle(index + 1, delay_constant)
				}, delay_constant * Math.random())
			} else {
				vm.title += '   ';
				vm.blink_interval = $interval(function () {
					if (vm.title.indexOf('|') == -1) {
						vm.title += '|'
					}
					else {
						vm.title = vm.title.replace('|', '')
					}
				}, 1000)
			}

		}

	}

	function SettingsCtrl($mdBottomSheet) {
		/*jshint validthis: true */
		var vm = this;

		vm.items = [
			{name: 'Roles', icon: 'assignment_ind'},
			{name: 'Notes', icon: 'speaker_notes'},
			{name: 'Tasks', icon: 'view_list'},
			{name: 'Inbox', icon: 'inbox'}
		];

		vm.listItemClick = function ($index) {
			var clickedItem = vm.items[$index];
			$mdBottomSheet.hide(clickedItem);
		};
	}

})();

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


/**
 * Created by nicolasacco on 25/09/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.controller('MetaModelsEditorController', MetaModelsEditorController);

	/* @ngInject */
	function MetaModelsEditorController($stateParams,
										$timeout,
										metaModelsService,
										$mdToast,
										META_MODELS,
										EcoreDecoratorsRepoService) {

		var self = this;

		self.editingPackage = undefined;


		self.init = init;
		self.store = __store;
		self.delete = __delete;
		self.export = _export;


		self.PANELS_MODE_AS_CARD = {
			label: 'as card',
			value: 'asCard'
		};
		self.PANELS_MODE_AS_SIDENAV = {
			label: 'as sidenav',
			value: 'asSidenav'
		};

		self.EDITOR_MODE_AS_TREE = {
			label: 'as tree',
			value: 'asTree'
		}


		self.ORIENTATION_ROW = 'row';
		self.ORIENTATION_COLUMN = 'column';

		self.settings = {
			orientation: self.ORIENTATION_ROW,
			panels: {
				mode: self.PANELS_MODE_AS_CARD
			},
			editor: {
				mode: self.EDITOR_MODE_AS_TREE
			}
		}


		init();


		function init() {
			EcoreDecoratorsRepoService.clearElements();
			self.metaModelId = $stateParams.modelId;
			if (self.metaModelId != null && self.metaModelId != '') {
				__loadMetaModel();
			} else {
				__initNewMetaModel();
			}
		}


		function __loadMetaModel() {
			var resourceSet = Ecore.ResourceSet.create();
			self.title = self.metaModelId;

			metaModelsService.loadById(self.metaModelId)
				.then(function (metaModelMetaData) {
					metaModelsService.loadFile(self.metaModelId)
						.then(function (metaModel) {
							try {
								var initModel = function (model) {
									self.selectedElement = model.get('contents').first();
									self.metaModel = metaModelMetaData;
									self.editingModel = model.get('contents').map(function (c) {
										return c;
									});
								}

								try {
									self.resource = resourceSet.create({uri: metaModelMetaData.uri[0]});
								} catch (e) {
									self.resource = resourceSet.create({uri: encodeURI(metaModelMetaData.name)});
								}

								self.resource.load(metaModel, initModel);

								self.modelIsSupported = true;
							} catch (e) {
								self.modelIsSupported = false;
							}
						})
				})
		}


		function __initNewMetaModel() {
			var resourceSet = Ecore.ResourceSet.create();
			self.metaModel = {
				_class: "org.mdeforge.business.model.EcoreMetamodel",
				name: 'aMetaModel.ecore',
				author: {},
				file: {
					fileName: ''
				}
			}

			self.resource = resourceSet.create({uri: '/model.json'});
			self.resource.get('contents').add(Ecore.EPackage.create({
				name: 'aPackage',
				nsPrefix: '',
				nsURI: ''
			}))


			self.editingModel = self.resource.get('contents').map(function (c) {
				return c;
			});

			self.selectedElement = self.resource.get('contents').first();

			self.modelIsSupported = true;
		}

		function __delete() {
			metaModelsService.destroy(self.metaModel.id).then(function (response) {
				$state.go(META_MODELS.ROUTES.metaModelsEditor)
			})
		}

		function __store() {
			var mm = angular.copy(self.metaModel)
			var xmi = self.resource.to(Ecore.XMI, true);
			mm.file.content = btoa(xmi + '\n');

			if (mm.file.fileName != self.metaModel.name) {
				mm.file.fileName = self.metaModel.name;
			}
			else {
				mm.file.fileName += '_updated'
			}
			self.posting = true;

			metaModelsService.store(mm).then(function (response) {

				$timeout(function () {
					self.posting = false;
					self.metaModel = response;
				}, 1000);

			}, function () {
				self.posting = false;
			});
		}

		function _export() {

			var element = document.createElement('a');
			element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(self.resource.to(Ecore.XMI, true)));
			element.setAttribute('download', 'export.ecore');
			element.style.display = 'none';
			document.body.appendChild(element);
			element.click();
			document.body.removeChild(element);
		}

	} // fine controller

})();


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


/**
 * Created by nicolasacco on 25/09/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsBrowser')
		.controller('MetaModelSelectorController', MetaModelSelectorController);

	/* @ngInject */
	function MetaModelSelectorController($state, $scope, $mdToast, AntiBounceService, metaModelsService, MODELS) {

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

		/**
		 *
		 * @param search
         * @private
         */
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

		/**
		 *
		 * @private
         */
		function __loadLastSearch() {
			var lastSearch = JSON.parse(localStorage.getItem(self.LAST_SEARCH_STORAGE_KEY))
			if (angular.isDefined(lastSearch) && lastSearch != null) {
				self.items = lastSearch.items;
				self.lastSearchText = lastSearch.searchText;
			}
		}

		/**
		 *
		 * @private
         */
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
			$state.go(MODELS.ROUTES.modelsEditor, {metaModelId: mm.id})
		}

	} // fine controller

})();


/**
 * Created by Nicola Sacco on 06/01/2017.
 */
(function () {
	'use strict';

	angular
		.module('modelsEditor')
		.controller('ModelsEditorController', ModelsEditorController);


	/* @ngInject */
	function ModelsEditorController($stateParams,
									$state,
									modelsService,
									ActualUserService,
									metaModelsService,
									$mdToast,
									MODELS,
									EcoreDecoratorsRepoService,
									ECORE_DECORATOR,
									ECORE_TYPES) {
		var self = this;

		/**
		 * Attributes
		 */
		self.rootElement = undefined;
		self.metaModel = undefined;
		self.metaModelMetaData = undefined;
		self.metaModelRootPackage = undefined;
		self.loading = true;

		/**
		 * Public Methods
		 */
		self.onRootElementSelected = __onRootElementSelected;
		self.export = _export;
		self.store = _store;

		init();

		function init() {
			/**
			 * Clear previously registered classes from other MetaModels
			 *
			 * OBS: This is similar to the registration of the metamodel in the eclipse workspace, it could be fixed by adding the uri to elements registration,
			 * sadly in many stored models the uri is not registered.
			 *
			 * By the way it is cleared at every page refresh.
			 *
			 * Todo: Fix by adding Complete Uri in registration of elements.
			 */
			EcoreDecoratorsRepoService.clearElements();

			if ($stateParams.metaModelId != null) {
				/**
				 * At least a metaModelId param has to be passed to URL in order to start editing a model
				 * @type {*|null}
				 */
				self.metaModelId = $stateParams.metaModelId;
				__loadMetaModel();
			} else {
				/**
				 * If no metaModelId is passed return to metaModelSelector and show the error to the user.
				 */
				$mdToast.show(
					$mdToast.simple()
						.textContent('No meta model selected.')
				);
				$state.go(MODELS.ROUTES.metaModelSelector)
			}
		}

		function __loadMetaModel() {
			/**
			 * Notify the downloading of the MetaModel
			 */
			$mdToast.show(
				$mdToast.simple()
					.textContent('Downloading MetaModel')
					.hideDelay(3000)
			);

			var resourceSet = Ecore.ResourceSet.create();

			/**
			 * Start the loading of the MetaModelMetaData
			 */
			metaModelsService.loadById(self.metaModelId)
				.then(function (metaModelMetaData) {
					/**
					 * Start the loading of MetaModel File
					 */
					metaModelsService.loadFile(self.metaModelId)
						.then(function (metaModel) {
							try {

								/**
								 * Define an onload function ( closure variables needed )
								 * @param model
								 */
								var initModel = function (model) {
									var contents = model.get('contents');

									self.metaModelMetaData = metaModelMetaData;

									self.metaModelRootPackages = model.get('contents').map(function (c) {
										return c;
									});

									self.metaModel = model;
									__onMetaModelLoaded();
								}


								try {
									/**
									 * If an URI is defined in metadata use it
									 */
									self.resource = resourceSet.create({uri: metaModelMetaData.uri[0]});
								} catch (e) {
									/**
									 * If it fails use the name of MetaModel
									 */
									self.resource = resourceSet.create({uri: encodeURI(metaModelMetaData.name)});
								}
								/**
								 * Start the decoding of the received file ( see EcoreJS implementation)
								 */
								self.resource.load(metaModel, initModel);

								self.modelIsSupported = true;
							} catch (e) {
								self.modelIsSupported = false;
							}
						})
				})
		}

		function __onMetaModelLoaded() {
			angular.forEach(self.metaModelRootPackages, function (item) {
				EcoreDecoratorsRepoService
					.getDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + item.eClass.values.name)
					.decorate(item);
			})

			if ($stateParams.modelId != null) {
				__loadModel($stateParams.modelId);
			} else {
				__initNewModel();
			}
		}


		function __initNewModel() {
			ActualUserService.getUser().then(function (user) {
				self.artifact = {
					name: 'aModel',
					metamodel: self.metaModelMetaData,
					author: user
				}
			})
			self.loading = false;
		}


		function __loadModel(id) {
			modelsService.loadById(id).then(function (model) {
				self.artifact = model;
				self.rootElement = loadPlainElement(model.model);
				self.selectedElement = self.rootElement;
				self.loading = false;
			})
		}

		function loadPlainElement(element) {
			var classes = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass);
			var clazz = classes [element._class];
			var instance = undefined;
			if (angular.isDefined(clazz)) {
				instance = clazz.create(element);
				instance.children = [];

				angular.forEach(element, function (item, key) {
					if (item != null)
						if (angular.isDefined(item._class)) {

							var child = loadPlainElement(item);
							instance.values[key] = child;
							child.parent = instance;
							/**
                             * Todo: Find correct reference and assign to child.parent_reference
							 * Todo: Something like child.parent_reference=clazz.get('eReferences')
							 */


							instance.children.push(instance.values[key]);
						} else {
							if (angular.isArray(item)) {
								angular.forEach(item, function (sub_item) {
									if (angular.isDefined(sub_item._class)) {
										var subInstance = loadPlainElement(sub_item);
										subInstance.parent = instance;
										instance.values[key].add(subInstance);
										instance.children.push(subInstance);
									}
								})
							}
						}
				})
			}

			return instance;

		}

		function __onRootElementSelected(element) {
			$mdToast.show(
				$mdToast.simple()
					.textContent(element.values.name + ' selected as root element')
					.hideDelay(3000)
			);
			self.rootElement = element.create();
			self.selectedElement = self.rootElement;
		}


		function getPlainModel(element) {
			if (element != null) {
				var plainElement = {
					//_class: element.eClass.values.name
					_class: element.eClass.eURI()
				}

				var attributes = element.eClass.get('eAllAttributes').map(function (c) {
					var attr = c.values;
					if (angular.isDefined(attr.eType) && attr.eType != null)
						attr.type = attr.eType.values.name;
					return attr;
				});

				angular.forEach(attributes, function (item) {
					plainElement[item.name] = element.values[item.name]
				});

				var references = element.eClass.get('eReferences').map(function (c) {
					return c;
				});

				angular.forEach(references, function (item) {

					if (item.values.upperBound == 1) {
						plainElement[item.values.name] = getPlainModel(element.values[item.values.name])
					} else {
						plainElement[item.values.name] = element.values[item.values.name].map(function (c) {
							return getPlainModel(c);
						})
					}

				});

				return plainElement;
			}
			else {
				return null;
			}

		}

		function _export() {

			var element = document.createElement('a');

			element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(JSON.stringify(getPlainModel(self.rootElement), null, '  ')));

			element.setAttribute('download', 'export.json');

			element.style.display = 'none';

			document.body.appendChild(element);

			element.click();

			document.body.removeChild(element);
		}

		function _store() {
			self.artifact.model = getPlainModel(self.rootElement);


			modelsService.store(self.artifact).then(function (data) {
				self.artifact = data;
				$stateParams.modelId = data.id;
			});
		}


	}

})();


(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.service:homeService
	 * @description
	 * # homeService
	 * Service of the app
	 */

	angular.module('mmwe')
		.factory('homeService', homeService);


	homeService.$inject = ['$http'];

	function homeService($http) {

		var STATUS_DONE = 'DONE';
		var STATUS_IN_PROGRESS = 'IN_PROGRESS';

		var list = [
			{"feature": "This Dashboard :)", status: STATUS_DONE},
			{"feature": "Meta Models Repository Browser", status: STATUS_DONE},
			{"feature": "Tree Editor for Meta Models", status: STATUS_DONE},
			{"feature": "Properties editor for Meta Models", status: STATUS_DONE},
			{"feature": "Meta Models Export in Ecore Json notation", status: STATUS_IN_PROGRESS},
			{"feature": "Integration with DISIM repository", status: STATUS_IN_PROGRESS},
		];

		return {
			getFeaturesList: getFeaturesList
		};

		function getFeaturesList() {
			return list;
		}

	}

})();

(function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name app.service:menuService
	 * @description
	 * # menuService
	 * Service of the app
	 */

	angular
		.module('mmwe')
		.factory('MenuService', Menu);

	// Inject your dependencies as .$inject = ['$http', '$otherDependency'];
	// function Name ($http, $otherDependency) {...}

	Menu.$inject = ['$http'];

	function Menu($http) {
		// Sample code.

		var menu = [
			{
				link: 'metaModels.metaModelsList',
				name: 'Meta Models',
				icon: 'folder'
			},
			{
				link: 'models.modelsList',
				name: 'Models',
				icon: 'folder'
			}];

		return {
			listMenu: function () {
				return menu;
			}
		};

	}

})();

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


(function () {
	'use strict';

	angular
		.module('mdeForge')
		.service('AntiBounceService', AntiBounceService);

	AntiBounceService.$inject = ['$timeout'];

	/* @ngInject */
	function AntiBounceService($timeout) {
		var service = {
			lastToken: undefined,
		}

		service.do = function (callback, antiBounceInterval) {
			if (angular.isUndefined(antiBounceInterval))
				antiBounceInterval = 500;

			try {
				$timeout.cancel(service.lastToken);
			} catch (e) {
			}

			service.lastToken = $timeout(callback, antiBounceInterval)

		}

		return service;
	}

})();

/**
 * Created by Nicola Sacco on 26/12/2016.
 */

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


(function () {
	'use strict';

	angular
		.module('metaModels')
		.service('metaModelsService', metaModelsService);

	/* @ngInject */
	function metaModelsService($q, $mdToast, mdeForgeClientService) {
		/**
		 * This service is used to load and post meta models from and to disim
		 * repository
		 * @type {string}
		 */

		var META_MODELS_PATH_URL = 'api/EcoreMetamodel';

		var ARTIFACTS_PATH_URL = 'api/Artifact'


		return {


			search: function (search) {
				var deferred = $q.defer();

				mdeForgeClientService.getInstance()
					.doGetRequest(ARTIFACTS_PATH_URL + '/search/' + search)
					.then(
					function (response) {
						deferred.resolve(response.data);
					}, deferred.reject
				);

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

				if (angular.isUndefined(folder)) {
					folder = 'shared'
				}

				mdeForgeClientService.getInstance()
					.doGetRequest(META_MODELS_PATH_URL + '/' + folder + '?limit=10')
					.then(
					function (response) {
						deferred.resolve(response.data);
					}, deferred.reject
				);

				return deferred.promise
			},


			/**
			 * This method is used to load entirely a specific metaModel
			 * with a certain id
			 * @param id
			 */
			loadById: function (id) {

				var deferred = $q.defer();

				/**
				 * Simulating download of object,
				 * firstly retrieve the metaModel description json
				 * and after that download the model from file
				 */
				mdeForgeClientService.getInstance()
					.doGetRequest(META_MODELS_PATH_URL + '/' + id)
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

				/**
				 * If id exists than we have to update, if not we have to post
				 * @see REST specification & guidelines
				 */
				if (angular.isDefined(data.id)) {
					mdeForgeClientService.getInstance()
						.doPutRequest(META_MODELS_PATH_URL, data)
						.then(
						function (response) {
							$mdToast.show($mdToast.simple().textContent('Stored :)'));
							deferred.resolve(response.data);
						}, deferred.reject
					);
				} else {
					mdeForgeClientService.getInstance()
						.doPostRequest(META_MODELS_PATH_URL, data)
						.then(
						function (response) {
							$mdToast.show($mdToast.simple().textContent('Stored :)'));
							deferred.resolve(response.data);
						}, deferred.reject
					);
				}
				return deferred.promise;
			}
		}


	} // fine service

})();


/**
 * Created by nicolasacco on 30/10/16.
 */
(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EcoreDecoratorsRepoService', EcoreDecoratorsRepoService);


	/* @ngInject */
	function EcoreDecoratorsRepoService() {

		var REGISTERED_ELEMENTS = {}

		var ECORE_DECORATORS = {}

		return {
			registerDecorator: function (key, value) {
				ECORE_DECORATORS[key] = value;
			},
			getDecorator: function (key) {
				return ECORE_DECORATORS[key];
			},
			registerElement: function (type, element) {
				if (!angular.isDefined(REGISTERED_ELEMENTS[type])) {
					REGISTERED_ELEMENTS[type] = {};
				}

				if (angular.isDefined(element.eURI))
					REGISTERED_ELEMENTS[type][element.eURI()] = element;
				else
					REGISTERED_ELEMENTS[type][element.id] = element;
			},

			getElements: function (type) {
				return REGISTERED_ELEMENTS[type];
			},

			clearElements: function () {
				REGISTERED_ELEMENTS = [];
			}
		}

	} // fine service

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EAttributePropertiesDecoratorService', EAttributePropertiesDecoratorService);

	/* @ngInject */
	function EAttributePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												  EcoreDecoratorsRepoService,
												  ECORE_TYPES) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			var p = [
				"name",
				"eType",
				"ordered",
				"unique",
				"lowerBound",
				"upperBound",
				"many",
				"required",
				"changeable",
				"volatile",
				"transient",
				"defaultValueLiteral",
				"defaultValue",
				"unsettable",
				"derived",
			]

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'eType': {
					type: ECORE_TYPES.EType,
					multiple: false,
					supportedValues: function () {
						var eDataTypes = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EDataType)
						var s_v = [
							Ecore.EString,
							Ecore.EInt,
							Ecore.EFloat,
							Ecore.EDouble,
							Ecore.EBoolean,
							Ecore.EDate
						]
						angular.forEach(eDataTypes, function (item) {
							s_v.push(item);
						})
						return s_v;
					}
				},
				'lowerBound': {
					type: ECORE_TYPES.EInt
				},
				'upperBound': {
					type: ECORE_TYPES.EInt
				},
				'defaultValue': {
					type: ECORE_TYPES.EString
				},
				'ordered': {
					type: ECORE_TYPES.EBoolean
				},
				'unique': {
					type: ECORE_TYPES.EBoolean
				},
				'required': {
					type: ECORE_TYPES.EBoolean
				},
				'changeable': {
					type: ECORE_TYPES.EBoolean
				},
				'volatile': {
					type: ECORE_TYPES.EBoolean
				},
				'transient': {
					type: ECORE_TYPES.EBoolean
				},
				'derived': {
					type: ECORE_TYPES.EBoolean
				},
				'unsettable': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EClassPropertiesDecoratorService', EClassPropertiesDecoratorService);

	/* @ngInject */
	function EClassPropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
											  ECORE_TYPES,
											  rfc4122,
											  EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EClass, ecoreElement);
			}


			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'eSuperTypes': {
					type: ECORE_TYPES.EClass,
					multiple: true,
					supportedValues: function () {
						var classes = [];
						var elements = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass)
						angular.forEach(elements, function (item) {
							classes.push(item);
						});
						return classes;
					}
				},
				'abstract': {
					type: ECORE_TYPES.EBoolean
				},
				'interface': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EDataTypePropertiesDecoratorService', EDataTypePropertiesDecoratorService);

	/* @ngInject */
	function EDataTypePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												 ECORE_TYPES) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			var p = [
				"name",
				"eType",
				"ordered",
				"unique",
				"lowerBound",
				"upperBound",
				"many",
				"required",
				"changeable",
				"volatile",
				"transient",
				"defaultValueLiteral",
				"defaultValue",
				"unsettable",
				"derived",
			]

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				}
			}

			return ecoreElement

		};


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EOperationPropertiesDecoratorService', EOperationPropertiesDecoratorService);

	/* @ngInject */
	function EOperationPropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												  ECORE_TYPES,
												  EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'eType': {
					type: ECORE_TYPES.EType,
					multiple: false,
					supportedValues: function () {
						var classes = [];
						var elements = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass)
						angular.forEach(elements, function (item) {
							classes.push(item);
						});

						classes = classes.concat([
							Ecore.EString,
							Ecore.EInt,
							Ecore.EFloat,
							Ecore.EDouble,
							Ecore.EBoolean,
							Ecore.EDate
						])

						return classes;
					}
				},
				'lowerBound': {
					type: ECORE_TYPES.EInt
				},
				'upperBound': {
					type: ECORE_TYPES.EInt
				},
				'unique': {
					type: ECORE_TYPES.EBoolean
				},
				'required': {
					type: ECORE_TYPES.EBoolean
				},
				'changeable': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EPackagePropertiesDecoratorService', EPackagePropertiesDecoratorService);

	/* @ngInject */
	function EPackagePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												ECORE_TYPES,
												rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'nsURI': {
					type: ECORE_TYPES.EString
				},
				'nsPrefix': {
					type: ECORE_TYPES.EString
				}
			}

			return ecoreElement

		};


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EReferencePropertiesDecoratorService', EReferencePropertiesDecoratorService);

	/* @ngInject */
	function EReferencePropertiesDecoratorService(EcoreElementPropertiesDecoratorMixinService,
												  ECORE_TYPES,
												  EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementPropertiesDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			ecoreElement.properties = {
				'name': {
					type: ECORE_TYPES.EString
				},
				'eType': {
					type: ECORE_TYPES.EType,
					multiple: false,
					supportedValues: function () {
						var classes = [];
						var elements = EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass)
						angular.forEach(elements, function (item) {
							classes.push(item);
						});
						return classes;
					}
				},
				'lowerBound': {
					type: ECORE_TYPES.EInt
				},
				'upperBound': {
					type: ECORE_TYPES.EInt
				},
				'unique': {
					type: ECORE_TYPES.EBoolean
				},
				'required': {
					type: ECORE_TYPES.EBoolean
				},
				'changeable': {
					type: ECORE_TYPES.EBoolean
				}
			}

			return ecoreElement

		};


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EcoreElementPropertiesDecoratorMixinService', EcoreElementPropertiesDecoratorMixinService);

	/* @ngInject */
	function EcoreElementPropertiesDecoratorMixinService(EcoreDecoratorsRepoService,
														 ECORE_DECORATOR) {



		var service = {
			getDecoratorByElement: function (element) {
				return EcoreDecoratorsRepoService
					.getDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + element.eClass.values.name);
			},

			getDecoratorByTypeName: function (typeName) {
				return EcoreDecoratorsRepoService
					.getDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + typeName);
			},

			decorate: function (ecoreElement) {

			}



		}

		return service;
	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EAttributeTreeDecoratorService', EAttributeTreeDecoratorService);

	/* @ngInject */
	function EAttributeTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
											rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			ecoreElement.id = rfc4122.v4();

			ecoreElement.supportedChildrenTypes = []

			ecoreElement.newChildren = function (typeName) {
			}
			ecoreElement.removeChildren = function (child) {
			}
			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EAttribute.create({
				name: 'anAttribute',
				eContainer: parent,
				eType: Ecore.EString
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EClassTreeDecoratorService', EClassTreeDecoratorService);

	/* @ngInject */
	function EClassTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
										ECORE_TYPES,
										rfc4122,
										EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {

			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EClass, ecoreElement);
			}
			ecoreElement.supportedChildrenTypes = [
				ECORE_TYPES.EAttribute,
				ECORE_TYPES.EReference,
				ECORE_TYPES.EOperation
			]

			ecoreElement.children = ecoreElement.get('eStructuralFeatures').map(function (c) {

				var decorator = service.getDecoratorByElement(c)
				if (angular.isDefined(decorator))
					return decorator.decorate(c);
				else
					return c;
			});

			ecoreElement.tags = ecoreElement.get('eSuperTypes').map(function (c) {
				return c.values.name;
			});

			ecoreElement.newChildren = function (typeName) {
				var newEl = service.getDecoratorByTypeName(typeName).buildNew(parent);
				ecoreElement.children.push(newEl);
				ecoreElement.get('eStructuralFeatures').add(newEl);
			}

			ecoreElement.removeChildren = function (child) {
				if (ecoreElement.children.indexOf(child) != -1) {
					ecoreElement.children.splice(ecoreElement.children.indexOf(child), 1)
					var structFeatures = ecoreElement.get('eStructuralFeatures');
					structFeatures.remove(child);
				}
			}

			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EClass.create({
				name: 'aClass',
				eContainer: parent
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EDataTypeTreeDecoratorService', EDataTypeTreeDecoratorService);

	/* @ngInject */
	function EDataTypeTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
										   rfc4122,
										   ECORE_TYPES,
										   EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EDataType, ecoreElement);
			}

			ecoreElement.supportedChildrenTypes = [];

			ecoreElement.newChildren = function (typeName) {
			}
			ecoreElement.removeChildren = function (child) {
			}


			return ecoreElement
		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EDataType.create({
				name: 'aDataType',
				eContainer: parent
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EOperationTreeDecoratorService', EOperationTreeDecoratorService);

	/* @ngInject */
	function EOperationTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
											rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			ecoreElement.id = rfc4122.v4();

			ecoreElement.supportedChildrenTypes = []

			ecoreElement.newChildren = function (typeName) {
			}
			ecoreElement.removeChildren = function (child) {
			}
			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EOperation.create({
				name: 'aOperation',
				eContainer: parent
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EPackageTreeDecoratorService', EPackageTreeDecoratorService);

	/* @ngInject */
	function EPackageTreeDecoratorService($rootScope, ECORE_TREE_SERVICE_EVENTS, EcoreElementTreeDecoratorMixinService,
										  ECORE_TYPES,
										  rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			ecoreElement.id = rfc4122.v4();

			var classifiers = ecoreElement.get('eClassifiers').map(function (c) {
				var decorator = service.getDecoratorByElement(c);
				if (angular.isDefined(decorator)) {
					return decorator.decorate(c);
				} else {
					var log = {
						date: new Date(),
						source: 'EPackageTreeDecoratorService',
					}
					try {
						log.message = "No decorator for " + c.eClass.values.name
						$rootScope.$broadcast(ECORE_TREE_SERVICE_EVENTS.LOG, log)
						console.log(log.message);
					} catch (e) {
						log.message = "Error " + e
						$rootScope.$broadcast(ECORE_TREE_SERVICE_EVENTS.LOG, log)
					}
					return c;
				}
			});

			var subPackages = ecoreElement.get('eSubPackages').map(function (c) {
				var decorator = service.getDecoratorByElement(c);
				if (angular.isDefined(decorator)) {
					return decorator.decorate(c);
				} else {
					var log = {
						date: new Date(),
						source: 'EPackageTreeDecoratorService',
					}
					try {
						log.message = "No decorator for " + c.eClass.values.name
						$rootScope.$broadcast(ECORE_TREE_SERVICE_EVENTS.LOG, log)
						console.log(log.message);
					} catch (e) {
						log.message = "Error " + e
						$rootScope.$broadcast(ECORE_TREE_SERVICE_EVENTS.LOG, log)
					}
					return c;
				}
			});

			ecoreElement.supportedChildrenTypes = [
				ECORE_TYPES.EPackage,
				ECORE_TYPES.EClass,
			]

			ecoreElement.children = classifiers.concat(subPackages);

			ecoreElement.newChildren = function (typeName) {

				var newEl = service.getDecoratorByTypeName(typeName).buildNew(parent);

				ecoreElement.children.push(newEl);

				if (typeName == ECORE_TYPES.EPackage)
					ecoreElement.get('eSubPackages').add(newEl);


				if (typeName == ECORE_TYPES.EClass)
					ecoreElement.get('eClassifiers').add(newEl);
			}

			ecoreElement.removeChildren = function (child) {
				if (child.eClass.values.name == ECORE_TYPES.EClass)
					ecoreElement.get('eClassifiers').remove(child);

				if (child.eClass.values.name == ECORE_TYPES.EPackage)
					ecoreElement.get('eSubPackages').remove(child);

				angular.forEach(ecoreElement.children, function (item, index) {
					if (item.id == child.id) {
						ecoreElement.children.splice(index, 1)
					}
				})
			}

			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EPackage.create({
					name: 'aPackage',
					eContainer: parent
				}
			)
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}


		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EReferenceTreeDecoratorService', EReferenceTreeDecoratorService);

	/* @ngInject */
	function EReferenceTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
											rfc4122) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreElement) {
			ecoreElement.id = rfc4122.v4();

			ecoreElement.supportedChildrenTypes = []

			ecoreElement.newChildren = function (typeName) {
			}
			ecoreElement.removeChildren = function (child) {
			}
			return ecoreElement

		};

		service.buildNew = function (parent) {
			var newEl = Ecore.EReference.create({
				name: 'aReference',
				eContainer: parent,
			})
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}

		return service;

	}

})();


(function () {
	'use strict';

	angular
		.module('ecoreDecorators')
		.service('EcoreElementTreeDecoratorMixinService', EcoreElementTreeDecoratorMixinService);

	/* @ngInject */
	function EcoreElementTreeDecoratorMixinService(EcoreDecoratorsRepoService,
												   ECORE_DECORATOR) {
		var service = {
			getDecoratorByElement: function (element) {
				return EcoreDecoratorsRepoService.getDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + element.eClass.values.name);
			},

			getDecoratorByTypeName: function (typeName) {
				return EcoreDecoratorsRepoService.getDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + typeName);
			},

			decorate: function (ecoreElement) {

			},

			buildNew: function (parent) {

			}


		}

		return service;
	}

})();


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


/**
 * Created by nicolasacco on 30/10/16.
 */
(function () {
	'use strict';

	angular
		.module('ecoreInstanceDecorators')
		.service('EcoreInstanceDecoratorsRepoService', EcoreInstanceDecoratorsRepoService);


	/* @ngInject */
	function EcoreInstanceDecoratorsRepoService() {

		var REGISTERED_ELEMENTS = {}

		var ECORE_DECORATORS = {}

		return {
			registerDecorator: function (key, value) {
				ECORE_DECORATORS[key] = value;
			},
			getDecorator: function (key) {
				return ECORE_DECORATORS[key];
			},
			registerElement: function (type, element) {
				if (!angular.isDefined(REGISTERED_ELEMENTS[type])) {
					REGISTERED_ELEMENTS[type] = {};
				}
				REGISTERED_ELEMENTS[type][element.id] = element;
			},

			getElements: function (type) {
				return REGISTERED_ELEMENTS[type];
			},

			clearElements: function () {
				REGISTERED_ELEMENTS = [];

			}
		}

	} // fine service

})();


(function () {
	'use strict';

	angular
		.module('ecoreInstanceDecorators')
		.service('EClassInstanceTreeDecoratorService', EClassInstanceTreeDecoratorService);

	/* @ngInject */
	function EClassInstanceTreeDecoratorService(EcoreElementTreeDecoratorMixinService,
												ECORE_TYPES,
												rfc4122,
												EcoreDecoratorsRepoService) {

		var service = {}

		service = angular.extend(service, EcoreElementTreeDecoratorMixinService);

		service.decorate = function (ecoreInstance, ecoreElement) {

			if (!angular.isDefined(ecoreElement.id)) {
				ecoreElement.id = rfc4122.v4();
				EcoreDecoratorsRepoService.registerElement(ECORE_TYPES.EClass, ecoreElement);
			}
			return ecoreElement
		};

		service.buildNew = function (eClass, values) {
			var newEl = undefined;
			if (angular.isDefined(values)) {
				newEl = eClass.create(values);
			}
			else {
				newEl = eClass.create();
			}
			return service.getDecoratorByElement(newEl).decorate(newEl);
		}


		return service;

	}

})();


/**
 * Created by nicolasacco on 15/10/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('consolePanel', consolePanelDirective);

	/* @ngInject */
	function consolePanelDirective(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: ConsolePanelController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/consolePanel.html',
			restrict: 'EA',
			scope: {}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function ConsolePanelController($rootScope, ECORE_TREE_SERVICE_EVENTS) {

		var self = this;

		// proprietà
		self.logs = []

		// metodi
		self.init = init;

		init();

		// =============================================

		function init() {
			self.logs.push({date: new Date(), source: 'ConsolePanel', message: 'ConsolePanel activated'})
		}

		$rootScope.$on(ECORE_TREE_SERVICE_EVENTS.LOG, function (evt, data) {
			self.logs.push(data);
		});

	} // fine controller

})();


/**
 * Created by nicolasacco on 29/10/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.filter('prettyJSON', function () {
			function prettyPrintJson(json) {
				return JSON ? JSON.stringify(json, null, '  ') : 'your browser doesnt support JSON so cant pretty print';
			}

			return prettyPrintJson;
		})
		.directive('jsonEcorePreview', jsonEcorePreviewDirective);


	/* @ngInject */
	function jsonEcorePreviewDirective(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: JsonEcorePreviewController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/JsonEcorePreview.html',
			restrict: 'EA',
			scope: {
				ecoreResource: '=?'
			}
		};
		return directive;
	}

	/* @ngInject */
	function JsonEcorePreviewController($scope, $rootScope, META_MODELS_EDITOR) {

		var self = this;

		// =============================================
		self.jsonResource = '{}';

		// metodi
		self.init = init;

		init();
		
		$rootScope.$on(META_MODELS_EDITOR.EVENTS.MODEL_UPDATE_EVENT, function (newVal) {
			self.jsonResource = self.ecoreResource.to();
		})

		function init() {


		}

	} // fine controller

})();


(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('metaDataPanel', metaDataPanel);

	metaDataPanel.$inject = ['META_MODELS_EDITOR'];

	/* @ngInject */
	function metaDataPanel(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: MetaDataPanelController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/metaDataPanel.html',
			restrict: 'EA',
			scope: {
				artifact: '='
			}
		};
		return directive;
	}

	MetaDataPanelController.$inject = ['metaModelsService'];

	/* @ngInject */
	function MetaDataPanelController(metaModelsService) {

		var self = this;

		function init() {

		}


		self.init = init;

		init();

	}

})();



/**
 * Created by nicolasacco on 01/11/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('elistMultiSelectInputDirective', elistMultiSelectInputDirective);

	/* @ngInject */
	function elistMultiSelectInputDirective(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: EListMultiSelectInputDirectiveController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/propertiesEditor/elistMultiSelectInputDirective.html',
			restrict: 'EA',
			scope: {
				ngModel: '=',
				propertiesField: '='
			}
		};
		return directive;

	} // fine direttiva

	/* @ngInject */
	function EListMultiSelectInputDirectiveController($scope) {

		var self = this;

		// metodi
		self.init = init;

		self.arrayValues = [];
		self.initializing = false;
		self.updating = false;

		init();

		function init() {

		}

		$scope.$watch('ctrl.ngModel', function (newVal) {
			if (!self.updating) {
				self.initializing = true;
				self.arrayValues = self.ngModel.map(function (c) {
					return c;
				});
				self.initializing = false;
			}
		})

		$scope.$watch('ctrl.arrayValues', function (newVal) {
			if (!self.initializing) {
				self.updating = true;
				self.ngModel.clear();
				angular.forEach(self.arrayValues, function (item) {
					self.ngModel.add(item);
				});
				self.updating = false;
			}
		})

	}

})();


/**
 * Created by nicolasacco on 06/10/16.
 */
(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('treeEcorePropertiesEditor', ecorePropertiesEditor);

	/* @ngInject */
	function ecorePropertiesEditor(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: TreeEcorePropertiesEditorController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/propertiesEditor/propertiesEditor.html',
			restrict: 'EA',
			scope: {
				rootTreeEcoreElement: '=',
				treeEcoreElement: '='
			}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function TreeEcorePropertiesEditorController($scope, EcoreDecoratorsRepoService, ECORE_DECORATOR) {

		var self = this;

		self.values = {};

		// metodi
		self.init = init;


		init();

		// =============================================

		function init() {

		}

		$scope.$watch('ctrl.treeEcoreElement', function () {
			EcoreDecoratorsRepoService
				.getDecorator(ECORE_DECORATOR.PROPERTIES_DECORATORS_PREFIX + self.treeEcoreElement.eClass.values.name)
				.decorate(self.treeEcoreElement)
		});
	} // fine controller

})();


/**
 * Created by nicolasacco on 27/09/16.
 */

(function () {
	'use strict';

	angular
		.module('metaModelsEditor')
		.directive('decoratedTreeEcoreEditor', decoratedTreeEcoreEditor);

	/* @ngInject */
	function decoratedTreeEcoreEditor(META_MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: DecoratedTreeEcoreEditorController,
			controllerAs: 'ctrl',
			templateUrl: META_MODELS_EDITOR.BASE_PATH + '/treeEditor/treeEditor.html',
			restrict: 'EA',
			scope: {
				ecoreResource: '=',
				editingModel: '=',
				selectedElement: '=?'
			}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function DecoratedTreeEcoreEditorController($scope,
												ECORE_DECORATOR,
												EcoreDecoratorsRepoService,
												ECORE_TYPES,
												$mdDialog,
												$rootScope,
												META_MODELS_EDITOR) {

		var self = this;


		self.ECORE_TYPE_ICONS = {}

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EPackage] = 'archive';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EClass] = 'class';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EAttribute] = 'list';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EReference] = 'swap_horiz';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EDataType] = 'text_format';

		self.ECORE_TYPES = ECORE_TYPES;

		self.treeOptions = {
			dirSelectable: true,
			multiSelection: false,
			allowDeselect: false,
			equality: function (o1, o2) {
				return o1.id == o2.id;
			},
			injectClasses: {
				ul: "a1",
				li: "a2",
				liSelected: "a7",
				iExpanded: "a3",
				iCollapsed: "a4",
				iLeaf: "a5",
				label: "a6",
				labelSelected: "a8"
			}
		}

		// =============================================

		self.expandedElements = [];

		self.supportedChildrenTypes = [];


		// metodi
		self.init = init;
		self.addChild = addChild;
		self.removeChild = removeChild;
		self.doCreateChild = doCreateChild;
		self.getSupportedChildrenTypes = getSupportedChildrenTypes;
		self.addChild = addChild;
		self.removeChild = removeChild;

		init();

		// =============================================

		function init() {
			__buildTree();
		}


		function __buildTree() {
			self.treeEcorePackage = []
			angular.forEach(self.editingModel, function (item) {
				self.treeEcorePackage.push(EcoreDecoratorsRepoService
					.getDecorator(ECORE_DECORATOR.TREE_DECORATORS_PREFIX + item.eClass.values.name)
					.decorate(item))
			})

		}

		function addChild(element) {
			self.creatingElement = true;
			self.showPrerenderedDialog();
		}

		function doCreateChild(child_type) {
			var newElement = self.selectedElement.newChildren(child_type);
			self.creatingElement = false;
			$mdDialog.hide();
			self.expandedElements.push(self.selectedElement);
		}

		function getSupportedChildrenTypes() {
			return self.selectedElement.supportedChildrenTypes;
		}

		function removeChild() {

			var parent = self.selectedElement.eContainer;

			if (angular.isDefined(parent)) {
				parent.removeChildren(self.selectedElement);
				self.selectedElement = parent;
			}

		}


		$scope.$watch('ctrl.selectedElement', function (newVal) {
			notifyUpdate();
		})


		self.showPrerenderedDialog = function (ev) {
			$mdDialog.show({
				controller: self,
				contentElement: '#addChildrenDialog',
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true
			});
		};


		function notifyUpdate() {
			$rootScope.$broadcast(META_MODELS_EDITOR.EVENTS.MODEL_UPDATE_EVENT);
		}

		self.export = function () {

			var element = document.createElement('a');
			element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(JSON.stringify(self.ecoreResource.to(), null, '  ')));
			element.setAttribute('download', 'export.json');
			element.style.display = 'none';
			document.body.appendChild(element);
			element.click();
			document.body.removeChild(element);
		}


	}

})
();


/**
 * Created by nicolasacco on 06/10/16.
 */
(function () {
	'use strict';

	angular
		.module('modelsEditor')
		.directive('ecoreInstancePropertiesEditor', ecoreInstancePropertiesEditor);

	/* @ngInject */
	function ecoreInstancePropertiesEditor(MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: TreeEcorePropertiesEditorController,
			controllerAs: 'ctrl',
			templateUrl: MODELS_EDITOR.BASE_PATH + '/propertiesEditor/propertiesEditor.html',
			restrict: 'EA',
			scope: {
				rootEcoreElement: '=',
				ecoreElement: '='
			}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function TreeEcorePropertiesEditorController($scope, EcoreDecoratorsRepoService, ECORE_DECORATOR, ECORE_TYPES) {

		var self = this;

		self.values = {};

		// metodi
		self.init = init;
		self.isTypeSupported = isTypeSupported;

		self.SUPPORTED_TYPES = ECORE_TYPES;

		init();

		// =============================================

		function init() {

		}

		function isTypeSupported(typeName) {
			return angular.isDefined(ECORE_TYPES[typeName]);
		}

		$scope.$watch('ctrl.ecoreElement', function () {
			if (angular.isDefined(self.ecoreElement)) {
				self.attributes = self.ecoreElement.eClass.get('eAllAttributes').map(function (c) {
					var attr = c.values;
					if (angular.isDefined(attr.eType) && attr.eType != null)
						attr.type = attr.eType.values.name;
					return attr;
				});
			}
		});

	} // fine controller

})();


/**
 * Created by nicolasacco on 07/01/17.
 */
(function () {
	'use strict';

	angular
		.module('modelsEditor')
		.directive('rootElementSelectorDirective', rootElementSelectorDirective);

	/* @ngInject */
	function rootElementSelectorDirective(MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: RootElementSelectorController,
			controllerAs: 'ctrl',
			templateUrl: MODELS_EDITOR.BASE_PATH + '/rootElementSelector/rootElementSelector.html',
			restrict: 'EA',
			scope: {
				onRootElementSelected: '='
			}
		};
		return directive;
	} // fine direttiva

	/* @ngInject */
	function RootElementSelectorController(EcoreDecoratorsRepoService, ECORE_TYPES) {

		var self = this;

		/**
		 * Public Methods
		 */
		self.init = init;
		self.selectRootElement = __selectRootElement;

		init();

		function init() {
			self.supportedEClasses = [];
			angular.forEach(EcoreDecoratorsRepoService.getElements(ECORE_TYPES.EClass), function (item) {
				if (!item.values.abstract)
					self.supportedEClasses.push(item)
			})
		}

		function __selectRootElement(element) {
			if (angular.isDefined(self.onRootElementSelected))
				self.onRootElementSelected(element);
		}

	} // fine controller

})();


/**
 * Created by nicolasacco on 27/09/16.
 */

(function () {
	'use strict';

	angular
		.module('modelsEditor')
		.directive('decoratedTreeEcoreInstanceEditor', decoratedTreeEcoreInstanceEditor);

	/* @ngInject */
	function decoratedTreeEcoreInstanceEditor(MODELS_EDITOR) {
		var directive = {
			bindToController: true,
			controller: DecoratedTreeEcoreEditorController,
			controllerAs: 'ctrl',
			templateUrl: MODELS_EDITOR.BASE_PATH + '/treeEditor/treeEditor.html',
			restrict: 'EA',
			scope: {
				rootElement: '=',
				selectedElement: '=?',
				ecoreResource: '='
			}
		};
		return directive;


	} // fine direttiva

	/* @ngInject */
	function DecoratedTreeEcoreEditorController($scope,
												ECORE_DECORATOR,
												EcoreDecoratorsRepoService,
												ECORE_TYPES,
												$mdDialog,
												$rootScope,
												META_MODELS_EDITOR, rfc4122) {

		var self = this;


		self.ECORE_TYPE_ICONS = {}

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EPackage] = 'archive';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EClass] = 'class';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EAttribute] = 'list';

		self.ECORE_TYPE_ICONS[ECORE_TYPES.EReference] = 'swap_horiz';

		self.ECORE_TYPES = ECORE_TYPES;

		self.treeOptions = {
			dirSelectable: true,
			multiSelection: false,
			allowDeselect: false,
			equality: function (o1, o2) {
				return o1.id == o2.id;
			},
			injectClasses: {
				ul: "a1",
				li: "a2",
				liSelected: "a7",
				iExpanded: "a3",
				iCollapsed: "a4",
				iLeaf: "a5",
				label: "a6",
				labelSelected: "a8"
			}
		}

		// =============================================

		self.expandedElements = [];

		self.supportedChildrenTypes = [];


		// metodi
		self.init = init;
		self.addChild = addChild;
		self.removeChild = removeChild;
		self.doCreateChild = doCreateChild;
		self.getSupportedChildrenTypes = getSupportedChildrenTypes;
		self.addChild = addChild;
		self.removeChild = removeChild;
		self.getLabel = getLabel;

		init();

		// =============================================

		function init() {
			__buildTree();
		}


		function __buildTree() {
			self.tree = [
				self.rootElement
			]
		}

		function addChild(element) {
			self.creatingElement = true;
			self.showPrerenderedDialog();
		}

		function doCreateChild(child_type) {
			var newElement = child_type.values.eType.create();

			newElement.id = rfc4122.v4();

			newElement.parent_reference = child_type;
			newElement.parent = self.selectedElement;

			if (child_type.values.upperBound == 1) {
				self.selectedElement.values[child_type.values.name] = newElement;
			} else {
				self.selectedElement.values[child_type.values.name].add(newElement);
			}

			if (angular.isUndefined(self.selectedElement.children))
				self.selectedElement.children = []

			self.selectedElement.children.push(newElement);

			self.creatingElement = false;

			$mdDialog.hide();

			self.expandedElements.push(self.selectedElement);
		}

		function getSupportedChildrenTypes() {


			var childTypes = [];
			if (angular.isDefined(self.selectedElement)) {
				childTypes = self.selectedElement.eClass.get('eReferences').map(function (c) {
					return c;
				});
			}
			var supportedChildTypes = [];

			angular.forEach(childTypes, function (item, key) {
				if (item.values.eType.values.abstract == false)
					if (canAddChild(item)) {
						supportedChildTypes.push(item)
					}
			});

			return supportedChildTypes;
		}

		function canAddChild(reference_instance) {

			/**
			 * Just be positive in life :)
			 * @type {boolean}
			 */
			var canAdd = true;

			/**
			 * The actual value of the property represented by the reference_instance in
			 * the actually editing "selectedElement" instance.
			 */
			var actualReferenceValue = self.selectedElement.values[reference_instance.values.name];

			/**
			 * Multiplicity is one for the selected reference so you can add iff
			 * the actualReferenceValue is undefined or null ( unset )
			 */
			if (reference_instance.values.upperBound == 1) {
				canAdd = angular.isUndefined(actualReferenceValue) || actualReferenceValue == null
			}

			/**
			 * Multiplicity is * for the selected reference so you can add
			 * in any case
			 */
			if (reference_instance.values.upperBound == -1) {
				canAdd = true;
			}

			/**
			 * Multiplicity is set for the selected reference so you can add
			 * only if actual size of actualReferenceValue is less than
			 * upperBound defined in reference_instance
			 */
			if (reference_instance.values.upperBound > 1) {

				canAdd = actualReferenceValue.size() < reference_instance.values.upperBound;
			}

			return canAdd;
		}

		function removeChild() {

			var parent = self.selectedElement.parent;
			var parent_reference = self.selectedElement.parent_reference;
			if (angular.isDefined(parent) && angular.isDefined(parent_reference)) {


				if (parent_reference.values.upperBound == 1) {
					parent.values[parent_reference.values.name] = null;
				} else {
					parent.values[parent_reference.values.name].remove(self.selectedElement);
				}

				parent.children.splice(parent.children.indexOf(self.selectedElement), 1);

				self.selectedElement = parent;
			}

		}

		$scope.$watch('ctrl.selectedElement', function (newVal) {
			notifyUpdate();
		})

		self.showPrerenderedDialog = function (ev) {
			$mdDialog.show({
				controller: self,
				contentElement: '#addChildrenDialog',
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true
			});
		};

		function notifyUpdate() {
			$rootScope.$broadcast(META_MODELS_EDITOR.EVENTS.MODEL_UPDATE_EVENT);
		}


		function getPlainModel(element) {
			if (element != null) {
				var plainElement = {}

				var attributes = element.eClass.get('eAllAttributes').map(function (c) {
					var attr = c.values;
					if (angular.isDefined(attr.eType) && attr.eType != null)
						attr.type = attr.eType.values.name;
					return attr;
				});

				angular.forEach(attributes, function (item) {
					plainElement[item.name] = element.values[item.name]
				});

				var references = element.eClass.get('eReferences').map(function (c) {
					return c;
				});

				angular.forEach(references, function (item) {

					if (item.values.upperBound == 1) {
						plainElement[item.values.name] = getPlainModel(element.values[item.values.name])
					} else {
						plainElement[item.values.name] = element.values[item.values.name].map(function (c) {
							return getPlainModel(c);
						})
					}

				});

				return plainElement;
			}
			else {
				return null;
			}

		}

		self.export = function () {

			var element = document.createElement('a');

			element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(JSON.stringify(getPlainModel(self.rootElement), null, '  ')));

			element.setAttribute('download', 'export.json');

			element.style.display = 'none';

			document.body.appendChild(element);

			element.click();

			document.body.removeChild(element);
		}


		function getLabel(node) {
			return node.values[Object.keys(node.values)[0]];
		}


	}

})
();

