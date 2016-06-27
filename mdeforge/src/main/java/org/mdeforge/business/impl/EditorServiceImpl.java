package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EditorService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.model.Editor;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.integration.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class EditorServiceImpl implements EditorService {

	@Autowired
	private EditorRepository editorRepository;

	@Override
	public void upload(Editor editor) {
		editorRepository.save(editor);
	}

	@Override
	public void download(Editor editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Editor editor) {
		editorRepository.delete(editor);

	}

	@Override
	public List<Editor> findEditorsByMetamodel(Metamodel metamodel){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseGrid<Editor> findAllPaginated(RequestGrid requestGrid) throws BusinessException {
		Page<Editor>  rows = null;
		if (requestGrid.getSortDir().compareTo("asc")==0){
			rows = editorRepository.findAll(new PageRequest(requestGrid.getStart(), requestGrid.getLength(),Direction.ASC, requestGrid.getSortCol()));
		}else{
			rows = editorRepository.findAll(new PageRequest(requestGrid.getStart(), requestGrid.getLength(),Direction.DESC, requestGrid.getSortCol()));
		}
		return new ResponseGrid<Editor>(requestGrid.getDraw(), rows.getNumberOfElements(), rows.getTotalElements(), rows.getContent());
	}
	
	@Override
	public Editor findByName(String name) throws BusinessException {
		return editorRepository.findByName(name);
	}

	@Override
	public void update(Editor editor) {
		editorRepository.save(editor);
	}
	

}
