package it.ntt.myschool.repository;

import org.springframework.data.repository.CrudRepository;

import it.ntt.myschool.entity.SchoolClass;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {
    
}
