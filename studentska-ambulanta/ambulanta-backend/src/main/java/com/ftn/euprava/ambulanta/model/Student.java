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
    @Column(unique=true)
    private String jmbg;
    @Column(unique=true)
    private String username;
    private String ime;
    private String prezime;
    private Pol pol;
    private Boolean stomatolog;
    private Boolean ginekolog;

    private Boolean opstaPraksa;

}
