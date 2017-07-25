package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Jsfiddle;
import org.mdeforge.business.model.User;

public interface JsfiddleService {

	void create(Jsfiddle jsfiddle) throws BusinessException;
	List<Jsfiddle> findByUser(User userId) throws BusinessException;
	Jsfiddle findById(String id, User user) throws BusinessException;
}
