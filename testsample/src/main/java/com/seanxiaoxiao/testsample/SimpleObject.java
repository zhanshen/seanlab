package com.seanxiaoxiao.testsample;

public class SimpleObject {

	private Integer intMember;
	
	@SuppressWarnings("unused")
	private String stringMember;
	
	public SimpleObject() {
		this.intMember = 0;
		this.stringMember = "xiaojiong";
	}
	
	public void actionWithOutReturn() {
		this.stringMember = "xiaoxiao";
	}
	
	public int actionWithInt() {
		return intMember;
	}
	
	public void actionWithException() throws Exception {
		throw new Exception();
	}
	
	public void actionSpendSometime() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			//Do nothing.
		}
	}
	
}
