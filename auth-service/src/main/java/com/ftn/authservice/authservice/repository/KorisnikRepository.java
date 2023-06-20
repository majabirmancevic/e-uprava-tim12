package com.ftn.authservice.authservice.repository;

import com.ftn.authservice.authservice.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik findByUsername(String username);
}
