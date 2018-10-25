package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Countries;
import tn.esprit.b3.esprit1718b3tourism.entities.Trip;
import tn.esprit.b3.esprit1718b3tourism.entities.Tripopinion;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class TripService
 */
@Stateless
@LocalBean
public class TripService extends GenericDAO<Trip> implements  TripServiceRemote , TripServiceLocal{
	@PersistenceContext
	private EntityManager entityManager;
	public TripService() {
		super(Trip.class);
	}
	@Override
	public List<String> stat2(String s) {
	
		List<String> ld;
		
		
		
			ld =(List<String>) entityManager.createQuery("select top.destination  from Trip top").getResultList();
					
		return ld;
		
		
		
	}
	@Override
	public Trip found(int i){
		Trip tr = null;
		
		tr= entityManager.createQuery("select co from Trip co where co.idTrip=:id ", Trip.class)
				.setParameter("id", i).getSingleResult();
		
		return tr;
	}


}
 


