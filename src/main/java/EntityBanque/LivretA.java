package EntityBanque;

import javax.persistence.Entity;

@Entity
public class LivretA extends Compte{
	public LivretA() {
		super();
	}

	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
}
