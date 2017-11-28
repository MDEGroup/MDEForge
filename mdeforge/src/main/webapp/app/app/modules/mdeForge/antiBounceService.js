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
