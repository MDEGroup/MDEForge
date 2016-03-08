package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;

public interface SearchProvider <T extends Artifact> {

	public List<T> search(String text);
	public List<T> orederedSearch(String text);
}
