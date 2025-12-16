package com.luminar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//Model object is injected by spring when call comes to /teacher
	
	@PostMapping("/save")
	public String save(@ModelAttribute("teacher") TeacherBean teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/viewstudent";
	}
	
	//redirect causes redirect to method mapped with viewstudent below
	
	/*View Teachers*/
	
	@GetMapping("/viewsteacher")
	public String viewteacher(Model m) {
		List<TeacherBean> list = teacherService.getTeacherDetails();
		m.addAttribute("list", list);
		return "viewsteacher";
	}
	
}
