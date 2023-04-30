package com.ftn.euprava.ambulanta.repository;

import com.ftn.euprava.ambulanta.model.LekarskoUverenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LekarskoUverenjeRepository extends JpaRepository<LekarskoUverenje,Long> {
}
