package tn.esprit.b3.esprit1718b3tourism.services;

import java.text.ParseException;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.PromotionDish;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface PromotionDishServiceRemote  extends IGenericDAO<PromotionDish>{
	public void refresh() throws ParseException;
}
