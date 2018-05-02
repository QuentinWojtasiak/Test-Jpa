package EntityBanque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	public Compte() {
		super();
	}

	@Id
	private Integer id;
	@Column(name = "numero", nullable = false)
	private String numero;
	@Column(name = "solde", nullable = false)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="Client_Compte",joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID"))
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
}
