package tn.esprit.b3.esprit1718b3tourism.services;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.b3.esprit1718b3tourism.entities.Menu;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class Menu
 */
@Stateless
@LocalBean
public class MenuService extends GenericDAO <Menu> implements MenuServiceRemote, MenuServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public MenuService() {
        super(Menu.class);
    }
   public Menu findMenuByRestaurant(int id)
   {
	   return  entityManager.createQuery("select m from Menu m where m.restaurant.id="+id,Menu.class).getSingleResult();
	   
   }
}
