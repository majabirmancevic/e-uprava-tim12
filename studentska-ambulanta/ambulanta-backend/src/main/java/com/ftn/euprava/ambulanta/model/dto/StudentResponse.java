package com.ftn.euprava.ambulanta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentResponse {

    private Long id;
    private String ime;
    private String prezime;
    private String jmbg;
}
