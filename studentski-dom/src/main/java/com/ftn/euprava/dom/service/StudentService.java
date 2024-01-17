package com.ftn.euprava.dom.service;

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

    public void prijaviStudentaNaKonkurs(String username, Long konkursId) {
        Optional<Student> studentOptional = studentRepository.findByUsername(username);
        Optional<Konkurs> konkursOptional = konkursService.getKonkursById(konkursId);

        if (studentOptional.isPresent() && konkursOptional.isPresent()) {
            Student student = studentOptional.get();
            Konkurs konkurs = konkursOptional.get();

            // Proveri da li je student već prijavljen na konkurs
            if (!konkurs.getPrijavljeniStudenti().contains(student)) {
                // Ako nije, izračunaj bodove i dodaj studenta na listu prijavljenih
                izracunajBodove(student);
                konkurs.getPrijavljeniStudenti().add(student);
                // Ažuriraj konkurs
                konkursService.updateKonkurs(konkursId, konkurs);
            }
        }
    }

    private void izracunajBodove(Student student) {
        // Implementirajte logiku za izračunavanje bodova
        // Na primer, možete koristiti formulu koju ste naveli (broj bodova + prosjek) / broj godina studiranja
        double bodovi = (student.getOsvojeniBodovi() + student.getProsek()) / student.getGodinaStudiranja();
        student.setBodovi(bodovi);
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
