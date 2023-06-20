package com.ftn.euprava.ambulanta.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "uverenja")
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
