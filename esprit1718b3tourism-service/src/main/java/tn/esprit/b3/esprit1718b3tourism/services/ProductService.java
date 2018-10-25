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
 * Session Bean implementation class ProductService
 */
@Stateless
@LocalBean
public class ProductService extends GenericDAO <Product> implements ProductServiceRemote, ProductServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ProductService() {
        super(Product.class);
    }
    public List <Product> findProductByRecette(int id)
    {
 	   return entityManager.createQuery("select p from Product p where p.recette.id="+id,Product.class).getResultList();
 	   
    }
    public List <Product> findProductInStock()
    {
 	   return entityManager.createQuery("select p from Product p where p.quantityStock > 6",Product.class).getResultList();
 	   
    }
    public Product findProductByName(String name)
    {
 	   return entityManager.createQuery("select p from Product p where p.productName=?1",Product.class).setParameter(1,name).getSingleResult();
 	   
    }
    public List<Product> findProductByRecipeName(String name)
    {
    	  return entityManager.createQuery("select p from Product p where p.recette.nameRecette=?1",Product.class).setParameter(1,name).getResultList();
    }
    public  Product findProductByRecettes(int id)
    {
 	   return entityManager.createQuery("select p from Product p where p.recette.id="+id,Product.class).getSingleResult();
 	   
    }
}
