package it.ntt.myschool.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.ntt.myschool.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

    //Query in formato JPA
    @Query("SELECT s FROM Student s WHERE s.schoolClass.section = :section  ")    
    public Collection<Student> findStudentsByClass(@Param("section") String section);
    
}
