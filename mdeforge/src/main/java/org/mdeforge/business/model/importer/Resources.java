package org.mdeforge.business.model.importer;

public class Resources
{
    private Search search;

    private Core core;

    public Search getSearch ()
    {
        return search;
    }

    public void setSearch (Search search)
    {
        this.search = search;
    }

    public Core getCore ()
    {
        return core;
    }

    public void setCore (Core core)
    {
        this.core = core;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [search = "+search+", core = "+core+"]";
    }
}