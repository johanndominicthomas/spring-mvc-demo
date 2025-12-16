package com.luminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luminar.beans.TeacherBean;
import com.luminar.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	/*Add Teacher*/
	
	@RequestMapping(value = "/teacher", method=RequestMethod.GET)
	public String showform(Model m) {
		m.addAttribute("teacher", new TeacherBean());
		return "teacher";
	}
}
