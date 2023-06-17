package com.ftn.euprava.ambulanta.controller;

import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeRequest;
import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeResponse;
import com.ftn.euprava.ambulanta.model.dto.ProveraUverenjaResponse;
import com.ftn.euprava.ambulanta.model.dto.StudentResponse;
import com.ftn.euprava.ambulanta.service.LekarskoUverenjeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/lekarsko-uverenje")
public class LekarskoUverenjeController {

    @Autowired
    private LekarskoUverenjeService lekarskoUverenjeService;

    @PostMapping
    @PreAuthorize("hasRole('DOKTOR')")
    public ResponseEntity<LekarskoUverenjeResponse> generate(@RequestBody @Valid LekarskoUverenjeRequest request){
        return ResponseEntity.ok(lekarskoUverenjeService.addLekarskoUverenje(request));
    }

    // provera studenta da li je uradio lekarski
    @GetMapping("/{jmbg}")
    public ResponseEntity<Boolean> proveraUverenja(@PathVariable String jmbg) {
        if(jmbg == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(lekarskoUverenjeService.proveraUverenjaZaStudenta(jmbg));
    }

    @GetMapping
    public ResponseEntity<List<LekarskoUverenjeResponse>> getAll() {
        return ResponseEntity.ok(lekarskoUverenjeService.getAll());
    }
    @GetMapping("/studenti")
    public ResponseEntity<List<StudentResponse>> getStudents(){
        return ResponseEntity.ok(lekarskoUverenjeService.getStudentiZaUverenje());
    }

}
