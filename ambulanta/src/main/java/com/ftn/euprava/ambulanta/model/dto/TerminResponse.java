package com.ftn.euprava.ambulanta.model.dto;

import com.ftn.euprava.ambulanta.model.SpecijalnostDoktora;
import com.ftn.euprava.ambulanta.model.StatusTermina;
import com.ftn.euprava.ambulanta.model.Termin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TerminResponse {

    private Long id;
    private LocalDateTime pocetakTermina;
    private LocalDateTime krajTermina;
    private String imeDoktora;
    private String specijalnostDoktora;
    private String statusTermina;


    public TerminResponse(Termin termin){
        this.id = termin.getId();
        this.pocetakTermina = termin.getPocetakTermina();
        this.krajTermina = termin.getKrajTermina();
        this.imeDoktora = termin.getDoktor().getIme() + " " + termin.getDoktor().getPrezime();
        this.specijalnostDoktora = SpecijalnostDoktora.returnSpecijalnostString(termin.getDoktor().getSpecijalnost());
        this.statusTermina = termin.getStatusTermina().toString();
    }
}
