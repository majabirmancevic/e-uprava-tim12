package com.ftn.euprava.ambulanta.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Doktor doktor;
    private LocalDateTime pocetakTermina;
    private LocalDateTime krajTermina;
    private StatusTermina statusTermina;
}
