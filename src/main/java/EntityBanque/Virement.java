package EntityBanque;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation{
	public Virement() {
	}

	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
