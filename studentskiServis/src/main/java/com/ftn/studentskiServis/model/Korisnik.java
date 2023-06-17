package com.ftn.studentskiServis.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jmbg;
    private Boolean aktivnaKartica;
    private Boolean naBudzetu;
    private Boolean uradioLekarski;
}
