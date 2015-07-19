package mdeforge.plugin.eclipse.control;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ProjectService;

public class ViewController {
	
	private static EcoreMetamodelService emms;
	private static ProjectService ps;
	private static EcoreMetamodel emm;
	private static Project p;

	
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
	
	private static void connections() throws Exception {
		emms = new EcoreMetamodelService("http://localhost:8080/mdeforge/",
				"Admin", "test123");
		ps = new ProjectService("http://localhost:8080/mdeforge/", "Admin",
				"test123");
	}
}
