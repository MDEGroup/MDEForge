package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;

public interface ProjectService {
	
//	void create(Project project) throws BusinessException;
	
	void delete(Project project, User user) throws BusinessException;
	
	ResponseGrid<Project> findAllPaginated(RequestGrid requestGrid) throws BusinessException;
	
	Project findByName(String name) throws BusinessException;
	
	Project findById(String id, User user) throws BusinessException;
	
	List<Project> findByIdWorkspace(String idWorkspace, User user) throws BusinessException;

	void create(Project project, User userId) throws BusinessException;

	void update(Project project, User idUser) throws BusinessException;

	List<Project> findByIdUser(User idUser) throws BusinessException;

	List<Project> findAll() throws BusinessException;
	
	Project findOne(String id) throws BusinessException;

}
