package fr.simplon.game.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="categorie")
public class Categorie implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy="categorie")
	@JsonBackReference
	private Set<Carte> cartes =new HashSet<>();
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Carte> getCartes() {
		return cartes;
	}
	public void setCartes(Set<Carte> cartes) {
		this.cartes = cartes;
	}

	
}
