package mdeforge.plugin.eclipse.mdeforgecontrol;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.client.ArtifactService;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ProjectService;
import org.mdeforge.client.UserService;;

public class MDEForgeViewController extends MDEForgeController {
	
	
	private static EcoreMetamodelService emms;
	private static ProjectService ps;
	private static UserService us;
	private static ArtifactService as;
	
	public MDEForgeViewController(String link, String user, String pass){
		super(link, user, pass);
	}
	
	public List<FileOutputStream> getFilesInProject(String id, String path) throws Exception{
		
		if(ps==null){
			ps = new ProjectService(link, user, pass);
			}
		
		if(as==null){
			as = new ArtifactService(link, user, pass);
		}
		
		Project p = ps.getProject(id);
		
		
		Path projectLocation = new Path(path); 
		
		
		String projectName = p.getName(); 
		// Get the project handle (no project created yet). 
		IProject project = 
		ResourcesPlugin.getWorkspace().getRoot().getProject(projectName); 

		// Get a new project description and set the appropriate location. 
		IProjectDescription description = 
		ResourcesPlugin.getWorkspace().newProjectDescription(project.getName()); 
		description.setLocation(projectLocation); 

		// Create and open the project. 
		project.create(description, null); 
		project.open(null); 
		
		
		List<Artifact> list = p.getArtifacts();
		List<FileOutputStream> result = new LinkedList<FileOutputStream>();
		
		Artifact temp = null;
		File file = null;
		
		for(Artifact a : list){
			temp = as.getArtifact(a.getId());
			
			byte dataToWrite[] = temp.getFile().getByteArray();
			String name = temp.getFile().getFileName();
			FileOutputStream out = new FileOutputStream(path+File.separator+name);
			out.write(dataToWrite);
			out.close();
			result.add(out);
		}
		
	
				
		
		return result;
		
		}
	
	

	/*returns for each metamodel the name->0, description->1, id->2*/
	public String[][] getEcoreMetamodels() throws Exception{
		List<EcoreMetamodel> l = null;
		String[][] ecoremetamodels;
	
			
			if(emms == null){
				new EcoreMetamodelService(link,user,pass);
			}
			
			l = emms.getEcoreMetamodels();
			ecoremetamodels = new String[l.size()][3];
			int i = 0;
			for(EcoreMetamodel p : l){
				ecoremetamodels[i][0] = p.getName();
				ecoremetamodels[i][1] = p.getDescription();
				ecoremetamodels[i][2] = p.getId();
				i++;
			}

		return ecoremetamodels;
	}
	
	/*returns for each metamodel the username->0, first+lastname->1, id->2*/
	
	public String[][] getUsers() throws Exception{
		List<User> l = null;
		String[][] users;
		if(us == null){
			us = new UserService(link, user, pass);
		}
			
			l = us.getUsers();
			
			User myself = null;
			
			for(User u : l){
				if(u.getUsername().equals(user)){
					myself = u;
				}
			}
			
			if(myself != null){
			l.remove(myself);
			}
			
			users = new String[l.size()][3];
			int i = 0;
			for(User p : l){
				users[i][0] = p.getUsername();
				users[i][1] = p.getFirstname()+" "+p.getLastname();
				users[i][2] = p.getId();
				i++;
			}
		
		return users;
	}
	
	/*returns for each project the name->0, shared->1, id->2*/
	public String[][] getProjects() throws Exception{
		List<Project> l = null;
		String[][] projects;
		
			if(ps == null){
				ps = new ProjectService(link, user, pass);
			}
			l = ps.getProjects();
			projects = new String[l.size()][3];
			int i = 0;
			for(Project p : l){
				projects[i][0] = p.getName();
				if(p.getUsers().size()>1){
					projects[i][1] = "Yes";
				}else{
					projects[i][1] = "No";
				}
				projects[i][2] = p.getId();
				i++;
			}
		
		return projects;
	}
	
	/*returns for each ATLtransformation the name->0, domainconformto->1, codomainconformto->2, id->3*/
	public String[][] getATLTransformations(){
		return null;
	}
	
//	private static void connections() throws Exception {
//		emms = new EcoreMetamodelService("http://localhost:8080/mdeforge/",
//				"Admin", "test123");
//		ps = new ProjectService("http://localhost:8080/mdeforge/", "Admin",
//				"test123");
//		us = new UserService("http://localhost:8080/mdeforge/", "Admin",
//			"test123");
//	}
}
