package org.mdeforge.business.importer;


public class SearchCodeResult {
	private String incomplete_results;

    private Content[] items;

    private String total_count;

    public String getIncomplete_results ()
    {
        return incomplete_results;
    }

    public void setIncomplete_results (String incomplete_results)
    {
        this.incomplete_results = incomplete_results;
    }

    public Content[] getItems ()
    {
        return items;
    }

    public void setItems (Content[] contents)
    {
        this.items = contents;
    }

    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }
}
