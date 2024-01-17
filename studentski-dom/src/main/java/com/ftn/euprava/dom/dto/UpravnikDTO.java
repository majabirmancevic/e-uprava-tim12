package com.ftn.euprava.dom.dto;

import lombok.Data;

@Data
public class UpravnikDTO {
    private Long id;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String jmbg;
    // Ostali atributi koje želite uključiti

    // Konstruktori, geteri, seteri...
}
