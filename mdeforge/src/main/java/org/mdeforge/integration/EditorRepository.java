package org.mdeforge.integration;

import org.mdeforge.business.model.Editor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditorRepository extends MongoRepository<Editor, String> {
	Editor findByName(String name);
}
