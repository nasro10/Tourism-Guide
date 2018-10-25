package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Admin;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface AdminServiceLocal extends IGenericDAO<Admin>{

}
