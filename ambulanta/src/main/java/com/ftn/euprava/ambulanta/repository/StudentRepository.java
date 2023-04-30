package com.ftn.euprava.ambulanta.repository;

import com.ftn.euprava.ambulanta.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByJmbg(String jmbg);
    Student findByUsername(String username);
}
