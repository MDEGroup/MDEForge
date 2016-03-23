package org.mdeforge.business.search;

import java.util.ArrayList;
import java.util.Arrays;

public class Tokenizer {
	
	public static String tokenizeString(String string) {
		String result = "";
		if(string!=null && string!="")
		{
			string = string.trim();
			// split first for empty spaces
			for (String s : string.split(" "))
				// then avoid the single char and the uri
				if (s.length()>1 && !s.matches("^(https?|file|ftp)?:///?.*"))
					// then split for any special character which is not alphanumeric
					for (String s2 : s.split("([^a-zA-Z0-9])"))
						if (isSignificant(s2))
						{// if s2 is a CamelCase string save the original and then save the substrings
							result += s2.toLowerCase() + " ";
							String[] stringArray = s2.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
							for (String s3 : stringArray)
								if (stringArray.length>1 && isSignificant(s3))
									result += s3.toLowerCase() + " ";
						}
		}
		return result;
	}
	
	private static boolean isSignificant(String s){
		String[] sa = {"name", "type", "null"};
		ArrayList<String> stringArray = new ArrayList<String>(Arrays.asList(sa));
		
		if (s.length()>1 && !stringArray.contains(s))
			return true;
		
		return false;
	}
}
