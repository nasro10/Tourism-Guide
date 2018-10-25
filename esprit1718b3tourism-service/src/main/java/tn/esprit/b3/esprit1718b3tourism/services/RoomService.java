package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Room;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class RoomService
 */
@Stateless
@LocalBean
public class RoomService extends GenericDAO<Room> implements RoomServiceRemote, RoomServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RoomService() {
      super(Room.class);
    }
    public Room findRoomByManager(int id)
    {
    	return  entityManager.createQuery("select r from Room r  where r.hotelmanager_id="+id,Room.class).getSingleResult();
  
    }
    public  List<Room>FindById(HotelManager hotelManager){
    	String jpql="Select r from Room r where r.hotelManager=:hotelManager ";
    	
    	//return em.createQuery(jpql).getResultList();
    	Query query=entityManager.createQuery(jpql);
    	query.setParameter("hotelManager", hotelManager);
    	return query.getResultList();
    }


    public  List<Room>FindByEtat(Boolean available){
    	String jpql="Select r from Room r where r.available=:available ";
    	
    	//return em.createQuery(jpql).getResultList();
    	Query query=entityManager.createQuery(jpql);
    	query.setParameter("available", available);
    	return query.getResultList();
    }


}
