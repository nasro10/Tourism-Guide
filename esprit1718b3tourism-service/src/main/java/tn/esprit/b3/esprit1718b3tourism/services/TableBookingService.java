package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.TableBooking;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class TableBookingService
 */
@Stateless
@LocalBean
public class TableBookingService extends GenericDAO<TableBooking> implements TableBookingServiceRemote, TableBookingServiceLocal {

    /**
     * Default constructor. 
     */
    public TableBookingService() {
        super(TableBooking.class);
    }

}
