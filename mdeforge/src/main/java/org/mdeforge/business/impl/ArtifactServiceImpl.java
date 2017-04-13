package org.mdeforge.business.impl;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.stereotype.Service;
@Service
public class ArtifactServiceImpl extends CRUDArtifactServiceImpl<Artifact> {

	@Override
	public void createIndex(Artifact is) {
		File indexDirFile = new File(basePathLucene);
		// Set the directory in which will be created the index.
		Directory indexDir;
		try {
			indexDir = FSDirectory.open(indexDirFile);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			// Create an index in the directory, appending new index over
			// previously indexed documents:
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND); // or CREATE
			// create the indexer
			
			IndexWriter writer = new IndexWriter(indexDir, conf);

			try {
				// writer.updateDocument(new Term("path", file.getPath()),
				// document);
				Document document = getMetadataIndex(is);
				writer.addDocument(document);
			} catch (CorruptIndexException e) {
				writer.close();
				throw new BusinessException(e.getMessage());
			} catch (IOException e) {
				writer.close();
				throw new BusinessException(e.getMessage());
			}
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			throw new BusinessException(e1.getMessage());
		}

	}

}
