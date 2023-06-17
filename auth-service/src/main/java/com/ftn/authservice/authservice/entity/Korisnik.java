package com.ftn.authservice.authservice.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;
    private String username;

    @Column(length = 60)
    private String lozinka;

    private String uloga;
    private boolean enabled = false;
}
