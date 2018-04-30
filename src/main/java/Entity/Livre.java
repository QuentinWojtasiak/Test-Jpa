package Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Livre")
public class Livre {
	@Id
	private Integer id;
	@Column(name = "titre", length = 255, nullable = false)
	private String titre;
	@Column(name = "auteur", length = 50, nullable = false)
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	public Livre(){}
	
	public Livre(Integer id, String titre, String auteur) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public String toString()
	{
		return "Id : "+ id +" Titre : "+titre+" Auteur : "+auteur;
	}
	
}
