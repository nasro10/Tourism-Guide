package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Menu;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface MenuServiceRemote extends IGenericDAO<Menu>{
	 public Menu findMenuByRestaurant(int id);
}
