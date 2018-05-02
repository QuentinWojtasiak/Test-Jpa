package EntityBanque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {
	public Banque() {
		super();
	}

	@Id
	private Integer id;
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;

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

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
}
