package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.EventBooking;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class EventBookingService
 */
@Stateless
@LocalBean
public class EventBookingService extends GenericDAO<EventBooking> implements EventBookingServiceRemote, EventBookingServiceLocal {

    /**
     * Default constructor. 
     */
    public EventBookingService() {
        super(EventBooking.class);
    }

}
