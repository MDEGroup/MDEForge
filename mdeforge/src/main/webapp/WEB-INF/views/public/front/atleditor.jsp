    <style>
        #editor { 
                position: absolute;
                top: 50px;
                right: 10px;
                bottom: 10px;
                left: 10px;
            }
    </style>
	
	
	 <div id="editor">
    </div>
	
	<input type="file" id="files" name="files[]" multiple />
	
    <script src="${pageContext.request.contextPath}/resources/global-index.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/ace.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/theme-eclipse.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/ext-language_tools.js"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/ext-tooltip.js"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/ext-searchbox.js"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/snippets/myatl.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/mode-myatl.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ace/worker-myatl.js" type="text/javascript"></script>
    <script type="text/javascript">
	
		if (window.File && window.FileReader && window.FileList && window.Blob) {
			 function handleFileSelect(evt) {
				var files = evt.target.files; // FileList object
				for (var i = 0, f; f = files[i]; i++) {
				  var reader = new FileReader();
				  reader.onload = (function(theFile) {
				   return function(e) {
						editor.getSession().setValue(e.target.result);
					};
				  })(f);
				reader.readAsText(f);
				}
			}
			document.getElementById('files').addEventListener('change', handleFileSelect, false);
			
			
		}
		else {
			console.log("File loading not supported.");
		}
	
    	//the guid associated to this editor
    	var guid = Math.round(Math.random() * 1000);
  		var index = [];
		var wordSNext = [];
		var completeCompletions = null;
		var definedNextWord = false;
		var lista_keyword = [];
	    var editor = ace.edit("editor");
		var previous = "";
		
		editor.getSession().setUseWrapMode(true);
	    editor.getSession().setTabSize(4); 
	    editor.getSession().setUseSoftTabs(true);
		editor.getSession().getUndoManager().reset();
		
		editor.setShowPrintMargin(false);
		editor.setBehavioursEnabled(true);
		editor.setWrapBehavioursEnabled(true); 
		editor.setReadOnly(false);			
	    editor.setFontSize(14);   
	    editor.setTheme("ace/theme/eclipse");
	    editor.getSession().setMode("ace/mode/myatl");
        var langTools = ace.require("ace/ext/language_tools");
	    editor.setOptions({
		    enableBasicAutocompletion: true,
		    enableSnippets: true,
			enableLiveAutocompletion: true
		});
		
		editor.getSession().on("changeAnnotation", function () {
		
			var annot = editor.getSession().getAnnotations();
			wordSNext = [];
			
			for (var key in annot) {
				if (annot.hasOwnProperty(key)) {
					var str = annot[key].text;
					var row = annot[key].row;
					var column = annot[key].column;
					var strsplit = str.split("expecting");
					if(strsplit.length > 1) {
						var strsplit2 = strsplit[1].split("'");//change?
						var wordtoverify = {word:strsplit2[1], row:row, column: column};
						wordSNext.push(wordtoverify);
					}
					if(str.includes("Missing")) {
						var strsplit = str.split(" at ");
						if(strsplit.length > 1) {
							var strsplit2 = strsplit[0].split("'");//change?
							var wordtoverify = {word:strsplit2[1], row:row, column: column};
							wordSNext.push(wordtoverify);
						}
					}
				}
			}
		});
	    var globalScope = {
	    		getCompletions: function(editor, session, pos, prefix, callback) {
	    	 	   for (var i=0; i < index.length; i++) {
	    			   if (index[i].indexOf(guid)>-1) {
	    				  index.splice(i, 1);
	    				  i--;
	    			   }
	    		   }	    	
	    	    	// remove the reference prefixes
		            for (var i=0;i<index.length;i++) {
		            	index[i] = index[i].substring(index[i].indexOf("#")+1, index[i].length);
		            }
		            var wordList = index;

					if(definedNextWord == false) {
						callback(null, wordList.map(function(word) {
		                return {
		                    name: word,
		                    value: word,
		                    score: 1,
		                    meta: "[global]"
		                };
						}));
					}
	    	    }   
	        }
		var old = [];
		old[0] = editor.completers[0];
		old[1] = editor.completers[1];
		old[2] = editor.completers[2];
		editor.completers = [];
		var completers = editor.completers;
		var keyWordCompleter = {
			getCompletions: function(editor, session, pos, prefix, callback) {
				if (session.$mode.completer) {
					return session.$mode.completer.getCompletions(editor, session, pos, prefix, callback);
				}
				var state = editor.session.getState(pos.row);
				var completions = session.$mode.getCompletions(state, session, pos, prefix);
				//callback(null, completions);
				
				if(completeCompletions == null) {
					//duplicate the original tokens array
					completeCompletions = completions.slice();
				}
								
				completions = [];
				definedNextWord = false;
				var elementsAdded = 0;
				
				
				for(var i=0; i<completeCompletions.length; i++) {
		
					//needs to add the pointer position?
					if(wordSNext.length != 0) {//i have a suggested word, show ONLY it
						var toAdd = false;
						for(var j=0; j<wordSNext.length; j++) {
							if(completeCompletions[i]["name"] == wordSNext[j]["word"]) {
								toAdd = true;
								definedNextWord = true;
							}
						}
						
						if(toAdd == true) {
							elementsAdded += 1;
							completions.push(completeCompletions[i]);
						}

					}
					else {
						
					}
				}
				
				if(elementsAdded == 0) {
					if(wordSNext.length != 0) {//ADDS ; : , ...
						
						definedNextWord = true;
						
						for(var j=0; j<wordSNext.length; j++) {
							var toAdd = {name:wordSNext[j]["word"], value:wordSNext[j]["word"], score:1, meta:"keyword"};
							completions.push(toAdd);
						}
					}
					else {//add all words from completeCompletions
						//completions = completeCompletions.slice();
						
						if((previous.value == ";") || (previous.value == "}")) {
							var toAdd = {name:'rule', value:'rule', score:2, meta:"keyword"};
							completions.push(toAdd);
							var toAdd = {name:'lazy', value:'lazy', score:2, meta:"keyword"};
							completions.push(toAdd);
							var toAdd = {name:'endpoint', value:'endpoint', score:2, meta:"keyword"};
							completions.push(toAdd);
							var toAdd = {name:'entrypoint', value:'entrypoint', score:2, meta:"keyword"};
							completions.push(toAdd);
							var toAdd = {name:'helper', value:'helper', score:2, meta:"keyword"};
							completions.push(toAdd);
							var toAdd = {name:'query', value:'query', score:2, meta:"keyword"};
							completions.push(toAdd);
							var toAdd = {name:'uses', value:'uses', score:2, meta:"keyword"};
							completions.push(toAdd);
						}
					}
				
				
				}
				
				callback(null, completions);
				
			}
		};
		
		completers[0] = globalScope;
		completers[1] = keyWordCompleter;
		
		langTools.addCompleter(globalScope);
		langTools.addCompleter(keyWordCompleter);
		
		//add documentation hover
		var TokenTooltip = ace.require("ace/ext/tooltip").TokenTooltip;	
		editor.tokenTooltip = new TokenTooltip(editor);		 	

	    //create the shared worker
	 	var worker = new SharedWorker("${pageContext.request.contextPath}/resources/global-index.js");
	 	//"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --allow-file-access-from-files
	 	worker.port.onmessage = function(e) {
	 		console.log(
	 			"call number: " + e.data.counter + "\n"+
	 			"message: " + e.data.message + "\n" +
	 			"editor Id: " + e.data.guid + "\n" +
	 			"index: " + e.data.index
	 		);
	 		//update the index reference
	 		index = e.data.index;
        };   

	 	//on focus get
		editor.on("focus", function() {
	 	});
		
		//on focus lost
	 	editor.on("blur", function() {
	 	});
	 	
	 	//on input
	 	editor.on("input", function() {
			
			
	 	});
	 	
	 	//on change
		editor.on("change", function(event) {	
			var splitRegex = /[^a-zA-Z_0-9\$\-]+/;
			index = editor.getValue().split(splitRegex);
	        worker.port.postMessage({
	           	message: editor.getValue(), 
	           	guid: guid, 
	           	index: index
	        });
	        
	        index = [];
			
			
			var position = editor.getCursorPosition();
			var token = editor.session.getTokenAt(position.row, position.column);
			
			var TokenIterator = require("ace/token_iterator").TokenIterator;
			var stream = new TokenIterator(editor.getSession(), position.row, position.column);
			previous=stream.stepBackward();//previous token		
			
			//ANNOTATION EXPECTED WORD
			var annot = editor.getSession().getAnnotations();
			wordSNext = [];
			
			for (var key in annot) {
				if (annot.hasOwnProperty(key)) {
					var str = annot[key].text;
					var row = annot[key].row;
					var column = annot[key].column;
					var strsplit = str.split("expecting");
					if(strsplit.length > 1) {
						var strsplit2 = strsplit[1].split("'");
						var wordtoverify = {word:strsplit2[1], row:row, column: column};
						wordSNext.push(wordtoverify);
					}
					if(str.includes("Missing")) {
						var strsplit = str.split(" at ");
						if(strsplit.length > 1) {
							var strsplit2 = strsplit[0].split("'");//change?
							var wordtoverify = {word:strsplit2[1], row:row, column: column};
							wordSNext.push(wordtoverify);
						}
					}
				}
			}
			
			
			
			

			
        });											
	 	worker.port.onmessage = function(e) {
	 		//update the index reference
	 		index = e.data.index;
        };
        
		//Bind keyboard shorcuts
		editor.commands.addCommand({
			name: 'saveFile',
			bindKey: {
			win: 'Ctrl-S',
			mac: 'Command-S',
			sender: 'editor|cli'
			},
			exec: function(env, args, request) {
				//TODO
			}
		});
		
		editor.getSession().setValue("");
		
		try {
			var banner = document.getElementById("github-banner");
			banner.style.visibility = "hidden";
			banner.style.display = "none";
		}
		catch(e) {
		}
    </script>
	
	
	