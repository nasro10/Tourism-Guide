package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.Local;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class LocalService
 */
@Stateless
@LocalBean
public class LocalService extends GenericDAO <Local> implements LocalServiceRemote, LocalServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public LocalService() {
    	super(Local.class);
    }
    
    public List<Local> getwordfromdescription(String eventName){
    	
    	return  entityManager.createQuery("select l from Local l where l.description like '%' || :eventName || '%'",Local.class).setParameter("eventName",eventName).getResultList();
    	
    }
  public List<Local>getplace(int id){
    	
    	return  entityManager.createQuery("select l from Local l where l.localPlaces>="+id+"order by l.localPlaces",Local.class).getResultList();
    	
    }
public Local getLocalById(int id){
	return entityManager.createQuery("select r from Local r  where r.idLocal="+id,Local.class).getSingleResult();
}


}
