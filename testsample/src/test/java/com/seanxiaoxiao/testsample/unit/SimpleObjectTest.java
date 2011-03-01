package com.seanxiaoxiao.testsample.unit;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.seanxiaoxiao.testsample.SimpleObject;

public class SimpleObjectTest {

	private SimpleObject simpleObject;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Print before set up and only once.");
	}
	
	@Before
	public void setUp() {
		simpleObject = new SimpleObject();
	}
	
	@Test
	public void testActionWithReturn() {
		Assert.assertEquals(0, simpleObject.actionWithInt());
	}
	
	@Test
	public void testActionWithOutReturn() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		simpleObject.actionWithOutReturn();
		Field field = SimpleObject.class.getDeclaredField("stringMember");
		field.setAccessible(true);
		Assert.assertEquals("xiaoxiao", field.get(simpleObject).toString());
	}
	
	@Test(expected = Exception.class)
	public void testActionWithException() throws Exception {
		simpleObject.actionWithException();
	}
	
	@Test(timeout = 2000)
	public void testActionSpendSomeTime() {
		simpleObject.actionSpendSometime();
	}
}
