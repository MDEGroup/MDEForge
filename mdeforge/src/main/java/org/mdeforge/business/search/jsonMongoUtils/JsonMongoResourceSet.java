package org.mdeforge.business.search.jsonMongoUtils;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.emfjson.mongo.MongoHandler;

public class JsonMongoResourceSet {
	
	private ResourceSet resourceSet;
	
	public JsonMongoResourceSet(){
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		resourceSet.getURIConverter().getURIHandlers().add(0, new MongoHandler());
	}
	
	public ResourceSet getResourceSet(){
		return this.resourceSet;
	}

}
