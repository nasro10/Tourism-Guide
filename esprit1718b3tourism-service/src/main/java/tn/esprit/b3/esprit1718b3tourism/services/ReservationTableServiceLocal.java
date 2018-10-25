package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.ReservationTable;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface ReservationTableServiceLocal  extends IGenericDAO<ReservationTable>{

}
