/**
 */
package org.mdeforge.emf.metric.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.mdeforge.emf.metric.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricFactoryImpl extends EFactoryImpl implements MetricFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetricFactory init() {
		try {
			MetricFactory theMetricFactory = (MetricFactory)EPackage.Registry.INSTANCE.getEFactory(MetricPackage.eNS_URI);
			if (theMetricFactory != null) {
				return theMetricFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetricFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetricPackage.CONTAINER: return createContainer();
			case MetricPackage.AGGREGATED_INTEGER_METRIC: return createAggregatedIntegerMetric();
			case MetricPackage.AGGREGATED_REAL_METRIC: return createAggregatedRealMetric();
			case MetricPackage.SIMPLE_METRIC: return createSimpleMetric();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.mdeforge.emf.metric.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedIntegerMetric createAggregatedIntegerMetric() {
		AggregatedIntegerMetricImpl aggregatedIntegerMetric = new AggregatedIntegerMetricImpl();
		return aggregatedIntegerMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedRealMetric createAggregatedRealMetric() {
		AggregatedRealMetricImpl aggregatedRealMetric = new AggregatedRealMetricImpl();
		return aggregatedRealMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleMetric createSimpleMetric() {
		SimpleMetricImpl simpleMetric = new SimpleMetricImpl();
		return simpleMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricPackage getMetricPackage() {
		return (MetricPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetricPackage getPackage() {
		return MetricPackage.eINSTANCE;
	}

} //MetricFactoryImpl
