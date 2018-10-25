package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface ProductServiceRemote extends IGenericDAO<Product>{
	 public List <Product> findProductByRecette(int id);
	 public List <Product> findProductInStock();
	 public Product findProductByName(String name);
	  public List<Product> findProductByRecipeName(String name);
	  public  Product findProductByRecettes(int id);
}
