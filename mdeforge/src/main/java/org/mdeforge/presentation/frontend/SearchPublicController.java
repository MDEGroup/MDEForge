package org.mdeforge.presentation.frontend;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/public")
public class SearchPublicController {
	
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Autowired
	private CosineSimilarityRelationService cosineSimilarityRelationService;
	@Autowired
	private DiceSimilarityRelationService diceSimilarityRelationService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private UserService userService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;


//	@RequestMapping(value = "/search/result", method = { RequestMethod.GET })
//	public String searchResult(Model model, @RequestParam(value = "search_string", required = true) String searchString) {
//		model.addAttribute("artifactList",artifactService.search(searchString));
//		return "public.search.result";
//	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public String search(Model model, @RequestParam(value = "search_string", required = false) String searchString, 
			@RequestParam(value = "artifactType", required = false) String artifactType) {
		
		System.out.println(artifactType);
		
		if(searchString != null && searchString != ""){
			model.addAttribute("artifactList", artifactService.search(searchString));
		}
			
		return "public.search";
	}
	
	
//	@RequestMapping(value = "/search_metamodel_by_example/result", method = { RequestMethod.POST })
//	public String searchEcoreMetamodelResultByExample(
//			Model model,
//			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
//		EcoreMetamodel m = new EcoreMetamodel();
//		byte[] bytes = file.getBytes();
//		GridFileMedia gfm = new GridFileMedia();
//		gfm.setByteArray(bytes);
//		gfm.setFileName("searchFragment.ecore");
//		m.setFile(gfm);
//		m.setName("searchFragment");        
//		model.addAttribute("artifactList",ecoreMetamodelService.searchByExample(m));
//		return "public.search.result";
//	}
	
	@RequestMapping(value = "/search_metamodel_by_example/result", method = { RequestMethod.POST })
	public String searchEcoreMetamodelResultByExample(
			Model model,
			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
		EcoreMetamodel m = new EcoreMetamodel();
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setByteArray(bytes);
		gfm.setFileName("searchFragment.ecore");
		m.setFile(gfm);
		m.setName("searchFragment");        
		model.addAttribute("artifactListByExample", ecoreMetamodelService.searchByExample(m));
		return "public.search";
	}
	

}
