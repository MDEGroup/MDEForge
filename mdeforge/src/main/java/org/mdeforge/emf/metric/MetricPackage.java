/**
 */
package org.mdeforge.emf.metric;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.mdeforge.emf.metric.MetricFactory
 * @model kind="package"
 * @generated
 */
public interface MetricPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metric";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.mdeforge.emf.metric";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metrics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricPackage eINSTANCE = org.mdeforge.emf.metric.impl.MetricPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.mdeforge.emf.metric.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.mdeforge.emf.metric.impl.ContainerImpl
	 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__METRICS = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.mdeforge.emf.metric.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.mdeforge.emf.metric.impl.MetricImpl
	 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__CODE = 2;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl <em>Aggregated Integer Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl
	 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getAggregatedIntegerMetric()
	 * @generated
	 */
	int AGGREGATED_INTEGER_METRIC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__DESCRIPTION = METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__CODE = METRIC__CODE;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__MINIMUM = METRIC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__MAXIMUM = METRIC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__MEDIAN = METRIC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__AVERAGE = METRIC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC__STANDARD_DEVIATION = METRIC_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Aggregated Integer Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Aggregated Integer Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_INTEGER_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl <em>Aggregated Real Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl
	 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getAggregatedRealMetric()
	 * @generated
	 */
	int AGGREGATED_REAL_METRIC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__DESCRIPTION = METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__CODE = METRIC__CODE;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__MINIMUM = METRIC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__MAXIMUM = METRIC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__MEDIAN = METRIC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__AVERAGE = METRIC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC__STANDARD_DEVIATION = METRIC_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Aggregated Real Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Aggregated Real Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_REAL_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.mdeforge.emf.metric.impl.SimpleMetricImpl <em>Simple Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.mdeforge.emf.metric.impl.SimpleMetricImpl
	 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getSimpleMetric()
	 * @generated
	 */
	int SIMPLE_METRIC = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_METRIC__DESCRIPTION = METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_METRIC__CODE = METRIC__CODE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_METRIC__VALUE = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Simple Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.mdeforge.emf.metric.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.mdeforge.emf.metric.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.mdeforge.emf.metric.Container#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see org.mdeforge.emf.metric.Container#getMetrics()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Metrics();

	/**
	 * Returns the meta object for class '{@link org.mdeforge.emf.metric.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see org.mdeforge.emf.metric.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.mdeforge.emf.metric.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.Metric#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.mdeforge.emf.metric.Metric#getDescription()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.Metric#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.mdeforge.emf.metric.Metric#getCode()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Code();

	/**
	 * Returns the meta object for class '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric <em>Aggregated Integer Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Integer Metric</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedIntegerMetric
	 * @generated
	 */
	EClass getAggregatedIntegerMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedIntegerMetric#getMinimum()
	 * @see #getAggregatedIntegerMetric()
	 * @generated
	 */
	EAttribute getAggregatedIntegerMetric_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedIntegerMetric#getMaximum()
	 * @see #getAggregatedIntegerMetric()
	 * @generated
	 */
	EAttribute getAggregatedIntegerMetric_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMedian <em>Median</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Median</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedIntegerMetric#getMedian()
	 * @see #getAggregatedIntegerMetric()
	 * @generated
	 */
	EAttribute getAggregatedIntegerMetric_Median();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getAverage <em>Average</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedIntegerMetric#getAverage()
	 * @see #getAggregatedIntegerMetric()
	 * @generated
	 */
	EAttribute getAggregatedIntegerMetric_Average();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getStandardDeviation <em>Standard Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard Deviation</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedIntegerMetric#getStandardDeviation()
	 * @see #getAggregatedIntegerMetric()
	 * @generated
	 */
	EAttribute getAggregatedIntegerMetric_StandardDeviation();

	/**
	 * Returns the meta object for class '{@link org.mdeforge.emf.metric.AggregatedRealMetric <em>Aggregated Real Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Real Metric</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedRealMetric
	 * @generated
	 */
	EClass getAggregatedRealMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedRealMetric#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedRealMetric#getMinimum()
	 * @see #getAggregatedRealMetric()
	 * @generated
	 */
	EAttribute getAggregatedRealMetric_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedRealMetric#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedRealMetric#getMaximum()
	 * @see #getAggregatedRealMetric()
	 * @generated
	 */
	EAttribute getAggregatedRealMetric_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedRealMetric#getMedian <em>Median</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Median</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedRealMetric#getMedian()
	 * @see #getAggregatedRealMetric()
	 * @generated
	 */
	EAttribute getAggregatedRealMetric_Median();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedRealMetric#getAverage <em>Average</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedRealMetric#getAverage()
	 * @see #getAggregatedRealMetric()
	 * @generated
	 */
	EAttribute getAggregatedRealMetric_Average();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.AggregatedRealMetric#getStandardDeviation <em>Standard Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard Deviation</em>'.
	 * @see org.mdeforge.emf.metric.AggregatedRealMetric#getStandardDeviation()
	 * @see #getAggregatedRealMetric()
	 * @generated
	 */
	EAttribute getAggregatedRealMetric_StandardDeviation();

	/**
	 * Returns the meta object for class '{@link org.mdeforge.emf.metric.SimpleMetric <em>Simple Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Metric</em>'.
	 * @see org.mdeforge.emf.metric.SimpleMetric
	 * @generated
	 */
	EClass getSimpleMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.mdeforge.emf.metric.SimpleMetric#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.mdeforge.emf.metric.SimpleMetric#getValue()
	 * @see #getSimpleMetric()
	 * @generated
	 */
	EAttribute getSimpleMetric_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetricFactory getMetricFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.mdeforge.emf.metric.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.mdeforge.emf.metric.impl.ContainerImpl
		 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__METRICS = eINSTANCE.getContainer_Metrics();

		/**
		 * The meta object literal for the '{@link org.mdeforge.emf.metric.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.mdeforge.emf.metric.impl.MetricImpl
		 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__DESCRIPTION = eINSTANCE.getMetric_Description();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__CODE = eINSTANCE.getMetric_Code();

		/**
		 * The meta object literal for the '{@link org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl <em>Aggregated Integer Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl
		 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getAggregatedIntegerMetric()
		 * @generated
		 */
		EClass AGGREGATED_INTEGER_METRIC = eINSTANCE.getAggregatedIntegerMetric();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_INTEGER_METRIC__MINIMUM = eINSTANCE.getAggregatedIntegerMetric_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_INTEGER_METRIC__MAXIMUM = eINSTANCE.getAggregatedIntegerMetric_Maximum();

		/**
		 * The meta object literal for the '<em><b>Median</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_INTEGER_METRIC__MEDIAN = eINSTANCE.getAggregatedIntegerMetric_Median();

		/**
		 * The meta object literal for the '<em><b>Average</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_INTEGER_METRIC__AVERAGE = eINSTANCE.getAggregatedIntegerMetric_Average();

		/**
		 * The meta object literal for the '<em><b>Standard Deviation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_INTEGER_METRIC__STANDARD_DEVIATION = eINSTANCE.getAggregatedIntegerMetric_StandardDeviation();

		/**
		 * The meta object literal for the '{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl <em>Aggregated Real Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl
		 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getAggregatedRealMetric()
		 * @generated
		 */
		EClass AGGREGATED_REAL_METRIC = eINSTANCE.getAggregatedRealMetric();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_REAL_METRIC__MINIMUM = eINSTANCE.getAggregatedRealMetric_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_REAL_METRIC__MAXIMUM = eINSTANCE.getAggregatedRealMetric_Maximum();

		/**
		 * The meta object literal for the '<em><b>Median</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_REAL_METRIC__MEDIAN = eINSTANCE.getAggregatedRealMetric_Median();

		/**
		 * The meta object literal for the '<em><b>Average</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_REAL_METRIC__AVERAGE = eINSTANCE.getAggregatedRealMetric_Average();

		/**
		 * The meta object literal for the '<em><b>Standard Deviation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_REAL_METRIC__STANDARD_DEVIATION = eINSTANCE.getAggregatedRealMetric_StandardDeviation();

		/**
		 * The meta object literal for the '{@link org.mdeforge.emf.metric.impl.SimpleMetricImpl <em>Simple Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.mdeforge.emf.metric.impl.SimpleMetricImpl
		 * @see org.mdeforge.emf.metric.impl.MetricPackageImpl#getSimpleMetric()
		 * @generated
		 */
		EClass SIMPLE_METRIC = eINSTANCE.getSimpleMetric();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_METRIC__VALUE = eINSTANCE.getSimpleMetric_Value();

	}

} //MetricPackage
