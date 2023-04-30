package com.ftn.euprava.ambulanta.controller;

import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeRequest;
import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeResponse;
import com.ftn.euprava.ambulanta.model.dto.ProveraUverenjaResponse;
import com.ftn.euprava.ambulanta.service.LekarskoUverenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/lekarsko-uverenje")
public class LekarskoUverenjeController {

    @Autowired
    private LekarskoUverenjeService lekarskoUverenjeService;

    @PostMapping
    public ResponseEntity<LekarskoUverenjeResponse> generate(@RequestBody @Valid LekarskoUverenjeRequest request){
        return ResponseEntity.ok(lekarskoUverenjeService.addLekarskoUverenje(request));
    }

    // api za proveru lekarskog uverenja
    @GetMapping("/{jmbg}")
    public ResponseEntity<ProveraUverenjaResponse> proveraUverenja(@PathVariable String jmbg) {
        return ResponseEntity.ok(lekarskoUverenjeService.proveraUverenjaZaStudenta(jmbg));
    }


}
