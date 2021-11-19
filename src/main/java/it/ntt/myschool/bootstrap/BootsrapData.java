package it.ntt.myschool.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.ntt.myschool.entity.SchoolClass;
import it.ntt.myschool.entity.Student;
import it.ntt.myschool.repository.SchoolClassRepository;
import it.ntt.myschool.repository.StudentRepository;


@Component
public class BootsrapData implements CommandLineRunner{

    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;

    public BootsrapData(StudentRepository studentRepository,SchoolClassRepository schoolClassRepository ){
        this.studentRepository=studentRepository;
        this.schoolClassRepository=schoolClassRepository;
    }
   

    @Override
    public void run(String... args) throws Exception {

        SchoolClass schoolClass1 = new SchoolClass("1A");
        SchoolClass schoolClass2 = new SchoolClass("2A");
        SchoolClass schoolClass3 = new SchoolClass("3A");

        Student student1 = new Student("Mario","Rossi",14);
        Student student2 = new Student("Giulio","Bianchi",14);
        Student student3 = new Student("Anna","Gialli",15);
        Student student4 = new Student("Silvio","Galli",15);
        Student student5 = new Student("Giorgia","Meloni",16);
        Student student6 = new Student("Michela","Galli",16);

        student1.setSchoolClass(schoolClass1);
        student2.setSchoolClass(schoolClass1);
        student3.setSchoolClass(schoolClass2);
        student4.setSchoolClass(schoolClass2);
        student5.setSchoolClass(schoolClass3);
        student6.setSchoolClass(schoolClass3);

        schoolClassRepository.save(schoolClass1);
        schoolClassRepository.save(schoolClass2);
        schoolClassRepository.save(schoolClass3);


        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);

    }
}
