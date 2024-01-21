package com.ftn.euprava.dom.dto;

import com.ftn.euprava.dom.model.Kartica;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String jmbg;
    private int godinaStudiranja;
    private int osvojeniBodovi;
    private double prosek;
    private Kartica kartica;
    private double bodovi;
    private Long konkursId;
    private Long sobaId;


}
