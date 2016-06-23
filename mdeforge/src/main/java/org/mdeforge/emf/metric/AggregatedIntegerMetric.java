/**
 */
package org.mdeforge.emf.metric;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Integer Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMedian <em>Median</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getAverage <em>Average</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getStandardDeviation <em>Standard Deviation</em>}</li>
 * </ul>
 *
 * @see org.mdeforge.emf.metric.MetricPackage#getAggregatedIntegerMetric()
 * @model
 * @generated
 */
public interface AggregatedIntegerMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(Integer)
	 * @see org.mdeforge.emf.metric.MetricPackage#getAggregatedIntegerMetric_Minimum()
	 * @model
	 * @generated
	 */
	Integer getMinimum();

	/**
	 * Sets the value of the '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(Integer value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(Integer)
	 * @see org.mdeforge.emf.metric.MetricPackage#getAggregatedIntegerMetric_Maximum()
	 * @model
	 * @generated
	 */
	Integer getMaximum();

	/**
	 * Sets the value of the '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(Integer value);

	/**
	 * Returns the value of the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Median</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Median</em>' attribute.
	 * @see #setMedian(Integer)
	 * @see org.mdeforge.emf.metric.MetricPackage#getAggregatedIntegerMetric_Median()
	 * @model
	 * @generated
	 */
	Integer getMedian();

	/**
	 * Sets the value of the '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getMedian <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Median</em>' attribute.
	 * @see #getMedian()
	 * @generated
	 */
	void setMedian(Integer value);

	/**
	 * Returns the value of the '<em><b>Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Average</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Average</em>' attribute.
	 * @see #setAverage(float)
	 * @see org.mdeforge.emf.metric.MetricPackage#getAggregatedIntegerMetric_Average()
	 * @model
	 * @generated
	 */
	float getAverage();

	/**
	 * Sets the value of the '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getAverage <em>Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average</em>' attribute.
	 * @see #getAverage()
	 * @generated
	 */
	void setAverage(float value);

	/**
	 * Returns the value of the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Deviation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Deviation</em>' attribute.
	 * @see #setStandardDeviation(float)
	 * @see org.mdeforge.emf.metric.MetricPackage#getAggregatedIntegerMetric_StandardDeviation()
	 * @model
	 * @generated
	 */
	float getStandardDeviation();

	/**
	 * Sets the value of the '{@link org.mdeforge.emf.metric.AggregatedIntegerMetric#getStandardDeviation <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Deviation</em>' attribute.
	 * @see #getStandardDeviation()
	 * @generated
	 */
	void setStandardDeviation(float value);

} // AggregatedIntegerMetric
