package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.Event_Sponsor;
import tn.esprit.b3.esprit1718b3tourism.entities.Event_SponsorId;
import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface EventServiceLocal extends IGenericDAO<Event> {
	public List<Event> findEventByManager(int id);
	 public Event findOneEventByManager(int id);
	 public Event getPlaceEventByName(String eventName);
	 public List<Event> findEventWherePlacenotnull();
	 public List<Event> getEventOrderByDate();
	 public Event_Sponsor createPersQuiz(Event_Sponsor quiz1);
	 public List<Event_Sponsor> findSponsorsByIdEvent(Integer e);
	 public List<Event_Sponsor> getPerso(Event_SponsorId id);
	 public Double getSommeMoneyByIdEvnt(int id);
	 public List<Sponsors> findSponsorByIdEvent(int e);
}
