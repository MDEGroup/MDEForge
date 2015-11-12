package org.mdeforge.business.model.wrapper.json;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.Artifact;

public class ArtifactList extends ArrayList<Artifact> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5188965696608791915L;

	public ArtifactList(List<? extends Artifact> list) {
		super(list); // may need a cast
	}
}
