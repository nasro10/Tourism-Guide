package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantRating;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class RestaurantRatingService
 */
@Stateless
@LocalBean
public class RestaurantRatingService extends GenericDAO<RestaurantRating> implements RestaurantRatingServiceRemote, RestaurantRatingServiceLocal {

    /**
     * Default constructor. 
     */
    public RestaurantRatingService() {
        super(RestaurantRating.class);
    }

}
