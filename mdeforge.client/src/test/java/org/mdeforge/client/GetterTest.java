package org.mdeforge.client;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;

public class GetterTest {

	private static MDEForgeClient c;

	@BeforeClass
	public static void setup() throws Exception {
		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
	}
	
	@Test
	public void getModelsTest() throws Exception {
		System.out.println("###Model");
		for (Model iterable_element : c.getModels()) {
			System.out.println(iterable_element.getName());
		}
		assertNotNull(c);
	}
	
	@Test
	public void getEcoreMetamodelsTest() throws Exception {
		System.out.println("###Ecore");
		for (EcoreMetamodel iterable_element : c.getEcoreMetamodels()) {
			System.out.println(iterable_element.getName());
		}
		assertNotNull(c);
	}
	@Test
	public void getETLTransformationsTest() throws Exception {
		System.out.println("###ETL");
		for (ETLTransformation iterable_element : c.getETLTransformations()) {
			System.out.println(iterable_element.getName());
		}
		assertNotNull(c);
	}
	@Test
	public void getATLTransformationsTest() throws Exception {
		System.out.println("###ATL");
		for (ATLTransformation iterable_element : c.getATLTransformations()) {
			System.out.println(iterable_element.getName());
		}
		assertNotNull(c);
	}
	@Test
	public void getEcoreMetanmodelInWorkspaceTest() throws Exception {
		System.out.println("###EcoreWorkspace");
		for (EcoreMetamodel iterable_element : c.getEcoreMetamodelsInWorkspace("5514aa53d4c67eee3e2c1b12")) {
			System.out.println(iterable_element.getName());
		}
		assertNotNull(c);
	}
}
