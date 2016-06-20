package org.mdeforge.business.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
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

public class WeightedResourceSerializer {
	
	private static String annotationUri = "http://mdeforge.com/annotations";
	private static String annotationName = "weight";
	
	public static WeightedContents serialize(Resource resource) throws BusinessException {
		WeightedContents wc = new WeightedContents();

		final EList<EObject> contents = resource.getContents();

		if (contents.size() == 1) {
			try {
				wc = serialize(wc, contents.get(0));
			} catch (IOException e) {
				throw new BusinessException();
			}
		} else {
			for (final EObject current : contents) {
				try {
					wc = serialize(wc, current);
				} catch (IOException e) {
					throw new BusinessException();
				}
			}
		}
		
		wc.setWeightedContentsThree(Tokenizer.tokenizeString(wc.getWeightedContentsThree()));
		wc.setWeightedContentsTwo(Tokenizer.tokenizeString(wc.getWeightedContentsTwo()));
		wc.setWeightedContentsOne(Tokenizer.tokenizeString(wc.getWeightedContentsOne()));
		wc.setDefaultContents(Tokenizer.tokenizeString(wc.getDefaultContents()));

		return wc;
	}
	/*
	 * DA VEDERE COME ESEMPIO
	 */
	public static WeightedContents serialize(WeightedContents wc, EObject object)
			throws IOException {
		final EClass eClass = object.eClass();
		final List<EAttribute> attributes = eClass.getEAllAttributes();
		final List<EReference> references = eClass.getEAllReferences();
		
		String classWeight = getAnnotation(eClass);

		for (final EAttribute attribute : attributes) {
			if (EObjects.isCandidate(object, attribute)) {
				final String key = attribute.getName();
				final Object value = object.eGet(attribute);
				
				String attributeWeight = getAnnotation(attribute);
				
				if (classWeight != null && attributeWeight == null) {
					setAnnotation(attribute, classWeight);
				}

				if (EObjects.isFeatureMap(attribute)) {
					wc = serializeFeatureMap(wc, attribute, object);
				} else {
					wc = serializeValues(wc, key, attribute, value);
				}
			}
		}

		for (final EReference reference : references) {
			if (EObjects.isCandidate(object, reference)) {
				final Object value = object.eGet(reference);
				final String key = reference.getName();
				
//				String referenceWeight = getAnnotation(reference);
//				
//				if (classWeight != null && referenceWeight == null) {
//					setAnnotation(reference, classWeight);
//				}

				if (EObjects.isMapEntry(reference.getEReferenceType())) {
					wc = serializeMapEntry(wc, key, reference, value);
				} else if (!reference.isContainment()) {
					// don't take care about references which are not
					// containment
				} else {
					wc = serializeContainment(wc, key, reference, object, value);
				}
			}
		}

		return wc;
	}

	private static WeightedContents serializeMapEntry(WeightedContents wc, String key,
			EReference reference, Object value) throws IOException {
		String weight = getAnnotation(reference);
		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Map.Entry<String, String>> entries = (Collection<Entry<String, String>>) value;

			for (Map.Entry<String, String> entry : entries) {
				wc.addContent(entry.getKey(), weight);
				wc.addContent(entry.getValue(), weight);
			}
		} else {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> entry = (Entry<String, String>) value;
			wc.addContent(entry.getKey(), weight);
			wc.addContent(entry.getValue(), weight);
		}

		return wc;
	}

	private static WeightedContents serializeFeatureMap(WeightedContents wc,
			EAttribute attribute, EObject owner) throws IOException {
		final Set<EStructuralFeature> features = EObjects.featureMaps(owner,
				attribute);

		for (EStructuralFeature feature : features) {
			final Object value = owner.eGet(feature);
			final String key = feature.getName();

			if (feature instanceof EAttribute) {
				wc = serializeValues(wc, key, (EAttribute) feature, value);
			} else {
				final EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					wc = serializeContainment(wc, key,
							reference, owner, value);
				} else {
					// don't take care about references which are not
					// containment
				}
			}
		}

		return wc;
	}

	private static WeightedContents serializeContainment(WeightedContents wc,
			String key, EReference containment, EObject owner, Object value)
			throws IOException {
		if (containment.isMany()) {
			final Collection<?> values = (Collection<?>) value;

			for (Object current : values) {
				EObject target = (EObject) current;
				EClass targetClass = target.eClass();
				
				String contaimentWeight = getAnnotation(containment);
				String targetWeight = getAnnotation(targetClass);
				
				if (contaimentWeight != null && targetWeight == null) {
					setAnnotation(targetClass, contaimentWeight);
				}

				if (EObjects.isContainmentProxy(owner, target)) {
					// don't take care about references which are not
					// containment
				} else {
					wc = serialize(wc, target);
				}
			}
		} else {

			if (EObjects.isContainmentProxy(owner, (EObject) value)) {
				// don't take care about references which are not containment
			} else {

				String contaimentWeight = getAnnotation(containment);
				EClass referencedClass = ((EObject) value).eClass();
				String referenceWeight = getAnnotation(referencedClass);
				
				if (contaimentWeight != null && referenceWeight == null) {
					setAnnotation(referencedClass, contaimentWeight);
				}
				wc = serialize(wc, (EObject) value);
			}
		}

		return wc;
	}
	
	public static WeightedContents serializeValues(WeightedContents wc, String key, EAttribute attribute, Object value) {
		String weight = getAnnotation(attribute);
		final EDataType type = attribute.getEAttributeType();

		if (attribute.isMany()) {
			wc = serializeMany(wc, key, type, (Collection<?>) value, weight);
		} else {
			wc = serializeValue(wc, key, type, value, weight);
		}
		
		return wc;
	}

	public static WeightedContents serializeMany(WeightedContents wc, String key, EDataType type, Collection<?> values, String weight) {
		try {
			for (Object value: values) {
				wc = writeValue(wc, type, value, weight);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wc;
	}

	public static WeightedContents serializeValue(WeightedContents wc, String key, EDataType type, Object value, String weight) {
		try {
			wc = writeValue(wc, type, value, weight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wc;
	}

	private static WeightedContents writeValue(WeightedContents wc, EDataType type, Object value, String weight) throws IOException {
		if (value instanceof String) {
			wc.addContent((String) value, weight);
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

		return wc;
	}
	
	private static String getAnnotation(EModelElement eModelElement) {
		return EcoreUtil.getAnnotation(eModelElement, annotationUri, annotationName);
	}
	
	private static void setAnnotation(EModelElement eModelElement, String value) {
		EcoreUtil.setAnnotation(eModelElement, annotationUri, annotationName, value);
	}
}
