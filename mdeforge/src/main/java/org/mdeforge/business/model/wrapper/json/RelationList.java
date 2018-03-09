package org.mdeforge.business.model.wrapper.json;

import java.util.ArrayList;
import java.util.List;
import org.mdeforge.business.model.Relation;

public class RelationList extends ArrayList<Relation> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5188965696608791915L;

	public RelationList(List<? extends Relation> list) {
		super(list); // may need a cast
	}
}
