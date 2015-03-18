/**
 */
package org.mdeforge.emf.metric;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.mdeforge.emf.metric.Container#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.mdeforge.emf.metric.MetricPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' reference list.
	 * The list contents are of type {@link org.mdeforge.emf.metric.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' reference list.
	 * @see org.mdeforge.emf.metric.MetricPackage#getContainer_Metrics()
	 * @model
	 * @generated
	 */
	EList<Metric> getMetrics();

} // Container
