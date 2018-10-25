package tn.esprit.b3.esprit1718b3tourism.services;

import java.sql.Blob;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Restaurant;
import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class TableRService
 */
@Stateless
@LocalBean
public class TableRService extends GenericDAO <TableR> implements TableRServiceRemote, TableRServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public TableRService() {
       super(TableR.class);
    }
    
    public Blob findPictureById(Integer id)
    {
    	return  entityManager.createQuery("select t.picture from TableR t  where t.idTable="+id,Blob.class).getSingleResult();
    	
    }
    public List<TableR >findTableByRestaurant(int id)
    {
    	 return entityManager.createQuery("select t from TableR t where t.restaurantT.idRestaurant=?1",TableR.class).setParameter(1,id).getResultList();
    }
    public List<TableR> findTableByEtat()
    {
    	return  entityManager.createQuery("select t from TableR t  where t.available = 'true' ",TableR.class).getResultList();
    }
}
