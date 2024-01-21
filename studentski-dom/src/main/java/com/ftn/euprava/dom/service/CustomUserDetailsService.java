package com.ftn.euprava.dom.service;

import com.ftn.euprava.dom.model.Student;
import com.ftn.euprava.dom.model.Upravnik;
import com.ftn.euprava.dom.repository.StudentRepository;
import com.ftn.euprava.dom.repository.UpravnikRepository;
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
    private UpravnikRepository upravnikRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByUsername(username).orElse(null);
        Upravnik upravnik = upravnikRepo.findByUsername(username);

        if (student == null && upravnik == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            if (student != null) {
                String role = "ROLE_STUDENT";
                grantedAuthorities.add(new SimpleGrantedAuthority(role));
                return new org.springframework.security.core.userdetails.User(
                        student.getUsername().trim(),
                        student.getPassword().trim(),
                        grantedAuthorities);
            } else {
                String role = "ROLE_UPRAVNIK";
                grantedAuthorities.add(new SimpleGrantedAuthority(role));
                return new org.springframework.security.core.userdetails.User(
                        upravnik.getUsername().trim(),
                        upravnik.getPassword().trim(),
                        grantedAuthorities);
            }
        }
    }
}

