package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.Promotion;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class PromotionService
 */
@Stateless
@LocalBean
public class PromotionService extends GenericDAO<Promotion> implements PromotionServiceRemote, PromotionServiceLocal {

    /**
     * Default constructor. 
     */
    public PromotionService() {
        // TODO Auto-generated constructor stub
    	super(Promotion.class);
    }
    

}
