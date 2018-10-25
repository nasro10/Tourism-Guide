package tn.esprit.b3.esprit1718b3tourism.services;

import java.text.ParseException;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.PromotionDish;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface PromotionDishServiceLocal extends IGenericDAO<PromotionDish>{
	public void refresh() throws ParseException;
}
