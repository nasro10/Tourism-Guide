package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import tn.esprit.b3.esprit1718b3tourism.entities.Countries;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class CountriesService
 */
@Stateless
@LocalBean
public class CountriesService extends GenericDAO<Countries> implements CountriesServiceRemote, CountriesServiceLocal {

    /**
     * Default constructor. 
     */
    public CountriesService() {
    	super(Countries.class);
    	}


}
