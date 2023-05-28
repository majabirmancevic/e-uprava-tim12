package com.ftn.euprava.ambulanta.model.dto;

import com.ftn.euprava.ambulanta.model.LekarskiIzvestaj;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LekarskiIzvestajResponse {
    private Long id;
    private String opis;

    public LekarskiIzvestajResponse(LekarskiIzvestaj izvestaj){
        this.id = izvestaj.getId();
        this.opis = izvestaj.getOpis();
    }

}
