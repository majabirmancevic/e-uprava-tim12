package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.exception.NotAcceptableException;
import com.ftn.euprava.ambulanta.model.*;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajResponse;
import com.ftn.euprava.ambulanta.model.dto.TerminDoktorResponse;
import com.ftn.euprava.ambulanta.model.dto.TerminResponse;
import com.ftn.euprava.ambulanta.repository.LekarskiIzvestajRepository;
import com.ftn.euprava.ambulanta.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;

    @Autowired
    private LekarskiIzvestajRepository lekarskiIzvestajRepository;

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

    public List<TerminResponse> getAllDoneTerminByStudent(Authentication authentication){
        List<TerminResponse> response = new ArrayList<>();
        Student student= studentService.findByUsername(authentication.getName());
        for(Termin termin: terminRepository.findAllByStudent(student)){
            if(termin.getStatusTermina().equals(StatusTermina.ZAVRSEN)) {
                response.add(new TerminResponse(termin));
            }
        }
        return response;
    }
    public List<TerminDoktorResponse> getAllTerminByDoktor(Authentication authentication){
        List<TerminDoktorResponse> response = new ArrayList<>();
        Doktor doktor= doktorService.findByUsername(authentication.getName());
        for(Termin termin: terminRepository.findAllByDoktor(doktor)){
            response.add(new TerminDoktorResponse(termin));
        }
        return response;
    }
    public List<TerminResponse> getAllFreeTerminBySpecijalnostAndDate(String specijalnost,String stringDate){
        LocalDate date = LocalDate.parse(stringDate);
        System.out.println("-- IZABRAN DATUM: " + date);
        LocalDateTime dateTimePocetak = date.atTime(8,00,00);
        LocalDateTime dateTimeKraj = date.atTime(20,00,00);
        List<TerminResponse> response = new ArrayList<>();
        SpecijalnostDoktora spec = SpecijalnostDoktora.returnSpecijalnost(specijalnost.toUpperCase());
        for(Termin termin: terminRepository.findAll()){
            if(termin.getDoktor().getSpecijalnost().equals(spec) && termin.getStatusTermina() == StatusTermina.SLOBODAN && !termin.getPocetakTermina().isBefore(dateTimePocetak) && !termin.getKrajTermina().isAfter(dateTimeKraj)) {
                response.add(new TerminResponse(termin));
            }
        }
        return response;
    }

    public void zakaziTermin(Long terminId, Authentication authentication) throws NotAcceptableException {
        Student student= studentService.findByUsername(authentication.getName());
        Boolean isStudentBudzet = studentService.checkStatusStudenta(student.getJmbg());
        Boolean isKarticaAktivna = studentService.checkStatusKartice(student.getJmbg());

        if(isStudentBudzet == null || isKarticaAktivna == null){
            throw new NotAcceptableException("Greska! Student nije pronadjen!");
        } else if(isStudentBudzet == true && isKarticaAktivna == true){
            Termin termin = terminRepository.findById(terminId).orElse(null);
            assert termin != null;
            termin.setStatusTermina(StatusTermina.ZAKAZAN);
            termin.setStudent(student);
            terminRepository.save(termin);
        } else {
            throw new NotAcceptableException("Student nije na budzetu ili nema aktivnu studentsku karticu!");
        }

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
