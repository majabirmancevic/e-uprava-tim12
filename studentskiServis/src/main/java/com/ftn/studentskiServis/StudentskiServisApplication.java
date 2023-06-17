package com.ftn.studentskiServis;

import com.ftn.studentskiServis.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentskiServisApplication implements CommandLineRunner {
	@Autowired
	private DataService dataService;
	public static void main(String[] args) {
		SpringApplication.run(StudentskiServisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataService.createUsers();
	}
}
