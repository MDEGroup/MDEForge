package org.mdeforge.presentation.frontend;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.SearchResultComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/public")
public class SearchPublicController {
	
//	private static final int MAX_SEARCH_RESULT = 50;
	
	@Autowired
	private User user;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public String search(Model model) {
		// Tags for MM (statics)
		// Get all Metamodels tags
		List<String> indexFieldNamesForMM = artifactService.indexFieldNamesForMM();
		model.addAttribute("indexFieldNamesForMM", indexFieldNamesForMM);

		// Tags for T. (statics)
		// Get all Transformations tags
		List<String> indexFieldNamesForT = artifactService.indexFieldNamesForT();
		model.addAttribute("indexFieldNamesForT", indexFieldNamesForT);

		// Tags for M. (dinamics)
		// Get all tags
		List<String> indexFieldNamesForM = artifactService.indexFieldNames();

		// Remove Metamodels and Transformations tags in order to find out only
		// the model tags.
		indexFieldNamesForM.removeAll(indexFieldNamesForMM);
		indexFieldNamesForM.removeAll(indexFieldNamesForT);

		model.addAttribute("indexFieldNamesForM", indexFieldNamesForM);

		return "public.search";
	}
	
	@RequestMapping(value="/searchArtifact", method = {RequestMethod.POST})
	 public @ResponseBody List<Artifact> searchArtifact(
			 @RequestParam(value = "search_string") String searchString, 
			 @RequestParam(value = "type") String type,
			 @RequestParam(value = "limit") int limit,
			 @RequestParam(value = "idProject", required = false) String idProject){
	  searchString += " AND forgeType:" + type;
	  List<Artifact> searchResultComplete = artifactService.search(searchString, limit);
	  
	  //filter based on project: remove all the artifact present in the user project
	  if(idProject != null){
		  List<Artifact> artifactsInProject = artifactService.findArtifactInProject(idProject, user);
		  searchResultComplete.removeAll(artifactsInProject);
	  }
	  
	  return searchResultComplete;
	 }
	
	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	public String search(Model model, 
			@RequestParam(value = "search_string", required = true) String searchString, 
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "hitPerPage", defaultValue = "10") int hitPerPage,
			@RequestParam(value = "isFuzzy", required = false) boolean isFuzzy) {
		
		if(isFuzzy){
			searchString += "~";
		}
		
//		SearchResultComplete searchResultComplete = artifactService.searchForm(searchString);
		SearchResultComplete searchResultComplete = artifactService.searchWithPagination(searchString, hitPerPage, page);
		model.addAttribute("searchResultComplete", searchResultComplete);
//		model.addAttribute("search_string", searchString);
		
		// Tags for MM (statics)
		// Get all Metamodels tags
		List<String> indexFieldNamesForMM = artifactService.indexFieldNamesForMM();
		for (String string : indexFieldNamesForMM) {
			System.out.println(string + "ggg");
		}
		model.addAttribute("indexFieldNamesForMM", indexFieldNamesForMM);

		// Tags for T. (statics)
		// Get all Transformations tags
		List<String> indexFieldNamesForT = artifactService.indexFieldNamesForT();
		model.addAttribute("indexFieldNamesForT", indexFieldNamesForT);

		// Tags for M. (dinamics)
		// Get all tags
		List<String> indexFieldNamesForM = artifactService.indexFieldNames();

		// Remove Metamodels and Transformations tags in order to find out only
		// the model tags.
		indexFieldNamesForM.removeAll(indexFieldNamesForMM);
		indexFieldNamesForM.removeAll(indexFieldNamesForT);

		model.addAttribute("indexFieldNamesForM", indexFieldNamesForM);
		return "public.search";
	}
	
	
	//@RequestMapping(value = "/search_metamodel_by_example/result", method = { RequestMethod.POST })
	public @ResponseBody List<EcoreMetamodel> searchEcoreMetamodelResultByExample(
			Model model,
			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
		EcoreMetamodel m = new EcoreMetamodel();
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setByteArray(bytes);
		gfm.setFileName("searchFragment.ecore");
		m.setFile(gfm);
		m.setName("searchFragment");        
		List<EcoreMetamodel> el = ecoreMetamodelService.searchByExample(m, 0.5);
		for (EcoreMetamodel ecoreMetamodel : el) {
			ecoreMetamodel.setFile(null);
		}
		return el;
	}
	
	
	@RequestMapping(value = "/search_metamodel_by_example/result", method = { RequestMethod.POST })
	public String searchEcoreMetamodelResultByExampleTop5(
			Model model,
			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
		EcoreMetamodel m = new EcoreMetamodel();
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setByteArray(bytes);
		gfm.setFileName("searchFragment.ecore");
		m.setFile(gfm);
		m.setName("searchFragment");        
		List<EcoreMetamodel> el = ecoreMetamodelService.searchByExample(m, 0.5);
		for (EcoreMetamodel ecoreMetamodel : el) {
			ecoreMetamodel.setFile(null);
		}
		model.addAttribute("artifactListByExample", el);
		return "public.search";

	}
	

}
