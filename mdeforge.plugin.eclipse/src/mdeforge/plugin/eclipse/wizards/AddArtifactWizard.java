package mdeforge.plugin.eclipse.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.Wizard;

public class AddArtifactWizard extends Wizard {

	protected AddArtifactPageEMM1 emm1;
	protected AddArtifactPageM1 m1;
	private IFile file;
	
	
	public AddArtifactWizard(IFile file){
		super();
		setNeedsProgressMonitor(true);
		this.file = file;
	}
	
	
	@Override
	public String getWindowTitle(){
		return "Upload Local Artifact";
	}
	
	@Override
	public void addPages(){
		
		emm1 = new AddArtifactPageEMM1(file);
		m1 = new AddArtifactPageM1();
		
		if(file.getFileExtension().equals("ecore")){
			addPage(emm1);
		}
		else if(file.getFileExtension().equals("xmi")){
			addPage(m1);
		}
		
	}
	@Override
	public boolean performFinish() {
		if(emm1 != null){
			System.out.println(emm1.getText1());
			System.out.println(emm1.getProject());
			System.out.println(emm1.getPublic());
			/*call to EcoreMetamodelService*/
		}
		else if(m1 != null){
			System.out.println(m1.getText1());
			/*call to ModelService*/
		}
		return true;
	}

}
