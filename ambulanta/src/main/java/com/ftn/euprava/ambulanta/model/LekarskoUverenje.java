package com.ftn.euprava.ambulanta.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class LekarskoUverenje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentJmbg;

    private String poruka;

    public LekarskoUverenje(String studentJmbg, String poruka) {
        this.studentJmbg = studentJmbg;
        this.poruka = poruka;
    }
}
