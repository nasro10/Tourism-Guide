package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Restaurant;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface RestaurantServiceRemote extends IGenericDAO<Restaurant>{
	
	 public Restaurant findRestaurantByManager(int id);
	 public Restaurant findRestaurantByName(String name);
	 public Restaurant findRestaurantByServer(int id);
	 public List<Integer> findIdUser();
	 public List<String> findRestaurantName();
}
