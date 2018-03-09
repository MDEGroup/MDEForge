package org.mdeforge.business.impl;

import org.mdeforge.business.TagService;
import org.mdeforge.business.model.Tag;
import org.mdeforge.integration.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;
	@Override
	public void save(Tag tag) {
		tagRepository.save(tag);
	}

}
