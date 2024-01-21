package com.ftn.euprava.dom.service;

import com.ftn.euprava.dom.dto.StudentDTO;
import com.ftn.euprava.dom.model.Konkurs;
import com.ftn.euprava.dom.model.Student;
import com.ftn.euprava.dom.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private KonkursService konkursService;

    public void prijaviStudentaNaKonkurs(StudentDTO studentDTO) {
        String username = studentDTO.getUsername();

        Student student = studentRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Student sa datim korisničkim imenom ne postoji"));

        // Setovanje vrednosti na osnovu konkursa
        student.setGodinaStudiranja(studentDTO.getGodinaStudiranja());
        student.setOsvojeniBodovi(studentDTO.getOsvojeniBodovi());
        student.setProsek(studentDTO.getProsek());

        // Računanje bodova po formuli
        double bodovi = studentDTO.getGodinaStudiranja() + (double) studentDTO.getOsvojeniBodovi() / studentDTO.getProsek();
        student.setBodovi(bodovi);

        // Setovanje konkursa
        Konkurs konkurs = konkursService.findKonkursById(studentDTO.getKonkursId())
                .orElseThrow(() -> new IllegalArgumentException("Konkurs sa datim ID-om ne postoji"));
        student.setKonkurs(konkurs);

        // Čuvanje ažuriranog studenta
        studentRepository.save(student);
    }




    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
