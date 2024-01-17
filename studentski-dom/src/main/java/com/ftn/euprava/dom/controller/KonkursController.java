package com.ftn.euprava.dom.controller;

import com.ftn.euprava.dom.dto.KonkursDTO;
import com.ftn.euprava.dom.dto.StudentDTO;
import com.ftn.euprava.dom.service.KonkursService;
import com.ftn.euprava.dom.service.SobeService;
import com.ftn.euprava.dom.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/konkursi")
public class KonkursController {

    @Autowired
    private KonkursService konkursService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SobeService sobeService;

    // ...

    @PostMapping("/{konkursId}/prijavi-se")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Void> prijaviSeNaKonkurs(@PathVariable Long konkursId, Authentication authentication) {
        String username = authentication.getName();
        studentService.prijaviStudentaNaKonkurs(username, konkursId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{konkursId}/rang-lista")
    public ResponseEntity<List<StudentDTO>> getRangLista(@PathVariable Long konkursId) {
        List<StudentDTO> rangLista = konkursService.getPrijavljeniStudenti(konkursId);

        if (rangLista != null && !rangLista.isEmpty()) {
            return ResponseEntity.ok(rangLista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PreAuthorize("hasRole('UPRAVNIK')")
    @PostMapping("/{konkursId}/dodeli-sobu")
    public ResponseEntity<Void> dodeliSobu(@PathVariable Long konkursId,
                                           @RequestParam Long studentId,
                                           @RequestParam Long sobaId) {
        // Provera da li student postoji i da li soba postoji
        if (konkursService.studentPostoji(studentId) && sobeService.sobaPostoji(sobaId)) {
            konkursService.dodeliSobu(studentId, sobaId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}

