package EntityBanque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Operation {
	public Operation() {
	}

	@Id
	private Integer id;
	@Column(name = "date", nullable = false)
	private LocalDateTime date;
	@Column(name = "montant", nullable = false)
	private double montant;
	@Column(name = "String")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte compte;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getIdCompte() {
		return compte;
	}

	public void setIdCompte(Compte compte) {
		this.compte = compte;
	}
}
