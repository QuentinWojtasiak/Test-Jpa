import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import EntityBanque.*;

public class TestJpaBanque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Client cl = new Client();
		LivretA la = new LivretA();
		Virement v = new Virement();
		Banque bq = new Banque();
		
		bq.setId(1);
		bq.setNom("nom");
		em.persist(bq);
		
		cl.setAdresse(new Adresse(10,"rue",62000,"ville"));
		cl.setId(1);
		cl.setNom("Jean");
		cl.setPrenom("Naimar");
		cl.setDateNaissance(LocalDate.of(01,01,0001));
		
		la.setId(1);
		la.setNumero("1");
		la.setSolde(10);
		la.setTaux(10);
				
		v.setId(1);
		v.setIdCompte(la);
		v.setMontant(10);
		v.setMotif("parce que");
		v.setDate(LocalDateTime.of(0001,01,01,01, 0));
		
		Set<Client> clients = new HashSet<Client>();
		clients.add(cl);
		Set<Operation> virements = new HashSet<Operation>();
		virements.add(v);
		Set<Compte> comptes = new HashSet<Compte>();
		comptes.add(la);
		
		bq.setClients(clients);
		la.setOperations(virements);
		la.setClients(clients);
		cl.setBanque(bq);
		cl.setComptes(comptes);
		
		em.persist(cl);
		em.persist(la);
		em.persist(v);
		
		et.commit();
		em.close();
	}

}
