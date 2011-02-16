package com.seanxiaoxiao.geometry.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.seanxiaoxiao.geometry.Rectangle;
import com.seanxiaoxiao.geometry.Square;

public class RectangleTest {

	private Rectangle rectangle = new Rectangle(5, 4);
	
	@Test
	public void testCircumference() {
		assertEquals(new Double(18), new Double(rectangle.getCircumference()));
	}
	
	@Test
	public void testArea() {
		assertEquals(new Double(20), new Double(rectangle.getArea()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailConstruct_LengthZero() {
		new Rectangle(0, 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailConstruct_LengthMinus() {
		new Rectangle(-5, 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailConstruct_WidthZero() {
		new Rectangle(4, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailConstruct_WidthMinus() {
		new Rectangle(4, -5);
	}
	
	@Test
	public void testIsCongruentWithItself() {
		assertTrue(rectangle.isCongruent(rectangle));
	}
	
	@Test
	public void testIsCongruentWithAnotherRectangle() {
		Rectangle anotherRectangle = new Rectangle(5, 4);
		assertTrue(rectangle.isCongruent(anotherRectangle));
	}
	
	@Test
	public void testIsCongruentWithAnotherReverseRectangle() {
		Rectangle anotherRectangle = new Rectangle(4, 5);
		assertTrue(rectangle.isCongruent(anotherRectangle));
	}
	
	@Test
	public void testIsCongruentWithAnotherSquare() {
		Rectangle rectangle = new Rectangle(5, 5);
		Square anothersSquare = new Square(5);
		assertTrue(rectangle.isCongruent(anothersSquare));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIsCongruentWithNullArgument() {
		assertTrue(rectangle.isCongruent(null));
	}
	
	@Test
	public void testIsCongruentNotCongruent() {
		Rectangle anotherRectangle = new Rectangle(4, 6);
		assertFalse(rectangle.isCongruent(anotherRectangle));
	}
}
