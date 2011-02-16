package com.seanxiaoxiao.geometry.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.seanxiaoxiao.geometry.Rectangle;
import com.seanxiaoxiao.geometry.Square;

public class SquareTest {

	private Square sampleSquare;
	
	@Before
	public void setUp() {
		sampleSquare = new Square(5);
	}
	
	@Test
	public void testAreaOfSquare() {
		assertEquals(Double.valueOf(25d), Double.valueOf(sampleSquare.getArea()));
	}
	
	@Test
	public void testCircumference() {
		assertEquals(Double.valueOf(20), Double.valueOf(sampleSquare.getCircumference()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testErrorConstructSqure_SideZero() {
		new Square(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testErrorConstructSqure_SideMinus() {
		new Square(-1);
	}
	
	@Test
	public void testIsCongruentWithAnotherSqure() {
		Square anotherSquare = new Square(5);
		assertTrue(sampleSquare.isCongruent(anotherSquare));
	}
	
	@Test
	public void testIsCongruentWithAnotherSqure_Not() {
		Square anotherSquare = new Square(5.2);
		assertFalse(sampleSquare.isCongruent(anotherSquare));
	}
	
	@Test
	public void testIsCongruentWithItself() {
		assertTrue(sampleSquare.isCongruent(sampleSquare));
	}
	
	@Test
	public void testIsCongruentWithAnotherRectangle() {
		Rectangle anotherRectangle = new Rectangle(5, 5);
		assertTrue(sampleSquare.isCongruent(anotherRectangle));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIsCrongruentNullArgument() {
		sampleSquare.isCongruent(null);
	}
}
