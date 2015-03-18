/**
 */
package org.mdeforge.emf.metric.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.mdeforge.emf.metric.AggregatedIntegerMetric;
import org.mdeforge.emf.metric.AggregatedRealMetric;
import org.mdeforge.emf.metric.Metric;
import org.mdeforge.emf.metric.MetricFactory;
import org.mdeforge.emf.metric.MetricPackage;
import org.mdeforge.emf.metric.SimpleMetric;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricPackageImpl extends EPackageImpl implements MetricPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatedIntegerMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatedRealMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleMetricEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.mdeforge.emf.metric.MetricPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetricPackageImpl() {
		super(eNS_URI, MetricFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MetricPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetricPackage init() {
		if (isInited) return (MetricPackage)EPackage.Registry.INSTANCE.getEPackage(MetricPackage.eNS_URI);

		// Obtain or create and register package
		MetricPackageImpl theMetricPackage = (MetricPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetricPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetricPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMetricPackage.createPackageContents();

		// Initialize created meta-data
		theMetricPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetricPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetricPackage.eNS_URI, theMetricPackage);
		return theMetricPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Metrics() {
		return (EReference)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Name() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Description() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatedIntegerMetric() {
		return aggregatedIntegerMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedIntegerMetric_Minimum() {
		return (EAttribute)aggregatedIntegerMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedIntegerMetric_Maximum() {
		return (EAttribute)aggregatedIntegerMetricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedIntegerMetric_Median() {
		return (EAttribute)aggregatedIntegerMetricEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedIntegerMetric_Average() {
		return (EAttribute)aggregatedIntegerMetricEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedIntegerMetric_StandardDeviation() {
		return (EAttribute)aggregatedIntegerMetricEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatedRealMetric() {
		return aggregatedRealMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedRealMetric_Minimum() {
		return (EAttribute)aggregatedRealMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedRealMetric_Maximum() {
		return (EAttribute)aggregatedRealMetricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedRealMetric_Median() {
		return (EAttribute)aggregatedRealMetricEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedRealMetric_Average() {
		return (EAttribute)aggregatedRealMetricEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedRealMetric_StandardDeviation() {
		return (EAttribute)aggregatedRealMetricEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleMetric() {
		return simpleMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleMetric_Value() {
		return (EAttribute)simpleMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricFactory getMetricFactory() {
		return (MetricFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		containerEClass = createEClass(CONTAINER);
		createEReference(containerEClass, CONTAINER__METRICS);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__NAME);
		createEAttribute(metricEClass, METRIC__DESCRIPTION);

		aggregatedIntegerMetricEClass = createEClass(AGGREGATED_INTEGER_METRIC);
		createEAttribute(aggregatedIntegerMetricEClass, AGGREGATED_INTEGER_METRIC__MINIMUM);
		createEAttribute(aggregatedIntegerMetricEClass, AGGREGATED_INTEGER_METRIC__MAXIMUM);
		createEAttribute(aggregatedIntegerMetricEClass, AGGREGATED_INTEGER_METRIC__MEDIAN);
		createEAttribute(aggregatedIntegerMetricEClass, AGGREGATED_INTEGER_METRIC__AVERAGE);
		createEAttribute(aggregatedIntegerMetricEClass, AGGREGATED_INTEGER_METRIC__STANDARD_DEVIATION);

		aggregatedRealMetricEClass = createEClass(AGGREGATED_REAL_METRIC);
		createEAttribute(aggregatedRealMetricEClass, AGGREGATED_REAL_METRIC__MINIMUM);
		createEAttribute(aggregatedRealMetricEClass, AGGREGATED_REAL_METRIC__MAXIMUM);
		createEAttribute(aggregatedRealMetricEClass, AGGREGATED_REAL_METRIC__MEDIAN);
		createEAttribute(aggregatedRealMetricEClass, AGGREGATED_REAL_METRIC__AVERAGE);
		createEAttribute(aggregatedRealMetricEClass, AGGREGATED_REAL_METRIC__STANDARD_DEVIATION);

		simpleMetricEClass = createEClass(SIMPLE_METRIC);
		createEAttribute(simpleMetricEClass, SIMPLE_METRIC__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		aggregatedIntegerMetricEClass.getESuperTypes().add(this.getMetric());
		aggregatedRealMetricEClass.getESuperTypes().add(this.getMetric());
		simpleMetricEClass.getESuperTypes().add(this.getMetric());

		// Initialize classes, features, and operations; add parameters
		initEClass(containerEClass, org.mdeforge.emf.metric.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Metrics(), this.getMetric(), null, "metrics", null, 0, -1, org.mdeforge.emf.metric.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Name(), ecorePackage.getEString(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Description(), ecorePackage.getEString(), "description", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregatedIntegerMetricEClass, AggregatedIntegerMetric.class, "AggregatedIntegerMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregatedIntegerMetric_Minimum(), ecorePackage.getEIntegerObject(), "minimum", null, 0, 1, AggregatedIntegerMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedIntegerMetric_Maximum(), ecorePackage.getEIntegerObject(), "maximum", null, 0, 1, AggregatedIntegerMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedIntegerMetric_Median(), ecorePackage.getEIntegerObject(), "median", null, 0, 1, AggregatedIntegerMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedIntegerMetric_Average(), ecorePackage.getEFloat(), "average", null, 0, 1, AggregatedIntegerMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedIntegerMetric_StandardDeviation(), ecorePackage.getEFloat(), "standardDeviation", null, 0, 1, AggregatedIntegerMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregatedRealMetricEClass, AggregatedRealMetric.class, "AggregatedRealMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregatedRealMetric_Minimum(), ecorePackage.getEFloat(), "minimum", null, 0, 1, AggregatedRealMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedRealMetric_Maximum(), ecorePackage.getEFloat(), "maximum", null, 0, 1, AggregatedRealMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedRealMetric_Median(), ecorePackage.getEFloat(), "median", null, 0, 1, AggregatedRealMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedRealMetric_Average(), ecorePackage.getEFloat(), "average", null, 0, 1, AggregatedRealMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregatedRealMetric_StandardDeviation(), ecorePackage.getEFloat(), "standardDeviation", null, 0, 1, AggregatedRealMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleMetricEClass, SimpleMetric.class, "SimpleMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleMetric_Value(), ecorePackage.getEString(), "value", null, 0, 1, SimpleMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// searchable
		createSearchableAnnotations();
	}

	/**
	 * Initializes the annotations for <b>searchable</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSearchableAnnotations() {
		String source = "searchable";	
		addAnnotation
		  (getMetric_Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getMetric_Description(), 
		   source, 
		   new String[] {
		   });
	}

} //MetricPackageImpl
