package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Local;
import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class SponsorsService
 */
@Stateless
@LocalBean
public class SponsorsService extends GenericDAO<Sponsors> implements SponsorsServiceRemote, SponsorsServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
   
    public SponsorsService() {
       super(Sponsors.class);
    }
       
       public Sponsors getSponsorById(int id){
    		return entityManager.createQuery("select r from Sponsors r  where r.id="+id,Sponsors.class).getSingleResult();
    	
    }
   
}
