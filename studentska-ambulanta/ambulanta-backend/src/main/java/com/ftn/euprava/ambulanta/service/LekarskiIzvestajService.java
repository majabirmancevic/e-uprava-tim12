package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.exception.BadRequestException;
import com.ftn.euprava.ambulanta.model.*;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajRequest;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajResponse;
import com.ftn.euprava.ambulanta.repository.LekarskiIzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LekarskiIzvestajService {

    @Autowired
    private LekarskiIzvestajRepository lekarskiIzvestajRepository;

    @Autowired
    private TerminService terminService;

    @Autowired
    private DoktorService doktorService;

    public Boolean addIzvestaj(LekarskiIzvestajRequest request){

        Termin termin = terminService.findById(request.getTerminId());

        if(termin != null && !termin.getStatusTermina().equals(StatusTermina.ZAVRSEN)) {

            termin.setStatusTermina(StatusTermina.ZAVRSEN);
            setSpecijalnost(termin);
            terminService.save(termin);

            LekarskiIzvestaj izvestaj = new LekarskiIzvestaj();
            izvestaj.setTermin(termin);
            izvestaj.setOpis(request.getOpis());


            LekarskiIzvestaj savedReport = lekarskiIzvestajRepository.save(izvestaj);

            return true;
        }
        return false;
    }

    public String validate(Termin termin) {
        String message = "";
        if (termin == null) {
            message = "Termin ne postoji";
        }
        if (!termin.getStatusTermina().equals(StatusTermina.ZAVRSEN)) {
            message = "Izvestaj vec postoji";
        }
        // TODO: kako testirati?
//        if (termin.getPocetakTermina().isAfter(LocalDateTime.now())) {
//            message = "Termin je prosao";
//        }
//        if(termin.getPocetakTermina().isBefore(LocalDateTime.now())){
//            message = "Pregled nije počeo";
//        }
        return message;
    }

    private void setSpecijalnost(Termin termin){
        if(termin.getDoktor().getSpecijalnost().equals(SpecijalnostDoktora.GINEKOLOG)){
            termin.getStudent().setGinekolog(true);
        } else if(termin.getDoktor().getSpecijalnost().equals(SpecijalnostDoktora.STOMATOLOG)){
            termin.getStudent().setStomatolog(true);
        } else {
            termin.getStudent().setOpstaPraksa(true);
        }
    }

    public List<LekarskiIzvestajResponse> getIzvestajiByDoktor(Authentication authentication){
        Doktor doktor = doktorService.findByUsername(authentication.getName());
        List<LekarskiIzvestajResponse> response = new ArrayList<>();
        for(LekarskiIzvestaj izvestaj : lekarskiIzvestajRepository.findAllByTermin_Doktor(doktor)){
            response.add(new LekarskiIzvestajResponse(izvestaj));
        }
        return response;
    }

}
