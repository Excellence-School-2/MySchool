package it.ntt.myschool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.ntt.myschool.entity.SchoolClass;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {
    

     //Query in formato JPA
     @Query("SELECT s FROM SchoolClass s WHERE s.section = :section  ")    
     public SchoolClass  findschoolClassBySection(@Param("section") String section);
}
