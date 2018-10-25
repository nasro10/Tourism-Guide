package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface PlatServiceLocal extends IGenericDAO<Plat> {
	 public List<Plat> bestDish(float IMC, int idMenu);
	 public float calculICM(float taille,float poids);
	 public List<Plat> findPlatByMenu(int id);
	 public List<Plat> bestDish1(float IMC, int idMenu);
	 public List<Plat> bestDish0(float IMC, int idMenu);
	 public List<Plat> bestDish2(float IMC, int idMenu);
	 public List<Plat> bestDish3(float IMC, int idMenu);
	 public List<Plat> recommandedDish(int idMenu);
	 public Plat findPlatByName(String name);
}
