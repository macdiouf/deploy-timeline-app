package fr.simplon.game.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="partie")
public class Partie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Etat etat;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebutPartie;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFinPartie;
	
	@OneToMany(mappedBy="partie")
	@JsonBackReference
	private List<PartieCarte> partiesCarte;
	@Transient
	private int score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Date getDateDebutPartie() {
		return dateDebutPartie;
	}
	public void setDateDebutPartie(Date dateDebutPartie) {
		this.dateDebutPartie = dateDebutPartie;
	}
	public Date getDateFinPartie() {
		return dateFinPartie;
	}
	public void setDateFinPartie(Date dateFinPartie) {
		this.dateFinPartie = dateFinPartie;
	}
	public List<PartieCarte> getPartiesCarte() {
		return partiesCarte;
	}
	public void setPartiesCarte(List<PartieCarte> partiesCarte) {
		this.partiesCarte = partiesCarte;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	

}
