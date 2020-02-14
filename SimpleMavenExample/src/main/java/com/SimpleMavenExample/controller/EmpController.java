package com.SimpleMavenExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.SimpleMavenExample.beans.Emp;
import com.SimpleMavenExample.dao.EmpDao;

@Controller
public class EmpController {

	@Autowired
	EmpDao dao;

	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Emp());
		return "empform";
	}

	/**
	 * This method is for x pupose
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Emp emp) {
		dao.save(emp);
		return "redirect:/viewemp";
	}
		
	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Emp> list = dao.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Emp emp = dao.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Emp emp) {
		dao.update(emp);
		return "redirect:/viewemp";
	}

	/*
	 * @RequestMapping(value = "/editemp/{id}") public String edit(@PathVariable int
	 * id, Model m) { Emp emp = dao.getEmpById(id); m.addAttribute("command", emp);
	 * return "empeditform"; }
	 * 
	 * @RequestMapping(value = "/editsave", method = RequestMethod.POST) //
	 * empeditform.jsp public String editsave(@ModelAttribute("emp") Emp emp) {
	 * dao.update(emp); return "redirect:/viewemp"; }
	 */
//TODO
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
	}

}
