package com.seanxiaoxiao.geometry;

import org.springframework.util.Assert;

public class Rectangle implements TwoDimensionGeometry<Rectangle> {

	private static final double MIN_SIZE = 0.000001;

	private final double length;
	
	private final double width;
	
	public Rectangle(double length, double width) {
		Assert.isTrue(length > 0, "The length of the rectangle must be larger than 0");
		Assert.isTrue(width > 0, "The width of the rectangle must be larger than 0");
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double getCircumference() {
		return (length + width) * 2;
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public boolean isCongruent(Rectangle anotherGeometry) {
		Assert.notNull(anotherGeometry);
		return (Math.abs(this.length - anotherGeometry.length) < MIN_SIZE && Math.abs(this.width - anotherGeometry.width) < MIN_SIZE) 
			|| (Math.abs(this.length - anotherGeometry.width) < MIN_SIZE && Math.abs(this.width - anotherGeometry.length) < MIN_SIZE);
	}

}
