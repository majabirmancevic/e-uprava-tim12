package com.ftn.euprava.dom.service;

import com.ftn.euprava.dom.dto.KonkursDTO;
import com.ftn.euprava.dom.dto.StudentDTO;
import com.ftn.euprava.dom.model.Konkurs;
import com.ftn.euprava.dom.model.Soba;
import com.ftn.euprava.dom.model.Student;
import com.ftn.euprava.dom.repository.KonkursRepository;
import com.ftn.euprava.dom.repository.SobaRepository;
import com.ftn.euprava.dom.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class KonkursService {

    @Autowired
    private KonkursRepository konkursRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SobaRepository sobaRepository;


    public List<KonkursDTO> getAllKonkursi() {
        List<Konkurs> konkursi = konkursRepository.findAll();
        return konkursi.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ...

    private KonkursDTO mapToDTO(Konkurs konkurs) {
        KonkursDTO konkursDTO = new KonkursDTO();
        konkursDTO.setId(konkurs.getId());
        konkursDTO.setGrad(konkurs.getGrad());
        konkursDTO.setSkolskaGodina(konkurs.getSkolskaGodina());
        // Dodajte ostale informacije prema potrebi
        return konkursDTO;
    }
    public Optional<Konkurs> getKonkursById(Long id) {
        return konkursRepository.findById(id);
    }

    public Konkurs createKonkurs(Konkurs konkurs) {
        return konkursRepository.save(konkurs);
    }

    public Konkurs updateKonkurs(Long id, Konkurs updatedKonkurs) {
        Optional<Konkurs> existingKonkurs = konkursRepository.findById(id);
        if (existingKonkurs.isPresent()) {
            return konkursRepository.save(updatedKonkurs);
        }
        return null;
    }

    public void deleteKonkurs(Long id) {
        konkursRepository.deleteById(id);
    }

    public List<StudentDTO> getPrijavljeniStudenti(Long konkursId) {
        Konkurs konkurs = konkursRepository.findById(konkursId).orElse(null);
        if (konkurs != null) {
            // Mapiraj prijavljene studente na DTO objekte
            return konkurs.getPrijavljeniStudenti().stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    private StudentDTO mapToDTO(Student student) {
        // Logika za mapiranje entiteta Student na StudentDTO
        // Uključujući i prikazivanje bodova
        return new StudentDTO(
                student.getId(),
                student.getUsername(),
                student.getIme(),
                student.getPrezime(),
                student.getGodinaStudiranja(),
                student.getBodovi()  // Dodajte ovo ako želite prikazivanje bodova
        );
    }

    public boolean studentPostoji(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    public void dodeliSobu(Long studentId, Long sobaId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Soba soba = sobaRepository.findById(sobaId).orElse(null);

        if (student != null && soba != null) {
            student.setSoba(soba);
            studentRepository.save(student);
        }
    }
}

