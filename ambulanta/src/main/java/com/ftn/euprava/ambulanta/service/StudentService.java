package com.ftn.euprava.ambulanta.service;

import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student findByUsername(String username){
        return studentRepository.findByUsername(username);
    }


}
