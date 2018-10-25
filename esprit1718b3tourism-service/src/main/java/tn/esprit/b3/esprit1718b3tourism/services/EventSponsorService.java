package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Event_Sponsor;
import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class EventSponsorService
 */
@Stateless
@LocalBean
public class EventSponsorService extends GenericDAO <Event_Sponsor> implements EventSponsorServiceRemote, EventSponsorServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public EventSponsorService() {
    	super(Event_Sponsor.class);
    }
    public List<Event_Sponsor> findAllApplys() {
		return entityManager.createQuery("SELECT t FROM Event_Sponsor t ", Event_Sponsor.class).getResultList(); 

	}
    public List<Event_Sponsor> findAllByEvent(Event event) {
  		return entityManager.createQuery("SELECT t FROM Event_Sponsor t where t.event=:e", Event_Sponsor.class).setParameter("e",event).getResultList(); 

  	}
    
    public Double getSommeMoney(Event event){
    	Double a;
  		return a=(Double) entityManager.createQuery("SELECT SUM(sponsormoney)  FROM Event_Sponsor t where t.event=:e").setParameter("e",event).getSingleResult(); 
 }
    public Double getSommeMoneyByIdEvnt(int id){
    	Double a;
  		return a=(Double) entityManager.createQuery("SELECT SUM(sponsormoney)  FROM Event_Sponsor t where t.event.idEvent="+id).getSingleResult(); 
 }
    public List<Sponsors> getSponsorsByIdEvent(int id){
    	
    	return entityManager.createQuery("select sponsors from Event_Sponsor r  where r.event.idEvent="+id,Sponsors.class).getResultList();

    	}   
   public List<Sponsors> getSponsorsByEvent(String nom){
    	
    	return entityManager.createQuery("select sponsors from Event_Sponsor r  where r.event.eventName=:c",Sponsors.class).setParameter("c",nom).getResultList();

    	}  
   public Float getMoney(int idev,int idsp){
   	Float a;
 		return a=(Float) entityManager.createQuery("SELECT sponsormoney  FROM Event_Sponsor t where t.event.idEvent="+idev+"and t.sponsors.id="+idsp).getSingleResult(); 
}
}
