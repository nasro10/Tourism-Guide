package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.ReservationTable;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class ReservationTableBean
 */
@Stateless
@LocalBean
public class ReservationTableService extends GenericDAO <ReservationTable> implements ReservationTableServiceRemote, ReservationTableServiceLocal {

    /**
     * Default constructor. 
     */
    public ReservationTableService() {
        super(ReservationTable.class);
    }

}
