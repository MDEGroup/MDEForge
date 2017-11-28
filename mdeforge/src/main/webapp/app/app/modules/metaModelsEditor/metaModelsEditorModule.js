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
