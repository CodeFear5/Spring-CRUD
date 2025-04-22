package com.nagesh.studentmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagesh.studentmanagement.model.Student;
import com.nagesh.studentmanagement.repo.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    StudentRepository repo;
      
    @GetMapping("/")
    public String showWelcomePage() {
        return "Welcome"; // this returns the 'welcome.html' from templates
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/form"; // redirect to prevent form resubmission
    }
    
    
    @GetMapping("/getUsers")
    public String ListStudents(Model model) {
     	model.addAttribute("students",repo.findAll());
    	return "list";
    }
    
    @GetMapping("/edit/{id}")
    public String EditUsers(@PathVariable int id,Model model) {   	
    	Student s=repo.findById(id).orElse(new Student());
    	model.addAttribute("student",s);
    	return "form";
    	
    }
    
    @GetMapping("/delete/{id}")
    	public String deleteUser(@PathVariable int id) {
    		
    		repo.deleteById(id);
    		
    		
    		return "redirect:/getUsers";
    	}
    
    
    
}
