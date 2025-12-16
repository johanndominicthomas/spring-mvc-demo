package com.luminar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	/*Get Teacher By Id*/
	@RequestMapping(value = "editteacher/{id}") //{id} - path variable
	public String editTeacher(@PathVariable int id,Model m) {
		return teacherService.getTeacherById(id).map(teacher ->{
			m.addAttribute("teacher", teacher);
			return "updateteacher";
		}).orElse("error");
	}
	
	/*
	 * When getTeacherById(id) is called, it returns an Optional<TeacherBean>,
	 * which may either contain a TeacherBean or be empty. Calling map(...) on
	 * this Optional always returns a new Optional, but the lambda inside map
	 * executes only if a value is present. If a value exists, the TeacherBean
	 * is transformed into a String view name, resulting in an Optional<String>;
	 * if no value exists, map skips the lambda and returns Optional.empty().
	 * Finally, orElse("error") is invoked on the resulting Optional to unwrap
	 * the value: it returns the contained String if present, or the fallback
	 * "error" if the Optional is empty. The final outcome of this chain is
	 * always a plain String, which is why it can be returned directly from
	 * the controller method.
	 */

	
}
