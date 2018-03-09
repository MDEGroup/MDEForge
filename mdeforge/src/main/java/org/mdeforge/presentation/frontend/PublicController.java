package org.mdeforge.presentation.frontend;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	@Autowired
	private GridFsTemplate operation;
	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {
		return "public.login";
	}

	@RequestMapping(value = "/about", method = { RequestMethod.GET })
	public String about() {
		return "public.about";
	}

	@RequestMapping(value = "/members", method = { RequestMethod.GET })
	public String members() {
		return "public.members";
	}

	@RequestMapping(value = "/publications", method = { RequestMethod.GET })
	public String publications() {
		return "public.publications";
	}

	@RequestMapping("/login")
	public String login() {
		return "public.login";
	}
	@RequestMapping(value = "/user/search", method = { RequestMethod.GET })
	public @ResponseBody List<User> searchUsers(@RequestParam("username") String username){
		return (userService.findByUsernameContaining(username));
	}
	
	@RequestMapping(value = "/user/exist_username", method = { RequestMethod.GET })
	public @ResponseBody boolean existUser(@RequestParam("username") String username){
		return (userService.findOneByUsername(username)==null)?false:true;
	}
	@RequestMapping(value = "/user/exist_email", method = { RequestMethod.GET })
	public @ResponseBody boolean existEmail(@RequestParam("email") String email){
		return (userService.findOneByEmail(email)==null)?false:true;
	}

	@RequestMapping(value = "/getPhoto", method = RequestMethod.GET)
	public @ResponseBody
	void getPhoto(HttpServletRequest request,
	        HttpServletResponse response, @RequestParam String id) {
	    try {
	    	
	    	Query q = new Query();
			q.addCriteria(Criteria.where("_id").is(id));
            GridFSDBFile imageForOutput = operation.findOne(q); 
            InputStream is = imageForOutput.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[]imagenEnBytes = buffer.toByteArray();
            response.setHeader("Accept-ranges","bytes");
            response.setContentType( "image/jpeg" );
            response.setContentLength(imagenEnBytes.length);
            response.setHeader("Expires","0");
            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Content-Description","File Transfer");
            response.setHeader("Content-Transfer-Encoding:","binary");

            OutputStream out = response.getOutputStream();
            out.write( imagenEnBytes );
            out.flush();
            out.close();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	    }
	}
	
	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String dashboard(Model model) throws IOException {
//		model.addAttribute("user",us);
		model.addAttribute("statistic", artifactService.statistic());
		model.addAttribute("statisticMM", ecoreMetamodelService.statistic());
		model.addAttribute("statisticM", modelService.statistic());
		model.addAttribute("statisticT", aTLTransformationService.statistic());
		model.addAttribute("statistic2", ecoreMetamodelService.numberOfMCdistribution());
		model.addAttribute("statisticATL", aTLTransformationService.numberOfMCdistribution());
		long numUsers = userService.countUsers();
		long numATL = aTLTransformationService.countAll();
		long numEcore = ecoreMetamodelService.countAll();
		long numModel = modelService.countAll();
		long numProject = projectService.countAll();
		List<EcoreMetamodel> recentsEcore = ecoreMetamodelService.findRecentArtifactsPublic();
		List<ATLTransformation> recentsATL = aTLTransformationService.findRecentArtifactsPublic();
		List<org.mdeforge.business.model.Model> recentsModel = modelService.findRecentArtifactsPublic();
		model.addAttribute("numArtifacts", numATL + numEcore + numModel);
		model.addAttribute("numUsers", numUsers);
		model.addAttribute("numATL", numATL);
		model.addAttribute("numEcore", numEcore);
		model.addAttribute("numModel", numModel);
		model.addAttribute("numProject", numProject);
		model.addAttribute("recentsEcore", recentsEcore);
		model.addAttribute("recentsATL", recentsATL);
		model.addAttribute("recentsModel", recentsModel);
		return "public.browse.dashboard";
	}
}
