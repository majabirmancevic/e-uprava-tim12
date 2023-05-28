package com.ftn.euprava.ambulanta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LekarskoUverenjeRequest {

    @NotNull
    @NotBlank
    @Size(min=13, max=13)
    private String jmbg;

    @NotNull
    @NotBlank
    private String ime;

    @NotNull
    @NotBlank
    private String prezime;
}
