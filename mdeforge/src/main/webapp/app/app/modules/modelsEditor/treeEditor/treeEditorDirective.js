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

