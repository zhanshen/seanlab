package com.seanxiaoxiao.geometry;


public class Square extends Rectangle implements TwoDimensionGeometry<Rectangle> {

	public Square(double side) {
		super(side, side);
	}
	
}
