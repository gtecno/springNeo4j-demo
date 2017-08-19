package com.demo.sprinbootgneo4j.demospringbootneo4j;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class Demospringbootneo4jApplication {

	private final static Logger log = LoggerFactory.getLogger(Demospringbootneo4jApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Demospringbootneo4jApplication.class, args);
	}


	@Bean
	CommandLineRunner demo(PersonRepository personRepository, MovieRepository movieRepository) {
		return args -> {

			personRepository.deleteAll();

			Person greg = new Person("Greg");
			Person roy = new Person("Roy");
			Person craig = new Person("Craig");
			Person gregorio = new Person("Gregorio");
			Person royer = new Person("Royer");
			Person craiglo = new Person("Craiglo");

			List<Person> team = Arrays.asList(greg, roy, craig,gregorio,royer,craiglo);

			log.info("Before linking up with Neo4j...");

			team.stream().forEach(person -> log.info("\t" + person.toString()));

			personRepository.save(greg);
			personRepository.save(roy);
			personRepository.save(craig);
			personRepository.save(gregorio);
			personRepository.save(royer);
			personRepository.save(craiglo);

			greg = personRepository.findByName(greg.getName());
			greg.worksWith(roy);
			greg.worksWith(craig);
			personRepository.save(greg);

			roy = personRepository.findByName(roy.getName());
			roy.worksWith(craig);
			// We already know that roy works with greg
			personRepository.save(roy);


			royer = personRepository.findByName(royer.getName());
     		royer.worksWith(craig);
			royer.worksWith(royer);
			personRepository.save(royer);



			gregorio = personRepository.findByName(gregorio.getName());
			gregorio.worksWith(roy);
			gregorio.worksWith(craig);
			gregorio.worksWith(royer);
			personRepository.save(gregorio);


			craig = personRepository.findByName(craig.getName());
			craig.amigos(craiglo);
			personRepository.save(craig);

			// We already know craig works with roy and greg

			log.info("Lookup each person by name...");
			team.stream().forEach(person -> log.info(
					"\t" + personRepository.findByName(person.getName()).toString()));


			movieRepository.deleteAll();
			Movie matrix = new Movie("Matrix",craig);
			Movie matrixReload = new Movie("Matrix Recargado",craig);
			Movie matrix3 = new Movie("Matrix 3",craig);
			Movie batman = new Movie("Batman",gregorio);
			Movie supermans = new Movie("Superman",craig);

			Set<Person> actores = new HashSet<>();
			actores.addAll(team);
			matrix.getActors(actores);

			List<Movie> movies = Arrays.asList(matrix, matrixReload,matrix3,batman,supermans);
			movieRepository.save(movies);




		};
	}
}
