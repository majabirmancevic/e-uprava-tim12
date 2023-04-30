package com.ftn.euprava.ambulanta.repository;

import com.ftn.euprava.ambulanta.model.Doktor;
import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminRepository extends JpaRepository<Termin,Long>{

    List<Termin> findAllByStudent(Student student);
    List<Termin> findAllByDoktor(Doktor doktor);

}
