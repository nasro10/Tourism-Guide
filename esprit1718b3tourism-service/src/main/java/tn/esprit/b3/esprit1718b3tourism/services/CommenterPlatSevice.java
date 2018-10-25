package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.CommenterPlat;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class CommenterPlatSevice
 */
@Stateless
@LocalBean
public class CommenterPlatSevice extends GenericDAO<CommenterPlat> implements CommenterPlatSeviceRemote, CommenterPlatSeviceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager entityManager;

    public CommenterPlatSevice() {
        super(CommenterPlat.class);
    }
    public List<String> findCommantaireByIdPlat(int id)
    {
    	return  entityManager.createQuery("select c.commentaire from CommenterPlat c where c.plat.id="+id,String.class).getResultList();
    }
    

}
