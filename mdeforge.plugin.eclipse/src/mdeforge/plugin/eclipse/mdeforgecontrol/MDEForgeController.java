package mdeforge.plugin.eclipse.mdeforgecontrol;

public abstract class MDEForgeController {
	protected static String link, user, pass;
	
	public MDEForgeController(String link, String user, String pass){
		this.link = link;
		this.user = user;
		this.pass = pass;
		}

}
