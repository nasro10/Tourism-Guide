package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.States;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface StatesServiceLocal extends IGenericDAO<States>{

	List<States> mapcs(String cn, int ci);

}
