package org.mdeforge.business.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {
	public String getNameFromPath(String path) {
		Path p = Paths.get(path);
		String file = p.getFileName().toString();
		return file;

	}

	public Boolean createPath(String path) {
		boolean result = false;
		File theDir = new File(path);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				System.out.println("DIR not create");
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
		return result;
	}
	
	public String createDate (String format){
		Calendar date = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String myDate=sdf.format(date.getTime());
//		"yyyyMMdd_HHmmss"
		
		return myDate;
	}
	

}
