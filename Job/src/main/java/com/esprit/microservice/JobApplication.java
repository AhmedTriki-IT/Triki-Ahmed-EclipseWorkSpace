package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(JobRepository repository) {
		
		return args->{
			Stream.of("disponible","occupe","disponible").forEach(service->{
				repository.save(new Job(service));
			});
			repository.findAll().forEach(System.out::println);
		};
		
	}

}
