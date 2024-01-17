package com.ftn.euprava.dom.service;

import com.ftn.euprava.dom.model.Upravnik;
import com.ftn.euprava.dom.repository.UpravnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UpravnikService {

    @Autowired
    private UpravnikRepository upravnikRepository;

    public List<Upravnik> getAllUpravnici() {
        return upravnikRepository.findAll();
    }

    public Optional<Upravnik> getUpravnikById(Long id) {
        return upravnikRepository.findById(id);
    }

    public Upravnik createUpravnik(Upravnik upravnik) {
        return upravnikRepository.save(upravnik);
    }

    public Upravnik updateUpravnik(Long id, Upravnik updatedUpravnik) {
        Optional<Upravnik> existingUpravnik = upravnikRepository.findById(id);
        if (existingUpravnik.isPresent()) {
            return upravnikRepository.save(updatedUpravnik);
        }
        return null;
    }

    public void deleteUpravnik(Long id) {
        upravnikRepository.deleteById(id);
    }
}

