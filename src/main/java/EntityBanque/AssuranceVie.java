package EntityBanque;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte{
	public AssuranceVie() {
		super();
	}
	private double taux;
	private LocalDate dateFin;
}
