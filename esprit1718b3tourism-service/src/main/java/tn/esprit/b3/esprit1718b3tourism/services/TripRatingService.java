package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.TripRating;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class TripRatingService
 */
@Stateless
@LocalBean
public class TripRatingService extends GenericDAO<TripRating> implements TripRatingServiceRemote, TripRatingServiceLocal {

    /**
     * Default constructor. 
     */
    public TripRatingService() {
        super(TripRating.class);
    }

}
