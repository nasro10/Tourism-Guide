package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.HotelBooking;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;


/**
 * Session Bean implementation class HotelBookingService
 */
@Stateless
@LocalBean
public class HotelBookingService extends GenericDAO<HotelBooking> implements HotelBookingServiceRemote, HotelBookingServiceLocal {

    /**
     * Default constructor. 
     */
    public HotelBookingService() {
        super(HotelBooking.class);
    }

}
