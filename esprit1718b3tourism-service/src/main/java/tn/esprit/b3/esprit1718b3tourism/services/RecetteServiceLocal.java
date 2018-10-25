package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.entities.Recette;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface RecetteServiceLocal extends IGenericDAO<Recette> {
	  public Recette findRecetteByPlat(int id);
	  List<Product> findAllProduct(int idRecette);
	  public int calculCaloriesRecette(int idRecette,List <Product> ls);
	  public List <String> findRecetteByName();
}
