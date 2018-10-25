package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface TripBookingServiceLocal extends IGenericDAO<TripBooking> {

}
