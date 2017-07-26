package org.mdeforge.business.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.integration.GridFileMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Service
public class GridFileMediaServiceImpl implements GridFileMediaService {
	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	GridFsTemplate operations;
	@Autowired
	GridFileMediaRepository gridFileMediaRepository;
	@Value("#{cfgproperties[basePath]}")
	private String basePath;

	@Override
	public void store(GridFileMedia gridFileMedia) throws BusinessException {
		GridFSFile gridFile = operations.store(new ByteArrayInputStream(gridFileMedia.getByteArray()),
				gridFileMedia.getFileName());
		gridFileMedia.setIdFile(gridFile.getId().toString());
		gridFileMediaRepository.save(gridFileMedia);
	}

	@Override
	public GridFileMedia getGridFileMedia(GridFileMedia id) throws BusinessException {
		Query q = new Query();
		q.addCriteria(Criteria.where("_id").is(id.getIdFile()));
		GridFSDBFile dbFile = operations.findOne(q);
		id.setByteArray(readData(dbFile));
		return id;
	}

	@Override
	public GridFileMedia createObjectFromFile(String tempFilePath, String fileName) throws IOException {
		GridFileMedia gfr = new GridFileMedia();
		gfr.setFileName(fileName);
		File f = new File(tempFilePath);
		if (f.createNewFile()){
	        System.out.println("File is created!");
		}else{
			System.out.println("File is not created");
		}
	
		if (f.exists()) {

			java.nio.file.Path path = Paths.get(f.getAbsolutePath());
			byte[] data = Files.readAllBytes(path);
			gfr.setByteArray(data);

		} else {
			System.out.println("temp file path doesn't exist");
		}

		return gfr;
	}

	private static byte[] readData(GridFSDBFile dbFile) {
		byte[] data = new byte[0];

		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			dbFile.writeTo(bout);
			data = bout.toByteArray();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return data;
	}

	@Override
	public void delete(GridFileMedia file) throws BusinessException {
		Query q = new Query();
		q.addCriteria(Criteria.where("id").is(file.getIdFile()));
		operations.delete(q);
		gridFileMediaRepository.delete(file);
	}

	
	/*
	 * This function create a new file System Resource . The name of file created is gotten up by basePath + artifact.getFile().getFilename()
	 * (non-Javadoc)
	 * @see org.mdeforge.business.GridFileMediaService#getFilePath(org.mdeforge.business.model.Artifact)
	 */
	@Override
	public String getFilePath(Artifact artifact) throws BusinessException {
		GridFileMedia grm = null;
		if (artifact.getFile().getId() != null)
			grm = getGridFileMedia(artifact.getFile());
		else
			grm = artifact.getFile();
		OutputStream out;
		try {
			FileSystemResource resource = new FileSystemResource(basePath + artifact.getFile().getFileName());
			out = resource.getOutputStream();
			if (grm.getByteArray() != null && grm.getByteArray().length != 0)
				out.write(grm.getByteArray());

			else
				out.write(Base64.decode(grm.getContent().getBytes()));

			out.close();
			return resource.getPath();
		} catch (FileNotFoundException e) {
			throw new BusinessException(e.getMessage());
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

/*
 * In this function We create the file
 * (non-Javadoc)
 * @see org.mdeforge.business.GridFileMediaService#getFilePathFromContent(org.mdeforge.business.model.GridFileMedia)
 */
	@Override
	public String getFilePathFromContent(GridFileMedia gdf) throws BusinessException {

		OutputStream out;
		try {
			FileSystemResource resource = new FileSystemResource(basePath + gdf.getFileName());
			out = resource.getOutputStream();
			if (gdf.getContent() != null)
				out.write(Base64.decode(gdf.getContent().getBytes()));
			if (gdf.getByteArray() != null)
				out.write(gdf.getByteArray());
			if (gdf.getByteArray() == null && gdf.getContent() == null) {
				out.close();
				throw new BusinessException("No Content");
			}
			out.close();
			return resource.getPath();
		} catch (FileNotFoundException e) {
			throw new BusinessException(e.getMessage());
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public byte[] getFileByte(Artifact artifact) throws BusinessException {
		GridFileMedia grm = getGridFileMedia(artifact.getFile());
		GridFS fileStore = new GridFS(mongoDbFactory.getDb());
		GridFSDBFile found = fileStore.findOne(grm.getFileName());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			found.writeTo(baos);
		} catch (IOException e) {
			throw new BusinessException();
		}
		return baos.toByteArray();
	}

	@Override
	public InputStream getFileInputStream(Artifact artifact) throws BusinessException {
		GridFileMedia grm = getGridFileMedia(artifact.getFile());
		Query q = new Query();
		q.addCriteria(Criteria.where("_id").is(grm.getIdFile()));
		GridFSDBFile dbFile = operations.findOne(q);
		return dbFile.getInputStream();
	}

}
