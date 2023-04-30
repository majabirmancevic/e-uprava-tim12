package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.model.Doktor;
import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.repository.DoktorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoktorService {

    @Autowired
    DoktorRepository doktorRepository;

    public Doktor findByUsername(String username){
        return doktorRepository.findByUsername(username);
    }

    public List<Doktor> findBySpecijalnost(String username){
        return doktorRepository.findAllBySpecijalnost(username);
    }
}
