package com.ftn.authservice.authservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class KorisnikDTO {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;


    public KorisnikDTO(Korisnik createdUser) {
        this.username = createdUser.getUsername();
        this.password = createdUser.getLozinka();
    }
}
