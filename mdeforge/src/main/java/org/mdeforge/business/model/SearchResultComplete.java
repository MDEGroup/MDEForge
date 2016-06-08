package org.mdeforge.business.model;

import java.util.List;

public class SearchResultComplete {
	
	private long searchTime;
	private List<SearchResult> results;
	
	
	public long getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(long searchTime) {
		this.searchTime = searchTime;
	}
	public List<SearchResult> getResults() {
		return results;
	}
	public void setResults(List<SearchResult> results) {
		this.results = results;
	}
	
	

}
