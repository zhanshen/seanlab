package com.seanxiaoxiao.testsample.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.seanxiaoxiao.testsample.Dao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"/springJdbcContext.xml"})
@Transactional
public class DaoImplTest {

	@Autowired
	private Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Test
	public void testInsert() {
		this.dao.insert(1, "xiaoxiao");
		Assert.assertEquals("xiaoxiao", this.dao.query(1));
	}
	
	@Test
	public void testUpdate() {
		this.dao.insert(1, "xiaoxiao");
		this.dao.update(1, "xubin");
		Assert.assertEquals("xubin", this.dao.query(1));
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void testDelete() {
		this.dao.insert(1, "xiaoxiao");
		this.dao.delete(1);
		this.dao.query(1);
	}
}
