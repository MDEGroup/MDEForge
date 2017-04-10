package org.mdeforge.presentation.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ReadmeFileService;
import org.mdeforge.business.SemanticSimilarityRelationService;
import org.mdeforge.business.SemanticSimilarityRelationServiceV1;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.Clusterizzation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.ReadmeFile;
import org.mdeforge.integration.ClusterizzationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public/ReadmeFile")
public class ReadmePublicController extends ArtifactPublicController<ReadmeFile> {

	@Autowired
	private ReadmeFileService readmeFileService;

//	@Autowired
//	private GridFileMediaService gridFileMediaService;
//	@Autowired 
//	private User user;

	
	
	public String details(Model model, @RequestParam String artifact_id) {

		super.details(model, artifact_id);
		return "public.browse.readme_details";
	}

	
	public String artifactFromName(@RequestParam String name,Model model) throws IOException{
		ReadmeFile ecoreMetamodel = readmeFileService.findOneByName(name);
		return "redirect:/public/ReadmeFile/artifact?artifact_id="+ ecoreMetamodel.getId();
	}
	@Override
	public String artifactList(Model model) {
		model.addAttribute("type", ReadmeFile.class.getSimpleName());
		return super.artifactList(model);
	}
}
