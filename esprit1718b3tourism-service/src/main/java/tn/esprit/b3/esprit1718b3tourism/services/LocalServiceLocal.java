package tn.esprit.b3.esprit1718b3tourism.services;


import java.util.List;

import tn.esprit.b3.esprit1718b3tourism.entities.Local;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@javax.ejb.Local
public interface LocalServiceLocal extends IGenericDAO<Local> {
	public List<Local> getwordfromdescription(String eventName);
	public List<Local>getplace(int id);
	public Local getLocalById(int id);
	
	
	}