package com.ftn.euprava.ambulanta.service;
import com.ftn.euprava.ambulanta.exception.NotAcceptableException;
import com.ftn.euprava.ambulanta.model.LekarskoUverenje;
import com.ftn.euprava.ambulanta.model.Pol;
import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeRequest;
import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeResponse;
import com.ftn.euprava.ambulanta.model.dto.ProveraUverenjaResponse;
import com.ftn.euprava.ambulanta.repository.LekarskoUverenjeRepository;
import com.ftn.euprava.ambulanta.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LekarskoUverenjeService {

    @Autowired
    private LekarskoUverenjeRepository lekarskoUverenjeRepository;

    @Autowired
    private StudentRepository studentRepository;

    // TODO : PROVERA JMBG-A KOD MATICARA
    public LekarskoUverenjeResponse addLekarskoUverenje(LekarskoUverenjeRequest request) throws NotAcceptableException {
        Student student = studentRepository.findByJmbg(request.getJmbg());
        if(proveraPregleda(student)) {
            LekarskoUverenjeResponse response = new LekarskoUverenjeResponse("Izdaje se lekarsko uverenje za "
                    + request.getIme() + " " + request.getPrezime() + ", JMBG: " + request.getJmbg()
                    + ". Datum izdavanja : " + LocalDate.now());

            LekarskoUverenje lekarskoUverenje = new LekarskoUverenje(request.getJmbg(), response.getOpis());
            lekarskoUverenjeRepository.save(lekarskoUverenje);
            return response;
        }else {
            throw new NotAcceptableException("Student nije uradio sve potrebne preglede!");
        }
    }

    public ProveraUverenjaResponse proveraUverenjaZaStudenta(final String jmbg) {
        LekarskoUverenje uverenje = lekarskoUverenjeRepository.findByStudentJmbg(jmbg);
        if(uverenje == null) {
            return new ProveraUverenjaResponse(false);
        }
        return new ProveraUverenjaResponse(true);
    }

    private Boolean proveraPregleda (Student student){
        Boolean uradio = false;

        if(student.getPol().equals(Pol.MUSKI)){
            if (student.getStomatolog() && student.getOpstaPraksa()) {
                uradio = true;
            }
        }
        if(student.getPol().equals(Pol.ZENSKI)){
            if (student.getStomatolog() && student.getOpstaPraksa() && student.getGinekolog()) {
                uradio = true;
            }
        }

        return uradio;
    }
}
