package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;

public interface SearchProvider {

	public List<Artifact> search(String text);
	public List<Artifact> orederedSearch(String text);
}
