package com.ftn.euprava.ambulanta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Doktor {

    private String jmbg;
    private String ime;
    private String prezime;
    private String username;
    private SpecijalnostDoktora specijalnost;
}
