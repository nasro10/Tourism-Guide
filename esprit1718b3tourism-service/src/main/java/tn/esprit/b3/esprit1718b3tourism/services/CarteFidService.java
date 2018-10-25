package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.b3.esprit1718b3tourism.entities.CarteFid;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class CarteFidService
 */
@Stateless
@LocalBean
public class CarteFidService extends GenericDAO<CarteFid> implements CarteFidServiceRemote, CarteFidServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private CarteFidServiceLocal carteServiceLocal;
	private List<CarteFid> ls1=new ArrayList<CarteFid>();
    public CarteFidService() {
      super(CarteFid.class);
    }
    public CarteFid findCarteByIdUser(int id)
    {
    	return  entityManager.createQuery("select c from CarteFid c where c.user.id="+id,CarteFid.class).getSingleResult();
    }
    
    

}
