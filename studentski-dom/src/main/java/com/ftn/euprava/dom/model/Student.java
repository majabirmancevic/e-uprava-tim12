package com.ftn.euprava.dom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String jmbg;
    private int godinaStudiranja;
    private int osvojeniBodovi;
    private double prosek;
    private double bodovi;

    @Enumerated(EnumType.STRING)
    private Kartica kartica;


    public void setBodovi(double bodovi) {
        this.bodovi = bodovi;
    }


    @ManyToOne
    @JoinColumn(name = "soba_id")
    private Soba soba;

    @ManyToOne
    @JoinColumn(name = "konkurs_id")
    private Konkurs konkurs;}

