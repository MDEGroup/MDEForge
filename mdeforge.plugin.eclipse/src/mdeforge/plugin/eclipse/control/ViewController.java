package mdeforge.plugin.eclipse.control;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ProjectService;
import org.mdeforge.client.UserService;;

public class ViewController {
	
	private static EcoreMetamodelService emms;
	private static ProjectService ps;
	private static EcoreMetamodel emm;
	private static UserService us;
	private static Project p;

	/*returns for each metamodel the name->0, description->1, id->2*/
	public static String[][] getEcoreMetamodel(){
		List<EcoreMetamodel> l = null;
		String[][] ecoremetamodels;
		try{
			connections();
			l = emms.getEcoreMetamodels();
			ecoremetamodels = new String[l.size()][3];
			int i = 0;
			for(EcoreMetamodel p : l){
				ecoremetamodels[i][0] = p.getName();
				ecoremetamodels[i][1] = p.getDescription();
				ecoremetamodels[i][2] = p.getId();
				i++;
			}
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return ecoremetamodels;
	}
	
	/*returns for each metamodel the username->0, first+lastname->1, id->2*/
	public static String[][] getUsers(){
		List<User> l = null;
		String[][] users;
		try{
			connections();
			l = us.getUsers();
			users = new String[l.size()][3];
			int i = 0;
			for(User p : l){
				users[i][0] = p.getUsername();
				users[i][1] = p.getFirstname()+" "+p.getLastname();
				users[i][2] = p.getId();
				i++;
			}
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return users;
	}
	
	/*returns for each project the name->0, shared->1, id->2*/
	public static String[][] getProjects(){
		List<Project> l = null;
		String[][] projects;
		try{
			connections();
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
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return projects;
	}
	
	/*returns for each ATLtransformation the name->0, domainconformto->1, codomainconformto->2, id->3*/
	public static String[][] getATLTransformations(){
		return null;
	}
	
	private static void connections() throws Exception {
		emms = new EcoreMetamodelService("http://localhost:8080/mdeforge/",
				"Admin", "test123");
		ps = new ProjectService("http://localhost:8080/mdeforge/", "Admin",
				"test123");
		us = new UserService("http://localhost:8080/mdeforge/", "Admin",
			"test123");
	}
}
