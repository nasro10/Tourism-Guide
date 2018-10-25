package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.EventRating;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class EventRatingService
 */
@Stateless
@LocalBean
public class EventRatingService extends GenericDAO<EventRating> implements EventRatingServiceRemote, EventRatingServiceLocal {

    /**
     * Default constructor. 
     */
    public EventRatingService() {
    super(EventRating.class);
    }

}
