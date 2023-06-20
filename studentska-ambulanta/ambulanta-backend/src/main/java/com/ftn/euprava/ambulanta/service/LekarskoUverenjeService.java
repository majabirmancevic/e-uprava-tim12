package com.ftn.euprava.ambulanta.service;
import com.ftn.euprava.ambulanta.exception.BadRequestException;
import com.ftn.euprava.ambulanta.exception.NotAcceptableException;
import com.ftn.euprava.ambulanta.model.LekarskoUverenje;
import com.ftn.euprava.ambulanta.model.Pol;
import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeRequest;
import com.ftn.euprava.ambulanta.model.dto.LekarskoUverenjeResponse;
import com.ftn.euprava.ambulanta.model.dto.ProveraUverenjaResponse;
import com.ftn.euprava.ambulanta.model.dto.StudentResponse;
import com.ftn.euprava.ambulanta.repository.LekarskoUverenjeRepository;
import com.ftn.euprava.ambulanta.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LekarskoUverenjeService {

    @Autowired
    private LekarskoUverenjeRepository lekarskoUverenjeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public LekarskoUverenjeResponse addLekarskoUverenje(LekarskoUverenjeRequest request) throws NotAcceptableException {
        Student student = studentRepository.findByJmbg(request.getJmbg());
        List<LekarskoUverenje> uverenja = lekarskoUverenjeRepository.findAll();
        for(LekarskoUverenje lu : uverenja){
            if(lu.getStudentJmbg().equals(student.getJmbg())){
                throw new BadRequestException("Vec postoji lekarsko uverenje");
            }
        }

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

    public List<StudentResponse> getStudentiZaUverenje(){
        List<StudentResponse> studenti = new ArrayList<StudentResponse>();
        List<Student> sviStudenti = studentRepository.findAll();
        for(Student s : sviStudenti){
            if(proveraPregleda(s)){
                StudentResponse studentForList = new StudentResponse();
                studentForList.setId(s.getId());
                studentForList.setIme(s.getIme());
                studentForList.setPrezime(s.getPrezime());
                studentForList.setJmbg(s.getJmbg());
                studenti.add(studentForList);
            }
        }
        return studenti;
    }

    public List<LekarskoUverenjeResponse> getAll(){
        List<LekarskoUverenjeResponse> response = new ArrayList<>();
        List<LekarskoUverenje> uverenja = lekarskoUverenjeRepository.findAll();

        for(LekarskoUverenje u : uverenja){
            LekarskoUverenjeResponse lur = new LekarskoUverenjeResponse();
            lur.setOpis(u.getPoruka());
            response.add(lur);
        }
        return response;
    }

    public Boolean proveraUverenjaZaStudenta(final String jmbg) {
        LekarskoUverenje uverenje = lekarskoUverenjeRepository.findByStudentJmbg(jmbg);
        if(uverenje == null) {
            //return new ProveraUverenjaResponse(false);
            return false;
        }
        //return new ProveraUverenjaResponse(true);
        return true;
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
