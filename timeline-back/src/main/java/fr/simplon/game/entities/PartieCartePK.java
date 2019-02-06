package fr.simplon.game.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class PartieCartePK implements Serializable{

	@Column(name="id_partie", insertable=false, updatable=false)
	private Long idPartie;
	
	@Column(name="id_carte", insertable=false, updatable=false)
	private Long idCarte;
	
	
	
	
	public Long getIdPartie() {
		return idPartie;
	}




	public void setIdPartie(Long idPartie) {
		this.idPartie = idPartie;
	}




	public Long getIdCarte() {
		return idCarte;
	}




	public void setIdCarte(Long idCarte) {
		this.idCarte = idCarte;
	}




	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartieCartePK)) {
			return false;
		}
		PartieCartePK castOther = (PartieCartePK)other;
		return 
			this.idPartie.equals(castOther.idPartie)
			&& this.idCarte==castOther.idCarte;
	}
}

