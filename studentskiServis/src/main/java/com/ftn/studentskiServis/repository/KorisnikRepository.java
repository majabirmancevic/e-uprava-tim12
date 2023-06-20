package com.ftn.studentskiServis.repository;


import com.ftn.studentskiServis.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik findByJmbg(String jmbg);
}
