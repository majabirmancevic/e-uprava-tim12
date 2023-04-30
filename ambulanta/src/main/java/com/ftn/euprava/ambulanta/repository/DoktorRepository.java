package com.ftn.euprava.ambulanta.repository;

import com.ftn.euprava.ambulanta.model.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoktorRepository extends JpaRepository<Doktor,Long> {

    Doktor findByUsername(String username);
    List<Doktor> findAllBySpecijalnost(String specialnost);
}
