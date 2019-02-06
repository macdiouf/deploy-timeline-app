package fr.simplon.game.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.simplon.game.entities.Categorie;
import fr.simplon.game.exceptions.ResourceNotFoundException;
import fr.simplon.game.repositories.CategorieRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@PostMapping("/categorie")
	public Categorie createCategorie(@RequestBody Categorie categorie){
		return categorieRepository.save(categorie);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/categories")
	public ResponseEntity<Collection<Categorie>> getAllCategories(){
		
		return new ResponseEntity<Collection<Categorie>>(categorieRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/categorie/{id}")
	public Categorie getCategorieById(@PathVariable(value = "id")  Long id){
		return categorieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categorie", "Id", id));
	}
	
	@PutMapping("/categorie/{id}")
	public Categorie updateCategorie(@PathVariable(value = "id") Long id, @RequestBody Categorie categorieDetails){
		Categorie categorie = categorieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categorie", "id", id));
		
		categorie.setNom(categorieDetails.getNom());
		
		return categorieRepository.save(categorie);
	}
	

}
