package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Project;
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
	Workspace findOne(String id);
	Workspace findOneWithUser(String id, String idUser) throws BusinessException;
	public ResponseGrid<Workspace> findAllPaginatedByOwner(RequestGrid requestGrid, User user)
			throws BusinessException;
	List<Project> findProjectInWorkspace(String id, User user);
	void removeProjectFromWorkspace(String idProject, String idWorkspace, User user) throws BusinessException;
	Project addProjectInWorkspace(String idProject, String idWorkspace,
			User user) throws BusinessException;
	Project addNewProjectInWorkspace(String projectName, String idWorkspace,
			User user) throws BusinessException;
	List<Workspace> findByUser(User user) throws BusinessException;
	Project addNewProjectInWorkspace(Project projectName, String idWorkspace, User user) throws BusinessException;
}
