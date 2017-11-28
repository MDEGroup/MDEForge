angular.module('mmwe').run(['$templateCache', function($templateCache) {
  'use strict';

  $templateCache.put('app/modules/home/dashboard.html',
    "<div class=\"md-padding\" layout-fill layout=\"column\" flex layout-align=\"center start\">\r" +
    "\n" +
    "	<div layout=\"row\">\r" +
    "\n" +
    "		<md-card flex=\"50\">\r" +
    "\n" +
    "			<md-toolbar class=\"md-hue-2\">\r" +
    "\n" +
    "				<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "					<h2>\r" +
    "\n" +
    "						<h1 class=\"title\">Welcome to <strong>mmwe</strong></h1>\r" +
    "\n" +
    "					</h2>\r" +
    "\n" +
    "					<span flex></span>\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "			</md-toolbar>\r" +
    "\n" +
    "			<md-card-content>\r" +
    "\n" +
    "				<h2>Hi {{vm.user.username}},</h2>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<p>\r" +
    "\n" +
    "					<strong>MMWE</strong> a.k.a. <strong>Meta Model Web Editor</strong>\r" +
    "\n" +
    "					allows you to create and edit Ecore (EMOF) based\r" +
    "\n" +
    "					Meta/Final Models stored in <a href=\"http://www.mdeForge.org\">mdeForge.org</a>.\r" +
    "\n" +
    "				</p>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<p>\r" +
    "\n" +
    "					The project is developed in collaboration with the <strong>Department of Computer Science and\r" +
    "\n" +
    "					Software\r" +
    "\n" +
    "					Engineering</strong> (DISIM in Italian)\r" +
    "\n" +
    "					of the <strong>University of L'Aquila</strong>.\r" +
    "\n" +
    "				</p>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<br>\r" +
    "\n" +
    "			</md-card-content>\r" +
    "\n" +
    "			<span flex></span>\r" +
    "\n" +
    "			<md-card-actions layout=\"row\" layout-align=\"end center\">\r" +
    "\n" +
    "				<a md-button class=\"md-primary\" href=\"https://github.com/nicfix/ecore-mmwe\">\r" +
    "\n" +
    "					<img class=\"png-icon\" src=\"/app/assets/images/GitHub-Mark-32px.png\" style=\"width: 16px; height: 16px;\">\r" +
    "\n" +
    "					MMWE\r" +
    "\n" +
    "				</a>\r" +
    "\n" +
    "				<a md-button class=\"md-primary\" href=\"https://github.com/MDEGroup/MDEForge\">\r" +
    "\n" +
    "					<img class=\"png-icon\" src=\"/app/assets/images/GitHub-Mark-32px.png\" style=\"width: 16px; height: 16px;\">\r" +
    "\n" +
    "					mdeForge.org\r" +
    "\n" +
    "				</a>\r" +
    "\n" +
    "			</md-card-actions>\r" +
    "\n" +
    "		</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-card flex=\"50\" layout=\"column\" ng-controller=\"MetaModelsListController as ctrl\"\r" +
    "\n" +
    "				 ng-show=\"ctrl.items.length>0\">\r" +
    "\n" +
    "			<md-toolbar class=\"md-hue-2\">\r" +
    "\n" +
    "				<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "					<h2>\r" +
    "\n" +
    "						<span class=\"title\">Metamodels for keyword \"{{ctrl.lastSearchText}}\"</span>\r" +
    "\n" +
    "					</h2>\r" +
    "\n" +
    "					<span flex></span>\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "			</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-subheader md-theme=\"docs-dark\" ng-if=\"ctrl.lastSearchText && !ctrl.searchText\"> * Your last search on\r" +
    "\n" +
    "				this browser\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-table-container ng-if=\"!ctrl.loading && ctrl.items.length>0\">\r" +
    "\n" +
    "				<table md-table>\r" +
    "\n" +
    "					<thead md-head>\r" +
    "\n" +
    "					<tr md-row>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Name\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Author\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Description\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</thead>\r" +
    "\n" +
    "					<tbody md-body>\r" +
    "\n" +
    "					<tr ng-repeat=\"item in ctrl.items | orderBy : 'name'\" ng-click=\"ctrl.editMetamodel(item)\"\r" +
    "\n" +
    "						md-row\r" +
    "\n" +
    "						style=\"cursor:pointer;\">\r" +
    "\n" +
    "						<td md-cell>{{item.name}}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.author.firstname }} {{ item.author.lastname }}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.description }}</td>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</tbody>\r" +
    "\n" +
    "				</table>\r" +
    "\n" +
    "			</md-table-container>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "		</md-card>\r" +
    "\n" +
    "	</div>\r" +
    "\n" +
    "	<div layout=\"row\" flex=\"50\">\r" +
    "\n" +
    "	</div>\r" +
    "\n" +
    "</div>\r" +
    "\n"
  );


  $templateCache.put('app/modules/home/home.html',
    "<md-sidenav layout=\"column\" class=\"md-sidenav-left md-whiteframe-z2\" md-component-id=\"left\"\r" +
    "\n" +
    "			md-is-locked-open=\"$mdMedia('gt-md')\" ng-if=\"!vm.loggingIn\">\r" +
    "\n" +
    "	<div ng-include=\"'/app/modules/layouts/side-nav/sidenav.html'\" flex></div>\r" +
    "\n" +
    "</md-sidenav>\r" +
    "\n" +
    "<div layout=\"column\" class=\"relative\" layout-fill role=\"main\" ng-controller=\"LayoutCtrl as layout\" ng-cloak\r" +
    "\n" +
    "	 ng-if=\"!vm.loggingIn\">\r" +
    "\n" +
    "	<md-toolbar>\r" +
    "\n" +
    "		<div ng-include=\"'/app/modules/layouts/tool-bar/toolbar.html'\"></div>\r" +
    "\n" +
    "	</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-content layout=\"column\" flex md-scroll-y style=\"background-color:#DCDCDC\">\r" +
    "\n" +
    "		<div ui-view flex=\"100\"></div>\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<div layout=\"column\" class=\"relative\" layout-fill role=\"main\" ng-if=\"vm.loggingIn\" ng-cloak>\r" +
    "\n" +
    "	<md-content layout-fill style=\"background-color:#DCDCDC\" layout=\"row\" layout-align=\"center center\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-card>\r" +
    "\n" +
    "			<md-progress-linear md-mode=\"indeterminate\"></md-progress-linear>\r" +
    "\n" +
    "			<div flex layout-align=\"center center\">\r" +
    "\n" +
    "				<h2 class=\"title\" style=\"text-align:center; font-weight: bold; padding-left:20px; padding-right:20px;\">\r" +
    "\n" +
    "					{{vm.appTitle}}</h2>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "</div>\r" +
    "\n"
  );


  $templateCache.put('app/modules/layouts/main-page/main-page.html',
    "<md-toolbar ng-show=\"!showSearch\">\r" +
    "\n" +
    "	<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "		<md-button ng-click=\"layout.toggleSidenav('left')\" hide-gt-md aria-label=\"Menu\">\r" +
    "\n" +
    "			<ng-md-icon icon=\"menu\"></ng-md-icon>\r" +
    "\n" +
    "		</md-button>\r" +
    "\n" +
    "		<h3>\r" +
    "\n" +
    "			<a href=\"/\">mmwe</a>\r" +
    "\n" +
    "		</h3>\r" +
    "\n" +
    "		<span flex></span>\r" +
    "\n" +
    "		<md-button aria-label=\"Search\" ng-click=\"showSearch = !showSearch\">\r" +
    "\n" +
    "			<ng-md-icon icon=\"search\"></ng-md-icon>\r" +
    "\n" +
    "		</md-button>\r" +
    "\n" +
    "		<md-menu>\r" +
    "\n" +
    "			<md-button aria-label=\"Open Settings\" ng-click=\"layout.openMenu($mdOpenMenu, $event)\">\r" +
    "\n" +
    "				<md-icon> more_vert</md-icon>\r" +
    "\n" +
    "			</md-button>\r" +
    "\n" +
    "			<md-menu-content width=\"4\">\r" +
    "\n" +
    "				<md-menu-item>\r" +
    "\n" +
    "					<md-button ng-click=\"layout.changeProfile($event)\">\r" +
    "\n" +
    "						<md-icon>face</md-icon>\r" +
    "\n" +
    "						Profile\r" +
    "\n" +
    "					</md-button>\r" +
    "\n" +
    "				</md-menu-item>\r" +
    "\n" +
    "				<md-menu-item>\r" +
    "\n" +
    "					<md-button ng-click=\"layout.changePassword()\">\r" +
    "\n" +
    "						<md-icon>lock</md-icon>\r" +
    "\n" +
    "						Password\r" +
    "\n" +
    "					</md-button>\r" +
    "\n" +
    "				</md-menu-item>\r" +
    "\n" +
    "				<md-menu-divider></md-menu-divider>\r" +
    "\n" +
    "				<md-menu-item>\r" +
    "\n" +
    "					<md-button ng-click=\"layout.logOut()\">\r" +
    "\n" +
    "						<md-icon>power_settings_new</md-icon>\r" +
    "\n" +
    "						Logout\r" +
    "\n" +
    "					</md-button>\r" +
    "\n" +
    "				</md-menu-item>\r" +
    "\n" +
    "			</md-menu-content>\r" +
    "\n" +
    "		</md-menu>\r" +
    "\n" +
    "	</div>\r" +
    "\n" +
    "</md-toolbar>\r" +
    "\n" +
    "<md-toolbar class=\"md-hue-1\" ng-show=\"showSearch\">\r" +
    "\n" +
    "	<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "		<md-button ng-click=\"showSearch = !showSearch\" aria-label=\"Back\">\r" +
    "\n" +
    "			<ng-md-icon icon=\"arrow_back\"></ng-md-icon>\r" +
    "\n" +
    "		</md-button>\r" +
    "\n" +
    "		<h3 flex=\"10\">\r" +
    "\n" +
    "			Back\r" +
    "\n" +
    "		</h3>\r" +
    "\n" +
    "		<md-input-container md-theme=\"input\" flex>\r" +
    "\n" +
    "			<label>&nbsp;</label>\r" +
    "\n" +
    "			<input ng-model=\"search.who\" placeholder=\"Search ...\">\r" +
    "\n" +
    "		</md-input-container>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</div>\r" +
    "\n" +
    "</md-toolbar>\r" +
    "\n" +
    "<md-content class=\"md-blue-grey-theme\" flex md-scroll-y>\r" +
    "\n" +
    "	<ui-view layout=\"column\" layout-fill layout-padding>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</ui-view>\r" +
    "\n" +
    "</md-content>\r" +
    "\n"
  );


  $templateCache.put('app/modules/layouts/side-nav/sidenav.html',
    "<div ng-controller=\"SidenavCtrl as vm\" ng-cloak layout=\"column\" layout-fill>\r" +
    "\n" +
    "	<md-toolbar class=\"md-tall md-hue-2\">\r" +
    "\n" +
    "		<div layout=\"column\" class=\"md-toolbar-tools-bottom inset\">\r" +
    "\n" +
    "			<div layout=\"row\">\r" +
    "\n" +
    "				<div flex=\"80\" style=\"margin-top: 10px;\">\r" +
    "\n" +
    "					<div class=\"title\">{{vm.title}}</div>\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "		</div>\r" +
    "\n" +
    "	</md-toolbar>\r" +
    "\n" +
    "	<md-list flex>\r" +
    "\n" +
    "		<md-list-item ui-sref=\"home.dashboard\">\r" +
    "\n" +
    "			<div class=\"inset\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"apps\"></ng-md-icon>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "			<p> Dashboard </p>\r" +
    "\n" +
    "		</md-list-item>\r" +
    "\n" +
    "		<md-list-item ng-repeat=\"item in vm.menu\" ng-click=\"vm.navigateTo('home.' + item.link)\">\r" +
    "\n" +
    "			<div class=\"inset\" ng-show=\"item.icon\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"{{item.icon}}\"></ng-md-icon>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "			<p> {{ item.name }}</p>\r" +
    "\n" +
    "		</md-list-item>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</md-list>\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "	<md-divider></md-divider>\r" +
    "\n" +
    "	<a href=\"http://www.disim.univaq.it/\" style=\"padding-left:10px; padding-right: 10px;\">\r" +
    "\n" +
    "		<img style=\"width:100%\" src=\"/app/assets/images/pageres.png\">\r" +
    "\n" +
    "	</a>\r" +
    "\n" +
    "\r" +
    "\n" +
    "</div>\r" +
    "\n"
  );


  $templateCache.put('app/modules/layouts/tool-bar/toolbar.html',
    "<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "	<md-button ng-click=\"layout.toggleSidenav('left')\" hide-gt-md aria-label=\"Menu\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"menu\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<h3 class=\"title\">{{layout.title}}</h3>\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-menu md-position-mode=\"target-right target\">\r" +
    "\n" +
    "		<md-button class=\"md-fab md-mini\" aria-label=\"Profile\" ng-click=\"$mdOpenMenu($event)\">\r" +
    "\n" +
    "			<ng-md-icon md-menu-origin icon=\"account_circle\"></ng-md-icon>\r" +
    "\n" +
    "		</md-button>\r" +
    "\n" +
    "		<md-menu-content width=\"4\">\r" +
    "\n" +
    "			<md-menu-item>\r" +
    "\n" +
    "				<md-button ng-click=\"layout.logOut()\">\r" +
    "\n" +
    "					Logout\r" +
    "\n" +
    "				</md-button>\r" +
    "\n" +
    "			</md-menu-item>\r" +
    "\n" +
    "		</md-menu-content>\r" +
    "\n" +
    "	</md-menu>\r" +
    "\n" +
    "</div>\r" +
    "\n"
  );


  $templateCache.put('app/modules/login/login.html',
    "<md-content layout-align=\"center center\" layout=\"row\" layout-fill flex style=\"background-color:#DCDCDC\">\r" +
    "\n" +
    "	<md-card flex=\"50\">\r" +
    "\n" +
    "		<md-toolbar class=\"md-hue-2\">\r" +
    "\n" +
    "			<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "				<h2>\r" +
    "\n" +
    "					<span class=\"title\">{{ctrl.title}}</span>\r" +
    "\n" +
    "				</h2>\r" +
    "\n" +
    "				<span flex></span>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "		</md-toolbar>\r" +
    "\n" +
    "		<md-progress-linear ng-if=\"ctrl.loading\" md-mode=\"indeterminate\"></md-progress-linear>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-card-content class=\"text-center\">\r" +
    "\n" +
    "			<h1 class=\"title\">Welcome to <strong>mmwe</strong></h1>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<h3>DISIM's Meta Model Web Editor</h3>\r" +
    "\n" +
    "		</md-card-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-divider class=\"margin-top-20\"></md-divider>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-content md-theme=\"docs-dark\" layout=\"column\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-subheader> * You can use <a href=\"http://www.mdeforge.org\"\r" +
    "\n" +
    "											style=\"color:white;font-weight: bold;\">mdeforge.org</a>\r" +
    "\n" +
    "				credentials\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<!--md-subheader ng-if=\"ctrl.loading\">Attempting to login {{ctrl.username}}</md-subheader-->\r" +
    "\n" +
    "			<form>\r" +
    "\n" +
    "				<div layout-padding layout=\"column\" flex>\r" +
    "\n" +
    "					<md-input-container flex-gt-md=\"50\">\r" +
    "\n" +
    "						<label>Username</label>\r" +
    "\n" +
    "						<input ng-model=\"ctrl.username\" ng-disabled=\"ctrl.loading\">\r" +
    "\n" +
    "					</md-input-container>\r" +
    "\n" +
    "\r" +
    "\n" +
    "					<md-input-container flex-gt-md=\"50\">\r" +
    "\n" +
    "						<label>Password</label>\r" +
    "\n" +
    "						<input ng-model=\"ctrl.password\" type=\"password\" ng-disabled=\"ctrl.loading\">\r" +
    "\n" +
    "					</md-input-container>\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "				<md-card-actions layout=\"row\" layout-align=\"end center\">\r" +
    "\n" +
    "					<md-button ng-click=\"ctrl.login()\" type=\"submit\"\r" +
    "\n" +
    "							   ng-disabled=\"!ctrl.username || !ctrl.password || ctrl.loading\">Login\r" +
    "\n" +
    "					</md-button>\r" +
    "\n" +
    "				</md-card-actions>\r" +
    "\n" +
    "			</form>\r" +
    "\n" +
    "		</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</md-card>\r" +
    "\n" +
    "</md-content>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModels/metaModels.html',
    "\r" +
    "\n" +
    "<md-content layout=\"column\" flex md-scroll-y style=\"background-color:#DCDCDC\">\r" +
    "\n" +
    "	<div ui-view flex=\"100\"></div>\r" +
    "\n" +
    "</md-content>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsBrowser/metaModelsList.html',
    "<!-- as a Dom element -->\r" +
    "\n" +
    "<!-- as an attribute -->\r" +
    "\n" +
    "<md-content md-theme=\"docs-dark\" layout-align=\"start center\" layout=\"row\" style=\"overflow: hidden;\"\r" +
    "\n" +
    "			class=\"md-toolbar-tools\">\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "	<md-button class=\"md-icon-button\" aria-label=\"Search\" ng-disabled=\"true\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"search\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-input-container flex=\"20\"\r" +
    "\n" +
    "						style=\"padding-top:0px;padding-bottom:0px;padding-right:0px;margin-bottom:0px;\">\r" +
    "\n" +
    "		<label>Search</label>\r" +
    "\n" +
    "		<input ng-model=\"ctrl.searchText\" type=\"text\" ng-disabled=\"ctrl.loading\">\r" +
    "\n" +
    "	</md-input-container>\r" +
    "\n" +
    "</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-progress-linear md-theme=\"docs-dark\" md-mode=\"indeterminate\" ng-if=\"ctrl.loading\"></md-progress-linear>\r" +
    "\n" +
    "<div class=\"md-padding\" flex layout=\"column\" layout-fill>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<!--md-card layout=\"column\" flex>\r" +
    "\n" +
    "		<md-toolbar>\r" +
    "\n" +
    "			<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"folder\"></ng-md-icon>\r" +
    "\n" +
    "				&nbsp;\r" +
    "\n" +
    "				<h2 class=\"title\">\r" +
    "\n" +
    "					Browse meta models\r" +
    "\n" +
    "				</h2>\r" +
    "\n" +
    "				<span flex></span>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "		</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</md-card-->\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-card layout=\"column\" flex>\r" +
    "\n" +
    "		<md-list flex ng-if=\"!ctrl.loading && ctrl.items && ctrl.items.length==0 && ctrl.searchText\">\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.searchText\">no results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.searchText}}\"</strong>\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-list flex ng-if=\"!ctrl.loading && ctrl.items.length>0\">\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.searchText\">Results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.searchText}}\"</strong>\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.lastSearchText && !ctrl.searchText\">Results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.lastSearchText}}\"</strong> ( last search on this browser )\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<md-table-container>\r" +
    "\n" +
    "				<table md-table>\r" +
    "\n" +
    "					<thead md-head>\r" +
    "\n" +
    "					<tr md-row>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Name\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Author\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Description\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</thead>\r" +
    "\n" +
    "					<tbody md-body>\r" +
    "\n" +
    "					<tr ng-repeat=\"item in ctrl.items | orderBy : 'name'\" ng-click=\"ctrl.editMetamodel(item)\" md-row\r" +
    "\n" +
    "						style=\"cursor:pointer;\">\r" +
    "\n" +
    "						<td md-cell>{{item.name}}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.author.firstname }} {{ item.author.lastname }}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.description }}</td>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</tbody>\r" +
    "\n" +
    "				</table>\r" +
    "\n" +
    "			</md-table-container>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-list layout-padding ng-if=\"!ctrl.items && !ctrl.searchText\">\r" +
    "\n" +
    "			<md-subheader>\r" +
    "\n" +
    "				Over 4000 meta models are waiting for you, let's start\r" +
    "\n" +
    "				searching!\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "	</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-button class=\"md-fab bottom-fab\" ng-click=\"ctrl.newMetaModel()\">\r" +
    "\n" +
    "	<ng-md-icon icon=\"add\"></ng-md-icon>\r" +
    "\n" +
    "</md-button>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/consolePanel.html',
    "<md-content flex layout-fill>\r" +
    "\n" +
    "	<md-table-container layout-fill>\r" +
    "\n" +
    "		<table md-table>\r" +
    "\n" +
    "			<thead md-head>\r" +
    "\n" +
    "			<tr md-row>\r" +
    "\n" +
    "				<th md-column colspan=\"1\">Time</th>\r" +
    "\n" +
    "				<th md-column colspan=\"1\">Source</th>\r" +
    "\n" +
    "				<th md-column colspan=\"3\">Message</th>\r" +
    "\n" +
    "			</tr>\r" +
    "\n" +
    "			</thead>\r" +
    "\n" +
    "			<tbody md-body>\r" +
    "\n" +
    "			<tr md-row\r" +
    "\n" +
    "				ng-repeat=\"log in ctrl.logs | orderBy :'-date'\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<td md-cell colspan=\"1\">{{log.date|date:'HH:mm:ss'}}</td>\r" +
    "\n" +
    "				<td md-cell colspan=\"1\">{{log.source}}</td>\r" +
    "\n" +
    "				<td md-cell colspan=\"3\">{{log.message}}</td>\r" +
    "\n" +
    "			</tr>\r" +
    "\n" +
    "			</tbody>\r" +
    "\n" +
    "		</table>\r" +
    "\n" +
    "	</md-table-container>\r" +
    "\n" +
    "</md-content>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/jsonEcorePreview.html',
    "<div flex style=\"padding:16px\">\r" +
    "\n" +
    "	<pre>\r" +
    "\n" +
    "{{ctrl.jsonResource|prettyJSON}}\r" +
    "\n" +
    "	</pre>\r" +
    "\n" +
    "</div>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/metaDataPanel.html',
    "<md-content flex layout-fill>\r" +
    "\n" +
    "	<md-content md-theme=\"docs-dark\" layout-gt-sm=\"column\" layout-padding>\r" +
    "\n" +
    "		<span>Name: <span class=\"md-title\">{{ctrl.artifact.name}}</span></span>\r" +
    "\n" +
    "		<span>Author: <span class=\"md-subhead\">{{ctrl.artifact.author.firstname}} {{ctrl.artifact.author.lastname}} <{{ctrl.artifact.author.email}}></span></span>\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-content layout-gt-sm=\"column\" layout-padding>\r" +
    "\n" +
    "		<md-input-container>\r" +
    "\n" +
    "			<label>Name</label>\r" +
    "\n" +
    "			<input ng-model=\"ctrl.artifact.name\" type=\"text\">\r" +
    "\n" +
    "		</md-input-container>\r" +
    "\n" +
    "		<md-input-container class=\"md-block\">\r" +
    "\n" +
    "			<label>Description</label>\r" +
    "\n" +
    "			<textarea ng-model=\"ctrl.artifact.description\" md-maxlength=\"150\" rows=\"2\"></textarea>\r" +
    "\n" +
    "		</md-input-container>\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "</md-content>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/metaModelsEditor.html',
    "<!-- as a Dom element -->\r" +
    "\n" +
    "<!-- as an attribute -->\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-content md-theme=\"docs-dark\" class=\"md-toolbar-tools\">\r" +
    "\n" +
    "	<ng-md-icon icon=\"description\"></ng-md-icon>\r" +
    "\n" +
    "	&nbsp;\r" +
    "\n" +
    "	<md-subheader ng-if=\"ctrl.metaModel && ctrl.editingModel && ctrl.modelIsSupported && !ctrl.posting\">\r" +
    "\n" +
    "		{{ctrl.metaModel.name}}\r" +
    "\n" +
    "	</md-subheader>\r" +
    "\n" +
    "	<md-subheader ng-if=\"!ctrl.editingModel && ctrl.modelIsSupported!=false\">Downloading metamodel</md-subheader>\r" +
    "\n" +
    "	<md-subheader ng-if=\"ctrl.posting && ctrl.modelIsSupported \">Posting updates</md-subheader>\r" +
    "\n" +
    "	<md-subheader ng-if=\"ctrl.modelIsSupported==false\">Sorry this metamodel is unsupported at the moment, feel free\r" +
    "\n" +
    "		to\r" +
    "\n" +
    "		contact us.\r" +
    "\n" +
    "	</md-subheader>\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "	<md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "			   ng-if=\"ctrl.metaModel && ctrl.editingModel && ctrl.modelIsSupported && !ctrl.posting\"\r" +
    "\n" +
    "			   ng-click=\"ctrl.store()\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"save\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "			   ng-if=\"ctrl.metaModel && ctrl.editingModel && ctrl.modelIsSupported && !ctrl.posting\"\r" +
    "\n" +
    "			   ng-click=\"ctrl.delete()\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"delete\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "			   ng-if=\"ctrl.metaModel && ctrl.editingModel && ctrl.modelIsSupported && !ctrl.posting\"\r" +
    "\n" +
    "			   ng-click=\"ctrl.export()\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"file_download\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "\r" +
    "\n" +
    "</md-content>\r" +
    "\n" +
    "<md-progress-linear md-theme=\"docs-dark\" md-mode=\"indeterminate\"\r" +
    "\n" +
    "					ng-if=\"(!ctrl.editingModel && !ctrl.metaModel)||ctrl.posting\"></md-progress-linear>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "<div flex layout=\"row\" layout-fill layout-align=\"center\"\r" +
    "\n" +
    "	 ng-if=\"ctrl.editingModel && ctrl.modelIsSupported\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<decorated-tree-ecore-editor flex=\"50\" layout=\"column\"\r" +
    "\n" +
    "								 ecore-resource=\"ctrl.resource\"\r" +
    "\n" +
    "								 editing-model=\"ctrl.editingModel\"\r" +
    "\n" +
    "								 selected-element=\"ctrl.selectedElement\"\r" +
    "\n" +
    "								 ng-if=\"ctrl.settings.editor.mode.value==ctrl.EDITOR_MODE_AS_TREE.value\">\r" +
    "\n" +
    "	</decorated-tree-ecore-editor>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-card flex=\"50\" layout=\"column\" ng-if=\"ctrl.settings.panels.mode.value==ctrl.PANELS_MODE_AS_CARD.value\">\r" +
    "\n" +
    "		<md-toolbar>\r" +
    "\n" +
    "			<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"tab\"></ng-md-icon>\r" +
    "\n" +
    "				&nbsp;\r" +
    "\n" +
    "				<h2>\r" +
    "\n" +
    "					<span>Panels</span>\r" +
    "\n" +
    "				</h2>\r" +
    "\n" +
    "				<span flex></span>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "		</md-toolbar>\r" +
    "\n" +
    "		<md-tabs md-dynamic-height md-border-bottom>\r" +
    "\n" +
    "			<md-tab label=\"Properties\" layout-fill>\r" +
    "\n" +
    "				<md-content layout=\"column\">\r" +
    "\n" +
    "					<tree-ecore-properties-editor ng-if=\"ctrl.selectedElement\"\r" +
    "\n" +
    "												  root-tree-ecore-element=\"ctrl.editingModel\"\r" +
    "\n" +
    "												  tree-ecore-element=\"ctrl.selectedElement\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "					</tree-ecore-properties-editor>\r" +
    "\n" +
    "				</md-content>\r" +
    "\n" +
    "			</md-tab>\r" +
    "\n" +
    "			<md-tab label=\"Console\" layout-fill>\r" +
    "\n" +
    "				<md-content layout=\"column\">\r" +
    "\n" +
    "					<console-panel>\r" +
    "\n" +
    "\r" +
    "\n" +
    "					</console-panel>\r" +
    "\n" +
    "				</md-content>\r" +
    "\n" +
    "			</md-tab>\r" +
    "\n" +
    "			<md-tab label=\"File\" ng-if=\"ctrl.metaModel\">\r" +
    "\n" +
    "				<meta-data-panel artifact=\"ctrl.metaModel\"></meta-data-panel>\r" +
    "\n" +
    "			</md-tab>\r" +
    "\n" +
    "		</md-tabs>\r" +
    "\n" +
    "	</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/propertiesEditor/elistMultiSelectInputDirective.html',
    "<md-select flex multiple=\"ctrl.propertiesField.multiple\"\r" +
    "\n" +
    "		   ng-model=\"ctrl.arrayValues\">\r" +
    "\n" +
    "	<md-option ng-repeat=\"option in ctrl.propertiesField.supportedValues()\" ng-value=\"option\">\r" +
    "\n" +
    "		{{option.values.name}}\r" +
    "\n" +
    "	</md-option>\r" +
    "\n" +
    "</md-select>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/propertiesEditor/propertiesEditor.html',
    "<md-table-container>\r" +
    "\n" +
    "	<table md-table>\r" +
    "\n" +
    "		<thead md-head>\r" +
    "\n" +
    "		<tr md-row>\r" +
    "\n" +
    "			<th md-column md-numeric>Property</th>\r" +
    "\n" +
    "			<th md-column md-numeric>Value</th>\r" +
    "\n" +
    "		</tr>\r" +
    "\n" +
    "		</thead>\r" +
    "\n" +
    "		<tbody md-body>\r" +
    "\n" +
    "		<tr md-row\r" +
    "\n" +
    "			ng-repeat=\"(property, value) in ctrl.treeEcoreElement.properties\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<td md-cell>{{property}}</td>\r" +
    "\n" +
    "			<td md-cell>\r" +
    "\n" +
    "				<input flex ng-if=\"value.type=='EString'\" type=\"{{value.type}}\"\r" +
    "\n" +
    "					   ng-model=\"ctrl.treeEcoreElement.values[property]\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<input flex ng-if=\"value.type=='EInt' || value.type=='EDouble' || value.type=='EFloat'\" type=\"number\"\r" +
    "\n" +
    "					   ng-model=\"ctrl.treeEcoreElement.values[property]\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<md-checkbox flex ng-if=\"value.type=='EBoolean'\"\r" +
    "\n" +
    "							 ng-model=\"ctrl.treeEcoreElement.values[property]\">\r" +
    "\n" +
    "				</md-checkbox>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<md-select flex ng-if=\"value.type=='EType'\"\r" +
    "\n" +
    "						   ng-model=\"ctrl.treeEcoreElement.values[property]\">\r" +
    "\n" +
    "					<md-option ng-repeat=\"option in value.supportedValues()\" ng-value=\"option\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "						{{option.values.name}}\r" +
    "\n" +
    "\r" +
    "\n" +
    "					</md-option>\r" +
    "\n" +
    "				</md-select>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<md-select flex ng-if=\"(value.type=='EClass' && value.multiple==false)\"\r" +
    "\n" +
    "						   ng-model=\"ctrl.treeEcoreElement.values[property]\">\r" +
    "\n" +
    "					<md-option ng-repeat=\"option in value.supportedValues()\" ng-value=\"option.eClass\">\r" +
    "\n" +
    "						{{option.values.name}}\r" +
    "\n" +
    "					</md-option>\r" +
    "\n" +
    "				</md-select>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<span flex elist-multi-select-input-directive ng-if=\"value.type=='EClass' && value.multiple==true\"\r" +
    "\n" +
    "					  ng-model=\"ctrl.treeEcoreElement.values[property]\"\r" +
    "\n" +
    "					  properties-field=\"value\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "				</span>\r" +
    "\n" +
    "			</td>\r" +
    "\n" +
    "		</tr>\r" +
    "\n" +
    "		</tbody>\r" +
    "\n" +
    "	</table>\r" +
    "\n" +
    "</md-table-container>\r" +
    "\n"
  );


  $templateCache.put('app/modules/metaModelsEditor/treeEditor/treeEditor.html',
    "<style>\r" +
    "\n" +
    "	.a1 {\r" +
    "\n" +
    "		margin-bottom: 0.5em;\r" +
    "\n" +
    "		margin-top: 0.5em;\r" +
    "\n" +
    "	}\r" +
    "\n" +
    "\r" +
    "\n" +
    "	.a2 {\r" +
    "\n" +
    "		margin-bottom: 0.5em;\r" +
    "\n" +
    "		margin-top: 0.5em;\r" +
    "\n" +
    "	}\r" +
    "\n" +
    "\r" +
    "\n" +
    "	.liSelected {\r" +
    "\n" +
    "		border: none;\r" +
    "\n" +
    "	}\r" +
    "\n" +
    "</style>\r" +
    "\n" +
    "<md-card layout=\"column\">\r" +
    "\n" +
    "	<md-toolbar>\r" +
    "\n" +
    "		<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "			<ng-md-icon icon=\"format_indent_increase\"></ng-md-icon>\r" +
    "\n" +
    "			&nbsp;\r" +
    "\n" +
    "			<h2>\r" +
    "\n" +
    "				<span>Tree Editor</span>\r" +
    "\n" +
    "			</h2>\r" +
    "\n" +
    "			<span flex></span>\r" +
    "\n" +
    "			<md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "					   ng-if=\"ctrl.getSupportedChildrenTypes().length > 0 \"\r" +
    "\n" +
    "					   ng-click=\"ctrl.addChild()\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"add_circle_outline\"></ng-md-icon>\r" +
    "\n" +
    "			</md-button>\r" +
    "\n" +
    "			<md-button class=\"md-fab md-mini\" ng-if=\"ctrl.selectedElement.eContainer\"\r" +
    "\n" +
    "					   ng-click=\"ctrl.removeChild()\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"remove_circle_outline\"></ng-md-icon>\r" +
    "\n" +
    "			</md-button>\r" +
    "\n" +
    "		</div>\r" +
    "\n" +
    "	</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-content class=\"md-padding\" layout=\"column\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<treecontrol class=\"tree-light\"\r" +
    "\n" +
    "					 tree-model=\"ctrl.treeEcorePackage\"\r" +
    "\n" +
    "					 options=\"ctrl.treeOptions\"\r" +
    "\n" +
    "					 selected-node=\"ctrl.selectedElement\"\r" +
    "\n" +
    "					 expanded-nodes=\"ctrl.expandedElements\">\r" +
    "\n" +
    "			<span>\r" +
    "\n" +
    "				<ng-md-icon icon=\"{{ctrl.ECORE_TYPE_ICONS[node.eClass.values.name]}}\"></ng-md-icon>\r" +
    "\n" +
    "			 </span>\r" +
    "\n" +
    "			{{node.values.name}}\r" +
    "\n" +
    "			<span ng-switch=\"node._type\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<span ng-if=\"node.eClass.values.name==ctrl.ECORE_TYPES.EClass\"\r" +
    "\n" +
    "					  ng-repeat=\"tag in node.tags\">\r" +
    "\n" +
    "					&nbsp;<span ng-if=\"$index==0\">-></span> <span ng-if=\"$index!=0\">,</span> {{tag}}\r" +
    "\n" +
    "				</span>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<span\r" +
    "\n" +
    "					ng-if=\"node.eClass.values.name==ctrl.ECORE_TYPES.EAttribute || node.eClass.values.name==ctrl.ECORE_TYPES.EReference\">\r" +
    "\n" +
    "					&nbsp;:&nbsp;{{node.values.eType.values.name}}\r" +
    "\n" +
    "				</span>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			</span>\r" +
    "\n" +
    "		</treecontrol>\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<!-- HIDDEN DIALOG FOR ADDING ELEMENTS -->\r" +
    "\n" +
    "<div style=\"visibility: hidden\">\r" +
    "\n" +
    "	<div class=\"md-dialog-container\" id=\"addChildrenDialog\">\r" +
    "\n" +
    "		<md-dialog>\r" +
    "\n" +
    "			<md-toolbar>\r" +
    "\n" +
    "				<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "					<ng-md-icon icon=\"add_circle_outline\"></ng-md-icon>\r" +
    "\n" +
    "					&nbsp;\r" +
    "\n" +
    "					<h2>\r" +
    "\n" +
    "						<span>Add children</span>\r" +
    "\n" +
    "					</h2>\r" +
    "\n" +
    "					<span flex></span>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "			</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-content layout-padding>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<p>What do you want to add to {{ctrl.selectedElement._type}} named <strong>{{ctrl.selectedElement.values.name}}</strong>\r" +
    "\n" +
    "					?</p>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<md-list>\r" +
    "\n" +
    "					<md-list-item class=\"md-2-line\" ng-click=\"ctrl.doCreateChild(child_type)\"\r" +
    "\n" +
    "								  ng-repeat=\"child_type in ctrl.getSupportedChildrenTypes()\">\r" +
    "\n" +
    "						<ng-md-icon icon=\"{{ctrl.ECORE_TYPE_ICONS[child_type]}}\" class=\"md-avatar-icon\"></ng-md-icon>\r" +
    "\n" +
    "\r" +
    "\n" +
    "						<div class=\"md-list-item-text\">\r" +
    "\n" +
    "							<h3> {{ child_type }} </h3>\r" +
    "\n" +
    "						</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "						<ng-md-icon icon=\"keyboard_arrow_right\"></ng-md-icon>\r" +
    "\n" +
    "\r" +
    "\n" +
    "					</md-list-item>\r" +
    "\n" +
    "\r" +
    "\n" +
    "					<!--md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "							   aria-label=\"{{child_type}}\"\r" +
    "\n" +
    "							   ng-click=\"ctrl.doCreateChild(child_type)\"\r" +
    "\n" +
    "							   ng-repeat=\"child_type in ctrl.getSupportedChildrenTypes()\">\r" +
    "\n" +
    "						<ng-md-icon icon=\"{{ctrl.ECORE_TYPE_ICONS[child_type]}}\"></ng-md-icon>\r" +
    "\n" +
    "					</md-button-->\r" +
    "\n" +
    "\r" +
    "\n" +
    "				</md-list>\r" +
    "\n" +
    "		</md-dialog>\r" +
    "\n" +
    "	</div>\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n"
  );


  $templateCache.put('app/modules/models/models.html',
    "\r" +
    "\n" +
    "<md-content layout=\"column\" flex md-scroll-y style=\"background-color:#DCDCDC\">\r" +
    "\n" +
    "	<div ui-view flex=\"100\"></div>\r" +
    "\n" +
    "</md-content>\r" +
    "\n"
  );


  $templateCache.put('app/modules/modelsBrowser/modelsList.html',
    "<!-- as a Dom element -->\r" +
    "\n" +
    "<!-- as an attribute -->\r" +
    "\n" +
    "<md-content md-theme=\"docs-dark\" layout-align=\"start center\" layout=\"row\" style=\"overflow: hidden;\"\r" +
    "\n" +
    "			class=\"md-toolbar-tools\">\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "	<md-button class=\"md-icon-button\" aria-label=\"Search\" ng-disabled=\"true\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"search\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-input-container flex=\"20\"\r" +
    "\n" +
    "						style=\"padding-top:0px;padding-bottom:0px;padding-right:0px;margin-bottom:0px;\">\r" +
    "\n" +
    "		<label>Search</label>\r" +
    "\n" +
    "		<input ng-model=\"ctrl.searchText\" type=\"text\" ng-disabled=\"ctrl.loading\">\r" +
    "\n" +
    "	</md-input-container>\r" +
    "\n" +
    "</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-progress-linear md-theme=\"docs-dark\" md-mode=\"indeterminate\" ng-if=\"ctrl.loading\"></md-progress-linear>\r" +
    "\n" +
    "<div class=\"md-padding\" flex layout=\"column\" layout-fill>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-card layout=\"column\" flex>\r" +
    "\n" +
    "		<md-list flex ng-if=\"!ctrl.loading && ctrl.items && ctrl.items.length==0 && ctrl.searchText\">\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.searchText\">no results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.searchText}}\"</strong>\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-list flex ng-if=\"!ctrl.loading && ctrl.items.length>0\">\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.searchText\">Results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.searchText}}\"</strong>\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.lastSearchText && !ctrl.searchText\">Results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.lastSearchText}}\"</strong> ( last search on this browser )\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<md-table-container>\r" +
    "\n" +
    "				<table md-table>\r" +
    "\n" +
    "					<thead md-head>\r" +
    "\n" +
    "					<tr md-row>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Name\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Author\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Description\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</thead>\r" +
    "\n" +
    "					<tbody md-body>\r" +
    "\n" +
    "					<tr ng-repeat=\"item in ctrl.items | orderBy : 'name'\" ng-click=\"ctrl.editModel(item)\" md-row\r" +
    "\n" +
    "						style=\"cursor:pointer;\">\r" +
    "\n" +
    "						<td md-cell>{{item.name}}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.author.firstname }} {{ item.author.lastname }}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.description }}</td>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</tbody>\r" +
    "\n" +
    "				</table>\r" +
    "\n" +
    "			</md-table-container>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-list layout-padding ng-if=\"!ctrl.items && !ctrl.searchText\">\r" +
    "\n" +
    "			<md-subheader>\r" +
    "\n" +
    "				Over 4000 meta models are waiting for you, let's start\r" +
    "\n" +
    "				searching!\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "	</md-card>\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-button class=\"md-fab bottom-fab\" ng-click=\"ctrl.newModel()\">\r" +
    "\n" +
    "	<ng-md-icon icon=\"add\"></ng-md-icon>\r" +
    "\n" +
    "</md-button>\r" +
    "\n"
  );


  $templateCache.put('app/modules/modelsEditor/metaModelSelector.html',
    "<!-- as a Dom element -->\r" +
    "\n" +
    "<!-- as an attribute -->\r" +
    "\n" +
    "<md-content md-theme=\"docs-dark\" layout-align=\"start center\" layout=\"row\" style=\"overflow: hidden;\"\r" +
    "\n" +
    "			class=\"md-toolbar-tools\">\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "	<md-button class=\"md-icon-button\" aria-label=\"Search\" ng-disabled=\"true\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"search\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-input-container flex=\"20\"\r" +
    "\n" +
    "						style=\"padding-top:0px;padding-bottom:0px;padding-right:0px;margin-bottom:0px;\">\r" +
    "\n" +
    "		<label>Search</label>\r" +
    "\n" +
    "		<input ng-model=\"ctrl.searchText\" type=\"text\" ng-disabled=\"ctrl.loading\">\r" +
    "\n" +
    "	</md-input-container>\r" +
    "\n" +
    "</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-progress-linear md-theme=\"docs-dark\" md-mode=\"indeterminate\" ng-if=\"ctrl.loading\"></md-progress-linear>\r" +
    "\n" +
    "<div class=\"md-padding\" flex layout=\"column\" layout-fill>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-card layout=\"column\" flex>\r" +
    "\n" +
    "		<md-list flex ng-if=\"!ctrl.loading && ctrl.items && ctrl.items.length==0 && ctrl.searchText\">\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.searchText\">no results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.searchText}}\"</strong>\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-list flex ng-if=\"!ctrl.loading && ctrl.items.length>0\">\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.searchText\">Results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.searchText}}\"</strong>\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<md-subheader ng-if=\"ctrl.lastSearchText && !ctrl.searchText\">Results for\r" +
    "\n" +
    "				<strong>\"{{ctrl.lastSearchText}}\"</strong> ( last search on this browser )\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "			<md-table-container>\r" +
    "\n" +
    "				<table md-table>\r" +
    "\n" +
    "					<thead md-head>\r" +
    "\n" +
    "					<tr md-row>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Name\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Author\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "						<th md-column>\r" +
    "\n" +
    "							Description\r" +
    "\n" +
    "						</th>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</thead>\r" +
    "\n" +
    "					<tbody md-body>\r" +
    "\n" +
    "					<tr ng-repeat=\"item in ctrl.items | orderBy : 'name'\" ng-click=\"ctrl.editMetamodel(item)\" md-row\r" +
    "\n" +
    "						style=\"cursor:pointer;\">\r" +
    "\n" +
    "						<td md-cell>{{item.name}}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.author.firstname }} {{ item.author.lastname }}</td>\r" +
    "\n" +
    "						<td md-cell>{{ item.description }}</td>\r" +
    "\n" +
    "					</tr>\r" +
    "\n" +
    "					</tbody>\r" +
    "\n" +
    "				</table>\r" +
    "\n" +
    "			</md-table-container>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<md-list layout-padding ng-if=\"!ctrl.items && !ctrl.searchText\">\r" +
    "\n" +
    "			<md-subheader>\r" +
    "\n" +
    "				Search a MetaModel to start creating a compliant model.\r" +
    "\n" +
    "			</md-subheader>\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "	</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n"
  );


  $templateCache.put('app/modules/modelsEditor/modelsEditor.html',
    "<md-content md-theme=\"docs-dark\" class=\"md-toolbar-tools\">\r" +
    "\n" +
    "	<ng-md-icon icon=\"description\"></ng-md-icon>\r" +
    "\n" +
    "	&nbsp;\r" +
    "\n" +
    "	<md-subheader>\r" +
    "\n" +
    "		{{ctrl.artifact.name}}, compliant with <a> {{ctrl.metaModelMetaData.name}} </a> metamodel\r" +
    "\n" +
    "	</md-subheader>\r" +
    "\n" +
    "	<span flex></span>\r" +
    "\n" +
    "	<md-button class=\"md-fab md-mini\" ng-if=\"ctrl.artifact\"\r" +
    "\n" +
    "			   ng-click=\"ctrl.store()\"\r" +
    "\n" +
    "			   ng-disabled>\r" +
    "\n" +
    "		<ng-md-icon icon=\"save\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-button class=\"md-fab md-mini\" ng-if=\"ctrl.artifact\"\r" +
    "\n" +
    "			   ng-click=\"ctrl.destroy()\"\r" +
    "\n" +
    "			   ng-disabled>\r" +
    "\n" +
    "		<ng-md-icon icon=\"delete\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "	<md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "			   ng-if=\"ctrl.rootElement\"\r" +
    "\n" +
    "			   ng-click=\"ctrl.export()\">\r" +
    "\n" +
    "		<ng-md-icon icon=\"file_download\"></ng-md-icon>\r" +
    "\n" +
    "	</md-button>\r" +
    "\n" +
    "\r" +
    "\n" +
    "</md-content>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<md-progress-linear md-theme=\"docs-dark\" md-mode=\"indeterminate\"\r" +
    "\n" +
    "					ng-if=\"ctrl.loading\"></md-progress-linear>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "<div flex layout=\"row\" layout-fill layout-align=\"center start\" ng-if=\"ctrl.metaModel\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<root-element-selector-directive ng-if=\"!ctrl.rootElement\" on-root-element-selected=\"ctrl.onRootElementSelected\"\r" +
    "\n" +
    "									 flex=\"50\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "	</root-element-selector-directive>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<decorated-tree-ecore-instance-editor flex=\"50\" layout=\"column\"\r" +
    "\n" +
    "										  selected-element=\"ctrl.selectedElement\"\r" +
    "\n" +
    "										  root-element=\"ctrl.rootElement\"\r" +
    "\n" +
    "										  ecore-resource=\"ctrl.resource\"\r" +
    "\n" +
    "										  ng-if=\"ctrl.rootElement\">\r" +
    "\n" +
    "	</decorated-tree-ecore-instance-editor>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-card flex=\"50\" layout=\"column\"\r" +
    "\n" +
    "			 ng-if=\"ctrl.rootElement && ctrl.settings.panels.mode.value==ctrl.PANELS_MODE_AS_CARD.value\">\r" +
    "\n" +
    "		<md-toolbar>\r" +
    "\n" +
    "			<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"tab\"></ng-md-icon>\r" +
    "\n" +
    "				&nbsp;\r" +
    "\n" +
    "				<h2>\r" +
    "\n" +
    "					<span>Panels</span>\r" +
    "\n" +
    "				</h2>\r" +
    "\n" +
    "				<span flex></span>\r" +
    "\n" +
    "			</div>\r" +
    "\n" +
    "		</md-toolbar>\r" +
    "\n" +
    "		<md-tabs md-dynamic-height md-border-bottom>\r" +
    "\n" +
    "			<md-tab label=\"Properties\" layout-fill>\r" +
    "\n" +
    "				<md-content layout=\"column\">\r" +
    "\n" +
    "					<ecore-instance-properties-editor ng-if=\"ctrl.selectedElement\"\r" +
    "\n" +
    "													  meta-model=\"ctrl.metaModel\"\r" +
    "\n" +
    "													  root-ecore-element=\"ctrl.rootElement\"\r" +
    "\n" +
    "													  ecore-element=\"ctrl.selectedElement\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "					</ecore-instance-properties-editor>\r" +
    "\n" +
    "				</md-content>\r" +
    "\n" +
    "			</md-tab>\r" +
    "\n" +
    "		</md-tabs>\r" +
    "\n" +
    "	</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n"
  );


  $templateCache.put('app/modules/modelsEditor/propertiesEditor/propertiesEditor.html',
    "<md-table-container>\r" +
    "\n" +
    "	<table md-table>\r" +
    "\n" +
    "		<thead md-head>\r" +
    "\n" +
    "		<tr md-row>\r" +
    "\n" +
    "			<th md-column md-numeric>Property</th>\r" +
    "\n" +
    "			<th md-column md-numeric>Value</th>\r" +
    "\n" +
    "		</tr>\r" +
    "\n" +
    "		</thead>\r" +
    "\n" +
    "		<tbody md-body>\r" +
    "\n" +
    "		<tr md-row\r" +
    "\n" +
    "			ng-repeat=\"attribute in ctrl.attributes\">\r" +
    "\n" +
    "			<td md-cell>{{attribute.name}}</td>\r" +
    "\n" +
    "			<td md-cell>\r" +
    "\n" +
    "			<input flex ng-if=\"attribute.type=='EString'\" type=\"text\"\r" +
    "\n" +
    "				   ng-model=\"ctrl.ecoreElement.values[attribute.name]\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<input flex ng-if=\"attribute.type=='EInt' || value.type=='EDouble' || value.type=='EFloat'\"\r" +
    "\n" +
    "				   type=\"number\"\r" +
    "\n" +
    "				   ng-model=\"ctrl.ecoreElement.values[attribute.name]\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-datepicker flex ng-model=\"ctrl.ecoreElement.values[attribute.name]\" md-placeholder=\"Enter date\"\r" +
    "\n" +
    "						   ng-if=\"attribute.type=='EDate'\"></md-datepicker>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-checkbox flex ng-if=\"attribute.type=='EBoolean'\"\r" +
    "\n" +
    "						 ng-model=\"ctrl.ecoreElement.values[attribute.name]\">\r" +
    "\n" +
    "			</md-checkbox>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<input type=\"text\" ng-if=\"!ctrl.isTypeSupported(attribute.type)\"\r" +
    "\n" +
    "				   ng-model=\"ctrl.ecoreElement.values[attribute.name]\"/>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			</td>\r" +
    "\n" +
    "		</tr>\r" +
    "\n" +
    "		</tbody>\r" +
    "\n" +
    "	</table>\r" +
    "\n" +
    "</md-table-container>\r" +
    "\n"
  );


  $templateCache.put('app/modules/modelsEditor/rootElementSelector/rootElementSelector.html',
    "<md-card>\r" +
    "\n" +
    "	<md-card-title>\r" +
    "\n" +
    "		<md-card-title-text>\r" +
    "\n" +
    "			<span class=\"md-headline\">Choose a class</span>\r" +
    "\n" +
    "		</md-card-title-text>\r" +
    "\n" +
    "	</md-card-title>\r" +
    "\n" +
    "	<md-content>\r" +
    "\n" +
    "		<md-list>\r" +
    "\n" +
    "			<md-list-item class=\"md-2-line\" ng-click=\"ctrl.selectRootElement(eClass)\"\r" +
    "\n" +
    "						  ng-repeat=\"eClass in ctrl.supportedEClasses\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"{{ctrl.ECORE_TYPE_ICONS[eClass]}}\" class=\"md-avatar-icon\"></ng-md-icon>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<div class=\"md-list-item-text\">\r" +
    "\n" +
    "					<h3> {{ eClass.values.name }} </h3>\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "				<span flex></span>\r" +
    "\n" +
    "				<ng-md-icon icon=\"keyboard_arrow_right\"></ng-md-icon>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			</md-list-item>\r" +
    "\n" +
    "\r" +
    "\n" +
    "		</md-list>\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "</md-card>\r" +
    "\n" +
    "\r" +
    "\n"
  );


  $templateCache.put('app/modules/modelsEditor/treeEditor/treeEditor.html',
    "<style>\r" +
    "\n" +
    "	.a1 {\r" +
    "\n" +
    "		margin-bottom: 0.5em;\r" +
    "\n" +
    "		margin-top: 0.5em;\r" +
    "\n" +
    "	}\r" +
    "\n" +
    "\r" +
    "\n" +
    "	.a2 {\r" +
    "\n" +
    "		margin-bottom: 0.5em;\r" +
    "\n" +
    "		margin-top: 0.5em;\r" +
    "\n" +
    "	}\r" +
    "\n" +
    "\r" +
    "\n" +
    "	.liSelected {\r" +
    "\n" +
    "		border: none;\r" +
    "\n" +
    "	}\r" +
    "\n" +
    "</style>\r" +
    "\n" +
    "<md-card layout=\"column\">\r" +
    "\n" +
    "	<md-toolbar>\r" +
    "\n" +
    "		<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "			<ng-md-icon icon=\"format_indent_increase\"></ng-md-icon>\r" +
    "\n" +
    "			&nbsp;\r" +
    "\n" +
    "			<h2>\r" +
    "\n" +
    "				<span>Tree Editor</span>\r" +
    "\n" +
    "			</h2>\r" +
    "\n" +
    "			<span flex></span>\r" +
    "\n" +
    "			<md-button class=\"md-fab md-mini\"\r" +
    "\n" +
    "					   ng-if=\"ctrl.getSupportedChildrenTypes().length > 0 \"\r" +
    "\n" +
    "					   ng-click=\"ctrl.addChild()\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"add_circle_outline\"></ng-md-icon>\r" +
    "\n" +
    "			</md-button>\r" +
    "\n" +
    "			<md-button class=\"md-fab md-mini\" ng-if=\"ctrl.selectedElement.parent\"\r" +
    "\n" +
    "					   ng-click=\"ctrl.removeChild()\">\r" +
    "\n" +
    "				<ng-md-icon icon=\"remove_circle_outline\"></ng-md-icon>\r" +
    "\n" +
    "			</md-button>\r" +
    "\n" +
    "		</div>\r" +
    "\n" +
    "	</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "	<md-content class=\"md-padding\" layout=\"column\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "		<treecontrol class=\"tree-light\"\r" +
    "\n" +
    "					 tree-model=\"ctrl.tree\"\r" +
    "\n" +
    "					 options=\"ctrl.treeOptions\"\r" +
    "\n" +
    "					 selected-node=\"ctrl.selectedElement\"\r" +
    "\n" +
    "					 expanded-nodes=\"ctrl.expandedElements\">\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<span>\r" +
    "\n" +
    "				{{node.eClass.values.name}} <span ng-if=\"ctrl.getLabel(node)\">({{ctrl.getLabel(node)}})</span>\r" +
    "\n" +
    "			</span>\r" +
    "\n" +
    "		</treecontrol>\r" +
    "\n" +
    "	</md-content>\r" +
    "\n" +
    "</md-card>\r" +
    "\n" +
    "\r" +
    "\n" +
    "<!-- HIDDEN DIALOG FOR ADDING ELEMENTS -->\r" +
    "\n" +
    "<div style=\"visibility: hidden\">\r" +
    "\n" +
    "	<div class=\"md-dialog-container\" id=\"addChildrenDialog\">\r" +
    "\n" +
    "		<md-dialog>\r" +
    "\n" +
    "			<md-toolbar>\r" +
    "\n" +
    "				<div class=\"md-toolbar-tools\">\r" +
    "\n" +
    "					<ng-md-icon icon=\"add_circle_outline\"></ng-md-icon>\r" +
    "\n" +
    "					&nbsp;\r" +
    "\n" +
    "					<h2>\r" +
    "\n" +
    "						<span>Add children</span>\r" +
    "\n" +
    "					</h2>\r" +
    "\n" +
    "					<span flex></span>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				</div>\r" +
    "\n" +
    "			</md-toolbar>\r" +
    "\n" +
    "\r" +
    "\n" +
    "			<md-content layout-padding\r" +
    "\n" +
    "			>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<p>What do you want to add to {{ctrl.selectedElement.eClass.values.name}}\r" +
    "\n" +
    "					?</p>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				<md-list>\r" +
    "\n" +
    "					<md-list-item class=\"md-2-line\"\r" +
    "\n" +
    "								  ng-click=\"ctrl.doCreateChild(child_type)\"\r" +
    "\n" +
    "								  ng-repeat=\"child_type in ctrl.getSupportedChildrenTypes()\">\r" +
    "\n" +
    "						<ng-md-icon icon=\"{{ctrl.ECORE_TYPE_ICONS[child_type]}}\" class=\"md-avatar-icon\"></ng-md-icon>\r" +
    "\n" +
    "\r" +
    "\n" +
    "						<div class=\"md-list-item-text\" ng-class=\"{'md-offset': phone.options.offset }\">\r" +
    "\n" +
    "							<span><h3> {{ child_type.values.eType.values.name }} </h3></span><span> <p>( field: {{child_type.values.name}} )</p></span>\r" +
    "\n" +
    "						</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n" +
    "						<ng-md-icon icon=\"keyboard_arrow_right\"></ng-md-icon>\r" +
    "\n" +
    "\r" +
    "\n" +
    "					</md-list-item>\r" +
    "\n" +
    "\r" +
    "\n" +
    "				</md-list>\r" +
    "\n" +
    "			</md-content>\r" +
    "\n" +
    "		</md-dialog>\r" +
    "\n" +
    "	</div>\r" +
    "\n" +
    "</div>\r" +
    "\n" +
    "\r" +
    "\n" +
    "\r" +
    "\n"
  );

}]);
