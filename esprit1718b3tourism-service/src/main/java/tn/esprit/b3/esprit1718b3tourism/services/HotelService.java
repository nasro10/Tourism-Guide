package tn.esprit.b3.esprit1718b3tourism.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.LocalBean;
import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

@Stateless
@LocalBean
public class HotelService extends GenericDAO<Hotel> implements HotelServiceLocal,HotelServiceRemote {
	@PersistenceContext
	private EntityManager entityManager;

	public HotelService() {
		super(Hotel.class);
	}
	@Override
	public List <Hotel> hcr(String cn , int ci) {
		
		List<Hotel> LH = null;
		
		
		try {
			LH = entityManager.createQuery("select ho from Hotel ho where ho.roomNbr>=:nb AND ho.country=:co ", Hotel.class)
					.setParameter("nb", ci).setParameter("co", cn).getResultList();
		} catch (Exception e) {
		}
		
		
		
		
		return LH;
	}
	
	 public  List<Hotel>FindByEtat(Boolean etat){
	    	String jpql="Select h from Hotel h where h.etat=:etat ";
	    	
	    	//return em.createQuery(jpql).getResultList();
	    	Query query=entityManager.createQuery(jpql);
	    	query.setParameter("etat", etat);
	    	return query.getResultList();
	    }
	 public  List<Hotel>FindById(HotelManager hotelManager_id){
		 String jpql="Select h from Hotel h where h.hotelManager_id=:hotelManager_id ";
	    	
	    	//return em.createQuery(jpql).getResultList();
	    	Query query=entityManager.createQuery(jpql);
	    	query.setParameter("hotelManage_idr", hotelManager_id);
	    	return query.getResultList();
	    }
	

}
