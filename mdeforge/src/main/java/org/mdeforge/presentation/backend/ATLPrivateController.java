package org.mdeforge.presentation.backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.mdeforge.business.ATLTransformationCompilationError;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ATLTransformationError;
import org.mdeforge.business.model.ATLTransformationTestServiceError;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.ATLTransformationForm;
import org.mdeforge.business.model.wrapper.json.RelationList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import transML.exceptions.transException;

@Controller
@RequestMapping("/private/ATLTransformation")
public class ATLPrivateController extends ArtifactPrivateController<ATLTransformation> {

	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private User user;
	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	
	@Override
	public String details(Model model, @RequestParam String artifact_id) {
		super.details(model, artifact_id);
		return "private.use.transformation_details";
	}
	
	@RequestMapping(value = "/artifact_project", method =  RequestMethod.GET )
	public String detailsByProject(Model model, @RequestParam String project_id, @RequestParam String artifact_id) {
		super.detailsByProject(model, project_id, artifact_id);
		return "private.use.transformation_details";
	}
	
	@RequestMapping(value = "/artifact_compare", method = { RequestMethod.GET })
	public String metamodelCompareStart(Model model) {
		
		List<ATLTransformation> transformationList = aTLTransformationService.findAllWithPublicByUser(user);
		model.addAttribute("transformationList", transformationList);
				
		return "private.use.transformation_compare";
	}

	@RequestMapping(value = "/artifact_compare", method = { RequestMethod.POST })
	public String metamodelCompareExecute(Model model, @RequestParam String left_metamodel_id, @RequestParam String right_metamodel_id) {
		//TODO
		return null;
	}

	@RequestMapping(value = "/execute_transformation", method = { RequestMethod.GET })
	public String transformationExecution(Model model,
			@RequestParam String transformation_id) {
		ATLTransformation atlTransformation = aTLTransformationService
				.findOne(transformation_id);
		model.addAttribute("atlTransformation", atlTransformation);
		String pathToDownload = gridFileMediaService
				.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		List<org.mdeforge.business.model.Model> models = modelService
				.findByTransformation(atlTransformation);
		model.addAttribute("atlTransformationFile", atlTransformationFile);
		model.addAttribute("models", models);
		return "private.use.transformation_execution";
	}

	@RequestMapping(value = "/result_transformation", method = { RequestMethod.POST })
	public String transformationResult(Model model,
			@RequestParam String transformation_id,
			@RequestParam List<String> models_in) {
		List<org.mdeforge.business.model.Model> models = new ArrayList<org.mdeforge.business.model.Model>();
		for (String modelId : models_in) {
			models.add(modelService.findOne(modelId));
		}
		ATLTransformation atl = aTLTransformationService
				.findOne(transformation_id);
		try {
			List<org.mdeforge.business.model.Model> result = aTLTransformationService
				.execute(atl, models, user);
			model.addAttribute("models", result);
			model.addAttribute("errors","");
		}
		catch (ATLCoreException  | ATLExecutionException e) {
			model.addAttribute("models", new ArrayList<org.mdeforge.business.model.Model>());
			model.addAttribute("errors",e.getMessage());
		}
		
		return "private.use.result_transformation";
	}

	@Override
	public String uploadNewArtifactStart(Model model) {
		super.uploadNewArtifactStart(model);
		List<EcoreMetamodel> el = ecoreMetamodelService
				.findAllWithPublicByUser(user);
		model.addAttribute("metamodelList", el);
		return "private.use.transformation_upload";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String uploadNewArtifact(Model model,
			@ModelAttribute ("transformation") ATLTransformationForm transformation,
			//@ModelAttribute ArrayList<DomainConformToRelation> domainConformToRelationList,
			@RequestParam("artifactfile") MultipartFile file)
			throws IOException {
		
		//temporary
		for (DomainConformToRelation it : transformation.getDomainConformToRelation()) {
			if(it.getToArtifact()!=null)
				transformation.getRelations().add(it);
		}
		for (CoDomainConformToRelation it : transformation.getCoDomainConformToRelation()) 
			if(it.getToArtifact()!=null)
				transformation.getRelations().add(it);
		List<Property> p = new ArrayList<Property>();
		for (Property property : transformation.getProperties())
			if(property.getName()!=null && !property.getName().equals(""))
				p.add(property);
		transformation.setProperties(p);
//		transformation.getRelations().addAll(transformation.getDomainConformToRelation());
//		transformation.getRelations().addAll(transformation.getCoDomainConformToRelation());
		//end temporary
		ATLTransformation m = new ATLTransformation();
		BeanUtils.copyProperties(transformation, m);
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName(file.getOriginalFilename());
		gfm.setByteArray(bytes);
		m.setCreated(new Date());
		m.setAuthor(user);
		m.setFile(gfm);
		ATLTransformation result = aTLTransformationService.create(m);
		boolean report = false;
		if (result != null) {
			report = true;
		}
		model.addAttribute("report", report);
		return "redirect:/private/ATLTransformation/artifact?artifact_id=" + m.getId();
	}

	@RequestMapping(value = "/modelInfo", method = { RequestMethod.POST }, consumes = "application/json")
	public @ResponseBody RelationList getModelInfo(@RequestBody GridFileMedia gfm)
					throws IOException {
		List<Relation> result = aTLTransformationService.getModelsInfo(gfm);
		return new RelationList(result);
	}
	

	@RequestMapping(value = "/anATLyzer", method = { RequestMethod.GET })
	public String anATLyzerTrasformation(Model model,
			@RequestParam String transformation_id) {
		ATLTransformation atlTransformation = aTLTransformationService.findOneById(transformation_id, user);
		List<ATLTransformationError> errors =	aTLTransformationService
				.anATLyzer(atlTransformation);
		atlTransformation.setAtlError(errors);
		model.addAttribute("atlTransformation", atlTransformation);
		String pathToDownload = gridFileMediaService
				.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		model.addAttribute("atlTransformationFile", atlTransformationFile);
		return "private.use.transformation_details";
	}
	@RequestMapping(value = "/test_service", method = { RequestMethod.GET })
	public String testService(Model model,
			@RequestParam String transformation_id) {
		try {
			ATLTransformation atlTransformation = aTLTransformationService.findOneById(transformation_id, user);
			List<ATLTransformationTestServiceError> r;
			r = aTLTransformationService.testServices(transformation_id);
			atlTransformation.setAtlTestError(r);
			String pathToDownload = gridFileMediaService
					.getFilePath(atlTransformation);
			File atlTransformationFile = new File(pathToDownload);
			model.addAttribute("atlTransformation", atlTransformation);
			model.addAttribute("atlTransformationFile", atlTransformationFile);

		} catch (ATLTransformationCompilationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (transException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "private.use.transformation_details";
	}
	
	@RequestMapping(value = "/analysis", method = { RequestMethod.GET })
	public String transformationAnalysis(Model model,
			@RequestParam String transformation_id) {
		try {
			ATLTransformation atlTransformation = aTLTransformationService.findOneById(transformation_id, user);
			Date d = new Date();
			List<ATLTransformationTestServiceError> r;
			r = aTLTransformationService.testServices(transformation_id);
			
			atlTransformation.setAtlTestError(r);
			List<ATLTransformationError> errors =	aTLTransformationService
					.anATLyzer(atlTransformation);
			atlTransformation.setAtlError(errors);
			String pathToDownload = gridFileMediaService
					.getFilePath(atlTransformation);
			File atlTransformationFile = new File(pathToDownload);
			atlTransformation = aTLTransformationService.findOneById(transformation_id, user);
			model.addAttribute("artifact", atlTransformation);
			model.addAttribute("artifactFile", atlTransformationFile);
			
		} catch (ATLTransformationCompilationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (transException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "private.use.transformation_details";
	}

	@Override
	public String artifactList(Model model) {
		model.addAttribute("type", ATLTransformation.class.getSimpleName());
		return super.artifactList(model);
	}
}
