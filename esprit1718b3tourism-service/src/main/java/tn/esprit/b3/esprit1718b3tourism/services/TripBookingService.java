package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class TripBookingService
 */
@Stateless
@LocalBean
public class TripBookingService extends GenericDAO<TripBooking> implements TripBookingServiceRemote, TripBookingServiceLocal {

    /**
     * Default constructor. 
     */
    public TripBookingService() {
        super(TripBooking.class);
    }

}
