package com.ftn.euprava.dom.service;

import com.ftn.euprava.dom.model.Dom;
import com.ftn.euprava.dom.repository.DomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DomService {

    @Autowired
    private DomRepository domRepository;

    public List<Dom> getAllDomes() {
        return domRepository.findAll();
    }

    public Optional<Dom> getDomById(Long id) {
        return domRepository.findById(id);
    }

    public Dom createDom(Dom dom) {
        return domRepository.save(dom);
    }

    public Dom updateDom(Long id, Dom updatedDom) {
        Optional<Dom> existingDom = domRepository.findById(id);
        if (existingDom.isPresent()) {
            return domRepository.save(updatedDom);
        }
        return null;
    }

    public void deleteDom(Long id) {
        domRepository.deleteById(id);
    }
}

