package com.ftn.euprava.ambulanta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jmbg;

    private String username;
    private String ime;
    private String prezime;
    private Pol pol;
    private Boolean obavioPregled;
}
