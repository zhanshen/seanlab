package com.seanxiaoxiao.geometry;

public interface TwoDimensionGeometry<T extends TwoDimensionGeometry<?>> {

	/**
	 * Get the circumference of certain geometry.
	 * @return The circumference of the geometry.
	 */
	public double getCircumference();
	
	/**
	 * Get the area of certain geometry.
	 * @return The area of the geometry.
	 */
	public double getArea();
	
	/**
	 * Judge if the geometry is congruent with another geometry.
	 * @param anotherGeometry Another geometry to compare.
	 * @return If the geometry is congruent with another geometry.
	 */
	public boolean isCongruent(T anotherGeometry);
}
