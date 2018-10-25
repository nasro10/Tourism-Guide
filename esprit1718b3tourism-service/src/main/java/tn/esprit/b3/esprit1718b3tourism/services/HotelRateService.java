package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.HotelRating;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class HotelRateService
 */
@Stateless
@LocalBean
public class HotelRateService extends GenericDAO<HotelRating> implements HotelRateServiceRemote, HotelRateServiceLocal {

    /**
     * Default constructor. 
     */
    public HotelRateService() {
        super(HotelRating.class);
    }

}
