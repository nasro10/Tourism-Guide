package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Menu;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface MenuServiceLocal extends IGenericDAO<Menu> {
	 public Menu findMenuByRestaurant(int id);
}
