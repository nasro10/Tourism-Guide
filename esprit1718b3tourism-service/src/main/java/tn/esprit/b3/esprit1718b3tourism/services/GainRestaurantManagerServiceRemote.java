package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.GainRestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface GainRestaurantManagerServiceRemote  extends IGenericDAO<GainRestaurantManager>{

}
