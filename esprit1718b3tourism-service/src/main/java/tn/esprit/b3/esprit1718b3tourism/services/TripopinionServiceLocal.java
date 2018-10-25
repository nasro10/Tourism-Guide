package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking;
import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking_Pk;
import tn.esprit.b3.esprit1718b3tourism.entities.Tripopinion;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;
@Local
public interface TripopinionServiceLocal extends IGenericDAO<Tripopinion> {
	List<Tripopinion> stat1(String s);
	Long stat2(String s);
	List<Tripopinion> stat3(String s);
	List<Tripopinion> stat4(Integer s);
	List<Tripopinion> stat5(Integer s);
	List<Tripopinion> stat6(String s);
	
}
