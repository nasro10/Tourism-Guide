package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.CommenterPlat;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface CommenterPlatSeviceRemote  extends IGenericDAO<CommenterPlat>{
	 public List<String> findCommantaireByIdPlat(int id);

}
