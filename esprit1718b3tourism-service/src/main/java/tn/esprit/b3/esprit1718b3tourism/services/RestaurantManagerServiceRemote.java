package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface RestaurantManagerServiceRemote extends IGenericDAO<RestaurantManager>{

}
