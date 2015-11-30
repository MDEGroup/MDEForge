package org.mdeforge.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mdeforge.business.model.serializer.json.ValuedRelationListSerializer;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Cluster implements Serializable {

	/**
	 
	 */
	private static final long serialVersionUID = -2956823730164268028L;
	private int kMax;
	private int kMin;
	private double kAvg;
	@DBRef
	private Set<Artifact> artifacts = new HashSet<Artifact>();
	private Set<String> domains = new HashSet<String>();
	@DBRef
	private Artifact mostRepresentive;
	@JsonSerialize(using = ValuedRelationListSerializer.class)
	private List<ValuedRelation> relations = new ArrayList<ValuedRelation>();
	public int getkMax() {
		return kMax;
	}
	public void setkMax(int kMax) {
		this.kMax = kMax;
	}
	public int getkMin() {
		return kMin;
	}
	public void setkMin(int kMin) {
		this.kMin = kMin;
	}
	public double getkAvg() {
		return kAvg;
	}
	public void setkAvg(double kAvg) {
		this.kAvg = kAvg;
	}
	public Set<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(Set<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	public Set<String> getDomains() {
		return domains;
	}
	public void setDomains(Set<String> domains) {
		this.domains = domains;
	}
	public Artifact getMostRepresentive() {
		return mostRepresentive;
	}
	public void setMostRepresentive(Artifact mostRepresentive) {
		this.mostRepresentive = mostRepresentive;
	}
	public List<ValuedRelation> getRelations() {
		return relations;
	}
	public void setRelations(List<ValuedRelation> relations) {
		this.relations = relations;
	}
}
