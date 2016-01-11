package org.mdeforge.business.model.importer;

public class GitHubRate
{
    private Resources resources;

    private Rate rate;

    public Resources getResources ()
    {
        return resources;
    }

    public void setResources (Resources resources)
    {
        this.resources = resources;
    }

    public Rate getRate ()
    {
        return rate;
    }

    public void setRate (Rate rate)
    {
        this.rate = rate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [resources = "+resources+", rate = "+rate+"]";
    }
}
