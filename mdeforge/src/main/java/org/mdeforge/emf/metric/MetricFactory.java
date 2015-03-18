/**
 */
package org.mdeforge.emf.metric;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.mdeforge.emf.metric.MetricPackage
 * @generated
 */
public interface MetricFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricFactory eINSTANCE = org.mdeforge.emf.metric.impl.MetricFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container</em>'.
	 * @generated
	 */
	Container createContainer();

	/**
	 * Returns a new object of class '<em>Aggregated Integer Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregated Integer Metric</em>'.
	 * @generated
	 */
	AggregatedIntegerMetric createAggregatedIntegerMetric();

	/**
	 * Returns a new object of class '<em>Aggregated Real Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregated Real Metric</em>'.
	 * @generated
	 */
	AggregatedRealMetric createAggregatedRealMetric();

	/**
	 * Returns a new object of class '<em>Simple Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Metric</em>'.
	 * @generated
	 */
	SimpleMetric createSimpleMetric();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetricPackage getMetricPackage();

} //MetricFactory
