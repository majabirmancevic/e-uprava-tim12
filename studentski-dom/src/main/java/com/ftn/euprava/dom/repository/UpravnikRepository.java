package com.ftn.euprava.dom.repository;

import com.ftn.euprava.dom.model.Upravnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpravnikRepository extends JpaRepository<Upravnik, Long> {
    Upravnik findByUsername(String username);
}

