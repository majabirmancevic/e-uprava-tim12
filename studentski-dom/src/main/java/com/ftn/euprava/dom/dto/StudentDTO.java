package com.ftn.euprava.dom.dto;

import com.ftn.euprava.dom.model.Kartica;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String jmbg;
    private int godinaStudiranja;
    private int osvojeniBodovi;
    private double prosek;
    private Kartica kartica;
    private double bodovi;

    // Konstruktori, geteri, seteri...

    // Dodajte ovaj konstruktor
    public StudentDTO(Long id, String username, String password, String ime,
                      int godinaStudiranja,
                      double prosek) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.godinaStudiranja = godinaStudiranja;
        this.osvojeniBodovi = osvojeniBodovi;
        this.prosek = prosek;
        this.kartica = kartica;
        this.bodovi = bodovi;
    }

    // Ostali atributi koje želite uključiti
}
