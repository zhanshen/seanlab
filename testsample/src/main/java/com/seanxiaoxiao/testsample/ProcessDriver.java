package com.seanxiaoxiao.testsample;

public class ProcessDriver {

	private ProcessAction processAction = new ProcessActionImpl();
	
	public void actionSerials1() {
		processAction.actionWithOutReturn();
	}
	
	public String actionSerials2() {
		return processAction.actionWithReturn();
	}
	
	public void actionSerials3() {
		for (int i = 0; i < 10; i++) {
			processAction.actionWithOutReturn();
		}
	}
	
	public void actionSerials4() {
		processAction.actionNeedArgument("xx");
	}
	
	public void actionSerials5() {
		String arg = processAction.actionWithReturn();
		processAction.actionNeedArgument(arg);
	}
	
	public void actionSerials6() {
		try {
			processAction.actionWithException();
			processAction.actionWithOutReturn();
		} catch (Exception e) {
			processAction.actionNeedArgument("ex");
		}
	}
	
	public void setProcessAction(ProcessAction processAction) {
		this.processAction = processAction;
	}
}
