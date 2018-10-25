package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Menu;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class Plat
 */
@Stateless
@LocalBean
public class PlatService extends GenericDAO <Plat> implements PlatServiceRemote, PlatServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public PlatService() {
        super(Plat.class);
    }
    
    public float calculICM(float taille,float poids)
    {
    	float imc= (poids / (taille*taille));
    	
		return imc;
    	
    }
    public List<Plat> bestDish(float IMC, int idMenu)
    {
		float taille=0;//entrer depuis textField
    	float poids=0;
    	IMC=calculICM(taille,poids);
    	if(IMC <18.5)
    	{
    		return  entityManager.createQuery("select p from Plat p where p.imc < 18.5 and p.menu.id="+idMenu,Plat.class).getResultList();
    	}
    	
    	else if((18.5<IMC) && (IMC< 24.9))
    		{
    		return  entityManager.createQuery("select p from Plat p where p.imc > 18.5 and p.imc < 24.9 and p.menu.id="+idMenu,Plat.class).getResultList();

    		}
    	
    	else	if((24.9<IMC) && (IMC<29.9))
        	{
    		
        	return  entityManager.createQuery("select p from Plat p where p.imc > 24.9 and p.imc < 29.9 and p.menu.id="+idMenu,Plat.class).getResultList();

        	}
        
    		else
    		{
    		return  entityManager.createQuery("select p from Plat p where p.imc > 29.9 and p.menu.id="+idMenu,Plat.class).getResultList();
    		
    		}
	
    }
    
    public List<Plat> findPlatByMenu(int id)
    {
    	 return  entityManager.createQuery("select p from Plat p where p.menu.id="+id,Plat.class).getResultList();
    }
    public List<Plat> bestDish0(float IMC, int idMenu)
    {
    	return  entityManager.createQuery("select p from Plat p where p.imc <18.5 and p.menu.id="+idMenu,Plat.class).getResultList();
    }
    
    public List<Plat> bestDish1(float IMC, int idMenu)
    {
    	return  entityManager.createQuery("select p from Plat p where p.imc > 18.5 and p.imc < 24.9 and p.menu.id="+idMenu,Plat.class).getResultList();
    }
    
    public List<Plat> bestDish2(float IMC, int idMenu)
    {
    	return  entityManager.createQuery("select p from Plat p where p.imc > 24.9 and p.imc < 29.9 and p.menu.id="+idMenu,Plat.class).getResultList();
    }
    
    public List<Plat> bestDish3(float IMC, int idMenu)
    {
    	return  entityManager.createQuery("select p from Plat p where p.imc > 29.9  and p.menu.id="+idMenu,Plat.class).getResultList();
    }
    public List<Plat> recommandedDish(int idMenu)
    {
    	return  entityManager.createQuery("select p from Plat p where p.recommanded >30 and p.menu.id="+idMenu,Plat.class).getResultList();
    }
    public Plat findPlatByName(String name)
    {
 	   return entityManager.createQuery("select p from Plat p where p.platName=?1",Plat.class).setParameter(1,name).getSingleResult();
 	   
    }
}
