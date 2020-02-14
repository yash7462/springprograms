package com.EmpMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.EmpMVC.beans.Emp;

public class EmpDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/**
	 * insert record into database
	 * 
	 * @param p
	 * @return
	 */
	public int save(Emp p) {
		String sql = "insert into Emp99(name,salary,designation) values('" + p.getName() + "'," + p.getSalary() + ",'"
				+ p.getDesignation() + "')";
		return template.update(sql);
	}

	/**
	 * update record into database by given id
	 * 
	 * @param p
	 * @return
	 */
	public int update(Emp p) {
		String sql = "update Emp99 set name='" + p.getName() + "', salary=" + p.getSalary() + ",designation='"
				+ p.getDesignation() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	/**
	 * delete record from database by given id
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from Emp99 where id=" + id + "";
		return template.update(sql);
	}

	/**
	 * it fetch id of record from database
	 * 
	 * @param id
	 * @return
	 */
	public Emp getEmpById(int id) {
		String sql = "select * from Emp99 where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	/**
	 * fetch all record from database
	 * 
	 * @return
	 */
	public List<Emp> getEmployees() {
		return template.query("select * from Emp99", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}
}