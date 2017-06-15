package org.mdeforge.business.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
	public  String getNameFromPath(String path) {
		Path p = Paths.get(path);
		String file = p.getFileName().toString();
		return file;

	}

}
