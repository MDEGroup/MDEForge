package test;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import mdeforge.plugin.eclipse.mdeforgecontrol.MDEForgeController;
import mdeforge.plugin.eclipse.mdeforgecontrol.MDEForgeServiceController;
import mdeforge.plugin.eclipse.mdeforgecontrol.MDEForgeViewController;

import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.client.ArtifactService;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ModelService;
import org.mdeforge.client.ProjectService;

public class testMDEForgeController {
	
@Ignore
@Test
public void testAddProject() throws Exception{
	ProjectService ps = new ProjectService("http://localhost:8080/mdeforge/", "Admin",
			"test123");
	
	Project p = new Project();
	p.setName("testProject");
	
	EcoreMetamodelService ems = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin",
			"test123");
	
	List<Artifact> res = new LinkedList();
	
	for(EcoreMetamodel e : ems.getEcoreMetamodels()){
		res.add(e);
	}
	
	p.setArtifacts(res);
	
	ps.addProject(p);
}


@Test
 public void testDownloadFile() throws Exception{
	 MDEForgeViewController m = new MDEForgeViewController("http://localhost:8080/mdeforge/", "Admin",
				"test123");
	 
	 List<FileOutputStream> list = m.getFilesInProject("55b8df64250fca2f3952a9c2","");
	 for(FileOutputStream o : list){
		 System.out.println(o);
	 }
	 
 }

}
