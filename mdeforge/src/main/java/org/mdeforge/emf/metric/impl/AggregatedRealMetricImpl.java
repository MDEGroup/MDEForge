/**
 */
package org.mdeforge.emf.metric.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.mdeforge.emf.metric.AggregatedRealMetric;
import org.mdeforge.emf.metric.MetricPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Real Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl#getMedian <em>Median</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl#getAverage <em>Average</em>}</li>
 *   <li>{@link org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl#getStandardDeviation <em>Standard Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregatedRealMetricImpl extends MetricImpl implements AggregatedRealMetric {
	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final float MINIMUM_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected float minimum = MINIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final float MAXIMUM_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected float maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMedian() <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedian()
	 * @generated
	 * @ordered
	 */
	protected static final float MEDIAN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMedian() <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedian()
	 * @generated
	 * @ordered
	 */
	protected float median = MEDIAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverage() <em>Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverage()
	 * @generated
	 * @ordered
	 */
	protected static final float AVERAGE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAverage() <em>Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverage()
	 * @generated
	 * @ordered
	 */
	protected float average = AVERAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected static final float STANDARD_DEVIATION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected float standardDeviation = STANDARD_DEVIATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedRealMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricPackage.Literals.AGGREGATED_REAL_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(float newMinimum) {
		float oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.AGGREGATED_REAL_METRIC__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(float newMaximum) {
		float oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.AGGREGATED_REAL_METRIC__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMedian() {
		return median;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMedian(float newMedian) {
		float oldMedian = median;
		median = newMedian;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.AGGREGATED_REAL_METRIC__MEDIAN, oldMedian, median));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAverage() {
		return average;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverage(float newAverage) {
		float oldAverage = average;
		average = newAverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.AGGREGATED_REAL_METRIC__AVERAGE, oldAverage, average));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardDeviation(float newStandardDeviation) {
		float oldStandardDeviation = standardDeviation;
		standardDeviation = newStandardDeviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.AGGREGATED_REAL_METRIC__STANDARD_DEVIATION, oldStandardDeviation, standardDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricPackage.AGGREGATED_REAL_METRIC__MINIMUM:
				return getMinimum();
			case MetricPackage.AGGREGATED_REAL_METRIC__MAXIMUM:
				return getMaximum();
			case MetricPackage.AGGREGATED_REAL_METRIC__MEDIAN:
				return getMedian();
			case MetricPackage.AGGREGATED_REAL_METRIC__AVERAGE:
				return getAverage();
			case MetricPackage.AGGREGATED_REAL_METRIC__STANDARD_DEVIATION:
				return getStandardDeviation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetricPackage.AGGREGATED_REAL_METRIC__MINIMUM:
				setMinimum((Float)newValue);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__MAXIMUM:
				setMaximum((Float)newValue);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__MEDIAN:
				setMedian((Float)newValue);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__AVERAGE:
				setAverage((Float)newValue);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__STANDARD_DEVIATION:
				setStandardDeviation((Float)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetricPackage.AGGREGATED_REAL_METRIC__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__MEDIAN:
				setMedian(MEDIAN_EDEFAULT);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__AVERAGE:
				setAverage(AVERAGE_EDEFAULT);
				return;
			case MetricPackage.AGGREGATED_REAL_METRIC__STANDARD_DEVIATION:
				setStandardDeviation(STANDARD_DEVIATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetricPackage.AGGREGATED_REAL_METRIC__MINIMUM:
				return minimum != MINIMUM_EDEFAULT;
			case MetricPackage.AGGREGATED_REAL_METRIC__MAXIMUM:
				return maximum != MAXIMUM_EDEFAULT;
			case MetricPackage.AGGREGATED_REAL_METRIC__MEDIAN:
				return median != MEDIAN_EDEFAULT;
			case MetricPackage.AGGREGATED_REAL_METRIC__AVERAGE:
				return average != AVERAGE_EDEFAULT;
			case MetricPackage.AGGREGATED_REAL_METRIC__STANDARD_DEVIATION:
				return standardDeviation != STANDARD_DEVIATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (minimum: ");
		result.append(minimum);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", median: ");
		result.append(median);
		result.append(", average: ");
		result.append(average);
		result.append(", standardDeviation: ");
		result.append(standardDeviation);
		result.append(')');
		return result.toString();
	}

} //AggregatedRealMetricImpl
