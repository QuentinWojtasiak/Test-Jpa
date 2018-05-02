package EntityBanque;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client {
	
	public Client() {
		super();
	}

	@Id
	private Integer id;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "prenom", nullable = false)
	private String prenom;
	@Column(name = "dateNaissance", nullable = false)
	private LocalDate dateNaissance;
	
	@ManyToMany(mappedBy="clients")
	private Set<Compte> comptes;
	
	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banque;
	
	@Embedded
	private Adresse adresse;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
