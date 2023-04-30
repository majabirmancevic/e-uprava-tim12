package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.model.*;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajResponse;
import com.ftn.euprava.ambulanta.model.dto.TerminResponse;
import com.ftn.euprava.ambulanta.repository.LekarskiIzvestajRepository;
import com.ftn.euprava.ambulanta.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;

    @Autowired
    LekarskiIzvestajRepository lekarskiIzvestajRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DoktorService doktorService;

    public List<TerminResponse> getAllTerminByStudent(Authentication authentication){
        List<TerminResponse> response = new ArrayList<>();
        Student student= studentService.findByUsername(authentication.getName());
        for(Termin termin: terminRepository.findAllByStudent(student)){
            response.add(new TerminResponse(termin));
        }
        return response;
    }
    public List<TerminResponse> getAllTerminByDoktor(Authentication authentication){
        List<TerminResponse> response = new ArrayList<>();
        Doktor doktor= doktorService.findByUsername(authentication.getName());
        for(Termin termin: terminRepository.findAllByDoktor(doktor)){
            response.add(new TerminResponse(termin));
        }
        return response;
    }
    public List<TerminResponse> getAllFreeTermin(String doktorName){
        List<TerminResponse> response = new ArrayList<>();
        Doktor doktor= doktorService.findByUsername(doktorName);
        for(Termin termin: terminRepository.findAllByDoktor(doktor)){
            if(termin.getStatusTermina() == StatusTermina.SLOBODAN && !termin.getPocetakTermina().isBefore(LocalDateTime.now())) {
                response.add(new TerminResponse(termin));
            }
        }
        return response;
    }

    public void zakaziTermin(Long terminId, Authentication authentication){
        Student student= studentService.findByUsername(authentication.getName());
        Termin termin = terminRepository.findById(terminId).orElse(null);
        assert termin != null;
        termin.setStatusTermina(StatusTermina.ZAKAZAN);
        termin.setStudent(student);
        terminRepository.save(termin);
    }


    public LekarskiIzvestajResponse getLekarskiIzvestaj(Long terminId){

        LekarskiIzvestaj lekarskiIzvestaj = lekarskiIzvestajRepository.findByTermin_Id(terminId);
        LekarskiIzvestajResponse response = new LekarskiIzvestajResponse();

        if(lekarskiIzvestaj == null){
            response.setOpis("Ne postoji izvestaj!");
        }else{
            response.setOpis(lekarskiIzvestaj.getOpis());
            response.setId(lekarskiIzvestaj.getId());
        }

        return response;
    }

    public Termin findById(Long id){
        return terminRepository.findById(id).orElse(null);
    }

    public Termin save(Termin termin){
        return terminRepository.save(termin);
    }

}
