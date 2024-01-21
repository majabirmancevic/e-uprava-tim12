package com.ftn.euprava.dom.repository;

import com.ftn.euprava.dom.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsername(String username);
    List<Student> findByBodoviGreaterThan(double bodovi);
    List<Student> findByBodoviGreaterThanAndSobaIsNull(double bodovi);



}

