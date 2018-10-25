package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.Event_Sponsor;
import tn.esprit.b3.esprit1718b3tourism.entities.Event_SponsorId;
import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class EventService
 */
@Stateless
@LocalBean
public class EventService extends GenericDAO <Event>  implements EventServiceRemote, EventServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
	 public List<Event> findEventByManager(int id)
	    {
	    	
	    	return  entityManager.createQuery("select e from Event e where e.eventmanager.id="+id,Event.class).getResultList();
	  
	    }
	 public Event findOneEventByManager(int id)
	    {
	    	//return  entityManager.createQuery("select r from Restaurant r join User u where r.restaurantManager.id=u.id and u.id="+id,Restaurant.class).setParameter(1,id).getSingleResult();
	    	//return  entityManager.createQuery("select r from Restaurant r join r.user u where r.restaurantManager.id=id"+id,Restaurant.class).setParameter(1,id).getSingleResult();
	    	//return  (Restaurant) entityManager.createQuery("SELECT r FROM Restaurant join r.restaurantManager_id e WHERE e.id="+resManager.getId()).getSingleResult();
	    	return  entityManager.createQuery("select r from Event r  where r.idEvent="+id,Event.class).getSingleResult();
	  
	    }
	 
	 public Event getPlaceEventByName(String eventName)
	    {
	     return  entityManager.createQuery("select r from Event r  where r.eventName=:eventName",Event.class).setParameter("eventName",eventName).getSingleResult();
	  
	    }
	
	 
    public EventService() {
    	super(Event.class);
    }
    public List<Event> findEventWherePlacenotnull()
    {
    	
    	return  entityManager.createQuery("select e from Event e where e.local.idLocal!=null",Event.class).getResultList();
  
    }
    
    public List<Event> getEventOrderByDate()
    {
    	
    	return  entityManager.createQuery("select e from Event e order by e.datedebut DESC",Event.class).getResultList();
  
    }
    public Event_Sponsor createPersQuiz(Event_Sponsor quiz1) {
		entityManager.persist(quiz1);
		return quiz1;
	}
    public List<Event_Sponsor> findSponsorsByIdEvent(Integer e) {
		return entityManager.createQuery("select m from Event_Sponsor m where m.event.idEvent=:e",Event_Sponsor.class).setParameter("e", e).getResultList();
	}
    public List<Event_Sponsor> getPerso(Event_SponsorId id){
    	return entityManager.createQuery("select m from Event_Sponsor m where m.id=:c",Event_Sponsor.class).setParameter("c", id).getResultList();
    	
    }
    public Double getSommeMoneyByIdEvnt(int id){
    	Double a;
  		return a=(Double) entityManager.createQuery("SELECT SUM(sponsormoney)  FROM Event_Sponsor t where t.event.idEvent="+id).getSingleResult(); 
 }
    public List<Sponsors> findSponsorByIdEvent(int e) {
		return entityManager.createQuery("select sponsors from Event_Sponsor m where m.event.idEvent=:e",Sponsors.class).setParameter("e", e).getResultList();
	} 
}
