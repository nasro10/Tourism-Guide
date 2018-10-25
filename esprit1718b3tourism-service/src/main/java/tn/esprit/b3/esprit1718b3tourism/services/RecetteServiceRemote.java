package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.entities.Recette;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface RecetteServiceRemote extends IGenericDAO<Recette>{
	  public Recette findRecetteByPlat(int id);
	  List<Product> findAllProduct(int idRecette);
	  public int calculCaloriesRecette(int idRecette,List <Product> ls);
	  public List <String> findRecetteByName();
}
