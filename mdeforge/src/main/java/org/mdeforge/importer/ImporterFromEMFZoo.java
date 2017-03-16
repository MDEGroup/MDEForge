package org.mdeforge.importer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ImporterFromEMFZoo {
	
	public static void main(String[] args) {
		Document doc;
		String projectUrl = "http://web.emn.fr/x-info/atlanmod/index.php?title=Ecore";
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		try {
			
			doc = Jsoup.connect(projectUrl).timeout(10000).get();
			Element e = doc.getElementById("content");
			Elements es = e.getAllElements();
			EcoreMetamodel emm = null;
			boolean enable = false;
			boolean complete = false;
			int count = 0;
			for (Element element : es) {
				if (element.tagName().equals("h3") && !enable)
				{
					if (count!=0)
					{
						enable = true;
						emm = new EcoreMetamodel();
						emm.setOpen(true);
						emm.setName(element.getElementsByTag("span").text());
					}
					count++;
				}
				else if(enable) {
					if (element.tagName().equals("p")) {
						String[] prop = element.text().split(":");
						if(prop.length == 2) {
							Property p = new Property();
							if(prop[0].toLowerCase().contains("description"))
								emm.setDescription(prop[1]);
							p.setName(prop[0].replace(" ", "").replace("", ""));
							p.setValue(prop[1]);
							emm.getProperties().add(p);
						}
					}
					if (element.tagName().equals("li") ) {
						String url = element.getElementsByTag("a").attr("href");
						url = url.replace("http", "https");
						System.out.println(emm.getName() + " _ " + url);
						
						URL url2 = new URL(url);
						URLConnection con = url2.openConnection();
						InputStream in = con.getInputStream();
						String encoding = con.getContentEncoding();
						encoding = encoding == null ? "UTF-8" : encoding;
						String body = IOUtils.toString(in, encoding);
						String file = body;
						GridFileMedia gfm = new GridFileMedia();
						gfm.setFileName(emm.getName().replace(" ", "").replace("%20", "").replace(".", "_")+ ".ecore");
						gfm.setContent(new String(Base64.encodeBase64(file.getBytes())));
						emm.setFile(gfm);
						enable = false;
						complete = true;
					}
				}
				if(complete) {
					try {
						complete = false;
						emm.setAuthor(usr);
						
						if((!emm.getName().equals("Measure 2.0")) && 
								(!emm.getName().equals("Requirement 1.0")) && 
								(!emm.getName().equals("Multilevel Healthcare Information Modelling 2.0")))
							ecoreMetamodelService.create(emm);
					} catch (Exception e1) {
						System.err.println("ERROR: Some error at " + projectUrl + ". Importer exception:" + e1.getMessage());
					}
				}
				
			}
			System.out.println("count: " + count);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: Unable to connect at " + projectUrl + "Importer exception:" + e1.getMessage());
		} catch (Exception e2) {
			System.err.println("ERROR: Some error at " + projectUrl + ". Importer exception:" + e2.getMessage());
		}
		((ConfigurableApplicationContext)context).close();
	}
}
