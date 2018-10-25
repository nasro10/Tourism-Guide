package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class RestaurantManagerService
 */
@Stateless
@LocalBean
public class RestaurantManagerService  extends GenericDAO <RestaurantManager> implements RestaurantManagerServiceRemote, RestaurantManagerServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RestaurantManagerService() {
        super(RestaurantManager.class);
    }

}
