package org.mdeforge.business.search.jsonMongoUtils;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.emfjson.mongo.MongoHandler;
import org.mdeforge.business.search.ResourceSerializer;

public class EmfjsonMongo {

	private static EmfjsonMongo instance =null;
	private ResourceSet resourceSet;

	private EmfjsonMongo(){
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		resourceSet.getURIConverter().getURIHandlers().add(0, new MongoHandler());
	}
	
	public static EmfjsonMongo getInstance(){
		if (instance==null)
			instance = new EmfjsonMongo();
		return instance;
	}
	
	public ResourceSet getResourceSet(){
		return this.resourceSet;
	}
	
	public String serializeAndSaveMetamodel(String sourceURI, String mongoURI){
		ResourceSet load_resourceSet = new ResourceSetImpl();
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(sourceURI),true);
		
		EList<EObject> contents = load_resource.getContents();
		String contentsString = ResourceSerializer.serialize(load_resource);
		Resource res = resourceSet.createResource(URI.createURI(mongoURI));

		res.getContents().addAll(contents);

		try {
			res.save(null);
			return contentsString;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public void saveMetamodel(String sourceURI, String mongoURI){
		ResourceSet load_resourceSet = new ResourceSetImpl();
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(sourceURI),true);

		Resource res = resourceSet.createResource(URI.createURI(mongoURI));

		res.getContents().addAll(load_resource.getContents());

		try {
			res.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Resource loadMetamodel(String mongoURI){
		Resource resource = resourceSet.createResource(URI.createURI(mongoURI));

		try {
			resource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resource;
	}
	
	public String saveModel(String metamodelURI, String sourceURI, String mongoURI){
		Resource mm = loadMetamodel(metamodelURI);
		EPackage mmePackage = null;
		
		ResourceSet load_resourceSet = new ResourceSetImpl();
		
		for (EObject eObject : mm.getContents()) {
			if (eObject instanceof EPackage){
				mmePackage = (EPackage) eObject;
				load_resourceSet.getPackageRegistry().put(mmePackage.getNsURI(), mmePackage);
			}
        }
		
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(sourceURI),true);

		Resource res = resourceSet.createResource(URI.createURI(mongoURI));
		
		EList<EObject> cs = load_resource.getContents();

		res.getContents().addAll(cs);
		
		String contents = ResourceSerializer.serialize(res);

		try {
			res.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contents;
	}
}