package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Flight;


import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService extends GenericDAO<Flight> implements FlightServiceLocal , FlightServiceRemote{
	@PersistenceContext
	private EntityManager entityManager;
	public FlightService() {
		super(Flight.class);
	}
	@Override
	public List <Flight> fcr(String cn , String ci, Date td , Integer pn) {
		
		List<Flight> LF = null;
		
		
		try {
			LF = entityManager.createQuery("select fl from Flight fl where fl.travelDateF=:td AND fl.homeCountryF=:co AND fl.destinationCityF=:ci AND fl.placesF>:pn  ", Flight.class)
					.setParameter("td", td).setParameter("co", cn).setParameter("ci", ci).setParameter("pn", pn).getResultList();
		} catch (Exception e) {
		}
		
		
		
		
		return LF;
	}



}
