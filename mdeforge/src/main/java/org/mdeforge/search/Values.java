/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.mdeforge.search;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

public class Values {

	public static String serialize(String contentsString, String key, EAttribute attribute, Object value) {
		final EDataType type = attribute.getEAttributeType();

		if (attribute.isMany()) {
			contentsString = serializeMany(contentsString, key, type, (Collection<?>) value);
		} else {
			contentsString = serializeValue(contentsString, key, type, value);
		}
		
		return contentsString;
	}

	public static String serializeMany(String contentsString, String key, EDataType type, Collection<?> values) {
		try {
			for (Object value: values) {
				contentsString = writeValue(contentsString, type, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contentsString;
	}

	public static String serializeValue(String contentsString, String key, EDataType type, Object value) {
		try {
			contentsString = writeValue(contentsString, type, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contentsString;
	}

	private static String writeValue(String contentsString, EDataType type, Object value) throws IOException {

		if (value instanceof String) {
			contentsString = addContent(contentsString, (String) value);
		}
		else if (value instanceof Integer) {
			
		}
		else if (value instanceof Boolean) {
			
		}
		else if (value instanceof Double) {
			
		}
		else if (value instanceof Long) {
			
		}
		else if (value instanceof Short) {
			
		}
		else if (value instanceof Float) {
			
		}
		else {
			//contentsString = addContent(contentsString, convertToString(type, value));
		}
		
		return contentsString;
	}
	
	public static String addContent(String contentsString, String value){
		if (!(value.equals("name") || value.equals("Name") || value.equals("type") || value.equals("Type") || value.equals("null") || value.equals("NULL"))){
			contentsString += " " + value;
		}
		
		return contentsString;
	}

}
