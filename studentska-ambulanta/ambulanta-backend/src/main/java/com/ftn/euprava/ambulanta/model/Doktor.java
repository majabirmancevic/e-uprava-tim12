package com.ftn.euprava.ambulanta.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Doktor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String jmbg;
    private String ime;
    private String prezime;
    @Column(unique=true)
    private String username;

    private String lozinka;
    private SpecijalnostDoktora specijalnost;
}
