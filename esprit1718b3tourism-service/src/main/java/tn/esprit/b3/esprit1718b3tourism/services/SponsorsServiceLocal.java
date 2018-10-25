package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface SponsorsServiceLocal extends IGenericDAO<Sponsors>{
	public Sponsors getSponsorById(int id);
	
}
