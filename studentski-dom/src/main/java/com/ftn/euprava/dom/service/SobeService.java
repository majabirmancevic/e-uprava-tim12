package com.ftn.euprava.dom.service;

import com.ftn.euprava.dom.model.Soba;
import com.ftn.euprava.dom.repository.SobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SobeService {

    @Autowired
    private SobaRepository sobaRepository;

    public List<Soba> getAllSobas() {
        return sobaRepository.findAll();
    }

    public Optional<Soba> getSobaById(Long id) {
        return sobaRepository.findById(id);
    }

    public Soba createSoba(Soba soba) {
        return sobaRepository.save(soba);
    }

    public Soba updateSoba(Long id, Soba updatedSoba) {
        Optional<Soba> existingSoba = sobaRepository.findById(id);
        if (existingSoba.isPresent()) {
            return sobaRepository.save(updatedSoba);
        }
        return null;
    }

    public void deleteSoba(Long id) {
        sobaRepository.deleteById(id);
    }

    public boolean sobaPostoji(Long sobaId) {
        return sobaRepository.existsById(sobaId);
    }
}
