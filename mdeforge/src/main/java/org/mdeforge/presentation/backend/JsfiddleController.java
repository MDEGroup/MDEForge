package org.mdeforge.presentation.backend;


import org.mdeforge.business.JsfiddleService;
import org.mdeforge.business.model.ArtifactList;
import org.mdeforge.business.model.ContentView;
import org.mdeforge.business.model.EditorJ;
import org.mdeforge.business.model.Jsfiddle;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/private/jsfiddle")
public class JsfiddleController {

	@Autowired
	private JsfiddleService jsfiddleService;
		
	@Autowired
	private User user;
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Jsfiddle createJsfiddle(@RequestBody Jsfiddle jsfiddle,
    						ModelMap model){
    	

    	for(ContentView contentView: jsfiddle.getContentViewList()){
    		switch (contentView.getType()) {
			case "editor":
				contentView.setContentType(new EditorJ());
				break;
			case "artifactList":
				contentView.setContentType(new ArtifactList());
				break;
			case "serviceList":
				break;
			case "table":
				break;
			case "emptyDiv":
				break;
			default:
				break;
			}
    	}
    	
    	
    	model.put("page", "JsfiddlePage");
    	
    	return jsfiddle;
    }
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Jsfiddle getJsfiddle(@PathVariable("id") String id) {
		
		Jsfiddle jsfiddle = jsfiddleService.findById(id, user);	
		return jsfiddle;
	}
	
}

