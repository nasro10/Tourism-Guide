package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.TripRating;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface TripRatingServiceRemote extends IGenericDAO<TripRating> {

}
