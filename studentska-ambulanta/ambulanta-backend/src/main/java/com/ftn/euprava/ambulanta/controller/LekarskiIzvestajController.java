package com.ftn.euprava.ambulanta.controller;

import com.ftn.euprava.ambulanta.exception.BadRequestException;
import com.ftn.euprava.ambulanta.model.dto.LekarskiIzvestajRequest;
import com.ftn.euprava.ambulanta.service.LekarskiIzvestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/izvestaji")
public class LekarskiIzvestajController {

    @Autowired
    LekarskiIzvestajService lekarskiIzvestajService;

    public ResponseEntity addLekarskiIzvestaj(@Validated @RequestBody LekarskiIzvestajRequest request) throws BadRequestException {
        try {
            Long id = lekarskiIzvestajService.addIzvestaj(request);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            return ResponseEntity.created(location).build();
        }
        catch (BadRequestException e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
}
