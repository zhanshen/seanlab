package com.seanxiaoxiao.testsample.unit;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.seanxiaoxiao.testsample.ProcessAction;
import com.seanxiaoxiao.testsample.ProcessDriver;

public class ProcessTest {

	private ProcessAction processAction = null;
	private ProcessDriver processDriver = null;

	@Before
	public void setUp() {
		processDriver = new ProcessDriver();
		processAction = EasyMock.createMock(ProcessAction.class);
		processDriver.setProcessAction(processAction);
	}

	@Test
	public void testActionSerials1() {
		processAction.actionWithOutReturn();
		EasyMock.expectLastCall();
		EasyMock.replay(processAction);
		processDriver.actionSerials1();
		EasyMock.verify(processAction);
	}
	
	@Test
	public void testActionSerials2() {
		processAction.actionWithReturn();
		EasyMock.expectLastCall().andReturn("xx").once();
		EasyMock.replay(processAction);
		Assert.assertEquals("xx", processDriver.actionSerials2());
		EasyMock.verify(processAction);
	}
	
	@Test
	public void testActionSerials3() {
		processAction.actionWithOutReturn();
		EasyMock.expectLastCall().times(10);
		EasyMock.replay(processAction);
		processDriver.actionSerials3();
		EasyMock.verify(processAction);
	}
	
	@Test
	public void testActionSerials4() {
		processAction.actionNeedArgument("xx");
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(processAction);
		processDriver.actionSerials4();
		EasyMock.verify(processAction);
	}
	
	@Test
	public void testActionSerials5() {
		processAction.actionWithReturn();
		EasyMock.expectLastCall().andReturn("xx").once();
		processAction.actionNeedArgument("xx");
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(processAction);
		processDriver.actionSerials5();
		EasyMock.verify(processAction);
	}
	
	@Test
	public void testActionSerials6ExceptionBranch() throws Exception {
		processAction.actionWithException();
		EasyMock.expectLastCall().andThrow(new Exception()).once();
		processAction.actionNeedArgument("ex");
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(processAction);
		processDriver.actionSerials6();
		EasyMock.verify(processAction);
	}
	
	@Test
	public void testActionSerials6NormalBranch() throws Exception {
		processAction.actionWithException();
		EasyMock.expectLastCall().once();
		processAction.actionWithOutReturn();
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(processAction);
		processDriver.actionSerials6();
		EasyMock.verify(processAction);
	}
}
