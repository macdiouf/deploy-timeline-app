package fr.simplon.game.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carte")
public class Carte implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String fait;
	@Lob
	private String image;
	private Date dateFait;
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFait() {
		return fait;
	}
	public void setFait(String fait) {
		this.fait = fait;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDateFait() {
		return dateFait;
	}
	public void setDateFait(Date dateFait) {
		this.dateFait = dateFait;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	

}
