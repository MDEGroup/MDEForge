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




