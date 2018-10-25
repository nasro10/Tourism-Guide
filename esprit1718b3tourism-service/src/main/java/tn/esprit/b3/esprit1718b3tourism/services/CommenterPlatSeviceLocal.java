package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.CommenterPlat;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface CommenterPlatSeviceLocal extends IGenericDAO<CommenterPlat>{
	 public List<String> findCommantaireByIdPlat(int id);

}
