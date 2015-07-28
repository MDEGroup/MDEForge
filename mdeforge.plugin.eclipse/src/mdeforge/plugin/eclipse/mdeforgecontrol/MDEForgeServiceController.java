package mdeforge.plugin.eclipse.mdeforgecontrol;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ModelService;
import org.mdeforge.client.ProjectService;
import org.mdeforge.client.WorkspaceService;

public class MDEForgeServiceController extends MDEForgeController {

	private static EcoreMetamodelService emms;
	private static ModelService ms;
	private static WorkspaceService wss;
	private static Model m;
	private static ProjectService ps;
	private static EcoreMetamodel emm;
	private static Project p;
	
	protected MDEForgeServiceController(String link, String user, String pass){
		super(link, user, pass);
	}

	/**/
	public static boolean AddEcoretoForge(boolean pub, String file,
			List<String> id_projects) throws Exception {
		
			
			emm = new EcoreMetamodel();
			emm.setOpen(pub);
			for (String id : id_projects) {

				p = ps.getProject(id);

				emm.addToProjects(p);
			}
	
		return true;
	}

	/* in attesa di ConformToService */
	public static boolean addModelToForge(boolean pub, String file,
			String id_metamodel) throws Exception {
		
			if(ms == null){
				new ModelService(link, user, pass);
			}
			
			if(emms == null){
				new EcoreMetamodelService(link, user, pass);
			}
			
			m = new Model();
			m.setOpen(pub);
			ConformToRelation r = new ConformToRelation();
			emm = emms.getEcoreMetamodel(id_metamodel);
			r.setToArtifact(emm);
			r.setFromArtifact(m);
			List<Relation> newRelations = new ArrayList<Relation>();
			newRelations.add(r);
			m.setRelations(newRelations);
			ms.addModel(m, file);

		
		return true;
	}

	/* da rivedere */
	public static boolean addATLTransformationToForge(boolean pub, String file,
			String id_domain_mm, String co_domain_mm) {
		return true;
	}

	/* Download of the Metamodel artifacts */
	public static boolean downloadMetamodels(String path, String[] ids) throws Exception {
		if(emms == null){
			new EcoreMetamodelService(link, user, pass);
		}
		
		for(String id : ids){
			
				emm = emms.getEcoreMetamodel(id);
				System.out.println(emm.getName());
		
		}
		return true;
	}

	/*
	 * Download of ATL artifact, DomainConformTo (from and to
	 * Artifacts),CodomainConformto (From and To Artifacts) in the current_path
	 */
	public static boolean downloadATLTransformations(String[] ids,
			String current_path) {
		return true;
	}

	/*
	 * Download of all the artifacts in a project and store it in a new Project
	 * with the same name
	 */
	public static boolean downloadProject(String id) {
		return true;
	}

	public static boolean addWorkspaceToForge(String name, String desc) throws Exception {
		
		if(wss==null){
			new WorkspaceService(link, user, pass);
		}
			
			Workspace w = new Workspace();
			w.setName(name);
			w.setDescription(desc);

			wss.addWorkspace(w);
		
		return true;
	}

//	private static void connections() throws Exception {
//		emms = new EcoreMetamodelService("http://localhost:8080/mdeforge/",
//				"Admin", "test123");
//		ps = new ProjectService("http://localhost:8080/mdeforge/", "Admin",
//				"test123");
//		ms = new ModelService("http://localhost:8080/mdeforge/", "Admin",
//				"test123");
//		wss = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin",
//				"test123");
//	}
}
