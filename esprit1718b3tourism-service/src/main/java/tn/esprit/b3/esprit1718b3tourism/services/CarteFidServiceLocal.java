package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.CarteFid;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface CarteFidServiceLocal extends IGenericDAO<CarteFid>{
	 public CarteFid findCarteByIdUser(int id);

}
