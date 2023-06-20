package com.ftn.studentskiServis.controller;

import com.ftn.studentskiServis.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servis")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/kartica/{jmbg}")
    public ResponseEntity<Boolean> proveraKartice(@PathVariable("jmbg") String jmbg){
        if(jmbg == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(korisnikService.isAktivnaKartica(jmbg));
    }

    @GetMapping("/budzet/{jmbg}")
    public ResponseEntity<Boolean> proveraBudzeta(@PathVariable("jmbg") String jmbg){
        if(jmbg == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(korisnikService.isBudzet(jmbg));
    }

    @PutMapping("/lekarski/{jmbg}")
    public ResponseEntity<Boolean> callAmbulanta(@PathVariable("jmbg") String jmbg){
        if(jmbg == null){
             return ResponseEntity.badRequest().body(false);
        }
        return ResponseEntity.ok(korisnikService.changeUradioLekarski(jmbg));
    }
}
