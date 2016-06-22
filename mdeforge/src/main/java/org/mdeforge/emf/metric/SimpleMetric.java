/**
 */
package org.mdeforge.emf.metric;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mdeforge.emf.metric.SimpleMetric#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.mdeforge.emf.metric.MetricPackage#getSimpleMetric()
 * @model
 * @generated
 */
public interface SimpleMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.mdeforge.emf.metric.MetricPackage#getSimpleMetric_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.mdeforge.emf.metric.SimpleMetric#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // SimpleMetric
