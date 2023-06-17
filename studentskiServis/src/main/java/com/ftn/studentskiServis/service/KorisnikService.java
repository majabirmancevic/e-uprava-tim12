package com.ftn.studentskiServis.service;

import com.ftn.studentskiServis.exception.BadRequestException;
import com.ftn.studentskiServis.model.Korisnik;
import com.ftn.studentskiServis.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    @Lazy
    RestTemplate restTemplate ;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public Korisnik findByJmbg(String jmbg){
        return korisnikRepository.findByJmbg(jmbg);
    }

    public Boolean isAktivnaKartica(String jmbg){
        Korisnik korisnik = findByJmbg(jmbg);
        if(korisnik == null){
            throw new BadRequestException("Korisnik sa ovim korisnickim imenom nije pronadjen!");
        } else if (korisnik.getAktivnaKartica().booleanValue()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isBudzet(String jmbg){
        Korisnik korisnik = findByJmbg(jmbg);
        if(korisnik == null){
            throw new BadRequestException("Korisnik sa ovim korisnickim imenom nije pronadjen!");
        } else if (korisnik.getNaBudzetu().booleanValue()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean changeUradioLekarski(String jmbg){
        Korisnik korisnik = korisnikRepository.findByJmbg(jmbg);
        if(korisnik == null){
            throw new BadRequestException("Korisnik nije pronadjen");
        }
        else {
            if(checkLekarski(jmbg)){
                korisnik.setUradioLekarski(true);
               return true;
            } else {
                return false;
            }
        }
    }

    public Boolean checkLekarski(String jmbg){
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity request = new HttpEntity(headers);
        String url = "http://localhost:9000/api/lekarsko-uverenje/{jmbg}";

        ResponseEntity<Boolean> response = this.restTemplate.exchange(url, HttpMethod.GET,request,Boolean.class,jmbg);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
