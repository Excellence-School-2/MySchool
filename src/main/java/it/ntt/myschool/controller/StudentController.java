package it.ntt.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.ntt.myschool.entity.Student;
import it.ntt.myschool.repository.SchoolClassRepository;
import it.ntt.myschool.repository.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
    private StudentRepository studentRepository;
    private SchoolClassRepository schoolClassRepository;
    

    public StudentController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository){
        this.studentRepository=studentRepository;
        this.schoolClassRepository=schoolClassRepository;
        
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


    @GetMapping("/addStudent")
    public String getNewStudentForm(Model model){
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
       return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student, @RequestParam String section) {
        student.setSchoolClass(schoolClassRepository.findschoolClassBySection(section));
    //lo prende dal form della pag AddStudent.html <input name="name" type="text" class="form-control" aria-describedby="namelHelp">
        studentRepository.save(student);
        return "redirect:/students";
    }
    
}
