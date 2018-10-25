package tn.esprit.b3.esprit1718b3tourism.services;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking;
import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking_Pk;
import tn.esprit.b3.esprit1718b3tourism.entities.Tripopinion;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface TripopinionServiceRemote extends IGenericDAO<Tripopinion> {

	

	List<Tripopinion> stat1(String s);

	Long stat2(String s);

	List<Tripopinion> stat3(String s);

	List<Tripopinion> stat4(Integer s);

	List<Tripopinion> stat5(Integer s);
	List<Tripopinion> stat6(String s);



}
