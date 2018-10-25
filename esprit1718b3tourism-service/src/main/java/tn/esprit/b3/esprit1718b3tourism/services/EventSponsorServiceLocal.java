package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.Event_Sponsor;
import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface EventSponsorServiceLocal  extends IGenericDAO<Event_Sponsor> {
	public List<Event_Sponsor> findAllApplys();
	public List<Event_Sponsor> findAllByEvent(Event event);
	 public Double getSommeMoney(Event event);
	 public Double getSommeMoneyByIdEvnt(int id);
	 public List<Sponsors> getSponsorsByIdEvent(int id);
	 public List<Sponsors> getSponsorsByEvent(String nom);
	 public Float getMoney(int idev,int idsp);
	 }
