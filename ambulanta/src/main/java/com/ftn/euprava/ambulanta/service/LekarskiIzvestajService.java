package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.exception.BadRequestException;
import com.ftn.euprava.ambulanta.model.LekarskiIzvestaj;
import com.ftn.euprava.ambulanta.model.SpecijalnostDoktora;
import com.ftn.euprava.ambulanta.model.StatusTermina;
import com.ftn.euprava.ambulanta.model.Termin;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajRequest;
import com.ftn.euprava.ambulanta.repository.LekarskiIzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class LekarskiIzvestajService {

    @Autowired
    private LekarskiIzvestajRepository lekarskiIzvestajRepository;

    @Autowired
    private TerminService terminService;

    public Long addIzvestaj(LekarskiIzvestajRequest request) throws BadRequestException {

        Termin termin = terminService.findById(request.getTerminId());
        String poruka = validate(termin);
        if(poruka.equals("")) {

            termin.setStatusTermina(StatusTermina.ZAVRSEN);
            setSpecijalnost(termin);
            terminService.save(termin);

            LekarskiIzvestaj izvestaj = new LekarskiIzvestaj();
            izvestaj.setTermin(termin);
            izvestaj.setOpis(request.getOpis());

            LekarskiIzvestaj savedReport = lekarskiIzvestajRepository.save(izvestaj);

            return savedReport.getId();
        }
        throw new BadRequestException(poruka);
    }

    public String validate(Termin termin) {
        String message = "";
        if (termin == null) {
            message = "Termin ne postoji";
        }
        if (!termin.getStatusTermina().equals(StatusTermina.ZAKAZAN)) {
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


}
