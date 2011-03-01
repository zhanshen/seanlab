package com.seanxiaoxiao.testsample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;


public class DaoImp implements Dao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insert(final int id, final String name) {
		final String insertSql = "insert into person(person_id, person_name) values(?, ?);";
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(insertSql, new String[] { "person_id", "person_name" });// 返回id
				ps.setInt(1, id);
				ps.setString(2, name);
				return ps;
			}
		});
	}

	public String query(int id) {
		return this.jdbcTemplate.queryForObject("select person_name from person where person_id = ?;", new Object[]{new Long(id)}, 
			new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					return rs.getString("person_name");
				}
		});
	}

	public void delete(final int id) {
		final String deleteSql = "delete from person where person_id = ?;";
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(deleteSql, new String[] { "person_id"});// 返回id
				ps.setInt(1, id);
				return ps;
			}
		});
	}

	public void update(final int id, final String name) {
		final String updateSql = "update person set person_name = ? where person_id = ?;";
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(updateSql, new String[] {"person_name", "person_id"});// 返回id
				ps.setString(1, name);
				ps.setInt(2, id);
				return ps;
			}
		});
	}
}
