package tn.esprit.b3.esprit1718b3tourism.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Remote
public interface CommandedDishServiceRemote extends IGenericDAO<CommandedDish>{
	 public List<CommandedDish> findCommandedDishById(int id);
	 public List<CommandedDish> findCommandedDishByDate1(String date1) throws ParseException ;
	 public float calculFacture();
	 

}
