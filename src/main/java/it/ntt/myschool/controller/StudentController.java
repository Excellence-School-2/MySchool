package it.ntt.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.ntt.myschool.repository.StudentRepository;

@Controller
public class StudentController {
    private StudentRepository studentRepository;
    

    public StudentController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
        
    }
    
    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students", studentRepository.findAll());
         //per far cambiare il titolo della pagina coerentemente alla pagina che clicco lato FE
        model.addAttribute("title", "All Students");
        return "studentList";
    }
    @GetMapping("/students/{section}")
    public String getStudentsByClass(Model model, @PathVariable String section){
        model.addAttribute("students" , studentRepository.findStudentsByClass(section));
        //per far cambiare il titolo della pagina  coerentemente alla pagina che clicco lato FE
        model.addAttribute("title", section +" "+ "Student List");
        return "studentList";

    }
}
