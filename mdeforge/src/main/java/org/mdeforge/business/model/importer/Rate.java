package org.mdeforge.business.model.importer;

public class Rate
{
    private String limit;

    private String remaining;

    private String reset;

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getRemaining ()
    {
        return remaining;
    }

    public void setRemaining (String remaining)
    {
        this.remaining = remaining;
    }

    public String getReset ()
    {
        return reset;
    }

    public void setReset (String reset)
    {
        this.reset = reset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [limit = "+limit+", remaining = "+remaining+", reset = "+reset+"]";
    }
}
