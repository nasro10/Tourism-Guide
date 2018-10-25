package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Flight;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface FlightServiceRemote extends IGenericDAO<Flight> {

	

	List<Flight> fcr(String cn, String ci, Date td, Integer pn);



}
