package org.mdeforge.client;

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
import org.junit.Test;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Property;

import junit.framework.TestCase;

public class Importer extends TestCase {


	private static EcoreMetamodelService ecoreMetamodelService; 
 
	@Test
	public void test() {
		Document doc;
		String projectUrl = "http://www.emn.fr/z-info/atlanmod/index.php/Ecore";
		try {
			ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin	", "test123");
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
							p.setName(prop[0].replace(" ", "").replace("", ""));
							p.setValue(prop[1]);
							emm.getProperties().add(p);
						}
					}
					if (element.tagName().equals("li") ) {
						String url = element.getElementsByTag("a").attr("href");
						System.out.println(url);
						
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
						ecoreMetamodelService.addEcoreMetamodel(emm);
					} catch (Exception e1) {
						System.err.println(emm.getName());
					}
				}
				
			}
			System.out.println("count: " + count);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Unable to connect at " + projectUrl + "Importer exception:" + e1.getMessage());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	}

}
