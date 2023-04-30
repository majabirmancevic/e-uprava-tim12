package com.ftn.euprava.ambulanta.model.dto;

import com.ftn.euprava.ambulanta.model.SpecijalnostDoktora;
import com.ftn.euprava.ambulanta.model.StatusTermina;
import com.ftn.euprava.ambulanta.model.Termin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TerminResponse {

    private Long id;
    private String pocetakTermina;
    private String krajTermina;
    private String imeDoktora;
    private String specijalnostDoktora;
    private String statusTermina;


    public TerminResponse(Termin termin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.id = termin.getId();
        this.pocetakTermina = termin.getPocetakTermina().format(formatter);
        this.krajTermina = termin.getKrajTermina().format(formatter);
        this.imeDoktora = termin.getDoktor().getIme() + " " + termin.getDoktor().getPrezime();
        this.specijalnostDoktora = SpecijalnostDoktora.returnSpecijalnostString(termin.getDoktor().getSpecijalnost());
        this.statusTermina = termin.getStatusTermina().toString();
    }
}
