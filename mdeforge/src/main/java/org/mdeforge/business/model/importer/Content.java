package org.mdeforge.business.model.importer;

import org.eclipse.egit.github.core.Repository;

public class Content {
	private String html_url;

    private Repository repository;

    private String sha;

    private String name;

    private String score;

    private String path;

    private String git_url;

    private String url;

    public String getHtml_url ()
    {
        return html_url;
    }

    public void setHtml_url (String html_url)
    {
        this.html_url = html_url;
    }

    public Repository getRepository ()
    {
        return repository;
    }

    public void setRepository (Repository repository)
    {
        this.repository = repository;
    }

    public String getSha ()
    {
        return sha;
    }

    public void setSha (String sha)
    {
        this.sha = sha;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getPath ()
    {
        return path;
    }

    public void setPath (String path)
    {
        this.path = path;
    }

    public String getGit_url ()
    {
        return git_url;
    }

    public void setGit_url (String git_url)
    {
        this.git_url = git_url;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [html_url = "+html_url+", repository = "+repository+", sha = "+sha+", name = "+name+", score = "+score+", path = "+path+", git_url = "+git_url+", url = "+url+"]";
    }
}
