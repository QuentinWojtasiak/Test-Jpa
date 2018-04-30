import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Entity.Client;
import Entity.Emprunt;
import Entity.Livre;

public class TestJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizza-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		if(em!=null)
		{
			LOG.info("instance d'em créée.");
		}
		
		/*Livre livre = em.find(Livre.class, 1);
		LOG.info(livre.toString());
		
		Query query = em.createQuery("select l from Livre l where l.titre='Germinal'");
		Livre livre2 = (Livre)query.getResultList().get(0);
		LOG.info(livre2.toString());*/
		
		Query query2 = em.createQuery("select e from Emprunt e where e.id='1'");
		Set<Livre> livres = ((Emprunt)query2.getSingleResult()).getLivres();
		for(Livre l:livres)
		{
			LOG.info(l.toString());
		}

		Query query3 = em.createQuery("select c from Client c where c.id='1'");
		Set<Emprunt> Emprunts = ((Client)query3.getSingleResult()).getEmprunts();
		for(Emprunt e:Emprunts)
		{
			LOG.info(e.toString());
		}
	}

}
