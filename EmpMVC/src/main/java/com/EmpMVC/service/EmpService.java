package com.EmpMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmpMVC.beans.Emp;
import com.EmpMVC.dao.EmpDao;

@Service
public class EmpService {

	@Autowired
	EmpDao dao;// will inject dao from xml file

	/**
	 * save the details in database
	 * 
	 * @param Emp
	 * @return
	 */
	public int save(Emp Emp) {
		return dao.save(Emp);
	}

	/**
	 * fetch the whole data from database
	 * 
	 * @return
	 */
	public List<Emp> getAllEmployees() {
		return dao.getEmployees();
	}

	/**
	 * this method return id of records
	 * 
	 * @param id
	 * @return
	 */
	public Emp getEmpById(int id) {
		return dao.getEmpById(id);
	}

	/**
	 * this method update the data
	 * 
	 * @param emp
	 * @return
	 */
	public int update(Emp emp) {
		return dao.update(emp);
	}

	/**
	 * delete record from database
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return dao.delete(id);
	}
}
