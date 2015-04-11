package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;

public interface WorkspaceService {
	void create(Workspace workspace) throws BusinessException;
	void update(Workspace workspace) throws BusinessException;
	void delete(Workspace workspace) throws BusinessException;
	ResponseGrid<Workspace> findAllPaginated(RequestGrid requestGrid) throws BusinessException;
	Workspace findByName(String name) throws BusinessException;
	Workspace findById(String id, User user) throws BusinessException;
	List<Workspace> findAll() throws BusinessException;
	void delete(String id, User user) throws BusinessException;
	List<Workspace> findAllByUsernamme(User user) throws BusinessException;
	Workspace findOne(String id);
	Workspace findOneWithUser(String id, String idUser) throws BusinessException;
	public ResponseGrid<Workspace> findAllPaginatedByOwner(RequestGrid requestGrid, User user)
			throws BusinessException;
}
