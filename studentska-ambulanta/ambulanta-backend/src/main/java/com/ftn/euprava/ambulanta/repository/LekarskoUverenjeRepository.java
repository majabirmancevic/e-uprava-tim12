package com.ftn.euprava.ambulanta.repository;

import com.ftn.euprava.ambulanta.model.LekarskoUverenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LekarskoUverenjeRepository extends JpaRepository<LekarskoUverenje,Long> {

//    @Query(value = "select * from uverenja where student_jmbg = ?1",
//            nativeQuery = true)
    LekarskoUverenje findByStudentJmbg(String jmbg);
}
