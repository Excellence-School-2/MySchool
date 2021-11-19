package it.ntt.myschool.repository;

import org.springframework.data.repository.CrudRepository;

import it.ntt.myschool.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
    
}
