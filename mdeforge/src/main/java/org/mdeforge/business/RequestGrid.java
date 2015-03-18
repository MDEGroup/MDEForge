package org.mdeforge.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class RequestGrid implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550585912754726435L;
	public static final String SEARCH_SEPARATOR = "|";
	private Integer iDisplayStart;
	private Integer iDisplayLength;
	private String sEcho;
	private String sSearch;
	private String aSearchValues;
	private String aSearchNames;
	private String sortCol;
	private String sortDir;
	private String sRangeSeparator;
	private List<SearchField> addedFilters;
	private boolean addPercentPrefix = false;

	public RequestGrid() {
		super();
		this.addedFilters = new ArrayList<SearchField>();
	}

	public RequestGrid(Integer iDisplayStart, Integer iDisplayLength, String sEcho, String sSearch, String sortCol, String sortDir, String aSearchNames, String aSearchValues, String sRangeSeparator) {
		super();
		this.iDisplayStart = iDisplayStart;
		this.iDisplayLength = iDisplayLength;
		this.sEcho = sEcho;
		this.sSearch = sSearch;
		this.sortCol = sortCol;
		this.sortDir = sortDir;
		this.aSearchNames = aSearchNames;
		this.aSearchValues = aSearchValues;
		this.sRangeSeparator = sRangeSeparator;

	}

	public String getaSearchValues() {
		return aSearchValues;
	}

	public void setaSearchValues(String aSearchValues) {
		this.aSearchValues = aSearchValues;
	}

	public void setaSearchNames(String aSearchNames) {
		this.aSearchNames = aSearchNames;
	}

	public String getaSearchNames() {
		return aSearchNames;
	}

	public List<SearchField> getSearchFields() {
		return createSearchFieldList(aSearchNames, aSearchValues, addedFilters);
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public String getSortCol() {
		return sortCol;
	}

	public void setSortCol(String sortCol) {
		this.sortCol = sortCol;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public void addFilter(String nome, String valore) {
		addFilter(nome, valore, SearchField.NullType.NO_NULL);
	}

	public void addFilter(String nome, SearchField.NullType nullType) {
		addFilter(nome, "", nullType);
	}

	public void addFilter(String nome, String valore, SearchField.NullType nullType) {
		SearchField sf = new SearchField(nome);
		sf.setNullType(nullType);
		sf.setValue(valore);
		sf.setRangeType(SearchField.RangeType.RANGE_NONE);
		addFilter(sf);

	}

	public void addFilter(SearchField sf) {
		addedFilters.add(sf);
	}

	public void addFilter(String nome, String[] valori) {
		SearchField sf = new SearchField(nome);
		sf.setNullType(SearchField.NullType.NO_NULL);
		if (valori.length > 1) {
			sf.setValue(StringUtils.arrayToDelimitedString(valori, SearchField.MULTIPLE_VALUE_SEPARATOR));
			sf.setRangeType(SearchField.RangeType.RANGE_IN);
		} else {
			sf.setValue(valori[0]);
			sf.setRangeType(SearchField.RangeType.RANGE_NONE);
		}
		addedFilters.add(sf);
	}

	public String getsRangeSeparator() {
		return sRangeSeparator;
	}

	public void setsRangeSeparator(String sRangeSeparator) {
		this.sRangeSeparator = sRangeSeparator;
	}

	private String getRangeValue(String value, int index) {
		String[] aRangeVals = value.split("\\".concat(getsRangeSeparator()));
		if (aRangeVals.length > index) {
			return aRangeVals[index];
		}
		return null;
	}

	public boolean isRangeValue(String value) {
		return value != null && value.contains(getsRangeSeparator());
	}

	private List<SearchField> createSearchFieldList(String aSearchNames, String aSearchValues, List<SearchField> addedFilters) {
		String[] values, names;
		List<SearchField> res = new ArrayList<SearchField>();
		values = StringUtils.delimitedListToStringArray(aSearchValues, SEARCH_SEPARATOR);
		names = StringUtils.delimitedListToStringArray(aSearchNames, SEARCH_SEPARATOR);
		int i = 0;
		for (String name : names) {
			String val = values[i];
			if (name.startsWith("json_")) {
				String temp = name.substring(5);
				name = temp.replace("_", ".");
			}
			if (isRangeValue(val)) {
				SearchField sfFrom = new SearchField(name);
				SearchField sfTo = new SearchField(name);
				sfFrom.setValue(getRangeValue(val, 0));
				sfFrom.setRangeType(SearchField.RangeType.RANGE_FROM);
				sfFrom.setNullType(SearchField.NullType.NO_NULL);
				sfTo.setValue(getRangeValue(val, 1));
				sfTo.setRangeType(SearchField.RangeType.RANGE_TO);
				sfTo.setNullType(SearchField.NullType.NO_NULL);
				res.add(sfFrom);
				res.add(sfTo);
			} else {
				SearchField sf = new SearchField(name);
				sf.setRangeType(SearchField.RangeType.RANGE_NONE);
				sf.setValue(val);
				sf.setNullType(SearchField.NullType.NO_NULL);
				sf.setAddPercentPrefix(true);
				res.add(sf);
			}
			i++;
		}
		res.addAll(addedFilters);
		return res;
	}

	public void addPrefixToProtocollo(String protocoloName) {
		String[] names = StringUtils.delimitedListToStringArray(this.getaSearchNames(), RequestGrid.SEARCH_SEPARATOR);
		String[] values = StringUtils.delimitedListToStringArray(this.getaSearchValues(), RequestGrid.SEARCH_SEPARATOR);
		StringBuilder newNames = new StringBuilder();
		StringBuilder newValues = new StringBuilder();
		String protocolloNormValue = null;
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			if (!protocoloName.equals(name)) {
				newNames.append(name);
				newValues.append(values[i]);
				if (i < (names.length - 1)) {
					newNames.append(RequestGrid.SEARCH_SEPARATOR);
					newValues.append(RequestGrid.SEARCH_SEPARATOR);
				}
			} else {
				protocolloNormValue = values[i];
			}
		}

		this.setaSearchNames(newNames.toString());
		this.setaSearchValues(newValues.toString());
		SearchField sf = new SearchField(protocoloName);
		sf.setNullType(SearchField.NullType.NO_NULL);
		sf.setValue(protocolloNormValue);
		sf.setRangeType(SearchField.RangeType.RANGE_NONE);
		if (isAddPercentPrefix()) {
			sf.setAddPercentPrefix(true);
		}
		this.addFilter(sf);

	}

	public boolean isAddPercentPrefix() {
		return addPercentPrefix;
	}

	public void setAddPercentPrefix(boolean addPercentPrefix) {
		this.addPercentPrefix = addPercentPrefix;
	}
}
