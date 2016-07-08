package org.mdeforge.presentation.backend;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.VerificationToken;
import org.mdeforge.integration.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Controller
@RequestMapping("/private")
public class PrivateController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ATLTransformationService aTLTransformationService;
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private GridFsTemplate operation;

	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String dashboard(Model model) throws IOException {
		
		model.addAttribute("user",us);
		model.addAttribute("statistic", artifactService.statistic());
		model.addAttribute("statisticMM", ecoreMetamodelService.statistic());
		model.addAttribute("statisticM", modelService.statistic());
		model.addAttribute("statisticT", aTLTransformationService.statistic());
		model.addAttribute("statistic2", ecoreMetamodelService.numberOfMCdistribution());
		model.addAttribute("statisticATL", aTLTransformationService.numberOfMCdistribution());
		List<Artifact> myArtifactsList = artifactService.findRecentArtifacts();
		model.addAttribute("myArtifactsList",myArtifactsList);
		
		List<Project> myProjectList = projectService.findRecent();
		model.addAttribute("myProjectList",myProjectList);
		
		
		long countT = aTLTransformationService.countAll();
		model.addAttribute("totalNumberOfTransformations",countT);
		
		long allMM = ecoreMetamodelService.countAll();
		model.addAttribute("totalNumberOfMetamodels",allMM);
		
		long allM = modelService.countAll();
		model.addAttribute("totalNumberOfModels",allM);
		
		long allA = artifactService.countAll();
		model.addAttribute("totalNumberOfArtifacts",allA);
		
//		List<Project> myProjectList = projectService.findSharedNoWorkspace(user);
		model.addAttribute("totalNumberOfProjects",myProjectList.size());

		return "private.use.dashboard";
	}

	@RequestMapping(value = "/shared_artifacts", method = { RequestMethod.GET })
	public String sharedArtifacts(Model model) throws IOException {
		
		List<Artifact> sharedArtifactList = artifactService.findSharedNoProject(us);
		model.addAttribute("sharedArtifactList",sharedArtifactList);
		model.addAttribute("pageName", "Shared Artifacts");
		return "private.use.shared_artifacts";
	}

	@RequestMapping(value = "/shared_projects", method = { RequestMethod.GET })
	public String sharedProjects(Model model) throws IOException {
		
		List<Project> sharedProjectList = projectService.findSharedNoWorkspace(us);
		model.addAttribute("sharedProjectList",sharedProjectList);
		
		return "private.use.shared_projects";
	}

	@RequestMapping(value = "/my_artifacts", method = { RequestMethod.GET })
	public String myArtifacts(Model model) throws IOException {
		
		List<Artifact> myArtifactsList = artifactService.findMyArtifacts(us);
		model.addAttribute("sharedArtifactList",myArtifactsList);
		model.addAttribute("pageName","My Artifacts");
		
		return "private.use.my_artifacts";
	}
	@RequestMapping(value = "/artifact/delete", method = RequestMethod.GET)
	public String deleteArtifact(@RequestParam("idArtifact") String idArtifact, org.springframework.ui.Model model) {
		Artifact artifact = artifactService.findOneById(idArtifact, us);
		artifactService.delete(artifact, us);
		return "redirect:/private/dashboard";
	}
	
	@RequestMapping(value = "/artifact/{idArtifact}/addUser/{idUser}", method=RequestMethod.GET)
	public @ResponseBody HttpEntity<User> addUserInArtifact(@PathVariable("idUser") String idUser, @PathVariable("idArtifact") String idArtifact) {
		try {
			User u = artifactService.addUserInArtifact(idUser, idArtifact, us);
			return  new ResponseEntity<User>(u, HttpStatus.OK);
		} catch (BusinessException e) {
			return  new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(value = "/artifact/{idArtifact}/removeUser/{idUser}", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	
	public @ResponseBody HttpEntity<String> removeUserFromArtifact(@PathVariable("idUser") String idUser, @PathVariable("idArtifact") String idArtifact) {
		try {
//			workspaceService.removeProjectFromWorkspace(idProject, idWorkspace, user);
			artifactService.removeUserFromArtifact(idUser, idArtifact);
			return  new ResponseEntity<String>("ok", HttpStatus.OK);
		} catch (BusinessException e) {
			return  new ResponseEntity<String>("ko", HttpStatus.UNPROCESSABLE_ENTITY);
		}
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
	
	@Autowired
	private User us;
	@Autowired
	private UserService userService;
	@Autowired
	ApplicationEventPublisher eventPublisher;
	@Autowired
	GridFsTemplate operations;
	@RequestMapping(value = "/update_account", method = { RequestMethod.GET })
	public String signIn(Model model) {
		model.addAttribute("user",userService.findOne(us.getId()));
		return "private.update";
	}
	
	@RequestMapping(value = "/change_password", method = { RequestMethod.GET })
	public String changePassword(Model model) {
		model.addAttribute("user",userService.findOne(us.getId()));
		return "private.use.change_password";
	}
	
	@RequestMapping(value = "/change_password", method = { RequestMethod.POST })
	public String changePassword(Model model,
			@RequestParam String password_old,
			@RequestParam String password_new,
			@RequestParam String password_new_r) {
		userService.changePassword(us, password_old, password_new, password_new_r);
		return "redirect:/private/dashboard";
	}
	
	@RequestMapping(value = "/update_account", method = { RequestMethod.POST })
	public String signInPost(Model model, @ModelAttribute ("user") User user,
			@RequestParam(value = "photo", required= false) MultipartFile photo,
			HttpServletRequest request) {
		if (user.getId().equals(us.getId()))
			try {
				if(photo != null) {
					user.setImage(operations.store(photo.getInputStream(), 
							photo.getOriginalFilename(),"").
								getId().toString());
				}
				userService.update(user);
			} catch (IOException e1) {
				System.out.println("ERROR");
			}
		else
			throw new BusinessException("You have not permission to update user data");
		
		return "redirect:/private/dashboard";
	}

	
	
    @RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
          (HttpServletRequest request, Model model, @RequestParam("token") String token) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            model.addAttribute("message", "The user couldn't be found!");
            return "public.registration.status"; 
        }
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", "The token has been expired!");
            return "public.registration.status"; 
        } 
        User user = verificationToken.getUser();
        model.addAttribute("message", "User is confirmed. Please login!");
        user.setEnabled(true); 
        userService.saveRegisteredUser(user); 
        return "public.registration.status"; 
    }
}
