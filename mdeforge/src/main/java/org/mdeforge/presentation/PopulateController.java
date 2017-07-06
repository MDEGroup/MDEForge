package org.mdeforge.presentation;

import org.mdeforge.business.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PopulateController {
	
	@Autowired
	private LuceneService luceneService;
	
	@RequestMapping(value = "/lucene_index", method = { RequestMethod.GET })
	public String indexExternalPathResources() {
		
		luceneService.createLuceneIndexFromConfigurationPath();
		luceneService.getAllIndexTags();
		
		return "public.index";
	}

}
