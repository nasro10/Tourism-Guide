package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Restaurant;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface RestaurantServiceLocal extends IGenericDAO<Restaurant> {
	 public Restaurant findRestaurantByManager(int id);
	 public Restaurant findRestaurantByName(String name);
	 public Restaurant findRestaurantByServer(int id);
	  public List<Integer> findIdUser();
	  public List<String> findRestaurantName();
	 
}
