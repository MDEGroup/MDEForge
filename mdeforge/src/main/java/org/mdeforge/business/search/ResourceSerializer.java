package org.mdeforge.business.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.EObjects;
import org.mdeforge.business.BusinessException;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class ResourceSerializer {

	public static String serialize(Resource resource) throws BusinessException {
		String contentsString = "";

		final EList<EObject> contents = resource.getContents();

		if (contents.size() == 1) {
			try {
				contentsString = serialize(contentsString, contents.get(0));
			} catch (IOException e) {
				throw new BusinessException();
			}
		} else {
			for (final EObject current : contents) {
				try {
					contentsString = serialize(contentsString, current);
				} catch (IOException e) {
					throw new BusinessException();
				}
			}
		}

		return Tokenizer.tokenizeString(contentsString);
	}

	public static String serialize(String contentsString, EObject object)
			throws IOException {
		final EClass eClass = object.eClass();
		
		final List<EAttribute> attributes = eClass.getEAllAttributes();
		final List<EReference> references = eClass.getEAllReferences();

		for (final EAttribute attribute : attributes) {
			if (EObjects.isCandidate(object, attribute)) {
				final String key = attribute.getName();
				final Object value = object.eGet(attribute);

				if (EObjects.isFeatureMap(attribute)) {
					contentsString = serializeFeatureMap(contentsString,
							attribute, object);
				} else {
					contentsString = serializeValues(contentsString, key,
							attribute, value);
				}
			}
		}

		for (final EReference reference : references) {
			if (EObjects.isCandidate(object, reference)) {
				final Object value = object.eGet(reference);
				final String key = reference.getName();

				if (EObjects.isMapEntry(reference.getEReferenceType())) {
					contentsString = serializeMapEntry(contentsString, key,
							reference, value);
				} else if (!reference.isContainment()) {
					// don't take care about references which are not
					// containment
				} else {
					contentsString = serializeContainment(contentsString, key,
							reference, object, value);
				}
			}
		}

		return contentsString;
	}

	private static String serializeMapEntry(String contentsString, String key,
			EReference reference, Object value) throws IOException {
		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Map.Entry<String, String>> entries = (Collection<Entry<String, String>>) value;

			for (Map.Entry<String, String> entry : entries) {
				contentsString += entry.getKey() + " ";
				contentsString += entry.getValue() + " ";
			}
		} else {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> entry = (Entry<String, String>) value;
			contentsString += entry.getKey() + " ";
			contentsString += entry.getValue() + " ";
		}

		return contentsString;
	}

	private static String serializeFeatureMap(String contentsString,
			EAttribute attribute, EObject owner) throws IOException {
		final Set<EStructuralFeature> features = EObjects.featureMaps(owner,
				attribute);

		for (EStructuralFeature feature : features) {
			final Object value = owner.eGet(feature);
			final String key = feature.getName();

			if (feature instanceof EAttribute) {
				contentsString = serializeValues(contentsString, key,
						(EAttribute) feature, value);
			} else {
				final EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					contentsString = serializeContainment(contentsString, key,
							reference, owner, value);
				} else {
					// don't take care about references which are not
					// containment
				}
			}
		}

		return contentsString;
	}

	private static String serializeContainment(String contentsString,
			String key, EReference containment, EObject owner, Object value)
			throws IOException {
		if (containment.isMany()) {
			final Collection<?> values = (Collection<?>) value;

			for (Object current : values) {
				EObject target = (EObject) current;

				if (EObjects.isContainmentProxy(owner, target)) {
					// don't take care about references which are not
					// containment
				} else {
					contentsString = serialize(contentsString, target);
				}
			}
		} else {

			if (EObjects.isContainmentProxy(owner, (EObject) value)) {
				// don't take care about references which are not containment
			} else {
				contentsString = serialize(contentsString, (EObject) value);
			}
		}

		return contentsString;
	}

	/**
	 * Prints the names of classes, attributes, references, enums, enum
	 * literals, and datatypes in a package.
	 */
	public static void printPackage(EPackage ePackage) {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			System.out.println(classifier.getName());
			System.out.print("  ");

			if (classifier instanceof EClass) {
				EClass eClass = (EClass) classifier;
				for (EAttribute attribute : eClass.getEAttributes()) {
					System.out.print(attribute.getName() + " ");
				}
				if (!eClass.getEAttributes().isEmpty()
						&& !eClass.getEReferences().isEmpty()) {
					System.out.println();
					System.out.print("  ");
				}
				for (EReference reference : eClass.getEReferences()) {
					System.out.print(reference.getName() + " ");
				}
			} else if (classifier instanceof EEnum) {
				EEnum eEnum = (EEnum) classifier;
				for (EEnumLiteral literal : eEnum.getELiterals()) {
					System.out.print(literal.getName() + " ");
				}
			} else if (classifier instanceof EDataType) {
				EDataType eDataType = (EDataType) classifier;
				System.out.print(eDataType.getInstanceClassName());
			}
			System.out.println();
		}
	}
	
	// ==========================================================================
	public static String serializeValues(String contentsString, String key, EAttribute attribute, Object value) {
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
			contentsString += " " + value;
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
}
