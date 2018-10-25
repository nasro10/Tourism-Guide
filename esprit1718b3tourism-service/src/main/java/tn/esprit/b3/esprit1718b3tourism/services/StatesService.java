package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Countries;
import tn.esprit.b3.esprit1718b3tourism.entities.States;

import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class StatesService
 */

@Stateless
@LocalBean
public class StatesService extends GenericDAO<States> implements StatesServiceRemote , StatesSeviceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	public StatesService() {
		super(States.class);
	}
	@Override
	public List <States> mapcs(String cn , int ci) {
		Countries c = null;
		List<States> LS = null;
		
		
		try {
			c = entityManager.createQuery("select co from Countries co where co.name=:name ", Countries.class)
					.setParameter("name", cn).getSingleResult();
		} catch (Exception e) {
		}
		try {
			LS = entityManager.createQuery("select st from States st where st.country_id=:sci ", States.class)
					.setParameter("sci", c.getId()).getResultList();
		} catch (Exception e) {
		}
		
		
		
		return LS;
	}
    

}
