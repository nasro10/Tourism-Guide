package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.entities.Recette;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class RecetteService
 */
@Stateless
@LocalBean
public class RecetteService extends GenericDAO <Recette> implements RecetteServiceRemote, RecetteServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RecetteService() {
        super(Recette.class);
    }
    //retourne la liste des produits qui constituent la recette
    public List<Product> findAllProduct(int idRecette) {
		return  entityManager.createQuery("select p from Product p where p.recette.id="+idRecette,Product.class).getResultList();
			
	}
    //retourne somme des calories dans une recette
    public int calculCaloriesRecette(int idRecette,List <Product> ls)
    {
    	int cal=0;
    	int s=0;
     
    	ls=findAllProduct(idRecette);
    	for(int i=0;i<ls.size();i++)
    	{
    		cal=ls.get(i).getCalories();//clories/100g
    		s=s+cal*ls.get(i).getQuantityCalories();//somme calories du produit constituant la recette
    		
    	}
    	return s;
    }
    
    public Recette findRecetteByPlat(int id)
    {
 	   return  entityManager.createQuery("select r from Recette r where r.plat.id="+id,Recette.class).getSingleResult();
 	   
    }
    public List <String> findRecetteByName()
    {
 	   return entityManager.createQuery("select r.nameRecette from Recette r",String.class).getResultList();
 	   
    }
}
