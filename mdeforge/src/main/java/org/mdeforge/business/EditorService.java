package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Editor;
import org.mdeforge.business.model.Metamodel;

public interface EditorService {
	void upload(Editor editor);
	void download(Editor editor);
	void delete(Editor editor);
	List<Editor> findEditorsByMetamodel(Metamodel metamodel);
	
	ResponseGrid<Editor> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	Editor findByName(String name);
	void update(Editor editor);
}