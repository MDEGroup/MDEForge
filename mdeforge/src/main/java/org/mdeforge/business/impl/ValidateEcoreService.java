package org.mdeforge.business.impl;

import java.io.File;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ValidateService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidateEcoreService implements ValidateService {

	@Autowired
	private GridFileMediaService gridFileMediaService;
	
	@Override
	public boolean isValid(Artifact art) {
		if (art instanceof EcoreMetamodel){
			try {
				EcoreFactory factory = EcoreFactory.eINSTANCE;
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
				File temp = new File(gridFileMediaService.getFilePath(art));
				Resource resource = resourceSet.createResource(URI.createFileURI(temp.getAbsolutePath()));

				resource.load(null);
				EcoreUtil.resolveAll(resourceSet);
				EObject eo = resource.getContents().get(0);
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eo);
				if (diagnostic.getSeverity() == Diagnostic.ERROR) 
					return false;
				else return true;
				
			} catch (Exception e) {
				return false;
			}
		}
		else return false;
		// TODO Auto-generated method stub
	}

}
