package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class HotelManagerService
 */
@Stateless
@LocalBean
public class HotelManagerService extends GenericDAO<HotelManager> implements HotelManagerServiceRemote, HotelManagerServiceLocal {

    /**
     * Default constructor. 
     */
    public HotelManagerService() {
    	super(HotelManager.class);
    }

}
