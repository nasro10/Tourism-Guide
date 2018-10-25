package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Countries;
import tn.esprit.b3.esprit1718b3tourism.entities.States;
import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking;
import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking_Pk;
import tn.esprit.b3.esprit1718b3tourism.entities.Tripopinion;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class TripopinionService
 */
@Stateless
@LocalBean
public class TripopinionService extends GenericDAO<Tripopinion> implements TripopinionServiceLocal , TripopinionServiceRemote{
	@PersistenceContext
	private EntityManager entityManager;
	public TripopinionService() {
		super(Tripopinion.class);
	}
	@Override
	public List <Tripopinion> stat1(String s) {
	
		List<Tripopinion> LTO = null;
		
		
		
			LTO = entityManager.createQuery("select to from Tripopinion to where to.tripop=:name  ", Tripopinion.class)
					.setParameter("name", s).getResultList();
		
		
		
		
		
		return LTO;
	}
	@Override
	public Long stat2(String s) {
	
		List<Tripopinion> LTO = null;
		Long nb = null;
		
		
			nb =  (Long) entityManager.createQuery("select COUNT(top.id) from Tripopinion  top ")
					.getSingleResult();
		return nb;
		
		
		
	}
	@Override
	public List <Tripopinion> stat3(String s) {
	
		List<Tripopinion> LTO = null;
		
		
		
			LTO = entityManager.createQuery("select to from Tripopinion to where to.priceop=:name  ", Tripopinion.class)
					.setParameter("name", s).getResultList();
		
		
		
		
		
		return LTO;
	}
	@Override
	public List <Tripopinion> stat4(Integer s) {
	
		List<Tripopinion> LTO = null;
		
		
		
			LTO = entityManager.createQuery("select to from Tripopinion to where to.ratedest=:name  ", Tripopinion.class)
					.setParameter("name", s).getResultList();
		
		
		
		
		
		return LTO;
	}
	@Override
	public List <Tripopinion> stat5(Integer s) {
	
		List<Tripopinion> LTO = null;
		
		
		
			LTO = entityManager.createQuery("select to from Tripopinion to where to.rateag=:name  ", Tripopinion.class)
					.setParameter("name", s).getResultList();
		
		
		
		
		
		return LTO;
	}
	public List <Tripopinion> stat6(String s) {
		
		List<Tripopinion> LTO = null;
		
		
		
			LTO = entityManager.createQuery("select to from Tripopinion to where to.travelprog=:name  ", Tripopinion.class)
					.setParameter("name", s).getResultList();
		
		
		
		
		
		return LTO;
	}
}
