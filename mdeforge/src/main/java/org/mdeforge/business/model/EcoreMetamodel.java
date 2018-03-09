package org.mdeforge.business.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EcoreMetamodel extends Metamodel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4392451687476669764L;
	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	@JsonIgnore
	public List<ConformToRelation> getConformToRelation() {
		return getRelations()
				.stream()
				.filter(t -> t instanceof ConformToRelation)
				.map(c -> (ConformToRelation) c)
				.collect(Collectors.toList()) ;
	}
}
