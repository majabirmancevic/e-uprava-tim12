package com.ftn.euprava.ambulanta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Student student;
    private Doktor doktor;
    private LocalDateTime pocetakTermina;
    private LocalDateTime krajTermina;
    private StatusTermina statusTermina;
}
