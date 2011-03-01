package com.seanxiaoxiao.testsample;

public class ProcessActionImpl implements ProcessAction {

	public String actionWithReturn() {
		return "xiao";
	}

	public void actionWithOutReturn() {
		//Do nothing.
	}
	
	public void actionNeedArgument(String argument) {
		
	}

	public void actionWithException() throws Exception {
		throw new Exception();
	}

}
