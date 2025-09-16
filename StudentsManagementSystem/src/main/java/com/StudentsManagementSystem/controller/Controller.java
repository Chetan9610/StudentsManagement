package com.StudentsManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentsManagementSystem.Student;
import com.StudentsManagementSystem.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private StudentService service;
	@GetMapping("/home")

	public String home() {
		return"home";//view page html file->home.html
	}
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",service.getAllStudents());
		
		return "students";//view
	
	}
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		
		Student.student=new Student();//to hold the student object
		Object student = null;
		model.addAttribute("students",student);
		
		return "create-student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student")Student student) {
    
		service.saveStudent(student);
		
		return "redirect:/students";
		
	}	
}
