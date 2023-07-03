package com.ftn.euprava.ambulanta.controller;

import com.ftn.euprava.ambulanta.service.DoktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/doktor")
public class DoktorController {

    @Autowired
    private DoktorService doktorService;

    @GetMapping("/{username}")
    public ResponseEntity<Boolean> checkDoktor(@PathVariable String username){
        return ResponseEntity.ok(doktorService.doktorOpstePrakse(username));
    }
}
