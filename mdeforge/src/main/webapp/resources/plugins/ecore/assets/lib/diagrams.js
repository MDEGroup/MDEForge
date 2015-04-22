(function() {


var root = this;
var DG = root.DG = {};

// Helper function to correctly set up the prototype chain, for subclasses.
// Similar to `goog.inherits`, but uses a hash of prototype properties and
// class properties to be extended.
var extend = function(protoProps, staticProps) {
    var parent = this;
    var child;

    // The constructor function for the new subclass is either defined by you
    // (the "constructor" property in your `extend` definition), or defaulted
    // by us to simply call the parent's constructor.
    if (protoProps && _.has(protoProps, 'constructor')) {
        child = protoProps.constructor;
    } else {
        child = function(){ return parent.apply(this, arguments); };
    }

    // Add static properties to the constructor function, if supplied.
    _.extend(child, parent, staticProps);

    // Set the prototype chain to inherit from `parent`, without calling
    // `parent`'s constructor function.
    var Surrogate = function(){ this.constructor = child; };
    Surrogate.prototype = parent.prototype;
    child.prototype = new Surrogate;

    // Add prototype properties (instance properties) to the subclass,
    // if supplied.
    if (protoProps) _.extend(child.prototype, protoProps);

    // Set a convenience property in case the parent's prototype is needed
    // later.
    child.__super__ = parent.prototype;

    return child;
};


/**
 * Representation of a 2D Point.
 *
 * @name Point
 * @class
 *
 */
var Point = DG.Point = function(x, y) {
    this.x = x;
    this.y = y;
};

Point.prototype.vector = function(point) {
    return Point.vector(this, point);
};

Point.prototype.theta = function(point) {
    return Point.theta(this, point);
};

Point.prototype.add = function(point) {
    this.x += point.y;
    this.y += point.y;
};

Point.prototype.sub = function(point) {
    this.x -= point.x;
    this.y -= point.y;
};

Point.prototype.equals = function(point) {
    if (!point)
        return false;
    else
        return this.x === point.x && this.y === point.y;
};

/**
 * Return Point inside the diagram from a mouse event.
 *
 */
Point.get = function(e) {
    var point;
    if (e && e.offsetX) {
        point = new Point(e.offsetX, e.offsetY);
    } else if (e && e.layerX) {
        point = new Point(e.layerX, e.layerY);
    }
    return point;
};

Point.theta = function(p1, p2) {
    var y = -(p2.y - p1.y), // invert the y-axis
        x = p2.x - p1.x,
        rad = Math.atan2(y, x);

    if (rad < 0) { // correction for III. and IV. quadrant
        rad = 2 * Math.PI + rad;
    }

    return {
        degrees: 180 * rad / Math.PI,
        radians: rad
    };
};

Point.vector = function(p1, p2) {
    return {
        x: p2.x - p1.x,
        y: p2.y - p1.y
    };
};

// Draw a line between two points.
//
var path = function(draw, p1, p2) {
    return {
        path: draw.path('M' + p1.x + ' ' + p1.y + 'L' + p2.x + ' ' + p2.y),
        start: p1,
        end: p2
    };
};


// Return the point of intersection of two lines.
//
var intersection = function(path1, path2) {
    var pt1Dir  = { x: path1.end.x - path1.start.x, y: path1.end.y - path1.start.y },
        pt2Dir  = { x: path2.end.x - path2.start.x, y: path2.end.y - path2.start.y },
        det     = (pt1Dir.x * pt2Dir.y) - (pt1Dir.y * pt2Dir.x),
        deltaPt = { x: path2.start.x - path1.start.x, y: path2.start.y - path1.start.y },
        alpha   = (deltaPt.x * pt2Dir.y) - (deltaPt.y * pt2Dir.x),
        beta    = (deltaPt.x * pt1Dir.y) - (deltaPt.y * pt1Dir.x);

    if (det === 0 || alpha * det < 0 || beta * det < 0) {
        return null; // no intersection
    }

    if (det > 0) {
        if (alpha > det || beta > det) {
            return null;
        }
    } else {
        if (alpha < det || beta < det) {
            return null;
        }
    }

    return {
        x: path1.start.x + (alpha * pt1Dir.x / det),
        y: path1.start.y + (alpha * pt1Dir.y / det)
    };
};


// Return the point of intersection between a line and a Bbox.
//
var findIntersection = function(draw, line, box) {
    var topLeft     = { x: box.x, y: box.y },
        topRight    = { x: box.x + box.width, y: box.y },
        bottomLeft  = { x: box.x, y: box.y + box.height },
        bottomRight = { x: box.x + box.width, y: box.y + box.height },

        points = [
            { p1: topLeft, p2: topRight },
            { p1: topLeft, p2: bottomLeft },
            { p1: bottomLeft, p2: bottomRight },
            { p1: bottomRight, p2: topRight }
        ],

        i = 0,
        l = points.length,
        boxLine,
        intersect;

    for (; i < l; i++) {
        boxLine = path(draw, points[i].p1, points[i].p2);
        intersect = intersection(line, boxLine);
        boxLine.path.remove();

        if (intersect) {
            return intersect;
        }
    }

    return null;
};


DG.Arrows = Arrows = {

    get: function(type) {
        if (typeof DG.Arrows[type] === 'function')
            return DG.Arrows[type];
        else return DG.Arrows.basic;
    },

    none: function(size) {
        if (!size) size = 2;
        return {
            path: [
                'M', size, '0',
                'L', ''+(-size),
                '0'
            ],
            dx: size,
            dy: size,
            attr: {
                opacity: 0
            }
        };
    },

    basic: function(size) {
        if (!size) size = 4;
        return {
            path: [
                'M', ''+size, '0',
                'L', ''+(-size), ''+(-size),
                'L', ''+(-size), ''+size, 'Z'
            ],
            dx: size,
            dy: size,
            attr: {
                stroke: 'black',
                fill: 'black'
            }
        };
    }

};


/*
 * Events API from Backbone.js
 *
 */

var array = [];
//var push = array.push;
var slice = array.slice;
//var splice = array.splice;

var Events = DG.Events = {

    // Bind an event to a `callback` function. Passing `"all"` will bind
    // the callback to all events fired.
    on: function(name, callback, context) {
        if (!eventsApi(this, 'on', name, [callback, context]) || !callback) return this;
        this._events || (this._events = {});
        var events = this._events[name] || (this._events[name] = []);
        events.push({callback: callback, context: context, ctx: context || this});
        return this;
    },

    // Bind an event to only be triggered a single time. After the first time
    // the callback is invoked, it will be removed.
    once: function(name, callback, context) {
        if (!eventsApi(this, 'once', name, [callback, context]) || !callback) return this;
        var self = this;
        var once = _.once(function() {
            self.off(name, once);
            callback.apply(this, arguments);
        });
        once._callback = callback;
        return this.on(name, once, context);
    },

    // Remove one or many callbacks. If `context` is null, removes all
    // callbacks with that function. If `callback` is null, removes all
    // callbacks for the event. If `name` is null, removes all bound
    // callbacks for all events.
    off: function(name, callback, context) {
        var retain, ev, events, names, i, l, j, k;
        if (!this._events || !eventsApi(this, 'off', name, [callback, context])) return this;
        if (!name && !callback && !context) {
            this._events = {};
            return this;
        }

        names = name ? [name] : _.keys(this._events);
        for (i = 0, l = names.length; i < l; i++) {
            name = names[i];
            if (events = this._events[name]) {
                this._events[name] = retain = [];
                if (callback || context) {
                    for (j = 0, k = events.length; j < k; j++) {
                        ev = events[j];
                        if ((callback && callback !== ev.callback && callback !== ev.callback._callback) ||
                                (context && context !== ev.context)) {
                                    retain.push(ev);
                                }
                    }
                }
                if (!retain.length) delete this._events[name];
            }
        }

        return this;
    },

    // Trigger one or many events, firing all bound callbacks. Callbacks are
    // passed the same arguments as `trigger` is, apart from the event name
    // (unless you're listening on `"all"`, which will cause your callback to
    // receive the true name of the event as the first argument).
    trigger: function(name) {
        if (!this._events) return this;
        var args = slice.call(arguments, 1);
        if (!eventsApi(this, 'trigger', name, args)) return this;
        var events = this._events[name];
        var allEvents = this._events.all;
        if (events) triggerEvents(events, args);
        if (allEvents) triggerEvents(allEvents, arguments);
        return this;
    },

    // Tell this object to stop listening to either specific events ... or
    // to every object it's currently listening to.
    stopListening: function(obj, name, callback) {
        var listeners = this._listeners;
        if (!listeners) return this;
        var deleteListener = !name && !callback;
        if (typeof name === 'object') callback = this;
        if (obj) (listeners = {})[obj._listenerId] = obj;
        for (var id in listeners) {
            listeners[id].off(name, callback, this);
            if (deleteListener) delete this._listeners[id];
        }
        return this;
    }

};

// Regular expression used to split event strings.
var eventSplitter = /\s+/;

// Implement fancy features of the Events API such as multiple event
// names `"change blur"` and jQuery-style event maps `{change: action}`
// in terms of the existing API.
var eventsApi = function(obj, action, name, rest) {
    if (!name) return true;

    // Handle event maps.
    if (typeof name === 'object') {
      for (var key in name) {
        obj[action].apply(obj, [key, name[key]].concat(rest));
      }
      return false;
    }

    // Handle space separated event names.
    if (eventSplitter.test(name)) {
      var names = name.split(eventSplitter);
      for (var i = 0, l = names.length; i < l; i++) {
        obj[action].apply(obj, [names[i]].concat(rest));
      }
      return false;
    }

    return true;
};

// A difficult-to-believe, but optimized internal dispatch function for
// triggering events. Tries to keep the usual cases speedy (most internal
// Backbone events have 3 arguments).
var triggerEvents = function(events, args) {
    var ev, i = -1, l = events.length, a1 = args[0], a2 = args[1], a3 = args[2];
    switch (args.length) {
      case 0: while (++i < l) (ev = events[i]).callback.call(ev.ctx); return;
      case 1: while (++i < l) (ev = events[i]).callback.call(ev.ctx, a1); return;
      case 2: while (++i < l) (ev = events[i]).callback.call(ev.ctx, a1, a2); return;
      case 3: while (++i < l) (ev = events[i]).callback.call(ev.ctx, a1, a2, a3); return;
      default: while (++i < l) (ev = events[i]).callback.apply(ev.ctx, args);
    }
};

var listenMethods = {listenTo: 'on', listenToOnce: 'once'};

// Inversion-of-control versions of `on` and `once`. Tell *this* object to
// listen to an event in another object ... keeping track of what it's
// listening to.
_.each(listenMethods, function(implementation, method) {
    Events[method] = function(obj, name, callback) {
        var listeners = this._listeners || (this._listeners = {});
        var id = obj._listenerId || (obj._listenerId = _.uniqueId('l'));
        listeners[id] = obj;
        if (typeof name === 'object') callback = this;
        obj[implementation](name, callback, this);
        return this;
    };
});


/**
 * @name SelectionBox
 * @class
 */
var SelectionBox = function() {
    this.constructor.call(this, SVG.create('rect'));
    this.attr(SelectionBox.style);
};

SelectionBox.style = {
    "stroke": "#00f",
    "stroke-width": 2,
    fill: "#aaf",
    opacity: 0.4
};

SelectionBox.prototype = new SVG.Shape();

SelectionBox.mousedown = function(container) {
    return function(e) {
        var p = Point.get(e);
        var box = container.selectionBox = container.doc.selectionBox();
        box.startPosition = { x: p.x, y: p.y };
        box.move(p.x, p.y);
    };
};

SelectionBox.mouseup = function(container) {
    return function() {
        var box = container.selectionBox;
        if (box) {
            container.selectNodes({
                x: box.attr('x'),
                y: box.attr('y'),
                width: box.attr('width'),
                height: box.attr('height')
            });
            box.remove();
            delete container.selectionBox;
        }
    };
};

SelectionBox.mousemove = function(container) {
    return function(e) {
        var p, dx, dy, start,
            xoffset = 0,
            yoffset = 0,
            box = container.selectionBox;

        if (box) {
            start = box.startPosition;
            p = Point.get(e);
            dx = p.x - start.x;
            dy = p.y - start.y;

            if (dx < 0) {
                xoffset = dx;
                dx = -1 * dx;
            }
            if (dy < 0) {
                yoffset = dy;
                dy = -1 * dy;
            }

            box.transform({ x: xoffset, y: yoffset });
            box.size(dx, dy);
        }
    };
};

SVG.extend(SVG.Container, {
    selectionBox: function(attributes) {
        return this.put(new SelectionBox(attributes));
    }
});


/**
 * @name Diagram
 * @class
 *
 */
var Diagram = DG.Diagram = function(element, options) {
    this.doc        = new SVG.Doc(element);
    this.shapes     = [];
    this.edges      = [];
    this.selected   = [];
    this.wrapper    = this.doc.rect().attr(Diagram.figure);

    this.wrapper.click(Diagram.delSelection(this));
    this.wrapper.on('mousedown', SelectionBox.mousedown(this));
    SVG.on(window, 'mouseup', SelectionBox.mouseup(this));
    SVG.on(window, 'mousemove', SelectionBox.mousemove(this));
    this.on('click', this.deselect);

   this.initialize.apply(this, [options]);
};

Diagram.extend = extend;

Diagram.figure = {
    fill: '#fff',
    'fill-opacity': 0,
    stroke: 'none',
    width: '100%',
    height: '100%'
};

Diagram.addElement = function(diagram) {
    return function(element) {
        if (element instanceof Shape || element instanceof Label) {
            element.parent = diagram;
            element.isRoot = true;
            diagram.shapes.push(element);
            element.on('select', Diagram.addSelection(diagram, element));
        } else if (arg instanceof Connection) {
            element.parent = diagram;
            diagram.edges.push(element);
            element.on('select', Diagram.addSelection(diagram, element));
        }
    };
};

Diagram.addSelection = function(diagram, element) {
    return function() {
        diagram.select(element);
    };
};

Diagram.delSelection = function(diagram) {
    return function() {
        diagram.deselect();
    };
};

_.extend(DG.Diagram.prototype, Events, {

    initialize: function() {},

    eachShape: function(fn, ctx) {
        _.each(this.shapes, fn, ctx || this);
        return this;
    },

    eachEdge: function(fn, ctx) {
        _.each(this.edges, fn, ctx || this);
        return this;
    },

    findShape: function(fn, ctx) {
        return _.find(this.shapes, fn, ctx);
    },

    add: function() {
        _.each(arguments, Diagram.addElement(this));
        return this;
    },

    render: function() {
        return this.eachShape(function(s) {
            s.render();
        }).eachEdge(function(e) {
            e.render();
        });
    },

    remove: function(element) {
        if (element instanceof Connection) {
            this.edges = _.without(this.edges, element);
        } else {
            this.shapes = _.without(this.shapes, element);
        }
    },

    select: function(element) {
        var isSelected = _.find(this.selected, function(e) {
            return e === element;
        });
        if (!isSelected) {
            this.selected.push(element);
        }
    },

    deselect: function(element) {
        if (element) {
            element.deselect();
            this.selected = _.without(this.selected, element);
        } else {
            _.each(this.selected, function(e) {
                e.deselect();
            });
            this.selected.length = 0;
        }
        return this;
    },

    selectNodes: function(box) {
        this.eachShape(function(shape) {
            if (shape.isInside(box)) {
                shape.select();
            }
        }, this);
    }

});


/**
 * @class
 * @name GridLayout
 *
 */
var GridLayout = DG.GridLayout = function(shape, data) {
    if (!shape) throw Error('Shape is not defined');
    data = data || {};

    this._shape         = shape;
    this._columns       = data.columns || 1;
    this._rows          = data.rows || 0;
    this.marginHeight   = data.marginHeight || 0;
    this.marginWidth    = data.marginWidth || 0;
    this.vgap           = data.vgap || 0;
    this.hgap           = data.hgap || 0;
};

GridLayout.prototype.columns = function() {
    var elements = this._shape.children;
    if (this._rows > 0)
        return Math.floor((elements.length + this._rows - 1) / this._rows);
    else
        return this._columns;
};

GridLayout.prototype.size = function() {
    if (!this._shape.children.length) return;

    this.rows   = this.createRows();
    this.bounds = this.computeSize();

    return this.bounds;
};

GridLayout.prototype.computeSize = function() {
    var max = _.max(this.rows || [], function(row) { return row.width; });
    var height = _.reduce(this.rows || [], function(memo, row) { return memo + row.height; }, 0);
    var width = (this.marginWidth * 2) + max.width + this.hgap * (max.cells.length - 1);
    height = height + ((this.rows.length - 1) * this.vgap) + (this.marginHeight * 2);

    var bounds = this._shape.figure.bbox();
    width = Math.max(bounds.width, width);
    height = Math.max(bounds.height, height);

    return { height: height, width: width };
};

var size = function(shape) {
    if (shape.layout) {
        return shape.layout.bounds || shape.figure.bbox();
    } else {
        return shape.figure.bbox();
    }
};

var createBasicRows = function(elements, columns) {
    var i       = 0,
        j       = 1,
        l       = elements.length,
        rows    = [],
        current = { width: 0, height: 0, cells: [] },
        previous,
        next,
        cell,
        currentShape;

    if (l) rows.push(current);

    for (; i < l; i++, j++) {
        currentShape = elements[i];
        cell = new GridCell({ shape: currentShape });
        cell.size = size(currentShape);
        if (previous) {
            cell.previous = previous;
            previous.next = cell;
        }
        previous = cell;
        current.cells.push(cell);
        if (j >= columns) {
            if (i != l - 1) {
                next = {
                    previous: current,
                    width: 0,
                    height: 0,
                    cells: []
                };
                current.next = next;
                current = next;
                rows.push(current);
            }
            j = 0;
        }
    }

    return rows;
};

var createColumns = function(rows, num) {
    var cols    = [],
        i       = 0,
        l       = rows.length,
        j, c;

    for (; i < num; i++) {
        cols.push([]);
        for (j = 0; j < l; j++) {
            c = rows[j].cells[i];
            if (c) {
                cols[i].push(c);
            }
        }
    }
    return cols;
};

GridLayout.prototype.createRows = function() {
    var elements        = this._shape.children,
        rows            = createBasicRows(elements, this.columns());

    _.each(createColumns(rows, this.columns()), function(column) {
        _.each(column, function(cell) {
            cell.height = cell.size.height;
        });
    });

    var updateRow = function(row) {
        var updateCell = function(cell) {
            cell.width = cell.size.width;
            row.width += cell.width;
        };

        _.each(row.cells, updateCell, this);

        var max = null;
        if (row.cells.length) {
            max = _.max(row.cells, function(cell) { return cell.height; });
        }

        row.height = max ? max.height : 0;
    };

    _.each(rows, updateRow, this);

    return rows;
};

GridLayout.prototype.layout = function() {
    var figure          = this._shape.figure,
        bounds          = size(this._shape),
        baseX           = figure.x() + this.marginWidth,
        x               = baseX,
        y               = figure.y() + this.marginHeight,
        hgap            = this.hgap,
        vgap            = this.vgap,
        marginWidth     = this.marginWidth,
        marginHeight    = this.marginHeight;

    var remainingHeightSpace = function(column) {
        var noGrabHeight = _.reduce(column, function(memo, cell) {
            if (cell.shape.gridData && cell.shape.gridData.grabExcessVerticalSpace)
                return memo;
            else return memo + cell.size.height;
        }, 0);
        var nbGrabCells = _.reduce(column, function(memo, cell) {
            if (cell.shape.gridData && cell.shape.gridData.grabExcessVerticalSpace)
                return memo + 1;
            else return memo;
        }, 0);
        var gaps = vgap * (column.length - 1);
        var bound = bounds.height - (marginHeight * 2) - gaps;
        var remaining = (bound - noGrabHeight) / nbGrabCells;
        return remaining;
    };
    var remainingWidthSpace = function(row) {
        var noGrabCellWidth = _.reduce(row.cells, function(memo, cell) {
            if (cell.shape.gridData && cell.shape.gridData.grabExcessHorizontalSpace)
                return memo;
            else return memo + cell.size.width;
        }, 0);
        var nbGrabCells = _.reduce(row.cells, function(memo, cell) {
            if (cell.shape.gridData && cell.shape.gridData.grabExcessHorizontalSpace)
                return memo + 1;
            else return memo;
        }, 0);

        var gaps = hgap * (row.cells.length - 1);
        var bound = bounds.width - (marginWidth * 2) - gaps;
        var remaining = (bound - noGrabCellWidth) / nbGrabCells;
        return remaining;
    };
    var updateRowPosition = function(row) {
        var remainingWidth = remainingWidthSpace(row);
        var updateCellPosition = function(cell) {
            cell.x = x;
            cell.y = y;

            if (cell.shape.gridData && cell.shape.gridData.grabExcessHorizontalSpace) {
                cell.width = remainingWidth;
            } else {
                cell.width  = cell.size.width;
            }
            x += cell.width + hgap;
        };

        _.each(row.cells, updateCellPosition);
        y += row.height + vgap;
        x = baseX;
    };
    var layoutCell  = function(cell) { cell.layout(); };
    var layoutRow   = function(row) {
        _.each(row.cells, layoutCell);
    };

    _.each(createColumns(this.rows || [], this.columns()), function(column) {
        var remainingHeight = remainingHeightSpace(column);
        _.each(column, function(cell) {
            if (cell.shape.gridData && cell.shape.gridData.grabExcessVerticalSpace) {
                cell.height = remainingHeight;
            } else {
                cell.height = cell.size.height;
            }
        });
    });

    _.each(this.rows || [], updateRowPosition);
    _.each(this.rows || [], layoutRow);

    _.each(this._shape.children || [], function(c) {
        if (c.layout) c.layout.layout();
    });
};

/**
 * @class
 * @name GridCell
 *
 */
var GridCell = DG.GridCell = function(data) {
    this.shape  = data.shape;
    this.width  = 0;
    this.height = 0;
};

GridCell.prototype.layout = function() {
    var data    = this.shape.gridData,
        bbox    = this.shape.figure.bbox();
        x       = this.x,
        y       = this.y,
        width   = bbox.width,
        height  = bbox.height;

    if (data) {
        /*
        if (data.verticalAlignment === 'center') {
            y += (this.height - height) / 2;
        }
        if (data.horizontalAlignment === 'center') {
            x += (this.width / 2) - (width / 2);
        }
        */
        this.shape.figure.move(x, y);
        if (data.horizontalAlignment === 'fill') {
            this.shape.figure.attr({ width: this.width, height: this.height });
        }
    } else {
        this.shape.figure.move(x, y);
    }
};

/**
 *  @class
 *  @name GridData
 *
 *  - verticalAlignment = 'center' | 'fill' | 'beginning' | 'end'
 *  - horizontalAlignment = 'beginning' |  'fill' | 'center' | 'end'
 *  - grabExcessVerticalSpace = false | true
 *  - grabExcessHorizontalSpace = false | true
 *  - verticalSpan = 1
 *  - horizontalSpan = 1
 */
var GridData = DG.GridData = function(attributes) {
    var attrs = attributes || {};

    this.verticalAlignment          = GridData.getVerticalAlignment(attrs);
    this.horizontalAlignment        = GridData.getHorizontalAlignment(attrs);
    this.grabExcessVerticalSpace    = attrs.grabExcessVerticalSpace || false;
    this.grabExcessHorizontalSpace  = attrs.grabExcessHorizontalSpace || false;
    this.verticalSpan               = attrs.verticalSpan || 1;
    this.horizontalSpan             = attrs.horizontalSpan || 1;
};

GridData.alignments = [ 'center', 'fill', 'beginning', 'end' ];

GridData.getAlignment = function(attributes, type) {
    var alignment = attributes[type + 'Alignment'];
    if (_.contains(GridData.alignments, alignment))
        return alignment;
    return null;
};

GridData.getVerticalAlignment = function(attributes) {
    return GridData.getAlignment(attributes, 'vertical') || 'center';
};

GridData.getHorizontalAlignment = function(attributes) {
    return GridData.getAlignment(attributes, 'horizontal') || 'beginning';
};



var Layout = DG.Layout = {};

Layout.create = function(figure, data) {
    var layout = data.layout;
    if (!figure || !layout || !layout.type) return null;

    switch(layout.type) {
        case 'grid':
            return new GridLayout(figure, layout);
        default:
            return null;
    }
};


/**
 * @name Figure
 */
var Figure = DG.Figure = {};

Figure.create = function(shape, data) {
    if (!shape) throw new Exception('Shape is missing');

    return shape.diagram().doc.figure(shape, data);
};

var createFigure = function(container, data) {
    var figure, type = data.type;
    if (type && typeof container[type] === 'function') {
        switch(type) {
            case 'rect':
                figure = container.rect(data.width, data.height);
                break;
            case 'circle':
                figure = container.circle(data.r);
                break;
            case 'ellipse':
                figure = container.ellipse(data.rx, data.ry);
                break;
            case 'polygon':
                figure = container.polygon(data.coordinates);
                break;
            case 'text':
                figure = container.text(data.text);
                break;
            case 'image':
                figure = container.image(data.path, data.width, data.height);
                break;
            default:
                figure = null;
        }
    }

    if (figure) figure.attr(data);

    return figure;
};

SVG.extend(SVG.Container, {
    figure: function(shape, attributes) {
        var attrs       = attributes || {};
        var shape_attrs = shape.attributes || {};
        var figure      = createFigure(this, attrs);

        figure.attributes       = _.clone(attrs);
        figure.shape            = shape;
        figure.connectAnchors   = [];

        // copy shape attributes
        if (shape_attrs.width)  figure.attributes.width  = shape_attrs.width;
        if (shape_attrs.height) figure.attributes.height = shape_attrs.height;
        if (shape_attrs.text)   figure.attributes.text   = shape_attrs.text;

        figure.attr(figure.attributes);

        // move to desired location
        if (shape_attrs.x && shape_attrs.y) figure.move(shape_attrs.x, shape_attrs.y);

        // store original sizes as minimuns
        var box = figure.bbox();
        figure.attributes.min = {};
        figure.attributes.min.width  = box.width;
        figure.attributes.min.height = box.height;

        return figure;
    }
});

SVG.extend(SVG.Shape, {

    remove: function() {
        this.hideDeleteAction();
        this.deselect();

        return SVG.Element.prototype.remove.apply(this, arguments);
    },

    minimumSize: function() {
        return this.attributes.min;
    },

    showConnectAnchors: function() {
        var shape = this.shape;
        if (this.hasConnectAnchors) return this;
        if (!this.connectAnchors.length) {
            this.connectAnchors = _.map(shape.anchors, ConnectionAnchor.create(shape), this);
        } else {
            _.each(this.connectAnchors, function(a) { a.render(); });
        }
        this.hasConnectAnchors = true;
        return this;
    },

    hideConnectAnchors: function() {
        if (!this.hasConnectAnchors) return this;
        _.each(this.connectAnchors, function(a) { a.remove(); });
        this.connectAnchors.length = 0;
        this.hasConnectAnchors = false;
        return this;
    },

    select: function() {
        if (this.isSelected) return this;
        var shape = this.shape;
        this.previous = {};
        this.previous.stroke = this.attr('stroke');
        this.previous['stroke-width'] = this.attr('stroke-width');
        this.attr({
            stroke: '#6599FF',
            'stroke-width': 2
        });
        this.selectAnchors = _.map(Anchor.positions, Anchor.create(shape), this);
        this.showDeleteAction(this.shape);
        this.isSelected = true;
        return this;
    },

    deselect: function() {
        if (!this.isSelected) return this;
        this.attr({
            stroke: this.previous.stroke,
            'stroke-width': this.previous['stroke-width']
        });
        _.each(this.selectAnchors, function(a) { a.remove(); });
        this.hideConnectAnchors();
        this.hideDeleteAction();
        this.isSelected = false;
        return this;
    },

    showDeleteAction: function() {
        var bbox = this.bbox();
        var shape = this.shape;
        var doc  = shape.diagram().doc;
        this.deleteAnchor = doc.circle(12).attr({
            fill: 'red',
            stroke: '#6599FF'
        });
        this.deleteAnchor.move(bbox.x + bbox.width - 22, bbox.y - 6);
        this.deleteAnchor.click(function() {
            shape.remove();
        });
        return this;
    },

    hideDeleteAction: function() {
        if (this.deleteAnchor) {
            this.deleteAnchor.remove();
            delete this.deleteAnchor;
        }
        return this;
    }

});


/**
 * @name Connection
 * @class
 *
 */
var Connection = DG.Connection = function(source, target, options) {
    this._source    = source;
    this._target    = target;
    this._diagram   = source.diagram();
    this._doc       = this._diagram.doc;
    this._points    = [];

    this._source.outEdges.push(this);
    this.initialize.apply(this, [options]);
};

Connection.extend = extend;

_.extend(Connection.prototype, DG.Events, {

    attr: {
        stroke: 'black',
        'stroke-width': 1
    },
    end: {
        fill: 'black',
        type: 'basic'
    },
    start: null,

    labels: [],

    initialize: function() {},

    connect: function(source, target) {
        this._source                = source;
        this._target                = target;
        this._connectSource.figure  = source;
        this._connectTarget.figure  = target;

        source.outEdges.push(this);
        target.inEdges.push(this);

        return this;
    },

    render: function() {
        this.removeWrapper();

        var boxes       = this.boxes(),
            points      = connectionPoints(this._doc, boxes, this._points),
            src, tgt, path;

        if (points.length === 2) {
            src = points[0];
            tgt = points[1];

            if (src !== null && tgt !== null) {
                path = createPath(src, tgt, this._points);

                this.wrapper = this._doc.path(path, true);
                this.wrapper.attr(this.attr);
                this.wrapper.attr({
                    cursor: 'pointer',
                    fill: 'none'
                });

                this.renderEnd(boxes[0], boxes[1], points);

                this.wrapper.dblclick(FlexPoint.create(this));
            }
        }
        return this;
    },

    renderEnd: function(sbox, tbox, points) {
        var doc     = this._doc;
        var spoint  = points[0];
        var tpoint  = points[1];
        var th      = Point.theta({ x: sbox.cx, y: sbox.cy }, { x: tbox.cx, y: tbox.cy });
        var c1r     = 360 - th.degrees + 180;
        var c2r     = 360 - th.degrees;

        var arrow;
        if (this.start) {
            arrow = Arrows.get(this.start.type);
            this._startArrow = renderConnectionEnd(doc, spoint, arrow(), th.radians, c1r).attr(this.start);
        }
        if (this.end) {
            arrow = Arrows.get(this.end.type);
            this._endArrow = renderConnectionEnd(doc, tpoint, arrow(), th.radians, c2r).attr(this.end);
        }

        return this;
    },

    addPoint: function(point) {
        this._points.push(point);
        this._points = _.sortBy(this._points, function(p) { return p.x; });
        this.render();
        return this;
    },

    removePoint: function(point) {
        this._points = _.without(this._points, point);
        this.render();
        return this;
    },

    removeWrapper: function() {
        if (this._startArrow)   this._startArrow.remove();
        if (this._endArrow)     this._endArrow.remove();
        _.each(this._points, function(p) { p.removeWrapper(); });

        if (this.wrapper) {
            this.wrapper.off();
            this.wrapper.remove();
        }
    },

    remove: function() {
        this.removeWrapper();
        this._source.outEdges = _.without(this._source.outEdges, this._source);
        this._target.inEdges  = _.without(this._target.inEdges, this._target);
        this._diagram.remove(this);
    },

    boxes: function() {
        return [
            this._source.figure.bbox(),
            this._target instanceof Shape ? this._target.figure.bbox() : this._target.wrapper.bbox()
        ];
    }

});

var createPath = function(source, target, points) {
    var start = 'M' + source.x + ' ' + source.y + 'L';
    var end   = target.x + ' ' + target.y;
    return _.reduce(points, function(memo, p) { return memo + p.x + ' ' + p.y + 'L'; }, start) + end;
};

var connectionPoints = function(doc, boxes, vertices) {
    var sbox            = boxes[0],
        tbox            = boxes[1],
        centerSource = { x: sbox.cx, y: sbox.cy },
        centerTarget = { x: tbox.cx, y: tbox.cy },
        centerPath, sourcePoint, targetPoint;

    if (vertices.length) {
        centerPath = path(doc, centerSource, vertices[0]);
        sourcePoint = findIntersection(doc, centerPath, sbox);
        centerPath.path.remove();
        centerPath = path(doc, vertices[vertices.length-1], centerTarget);
        targetPoint = findIntersection(doc, centerPath, tbox);
        centerPath.path.remove();
    } else {
        centerPath   = path(doc, centerSource, centerTarget),
        sourcePoint  = findIntersection(doc, centerPath, sbox),
        targetPoint  = findIntersection(doc, centerPath, tbox);
        centerPath.path.remove();
    }

    return [ sourcePoint, targetPoint ];
};

/**
 * @name FlexPoint
 *
 */
var FlexPoint = function(connection, point) {
    this.x              = point.x;
    this.y              = point.y;
    this._connection    = connection;
    this._doc           = connection._doc;
};

FlexPoint.create = function(connection) {
    return function(e) {
        var flex = new FlexPoint(connection, Point.get(e));
        connection.addPoint(flex);
        return flex.render();
    };
};

FlexPoint.onstart = function() {
    return function() {};
};

FlexPoint.onmove = function(point) {
    return function() {
        point.x = this.cx();
        point.y = this.cy();
        point._connection.render();
    };
};

FlexPoint.onend = function(point) {
    return function() {
        point.x = this.cx();
        point.y = this.cy();
    };
};

FlexPoint.remove = function(point) {
    return function() {
        this.remove();
        this.off();
        delete point.wrapper;
        point._connection.removePoint(point);
    };
};

FlexPoint.prototype.render = function() {
    this.removeWrapper();
    this.wrapper = this._doc.rect(6, 6).attr({
        fill: 'black',
        cursor: 'pointer'
    }).center(this.x, this.y);

    this.wrapper.dragstart  = FlexPoint.onstart(this);
    this.wrapper.dragend    = FlexPoint.onend(this);
    this.wrapper.dragmove   = FlexPoint.onmove(this);
    this.wrapper.draggable();

    this.wrapper.dblclick(FlexPoint.remove(this));
    return this;
};

FlexPoint.prototype.removeWrapper = function() {
    if (this.wrapper) this.wrapper.remove();
};

/**
 * ConnectionEnd
 */

var renderConnectionEnd = function(doc, point, arrow, radians, angle) {
    var x = point.x + (-1.5 * (arrow.dx - 1) * Math.cos(radians));
    var y = point.y + (1.5 * (arrow.dy - 1) * Math.sin(radians));
    return doc.path(arrow.path.join(' '), true)
        .attr(arrow.attr)
        .transform({
            x: x,
            y: y,
            rotation: angle
        });
};

/**
 * @name Anchor
 * @class
 *
 */
var Anchor = DG.Anchor = function(shape, position) {
    this._shape     = shape;
    this._figure    = shape.figure;
    this._container = shape.diagram().doc;
    this._position  = position;
};

Anchor.positions = ['ne', 'se', 'sw', 'nw'];

Anchor.create = function(shape) {
    return function(position) {
        return new Anchor(shape, position).render();
    };
};

Anchor.figure = function(container, point, position) {
    return container.rect(6, 6).attr({
        x: point.x,
        y: point.y,
        fill: 'blue',
        'fill-opacity': 0.2,
        stroke: 'none',
        'stroke-width': 0,
        type: 'anchor',
        cursor: position + '-resize'
    }).draggable();
};

Anchor.onstart = function(shape, figure, anchor) {
    return function() {
        _.each(figure.selectAnchors, function(a) {
            if (a !== anchor) a.remove();
        });
        figure.fixed();
        figure.hideConnectAnchors();
        figure.hideDeleteAction();
        shape.hideChildren();
    };
};

Anchor.onmove = function(shape, figure, place) {
    return function(delta) {
        var bbox = figure.bbox(),
            x, y, width, height;

        if (figure.od) {
            x = delta.x - figure.od.x;
            y = delta.y - figure.od.y;
            figure.od = delta;
        } else {
            x = delta.x;
            y = delta.y;
            figure.od = delta;
        }

        if (place === 'se') {
            width = bbox.width + x;
            height = bbox.height + y;
        }
        else if (place === 'ne') {
            width = bbox.width + x;
            height = bbox.height - y;
            figure.attr({ y: bbox.y + y });
        }
        else if (place === 'nw') {
            width = bbox.width - x;
            height = bbox.height - y;
            figure.attr({ x: bbox.x + x, y: bbox.y + y });
        }
        else {
            width = bbox.width - x;
            height = bbox.height + y;
            figure.attr({ x: bbox.x + x });
        }

        width = width > 0 ? width : 1;
        height = height > 0 ? height : 1;

        figure.size(width, height);
        shape.refreshEdges();
    };
};

Anchor.onend = function(shape, figure) {
    return function() {
        figure.deselect();
        figure.draggable();
        shape.showChildren();
        delete figure.od;
    };
};

Anchor.prototype.render = function() {
    var position    = this.position(),
        place       = this._position,
        shape       = this._shape,
        figure      = this._figure,
        container   = this._container;

    this.wrapper            = Anchor.figure(container, position, place);
    this.wrapper.dragstart  = Anchor.onstart(shape, figure, this);
    this.wrapper.dragmove   = Anchor.onmove(shape, figure, place);
    this.wrapper.dragend    = Anchor.onend(shape, figure);

    return this;
};

Anchor.prototype.remove = function() {
    if (this.wrapper) {
        this.wrapper.remove();
        delete this.wrapper;
    }
};

Anchor.prototype.position = function() {
    var bbox = this._figure.bbox();
    var position = {};

    if (this._position === 'nw') {
        position.x = bbox.x - 3;
        position. y = bbox.y - 3;
    }
    else if (this._position === 'ne') {
        position.x = (bbox.x + bbox.width) - 3;
        position. y = bbox.y - 3;
    }
    else if (this._position === 'se') {
        position.x = (bbox.x + bbox.width) - 3;
        position. y = (bbox.y + bbox.height) - 3;
    }
    else {
        position.x = bbox.x - 3;
        position.y = (bbox.y + bbox.height) - 3;
    }
    return position;
};


/**
 * @name ConnectionAnchor
 * @class
 *
 */
var ConnectionAnchor = DG.ConnectionAnchor = function(shape, position, connectionType) {
    this._shape             = shape;
    this._figure            = shape.figure;
    this._container         = shape.diagram().doc;
    this._position          = position; // ['n', 'w', 's', 'e']
    this._connectionType    = connectionType || DG.Connection;
};

// ConnectionAnchor.positions = ['n', 'w', 's', 'e'];

ConnectionAnchor.create = function(shape) {
    return function(def) {
        return new ConnectionAnchor(shape, def.position, def.connectionType).render();
    };
};

ConnectionAnchor.figure = function(container, point) {
    return container.circle(8).attr({
        cx: point.x,
        cy: point.y,
        fill: 'white',
        'fill-opacity': 1,
        stroke: 'blue',
        'stroke-opacity': 0.4,
        type: 'anchor',
        cursor: 'pointer'
    }).draggable();
};

ConnectionAnchor.onstart = function(anchor, shape, figure) {
    return function() {
        if (!anchor.connection) {
            figure.fixed();
            var clone = anchor.clone().render();
            figure.connectAnchors = _.without(figure.connectAnchors, anchor);
            figure.connectAnchors.push(clone);
            var connection = new anchor._connectionType(shape, anchor);
            anchor.connection = connection;
        }
    };
};

ConnectionAnchor.onmove = function(shape) {
    return function() {
        shape.refreshEdges();
    };
};

ConnectionAnchor.onend = function(anchor, shape, figure) {
    return function() {
        var found   = shape.diagram().findShape(function(node) {
            return node !== shape && anchor.isInside(node);
        });
        figure.draggable();
        if (found) {
            anchor.connection._target = found;
            found.inEdges.push(anchor.connection);
            anchor.connection.render();
            anchor.remove();
        }
    };
};

ConnectionAnchor.prototype.isInside = function(shape) {
    var abox = this.wrapper.bbox();
    var box = shape.figure.bbox();

    return abox.x > box.x &&
        (abox.x + abox.width) < (box.x + box.width) &&
        abox.y > box.y &&
        (abox.y + abox.height) < (box.x + box.height);
};

ConnectionAnchor.prototype.bbox = function() {
    return this.wrapper ? this.wrapper.bbox() : null;
};

ConnectionAnchor.prototype.render = function() {
    var position    = this.position();
    var figure      = this._figure;
    var container   = this._container;
    var shape       = this._shape;
    this.wrapper    = ConnectionAnchor.figure(container, position);

    this.wrapper.dragstart  = ConnectionAnchor.onstart(this, shape, figure);
    this.wrapper.dragmove   = ConnectionAnchor.onmove(shape);
    this.wrapper.dragend    = ConnectionAnchor.onend(this, shape, figure);

    return this;
};

ConnectionAnchor.prototype.remove = function() {
    if (this.wrapper) {
        this.wrapper.remove();
        delete this.wrapper;
    }
};

ConnectionAnchor.prototype.position = function() {
    var bbox = this._figure.bbox();
    var position = {};

    if (this._position === 'e') {
        position.x = bbox.x + bbox.width;
        position.y = bbox.y + (bbox.height / 2);
    }
    else if (this._position === 'w') {
        position.x = bbox.x;
        position.y = bbox.y + (bbox.height / 2);
    }
    else if (this._position === 'n') {
        position.x = bbox.x + (bbox.width / 2);
        position.y = bbox.y;
    }
    else {
        position.x = bbox.x + (bbox.width / 2);
        position.y = bbox.y + bbox.height;
    }
    return position;
};

ConnectionAnchor.prototype.clone = function() {
    return new ConnectionAnchor(this._shape, this._position, this._connectionType);
};


/**
 * @name Shape
 * @class
 *
 */
var Shape = DG.Shape = function(attributes) {
    var attrs = attributes || {};

    this.attributes         = attrs;
    this.inEdges            = [];
    this.outEdges           = [];
    this.children           = [];
    this.parent             = null;
    this.isRoot             = false;
    this.isSelected         = false;
    this.hasConnectAnchors  = false;

    this.initialize.apply(this, arguments);
};

//
// drag functions
//


Shape.dragstart = function(shape) {
    return function() {
        shape.hideChildren();
        shape.deselect();
    };
};

Shape.dragmove = function(shape) {
    return function() {
        shape.refreshEdges();
    };
};

Shape.dragend = function(shape) {
    return function() {
        shape.showChildren();
    };
};


//
// Shape prototype
//


_.extend(Shape.prototype, Events, {

    config: {
        resizable: true,
        selectable: true,
        draggable: true
    },

    anchors: [
        { position: 'n' },
        { position: 's' },
        { position: 'w' },
        { position: 'e' }
    ],

    render: function() {
        if (this.figure || (this.figure = this.createFigure())) {
            this.renderChildren();

            if (this.config.draggable) {
                this.figure.dragstart   = Shape.dragstart(this);
                this.figure.dragmove    = Shape.dragmove(this);
                this.figure.dragend     = Shape.dragend(this);
                this.figure.draggable();
            }

            var me = this;
            if (this.config.selectable) {
                this.figure.on('click', function() { me.select(); });
            }
            this.figure.on('click', function(e) { me.trigger('click', e); });
        }
        return this;
    },

    renderChildren: function() {
        _.each(this.children, render);
        this.doLayout();
    },

    showChildren: function() {
        _.each(this.children, function(c) {
            c.figure.show();
            if (c.children) c.showChildren();
        });
        if (this.isRoot && this.layout) {
            this.doLayout();
        }
    },

    hideChildren: function() {
        _.each(this.children, function(c) {
            c.figure.hide();
            if (c.children) c.hideChildren();
        });
    },

    doLayout: function() {
        if (this.layout) {
            this.figure.attr(this.layout.size());
            this.layout.layout();
        }
    },

    diagram: function() {
        var parent = this;
        while(parent.parent) parent = parent.parent;
        return parent;
    },

    add: function(shape) {
        shape.parent = this;
        this.children.push(shape);
    },

    remove: function() {
        if (this.figure) {
            this.figure.off();
            this.figure.remove();
            _.each(this.children, function(c) {
                c.remove();
            });
            _.each(this.inEdges, function(e) {
                e.remove();
            });
            _.each(this.outEdges, function(e) {
                e.remove();
            });
            this.diagram().remove(this);
        }
        return this;
    },

    select: function() {
        this.isSelected = true;
        this.figure.select();
        this.figure.showConnectAnchors();
        this.trigger('select');
    },

    deselect: function() {
        this.isSelected = false;
        this.figure.deselect();
        this.figure.hideConnectAnchors();
        this.trigger('select');
    },

    move: function(x, y) {
        if (this.figure) this.figure.move(x, y);
        this.doLayout();
        return this;
    },

    refreshEdges: function() {
        _.each(this.inEdges, render);
        _.each(this.outEdges, render);
    },

    isInside: function(box) {
        var bbox = this.figure.bbox();
        return bbox.x >= box.x &&
            (bbox.x + bbox.width) <= (box.x + box.width) &&
            bbox.y >= box.y &&
            (bbox.y + bbox.height) <= (box.y + box.height);
    },

    initialize: function() {},
    createFigure: function() {}

});

function render(e) {
    return typeof e.render === 'function' ? e.render() : e;
}

Shape.extend = extend;


/**
 * @name Label
 * @class
 *
 */
var Label = DG.Label = function(attributes) {
    var attrs = attributes || {};
    this.attributes = attrs;
    this.initialize.apply(this, arguments);
};

Label.extend = extend;

_.extend(Label.prototype, Events, {

    config: {
        draggable: false,
        selectable: false,
        resizable: false,
        editable: true
    },

    render: function() {
        if (this.figure || (this.figure = this.createFigure())) {
            if (this.config.draggable) {
                this.figure.draggable();
            }
            if (this.config.editable) {
                this.figure.on('dblclick', this.callEdit());
            }
        }
        return this;
    },

    remove: function() {
        if (this.figure) {
            this.figure.off();
            this.figure.remove();
        }
    },

    doLayout: function() {},

    diagram: function() {
        var parent = this;
        while(parent.parent) parent = parent.parent;
        return parent;
    },

    callEdit: function() {
        var label = this;
        return function() {
            createEditForm(label.figure);
        };
    },

    text: function(text) {
        if (text) {
            this.attributes.text = text;
            if (this.figure) {
                this.figure.attr('text', text);
            }
            this.trigger('change:text', text);
        }
        return this.attributes.text;
    },

    move: function(x, y) {
       if (this.figure) this.figure.move(x, y);
       return this;
    },

    initialize: function() {},

    createFigure: function() {
        return DG.Figure.create(this, this.figure);
    },

    select: function() {},

    deselect: function() {},

    isInside: function(box) {
        var bbox = this.figure.bbox();
        return bbox.x >= box.x &&
            (bbox.x + bbox.width) <= (box.x + box.width) &&
            bbox.y >= box.y &&
            (bbox.y + bbox.height) <= (box.y + box.height);
    }

});

var createEditForm = function(figure) {
    var node = figure.node;
    var bounds = figure.bbox();

    var container = node.parentNode.parentNode;
    var x = bounds.x; //container.offsetLeft;
    var y = bounds.y; //container.offsetTop;

    var textInput = document.createElement('input');
    textInput.setAttribute('type', 'text');
    textInput.setAttribute('style',
            'position: absolute; top: '+y+'px; left: '+x+'px; width: '+
            bounds.width+'px; height: '+bounds.height+'px;');
    textInput.value = figure.attr('text');
    container.appendChild(textInput);

    var handleTextInput = function(e) {
        e.stopImmediatePropagation();
        figure.attr('text', textInput.value);
        textInput.removeEventListener('blur', handleTextInput, true);
        container.removeChild(textInput);
    };

    textInput.focus();
    textInput.addEventListener('blur', handleTextInput, true);
};


})();
