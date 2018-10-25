package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Trip;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface TripServiceRemote extends IGenericDAO<Trip> {

	List<String> stat2(String s);

	Trip found(int i);

	

	

}
