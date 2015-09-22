package org.mdeforge.business.model.wrapper.json;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.Relation;

public class RelationList extends ArrayList<Relation> {
	public RelationList(List<? extends Relation> list) {
		super(list); // may need a cast
	}
	public RelationList() {
		super(new ArrayList<Relation>()); // may need a cast
	}
}
