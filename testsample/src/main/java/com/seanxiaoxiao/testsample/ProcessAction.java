package com.seanxiaoxiao.testsample;

public interface ProcessAction {

	public String actionWithReturn();
	
	public void actionWithOutReturn();
	
	public void actionNeedArgument(String argument);
	
	public void actionWithException() throws Exception;
}
