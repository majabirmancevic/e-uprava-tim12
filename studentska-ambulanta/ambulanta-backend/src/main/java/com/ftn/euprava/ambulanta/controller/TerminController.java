package com.ftn.euprava.ambulanta.controller;

import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajResponse;
import com.ftn.euprava.ambulanta.model.dto.TerminDoktorResponse;
import com.ftn.euprava.ambulanta.model.dto.TerminResponse;
import com.ftn.euprava.ambulanta.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/termini")
public class TerminController {
    @Autowired
    private TerminService terminService;

    @GetMapping("/history/student")
    public ResponseEntity<List<TerminResponse>> getZavrseniTerminiStudenta(Authentication authentication) {
        return ResponseEntity.ok().body(terminService.getAllDoneTerminByStudent(authentication) );
    }

    @GetMapping("/doktor")
    public ResponseEntity<List<TerminDoktorResponse>> getAppointmentByLoggedDoctor(Authentication authentication) {
        return ResponseEntity.ok().body(terminService.getAllTerminByDoktor(authentication));
    }

    @GetMapping("/free/{specijalnost}/{date}")
    public ResponseEntity<List<TerminResponse>> getFreeTermini(@PathVariable("specijalnost") String specijalnost, @PathVariable("date") String date) {
        return ResponseEntity.ok().body(terminService.getAllFreeTerminBySpecijalnostAndDate(specijalnost,date));
    }

    @GetMapping("/{terminId}/izvestaj")
    public ResponseEntity<LekarskiIzvestajResponse> getLekarskiIzvestaj(@PathVariable("terminId") Long terminId){
        return ResponseEntity.ok().body(terminService.getLekarskiIzvestaj(terminId));

    }

    @PutMapping("/{termin-id}")
    public void zakaziTermin(@PathVariable("termin-id") Long termin_id, Authentication authentication) {
        terminService.zakaziTermin(termin_id, authentication);
    }

}
