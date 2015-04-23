
var EReferenceConnection = DG.Connection.extend({
    attr: {
        stroke: 'black',
        'stroke-width': 1
    },
    end: {
        type: 'basic'
    },
//    labels: [
//        { text: 'property', position: 'end' }
//    ],
    initialize: function(attributes) {
        if (attributes && attributes.model) {
            this.model = attributes.model;
//            this.labels[0].set('text', this.model.get('name'));
        }
    }
});

var ESuperTypesConnection = DG.Connection.extend({
    attr: {
        stroke: 'black',
        'stroke-width': 1
    },
    end: {
        fill: 'white',
        type: 'basic'
    },
    initialize: function(attributes) {

    }
});


var CompartmentFigure = {
    type: 'rect',
    width: 100,
    height: 20,
    fill: '#fff',
    stroke: '#86A4D0',
    'stroke-width': 1
};

var FeatureCompartment = DG.Shape.extend({
    config: {},

    initialize: function() {
        this.layout = new DG.GridLayout(this, {
            columns: 1,
            vgap: 5,
            hgap: 5,
            marginHeight: 5,
            marginWidth: 5
        });
        /*
        this.gridData = new DG.GridData({
            horizontalAlignment: 'fill',
            grabExcessHorizontalSpace: true
        });
        */
        this.on('click', this.addFeature);
    },

    createFigure: function() {
        return DG.Figure.create(this, CompartmentFigure);
    },

    addFeature: function() {
        var palette = Workbench.palette;
        var selected = palette.selected;
        var shape, options;

        if (selected && selected.title === 'EAttribute') {
            shape = new selected.shape();
            this.add(shape);
            this.diagram().render();
            palette.selected = null;
        }
    }
});

var OperationCompartment = DG.Shape.extend({
    config: {},

    initialize: function() {
        this.layout = new DG.GridLayout(this, {
            columns: 1,
            vgap: 5,
            hgap: 5,
            marginHeight: 5,
            marginWidth: 5
        });
        /*
        this.gridData = new DG.GridData({
            horizontalAlignment: 'fill',
            grabExcessHorizontalSpace: true,
            grabExcessVerticalSpace: true
        });
        */
        this.on('click', this.addFeature);
    },
    createFigure: function() {
        return DG.Figure.create(this, CompartmentFigure);
    },
    addFeature: function() {
        var palette = Workbench.palette;
        var selected = palette.selected;
        var shape, options;

        if (selected && selected.title === 'EOperation') {
            shape = new selected.shape();
            this.add(shape);
            this.diagram().render();
            palette.selected = null;
        }
    }
});



var EAttributeShape = DG.Label.extend({

    initialize: function(attributes) {
        var attrs = attributes || {};

        if (attrs.model) {
            this.model = attrs.model;
        } else {
            this.model = Ecore.EAttribute.create({ name: 'name', eType: Ecore.EString });
        }

        var text = this.model.get('name');
        if (this.model.has('eType')) text += ': ' + this.model.get('eType').get('name');

        this.attributes.text = text;
/*
        this.on('change:text', function(label) {
            var text = label.getText();
            var split = text.split(':');
            var name = split[0].trim();
            var type;
            if (split.length > 1) {
                type = split[1].trim();
            }
            this.model.set('name', name);
        }, this);
*/
    },

    createFigure: function() {
        return DG.Figure.create(this, {
            type: 'text',
            text: 'name: String',
            stroke: 'none',
            fill: '#535353'
        });
    }
});


var ClassifierLabel = {
    type: 'text',
    text: '',
    'font-size': 14,
    'font-weight': 'bold',
    height: 30
};

var ClassifierShape = {
    type: 'rect',
    width: 100,
    height: 60,
//    fill: '235-#F9F9D8-#FFFFFF',
    fill: '#D3DAEE',
    opacity: 1,
    stroke: '#86A4D0',
    'stroke-width': 1,
    'stroke-opacity': 0.8
};

var ClassifierLayout = {
    type: 'grid',
    columns: 1
};

var ClassLabelShape = DG.Label.extend({
    config: {
        draggable: false,
        resizable: false,
        selectable: false,
        editable: true
    },
    createFigure: function() {
        return DG.Figure.create(this, ClassifierLabel);
    }
});

var ClassLabelCompartment = DG.Shape.extend({
    config: {},
    initialize: function() {
        this.layout = new DG.GridLayout(this, {
            columns: 1,
            vgap: 5,
            hgap: 5,
            marginHeight: 5,
            marginWidth: 5
        });
        /*
        this.gridData = new DG.GridData({
            horizontalAlignment: 'fill',
            grabExcessHorizontalSpace: true
        });
        */
    },
    createFigure: function() {
        return DG.Figure.create(this, _.extend({}, CompartmentFigure, { fill: 'none' }));
    }
});


var EClassShape = DG.Shape.extend({

    anchors: [
        { position: 'n', connectionType: ESuperTypesConnection },
        { position: 'e', connectionType: EReferenceConnection }
    ],

    initialize: function(attributes) {
        var attrs = attributes || {};
        var diagram = attrs.diagram;

        if (attrs.model) {
            this.model = attributes.model;
            this.model.shape = this;
        } else {
            this.model = Ecore.EClass.create({ name: 'MyClass' });
            this.model.shape = this;
            diagram.model.get('eClassifiers').add(this.model);
        }

        this.layout = new DG.GridLayout(this, {
            columns: 1
        });
        this.add(new ClassLabelCompartment());
        this.add(new FeatureCompartment());
        this.add(new OperationCompartment());

        this.children[0].gridData = new DG.GridData({
            horizontalAlignment: 'fill',
            grabExcessHorizontalSpace: true
        });
        this.children[1].gridData = new DG.GridData({
            horizontalAlignment: 'fill',
            grabExcessHorizontalSpace: true
        });
        this.children[2].gridData = new DG.GridData({
            horizontalAlignment: 'fill',
            grabExcessHorizontalSpace: true,
            grabExcessVerticalSpace: true
        });
        this.children[0].add(new ClassLabelShape({
            text: this.model.get('name')
        }));
        this.createContent(diagram);
    },

    createFigure: function() {
        return DG.Figure.create(this, {
            type: 'rect',
            width: 100,
            height: 60,
            fill: '#D3DAEE',
            cursor: 'move',
            stroke: '#86A4D0',
            'stroke-width': 1
        });
    },

    /*
    doConnect: function(e) {
        var palette = Workbench.palette;
        var selected = palette.selected;

        if (selected && selected.connection) {
            this.dragConnection(e, selected.connection);
            this.on('connect:source', function() { palette.selected = null; });
        }
    },
    */

    createContent: function(diagram) {
        _.each(this.model.get('eAttributes'), function(attr) {
            this.children[1].add(new EAttributeShape({ model: attr }));
        }, this);
/*
        this.model.get('eOperations').each(function(o) {
            this.children[2].add(new EOperationShape({ model: o }));
        }, this);
*/
    }

});



var layout = function() {
    var current = { x: 0, y: 100 };
    return function() {
        var ws = 10, we = 800,
            pad = 150;

        if (we > (current.x + pad)) {
            current.x = current.x + pad;
            current.y = current.y;
        } else {
            current.x = ws;
            current.y = current.y + pad;
        }
        return current;
    };
};

var EcoreDiagram = DG.Diagram.extend({
    initialize: function(attributes) {
        var attrs = attributes || {};
        this.layout = layout();
        if (attrs.model) {
            this.model = attrs.model;
            this.createContent();
        }
        this.wrapper.on('click', this.addFromPalette(this));
    },
    addFromPalette: function(diagram) {
        return function(e) {
            var palette = Workbench.palette;
            var selected = palette.selected;
            var shape, options;

            if (selected && typeof selected.shape === 'function') {
                options = DG.Point.get(e);
                options.diagram = diagram;
                shape = new selected.shape(options);
                diagram.add(shape);
                diagram.render();
                palette.selected = null;
            }
        };
    },
    createContent: function() {
        this.model.get('eClassifiers').each(function(c) {
            if (c.isTypeOf('EClass')) {
                var position = this.layout();
                var shape = new EClassShape({ diagram: this, model: c, x: position.x, y: position.y });
                this.add(shape);
            }
        }, this);
    }
});


/**
 * @name NavBox
 */
var NavBox = Backbone.View.extend({
    template: _.template('<div class="nav-box"></div>'),
    templateHeader: _.template('<div class="nav-box-header"><%= title %><i class="icon-large"></i></div>'),

    _icon_up: 'icon-double-angle-up',
    _icon_down: 'icon-double-angle-down',

    events: {
        'click .icon-double-angle-up': 'hide',
        'click .icon-double-angle-down': 'show'
    },
    initialize: function(attributes) {
        this.navigator = attributes.navigator;
        this.views = [];
        this.isRender = false;
    },
    render: function() {
        if (this.isRender) return this;

        var html = this.template();
        var header = this.templateHeader({ title: this.title });
        this.setElement(html);
        this.$el.append(header);
        $('i[class~="icon-large"]', this.$el).addClass(this._icon_up);
        this.isRender = true;

        return this;
    },
    show: function() {
        _.each(this.views, function(view) { this.$el.append(view.render().$el); }, this);
        $('i[class~="'+ this._icon_down + '"]', this.$el)
            .removeClass(this._icon_down)
            .addClass(this._icon_up);
    },
    hide: function() {
        _.each(this.views, function(view) { view.remove(); });
        $('i[class~="' + this._icon_up + '"]', this.$el)
            .removeClass(this._icon_up)
            .addClass(this._icon_down);
    },
    removeView: function(view) {
        view.remove();
    },
    removeViews: function() {
        _.each(this.views, this.removeView);
    },
    remove: function() {
        this.removeViews();
        this.views.length = 0;
        return Backbone.View.prototype.remove.apply(this);
    }
});


/**
 * NavigatorHeaderView
 *
 */
var NavigatorHeaderView = Backbone.View.extend({
    template: _.template('<div class="nav-header"><div class="nav-header-content"></div></div>'),
//    templateTitle: _.template('<h3>Ecore Editor</h3>'),
    templateHide: _.template('<i class="icon-double-angle-left icon-large"></i>'),
    templateShow: _.template('<i class="icon-double-angle-right icon-large"></i>'),

    events: {
        'click .icon-double-angle-left': 'hide',
        'click .icon-double-angle-right': 'show'
    },

    initialize: function(attributes) {
        _.bindAll(this);
    },

    render: function(hide) {
        if (this.$el) this.remove();

        var html = this.template();
        this.setElement(html);
        var $content = $('.nav-header-content', this.$el),
            icon, title;

        if (hide) {
            icon = this.templateShow();
            $content.append(icon);
        } else {
//            title = this.templateTitle();
            icon = this.templateHide();
            $content.append(icon);
        }

        return this;
    },

    hide: function() {
        this.trigger('hide');
    },

    show: function() {
        this.trigger('show');
    }

});


/**
 * @name PaletteView
 *
 */
var PaletteView = NavBox.extend({
    title: 'Palette',

    shapes: {
//        'EPackage': EPackageShape,
          'EClass': EClassShape,
//        'EEnum': EEnumShape,
//        'EEnumLiteral': EEnumLiteralShape,
//        'EDataType': EDataTypeShape,
          'EAttribute': EAttributeShape
//        'EOperation': EOperationShape
    },

    connections: {
//        'EReference': EReferenceConnection,
//        'ESuperTypes': ESuperTypesConnection
    },

    initialize: function(attributes) {
        _.bindAll(this);
        NavBox.prototype.initialize.apply(this, [attributes]);
    },

    render: function() {
        NavBox.prototype.render.apply(this);

        /*
        this.header = new PaletteHeaderView({ palette: this });
        this.header.render();
        this.$el.append(this.header.$el);
        */

        _.each(this.shapes, function(shape, title) {
            var view = new PaletteItemView({ palette: this, shape: shape, title: title });
            this.views.push(view);
            this.$el.append(view.render().$el);
        }, this);

        _.each(this.connections, function(connection, title) {
            var view = new PaletteItemView({ palette: this, connection: connection, title: title });
            this.views.push(view);
            this.$el.append(view.render().$el);
        }, this);

        return this;
    }

});

var PaletteHeaderView = Backbone.View.extend({
    template: '<div class="nav-row"></div>',
    initialize: function(attributes) {
        this.palette = attributes.palette;
    },
    render: function() {
        this.setElement(this.template);
        console.log(this.$el);
        this.selectTool = new ToolItemView({
            palette: this.palette,
            title: 'select',
            icon: 'icon-arrow'
        });
        this.selectTool.render();
        this.$el.append(this.selectTool.$el);
        return this;
    }
});

/**
 * @name PaletteItemView
 *
 */
var PaletteItemView = Backbone.View.extend({
    template: _.template('<div class="nav-row"><i class="icon-edit-<%= title %>"></i><span><%= title %></span></div>'),
    events: {
        'click': 'select'
    },
    initialize: function(attributes) {
        _.bindAll(this);
        this.palette = attributes.palette;
        this.shape = attributes.shape;
        this.connection = attributes.connection;
        this.title = attributes.title;
    },
    render: function() {
        var html = this.template({ title: this.title });
        this.setElement(html);
        return this;
    },
    select: function() {
        this.palette.selected = this;
    }
});

var ToolItemView = PaletteItemView.extend({
    template: _.template('<i class="<%= icon %>"></i><span><%= title %></span>'),
    initialize: function(attributes) {
        PaletteItemView.prototype.initialize.apply(this, [attributes]);
        this.icon = attributes.icon;
    },
    render: function() {
        this.setElement(this.template({ title: this.title, icon: this.icon }));
        return this;
    }
});


/**
 * @name ResourceSetView
 * @class
 */
var ResourceSetView = NavBox.extend({
    title: 'Resources',

    initialize: function(attributes) {
        _.bindAll(this, 'show', 'hide');
        NavBox.prototype.initialize.apply(this, [attributes]);
        this.modal = new CreateResourceModal({ model: this.model });
        this.model.on('change add remove', this.render);
    },

    render: function() {
        NavBox.prototype.render.apply(this);

        this.model.get('resources').each(this.addResource, this);
        var emptyView = new ResourceView().render();
        this.views.push(emptyView);
        this.$el.append(emptyView.$el);

        _.each(this.views, function(view) {
            view.on('create', this.createResource, this);
            view.on('open:editor', function() { this.navigator.trigger('open:editor', view.model); }, this);
            view.on('remove', this.deleteResource, this);
        }, this);

        return this;
    },

    addResource: function(res) {
        var view = new ResourceView({ model: res });
        view.render();
        this.views.push(view);
        this.$el.append(view.$el);
        return this;
    },

    deleteResource: function(resource) {
    // TODO
    // this.model.remove(resource);
    },

    createResource: function(e) {
        this.modal.render().show();
    }

});

/**
 * @name ResourceView
 * @class
 */
var ResourceView = Backbone.View.extend({
    template:
        '<div class="nav-row"></div>',
    templateResource: _.template(
            '<i class="<%= icon1 %>"></i>' +
            '<span> <%= uri %></span>' +
            '<i class="<%= icon2 %>""></i>'),
    templateAdd: _.template(
        '<i class="<%= icon4 %>"></i>'),

    events: {
        'click': 'openEditor',
        'click .icon-remove': 'remove',
        'click .icon-plus': 'createResource'
    },

    icons: [
        { klass: 'icon-folder-close icon-large' },
        { klass: 'icon-remove icon-large', tooltip: 'Delete this resource' },
        { klass: 'icon-plus icon-large', tooltip: 'Create a new resource' }
    ],

    initialize: function(attributes) {
        _.bindAll(this);
    },
    render: function() {
        this.setElement(this.template);

        if (this.model) {
            var title = this.model.get('uri');
            var idx = title.lastIndexOf('/');
            title = idx ? title.substring(idx + 1, title.length) : title;
            this.$el.children().remove();
            this.$el.append(this.templateResource({
                icon1: this.icons[0].klass,
                icon2: this.icons[1].klass,
                uri: title
            }));
        } else {
            this.$el.children().remove();
            this.$el.append(this.templateAdd({
                icon4: this.icons[2].klass
            }));
        }

        this.addTooltip();

        return this;
    },
    addTooltip: function() {
        _.each(this.icons, function(icon) {
            var el = $('i[class="'+icon.klass+'"]', this.$el);
            if (el.length && icon.tooltip)
                el.tooltip({
                    placement: 'right',
                    title: icon.tooltip,
                    trigger: 'hover'
                });
        }, this);
    },
    openEditor: function(e) {
        if (e) e.stopPropagation();
        if (this.model) {
            this.trigger('open:editor', this.model);
        }
    },
    createResource: function() {
        this.trigger('create', this);
    },
    remove: function() {
        this.trigger('remove', this.model);
        return Backbone.View.prototype.remove.apply(this);
    }
});



var PropertyView = NavBox.extend({
    title: 'Properties',
    initialize: function(attributes) {
        NavBox.prototype.initialize.apply(this, [attributes]);
    },
    render: function() {
        NavBox.prototype.render.apply(this);
        this.update();
        _.each(this.views, this.renderView, this);
        return this;
    },
    update: function() {
        this.removeViews();
        this.views.length = 0;

        var model = this.model;
        if (model) {
            var filter = function(attr) {
                return !attr.get('many') && !attr.get('derived');
            };
            var features = _.filter(model.eClass.get('eAllAttributes'), filter);
            features = _.union(features, _.filter(model.eClass.get('eAllReferences'), function(r) {
                return !r.get('containment') && !r.get('derived');
            }));
            var label, edit;
            this.views = _.flatten(_.map(features, function(attr) {
                if (attr.get('eType') === Ecore.EBoolean) {
                    return new BooleanView({ model: model, attribute: attr });
                } else if (attr.isTypeOf('EAttribute')) {
                    label = new LabelView({ model: attr.get('name') });
                    edit = new TextView({ model: model, attribute: attr });
                    return [label, edit];
                } else if (attr.get('many')) {
                     label = new LabelView({ model: attr.get('name') });
                     return label;
                } else {
                    label = new LabelView({ model: attr.get('name') });
                    edit = new SingleSelectView({ model: model, reference: attr });
                    return [label, edit];
                }
            }));
        } else {
            this.views = [];
        }
    },
    renderView: function(view) {
        var $v = view.render().$el;
        this.$el.append($v);
    }
});


var RowView = Backbone.View.extend({
    template: '<div class="nav-row"></div>',
    render: function() {
        this.setElement(this.template);
        return this;
    }
});


var LabelView = RowView.extend({
    labelTmpl: _.template(
        '<label class="label-property">' +
            '<%= text %>' +
        '</label>'
    ),
    initialize: function(attributes) {
    },
    render: function() {
        RowView.prototype.render.apply(this);
        this.$el.append(this.labelTmpl({
            text: this.model
        }));
        return this;
    }
});


var TextView = RowView.extend({
    textTmpl: _.template(
        '<div class="text-property" contenteditable="">' +
            '<%= text %>' +
        '</div>'
    ),
    initialize: function(attributes) {
        this.attribute = attributes.attribute;
    },
    render: function() {
        RowView.prototype.render.apply(this);
        this.$el.append(this.textTmpl({
            text: this.model.get(this.attribute)
        }));
        return this;
    }
});


var BooleanView = RowView.extend({
    boolTmpl: _.template(
        '<div class="bool-property">' +
            '<label>' +
                '<input type="checkbox" <% if (value) { %> checked <% } %> >' +
                '<%= label %>' +
            '</label>' +
        '</div>'
    ),
    initialize: function(attributes) {
        this.attribute = attributes.attribute;
    },
    render: function() {
        RowView.prototype.render.apply(this);
        var value = this.model.get(this.attribute) === true ? true : false;
        this.$el.append(this.boolTmpl({
            label: this.attribute.get('name'),
            value: value
        }));
        return this;
    }
});


var SingleSelectView = RowView.extend({
    selectTmpl: _.template(
        '<select></select>'
    ),
    initialize: function(attributes) {
        this.reference = attributes.reference;
    },
    render: function() {
        RowView.prototype.render.apply(this);
        this.$el.append(this.selectTmpl({
        }));
        return this;
    }
});


/**
 * Navigator
 *
 */
var NavigatorView = Backbone.View.extend({
    el: '#navigator',

    initialize: function() {
        _.bindAll(this);
        this.resourceSetView = new ResourceSetView({ model: this.model, navigator: this });
        this.paletteView = new PaletteView({ navigator: this });
        this.propertyView = new PropertyView({ navigator: this });

        this.header = new NavigatorHeaderView();
        this.header.on('hide', this.hide);
        this.header.on('show', this.show);
    },

    render: function() {
        this.$header = this.header.render().$el;
        this.$el.append(this.$header);
        this.$el.append(this.resourceSetView.render().$el);
        this.$el.append(this.paletteView.render().$el);
        this.$el.append(this.propertyView.render().$el);

        return this;
    },

    hide: function() {
        this.trigger('hide');
        this.resourceSetView.remove();
        this.paletteView.remove();
        this.propertyView.remove();
        this.$header = this.header.render(true).$el;
        this.$el.append(this.$header);
        this.$el.animate({ width: '30px' }, 200);
    },

    show: function() {
        this.trigger('show');
        this.$el.animate({ width: '280px' }, 200);
        this.render();
    }

});




var ModalView = Backbone.View.extend({
    template: _.template('<div id="<%= id =>" class="modal hide fade"></div>'),
    templateHeader: _.template('<div class="modal-header"></div>'),
    templateBody: _.template('<div class="modal-body"></div>'),
    templateFooter: _.template('<div class="modal-footer"><a href="#" class="btn mclose">Close</a><a href="#" class="btn confirm">Confirm</a></div>'),

    render: function() {
        var html = this.template({ id: this.cid });
        var header = this.templateHeader();
        var body = this.templateBody();
        var footer = this.templateFooter();

        this.setElement(html);
        this.$el.append(header);
        this.$el.append(body);
        this.$el.append(footer);

        this.$header = $('div[class="modal-header"]', this.$el);
        this.$body = $('div[class="modal-body"]', this.$el);
        this.$footer = $('div[class="modal-footer"]', this.$el);

        return this;
    },

    show: function() {
        this.$el.modal('show');
    },

    hide: function() {
        this.$el.modal('hide');
    }

});

var CreateResourceModal = ModalView.extend({
    templateForm: _.template('<form class="form-horizontal"></form>'),
    templateControlURI: _.template('<div class="control-group"><label class="control-label" for="inputURI">URI</label><div class="controls"><input type="text" id="inputURI" placeholder="URI"></div></div>'),
    templateControlElement: _.template('<div class="control-group"><label class="control-label" for="inputElement">Element</label><div class="controls"><select type="text" id="selectElement"></select></div>'),
    templateHeaderContent: _.template('<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h3>Create Resource</h3></div>'),
    templateOptions: _.template('<% _.each(options, function(option) { %> <option><%= option.get("name") %></option> <% }); %>'),

    events: {
        'click .modal-footer a[class~="confirm"]': 'onConfirm',
        'click .modal-footer a[class~="mclose"]': 'onClose'
    },

    initialize: function() {
        _.bindAll(this, 'onConfirm');
    },

    render: function() {
        ModalView.prototype.render.apply(this);

        var html = this.templateForm();
        var header = this.templateHeaderContent();
        var cURI = this.templateControlURI();
        var cElt = this.templateControlElement();

        this.$header.append(header);
        this.$body.append(html);
        this.$form = $('form', this.$body);
        this.$form.append(cURI).append(cElt);

        this.$select = $('#selectElement', this.$form);
        this.classes = this.model.elements('EClass');
        this.classes = _.filter(this.classes, function(c) { return !c.get('abstract'); });

        var options = this.templateOptions({ options: this.classes });
        this.$select.append(options);

        return this;
    },

    createResource: function(uri, eClass) {
        var res = this.model.create({ uri: uri });
        res.get('contents').add(eClass.create());
        this.model.trigger('change add', res);
    },

    onClose: function() {
        this.hide();
    },

    onConfirm: function() {
        var uri = $('#inputURI', this.$form).val();
        var element = $('option:selected', this.$select).val();

        if (uri && uri.length && element) {
            var eClass = _.find(this.classes, function(c) { return c.get('name') === element; } );
            if (eClass) this.createResource(uri, eClass);
        }

        this.$el.modal('hide');
    }

});



var PropertyWindow = Ecore.Edit.Window.extend({
    el: '#property-window',
    title: 'Property',
    draggable: true,
    content: new Ecore.Edit.PropertySheet(),
    render: function() {
        this.content.model = this.model;
        return Ecore.Edit.Window.prototype.render.apply(this);
    }
});



var DiagramPanelPart = Ecore.Edit.PanelPart.extend({
    tmpl: _.template('<div id="diagram-<%= id %>" style="width: 100%; height: 100%;"></div>'),
    initialize: function(attributes) {
//            model: this.model.get('contents').first()
    },
    renderContent: function() {
        if (!this.$diagram) {
            this.$diagram = $(this.tmpl({ id: this.cid }));
            this.$content.append(this.$diagram);
        }
        if (!this.diagram) {
            this.diagram = new EcoreDiagram(this.$diagram[0], {
                model: this.model.get('contents').first()
            });
        }
    }
});

var MultiPartEditor = Ecore.Edit.MultiPanelElement.extend({
    initialize: function(attributes) {
        this.title = Ecore.Edit.util.lastSegment(this.model.get('uri'));
        this.tab = new Ecore.Edit.TabDropdown({ title: this.title, editor: this });
        var part1 = new Ecore.Edit.TreePanelPart({ model: this.model });
        var part2 = new DiagramPanelPart({ model: this.model });
        this.tab.addDropItem('Tree Editor', part1.cid);
        this.tab.addDropItem('Diagram Editor', part2.cid, function() {
            part2.diagram.render();
        });
        var me = this.tab;
        this.tab.addDropItem('Close', function() { me.remove(); });
        this.parts = [part1, part2];
        this.tab.on('remove', this.remove, this);
        this.parts[0].tree.on('select', function(m) { this.trigger('select', m); }, this);
        this.parts[0].tree.on('deselect', function(m) { this.trigger('deselect', m); }, this);
    }
});

var EcoreTabPanel = Ecore.Edit.TabPanel.extend({
    el: '#main2',

    open: function(model, diagram) {
        var editor = this.find(model);
        if (!editor) {
            editor = new MultiPartEditor({ model: model });
            this.add(editor);
            editor.on('select', function(m) { this.trigger('select', m); }, this);
            editor.on('deselect', function(m) { this.trigger('deselect', m); }, this);
            editor.render();
        }
        this.show(editor);
        if (editor.diagram) editor.diagram.render();
    },

    find: function(model) {
        return _.find(this.elements, function(element) {
            return element.model === model;
        });
    },

    expand: function() {
        this.$el[0].style.left = '20px';
    }

});


//
// dnd
//

function handleFileSelect(e) {
    e.stopPropagation();
    e.preventDefault();

    var startByte = e.target.getAttribute('data-startbyte');
    var endByte = e.target.getAttribute('data-endbyte');

    var files = e.dataTransfer.files;
    var file = files[0];
    var reader = new FileReader();

    reader.onloadend = function(e) {
        if (e.target.readyState == FileReader.DONE) {
            var data = e.target.result;
            var res = resourceSet.create({ uri: file.name  });
            res.parse(data, Ecore.XMI);
            resourceSet.trigger('change');
        }
    };

    var blob = file.slice(0, file.size);
    reader.readAsBinaryString(blob);
}

function handleDragOver(e) {
    e.stopPropagation();
    e.preventDefault();
    e.dataTransfer.dropEffect = 'copy';
}

var dropzone = $('#navigator')[0];
if (dropzone) {
    dropzone.addEventListener('dragover', handleDragOver, false);
    dropzone.addEventListener('drop', handleFileSelect, false);
}



// initialize models
var resourceSet = Ecore.ResourceSet.create();

var EcoreResource = resourceSet.create({ uri: Ecore.EcorePackage.get('nsURI') });

var ResourceResource = resourceSet.create({ uri: 'http://www.eclipselabs.org/ecore/2012/resources' });

var SampleResource = resourceSet.create({ uri: 'sample.ecore' });
var SamplePackage = Ecore.EPackage.create({
    name: 'sample', 
    nsPrefix: 'sample', 
    nsURI: ',/sample',
    eClassifiers: [
        {   eClass: Ecore.EClass, name: 'Foo',
            eStructuralFeatures:[
                { eClass: Ecore.EAttribute, name: 'bar', eType: Ecore.EString }
            ]
        }
    ]
});
SampleResource.get('contents').add(SamplePackage);


var BascianiResource = resourceSet.create({ uri: 'C:/Users/Francesco/Desktop/WebAppMM.ecore' });
resourceSet.parse(BascianiResource, Ecore.XMI); // data being a string containing the XMI.






window.Workbench = _.extend({}, Backbone.Events);
Workbench.properties = new PropertyWindow();
Workbench.editorTab = new EcoreTabPanel();
Workbench.navigator = new NavigatorView({ model: resourceSet });
Workbench.palette = Workbench.navigator.paletteView;

window.onload = function() {

    Workbench.navigator.render();

    Workbench.navigator.on('open:editor', function(m) {
        this.editorTab.render().open(m);
    }, Workbench);

    Workbench.navigator.on('open:diagram', function(m) {
        this.editorTab.render().open(m, true);
    }, Workbench);

    Workbench.navigator.on('hide', function() {
        $('#main2').animate({ left: '30px' }, 200);
    }, Workbench);

    Workbench.navigator.on('show', function() {
        $('#main2').animate({ left: '280px' }, 200);
    }, Workbench);

    Workbench.editorTab.on('select', function(m) {
        this.navigator.propertyView.model = m.model;
        this.navigator.propertyView.render();
    }, Workbench);

    Workbench.properties.content.on('change', function() {
        console.log(Workbench.editorTab);
    }, Workbench);

    resourceSet.on('add', function(m) {
        this.editorTab.render().open(m);
        this.properties.content.model = m;
        this.properties.render();
    }, Workbench);

};

