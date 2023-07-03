package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Service
public class DataService {
    @Autowired
    private DoktorService doktorService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private TerminService terminService;

    @Autowired
    private LekarskiIzvestajService izvestajService;


    public void createUsers(){
        Doktor doktor = new Doktor();
        doktor.setJmbg("1234567899876");
        doktor.setIme("Natasa");
        doktor.setPrezime("Djurica");
        doktor.setUsername("natasa123");
        doktor.setLozinka("natasa123");
        doktor.setSpecijalnost(SpecijalnostDoktora.STOMATOLOG);

        Doktor doktor1 = new Doktor();
        doktor1.setJmbg("9876543211234");
        doktor1.setIme("Andjela");
        doktor1.setPrezime("Smiljanic");
        doktor1.setUsername("andjela123");
        doktor1.setLozinka("andjela123");
        doktor1.setSpecijalnost(SpecijalnostDoktora.GINEKOLOG);

        Doktor doktor2 = new Doktor();
        doktor2.setJmbg("1112223334445");
        doktor2.setIme("Dragana");
        doktor2.setPrezime("Mirkovic");
        doktor2.setUsername("dragana123");
        doktor2.setLozinka("dragana123");
        doktor2.setSpecijalnost(SpecijalnostDoktora.OPSTA_PRAKSA);

        doktorService.save(doktor);
        doktorService.save(doktor1);
        doktorService.save(doktor2);

        Student student = new Student();
        student.setJmbg("1122334455667");
        student.setUsername("milica123");
        student.setLozinka("milica123");
        student.setIme("Milica");
        student.setPrezime("Radojevic");
        student.setPol(Pol.ZENSKI);
        student.setStomatolog(false);
        student.setGinekolog(false);
        student.setOpstaPraksa(false);

        Student student1 = new Student();
        student1.setJmbg("3322114433441");
        student1.setUsername("maja123");
        student1.setLozinka("maja123");
        student1.setIme("Maja");
        student1.setPrezime("Birmancevic");
        student1.setPol(Pol.ZENSKI);
        student1.setStomatolog(false);
        student1.setGinekolog(false);
        student1.setOpstaPraksa(false);

        studentService.save(student);
        studentService.save(student1);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//
//        Termin termin = new Termin();
//        termin.setStudent(null);
//        termin.setDoktor(doktor);
//        termin.setPocetakTermina(LocalDateTime.parse("2023-06-19 16:30",formatter));
//        termin.setKrajTermina(LocalDateTime.parse("2023-06-19 16:45",formatter));
//        termin.setStatusTermina(StatusTermina.SLOBODAN);
//
//
//        Termin termin1 = new Termin();
//
//        termin1.setStudent(null);
//        termin1.setDoktor(doktor1);
//
//        //LocalDateTime dt1 = LocalDateTime.of(2023, Month.JUNE,17,10,0);
//        String newDate = "2023-06-18 17:10";
//        //String newDate = dt1.format(formatter);
//        termin1.setPocetakTermina(LocalDateTime.parse(newDate,formatter));
//
//        //LocalDateTime dt2 =LocalDateTime.of(2023, Month.JUNE,17,10,15);
//        String newDate2 = "2023-06-18 16:15";
//        termin1.setKrajTermina(LocalDateTime.parse(newDate2,formatter));
//
//        termin1.setStatusTermina(StatusTermina.SLOBODAN);
//
//        terminService.save(termin);
//        terminService.save(termin1);
    }


}
