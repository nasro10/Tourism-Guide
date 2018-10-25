package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.AirlineCompany;

import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class AirlineCompanyService
 */
@Stateless
@LocalBean
public class AirlineCompanyService extends GenericDAO<AirlineCompany> implements AirlineCompanyServiceLocal , AirlineCompanyServiceRemote {
	@PersistenceContext
	private EntityManager entityManager;
	public AirlineCompanyService() {
		super(AirlineCompany.class);
	}
}
