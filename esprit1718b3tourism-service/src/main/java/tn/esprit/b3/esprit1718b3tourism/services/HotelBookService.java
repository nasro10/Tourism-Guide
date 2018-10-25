package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.HotelBook;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class HotelBookService
 */
@Stateless
@LocalBean
public class HotelBookService extends GenericDAO<HotelBook> implements HotelBookServiceRemote, HotelBookServiceLocal {

    /**
     * Default constructor. 
     */
    public HotelBookService() {
        super(HotelBook.class);
    }

}
