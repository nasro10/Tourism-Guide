package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface ProductServiceLocal extends IGenericDAO<Product> {
	 public List <Product> findProductByRecette(int id);
	 public List <Product> findProductInStock();
	 public Product findProductByName(String name);
	  public List<Product> findProductByRecipeName(String name);
	  public  Product findProductByRecettes(int id);
}
