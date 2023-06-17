package com.ftn.euprava.ambulanta.service;


import com.ftn.euprava.ambulanta.model.Doktor;
import com.ftn.euprava.ambulanta.model.Student;
import com.ftn.euprava.ambulanta.repository.DoktorRepository;
import com.ftn.euprava.ambulanta.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private DoktorRepository doktorRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = null;
        Doktor doktor = null;
       // Student student = studentRepo.findByUsername(username);
        //Doktor doktor = doktorRepo.findByUsername(username);

        if(studentRepo.findByUsername(username) != null){
            student = studentRepo.findByUsername(username);
        } else if(doktorRepo.findByUsername(username) != null){
            doktor = doktorRepo.findByUsername(username);
        }

        if(student == null && doktor == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            if(student != null){
                String role = "ROLE_STUDENT" ;
                grantedAuthorities.add(new SimpleGrantedAuthority(role));
                return new org.springframework.security.core.userdetails.User(
                        student.getUsername().trim(),
                        student.getLozinka().trim(),
                        grantedAuthorities);
            } else {
                String role = "ROLE_DOKTOR" ;
                grantedAuthorities.add(new SimpleGrantedAuthority(role));
                return new org.springframework.security.core.userdetails.User(
                        doktor.getUsername().trim(),
                        doktor.getLozinka().trim(),
                        grantedAuthorities);
            }
        }
    }
}
