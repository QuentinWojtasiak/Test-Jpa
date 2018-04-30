package Entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Emprunt {

	@Id
	private Integer id;
	@Column(name = "DATE_DEBUT", nullable = false)
	private Date dateDebut;
	@Column(name = "DATE_FIN", nullable = true)
	private Date dateFin;
	@Column(name = "delai", length = 10, nullable = true)
	private Integer delai;
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client idClient;
	
	@ManyToMany
	@JoinTable(name="compo",joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private Set<Livre> livres;

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public Emprunt(){}
	
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", idClient=" + idClient + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	public Client getIdClient() {
		return idClient;
	}
	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}
	
}
