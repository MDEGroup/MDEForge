package org.mdeforge.business.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.integration.GridFileMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
@Service
public class GridFileMediaServiceImpl implements GridFileMediaService {

	@Autowired
	GridFsTemplate operations;
	@Autowired
	GridFileMediaRepository gridFileMediaRepository;
	@Override
	public void store(GridFileMedia gridFileMedia) throws BusinessException {
		GridFSFile gridFile = operations.store(new ByteArrayInputStream(gridFileMedia.getByteArray()), gridFileMedia.getFileName());
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
	private static byte[] readData(GridFSDBFile dbFile) {
        byte[] data = new byte[0];

        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            dbFile.writeTo(bout);
            data = bout.toByteArray();
        } catch (Exception e) {
            // error while reading data
            e.printStackTrace();
        }

        return data;
    }

	@Override
	public void delete(String idGridFileMedia) throws BusinessException {
		GridFileMedia file = gridFileMediaRepository.findOne(idGridFileMedia);
		Query q = new Query();
		q.addCriteria(Criteria.where("id").is(file.getIdFile()));
		operations.delete(q);
		gridFileMediaRepository.delete(file);
		
	}

}
