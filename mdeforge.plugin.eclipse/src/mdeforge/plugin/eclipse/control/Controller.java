package mdeforge.plugin.eclipse.control;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ProjectService;

public class Controller {

	private static EcoreMetamodelService emms;
	private static ProjectService ps;
	private static EcoreMetamodel emm;
	private static Project p;

	public static boolean AddEcoretoForge(boolean pub, String file, List<String> id_projects) {
		try {
			connections();
			emm = new EcoreMetamodel();
			emm.setOpen(pub);
			for (String id : id_projects) {

				p = ps.getProject(id);

				emm.addToProjects(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static List<Project> getProjects(){
		List<Project> l = null;
		try {
			connections();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			l = ps.getProjects();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static List<EcoreMetamodel> getEcoreMetamodel(){
		List<EcoreMetamodel> l = null;
		try{
			connections();
			l = emms.getEcoreMetamodels();
		} catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}

	public static void connections() throws Exception {
		emms = new EcoreMetamodelService("http://localhost:8080/mdeforge/",
				"Admin", "test123");
		ps = new ProjectService("http://localhost:8080/mdeforge/", "Admin",
				"test123");
	}
}
