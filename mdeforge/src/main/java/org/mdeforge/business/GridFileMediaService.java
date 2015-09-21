package org.mdeforge.business;

import java.io.IOException;
import java.io.InputStream;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;

public interface GridFileMediaService {
	void store(GridFileMedia gridFileMedia) throws BusinessException;
	
	public String getFilePath(Artifact artifact) throws BusinessException;
	
	GridFileMedia getGridFileMedia(GridFileMedia id) throws BusinessException;

	void delete(GridFileMedia idGridFileMedia) throws BusinessException;

	byte[] getFileByte(Artifact artifact) throws BusinessException;

	InputStream getFileInputStream(Artifact artifact) throws BusinessException;

	GridFileMedia createObjectFromFile(String fileName) throws IOException;
	
}
