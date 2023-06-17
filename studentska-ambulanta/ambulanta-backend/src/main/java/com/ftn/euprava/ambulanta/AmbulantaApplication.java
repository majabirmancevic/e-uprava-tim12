package com.ftn.euprava.ambulanta;

import com.ftn.euprava.ambulanta.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com/ftn/euprava/ambulanta/repository")
public class AmbulantaApplication implements CommandLineRunner {

	@Autowired
	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(AmbulantaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataService.createUsers();
	}
}
