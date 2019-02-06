package fr.simplon.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.simplon.game.entities.Categorie;
import fr.simplon.game.repositories.CategorieRepository;

@SpringBootApplication
public class TimelineBackApplication implements CommandLineRunner {
	
	@Autowired
	private CategorieRepository categorieRepository;

	public static void main(String[] args) {
		SpringApplication.run(TimelineBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		categorieRepository.save(new Categorie("INFORMATIQUE"));
		categorieRepository.save(new Categorie("SPORT"));
	}
	
	

}

