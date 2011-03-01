package com.seanxiaoxiao.testsample;


public interface Dao {

	public void insert(final int id, final String name);
	
	public String query(int id);
	
	public void delete(final int id);
	
	public void update(final int id, final String name);
	
}
