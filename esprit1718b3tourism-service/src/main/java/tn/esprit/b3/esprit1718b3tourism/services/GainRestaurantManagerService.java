package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.GainRestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class GainRestaurantManagerService
 */
@Stateless
@LocalBean
public class GainRestaurantManagerService extends GenericDAO<GainRestaurantManager> implements GainRestaurantManagerServiceRemote, GainRestaurantManagerServiceLocal {

    /**
     * Default constructor. 
     */
    public GainRestaurantManagerService() {
        super(GainRestaurantManager.class);
    }

}
