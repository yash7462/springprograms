package com.EmpMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.EmpMVC.beans.Emp;

import com.EmpMVC.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService empservice;

	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Emp());
		return "empform";
	}

	/**
	 * add data into database
	 * 
	 * @param emp
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Emp emp, Model m) {

		m.addAttribute("command", empservice.save(emp));

		return "redirect:/viewemp";
	}

	/**
	 * Fetch data from database and display.
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/viewemp")
	public String viewemp(Model m) {
		m.addAttribute("list", empservice.getAllEmployees());
		return "viewemp";
	}

	/**
	 * first this method fetch id from DB table and redirect to edit method
	 * 
	 * @param id
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {

		m.addAttribute("command", empservice.getEmpById(id));
		return "empeditform";
	}

	/**
	 * It updates model object.
	 * 
	 * @param emp
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Emp emp, Model m) {

		m.addAttribute("command", empservice.update(emp));

		return "redirect:/viewemp";
	}

	/**
	 * It deletes record for the given id in URL and redirects to /viewemp
	 * 
	 * @param id
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model m) {
		m.addAttribute("command", empservice.delete(id));

		return "redirect:/viewemp";
	}
}