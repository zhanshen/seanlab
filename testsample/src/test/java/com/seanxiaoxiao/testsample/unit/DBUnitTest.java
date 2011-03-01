package com.seanxiaoxiao.testsample.unit;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seanxiaoxiao.testsample.Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/springJdbcContext.xml" })
public class DBUnitTest {

	@Autowired
	private Dao dao;

	@Autowired
	private DataSource dataSource;

	private IDatabaseConnection conn = null;
	
	@Before
	public void setUp() throws DatabaseUnitException, SQLException {
		conn = new DatabaseConnection(dataSource.getConnection());
	}
	
	@After
	public void tearDown() throws Exception {
		initDatabase(dataSource, "data-empty.xml");
	}
	
	private static IDataSet initDatabase(DataSource dataSource, String datafile) throws Exception {
		final IDatabaseConnection conn = new DatabaseConnection(dataSource.getConnection());
		final IDataSet data = getDataSet(datafile);
		try {
			DatabaseOperation.CLEAN_INSERT.execute(conn, data);
		} finally {
			conn.close();
		}
		return data;
	}
	
	
	private static IDataSet getDataSet(String datafile) throws IOException, DataSetException {
		@SuppressWarnings("deprecation")
		ReplacementDataSet rds = new ReplacementDataSet(new FlatXmlDataSet(Thread.currentThread().getContextClassLoader().getResource(datafile)));
		rds.addReplacementObject("[NULL]", null);
		return rds;
	}
	
	@Test
	public void testInsert() throws Exception {
		initDatabase(this.dataSource, "data.xml");
		dao.insert(4, "tangweiwei");
		QueryDataSet actual = new QueryDataSet(conn);
		actual.addTable("person",
				"select * from person");
		IDataSet expectedData = getDataSet("data-insert_expected.xml");
		Assertion.assertEquals(expectedData, actual);
	}
	
	@Test
	public void testUpdate() throws Exception {
		initDatabase(this.dataSource, "data.xml");
		dao.update(3, "xiaoxiao");
		QueryDataSet actual = new QueryDataSet(conn);
		actual.addTable("person",
				"select * from person");
		IDataSet expectedData = getDataSet("data-update_expected.xml");
		Assertion.assertEquals(expectedData, actual);
	}
	
	@Test
	public void testDelete() throws Exception {
		initDatabase(this.dataSource, "data.xml");
		dao.delete(3);
		QueryDataSet actual = new QueryDataSet(conn);
		actual.addTable("person",
				"select * from person");
		IDataSet expectedData = getDataSet("data-delete_expected.xml");
		Assertion.assertEquals(expectedData, actual);
	}
}
