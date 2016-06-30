package org.mdeforge.business.model.form;

import java.util.List;

public class SearchResultComplete {
	
	private long searchTime;
	private String queryString;
	private int totalHits;
	private int hitsPerPage;
	private int pageNumber;
	private int pages;
	private List<SearchResult> results;
	
	
	public long getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(long searchTime) {
		this.searchTime = searchTime;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public int getTotalHits() {
		return totalHits;
	}
	public void setTotalHits(int totalHits) {
		this.totalHits = totalHits;
	}
	public int getHitsPerPage() {
		return hitsPerPage;
	}
	public void setHitsPerPage(int hitsPerPage) {
		this.hitsPerPage = hitsPerPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<SearchResult> getResults() {
		return results;
	}
	public void setResults(List<SearchResult> results) {
		this.results = results;
	}
	
	
	
	

}
