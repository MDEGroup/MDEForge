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
		return null;		
	}

}
