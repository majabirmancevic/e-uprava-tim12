package com.ftn.euprava.ambulanta.repository;

import com.ftn.euprava.ambulanta.model.LekarskiIzvestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LekarskiIzvestajRepository extends JpaRepository<LekarskiIzvestaj,Long> {
    LekarskiIzvestaj findByTermin_Id(Long terminId);

}
