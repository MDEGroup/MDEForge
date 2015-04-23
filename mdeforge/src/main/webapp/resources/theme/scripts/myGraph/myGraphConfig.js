var redraw;

window.onload = function() {
	
	var width = 900;
    var height = 400;
    /*
	var width = $(document).width();
    var height = $(document).height() - 100;
*/
    /* Showcase of the Bellman-Ford search algorithm finding shortest paths 
       from one point to every node */
    
    /*  */

    /* We need to write a new node renderer function to display the computed
       distance.
       (the Raphael graph drawing implementation of Dracula can draw this shape,
       please consult the RaphaelJS reference for details http://raphaeljs.com/) */
    var render = function(r, n) {
            /* the Raphael set is obligatory, containing all you want to display */
            var set = r.set().push(
                /* custom objects go here */
                r.rect(n.point[0]-30, n.point[1]-13, 60, 44).attr({"fill": "#feb", r : "12px", "stroke-width" : n.distance == 0 ? "3px" : "1px" })).push(
                r.text(n.point[0], n.point[1] + 10, (n.label || n.id)));
            return set;
        };
    
    var g = new Graph();
    
    /* modify the edge creation to attach random weights */
   /* g.edgeFactory.build = function(source, target) {
	var e = jQuery.extend(true, {}, this.template);
	e.source = source;
	e.target = target;
	e.style.label = e.weight = Math.floor(Math.random() * 10) + 1;
	return e;
    }*/
    
    
    /*function getMyData2(){
		var xxx = [];
		
		$.ajax({
			contentType : "application/json",
			dataType: 'json',
			 type: "POST",
		    traditional: true,
		    url: '/transform/demo/getGraph.htm',
		    async: false,					    
		    success: function (data) {			    			  	
		   
		    	for (var i = 0; i < data.length; ++i)
		    		alert(data[i]);
					xxx.push([i, data[i]]);
								       
		    },
		    error: function () {
		        var cdefg = data;
		    }
		});
					
		
		
		return xxx;
	}
    */
 
    
    
    
    /* creating nodes and passing the new renderer function to overwrite the default one */
    g.addNode("Grafcet", {render:render}); // TODO add currying support for nicer code
//    g.addNode("MM3", {render:render});
    g.addNode("PetriNet1.0", {render:render});
//    g.addNode("MM1", {render:render});
//    g.addNode("MM2", {render:render});
//    g.addNode("MM4", {render:render});
    g.addNode("PetriNet2.0", {render:render});
    g.addNode("XML", {render:render});
//    g.addNode("MM5", {render:render});
    g.addNode("PNML", {render:render});
   

    /* connections */
//    g.addEdge("Grafcet", "MM3", {directed: true, label: "Grafcet_to_MM3",  "label-style" : { "font-size": 8}, stroke:"#aaa"}); // also supports directed graphs, but currently doesn't look that nice
    g.addEdge("Grafcet", "PetriNet1.0", {directed: true, label: "Grafcet_to_PetriNet1.0",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
//    g.addEdge("PetriNet1.0", "MM1", {directed: true, label: "PetriNet1.0_to_MM1",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
//    g.addEdge("MM1", "PetriNet1.0", {directed: true, label: "MM1_to_PetriNet1.0",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
//    g.addEdge("MM1", "MM2", {directed: true, label: "MM1_to_MM2",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
//    g.addEdge("MM4", "MM2", {directed: true, label: "MM4_to_MM2",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
    g.addEdge("PetriNet1.0", "PetriNet2.0", {directed: true, label: "Adapter(PetriNet1.0, PetriNet2.0)",  "label-style" : { "font-size": 8}, stroke:"red"});
    g.addEdge("PetriNet1.0", "XML", {directed: true, label: "PetriNet1.0_to_XML",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
    g.addEdge("PNML", "XML", {directed: true, label: "PNML_to_XML",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
//    g.addEdge("PNML", "MM5",{directed: true, label: "PNML_to_MM5",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
//    g.addEdge("PetriNet2.0", "MM5", {directed: true, label: "PetriNet2.0_to_MM5",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
    g.addEdge("PetriNet2.0", "PNML",{directed: true, label: "PetriNet2.0_to_PNML",  "label-style" : { "font-size": 8}, stroke:"#aaa"});
    
    

    /* random edge weights (our undirected graph is modelled as a bidirectional graph) */
    /*    for(e in g.edges)
        if(g.edges[e].backedge != undefined) {
            g.edges[e].weight = Math.floor(Math.random()*10) + 1;
            g.edges[e].backedge.weight = g.edges[e].weight;
        }
     */
    /* layout the graph using the Spring layout implementation */
    var layouter = new Graph.Layout.Spring(g);
    
    /* draw the graph using the RaphaelJS draw implementation */

    /* calculating the shortest paths via Bellman Ford */
//    bellman_ford(g, g.nodes["Berlin"]);
    
    /* calculating the shortest paths via Dijkstra */
   /* dijkstra(g, g.nodes["Grafcet"]);*/
    
    /* calculating the shortest paths via Floyd-Warshall */
    /*floyd_warshall(g, g.nodes["PNML"]);*/


    /* colourising the shortest paths and setting labels */
    /*for(e in g.edges) {
        if(g.edges[e].target.predecessor === g.edges[e].source || g.edges[e].source.predecessor === g.edges[e].target) {
            g.edges[e].style.stroke = "#bfa";
            g.edges[e].style.fill = "#56f";
        } else {
            g.edges[e].style.stroke = "#aaa";
        }
    }*/
    
    var renderer = new Graph.Renderer.Raphael('canvas', g, width, height);

    redraw = function() {
        layouter.layout();
        renderer.draw();
    };
    
/*    var pos=0;
    step = function(dir) {
        pos+=dir;
        var renderer = new Graph.Renderer.Raphael('canvas', g.snapshots[pos], width, height);
        renderer.draw();
    };*/
};