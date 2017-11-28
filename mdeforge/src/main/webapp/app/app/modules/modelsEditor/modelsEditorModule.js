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
