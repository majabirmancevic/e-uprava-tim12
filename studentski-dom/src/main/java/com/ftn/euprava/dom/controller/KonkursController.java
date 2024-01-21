package com.ftn.euprava.dom.controller;

import com.ftn.euprava.dom.dto.KonkursDTO;
import com.ftn.euprava.dom.dto.StudentDTO;
import com.ftn.euprava.dom.model.Soba;
import com.ftn.euprava.dom.model.Student;
import com.ftn.euprava.dom.repository.SobaRepository;
import com.ftn.euprava.dom.repository.StudentRepository;
import com.ftn.euprava.dom.service.KonkursService;
import com.ftn.euprava.dom.service.SobeService;
import com.ftn.euprava.dom.service.StudentService;
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
import java.util.Optional;

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

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private SobaRepository sobaRepository;


    @GetMapping
//    @PreAuthorize("hasRole('STUDENT')")

    public ResponseEntity<List<KonkursDTO>> getAllKonkursi() {
        List<KonkursDTO> konkursi = konkursService.getAllKonkursi();

        if (konkursi != null && !konkursi.isEmpty()) {
            return ResponseEntity.ok(konkursi);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/prijavi-se-na-konkurs")
    public ResponseEntity<String> prijaviSeNaKonkurs(@RequestBody StudentDTO studentDTO) {
        try {
            studentService.prijaviStudentaNaKonkurs(studentDTO);
            return new ResponseEntity<>("Student je uspešno prijavljen na konkurs.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/rang-lista")
    public List<Student> getRangLista() {
        return studentRepository.findByBodoviGreaterThan(0);
    }

//    @PreAuthorize("hasRole('UPRAVNIK')")
//    @PostMapping("/{konkursId}/dodeli-sobu")
//    public ResponseEntity<Void> dodeliSobu(@PathVariable Long konkursId,
//                                           @RequestParam Long studentId,
//                                           @RequestParam Long sobaId) {
//        // Provera da li student postoji i da li soba postoji
//        if (konkursService.studentPostoji(studentId) && sobeService.sobaPostoji(sobaId)) {
//            konkursService.dodeliSobu(studentId, sobaId);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @GetMapping("/rang-lista-soba")
    public ResponseEntity<List<Student>> getRangListaSobaNull() {
        List<Student> rangLista = studentRepository.findByBodoviGreaterThanAndSobaIsNull(0);

        if (rangLista != null && !rangLista.isEmpty()) {
            return ResponseEntity.ok(rangLista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/dodeli-sobu")
    public ResponseEntity<Void> dodeliSobu(@RequestParam String username, @RequestParam Long sobaId) {
        try {

            Optional<Student> studentOptional = studentRepository.findByUsername(username);
            Optional<Soba> sobaOptional = sobaRepository.findById(sobaId);

            if (studentOptional.isPresent() && sobaOptional.isPresent()) {
                Student student = studentOptional.get();
                Soba soba = sobaOptional.get();

                student.setSoba(soba);

                studentRepository.save(student);

                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{username}/soba-info")
    public ResponseEntity<Student> getSobaInfoByUsername(@PathVariable String username) {
        try {
            Optional<Student> studentOptional = studentRepository.findByUsername(username);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                Soba soba = student.getSoba();

                if (soba != null) {
                    // Možete direktno koristiti Student objekat za prikaz informacija
                    return ResponseEntity.ok(student);
                }
            }

            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

