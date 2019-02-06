package fr.simplon.game.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partie_cartie")
public class PartieCarte implements Serializable {
	
	@EmbeddedId
	private PartieCartePK id;
	
	@ManyToOne
	@JoinColumn(name="id_partie", insertable=false, updatable=false)
	private Partie partie;
	
	@ManyToOne
	@JoinColumn(name="id_carte", insertable=false, updatable=false)
	private Carte carte;
	
	private boolean deviner;

	public PartieCartePK getId() {
		return id;
	}

	public void setId(PartieCartePK id) {
		this.id = id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public boolean isDeviner() {
		return deviner;
	}

	public void setDeviner(boolean deviner) {
		this.deviner = deviner;
	}
	
	

}
