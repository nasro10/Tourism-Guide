package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.entities.Restaurant;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class RestaurantService
 */
@Stateless
@LocalBean
public class RestaurantService extends GenericDAO <Restaurant> implements RestaurantServiceRemote, RestaurantServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RestaurantService() {
       super(Restaurant.class);
    }
    public Restaurant findRestaurantByManager(int id)
    {
    	return  entityManager.createQuery("select r from Restaurant r  where r.restaurantManager.id="+id,Restaurant.class).getSingleResult();
  
    }
    public Restaurant findRestaurantByName(String name)
    {
 	   return entityManager.createQuery("select r from Restaurant r where r.name=?1",Restaurant.class).setParameter(1,name).getSingleResult();
 	   
    }
    public Restaurant findRestaurantByServer(int id)
    {
    	return  entityManager.createQuery("select r from Restaurant r  where r.server.id="+id,Restaurant.class).getSingleResult();
  
    }
    public List<Integer> findIdUser()
    {
    	return  entityManager.createQuery("select r.restaurantManager.id from Restaurant r  ",Integer.class).getResultList();
  
    }
    public List<String> findRestaurantName()
    {
    	return  entityManager.createQuery("select r.name from Restaurant r  ",String.class).getResultList();
  
    }
}
