package com.ftn.studentskiServis.service;


import com.ftn.studentskiServis.model.Korisnik;
import com.ftn.studentskiServis.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;

@Service
public class DataService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public void createUsers(){
        Korisnik korisnik = new Korisnik();
        korisnik.setJmbg("1122334455667");
        korisnik.setNaBudzetu(true);
        korisnik.setAktivnaKartica(true);
        korisnik.setUradioLekarski(false);

        Korisnik korisnik1 = new Korisnik();
        korisnik1.setJmbg("3322114433441");
        korisnik1.setNaBudzetu(true);
        korisnik1.setAktivnaKartica(true);
        korisnik1.setUradioLekarski(false);

        korisnikRepository.save(korisnik);
        korisnikRepository.save(korisnik1);
    }


}
