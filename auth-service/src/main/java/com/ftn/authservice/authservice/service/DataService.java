package com.ftn.authservice.authservice.service;

import com.ftn.authservice.authservice.entity.Korisnik;
import com.ftn.authservice.authservice.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void korisnici(){
        Korisnik korisnik = new Korisnik();
        korisnik.setIme("Natasa");
        korisnik.setPrezime("Djurica");
        korisnik.setUsername("natasa123");
        korisnik.setLozinka(passwordEncoder.encode("natasa123"));
        korisnik.setUloga("DOKTOR");
        korisnik.setEnabled(false);

        Korisnik korisnik1 = new Korisnik();
        korisnik1.setIme("Andjela");
        korisnik1.setPrezime("Smiljanic");
        korisnik1.setUsername("andjela123");
        korisnik1.setLozinka(passwordEncoder.encode("andjela123"));
        korisnik1.setUloga("DOKTOR");
        korisnik1.setEnabled(false);

        Korisnik doktor2 = new Korisnik();
        doktor2.setIme("Dragana");
        doktor2.setPrezime("Mirkovic");
        doktor2.setUsername("dragana123");
        doktor2.setLozinka(passwordEncoder.encode("dragana123"));
        doktor2.setUloga("DOKTOR");
        doktor2.setEnabled(false);

//        Korisnik korisnik2 = new Korisnik();
//        korisnik2.setIme("Milica");
//        korisnik2.setPrezime("Radojevic");
//        korisnik2.setUsername("milica123");
//        korisnik2.setLozinka(passwordEncoder.encode("milica123"));
//        korisnik2.setUloga("STUDENT");
//        korisnik2.setEnabled(false);

        Korisnik korisnik3 = new Korisnik();
        korisnik3.setIme("Maja");
        korisnik3.setPrezime("Birmancevic");
        korisnik3.setUsername("maja123");
        korisnik3.setLozinka(passwordEncoder.encode("maja123"));
        korisnik3.setUloga("STUDENT");
        korisnik3.setEnabled(false);

        Korisnik korisnik2 = new Korisnik();
        korisnik2.setIme("Admin");
        korisnik2.setPrezime("Adminovic");
        korisnik2.setUsername("admin");
        korisnik2.setLozinka(passwordEncoder.encode("admin123"));
        korisnik2.setUloga("UPRAVNIK");
        korisnik2.setEnabled(false);




        korisnikRepository.save(korisnik);
        korisnikRepository.save(korisnik1);
        korisnikRepository.save(doktor2);
        korisnikRepository.save(korisnik2);
        korisnikRepository.save(korisnik3);

    }
}
