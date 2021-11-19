package it.ntt.myschool.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ntt.myschool.entity.Student;
import it.ntt.myschool.repository.StudentRepository;


//Implementazione servizi RESTful API
@RestController
public class StudentRestController {

    //Injection (devo recuperare gli studenti che sono nel db e per farlo mi aiuta la repository)
    private StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    // End Injection
    

    @GetMapping("/api/v0/students")
    public Iterable<Student> getStudents(){
        //List<Student> studentList = new ArrayList<>();
        return studentRepository.findAll();
         
    }

   

    @GetMapping("/api/v0/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepository.findById(id).get();
    }

    
}
