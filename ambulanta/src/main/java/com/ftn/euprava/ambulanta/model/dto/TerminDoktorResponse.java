package com.ftn.euprava.ambulanta.model.dto;

import com.ftn.euprava.ambulanta.model.Doktor;
import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.model.Termin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TerminDoktorResponse {
    private Long id;
    private Student student;
    private Doktor doktor;
    private String pocetakTermina;
    private String krajTermina;
    private String statusTermina;


    public TerminDoktorResponse(Termin termin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.id = termin.getId();
        this.student = termin.getStudent();
        this.doktor = termin.getDoktor();
        this.pocetakTermina = termin.getPocetakTermina().format(formatter);
        this.krajTermina = termin.getKrajTermina().format(formatter);
        this.statusTermina = termin.getStatusTermina().toString();
    }
}
