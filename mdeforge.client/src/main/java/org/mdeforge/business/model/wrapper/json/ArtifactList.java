package org.mdeforge.business.model.wrapper.json;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.Artifact;

public class ArtifactList extends ArrayList<Artifact> {
	public ArtifactList(List<? extends Artifact> list) {
		super(list); // may need a cast
	}
}
