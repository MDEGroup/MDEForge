package org.mdeforge.business.impl;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.digraphs2weightedbipartitegraph.files.Digraphs2weightedbipartitegraph;
import org.eclipse.m2m.atl.ecore2digraph_v2.files.Ecore2directgraph;
import org.springframework.stereotype.Service;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.SimilarityService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;

import algorithm.HungarianAlgorithm;

import com.google.common.io.Files;

import digraphMM.impl.DigraphMMFactoryImpl;

@Service
public class SimilarityServiceImpl implements SimilarityService {

	
	@Override
	public String calculateSimilarity(Artifact art1, Artifact art2) {
		final String a1InFileName = new String("a1.ecore");
		final String a1OutFileName = new String("a1/temp_out/out_net1_01.xmi");
		final String b1InFileName = new String("b1.ecore");
		final String b1OutFileName = new String("b1/temp_out/out_net1_01.xmi");
		final String c1OutFileName = new String("c1/temp_out/out_net1_01.xmi");
		String s1 = art1.getName().replace(" ", "");
		String s2 = art2.getName().replace(" ", "");
		s1 = s1.replace(".", "_");
		s2 = s2.replace(".", "_");
		
		final String c1OutTextFileName = new String("c1/" + s1 + "___" + s2 + ".txt");
		EcoreMetamodel a = null;
		if(art1 instanceof EcoreMetamodel)
			 a = (EcoreMetamodel) art1;
		else throw new BusinessException();
		EcoreMetamodel b = null;
		if(art2 instanceof EcoreMetamodel)
			 b = (EcoreMetamodel) art2;
		else throw new BusinessException();
		File a1 = new File(a1InFileName);
		File b1 = new File(b1InFileName);
		try {
			//Generate directGraph
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("digraphMM", new DigraphMMFactoryImpl());
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			Files.write(a.getFile().getByteArray(),a1);
			Files.write(b.getFile().getByteArray(),b1);
			String [] arrayA1 = {a1InFileName,a1OutFileName};
			Ecore2directgraph.main(arrayA1);
			String [] arrayB1 = {b1InFileName,b1OutFileName};
			Ecore2directgraph.main(arrayB1);
			String [] cArray = {a1OutFileName,b1OutFileName,c1OutFileName};
			Digraphs2weightedbipartitegraph.main(cArray);
			String [] dArray = {c1OutFileName,	c1OutTextFileName};
			HungarianAlgorithm.main(dArray);
			String similarityValue =HungarianAlgorithm.getSimilarityValue();
			a1.delete();
			b1.delete();
			
			HungarianAlgorithm.main(dArray);
			return similarityValue;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new BusinessException();
		}

		
	}

}
