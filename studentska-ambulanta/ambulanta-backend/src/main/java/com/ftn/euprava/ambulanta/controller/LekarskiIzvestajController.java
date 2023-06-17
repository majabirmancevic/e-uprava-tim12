package com.ftn.euprava.ambulanta.controller;

import com.ftn.euprava.ambulanta.exception.BadRequestException;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajRequest;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajResponse;
import com.ftn.euprava.ambulanta.model.dto.TerminDoktorResponse;
import com.ftn.euprava.ambulanta.service.LekarskiIzvestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/izvestaji")
public class LekarskiIzvestajController {

    @Autowired
    LekarskiIzvestajService lekarskiIzvestajService;
    @PreAuthorize("hasRole('DOKTOR')")
    @PostMapping
    public HttpStatus addLekarskiIzvestaj(@RequestBody LekarskiIzvestajRequest request) {

        if(lekarskiIzvestajService.addIzvestaj(request)){
            return HttpStatus.CREATED;
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }
//            Boolean isSaved = lekarskiIzvestajService.addIzvestaj(request);
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(id)
//                    .toUri();
    }

    @GetMapping("/by-doktor")
    public ResponseEntity<List<LekarskiIzvestajResponse>> getIzvestajiByLoggedDoctor(Authentication authentication) {
        return ResponseEntity.ok().body(lekarskiIzvestajService.getIzvestajiByDoktor(authentication));
    }
}
